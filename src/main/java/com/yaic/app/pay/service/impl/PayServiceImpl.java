package com.yaic.app.pay.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.yaic.app.Constants;
import com.yaic.app.enums.PayWayEnum;
import com.yaic.app.order.dto.custom.PayInfoDto;
import com.yaic.app.order.dto.domain.OrderCustomerDto;
import com.yaic.app.order.dto.domain.OrderMainDto;
import com.yaic.app.order.dto.domain.OrderPayinfoDto;
import com.yaic.app.order.dto.domain.ShopOrderGoodsDto;
import com.yaic.app.order.dto.domain.ShopOrderInfoDto;
import com.yaic.app.order.dto.domain.ShopOrderPayinfoDto;
import com.yaic.app.order.dto.msg.CallBackThirdPayReq;
import com.yaic.app.order.dto.msg.CallBackThirdPayResp;
import com.yaic.app.order.dto.msg.DealOrderAfterPayReq;
import com.yaic.app.order.dto.msg.DealOrderAfterPayResp;
import com.yaic.app.order.dto.msg.GetWxSignReq;
import com.yaic.app.order.dto.msg.GetWxSignResp;
import com.yaic.app.order.dto.msg.InitOrderPayReq;
import com.yaic.app.order.dto.msg.InitOrderPayResp;
import com.yaic.app.order.dto.msg.common.OrderDto;
import com.yaic.app.order.dto.msg.common.RequestMessage;
import com.yaic.app.order.dto.msg.common.ResponseMessage;
import com.yaic.app.order.dto.msg.common.ShopOrderDto;
import com.yaic.app.order.service.OrderCustomerService;
import com.yaic.app.order.service.OrderMainService;
import com.yaic.app.order.service.OrderPayinfoService;
import com.yaic.app.order.service.OrderService;
import com.yaic.app.order.service.OrderSolutionProdService;
import com.yaic.app.order.service.ShopOrderGoodsService;
import com.yaic.app.order.service.ShopOrderInfoService;
import com.yaic.app.order.service.ShopOrderPayinfoService;
import com.yaic.app.order.utils.ClientUtils;
import com.yaic.app.pay.service.PayService;
import com.yaic.app.pay.utils.BankCodeMap;
import com.yaic.app.pdms.dto.custom.PdmsSolutionInfoDto;
import com.yaic.app.pdms.dto.msg.GetPdmsSolutionReq;
import com.yaic.app.pdms.dto.msg.common.PdmsRequestMessage;
import com.yaic.app.pdms.dto.msg.common.PdmsResponseMessage;
import com.yaic.app.syn.dto.domain.SynEpolicyDto;
import com.yaic.app.syn.dto.domain.SynPolicyDtlDto;
import com.yaic.app.syn.dto.domain.SynPolicyDto;
import com.yaic.app.syn.service.SynEpolicyService;
import com.yaic.app.syn.service.SynPolicyDtlService;
import com.yaic.app.syn.service.SynPolicyService;
import com.yaic.fa.mybatis.mapper.entity.Condition;
import com.yaic.fa.redis.core.RedisTemplate;
import com.yaic.servicelayer.charset.StandardCharset;
import com.yaic.servicelayer.util.CollectionUtil;
import com.yaic.servicelayer.util.ConfigUtil;
import com.yaic.servicelayer.util.StringUtil;
import com.yaic.servicelayer.util.TimeUtil;

@Service("payService")
public class PayServiceImpl implements PayService {

    private static final Logger logger = LoggerFactory.getLogger(PayServiceImpl.class);
    
    private static final Logger synPolicyLogger = LoggerFactory.getLogger("synPolicyLogger");
    
    private static final String SUCCESS_CODE = "0000"; // 处理成功
    private static final String FAIL_CODE = "9999"; // 处理失败
    private static final String SUCCESS_STATE = "1"; // 成功状态
    private static final String FAIL_STATE = "0"; // 失败状态
    private static final String SUCCESS_MSG = "success";
    private static final String CREATE_USER = "SYSTEM"; // 创建人
    private static final String UPDATED_USER = "SYSTEM"; // 更新人
    private static final String FORMAT = "yyyyMMddHHmmss";
    private static final String PAY_SUCCESS_CODE = "2"; // 支付成功
    private static final String PAY_ERROR_CODE = "9,error"; // 接口异常
    private static final String PAY_CODE = "0,1,8"; // 0:未支付,1:支付失败,8:订单不存在
    private static final String ORDER_FINISH_STATUS = "2"; // 订单已完成状态
    private static final String ODST_PREFIX = "ODST_"; // 订单支付状态前缀

    @Autowired
    private ShopOrderPayinfoService shopOrderPayinfoService;
    @Autowired
    private ShopOrderGoodsService shopOrderGoodsService;
    @Autowired
    private OrderPayinfoService orderPayinfoService;
    @Autowired
    private ShopOrderInfoService shopOrderInfoService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderMainService orderMainService;
    @Autowired
    private OrderCustomerService orderCustomerService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private OrderSolutionProdService orderSolutionProdService;
    @Autowired
    private SynPolicyService synPolicyService;
    @Autowired
    private SynPolicyDtlService synPolicyDtlService;
    @Autowired
    private SynEpolicyService synEpolicyService;

    /**
     * 5.2.16 第三方支付回调
     * 
     * @Author: lujicong
     * @Date: 2015-12-24
     * @Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    @Override
    public ResponseMessage callBackThirdPay(RequestMessage requestMessageObj) throws Exception {

        /**
         * 处理过程：
         * 1]更新订单总支付状态;
         * 判断是否已经处理:
         *     否: 
         *         更新订单详情信息,
         *         写入保单同步信息表【t_syn_policy】
         *         写入电子保单同步信息表【t_syn_epolicy】
         *         更新订单主表信息
         *         更新订单支付信息
         *         写入保单同步明细信息表【t_syn_policy_dtl】
         *         获取订单详情信息返回
         *     是：
         *         获取订单详情信息返回
         */
        
        ResponseMessage responseMessage = new ResponseMessage();
        CallBackThirdPayReq callBackThirdPayReq = requestMessageObj.getData().getCallBackThirdPayReq();

        String orderTmpCode = callBackThirdPayReq.getOrderCode();

        String payeeName = callBackThirdPayReq.getPayeeName();
        String bankName = callBackThirdPayReq.getBankName();
        String bankAccount = callBackThirdPayReq.getBankAccount();
        String policyNo = null;
        // 传入信息校验
        StringBuffer checkMsg = new StringBuffer();
        if (StringUtil.isEmpty(orderTmpCode)) {
            checkMsg.append("订单号不能为空,");
        }
        if (StringUtil.isNotEmpty(checkMsg.toString())) {
            responseMessage.setMessage(checkMsg.substring(0, checkMsg.length() - 1));
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }

        BigInteger orderCode = new BigInteger(orderTmpCode);

        // 更新订单总支付状态
        ShopOrderPayinfoDto shopOrderPayinfoDto = new ShopOrderPayinfoDto();
        shopOrderPayinfoDto.setPayStatus("1"); // 0-未支付，1-支付成功，2-支付失败
        shopOrderPayinfoDto.setPayeeName(payeeName);
        shopOrderPayinfoDto.setBankName(bankName);
        shopOrderPayinfoDto.setBankAccount(bankAccount);
        shopOrderPayinfoDto.setUpdatedUser(UPDATED_USER);
        shopOrderPayinfoDto.setUpdatedDate(new Date());
        Condition shopPayInfoCond = new Condition(ShopOrderPayinfoDto.class);
        //jhc--start
        List<Object> payStatusValue = new ArrayList<Object>();
        payStatusValue.add(1);
        shopPayInfoCond.createCriteria().andEqualTo("orderCode", orderCode).andNotIn("payStatus", payStatusValue); 
        //jhc--end
        int count = shopOrderPayinfoService.updateByConditionNotNull(shopOrderPayinfoDto, shopPayInfoCond);
        boolean isDeal = false;
        if (count == 0) {
            isDeal = true;
        }

        if (!isDeal) {
            
            synPolicyLogger.warn("【写入保单同步任务信息】回调处理,订单号:{}", orderCode);
            
            // 更新订单详情信息
            ShopOrderInfoDto shopOrderInfoDto = new ShopOrderInfoDto();
            shopOrderInfoDto.setOrderCode(orderCode);
            shopOrderInfoDto.setOrderStatus("2");
            shopOrderInfoDto.setUpdatedUser(UPDATED_USER);
            shopOrderInfoDto.setUpdatedDate(new Date());
            shopOrderInfoService.updateByPrimaryKeyNotNull(shopOrderInfoDto);

            // 订单商品关联信息列表
            ShopOrderGoodsDto queryOrderGoodsDto = new ShopOrderGoodsDto();
            queryOrderGoodsDto.setOrderCode(orderCode);
            queryOrderGoodsDto.setInvalidFlag(0);
            List<ShopOrderGoodsDto> shopOrderGoodsList = shopOrderGoodsService.select(queryOrderGoodsDto);

            // 订单明细列表
            boolean testIssueFlag = false;
            List<SynPolicyDtlDto> synPolicyDtlList = null;
            if (CollectionUtil.isNotEmpty(shopOrderGoodsList)) {
                SynPolicyDtlDto synPolicyDtlDto = null;
                synPolicyDtlList = new ArrayList<SynPolicyDtlDto>();
                for (ShopOrderGoodsDto shopOrderGoodsDto : shopOrderGoodsList) {

                    OrderMainDto orderMainDto = new OrderMainDto();
                    orderMainDto.setOrderCode(orderCode);
                    orderMainDto.setOrderMainId(shopOrderGoodsDto.getGoodsNo());
                    orderMainDto = orderMainService.selectOne(orderMainDto);
                    String underwriterInd = orderMainDto.getUnderwriterInd();
                    
                    if (StringUtil.isEmpty(orderMainDto.getPolicyNo())) {
                        // 生成保单号
                        orderMainDto.setPolicyNo(orderService.createPolicyNo("8G", orderMainDto.getChannelTip().substring(1, 4),
                                shopOrderGoodsDto.getGoodsId()));
                        policyNo = orderMainDto.getPolicyNo();
                        logger.info("生成保单号:{}", policyNo);
                    }

                    // 判断是否测试单
                    if(!testIssueFlag && StringUtil.isNotEmpty(orderMainDto.getTestIssueFlag()) && "Y".equals(orderMainDto.getTestIssueFlag())){
                    	testIssueFlag = true;
                    }
                    
                    // 更新订单主表信息
                    orderMainDto.setOrderMainId(shopOrderGoodsDto.getGoodsNo());
                    orderMainDto.setStatus("3"); // 3-转保单成功
                    /*add by zhaobaoyang 2018/08/20 for BJYY-409 乐荐-惠保E生个人医疗保险  人工审核同步转投保已完成，避免重复转投保begin*/
                    if (StringUtil.notContains("1,3", underwriterInd)) {//1-审核通过，3-自动核保通过
                    	orderMainDto.setUnderwriterInd("6"); // 6-承保确认
                    }
                    /*add by zhaobaoyang 2018/08/20 for BJYY-409 乐荐-惠保E生个人医疗保险  人工审核同步转投保已完成，避免重复转投保end*/
                    orderMainDto.setUpdatedUser(UPDATED_USER);
                    orderMainDto.setUpdatedDate(new Date());
                    orderMainDto.setOrderCode(null);
                    Condition orderMainCond = new Condition(OrderMainDto.class);
                    orderMainCond.createCriteria().andEqualTo("orderCode", orderCode).andEqualTo("orderMainId", shopOrderGoodsDto.getGoodsNo());
                    orderMainService.updateByConditionNotNull(orderMainDto, orderMainCond);

                    // 更新订单支付信息
                    OrderPayinfoDto orderPayinfoDto = new OrderPayinfoDto();
                    orderPayinfoDto.setPayStatus("1");
                    orderPayinfoDto.setPayDate(new Date());
                    orderPayinfoDto.setUpdatedUser(UPDATED_USER);
                    orderPayinfoDto.setUpdatedDate(new Date());
                    Condition orderPayCond = new Condition(OrderPayinfoDto.class);
                    orderPayCond.createCriteria().andEqualTo("orderCode", orderCode).andEqualTo("orderMainId", shopOrderGoodsDto.getGoodsNo());
                    orderPayinfoService.updateByConditionNotNull(orderPayinfoDto, orderPayCond);

                    synPolicyDtlDto = new SynPolicyDtlDto();
                    synPolicyDtlDto.setOrderMainId(shopOrderGoodsDto.getGoodsNo());
                    synPolicyDtlDto.setPolicyNo(orderMainDto.getPolicyNo());
                    synPolicyDtlDto.setAgrtCode(orderMainDto.getAgrtCode());
                    synPolicyDtlList.add(synPolicyDtlDto);
                }
            }
            
            // 测试单内容不插入任务表中
            if (!testIssueFlag) {
	            synPolicyLogger.warn("【写入保单同步任务信息】开始,订单号:{}", orderCode);
	            // 任务表放到一起写入减低取数问题的可能性
	            if(CollectionUtil.isNotEmpty(synPolicyDtlList)) {
	                for(SynPolicyDtlDto synPolicyDtlDto : synPolicyDtlList) {
	                    try {
	                        // 写入保单同步明细信息表【t_syn_policy_dtl】
	                        synPolicyDtlDto.setOrderCode(orderCode);
	                        synPolicyDtlDto.setDealStatus("0"); // 0-初始状态
	                        synPolicyDtlDto.setInvalidFlag(0);
	                        synPolicyDtlDto.setCreatedUser(CREATE_USER);
	                        synPolicyDtlDto.setCreatedDate(new Date());
	                        synPolicyDtlDto.setUpdatedUser(UPDATED_USER);
	                        synPolicyDtlDto.setUpdatedDate(synPolicyDtlDto.getCreatedDate());
	                        synPolicyDtlService.insertNotNull(synPolicyDtlDto);
	                    } catch (Exception e) {
	                        logger.error("写入保单同步明细信息表【t_syn_policy_dtl】异常,订单主表id:{},订单号:{},错误信息:{}", synPolicyDtlDto.getOrderMainId(), orderCode, e);
	                        synPolicyLogger.error("写入保单同步明细信息表【t_syn_policy_dtl】异常,订单主表id:{},订单号:{},错误信息:{}", synPolicyDtlDto.getOrderMainId(), orderCode, e);
	                    }
	                }
	            }
	            
	            // 写入保单同步信息表【t_syn_policy】
	            try {
	                SynPolicyDto synPolicyDto = new SynPolicyDto();
	                synPolicyDto.setOrderCode(orderCode);
	                synPolicyDto.setDetailCount(shopOrderGoodsList.size());
	                synPolicyDto.setDealStatus("0"); // 未处理
	                synPolicyDto.setInvalidFlag(0);
	                synPolicyDto.setCreatedUser(CREATE_USER);
	                synPolicyDto.setCreatedDate(new Date());
	                synPolicyDto.setUpdatedUser(UPDATED_USER);
	                synPolicyDto.setUpdatedDate(synPolicyDto.getCreatedDate());
	                synPolicyService.insertNotNull(synPolicyDto);
	                
	            } catch (Exception e) {
	                logger.error("写入保单同步信息表【t_syn_policy】异常,订单号:{},错误信息:{}", orderCode, e);
	                synPolicyLogger.error("写入保单同步信息表【t_syn_policy】异常,订单号:{},错误信息:{}", orderCode, e);
	            }
	            synPolicyLogger.warn("【写入保单同步任务信息】结束,订单号:{}", orderCode);
            }
            
            // 写入电子保单同步信息表【t_syn_epolicy】
            try {
            	SynEpolicyDto synEpolicyDto = new SynEpolicyDto();
                synEpolicyDto.setOrderCode(orderCode);
                synEpolicyDto.setDealStatus("0"); // 未处理
                synEpolicyDto.setInvalidFlag(0);
                synEpolicyDto.setCreatedUser(CREATE_USER);
                synEpolicyDto.setCreatedDate(new Date());
                synEpolicyDto.setUpdatedUser(UPDATED_USER);
                synEpolicyDto.setUpdatedDate(synEpolicyDto.getCreatedDate());
                synEpolicyService.insertNotNull(synEpolicyDto);
            } catch (Exception e) {
            	logger.error("写入电子保单同步信息表【t_syn_epolicy】异常,订单号:{},错误信息:{}", orderCode, e);
            	synPolicyLogger.error("写入电子保单同步信息表【t_syn_epolicy】异常,订单号:{},错误信息:{}", orderCode, e);
            }
            synPolicyLogger.warn("【写入电子保单同步任务信息】结束,订单号:{}", orderCode);
            
        }
        // 获取订单详情信息
        ShopOrderDto shopOrderDto = orderService.getOrderDetailInfo(orderCode);
        CallBackThirdPayResp callBackThirdPayResp = new CallBackThirdPayResp();
        callBackThirdPayResp.setShopOrderInfo(shopOrderDto.getShopOrderInfo());
        callBackThirdPayResp.setShopOrderPayinfo(shopOrderDto.getShopOrderPayinfo());
        callBackThirdPayResp.setShopOrderShipping(shopOrderDto.getShopOrderShipping());
        callBackThirdPayResp.setOrderList(shopOrderDto.getOrderList());
        responseMessage.getData().setCallBackThirdPayResp(callBackThirdPayResp);

        responseMessage.setMessage(SUCCESS_MSG);
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);

        // 支付成功状态写入缓存、FTP 对账数据上传
        try {
        	logger.info("支付成功状态回调中台DYSUB写入缓存、FTP 对账数据上传,订单号:{},保单号:{}", orderCode, policyNo);
            redisTemplate.set(ODST_PREFIX + orderTmpCode, "1", Constants.EXPIRE_TIME); // 支付成功
            //orderService.addPolicyNoToRedis(shopOrderDto, orderTmpCode);
            orderService.orderCallbackDysubData(shopOrderDto, policyNo, Constants.DEAL_TYPE_INSURE);
        } catch (Exception e) {
            logger.error("ODST_[" + orderTmpCode + "]写入Redis缓存失败," + e);
        }

        return responseMessage;
    }

    /**
     * 5.2.17 发起订单支付
     * 
     * @Author: lujicong
     * @Date: 2015-12-24
     * @Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    @Override
    public ResponseMessage initOrderPay(RequestMessage requestMessageObj) throws Exception {
        ResponseMessage responseMessage = new ResponseMessage();
        InitOrderPayReq initOrderPayReq = requestMessageObj.getData().getInitOrderPayReq();

        String uid = requestMessageObj.getUserId();
        String orderTmpCode = initOrderPayReq.getOrderCode();
        String payWay = initOrderPayReq.getPayWay();
        String dataSource = initOrderPayReq.getDataSource();
        String tradeType = initOrderPayReq.getTradeType();
        String openId = initOrderPayReq.getOpenId();
        String spBillCreateIp = initOrderPayReq.getSpBillCreateIp();
        String clientType = initOrderPayReq.getClientType();
        String returnUrl = initOrderPayReq.getReturnUrl();
        
        String appCode = initOrderPayReq.getAppCode();
        String channelNo = initOrderPayReq.getChannelNo();
        String frontUrl = initOrderPayReq.getFrontUrl();
        String mobile = initOrderPayReq.getMobile();
        String model = initOrderPayReq.getModel();
        String actCode = initOrderPayReq.getActCode();
        String serialNo = initOrderPayReq.getSerialNo();
        String userName = initOrderPayReq.getUserName();
        String goodType = initOrderPayReq.getGoodType();
        
        String payeeName = initOrderPayReq.getPayeeName();
        String bankCode = initOrderPayReq.getBankCode();
        String bankName = initOrderPayReq.getBankName();
        String bankAccount = initOrderPayReq.getBankAccount();
        String docType = initOrderPayReq.getDocType();
        String docNo = initOrderPayReq.getDocNo();
        String phoneNo = initOrderPayReq.getPhoneNo();
		// Add by Qu Dihuai for RM-4599 start
		String unionPayUserId = initOrderPayReq.getUnionPayUserId();
		// Add by Qu Dihuai for RM-4599 end

        // 传入信息校验
        StringBuffer checkMsg = new StringBuffer();
        if (StringUtil.isEmpty(uid)) {
            checkMsg.append("用户ID不能为空,");
        }
        if (StringUtil.isEmpty(orderTmpCode)) {
            checkMsg.append("订单号不能为空,");
        }
        if (StringUtil.isEmpty(payWay)) {
            checkMsg.append("支付方式不能为空,");
        }
        if (StringUtil.isEmpty(dataSource)) {
            checkMsg.append("数据来源不能为空,");
        }
        if (StringUtil.isNotEmpty(checkMsg.toString())) {
            responseMessage.setMessage(checkMsg.substring(0, checkMsg.length() - 1));
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }

        BigInteger userId = new BigInteger(uid);
        BigInteger orderCode = new BigInteger(orderTmpCode);

        // 发起订单支付返回信息
        InitOrderPayResp initOrderPayResp = new InitOrderPayResp();

        // 查询订单详细信息
        ShopOrderDto shopOrderDto = orderService.getOrderDetailInfo(orderCode);

        ShopOrderInfoDto shopOrderInfoDto = shopOrderDto.getShopOrderInfo();

        if ("0".equals(shopOrderInfoDto.getOrderStatus())) {
            responseMessage.setMessage("该订单处于未确认状态,发起订单支付失败");
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        } else if ("4".equals(shopOrderInfoDto.getOrderStatus())) {
            responseMessage.setMessage("该订单处于取消状态,发起订单支付失败");
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }

        ShopOrderPayinfoDto shopOrderPayinfoDto = shopOrderDto.getShopOrderPayinfo();
        
        Integer payExpired = -1;
        String backIssueFlag = "";
		try {
			PdmsRequestMessage pdmsRequestMessage = new PdmsRequestMessage();
			GetPdmsSolutionReq getPdmsSolutionReq = new GetPdmsSolutionReq();
			getPdmsSolutionReq.setAgrtCode(shopOrderDto.getOrderList().get(0).getOrderMain().getAgrtCode());
			pdmsRequestMessage.getData().setGetPdmsSolutionReq(getPdmsSolutionReq);
			PdmsResponseMessage pdmsResponseMessage = orderSolutionProdService.getPdmsSolution(pdmsRequestMessage);
			PdmsSolutionInfoDto pdmsSolutionInfoDto = pdmsResponseMessage.getData().getGetPdmsSolutionResp().getPdmsSolutionInfoDto();
			payExpired = pdmsSolutionInfoDto.getSolutionMain().getPayExpired();
			backIssueFlag = pdmsSolutionInfoDto.getSolutionMain().getBackPolicyFlag();
		} catch (NullPointerException e) {
			logger.warn("获取订单协议信息报错,orderCode[" + orderCode + "],dataSource[" + dataSource + "]."); 
			throw new NullPointerException();
		}
        
		Date currDate = new Date();
		logger.info("校验支付时效开始,orderCode[" + orderCode + "],payExpired[" + payExpired + "].");
        if(payExpired != null && payExpired > 0) {
        	long orderAddTime = shopOrderDto.getShopOrderInfo().getAddTime().getTime();
        	if(currDate.getTime() - orderAddTime > payExpired*60*1000) {
        		logger.info("支付超时,orderCode[" + orderCode + "],payExpired[" + payExpired + "],currDate[" + currDate + "].");
                responseMessage.setMessage("该产品的支付时效为" + payExpired + "分钟,该单已超时.");
                responseMessage.setCode(FAIL_CODE);
                responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
                responseMessage.setState(FAIL_STATE);
                return responseMessage;
        	}
        }
        List<OrderDto> list = shopOrderDto.getOrderList();
        if (!"1".equals(backIssueFlag)) {
            for (OrderDto orderDto : list) {
            	if ((orderDto.getOrderMain().getStartDate().getTime()) - (currDate.getTime()) < 0) {
            		logger.info("已过起保日期,orderCode[" + orderCode + "],currDate[" + currDate + "].");
                    responseMessage.setMessage("已过起保日期的订单无法支付,请重新下单.");
                    responseMessage.setCode(FAIL_CODE);
                    responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
                    responseMessage.setState(FAIL_STATE);
                    return responseMessage;
            	}
            }
        }

        List<OrderDto> orderList = shopOrderDto.getOrderList();

        // 商品名称
        String goodsName = orderList.get(0).getOrderMain().getProductName();
        String testIssueFlag = orderList.get(0).getOrderMain().getTestIssueFlag();
		String projectCode = orderList.get(0).getOrderMain().getProjectCode(); // 组合产品取不到,先取其中一条
        /*if (orderList.size() > 1) {
            goodsName = orderList.get(0).getOrderMain().getProductName();
        } else {
            OrderMainDto orderMain = orderList.get(0).getOrderMain();
            goodsName = orderMain.getProductName();
        }*/

        String[] payQueryresult = null;
        if (StringUtil.isNotEmpty(shopOrderPayinfoDto.getPayNo())) {
            payQueryresult = this.orderPayQuery(shopOrderPayinfoDto.getPayWay(), shopOrderPayinfoDto.getPayNo(), orderTmpCode,
                    shopOrderPayinfoDto.getPayDate(), shopOrderPayinfoDto.getDataSource());
        } else {
            payQueryresult = new String[2];
            payQueryresult[0] = "Y";
            payQueryresult[1] = "{\"success\": \"0\"}";
        }

        if ("Y".equals(payQueryresult[0])) {
            PayInfoDto payInfoDto = JSON.parseObject(payQueryresult[1], PayInfoDto.class);
            String success = payInfoDto.getSuccess();
            if (PAY_CODE.indexOf(success) > -1) {
            	
            	//发起支付前先保存部分信息--by chuyang 2017-03-09 12:36:55
            	ShopOrderPayinfoDto orderPayinfoDto = new ShopOrderPayinfoDto();
                orderPayinfoDto.setUserId(userId);
                orderPayinfoDto.setOrderCode(orderCode);
            	orderPayinfoDto = shopOrderPayinfoService.selectOne(orderPayinfoDto);
            	orderPayinfoDto.setPayWay(payWay);
                orderPayinfoDto.setDataSource(dataSource);
                orderPayinfoDto.setPayeeName(payeeName);
                if (StringUtil.isNotEmpty(bankCode)) {
					orderPayinfoDto.setBankCode(BankCodeMap.trans(bankCode));
				}
                orderPayinfoDto.setBankName(bankName);
                orderPayinfoDto.setBankAccount(bankAccount);
                orderPayinfoDto.setDocType(docType);
                orderPayinfoDto.setDocNo(docNo);
                orderPayinfoDto.setPhoneNo(phoneNo);
                orderPayinfoDto.setUpdatedUser(uid);
                orderPayinfoDto.setUpdatedDate(new Date());
                orderPayinfoDto.setOrderCode(null);
                Condition cond = new Condition(ShopOrderPayinfoDto.class);
                cond.createCriteria().andEqualTo("payinfoId", orderPayinfoDto.getPayinfoId()).andEqualTo("orderCode", orderCode);
                shopOrderPayinfoService.updateByConditionNotNull(orderPayinfoDto, cond);
                
                // /////////////发起支付操作/////////////////
                // Modify by Qu Dihuai for RM-4599 start
                String[] payResult = this.orderPay(payWay, orderTmpCode, orderTmpCode, shopOrderPayinfoDto.getPayAmount(),
                        shopOrderInfoDto.getAddTime(), projectCode, goodsName, "1", tradeType, openId, spBillCreateIp, clientType, uid, dataSource,
                        returnUrl, appCode, channelNo, frontUrl, mobile, model, actCode, serialNo, userName, goodType, payeeName, phoneNo,
                        bankAccount, docType, docNo, unionPayUserId, testIssueFlag);
                // Modify by Qu Dihuai for RM-4599 end

                if ("Y".equals(payResult[0])) {
                    payInfoDto = JSON.parseObject(payResult[1], PayInfoDto.class);
                    if ("true".equals(payInfoDto.getSuccess())) {
                        // 更新资金交易流水号和交易时间
                        orderPayinfoDto.setPayNo(payInfoDto.getBatchNo());
                        orderPayinfoDto.setPayDate(TimeUtil.parseDate(payInfoDto.getOrderDate(), FORMAT));
                        
                        orderPayinfoDto.setUpdatedUser(uid);
                        orderPayinfoDto.setUpdatedDate(new Date());
                        //shopOrderPayinfoService.updateByPrimaryKey(orderPayinfoDto);
                        orderPayinfoDto.setOrderCode(null);
                        Condition shopPayInfoCond = new Condition(ShopOrderPayinfoDto.class);
                        shopPayInfoCond.createCriteria().andEqualTo("payinfoId", orderPayinfoDto.getPayinfoId()).andEqualTo("orderCode", orderCode);
                        shopOrderPayinfoService.updateByConditionNotNull(orderPayinfoDto, shopPayInfoCond);

                        initOrderPayResp.setPassFlag("0");
                        initOrderPayResp.setMessage(payResult[1]);
                    } else {
                        initOrderPayResp.setPassFlag("1");
                        initOrderPayResp.setMessage(payInfoDto.getErrorMsg());
                        logger.warn("支付发起出错原因,userId:" + uid + ",orderCode:" + orderCode + payInfoDto.getErrorMsg());
                    }
                } else {
                    initOrderPayResp.setPassFlag("1");
                    initOrderPayResp.setMessage("支付发起请求失败:"+payResult[1]);
                    logger.error("支付发起(资金)请求失败,userId:" + uid + ",orderCode:" + orderCode + payResult[1]);
                }
            } else if (PAY_SUCCESS_CODE.equals(success)) {
                // 情况一：订单状态已完成;支付状态支付成功
                // 其他情况：调用支付后订单处理接口进行后续处理
                if ("2".equals(shopOrderInfoDto.getOrderStatus()) && "1".equals(shopOrderPayinfoDto.getPayStatus())) {
                    initOrderPayResp.setPassFlag("1");
                    initOrderPayResp.setMessage("该订单已支付成功");

                    // 支付成功状态写入缓存
                    try {
                        redisTemplate.set(ODST_PREFIX + orderTmpCode, "1", Constants.EXPIRE_TIME); // 支付成功
                    } catch (Exception e) {
                        logger.error("ODST_[" + orderTmpCode + "]写入Redis缓存失败," + e);
                    }
                } else {
                    // 支付后订单处理
                    RequestMessage afterPayReq = new RequestMessage();
                    afterPayReq.setInterfaceCode("DealOrderAfterPay");
                    afterPayReq.setRequestTime(new Date());
                    afterPayReq.setUserId(uid);
                    DealOrderAfterPayReq dealOrderAfterPayReq = new DealOrderAfterPayReq();
                    dealOrderAfterPayReq.setOrderCode(orderTmpCode);
                    afterPayReq.getData().setDealOrderAfterPayReq(dealOrderAfterPayReq);

                    ResponseMessage afterPayResp = orderService.dealOrderAfterPay(afterPayReq);

                    if (SUCCESS_CODE.equals(afterPayResp.getCode())) {

                        // 支付成功状态写入缓存
                        try {
                            redisTemplate.set(ODST_PREFIX + orderTmpCode, "1", Constants.EXPIRE_TIME); // 支付成功
                        } catch (Exception e) {
                            logger.error("ODST_[" + orderTmpCode + "]写入Redis缓存失败," + e);
                        }

                        DealOrderAfterPayResp dealOrderAfterPayResp = afterPayResp.getData().getDealOrderAfterPayResp();
                        ShopOrderInfoDto orderInfoDto = dealOrderAfterPayResp.getShopOrderInfo();
                        if (ORDER_FINISH_STATUS.equals(orderInfoDto.getOrderStatus())) {
                            initOrderPayResp.setPassFlag("1");
                            initOrderPayResp.setMessage("该订单已支付成功及已生成保单");
                        } else {
                            initOrderPayResp.setPassFlag("1");
                            initOrderPayResp.setMessage("该订单已支付成功,生成保单失败,请联系客服协助处理");
                            logger.error("订单已支付成功,生成保单失败,userId:{},orderCode:{}", uid, orderCode);
                        }
                    } else {
                        initOrderPayResp.setPassFlag("1");
                        initOrderPayResp.setMessage(afterPayResp.getMessage());
                    }
                }
            } else if (PAY_ERROR_CODE.indexOf(success) > -1) {
                initOrderPayResp.setPassFlag("1");
                initOrderPayResp.setMessage(payInfoDto.getErrorMsg());
            } else {
                initOrderPayResp.setPassFlag("1");
                initOrderPayResp.setMessage("该订单状态为:" + Constants.paystatusMap.get(success));
            }
        } else {
            initOrderPayResp.setPassFlag("1");
            initOrderPayResp.setMessage(payQueryresult[1]);
            logger.error("资金支付查询服务异常,userId:" + uid + ",orderCode:" + orderCode + payQueryresult[1]);
        }

        responseMessage.getData().setInitOrderPayResp(initOrderPayResp);

        responseMessage.setMessage(SUCCESS_MSG);
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);
        return responseMessage;
    }

    /**
     * 发起支付
     * @param payWay 支付方式
     * @param batchNo 资金交易流水号
     * @param orderID 订单号
     * @param orderAmount 订单金额
     * @param orderDate 订单时间
     * @param goodsID 商品ID
     * @param goodsName 商品名称
     * @param goodsNum 商品数量
     * @param tradeType 交易类型(WX)
     * @param openId 用户标识 (jsapi 使用)(WX)
     * @param spBillCreateIp 终端IP APP和网页支付提交用户端ip(WX)
     * @param clientType 启动类型(工行APP)
     * @param payerId 客户号或者用户号码，用于快捷支付第二次支付不用录入很多信息
     * @param dataSource 数据来源，即调用的系统
     * @param returnUrl 支付宝前端跳转url
     *  <p> union param start </p>
     * @param appCode 应用ID
     * @param channelNo 渠道编号
     * @param frontUrl 前台通知地址
     * @param mobile 手机号
     * @param model 模式类型
     * @param actCode 活动编号
     * @param serialNo 流水号
     * @param userName 用户名
     * @param goodType 商品类型
     * @param unionPayUserId 银联的用户ID
     * @param testIssueFlag 测试单标识Y-是，N（或null）-否
     * <p> union param end </p>
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private String[] orderPay(String payWay, String batchNo, String orderID, BigDecimal orderAmount, Date orderDate, String goodsID,
            String goodsName, String goodsNum, String tradeType, String openId, String spBillCreateIp, String clientType, String payerId,
            String dataSource, String returnUrl, String appCode, String channelNo, String frontUrl, String mobile, String model, String actCode,
            String serialNo, String userName, String goodType, String payeeName, String phoneNo, String bankAccount, String docType, String docNo, 
            final String unionPayUserId, String testIssueFlag)
            throws Exception {
        Map paramMap = new HashMap();
        paramMap.put("batchNo", batchNo);
        paramMap.put("orderID", orderID);
        paramMap.put("orderAmount", String.valueOf(orderAmount.multiply(new BigDecimal(100)).intValue()));
        paramMap.put("orderDate", TimeUtil.format(orderDate, FORMAT));
        paramMap.put("goodsID", goodsID);
        paramMap.put("goodsPrice", String.valueOf(orderAmount.multiply(new BigDecimal(100)).intValue()));
        paramMap.put("goodsName", goodsName);
        paramMap.put("goodsNum", goodsNum);
        paramMap.put("payerId", payerId);
        paramMap.put("dataSource", dataSource);
        paramMap.put("returnUrl", returnUrl);
        paramMap.put("testIssueFlag", testIssueFlag);

        String[] payresult = null;
        if (PayWayEnum.ICBC_PAY.code().equals(payWay)) {
            payresult = new ClientUtils().connectServer(ConfigUtil.getValue("icbcepay.url"), paramMap);
        } else if (PayWayEnum.ICBC_APP_PAY.code().equals(payWay)) {
            paramMap.put("clientType", clientType);
            payresult = new ClientUtils().connectServer(ConfigUtil.getValue("icbcepay.app.url"), paramMap);
        } else if (PayWayEnum.ALI_PAY.code().equals(payWay)) {
            // 支付宝是否默认金额为1分钱(Y:是 N:否)
            if ("Y".equals(ConfigUtil.getValue("alipay.pay.default"))) {
                paramMap.put("orderAmount", "1");
                paramMap.put("goodsPrice", "1");
            }
            payresult = new ClientUtils().connectServer(ConfigUtil.getValue("alipay.url"), paramMap);
        } else if (PayWayEnum.ALI_NATIVE_PAY.code().equals(payWay)) {
            // 支付宝是否默认金额为1分钱(Y:是 N:否)
            if ("Y".equals(ConfigUtil.getValue("alipay.pay.default"))) {
                paramMap.put("orderAmount", "1");
                paramMap.put("goodsPrice", "1");
            }
            payresult = new ClientUtils().connectServer(ConfigUtil.getValue("alipay.native.url"), paramMap);
        } else if (PayWayEnum.ALI_APP_PAY.code().equals(payWay)) {
            // 支付宝是否默认金额为1分钱(Y:是 N:否)
            if ("Y".equals(ConfigUtil.getValue("alipay.pay.default"))) {
                paramMap.put("orderAmount", "1");
                paramMap.put("goodsPrice", "1");
            }
            payresult = new ClientUtils().connectServer(ConfigUtil.getValue("alipay.app.url"), paramMap);
        } else if (PayWayEnum.ALI_WAP_PAY.code().equals(payWay)) {
            // 支付宝是否默认金额为1分钱(Y:是 N:否)
            if ("Y".equals(ConfigUtil.getValue("alipay.pay.default"))) {
                paramMap.put("orderAmount", "1");
                paramMap.put("goodsPrice", "1");
            }
            payresult = new ClientUtils().connectServer(ConfigUtil.getValue("alipay.wap.url"), paramMap);
        } else if (PayWayEnum.WX_PAY.code().equals(payWay)) {
            // 微信支付是否默认金额为1分钱(Y:是 N:否)
            if ("Y".equals(ConfigUtil.getValue("weixin.pay.default"))) {
                paramMap.put("orderAmount", "1");
                paramMap.put("goodsPrice", "1");
            }
            paramMap.put("tradeType", tradeType);
            paramMap.put("openId", openId);
            paramMap.put("spBillCreateIp", spBillCreateIp);
            payresult = new ClientUtils().connectServer(ConfigUtil.getValue("weixinpay.url"), paramMap);
        } else if (PayWayEnum.WX_H5_PAY.code().equals(payWay)) {
            // 微信支付是否默认金额为1分钱(Y:是 N:否)
            if ("Y".equals(ConfigUtil.getValue("weixin.pay.default"))) {
                paramMap.put("orderAmount", "1");
                paramMap.put("goodsPrice", "1");
            }
            paramMap.put("tradeType", tradeType);
            paramMap.put("openId", openId);
            paramMap.put("spBillCreateIp", spBillCreateIp);
            payresult = new ClientUtils().connectServer(ConfigUtil.getValue("weixinpay.url"), paramMap);
        } else if (PayWayEnum.KUAIQIAN_PAY.code().equals(payWay)) {
            String chinese = goodsName; // java内部编码
            String gbkChinese = new String(chinese.getBytes(StandardCharset.GBK), StandardCharset.ISO_8859_1); // 转换成gbk编码
            String unicodeChinese = new String(gbkChinese.getBytes(StandardCharset.ISO_8859_1), StandardCharset.GBK); // java内部编码
            String utf8Chinese = new String(unicodeChinese.getBytes(StandardCharset.UTF_8), StandardCharset.ISO_8859_1); // utf-8编码
            unicodeChinese = new String(utf8Chinese.getBytes(StandardCharset.ISO_8859_1), StandardCharset.UTF_8); // java内部编码
            paramMap.put("goodsName", unicodeChinese);
            // 快钱支付是否默认金额为1分钱(Y:是 N:否)
            if ("Y".equals(ConfigUtil.getValue("kuaiqian.pay.default"))) {
                paramMap.put("orderAmount", "1");
                paramMap.put("goodsPrice", "1");
            }
            payresult = new ClientUtils().connectServer(ConfigUtil.getValue("kuaiqianpay.url"), paramMap);
        } else if (PayWayEnum.UNION_PAY.code().equals(payWay)) {
            // 银联支付是否默认金额为1分钱(Y:是 N:否)
            if("Y".equals(ConfigUtil.getValue("union.pay.default"))) {
                paramMap.put("orderAmount", "1");
                paramMap.put("goodsPrice", "1");
            }
            paramMap.put("appCode", appCode);
            paramMap.put("channelNo", channelNo);
            paramMap.put("frontUrl", frontUrl);
            paramMap.put("mobile", mobile);
            paramMap.put("model", model);
            paramMap.put("actCode", actCode);
            paramMap.put("serialNo", serialNo);
            paramMap.put("userName", userName);
            paramMap.put("goodType", goodType);
            // Add by Qu Dihuai for RM-4599 start
            paramMap.put("userId", unionPayUserId);
            // Add by Qu Dihuai for RM-4599 end
            payresult = new ClientUtils().connectServer(ConfigUtil.getValue("unionpay.url"), paramMap);
        } else if (PayWayEnum.WU_TONG.code().equals(payWay)) {
        	if("Y".equals(ConfigUtil.getValue("union.pay.default"))) {
                paramMap.put("orderAmount", "120");
                paramMap.put("goodsPrice", "120");
            }
            // 验证支付证件号码是否是投保人证件号码
            OrderCustomerDto orderCustomer = new OrderCustomerDto();
            orderCustomer.setCustomerFlag("1");
            orderCustomer.setOrderCode(new BigInteger(orderID));
            orderCustomer = orderCustomerService.selectOne(orderCustomer);
            if (orderCustomer.getDocType().equals(docType) && orderCustomer.getDocNo().equals(docNo)
                    && orderCustomer.getCustomerName().equals(payeeName)) {

                paramMap.put("customerName", payeeName);
                paramMap.put("phoneNo", phoneNo);
                paramMap.put("acctNo", bankAccount);
                paramMap.put("cerdType", docType);
                paramMap.put("cerdId", docNo);

                payresult = new ClientUtils().connectServer(ConfigUtil.getValue("wutongpay.url"), paramMap);
            } else {
                payresult = new String[2];
                payresult[0] = "N";
                payresult[1] = "支付人与投保人不匹配";
        	}
        } else {
            payresult = new String[2];
            payresult[0] = "N";
            payresult[1] = "没有找到该支付方式";
        }
        return payresult;
    }

	/**
	 * 支付查询
	 * 
	 * @return
	 * @throws Exception
	 */
	private String[] orderPayQuery(String payWay, String batchNo, String orderID, Date orderDate, String dataSource) {
		final PayWayEnum payWayEnum = PayWayEnum.fromCode(payWay);
		if (payWayEnum == null) {
			return new String[] { "N", "没有找到该支付方式" };
		}

		final Map<String, String> paramMap = new HashMap<>();
		paramMap.put("batchNo", batchNo == null ? orderID : batchNo);
		paramMap.put("orderID", orderID);
		paramMap.put("orderDate", TimeUtil.format(orderDate == null ? new Date() : orderDate, FORMAT));
		paramMap.put("dataSource", dataSource);

		return new ClientUtils().connectServer(ConfigUtil.getValue(payWayEnum.urlKey()), paramMap);
	}

    /**
     * 5.2.22 获取微信签名
     * 
     * @Author: lujicong
     * @Date: 2015-12-24
     * @Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    @Override
    public ResponseMessage getWxSign(RequestMessage requestMessageObj) throws Exception {
        ResponseMessage responseMessage = new ResponseMessage();
        GetWxSignReq getWxSignReq = requestMessageObj.getData().getGetWxSignReq();
        
        String appid = getWxSignReq.getAppid();
        String dataSource = getWxSignReq.getDataSource();
        String characterEncoding = getWxSignReq.getCharacterEncoding();
        
        // 传入信息校验
        StringBuffer checkMsg = new StringBuffer();
        if (StringUtil.isEmpty(dataSource)) {
            checkMsg.append("数据来源不能为空,");
        }
        if(StringUtil.isEmpty(characterEncoding)) {
            checkMsg.append("编码类型不能为空,");
        }
        if (StringUtil.isNotEmpty(checkMsg.toString())) {
            responseMessage.setMessage(checkMsg.substring(0, checkMsg.length() - 1));
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }

        String result[] = new ClientUtils().connectServer(ConfigUtil.getValue("weixin.sign"), getWxSignReq);
        
        if ("Y".equals(result[0])) {
            GetWxSignResp getWxSignResp = new GetWxSignResp();
            getWxSignResp.setResult(result[1]);
            responseMessage.getData().setGetWxSignResp(getWxSignResp);
        }else {
            responseMessage.setMessage(result[1]);
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            logger.error("appid:{},characterEncoding:{},data:{},errorInfo:{}",appid, characterEncoding, getWxSignReq.getData(), result[1]);
            return responseMessage;
        }
        
        responseMessage.setMessage(SUCCESS_MSG);
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);
        return responseMessage;
    }
}
