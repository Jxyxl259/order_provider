package com.yaic.app.order.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yaic.app.Constants;
import com.yaic.app.dysub.dto.msg.OrderCallBackDysubReq;
import com.yaic.app.dysub.dto.msg.PolicyNoToRedisReq;
import com.yaic.app.dysub.dto.msg.common.DysubRequestMessage;
import com.yaic.app.dysub.dto.msg.common.DysubResponseMessage;
import com.yaic.app.nfin.dto.msg.common.NFinRequestMessage;
import com.yaic.app.nfin.dto.msg.common.NFinResponseMessage;
import com.yaic.app.nfin.service.NFinService;
import com.yaic.app.order.dto.SortOrderInfo;
import com.yaic.app.order.dto.SortPolicyInfo;
import com.yaic.app.order.dto.custom.PolicyInfo;
import com.yaic.app.order.dto.custom.ProdToPolicyInfo;
import com.yaic.app.order.dto.custom.PropertyPolicyDto;
import com.yaic.app.order.dto.domain.OrderCargoDtlDto;
import com.yaic.app.order.dto.domain.OrderCargoDto;
import com.yaic.app.order.dto.domain.OrderClaimDto;
import com.yaic.app.order.dto.domain.OrderClausesDto;
import com.yaic.app.order.dto.domain.OrderCoinsLiabDto;
import com.yaic.app.order.dto.domain.OrderCoinsuranceDto;
import com.yaic.app.order.dto.domain.OrderCommissionDto;
import com.yaic.app.order.dto.domain.OrderCustomerDto;
import com.yaic.app.order.dto.domain.OrderDeductibleDto;
import com.yaic.app.order.dto.domain.OrderDynamicItemDto;
import com.yaic.app.order.dto.domain.OrderDynamicListDto;
import com.yaic.app.order.dto.domain.OrderIdxUserIdDto;
import com.yaic.app.order.dto.domain.OrderItemAcciBenDto;
import com.yaic.app.order.dto.domain.OrderItemAcciDto;
import com.yaic.app.order.dto.domain.OrderItemAcciLstDto;
import com.yaic.app.order.dto.domain.OrderItemkindDto;
import com.yaic.app.order.dto.domain.OrderLimitDto;
import com.yaic.app.order.dto.domain.OrderMainDto;
import com.yaic.app.order.dto.domain.OrderPartnerDto;
import com.yaic.app.order.dto.domain.OrderPayinfoDto;
import com.yaic.app.order.dto.domain.OrderPaymentPlanDto;
import com.yaic.app.order.dto.domain.OrderPaymentPlanReinsDto;
import com.yaic.app.order.dto.domain.OrderPropertyDto;
import com.yaic.app.order.dto.domain.OrderRescueDto;
import com.yaic.app.order.dto.domain.OrderRiskDynamicDto;
import com.yaic.app.order.dto.domain.OrderSalesmanDto;
import com.yaic.app.order.dto.domain.OrderSpecialClausesDto;
import com.yaic.app.order.dto.domain.ShopOrderExtendInfoDto;
import com.yaic.app.order.dto.domain.ShopOrderGoodsDto;
import com.yaic.app.order.dto.domain.ShopOrderInfoDto;
import com.yaic.app.order.dto.domain.ShopOrderPayinfoDto;
import com.yaic.app.order.dto.domain.ShopOrderShippingDto;
import com.yaic.app.order.dto.domain.VorderDynamicDto;
import com.yaic.app.order.dto.msg.CallBackOrderInfoReq;
import com.yaic.app.order.dto.msg.CancelInsuranceCallBackReq;
import com.yaic.app.order.dto.msg.CancelInsuranceReq;
import com.yaic.app.order.dto.msg.CancelInsuranceResp;
import com.yaic.app.order.dto.msg.CreateOrderReq;
import com.yaic.app.order.dto.msg.CreateOrderResp;
import com.yaic.app.order.dto.msg.DealOrderAfterPayReq;
import com.yaic.app.order.dto.msg.DealOrderAfterPayResp;
import com.yaic.app.order.dto.msg.EndorReq;
import com.yaic.app.order.dto.msg.EndorResp;
import com.yaic.app.order.dto.msg.LiabilitySwitchReq;
import com.yaic.app.order.dto.msg.LiabilitySwitchResp;
import com.yaic.app.order.dto.msg.ManuallyAuditingReq;
import com.yaic.app.order.dto.msg.NcmGetTrandNoReq;
import com.yaic.app.order.dto.msg.NcmGetTrandNoResp;
import com.yaic.app.order.dto.msg.NcmTrandNoToPayReq;
import com.yaic.app.order.dto.msg.NcmTrandNoToPayResp;
import com.yaic.app.order.dto.msg.OrderActivationCardLogoutReq;
import com.yaic.app.order.dto.msg.OrderActivationCardLogoutResp;
import com.yaic.app.order.dto.msg.OrderSalesInfoDto;
import com.yaic.app.order.dto.msg.OrderToPolicyReq;
import com.yaic.app.order.dto.msg.OrderToPolicyResp;
import com.yaic.app.order.dto.msg.OrderToPolicyUpdateDataReq;
import com.yaic.app.order.dto.msg.OrderToProposalReq;
import com.yaic.app.order.dto.msg.OrderToProposalResp;
import com.yaic.app.order.dto.msg.QueryActivationCardInfoReq;
import com.yaic.app.order.dto.msg.QueryActivationCardInfoResp;
import com.yaic.app.order.dto.msg.QueryOrderCountReq;
import com.yaic.app.order.dto.msg.QueryOrderCountResp;
import com.yaic.app.order.dto.msg.QueryOrderDetailInfoReq;
import com.yaic.app.order.dto.msg.QueryOrderDetailInfoResp;
import com.yaic.app.order.dto.msg.QueryOrderListReq;
import com.yaic.app.order.dto.msg.QueryOrderListResp;
import com.yaic.app.order.dto.msg.QueryOrderPayInfoReq;
import com.yaic.app.order.dto.msg.QueryOrderPayInfoResp;
import com.yaic.app.order.dto.msg.QueryOrderPayStatusReq;
import com.yaic.app.order.dto.msg.QueryOrderPayStatusResp;
import com.yaic.app.order.dto.msg.QueryOrderRepeatedResp;
import com.yaic.app.order.dto.msg.QueryPolicyDetailInfoReq;
import com.yaic.app.order.dto.msg.QueryPolicyDetailInfoResp;
import com.yaic.app.order.dto.msg.QueryPolicyEndorInfoResp;
import com.yaic.app.order.dto.msg.QueryPolicyListReq;
import com.yaic.app.order.dto.msg.QueryPolicyListResp;
import com.yaic.app.order.dto.msg.QueryProdToPolicyListReq;
import com.yaic.app.order.dto.msg.QueryProdToPolicyListResp;
import com.yaic.app.order.dto.msg.QueryPropallReq;
import com.yaic.app.order.dto.msg.QueryPropertyCountReq;
import com.yaic.app.order.dto.msg.QueryPropertyCountResp;
import com.yaic.app.order.dto.msg.QueryUserIdByOrderCodeReq;
import com.yaic.app.order.dto.msg.QueryUserIdByOrderCodeResp;
import com.yaic.app.order.dto.msg.SurrenderCallBackReq;
import com.yaic.app.order.dto.msg.TransTrandNoToPayResp;
import com.yaic.app.order.dto.msg.UnderwriterCallBackReq;
import com.yaic.app.order.dto.msg.UpdateOrderPayInfoReq;
import com.yaic.app.order.dto.msg.UpdateOrderPayStatusReq;
import com.yaic.app.order.dto.msg.UpdateOrderStatusReq;
import com.yaic.app.order.dto.msg.common.CallBackOrderInfoDto;
import com.yaic.app.order.dto.msg.common.OrderDto;
import com.yaic.app.order.dto.msg.common.RequestMessage;
import com.yaic.app.order.dto.msg.common.ResponseMessage;
import com.yaic.app.order.dto.msg.common.ShopOrderDto;
import com.yaic.app.order.service.OrderCargoDtlService;
import com.yaic.app.order.service.OrderCargoService;
import com.yaic.app.order.service.OrderClaimService;
import com.yaic.app.order.service.OrderClausesService;
import com.yaic.app.order.service.OrderCoinsLiabService;
import com.yaic.app.order.service.OrderCoinsuranceService;
import com.yaic.app.order.service.OrderCommissionService;
import com.yaic.app.order.service.OrderCustomerService;
import com.yaic.app.order.service.OrderDeductibleService;
import com.yaic.app.order.service.OrderDynamicItemService;
import com.yaic.app.order.service.OrderDynamicListService;
import com.yaic.app.order.service.OrderIdxUserIdService;
import com.yaic.app.order.service.OrderItemAcciBenService;
import com.yaic.app.order.service.OrderItemAcciLstService;
import com.yaic.app.order.service.OrderItemAcciService;
import com.yaic.app.order.service.OrderItemkindService;
import com.yaic.app.order.service.OrderLimitService;
import com.yaic.app.order.service.OrderMainService;
import com.yaic.app.order.service.OrderPartnerService;
import com.yaic.app.order.service.OrderPayinfoService;
import com.yaic.app.order.service.OrderPaymentPlanReinsService;
import com.yaic.app.order.service.OrderPaymentPlanService;
import com.yaic.app.order.service.OrderPropertyService;
import com.yaic.app.order.service.OrderRescueService;
import com.yaic.app.order.service.OrderRiskDynamicService;
import com.yaic.app.order.service.OrderSalesmanService;
import com.yaic.app.order.service.OrderService;
import com.yaic.app.order.service.OrderSolutionProdService;
import com.yaic.app.order.service.OrderSpecialClausesService;
import com.yaic.app.order.service.ShopOrderGoodsService;
import com.yaic.app.order.service.ShopOrderInfoService;
import com.yaic.app.order.service.ShopOrderPayinfoService;
import com.yaic.app.order.service.ShopOrderShippingService;
import com.yaic.app.order.service.VorderDynamicService;
import com.yaic.app.order.utils.ClientUtils;
import com.yaic.app.order.utils.ToolUtils;
import com.yaic.app.pdms.dto.custom.PdmsProdInfoDto;
import com.yaic.app.pdms.dto.custom.PdmsProdRiskInfoDto;
import com.yaic.app.pdms.dto.custom.PdmsSolutionInfoDto;
import com.yaic.app.pdms.dto.domain.PdmsClauseDto;
import com.yaic.app.pdms.dto.domain.PdmsProductClaimDto;
import com.yaic.app.pdms.dto.domain.PdmsProductDeductibleDto;
import com.yaic.app.pdms.dto.domain.PdmsProductKindDto;
import com.yaic.app.pdms.dto.domain.PdmsProductLimitDto;
import com.yaic.app.pdms.dto.domain.PdmsProductSpecialClsDto;
import com.yaic.app.pdms.dto.domain.PdmsSolutionDto;
import com.yaic.app.pdms.dto.domain.PdmsSolutionIntermediaryDto;
import com.yaic.app.pdms.dto.domain.PdmsSolutionMessageDto;
import com.yaic.app.pdms.dto.domain.PdmsSolutionSalesmanDto;
import com.yaic.app.pdms.dto.msg.GetPdmsProductReq;
import com.yaic.app.pdms.dto.msg.GetPdmsProductResp;
import com.yaic.app.pdms.dto.msg.GetSolutionProdReq;
import com.yaic.app.pdms.dto.msg.GetSolutionProdResp;
import com.yaic.app.pdms.dto.msg.common.PdmsRequestMessage;
import com.yaic.app.pdms.dto.msg.common.PdmsResponseMessage;
import com.yaic.app.provider.StatusCodeProvider;
import com.yaic.app.pubs.dto.msg.MailRequestDto;
import com.yaic.app.pubs.dto.msg.MailResponseDto;
import com.yaic.app.pubs.service.MailService;
import com.yaic.app.syn.dto.domain.SynEpolicyDto;
import com.yaic.app.syn.dto.domain.SynPolicyDtlDto;
import com.yaic.app.syn.dto.domain.SynPolicyDto;
import com.yaic.app.syn.dto.domain.SynPolicySurrenderDto;
import com.yaic.app.syn.service.SynEpolicyService;
import com.yaic.app.syn.service.SynPolicyDtlService;
import com.yaic.app.syn.service.SynPolicyService;
import com.yaic.app.syn.service.SynPolicySurrenderService;
import com.yaic.app.trans.dto.msg.TransActivationCardLogoutReq;
import com.yaic.app.trans.dto.msg.TransActivationCardLogoutResp;
import com.yaic.app.trans.dto.msg.TransCancelInsuranceReq;
import com.yaic.app.trans.dto.msg.TransCancelInsuranceResp;
import com.yaic.app.trans.dto.msg.TransEndorReq;
import com.yaic.app.trans.dto.msg.TransEndorResp;
import com.yaic.app.trans.dto.msg.TransLiabilitySwitchReq;
import com.yaic.app.trans.dto.msg.TransLiabilitySwitchResp;
import com.yaic.app.trans.dto.msg.TransOrderToBusinessNoReq;
import com.yaic.app.trans.dto.msg.TransOrderToBusinessNoResp;
import com.yaic.app.trans.dto.msg.TransOrderToProposalReq;
import com.yaic.app.trans.dto.msg.TransOrderToProposalResp;
import com.yaic.app.trans.dto.msg.TransQueryActivationCardInfoReq;
import com.yaic.app.trans.dto.msg.TransQueryActivationCardInfoResp;
import com.yaic.app.trans.dto.msg.TransSalesInfoDto;
import com.yaic.app.trans.dto.msg.common.TransRequestMessage;
import com.yaic.app.trans.dto.msg.common.TransResponseMessage;
import com.yaic.fa.dto.PageDto;
import com.yaic.fa.exceptions.MessageException;
import com.yaic.fa.mybatis.mapper.entity.Condition;
import com.yaic.fa.redis.core.RedisTemplate;
import com.yaic.fa.redis.core.RedisTemplateCheckProp;
import com.yaic.fa.redis.core.RedisTemplateTakeNo;
import com.yaic.servicelayer.codec.digest.MD5Helper;
import com.yaic.servicelayer.datetime.DateTime;
import com.yaic.servicelayer.http.wrapper.HttpResponseWrapper;
import com.yaic.app.generator.IdGenerator;
import com.yaic.servicelayer.util.CollectionUtil;
import com.yaic.servicelayer.util.ConfigUtil;
import com.yaic.servicelayer.util.DecimalUtil;
import com.yaic.servicelayer.util.ObjectUtil;
import com.yaic.servicelayer.util.StringUtil;
import com.yaic.servicelayer.util.TimeUtil;

/**
 * 订单管理服务
 * @Author: lujicong
 * @Date: 2015-12-23
 * @Version: 1.0
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    private static final String SUCCESS_CODE     = "0000";      // 处理成功
    private static final String FAIL_CODE        = "9999";      // 处理失败
    private static final String SUCCESS_STATE    = "1";         // 成功状态
    private static final String FAIL_STATE       = "0";         // 失败状态
    private static final String CREATE_USER      = "SYSTEM";    // 创建人
    private static final String UPDATED_USER     = "SYSTEM";    // 更新人

    private static final String ORDER_DEAL_STATUS = "3,6,7,8";  // 订单状态
    private static final String ORDER_CANCEL_STATUS = "5";      // 全单批退
    private static final String SUCCESS_MSG = "success";
    
    private static final String ODST_PREFIX = "ODST_";          // 订单支付状态前缀
    public static final String FIELD_SEPARATOR = "_FIELD_SEPARATOR_"; //字段分隔符
    
    private static final String POA_EMAIL = "POA_EMAIL_";        //暂收款是否已发送邮件
    
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisTemplateCheckProp redisTemplateCheckProp;
    @Autowired
    private OrderMainService orderMainService;
    @Autowired
    private OrderPayinfoService orderPayinfoService;
    @Autowired
    private OrderCustomerService orderCustomerService;
    @Autowired
    private OrderPropertyService orderPropertyService;
    @Autowired
    private OrderItemkindService orderItemkindService;
    @Autowired
    private ShopOrderInfoService shopOrderInfoService;
    @Autowired
    private ShopOrderGoodsService shopOrderGoodsService;
    @Autowired
    private OrderIdxUserIdService orderIdxUserIdService;
    @Autowired
    private ShopOrderPayinfoService shopOrderPayinfoService;
    @Autowired
    private ShopOrderShippingService shopOrderShippingService;
    @Autowired
    private OrderDynamicItemService orderDynamicItemService;
    @Autowired
    private OrderSolutionProdService orderSolutionProdService;
    @Autowired
    private OrderClausesService orderClausesService;
    @Autowired
    private OrderSpecialClausesService orderSpecialClausesService;
    @Autowired
    private OrderDynamicListService orderDynamicListService;
    @Autowired
    private OrderLimitService orderLimitService;
    @Autowired
    private OrderDeductibleService orderDeductibleService;
    @Autowired
    private OrderClaimService orderClaimService;
    @Autowired
    private VorderDynamicService vorderDynamicService;
    @Autowired
    private OrderItemAcciLstService orderItemAcciLstService;
    @Autowired
    private OrderCommissionService orderCommissionService;
    @Autowired
    private OrderCargoService orderCargoService;
    @Autowired
    private OrderCargoDtlService orderCargoDtlService;
    @Autowired
    private OrderPaymentPlanService orderCargoPaymentPlanService;
    @Autowired
    private OrderPaymentPlanReinsService orderPaymentPlanReinsService;
    @Autowired
    private OrderItemAcciService orderItemAcciService;
    @Autowired
    private OrderItemAcciBenService orderItemAcciBenService;
    @Autowired
    private OrderRiskDynamicService orderRiskDynamicService;
    @Autowired
    private RedisTemplateTakeNo redisTemplateTakeNo;
    @Autowired
    private SynPolicyService synPolicyService;
    @Autowired
    private SynPolicyDtlService synPolicyDtlService;
    @Autowired
    private SynPolicySurrenderService synPolicySurrenderService;
//  @Autowired
//  private FinService finService;/** delete by zhaobaoyang 2018/08/14 for RM-6864 新收付暂收款功能需求-中台系统   */
    @Autowired
    private NFinService nfinService;
    @Autowired
    private MailService mailService;
	@Autowired
	private OrderPartnerService orderPartnerService;
	@Autowired
	private OrderSalesmanService orderSalesmanService;
	@Autowired
	private OrderCoinsuranceService orderCoinsuranceService;
	@Autowired
	private OrderCoinsLiabService orderCoinsLiabService;
	@Autowired
	private SynEpolicyService synEpolicyService;
	@Autowired
	private OrderRescueService orderRescueService;
    @Autowired
    private IdGenerator idGenerator;
    /**
     * 5.2.1 创建/修改订单
     * 
     * @Author lujicong
     * @Date: 2015-12-23
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
    public ResponseMessage createOrder(RequestMessage requestMessageObj) throws Exception {
        ResponseMessage responseMessage = new ResponseMessage();
        CreateOrderReq createOrderReq = requestMessageObj.getData().getCreateOrderReq();
        String uid = requestMessageObj.getUserId(); // 用户ID

        // 传入信息校验
        StringBuffer checkMsg = new StringBuffer();
        if (StringUtil.isEmpty(uid)) {
            checkMsg.append("用户ID不能为空,");
        }
        if (createOrderReq.getShopOrderInfo() == null) {
            checkMsg.append("订单详情信息不能为空,");
        }
        if (CollectionUtil.isEmpty(createOrderReq.getOrderList())) {
            checkMsg.append("订单信息列表不能为空,");
        }
        if (StringUtil.isNotEmpty(checkMsg.toString())) {
            responseMessage.setMessage(checkMsg.substring(0, checkMsg.length() - 1));
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }

        // 用户ID
        BigInteger userId = new BigInteger(uid);

        // 订单号
        ShopOrderInfoDto shopOrderInfoDto = createOrderReq.getShopOrderInfo();
        BigInteger orderCode = shopOrderInfoDto.getOrderCode();

        if (orderCode == null) { // 新增订单
            orderCode = this.addOrder(userId, orderCode, createOrderReq);
        } else { // 修改订单
            orderCode = this.editOrder(userId, orderCode, createOrderReq);
        }
        CreateOrderResp createOrderResp = new CreateOrderResp();
        createOrderResp.setOrderCode(String.valueOf(orderCode));
        responseMessage.getData().setCreateOrderResp(createOrderResp);

        responseMessage.setMessage(SUCCESS_MSG);
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);

        return responseMessage;
    }
    
    /**
     * 获取协议方案信息
     * 
     * @return
     * @throws Exception
     */
    private GetSolutionProdResp getPdmsSolutionProdInfo(ShopOrderInfoDto shopOrderInfoDto, QueryActivationCardInfoResp activationCardInfoResp,
            OrderDto orderDto, BigInteger orderCode, String operateUser) throws Exception {
        // 协议信息
        String agrtCode = orderDto.getOrderMain().getAgrtCode();
        // 方案代码
        String projectCode = orderDto.getOrderMain().getProjectCode();
        String riskCode = orderDto.getOrderGoods().getGoodsId();
        
        PdmsResponseMessage pdmsResponseMessage = getPdmsSolutionProd(agrtCode, projectCode, riskCode);
        if (!SUCCESS_CODE.equals(pdmsResponseMessage.getCode())) {
        	logger.error("获取销售方案信息失败,销售方案号:{},响应状态为:{},失败原因:{}", agrtCode, pdmsResponseMessage.getStatusCode(), pdmsResponseMessage.getMessage());
        	throw new MessageException(pdmsResponseMessage.getStatusCode(),pdmsResponseMessage.getMessage());
        }
        
        GetSolutionProdResp getSolutionProdResp = pdmsResponseMessage.getData().getGetSolutionProdResp();
        PdmsSolutionInfoDto pdmsSolutionInfoDto = getSolutionProdResp.getPdmsSolutionInfoDto();
        PdmsSolutionDto solutionMain = pdmsSolutionInfoDto.getSolutionMain();
        
        // 获取卡式保单业务信息
        if(activationCardInfoResp != null) {
        	if (StringUtil.isEmpty(projectCode)) {
        		projectCode = activationCardInfoResp.getProjectCode();
        	}
        	ObjectUtil.copyProperties(solutionMain, activationCardInfoResp.getSalesInfoDto());
        	pdmsSolutionInfoDto.setSolutionMain(solutionMain);
        	getSolutionProdResp.setPdmsSolutionInfoDto(pdmsSolutionInfoDto);
        }
        
        List<PdmsProdInfoDto> productList = getSolutionProdResp.getProductList();
        if (CollectionUtil.isEmpty(productList)) {
        	pdmsResponseMessage = getPdmsProduct(projectCode, riskCode);
        	if (!SUCCESS_CODE.equals(pdmsResponseMessage.getCode())) {
        		logger.error("获取产品代码信息失败,产品代码:{},响应状态为:{},失败原因:{}", agrtCode, pdmsResponseMessage.getStatusCode(),pdmsResponseMessage.getMessage());
                throw new MessageException(pdmsResponseMessage.getStatusCode(),pdmsResponseMessage.getMessage());
        	}
        	GetPdmsProductResp getPdmsProductResp = pdmsResponseMessage.getData().getGetPdmsProductResp();
        	PdmsProdInfoDto pdmsProdInfo = getPdmsProductResp.getPdmsProdInfo();
        	productList.add(pdmsProdInfo);
        	getSolutionProdResp.setProductList(productList);
        }
        
        return getSolutionProdResp;
    }
    
    /**
     * 修改订单处理
     * 
     * @Author lujicong
     * @Date: 2015-12-23
     * @Version: 1.0
     * @param userId
     * @param orderCode
     * @param createOrderReq
     * @throws Exception 
     */
    private BigInteger editOrder(BigInteger userId, BigInteger orderCode, CreateOrderReq createOrderReq) throws Exception {
        /**
         * 处理流程：
         * 1、订单信息列表：
         *    1>删除订单数据
         *          手续费信息
         *          货运险缴费计划信息
         *          货运险标的信息
         *          动态清单信息
         *          动态标的信息
         *          家财标的信息
         *          意健险险种动态信息
         *          意外险受益人清单信息
         *          意外险人员清单信息
         *          意外险标的信息
         *          订单业务单关联信息
         *          客户信息列表 
         *          支付信息
         *          免赔信息列表
         *          限额信息列表
         *          特约信息列表
         *          条款信息列表
         *          险别信息列表
         *          订单商品关联信息
         *          订单信息
         *    2>获取协议信息
         *      协议号不为空，直接取协议信息
         *      若协议号为空,
         *          优先通过订单来源和险种代码查找业务映射信息，
         *    3>保存订单信息;
         *    4>保存险别信息列表;
         *    5>保存订单商品关联信息;
         *    6>保存条款信息列表;
         *    7>保存特约信息列表;
         *    8>保存限额信息列表;
         *    9>保存免赔信息列表;
         *    10>保存支付信息;
         *    11>保存客户信息列表;
         *    12>保存订单业务单关联信息;
         *    13>保存家财标的信息;
         *    14>保存动态标的信息列表;
         *    15>保存动态清单信息列表;
         *    16>保存货运险标的信息;
         *    17>保存货运险缴费计划信息;
         *    18>保存意外险标的信息
         *           18.1保存意外险人员清单信息
         *                   18.1.1保存意外险受益人清单信息
         *    19>保存意健险险种动态信息
         *    20>保存手续费信息;
         *    20>保存共保信息列表;
         *    21>保存共保责任列表;
         * 2、更新订单详情信息;
         * 3、更新订单支付信息;
         * 4、更新订单配送信息;
         */
        
        // 操作用户
        String operateUser = String.valueOf(userId);
        
        // 订单详情信息
        ShopOrderInfoDto shopOrderInfoDto = createOrderReq.getShopOrderInfo();
        shopOrderInfoDto.setUserId(userId);
        shopOrderInfoDto.setOrderCode(orderCode);
        
        // 订单扩展信息
        ShopOrderExtendInfoDto shopOrderExtendInfo = createOrderReq.getShopOrderExtendInfo();
        
        ShopOrderInfoDto ckShopOrderInfoDto = new ShopOrderInfoDto();
        ckShopOrderInfoDto.setUserId(userId);
        ckShopOrderInfoDto.setOrderCode(orderCode);
        ckShopOrderInfoDto = shopOrderInfoService.selectByPrimaryKey(ckShopOrderInfoDto);
        
        // 订单状态校验
        /* deleted by lguojiang 2018/8/30 for RM-8155 为了TIPS宠物医疗险-需求优化需求进行的修改 begin *\
        if("1".equals(ckShopOrderInfoDto.getOrderStatus())) {
            throw new MessageException("该订单已确认，不允许修改");
        }else 
        \* deleted by lguojiang 2018/8/30 for RM-8155 为了TIPS宠物医疗险-需求优化需求进行的修改 end   */
        if("2".equals(ckShopOrderInfoDto.getOrderStatus())) {
            throw new MessageException("该订单已完成，不允许修改");
        }
        
        // 获取卡式保单业务信息
        QueryActivationCardInfoResp activationCardInfoResp = this.getActivationCardInfo(shopOrderExtendInfo);
        
        // 订单支付信息
        ShopOrderPayinfoDto orderPayinfoDto = createOrderReq.getShopOrderPayinfo();
        
        if(orderPayinfoDto == null) {
            orderPayinfoDto = new ShopOrderPayinfoDto();
        }
        
        ShopOrderPayinfoDto shopOrderPayinfoDto = new ShopOrderPayinfoDto();
        shopOrderPayinfoDto.setUserId(userId);
        shopOrderPayinfoDto.setOrderCode(orderCode);
        shopOrderPayinfoDto = shopOrderPayinfoService.selectOne(shopOrderPayinfoDto);
        
        // 订单商品关联信息列表
        ShopOrderGoodsDto queryOrderGoodsDto = new ShopOrderGoodsDto();
        queryOrderGoodsDto.setUserId(userId);
        queryOrderGoodsDto.setOrderCode(orderCode);
        queryOrderGoodsDto.setInvalidFlag(0);
        List<ShopOrderGoodsDto> shopOrderGoodsList = shopOrderGoodsService.select(queryOrderGoodsDto);
        
        // --------------删除订单数据--------------
        if(CollectionUtil.isNotEmpty(shopOrderGoodsList)) {
            for(ShopOrderGoodsDto goodsDto : shopOrderGoodsList) {
                this.deleteOrderInfo(goodsDto);
            }
        }
        
        // 订单总金额
        BigDecimal orderSumFee = DecimalUtil.toBigDecimal(0.00);
        
        Date lastPlanDate = null;
        
        // 缴费计划第一期金额
        BigDecimal paymentPlan1SumFee = DecimalUtil.toBigDecimal(0.00);
        
        // --------------重写订单信息列表数据-------------
        List<OrderDto> orderList = createOrderReq.getOrderList();
        for(OrderDto orderDto : orderList) {
            
            // 获取销售方案信息
        	GetSolutionProdResp getSolutionProdResp =  this.getPdmsSolutionProdInfo(ckShopOrderInfoDto,activationCardInfoResp, orderDto, orderCode, operateUser);
            
            PdmsSolutionInfoDto pdmsSolutionInfoDto = getSolutionProdResp.getPdmsSolutionInfoDto();
            
            // 销售业务信息
            PdmsSolutionDto solutionMain = pdmsSolutionInfoDto.getSolutionMain();
            // 获取产品信息
            List<PdmsProdInfoDto> productList = getSolutionProdResp.getProductList();
            PdmsProdInfoDto pdmsProdInfoDto = productList.get(0);
            PdmsProdRiskInfoDto pdmsProdRiskInfoDto = pdmsProdInfoDto.getPdmsProdRiskInfoList().get(0);
            
            // 取最大的缴费截止时间
            if(lastPlanDate == null) {
                lastPlanDate = new DateTime(orderDto.getOrderMain().getStartDate()).addDay(solutionMain.getCreditPeriod());
            }else {
                if(lastPlanDate.before(new DateTime(orderDto.getOrderMain().getStartDate()).addDay(solutionMain.getCreditPeriod()))) {
                    lastPlanDate = new DateTime(orderDto.getOrderMain().getStartDate()).addDay(solutionMain.getCreditPeriod());
                }
            }
            
            // 保存订单信息(并产生orderMainId)
            BigInteger orderMainId = this.saveOrderMain(shopOrderInfoDto, orderDto, orderCode, userId, solutionMain, pdmsProdInfoDto, pdmsProdRiskInfoDto, operateUser);
            
            // 合作方信息
            this.saveOrderPartner(orderDto, orderCode, orderMainId, userId, pdmsSolutionInfoDto, operateUser);
			
            // 业务员信息
            this.saveOrderSalesman(orderDto, orderCode, orderMainId, userId, pdmsSolutionInfoDto, operateUser);

            // 保存险别列表信息(优先取传进来,否则取方案里配置)
            BigDecimal sumFee = this.saveItemKind(orderDto, orderCode, orderMainId, userId, pdmsProdRiskInfoDto, operateUser);
            
            // 累计订单总金额
            orderSumFee = orderSumFee.add(sumFee);
            
            // 保存订单商品关联信息(险种代码、名称都取方案里边配置的)
            ShopOrderGoodsDto shopOrderGoodsDto = this.saveOrderGoods(orderDto, orderCode, orderMainId, userId, sumFee, pdmsProdInfoDto, operateUser);
            
            // 保存条款信息列表(优先取传进来,否则取方案里配置)
            this.saveOrderClauses(orderDto, orderCode, orderMainId, userId, pdmsProdRiskInfoDto, operateUser);
            
            // 保存特约信息列表(优先取传进来,否则取方案里配置)
            this.saveOrderSpecialClauses(orderDto, orderCode, orderMainId, userId, pdmsProdRiskInfoDto, operateUser);
            
            // 保存限额信息列表(优先取传进来,否则取方案里配置)
            this.saveOrderLimit(orderDto, orderCode, orderMainId, userId, pdmsProdRiskInfoDto, operateUser);
            
            // 保存免赔信息列表(优先取传进来,否则取方案里配置)
            this.saveOrderDeductible(orderDto, orderCode, orderMainId, userId, pdmsProdRiskInfoDto, operateUser);
            
            // 保存赔付信息列表(优先取传进来,否则取方案里配置)
            this.saveOrderClaim(orderDto, orderCode, orderMainId, userId, pdmsProdRiskInfoDto, operateUser);
            
            // 保存支付信息
            this.saveOrderPayinfo(shopOrderGoodsDto, orderDto, orderCode, orderMainId, userId, operateUser);

            // 保存客户信息列表
            this.saveOrderCustomer(orderDto, orderCode, orderMainId, userId, operateUser);
            
            // 保存家财标的信息
            this.saveOrderProperty(orderDto, orderCode, orderMainId, userId, pdmsProdRiskInfoDto, operateUser);
            
            // 保存动态标的信息
            this.saveOrderDynamicItem(shopOrderGoodsDto, orderDto, orderCode, orderMainId, userId, solutionMain, pdmsProdRiskInfoDto, operateUser);
            
            // 保存动态清单信息列表
            this.saveOrderDynamicList(shopOrderGoodsDto, orderDto, orderCode, orderMainId, userId, solutionMain, operateUser);
            
            // 保存货运险标的及标的详情信息
            this.saveOrderCargo(orderDto, orderCode, orderMainId, userId, operateUser);
            
            // 保存货运险缴费计划(返回缴费计划第一期金额)
            BigDecimal paymentPlan1SumFeeSub = this.saveOrderPaymentPlan(orderDto, orderCode, orderMainId, userId, operateUser);
            
            // 累计订单缴费计划金额
            paymentPlan1SumFee = paymentPlan1SumFee.add(paymentPlan1SumFeeSub);
            
            // 保存再保分期信息
            this.saveOrderPaymentPlanReins(orderDto, orderCode, orderMainId, userId, operateUser);
            
            // 保存意健险标的信息
            this.saveOrderItemAcciInfo(orderDto, orderCode, orderMainId, userId, operateUser);
            
            // 保存意健险险种动态信息
            this.saveOrderRiskDynamic(shopOrderGoodsDto, orderDto, orderCode, orderMainId, userId, operateUser);
            
            // 保存佣金信息列表
            this.saveOrderCommission(orderDto, orderCode, orderMainId, userId, solutionMain, operateUser);
            
            // 保存共保信息列表
            this.saveOrderCoinsurance(orderDto, orderCode, orderMainId, userId, solutionMain, operateUser);
            
            // 保存共保责任列表
            this.saveOrderCoinsLiab(orderDto, orderCode, orderMainId, userId, solutionMain, operateUser);
            
            //保存救援信息
            this.saveOrderRescue(orderDto, orderCode, orderMainId, userId, pdmsProdInfoDto,operateUser);
        }
        
        // 更新订单详情信息
        shopOrderInfoDto.setUserId(userId);
        shopOrderInfoDto.setOrderCode(orderCode);
        shopOrderInfoDto.setOrderStatus("0"); // 0-未确认
        if(shopOrderInfoDto.getOrderAmount() == null) {
            shopOrderInfoDto.setOrderAmount(orderSumFee);
        }
        shopOrderInfoDto.setGoodsAmount(shopOrderInfoDto.getOrderAmount());
        shopOrderInfoDto.setInvalidFlag(0);
        shopOrderInfoDto.setUpdatedUser(operateUser);
        shopOrderInfoDto.setUpdatedDate(new Date());
        shopOrderInfoService.updateByPrimaryKeyNotNull(shopOrderInfoDto);
        
        // 更新订单支付信息
        shopOrderPayinfoDto.setUserId(userId);
        if(paymentPlan1SumFee.doubleValue() > 0) {
            shopOrderPayinfoDto.setPayAmount(paymentPlan1SumFee);
        } else {
            shopOrderPayinfoDto.setPayAmount(shopOrderInfoDto.getOrderAmount()); // 支付金额
        }
        // 卡式保单业务信息
        if(activationCardInfoResp != null) {
            shopOrderPayinfoDto.setPayNo(activationCardInfoResp.getBusinessNo());
            shopOrderPayinfoDto.setActivationCardNo(activationCardInfoResp.getActivationCardNo());
            shopOrderPayinfoDto.setDocVerCode(activationCardInfoResp.getDocVerCode());
        }
        shopOrderPayinfoDto.setPayStatus("0"); // 未支付
        shopOrderPayinfoDto.setInvalidFlag(0);
        shopOrderPayinfoDto.setUpdatedUser(operateUser);
        shopOrderPayinfoDto.setUpdatedDate(new Date());
        shopOrderPayinfoDto.setBankAccount(orderPayinfoDto.getBankAccount());
        shopOrderPayinfoDto.setBankName(orderPayinfoDto.getBankName());
        shopOrderPayinfoDto.setPayeeName(orderPayinfoDto.getPayeeName());
        if(orderPayinfoDto.getPlanDate() != null) { // 计划缴费截止日期 add 20160712
            shopOrderPayinfoDto.setPlanDate(orderPayinfoDto.getPlanDate());
        }else {
            shopOrderPayinfoDto.setPlanDate(lastPlanDate);
        }
        shopOrderPayinfoDto.setOrderCode(null);
        Condition shopPayInfoCond = new Condition(ShopOrderPayinfoDto.class);
        shopPayInfoCond.createCriteria().andEqualTo("payinfoId", shopOrderPayinfoDto.getPayinfoId())
                                        .andEqualTo("orderCode", orderCode);
        shopOrderPayinfoService.updateByConditionNotNull(shopOrderPayinfoDto, shopPayInfoCond);
            
        // 更新订单配送信息
        ShopOrderShippingDto shopOrderShippingDto = createOrderReq.getShopOrderShipping();
        if(shopOrderShippingDto != null) {
            ShopOrderShippingDto orderShippingDto = new ShopOrderShippingDto();
            orderShippingDto.setUserId(userId);
            orderShippingDto.setOrderCode(orderCode);
            orderShippingDto = shopOrderShippingService.selectOne(orderShippingDto);
            boolean updateFlag = true;
            if(orderShippingDto == null) {
                updateFlag = false;
                orderShippingDto = new ShopOrderShippingDto();
            }
            ObjectUtil.copyProperties(orderShippingDto, shopOrderShippingDto); // copySimpleObject(Object target, Object source)
            orderShippingDto.setUserId(userId);
            orderShippingDto.setOrderCode(orderCode);
            orderShippingDto.setAddTime(new Date());
            orderShippingDto.setShippingStatus("0"); // 0-未发货
            orderShippingDto.setOrderAmount(shopOrderInfoDto.getOrderAmount()); // 订单金额
            orderShippingDto.setInvalidFlag(0);
            orderShippingDto.setUpdatedUser(operateUser);
            orderShippingDto.setUpdatedDate(new Date());
            if(updateFlag) {
                orderShippingDto.setOrderCode(null);
                Condition shopShippingCond = new Condition(ShopOrderShippingDto.class);
                shopShippingCond.createCriteria().andEqualTo("shippingId", orderShippingDto.getShippingId())
                                                 .andEqualTo("orderCode", orderCode);
                shopOrderShippingService.updateByConditionNotNull(orderShippingDto, shopShippingCond);
            }else {
                orderShippingDto.setCreatedUser(operateUser);
                orderShippingDto.setCreatedDate(new Date());
                shopOrderShippingService.insertNotNull(orderShippingDto);
            }
        }
        
        return orderCode;
    }
    
    /**
     * 新增订单处理
     * 
     * @Author lujicong
     * @Date: 2015-12-23
     * @Version: 1.0
     * @param userId
     * @param orderCode
     * @param createOrderReq
     * @throws Exception 
     */
    private BigInteger addOrder(BigInteger userId, BigInteger orderCode, CreateOrderReq createOrderReq) throws Exception {
        /**
         * 处理流程：
         * 1、生成订单号;
         * 2、订单信息列表：
         *    1>获取协议信息
         *      协议号不为空，直接取协议信息
         *      若协议号为空,
         *          优先通过订单来源和险种代码查找业务映射信息
         *      取方案优先取协议里配置的协议号,若协议里配置方案号为空则取传进来的.
         *    2>保存订单信息;
         *    3>保存险别信息列表;
         *    4>保存订单商品关联信息;
         *    5>保存条款信息列表;
         *    6>保存特约信息列表;
         *    7>保存限额信息列表;
         *    8>保存免赔信息列表;
         *    9>保存支付信息;
         *    10>保存客户信息列表;
         *    11>保存订单业务单关联信息;
         *    12>保存家财标的信息;
         *    13>保存动态标的信息列表;
         *    14>保存动态清单信息列表;
         *    15>保存货运险标的信息;
         *    16>保存货运险缴费计划信息;
         *    17>保存意外险标的信息
         *           17.1保存意外险人员清单信息
         *                   17.1.1保存意外险受益人清单信息
         *    18>保存意健险险种动态信息
         *    19>保存手续费信息;
         *    20>保存共保信息列表;
         *    21>保存共保责任列表;
         * 3、保存订单详情信息;
         * 4、保存订单号与用户ID索引信息;
         * 5、保存订单支付信息;
         * 6、保存订单配送信息;
         */
        
        // 保存订单详情信息
        String id = idGenerator.generate();
        if (StringUtil.isEmpty(id)) {
            throw new MessageException("生成订单号失败");
        }
        
        // 操作用户
        String operateUser = String.valueOf(userId);
        
        // 订单号
        orderCode = new BigInteger(id);
        
        // 订单详情信息
        ShopOrderInfoDto shopOrderInfoDto = createOrderReq.getShopOrderInfo();
        
        // 订单扩展信息
        ShopOrderExtendInfoDto shopOrderExtendInfo = createOrderReq.getShopOrderExtendInfo();
        
        // 获取卡式保单业务信息
        QueryActivationCardInfoResp activationCardInfoResp = null;
        if(shopOrderExtendInfo != null){
        	Object cardStatus = redisTemplate.get(ODST_PREFIX + shopOrderExtendInfo.getActivationCardNo());
        	if(StringUtil.isEmpty((String) cardStatus)){
        		activationCardInfoResp = this.getActivationCardInfo(shopOrderExtendInfo);
        	}else{
        		throw new MessageException("激活卡处于待激活状态，请勿重新激活");
        	}
    	}
        
        // 订单总金额
        BigDecimal orderSumFee = DecimalUtil.toBigDecimal(0.00);
        
        Date lastPlanDate = null;
        
        // 缴费计划第一期金额
        BigDecimal paymentPlan1SumFee = DecimalUtil.toBigDecimal(0.00);
        
        // 订单信息列表
        List<OrderDto> orderList = createOrderReq.getOrderList();
        for(OrderDto orderDto : orderList) {
            
            // 获取销售方案信息
        	GetSolutionProdResp getSolutionProdResp = this.getPdmsSolutionProdInfo(shopOrderInfoDto, activationCardInfoResp, orderDto, orderCode, operateUser);
            
            PdmsSolutionInfoDto pdmsSolutionInfoDto = getSolutionProdResp.getPdmsSolutionInfoDto();
            // 销售业务信息
            PdmsSolutionDto solutionMain = pdmsSolutionInfoDto.getSolutionMain();
            // 获取产品信息
            List<PdmsProdInfoDto> productList = getSolutionProdResp.getProductList();
            PdmsProdInfoDto pdmsProdInfoDto = productList.get(0);
            PdmsProdRiskInfoDto pdmsProdRiskInfoDto = pdmsProdInfoDto.getPdmsProdRiskInfoList().get(0);
            
            // 取最大的缴费截止时间
            if(lastPlanDate == null) {
                lastPlanDate = new DateTime(orderDto.getOrderMain().getStartDate()).addDay(solutionMain.getCreditPeriod());
            }else {
                if(lastPlanDate.before(new DateTime(orderDto.getOrderMain().getStartDate()).addDay(solutionMain.getCreditPeriod()))) {
                    lastPlanDate = new DateTime(orderDto.getOrderMain().getStartDate()).addDay(solutionMain.getCreditPeriod());
                }
            }
            
            // 保存订单信息(并产生orderMainId)
            BigInteger orderMainId = this.saveOrderMain(shopOrderInfoDto, orderDto, orderCode, userId, solutionMain, pdmsProdInfoDto, pdmsProdRiskInfoDto, operateUser);
			
            // 合作方信息
            this.saveOrderPartner(orderDto, orderCode, orderMainId, userId, pdmsSolutionInfoDto, operateUser);
			
            // 业务员信息
            this.saveOrderSalesman(orderDto, orderCode, orderMainId, userId, pdmsSolutionInfoDto, operateUser);

            // 保存险别列表信息(优先取传进来,否则取方案里配置)
            BigDecimal sumFee = this.saveItemKind(orderDto, orderCode, orderMainId, userId, pdmsProdRiskInfoDto, operateUser);
            
            // 累计订单总金额
            orderSumFee = orderSumFee.add(sumFee);
            
            // 保存订单商品关联信息(险种代码、名称都取方案里边配置的)
            ShopOrderGoodsDto shopOrderGoodsDto = this.saveOrderGoods(orderDto, orderCode, orderMainId, userId, sumFee, pdmsProdInfoDto, operateUser);
            
            // 保存条款信息列表(优先取传进来,否则取方案里配置)
            this.saveOrderClauses(orderDto, orderCode, orderMainId, userId, pdmsProdRiskInfoDto, operateUser);
            
            // 保存特约信息列表(优先取传进来,否则取方案里配置)
            this.saveOrderSpecialClauses(orderDto, orderCode, orderMainId, userId, pdmsProdRiskInfoDto, operateUser);
            
            // 保存限额信息列表(优先取传进来,否则取方案里配置)
            this.saveOrderLimit(orderDto, orderCode, orderMainId, userId, pdmsProdRiskInfoDto, operateUser);
            
            // 保存免赔信息列表(优先取传进来,否则取方案里配置)
            this.saveOrderDeductible(orderDto, orderCode, orderMainId, userId, pdmsProdRiskInfoDto, operateUser);
            
            // 保存赔付信息列表(优先取传进来,否则取方案里配置)
            this.saveOrderClaim(orderDto, orderCode, orderMainId, userId, pdmsProdRiskInfoDto, operateUser);
            
            // 保存支付信息
            this.saveOrderPayinfo(shopOrderGoodsDto, orderDto, orderCode, orderMainId, userId, operateUser);
            
            // 保存客户信息列表
            this.saveOrderCustomer(orderDto, orderCode, orderMainId, userId, operateUser);
            
            // 保存家财标的信息
            this.saveOrderProperty(orderDto, orderCode, orderMainId, userId, pdmsProdRiskInfoDto, operateUser);
            
            // 保存动态标的信息
            this.saveOrderDynamicItem(shopOrderGoodsDto, orderDto, orderCode, orderMainId, userId, solutionMain, pdmsProdRiskInfoDto, operateUser);
            
            // 保存动态清单信息列表
            this.saveOrderDynamicList(shopOrderGoodsDto, orderDto, orderCode, orderMainId, userId, solutionMain, operateUser);
            
            // 保存货运险标的及标的详情信息
            this.saveOrderCargo(orderDto, orderCode, orderMainId, userId, operateUser);
            
            // 保存货运险缴费计划(返回缴费计划第一期金额)
            BigDecimal paymentPlan1SumFeeSub = this.saveOrderPaymentPlan(orderDto, orderCode, orderMainId, userId, operateUser);
            
            // 保存再保分期信息
            this.saveOrderPaymentPlanReins(orderDto, orderCode, orderMainId, userId, operateUser);
            
            // 累计订单缴费计划金额
            paymentPlan1SumFee = paymentPlan1SumFee.add(paymentPlan1SumFeeSub);
            
            // 保存意健险标的信息
            this.saveOrderItemAcciInfo(orderDto, orderCode, orderMainId, userId, operateUser);
            
            // 保存意健险险种动态信息
            this.saveOrderRiskDynamic(shopOrderGoodsDto, orderDto, orderCode, orderMainId, userId, operateUser);
	        
            // 保存佣金信息列表
            this.saveOrderCommission(orderDto, orderCode, orderMainId, userId, solutionMain, operateUser);
            
            // 保存共保信息列表
            this.saveOrderCoinsurance(orderDto, orderCode, orderMainId, userId, solutionMain, operateUser);
            
            // 保存共保责任列表
            this.saveOrderCoinsLiab(orderDto, orderCode, orderMainId, userId, solutionMain, operateUser);
            
            //保存救援信息
            this.saveOrderRescue(orderDto, orderCode, orderMainId, userId, pdmsProdInfoDto,operateUser);
        }
        
        // 保存订单详情表信息
        shopOrderInfoDto.setUserId(userId);
        shopOrderInfoDto.setOrderCode(orderCode);
        shopOrderInfoDto.setOrderStatus("0"); // 0-未确认
        if(shopOrderInfoDto.getOrderAmount() == null) {
            shopOrderInfoDto.setOrderAmount(orderSumFee);
        }
        shopOrderInfoDto.setGoodsAmount(shopOrderInfoDto.getOrderAmount());
        shopOrderInfoDto.setDiscount(DecimalUtil.toBigDecimal(0));
        if(shopOrderInfoDto.getAddTime() == null) {
            shopOrderInfoDto.setAddTime(new Date());
        }
        shopOrderInfoDto.setInvalidFlag(0);
        shopOrderInfoDto.setCreatedUser(operateUser);
        shopOrderInfoDto.setCreatedDate(new Date());
        shopOrderInfoDto.setUpdatedUser(operateUser);
        shopOrderInfoDto.setUpdatedDate(new Date());
        shopOrderInfoService.insertNotNull(shopOrderInfoDto);
        
        // 订单号与用户ID索引信息
        OrderIdxUserIdDto orderIdxUserIdDto = new OrderIdxUserIdDto();
        orderIdxUserIdDto.setOrderCode(orderCode);
        orderIdxUserIdDto.setUserId(userId);
        orderIdxUserIdService.insertNotNull(orderIdxUserIdDto);
        
        // 保存订单支付信息 
        ShopOrderPayinfoDto shopOrderPayinfoDto = createOrderReq.getShopOrderPayinfo();
        if(shopOrderPayinfoDto == null) {
            shopOrderPayinfoDto = new ShopOrderPayinfoDto();
        }
        shopOrderPayinfoDto.setUserId(userId);
        shopOrderPayinfoDto.setOrderCode(orderCode);
        if(paymentPlan1SumFee.doubleValue() > 0) {
            shopOrderPayinfoDto.setPayAmount(paymentPlan1SumFee);
        } else {
            shopOrderPayinfoDto.setPayAmount(shopOrderInfoDto.getOrderAmount());
        }
        // 卡式保单业务信息
        if(activationCardInfoResp != null) {
            shopOrderPayinfoDto.setPayNo(activationCardInfoResp.getBusinessNo());
            shopOrderPayinfoDto.setActivationCardNo(activationCardInfoResp.getActivationCardNo());
            shopOrderPayinfoDto.setDocVerCode(activationCardInfoResp.getDocVerCode());
        }
        shopOrderPayinfoDto.setPayStatus("0"); // 未支付
        shopOrderPayinfoDto.setInvalidFlag(0);
        shopOrderPayinfoDto.setCreatedUser(operateUser);
        shopOrderPayinfoDto.setCreatedDate(new Date());
        shopOrderPayinfoDto.setUpdatedUser(operateUser);
        shopOrderPayinfoDto.setUpdatedDate(new Date());
        shopOrderPayinfoDto.setBankAccount(shopOrderPayinfoDto.getBankAccount());
        shopOrderPayinfoDto.setBankName(shopOrderPayinfoDto.getBankName());
        shopOrderPayinfoDto.setPayeeName(shopOrderPayinfoDto.getPayeeName());
        if(shopOrderPayinfoDto.getPlanDate() == null) { // 计划缴费截止日期 add 20160712
            shopOrderPayinfoDto.setPlanDate(lastPlanDate);
        }
        shopOrderPayinfoService.insertNotNull(shopOrderPayinfoDto);
        
        // 保存订单配送信息
        ShopOrderShippingDto shopOrderShippingDto = createOrderReq.getShopOrderShipping();
        if (shopOrderShippingDto != null) {
            shopOrderShippingDto.setUserId(userId);
            shopOrderShippingDto.setOrderCode(orderCode);
            shopOrderShippingDto.setAddTime(new Date());
            shopOrderShippingDto.setShippingStatus("0"); // 0-未发货
            shopOrderShippingDto.setOrderAmount(shopOrderInfoDto.getOrderAmount()); // 订单金额
            shopOrderShippingDto.setInvalidFlag(0);
            shopOrderShippingDto.setCreatedUser(operateUser);
            shopOrderShippingDto.setCreatedDate(new Date());
            shopOrderShippingDto.setUpdatedUser(operateUser);
            shopOrderShippingDto.setUpdatedDate(new Date());
            shopOrderShippingService.insertNotNull(shopOrderShippingDto);
        }
        
        if(activationCardInfoResp != null){
	        if("1".equals(activationCardInfoResp.getCardStatus())){
		        try {	// 激活卡待激活状态写入缓存
		            redisTemplate.set(ODST_PREFIX + shopOrderExtendInfo.getActivationCardNo(), "1", 10*1);
		        } catch (Exception e) {
		            logger.error("ODST_["+shopOrderExtendInfo.getActivationCardNo()+"]写入Redis缓存失败," + e);
		        }
			}
        }
        
        return orderCode;
    }
    
    /**
     * 保存共保信息列表
     * @param orderDto
     * @param orderCode
     * @param orderMainId
     * @param userId
     * @param solutionMain
     * @param operateUser
     */
    private void saveOrderCoinsurance(OrderDto orderDto, BigInteger orderCode,
			BigInteger orderMainId, BigInteger userId,
			PdmsSolutionDto solutionMain, String operateUser) {
    	List<OrderCoinsuranceDto> orderCoinsuranceList = orderDto.getCoinsuranceList();
    	if (CollectionUtil.isNotEmpty(orderCoinsuranceList)) {
    		OrderCoinsuranceDto orderCoinsuranceDto = null;
    		for (int i = 0; i < orderCoinsuranceList.size(); i++) {
    			orderCoinsuranceDto = orderCoinsuranceList.get(i);
    			orderCoinsuranceDto.setOrderMainId(orderMainId);
    			orderCoinsuranceDto.setOrderCode(orderCode);
    			orderCoinsuranceDto.setInvalidFlag(0);
    			orderCoinsuranceDto.setCreatedUser(operateUser);
    			orderCoinsuranceDto.setCreatedDate(new Date());
    			orderCoinsuranceDto.setUpdatedUser(operateUser);
    			orderCoinsuranceDto.setUpdatedDate(new Date());
    			orderCoinsuranceService.insertNotNull(orderCoinsuranceDto);
    		}
    	}
	}

    /**
     * 保存共保责任列表
     * @param orderDto
     * @param orderCode
     * @param orderMainId
     * @param userId
     * @param solutionMain
     * @param operateUser
     */
    private void saveOrderCoinsLiab(OrderDto orderDto, BigInteger orderCode,
    		BigInteger orderMainId, BigInteger userId,
    		PdmsSolutionDto solutionMain, String operateUser) {
    	List<OrderCoinsLiabDto> orderCoinsLiabList = orderDto.getCoinsLiabList();
    	if (CollectionUtil.isNotEmpty(orderCoinsLiabList)) {
    		OrderCoinsLiabDto orderCoinsLiabDto = null;
    		for (int i = 0; i < orderCoinsLiabList.size(); i++) {
    			orderCoinsLiabDto = orderCoinsLiabList.get(i);
    			orderCoinsLiabDto.setOrderMainId(orderMainId);
    			orderCoinsLiabDto.setOrderCode(orderCode);
    			orderCoinsLiabDto.setInvalidFlag(0);
    			orderCoinsLiabDto.setCreatedUser(operateUser);
    			orderCoinsLiabDto.setCreatedDate(new Date());
    			orderCoinsLiabDto.setUpdatedUser(operateUser);
    			orderCoinsLiabDto.setUpdatedDate(new Date());
    			orderCoinsLiabService.insertNotNull(orderCoinsLiabDto);
    		}
    	}
    }
    
    /**
     * 保存救援信息
     */
    private void saveOrderRescue(OrderDto orderDto, BigInteger orderCode, BigInteger orderMainId, BigInteger userId, 
    		PdmsProdInfoDto pdmsProdInfoDto, String operateUser) {
    	List<OrderRescueDto> orderRescueDtoList = orderDto.getRescueList();
    	if (ToolUtils.contains(pdmsProdInfoDto.getIsRescue(), "1")) {
    		int serialNo = 1;
    		OrderRescueDto orderRescueDto = new OrderRescueDto();
    		orderRescueDto.setRescueCompany(pdmsProdInfoDto.getRescueCompany());
    		orderRescueDto.setRescueProgram(pdmsProdInfoDto.getRescueProgram());
    		orderRescueDto.setRescuePlan(pdmsProdInfoDto.getAssProCode());
    		orderRescueDto.setUserId(userId);
    		orderRescueDto.setOrderMainId(orderMainId);
    		orderRescueDto.setOrderCode(orderCode);
    		orderRescueDto.setSerialNo(serialNo);
    		orderRescueDto.setInvalidFlag(0);
    		orderRescueDto.setCreatedDate(new Date());
    		orderRescueDto.setCreatedUser(operateUser);
    		orderRescueDto.setUpdatedDate(new Date());
    		orderRescueDto.setUpdatedUser(operateUser);
    		if (CollectionUtil.isNotEmpty(orderRescueDtoList)) {
    			orderRescueDto.setRescueProgram(orderRescueDtoList.get(0).getRescueProgram());
    		}
    		orderRescueService.insertNotNull(orderRescueDto);
    	}
    }
    
	/**
     * 获取卡式保单业务信息
     * @return
     * @throws Exception
     */
    private QueryActivationCardInfoResp getActivationCardInfo(ShopOrderExtendInfoDto shopOrderExtendInfo) throws Exception {
        QueryActivationCardInfoResp activationCardInfoResp = null;
        if (shopOrderExtendInfo != null) {
            String activationCardNo = shopOrderExtendInfo.getActivationCardNo();
            String password = shopOrderExtendInfo.getActivationPassword();
            if (StringUtil.isNotEmpty(activationCardNo)) {
                RequestMessage requestMessageObj = new RequestMessage();
                QueryActivationCardInfoReq queryActivationCardInfoReq = new QueryActivationCardInfoReq();
                queryActivationCardInfoReq.setActivationCardNo(activationCardNo);
                queryActivationCardInfoReq.setActivationPassword(password);
                requestMessageObj.getData().setQueryActivationCardInfoReq(queryActivationCardInfoReq);

                ResponseMessage responseMessage = this.queryActivationCardInfo(requestMessageObj);
                if (SUCCESS_CODE.equals(responseMessage.getCode())) {
                    activationCardInfoResp = responseMessage.getData().getQueryActivationCardInfoResp();
                    if (!"1".equals(activationCardInfoResp.getCardStatus())) {
                        throw new MessageException(activationCardInfoResp.getCardMessage());
                    }
                } else {
                	logger.error("请求TRANS系统查询激活卡信息失败,响应状态为:{},响应信息为:{}",responseMessage.getStatusCode(),responseMessage.getMessage());
                    throw new MessageException(responseMessage.getStatusCode(),responseMessage.getMessage());
                }
            }
        }
        return activationCardInfoResp;
    }
    
    /**
     * 保存订单信息
     * 
     * @param orderDto
     * @return
     */
    private BigInteger saveOrderMain(ShopOrderInfoDto shopOrderInfoDto, OrderDto orderDto, BigInteger orderCode, BigInteger userId,
    		PdmsSolutionDto solutionMain, PdmsProdInfoDto pdmsProdInfoDto, PdmsProdRiskInfoDto pdmsProdRiskInfoDto, String operateUser) {
        String orderMainId = idGenerator.generate();
        if (StringUtil.isEmpty(orderMainId)) {
            throw new MessageException("生成订单主表单号失败");
        }

        BigInteger orderId = new BigInteger(orderMainId);

        OrderMainDto orderMainDto = orderDto.getOrderMain();
        orderMainDto.setOrderMainId(orderId);
        orderMainDto.setOrderCode(orderCode);

        Date orderDate = orderMainDto.getOrderDate(); // 签单日期
        if (orderDate == null) {
            orderDate = new Date();
        }
        orderMainDto.setUserId(userId);
        orderMainDto.setOrderDate(orderDate);
        orderMainDto.setBusinessSourceId(shopOrderInfoDto.getReferer()); // 订单来源
        orderMainDto.setStatus("0"); // 0-初始状态
        
        orderMainDto.setAgrtCode(solutionMain.getAgrtCode()); // 协议号
        orderMainDto.setBusinessMode(solutionMain.getBusinessMode());
        orderMainDto.setBusinessSource(solutionMain.getBusinessSource());
        orderMainDto.setChannelDetailCode(solutionMain.getChannelDetailCode());
        orderMainDto.setChannelTip(solutionMain.getChannelTip());
        orderMainDto.setCompanyCode(solutionMain.getCompanyCode());//出单机构
        orderMainDto.setIssueCompany(solutionMain.getIssueCompany());//业务归属机构
        orderMainDto.setPioneerCode(solutionMain.getPioneerCode());
        orderMainDto.setSalesmanCode(solutionMain.getSalesmanCode());
        orderMainDto.setSalesmanName(solutionMain.getSalesmanName());
        orderMainDto.setTeamCode(solutionMain.getTeamCode());
        orderMainDto.setTeamName(solutionMain.getTeamName());
        orderMainDto.setIntermediaryCode(solutionMain.getIntermediaryCode());
        orderMainDto.setAgreementNo(solutionMain.getAgreementNo());
        orderMainDto.setSolutionCode(solutionMain.getSolutionCode());
        orderMainDto.setOrgId(solutionMain.getOrgId()); // 组织机构代码
        orderMainDto.setAgreementNoSub(solutionMain.getAgreementNoSub());
        orderMainDto.setCreditPeriod(solutionMain.getCreditPeriod());
        orderMainDto.setProjectCode(pdmsProdInfoDto.getProdCode());
		if (StringUtil.isEmpty(orderMainDto.getPoaSerialNo())) {
			orderMainDto.setPoaSerialNo(solutionMain.getPoaSerialNo());
		}
        orderMainDto.setCodInd(solutionMain.getCodInd()); // 是否见费出单
        orderMainDto.setDataSource(solutionMain.getDataSource());
        orderMainDto.setProductClass(pdmsProdInfoDto.getProductClass());
        if (StringUtil.isEmpty(orderMainDto.getRationType())) {
        	orderMainDto.setRationType(pdmsProdRiskInfoDto.getRationType());
        }
        if (StringUtil.isEmpty(orderMainDto.getProductName())) {
        	orderMainDto.setProductName(solutionMain.getAgrtName());// 产品工厂销售方案名称作为产品名称存储
        }
        
		/** RM-3959 快景-国内货物运输保险-中台系统 最低保费限制中台动态传值 by hguoqing */
		if (orderMainDto.getLowestPremium() == null) {
			orderMainDto.setLowestPremium(DecimalUtil.toBigDecimal("0"));
		} else {
			orderMainDto.setLowestPremium(orderMainDto.getLowestPremium());
		}
		/** RM-3959 快景-国内货物运输保险-中台系统 最低保费限制中台动态传值 by hguoqing */

        orderMainDto.setInvalidFlag(0);
        orderMainDto.setCreatedUser(operateUser);
        orderMainDto.setCreatedDate(new Date());
        orderMainDto.setUpdatedUser(operateUser);
        orderMainDto.setUpdatedDate(new Date());
        orderMainService.insertNotNull(orderMainDto);

        return orderId;
    }
    
    /**
     * 保存合作方信息列表
     */
	private void saveOrderPartner(OrderDto orderDto, BigInteger orderCode, BigInteger orderMainId, BigInteger userId, 
			PdmsSolutionInfoDto pdmsSolutionInfoDto, String operateUser) {
		List<PdmsSolutionIntermediaryDto> solutionIntermediaryList = pdmsSolutionInfoDto.getSolutionIntermediaryList();
		if (CollectionUtil.isNotEmpty(solutionIntermediaryList)) {
			OrderPartnerDto orderPartnerDto = null;
		    for (int i = 0; i < solutionIntermediaryList.size(); i++) {
		    	PdmsSolutionIntermediaryDto solutionIntermediaryDto = solutionIntermediaryList.get(i);
		    	orderPartnerDto = new OrderPartnerDto();
		    	orderPartnerDto.setPartnerType(solutionIntermediaryDto.getIntermediaryKind());
		    	orderPartnerDto.setPartnerFlag(solutionIntermediaryDto.getIntermediaryFlag());
		    	orderPartnerDto.setPartnerCode(solutionIntermediaryDto.getIntermediaryCode());
		    	orderPartnerDto.setPartnerName(solutionIntermediaryDto.getIntermediaryName());
		    	orderPartnerDto.setPartnerAlias(solutionIntermediaryDto.getIntermediaryAlias());
		    	orderPartnerDto.setUserId(userId);
		    	orderPartnerDto.setOrderMainId(orderMainId);
		    	orderPartnerDto.setOrderCode(orderCode);
		    	orderPartnerDto.setSerialNo(i+1);
		    	orderPartnerDto.setInvalidFlag(0);
		    	orderPartnerDto.setCreatedUser(operateUser);
		    	orderPartnerDto.setCreatedDate(new Date());
		    	orderPartnerDto.setUpdatedUser(operateUser);
		    	orderPartnerDto.setUpdatedDate(new Date());
		    	orderPartnerService.insertNotNull(orderPartnerDto);
		    }
	    }
	}
    
	/**
     * 保存业务员信息列表
     */
	private void saveOrderSalesman(OrderDto orderDto, BigInteger orderCode, BigInteger orderMainId, BigInteger userId, 
			PdmsSolutionInfoDto pdmsSolutionInfoDto, String operateUser) {
		List<PdmsSolutionSalesmanDto> solutionSalesmanList = pdmsSolutionInfoDto.getSolutionSalesmanList();
		if (CollectionUtil.isEmpty(solutionSalesmanList)) {
			throw new MessageException("业务员信息列表不能为空");
		}
		
		OrderSalesmanDto orderSalesmanDto = null;
		for (int i = 0; i < solutionSalesmanList.size(); i++) {
			PdmsSolutionSalesmanDto solutionSalesmanDto = solutionSalesmanList.get(i);
			orderSalesmanDto = new OrderSalesmanDto();
			orderSalesmanDto.setSerialNo(i+1);
			orderSalesmanDto.setSalesmanFlag(solutionSalesmanDto.getSalesFlag());
			orderSalesmanDto.setSalesmanCode(solutionSalesmanDto.getSalesmanCode());
			orderSalesmanDto.setSalesmanName(solutionSalesmanDto.getSalesmanName());
			orderSalesmanDto.setTeamCode(solutionSalesmanDto.getTeamCode());
			orderSalesmanDto.setTeamName(solutionSalesmanDto.getTeamName());
			orderSalesmanDto.setUserId(userId);
			orderSalesmanDto.setOrderMainId(orderMainId);
			orderSalesmanDto.setOrderCode(orderCode);
			orderSalesmanDto.setInvalidFlag(0);
			orderSalesmanDto.setCreatedUser(operateUser);
			orderSalesmanDto.setCreatedDate(new Date());
			orderSalesmanDto.setUpdatedUser(operateUser);
			orderSalesmanDto.setUpdatedDate(new Date());
			orderSalesmanService.insertNotNull(orderSalesmanDto);
		}
	}
	
    /**
     * 保存险别信息
     * 
     * @return
     */
    private BigDecimal saveItemKind(OrderDto orderDto, BigInteger orderCode, BigInteger orderMainId, BigInteger userId, 
    		PdmsProdRiskInfoDto pdmsProdRiskInfoDto, String operateUser) {
        List<OrderItemkindDto> itemkindList = orderDto.getItemkindList();
        if (CollectionUtil.isEmpty(itemkindList)) {
            itemkindList = new ArrayList<OrderItemkindDto>();
            List<PdmsProductKindDto> productKindList = pdmsProdRiskInfoDto.getProductKindList();
            OrderItemkindDto itemkindDto = null;
            for (int i = 0; i < productKindList.size(); i++) {
            	PdmsProductKindDto productKindDto = productKindList.get(i);
                itemkindDto = new OrderItemkindDto();
                itemkindDto.setOrderMainId(orderMainId);
                itemkindDto.setItemNo(1);
                itemkindDto.setSerialNo(productKindDto.getSerialNo());
                itemkindDto.setKindCode(productKindDto.getKindCode());
                itemkindDto.setKindName(productKindDto.getKindName());
                itemkindDto.setAmount(productKindDto.getAmount());
                itemkindDto.setPremium(productKindDto.getPremium());
                itemkindDto.setRate(productKindDto.getRate());
                itemkindDto.setKindInd(productKindDto.getKindInd());
                itemkindDto.setCalculateInd(productKindDto.getCalculateInd());
                itemkindList.add(itemkindDto);
            }
        }
        if (CollectionUtil.isEmpty(itemkindList)) {
            throw new MessageException("险别信息列表不能为空");
        }
        OrderItemkindDto orderItemkindDto = null;
        BigDecimal sumFee = DecimalUtil.toBigDecimal(0.00);
        for (int i = 0; i < itemkindList.size(); i++) {
            orderItemkindDto = itemkindList.get(i);
            sumFee = sumFee.add(orderItemkindDto.getPremium());
            if (orderItemkindDto.getItemNo() == null) {
            	orderItemkindDto.setItemNo(1);
            }
            if (orderItemkindDto.getSerialNo() == null) {
            	orderItemkindDto.setSerialNo(i+1);
            }
            orderItemkindDto.setItemkindId(null);
            orderItemkindDto.setUserId(userId);
            orderItemkindDto.setOrderMainId(orderMainId);
            orderItemkindDto.setOrderCode(orderCode);
            orderItemkindDto.setInvalidFlag(0);
            orderItemkindDto.setCreatedUser(operateUser);
            orderItemkindDto.setCreatedDate(new Date());
            orderItemkindDto.setUpdatedUser(operateUser);
            orderItemkindDto.setUpdatedDate(new Date());
            orderItemkindService.insertNotNull(orderItemkindDto);
        }
        return sumFee;
    }
    
    /**
     * 订单商品关联信息(险种代码、名称都取方案里边配置的)
     */
    private ShopOrderGoodsDto saveOrderGoods(OrderDto orderDto, BigInteger orderCode, BigInteger orderMainId, BigInteger userId, 
    		BigDecimal sumFee, PdmsProdInfoDto pdmsProdInfoDto, String operateUser) {
        PdmsProdRiskInfoDto pdmsProdRiskInfoDto = pdmsProdInfoDto.getPdmsProdRiskInfoList().get(0);
        
        ShopOrderGoodsDto shopOrderGoodsDto = orderDto.getOrderGoods();
        if (shopOrderGoodsDto == null) {
            shopOrderGoodsDto = new ShopOrderGoodsDto();
            shopOrderGoodsDto.setGoodsNumber(1);
        }
        shopOrderGoodsDto.setGoodsId(pdmsProdRiskInfoDto.getRiskCode());
        shopOrderGoodsDto.setGoodsName(pdmsProdInfoDto.getProdName());
        shopOrderGoodsDto.setUserId(userId);
        shopOrderGoodsDto.setOrderCode(orderCode);
        shopOrderGoodsDto.setGoodsNo(orderMainId);
        if (shopOrderGoodsDto.getGoodsPrice() == null) {
            shopOrderGoodsDto.setGoodsPrice(sumFee);
        }
        /* shopOrderGoodsDto.setGoodsNumber(1); */
        shopOrderGoodsDto.setGoodsType("1"); // 1：订单主体(保险类);2：商品;3：礼品 目前没用上给默认值
        shopOrderGoodsDto.setInvalidFlag(0);
        shopOrderGoodsDto.setCreatedUser(operateUser);
        shopOrderGoodsDto.setCreatedDate(new Date());
        shopOrderGoodsDto.setUpdatedUser(operateUser);
        shopOrderGoodsDto.setUpdatedDate(new Date());
        shopOrderGoodsService.insertNotNull(shopOrderGoodsDto);

        return shopOrderGoodsDto;
    }
    
    /**
     * 保存条款信息列表(优先取传进来,否则取方案里配置)
     */
    private void saveOrderClauses(OrderDto orderDto, BigInteger orderCode, BigInteger orderMainId, BigInteger userId, 
    		PdmsProdRiskInfoDto pdmsProdRiskInfoDto, String operateUser) {
        List<OrderClausesDto> clausesList = orderDto.getClausesList();
        if (CollectionUtil.isEmpty(clausesList)) {
            clausesList = new ArrayList<OrderClausesDto>();
            List<PdmsClauseDto> productClauseList = pdmsProdRiskInfoDto.getProductClauseList();
            OrderClausesDto orderClausesDto = null;
            for (int i = 0; i < productClauseList.size(); i++) {
            	PdmsClauseDto pdmsClauseDto = productClauseList.get(i);
                orderClausesDto = new OrderClausesDto();
                orderClausesDto.setUserId(userId);
                orderClausesDto.setOrderMainId(orderMainId);
                orderClausesDto.setClauseCode(pdmsClauseDto.getClauseCode());
                orderClausesDto.setClauseLongName(pdmsClauseDto.getClauseName());
                orderClausesDto.setClauses(pdmsClauseDto.getClauseContext());
                orderClausesDto.setDisplayNo(pdmsClauseDto.getDisplayNo());
                clausesList.add(orderClausesDto);
            }
        }

        OrderClausesDto orderClausesDto = null;
        for (int i = 0; i < clausesList.size(); i++) {
            orderClausesDto = clausesList.get(i);
            orderClausesDto.setClausesId(null);
            orderClausesDto.setUserId(userId);
            orderClausesDto.setOrderMainId(orderMainId);
            orderClausesDto.setOrderCode(orderCode);
            orderClausesDto.setSerialNo(i+1);
            orderClausesDto.setInvalidFlag(0);
            orderClausesDto.setCreatedUser(operateUser);
            orderClausesDto.setCreatedDate(new Date());
            orderClausesDto.setUpdatedUser(operateUser);
            orderClausesDto.setUpdatedDate(new Date());
            orderClausesService.insertNotNull(orderClausesDto);
        }
    }
    
    /**
     * 保存特约信息列表(优先取传进来,否则取方案里配置)
     */
    private void saveOrderSpecialClauses(OrderDto orderDto, BigInteger orderCode, BigInteger orderMainId, BigInteger userId,
    		PdmsProdRiskInfoDto pdmsProdRiskInfoDto, String operateUser) {
        List<OrderSpecialClausesDto> specialClausesList = orderDto.getSpecialClausesList();
        if (CollectionUtil.isEmpty(specialClausesList)) {
            specialClausesList = new ArrayList<OrderSpecialClausesDto>();
            List<PdmsProductSpecialClsDto> productSpecialClsList = pdmsProdRiskInfoDto.getProductSpecialClsList();
            OrderSpecialClausesDto specialClausesDto = null;
            for (int i = 0; i < productSpecialClsList.size(); i++) {
            	PdmsProductSpecialClsDto pdmsProductSpecialClsDto = productSpecialClsList.get(i);
                specialClausesDto = new OrderSpecialClausesDto();
                specialClausesDto.setUserId(userId);
                specialClausesDto.setOrderMainId(orderMainId);
                specialClausesDto.setSerialNo(pdmsProductSpecialClsDto.getSerialNo());
                specialClausesDto.setClauseCode(pdmsProductSpecialClsDto.getClauseCode());
                specialClausesDto.setClauseCName(pdmsProductSpecialClsDto.getClauseName());
                specialClausesDto.setClausecontext(pdmsProductSpecialClsDto.getClauseContext());
                specialClausesDto.setDisplayNo(pdmsProductSpecialClsDto.getSerialNo());
                specialClausesList.add(specialClausesDto);
            }
        }

        OrderSpecialClausesDto orderSpecialClausesDto = null;
        for (int i = 0; i < specialClausesList.size(); i++) {
            orderSpecialClausesDto = specialClausesList.get(i);
            orderSpecialClausesDto.setSpecialClausesId(null);
            orderSpecialClausesDto.setUserId(userId);
            orderSpecialClausesDto.setOrderMainId(orderMainId);
            orderSpecialClausesDto.setOrderCode(orderCode);
            orderSpecialClausesDto.setInvalidFlag(0);
            orderSpecialClausesDto.setCreatedUser(operateUser);
            orderSpecialClausesDto.setCreatedDate(new Date());
            orderSpecialClausesDto.setUpdatedUser(operateUser);
            orderSpecialClausesDto.setUpdatedDate(new Date());
            orderSpecialClausesService.insertNotNull(orderSpecialClausesDto);
        }
    }
    
    /**
     * 保存限额信息列表(优先取传进来,否则取方案里配置)
     */
    private void saveOrderLimit(OrderDto orderDto, BigInteger orderCode, BigInteger orderMainId, BigInteger userId, 
    		PdmsProdRiskInfoDto pdmsProdRiskInfoDto, String operateUser) {
        List<OrderLimitDto> limitList = orderDto.getLimitList();
        if (CollectionUtil.isEmpty(limitList)) {
            limitList = new ArrayList<OrderLimitDto>();
            List<PdmsProductLimitDto> productLimitList = pdmsProdRiskInfoDto.getProductLimitList();
            OrderLimitDto orderLimitDto = null;
            for (int i = 0; i < productLimitList.size(); i++) {
            	PdmsProductLimitDto pdmsProductLimitDto = productLimitList.get(i);
                orderLimitDto = new OrderLimitDto();
                ObjectUtil.copyProperties(orderLimitDto, pdmsProductLimitDto);
                orderLimitDto.setItemNo(1);
                orderLimitDto.setUserId(userId);
                orderLimitDto.setOrderMainId(orderMainId);
                limitList.add(orderLimitDto);
            }
        }

        OrderLimitDto orderLimitDto = null;
        for (int i = 0; i < limitList.size(); i++) {
            orderLimitDto = limitList.get(i);
            orderLimitDto.setLimitId(null);
            orderLimitDto.setUserId(userId);
            orderLimitDto.setOrderMainId(orderMainId);
            orderLimitDto.setOrderCode(orderCode);
            orderLimitDto.setInvalidFlag(0);
            orderLimitDto.setCreatedUser(operateUser);
            orderLimitDto.setCreatedDate(new Date());
            orderLimitDto.setUpdatedUser(operateUser);
            orderLimitDto.setUpdatedDate(new Date());
            if (orderLimitDto.getItemNo() == null) {
            	orderLimitDto.setItemNo(1);
            }
            orderLimitService.insertNotNull(orderLimitDto);
        }
    }
    
    /**
     * 保存免赔信息列表(优先取传进来,否则取方案里配置)
     */
    private void saveOrderDeductible(OrderDto orderDto, BigInteger orderCode, BigInteger orderMainId, BigInteger userId, 
    		PdmsProdRiskInfoDto pdmsProdRiskInfoDto, String operateUser) {
        List<OrderDeductibleDto> deductibleList = orderDto.getDeductibleList();
        if (CollectionUtil.isEmpty(deductibleList)) {
            deductibleList = new ArrayList<OrderDeductibleDto>();
            if (pdmsProdRiskInfoDto != null) {
            	List<PdmsProductDeductibleDto> productDeductibleList = pdmsProdRiskInfoDto.getProductDeductibleList();
                OrderDeductibleDto orderDeductibleDto = null;
                for (int i = 0; i < productDeductibleList.size(); i++) {
                	PdmsProductDeductibleDto pdmsProductDeductibleDto = productDeductibleList.get(i);
                    orderDeductibleDto = new OrderDeductibleDto();
                    ObjectUtil.copyProperties(orderDeductibleDto, pdmsProductDeductibleDto);
                    orderDeductibleDto.setLiabCode(pdmsProductDeductibleDto.getLimitCode());
                    orderDeductibleDto.setUserId(userId);
                    orderDeductibleDto.setOrderMainId(orderMainId);
                    orderDeductibleDto.setItemNo(1);
                    deductibleList.add(orderDeductibleDto);
                }
            }
        }

        OrderDeductibleDto orderDeductibleDto = null;
        for (int i = 0; i < deductibleList.size(); i++) {
            orderDeductibleDto = deductibleList.get(i);
            orderDeductibleDto.setDeductibleId(null);
            orderDeductibleDto.setUserId(userId);
            orderDeductibleDto.setOrderMainId(orderMainId);
            orderDeductibleDto.setOrderCode(orderCode);
            orderDeductibleDto.setInvalidFlag(0);
            orderDeductibleDto.setCreatedUser(operateUser);
            orderDeductibleDto.setCreatedDate(new Date());
            orderDeductibleDto.setUpdatedUser(operateUser);
            orderDeductibleDto.setUpdatedDate(new Date());
            if (orderDeductibleDto.getItemNo() == null) {
            	orderDeductibleDto.setItemNo(1);
            }
            orderDeductibleService.insertNotNull(orderDeductibleDto);
        }
    }
    
    /**
     * 保存赔付信息列表(优先取传进来,否则取方案里配置)
     */
    private void saveOrderClaim(OrderDto orderDto, BigInteger orderCode, BigInteger orderMainId, BigInteger userId, 
    		PdmsProdRiskInfoDto pdmsProdRiskInfoDto, String operateUser) {
    	List<OrderClaimDto> orderClaimList = orderDto.getOrderClaimList();
    	if (CollectionUtil.isEmpty(orderClaimList)) {
    		orderClaimList = new ArrayList<OrderClaimDto>();
    		if (pdmsProdRiskInfoDto != null) {
    			List<PdmsProductClaimDto> productClaimList = pdmsProdRiskInfoDto.getProductClaimList();
    			OrderClaimDto orderClaimDto = null;
    			for (int i = 0; i < productClaimList.size(); i++) {
    				PdmsProductClaimDto pdmsProductClaimDto = productClaimList.get(i);
    				orderClaimDto = new OrderClaimDto();
    				ObjectUtil.copyProperties(orderClaimDto, pdmsProductClaimDto);
    				orderClaimDto.setUserId(userId);
    				orderClaimDto.setOrderMainId(orderMainId);
    				orderClaimDto.setItemNo(1);
    				orderClaimList.add(orderClaimDto);
    			}
    		}
    	}
    	
    	OrderClaimDto orderClaimDto = null;
    	for (int i = 0; i < orderClaimList.size(); i++) {
    		orderClaimDto = orderClaimList.get(i);
    		orderClaimDto.setUserId(userId);
    		orderClaimDto.setOrderCode(orderCode);
    		orderClaimDto.setOrderMainId(orderMainId);
    		orderClaimDto.setInvalidFlag(0);
    		orderClaimDto.setCreatedUser(operateUser);
    		orderClaimDto.setCreatedDate(new Date());
    		orderClaimDto.setUpdatedUser(operateUser);
    		orderClaimDto.setUpdatedDate(new Date());
    		if (orderClaimDto.getItemNo() == null) {
    			orderClaimDto.setItemNo(1);
    		}
    		orderClaimService.insertNotNull(orderClaimDto);
    	}
    }
    
    /**
     * 保存支付信息
     */
    private void saveOrderPayinfo(ShopOrderGoodsDto shopOrderGoodsDto, OrderDto orderDto, BigInteger orderCode, BigInteger orderMainId,
            BigInteger userId, String operateUser) {
        OrderPayinfoDto orderPayinfoDto = orderDto.getPayinfo();
        if (orderPayinfoDto == null) {
            orderPayinfoDto = new OrderPayinfoDto();
        }
        // 支付信息
        OrderPayinfoDto payinfo = new OrderPayinfoDto();
        payinfo.setUserId(userId);
        payinfo.setOrderMainId(orderMainId);
        payinfo.setOrderCode(orderCode);
        // payinfo.setPayWay(shopOrderPayinfoDto.getPayWay());
        payinfo.setAccountHolder(orderPayinfoDto.getAccountHolder());
        payinfo.setBankAccount(orderPayinfoDto.getBankAccount());
        payinfo.setBankDeposit(orderPayinfoDto.getBankDeposit());
        payinfo.setPayStatus("0"); // 未支付
        payinfo.setPayAmount(shopOrderGoodsDto.getGoodsPrice());
        payinfo.setInvalidFlag(0);
        payinfo.setCreatedUser(operateUser);
        payinfo.setCreatedDate(new Date());
        payinfo.setUpdatedUser(operateUser);
        payinfo.setUpdatedDate(new Date());
        orderPayinfoService.insertNotNull(payinfo);
    }
    
    /**
     * 保存客户信息
     */
    private void saveOrderCustomer(OrderDto orderDto, BigInteger orderCode, BigInteger orderMainId, BigInteger userId,
            String operateUser) {
        List<OrderCustomerDto> customerList = orderDto.getCustomerList();

        /*boolean hasAppli = false;
        boolean hasInsured = false;
        if (StringUtil.isNotEmpty(customerList)) {
            for (OrderCustomerDto customerDto : customerList) {
                if ("1".equals(customerDto.getCustomerFlag())) { // 1:投保人，2：被保险人的值
                    hasAppli = true;
                } else if ("2".equals(customerDto.getCustomerFlag())) {
                    hasInsured = true;
                }
            }
        }

        if (StringUtil.isEmpty(customerList)) {
            customerList = new ArrayList<OrderCustomerDto>();
        }

        if (StringUtil.isNotEmpty(pmAgrtRltdPatyList)) {
            for (PmAgrtRltdPatyDto agrtRltdPatyDto : pmAgrtRltdPatyList) {
                if ("1".equals(agrtRltdPatyDto.getInsuredFlag()) && !hasAppli) {
                    OrderCustomerDto appliCustomer = new OrderCustomerDto();
                    appliCustomer.setCustomerType(agrtRltdPatyDto.getInsuredType());
                    appliCustomer.setCustomerName(agrtRltdPatyDto.getInsuredName());
                    appliCustomer.setDocType(agrtRltdPatyDto.getIdentifyType());
                    appliCustomer.setDocNo(agrtRltdPatyDto.getIdentifyNumber());
                    appliCustomer.setSex(agrtRltdPatyDto.getSex());
                    appliCustomer.setBirthDate(agrtRltdPatyDto.getBirthDate());
                    appliCustomer.setPostCode(agrtRltdPatyDto.getPostCode());
                    appliCustomer.setPhoneNo(agrtRltdPatyDto.getMobilePhone());
                    appliCustomer.setEmail(agrtRltdPatyDto.getEmail());
                    appliCustomer.setCustomerAddress(agrtRltdPatyDto.getInsuredAddress());
                    appliCustomer.setCustomerFlag(agrtRltdPatyDto.getInsuredFlag());
                    appliCustomer.setCustomerSameInd(agrtRltdPatyDto.getAppliSameInd());
                    appliCustomer.setContactName(agrtRltdPatyDto.getContactName());
                    appliCustomer.setOfficePhone(agrtRltdPatyDto.getOfficePhone());
                    appliCustomer.setContactMobile(agrtRltdPatyDto.getContactPhone());
                    customerList.add(appliCustomer);
                } else if ("2".equals(agrtRltdPatyDto.getInsuredFlag()) && !hasInsured) {
                    OrderCustomerDto insureCustomer = new OrderCustomerDto();
                    insureCustomer.setCustomerType(agrtRltdPatyDto.getInsuredType());
                    insureCustomer.setCustomerName(agrtRltdPatyDto.getInsuredName());
                    insureCustomer.setDocType(agrtRltdPatyDto.getIdentifyType());
                    insureCustomer.setDocNo(agrtRltdPatyDto.getIdentifyNumber());
                    insureCustomer.setSex(agrtRltdPatyDto.getSex());
                    insureCustomer.setBirthDate(agrtRltdPatyDto.getBirthDate());
                    insureCustomer.setPostCode(agrtRltdPatyDto.getPostCode());
                    insureCustomer.setPhoneNo(agrtRltdPatyDto.getMobilePhone());
                    insureCustomer.setEmail(agrtRltdPatyDto.getEmail());
                    insureCustomer.setCustomerAddress(agrtRltdPatyDto.getInsuredAddress());
                    insureCustomer.setCustomerFlag(agrtRltdPatyDto.getInsuredFlag());
                    insureCustomer.setCustomerSameInd(agrtRltdPatyDto.getAppliSameInd());
                    insureCustomer.setContactName(agrtRltdPatyDto.getContactName());
                    insureCustomer.setOfficePhone(agrtRltdPatyDto.getOfficePhone());
                    insureCustomer.setContactMobile(agrtRltdPatyDto.getContactPhone());
                    customerList.add(insureCustomer);
                }
            }
        }*/

        if (CollectionUtil.isEmpty(customerList)) {
            throw new MessageException("关系人信息不能为空");
        }

        OrderCustomerDto orderCustomerDto = null;
        for (int i = 0; i < customerList.size(); i++) {
            orderCustomerDto = customerList.get(i);
            orderCustomerDto.setUserId(userId);
            orderCustomerDto.setOrderMainId(orderMainId);
            orderCustomerDto.setOrderCode(orderCode);
            orderCustomerDto.setInvalidFlag(0);
            orderCustomerDto.setCreatedUser(operateUser);
            orderCustomerDto.setCreatedDate(new Date());
            orderCustomerDto.setUpdatedUser(operateUser);
            orderCustomerDto.setUpdatedDate(new Date());
            orderCustomerService.insertNotNull(orderCustomerDto);
        }
    }
    
    /**
     * 保存家财标的信息
     */
    private void saveOrderProperty(OrderDto orderDto, BigInteger orderCode, BigInteger orderMainId, BigInteger userId, 
    		PdmsProdRiskInfoDto pdmsProdRiskInfoDto, String operateUser) {
        OrderPropertyDto orderPropertyDto = orderDto.getProperty();
        if (orderPropertyDto != null) {
            orderPropertyDto.setUserId(userId);
            orderPropertyDto.setOrderMainId(orderMainId);
            orderPropertyDto.setOrderCode(orderCode);
            orderPropertyDto.setRationType(pdmsProdRiskInfoDto.getRationType());
            orderPropertyDto.setInvalidFlag(0);
            orderPropertyDto.setCreatedUser(operateUser);
            orderPropertyDto.setCreatedDate(new Date());
            orderPropertyDto.setUpdatedUser(operateUser);
            orderPropertyDto.setUpdatedDate(new Date());
            orderPropertyService.insertNotNull(orderPropertyDto);
        }
    }
    
    /**
     * 保存动态标的信息
     */
    private void saveOrderDynamicItem(ShopOrderGoodsDto shopOrderGoodsDto, OrderDto orderDto, BigInteger orderCode, BigInteger orderMainId,
            BigInteger userId, PdmsSolutionDto solutionMain, PdmsProdRiskInfoDto pdmsProdRiskInfoDto, String operateUser) {
        List<OrderDynamicItemDto> orderDynamicItemList = orderDto.getDynamicItemList();
        if (CollectionUtil.isNotEmpty(orderDynamicItemList)) {
            OrderDynamicItemDto dynamicItem = null;
            for (int i = 0; i < orderDynamicItemList.size(); i++) {
                dynamicItem = orderDynamicItemList.get(i);
                dynamicItem.setRiskCode(shopOrderGoodsDto.getGoodsId());
                dynamicItem.setPlanCode("0000"); // 单险种
                if (StringUtil.isEmpty(dynamicItem.getRationType())) {
                	dynamicItem.setRationType(pdmsProdRiskInfoDto.getRationType());
                }
                //dynamicItem.setDynamicType(solutionMain.getDynamicType());
                //dynamicItem.setItemCode(solutionMain.getItemCode());
                dynamicItem.setItemNo(i + 1);
                dynamicItem.setUserId(userId);
                dynamicItem.setOrderMainId(orderMainId);
                dynamicItem.setOrderCode(orderCode);
                dynamicItem.setInvalidFlag(0);
                dynamicItem.setCreatedUser(operateUser);
                dynamicItem.setCreatedDate(new Date());
                dynamicItem.setUpdatedUser(operateUser);
                dynamicItem.setUpdatedDate(new Date());
                orderDynamicItemService.insertNotNull(dynamicItem);
            }
        }
    }
    
    /**
     * 保存动态清单信息列表
     */
    private void saveOrderDynamicList(ShopOrderGoodsDto shopOrderGoodsDto, OrderDto orderDto, BigInteger orderCode, BigInteger orderMainId,
            BigInteger userId, PdmsSolutionDto solutionMain, String operateUser) {
        List<OrderDynamicListDto> orderDynamicListList = orderDto.getDynamicListList();
        if (CollectionUtil.isNotEmpty(orderDynamicListList)) {
            OrderDynamicListDto dynamicList = null;
            for (int i = 0; i < orderDynamicListList.size(); i++) {
                dynamicList = orderDynamicListList.get(i);
                dynamicList.setRiskCode(shopOrderGoodsDto.getGoodsId());
                dynamicList.setPlanCode("0000"); // 单险种
                //dynamicList.setDynamicType(solutionMain.getDynamicType());
                //dynamicList.setItemCode(solutionMain.getItemCode());
                if(dynamicList.getItemNo() == null){
                	dynamicList.setItemNo(1);
                }
                if (dynamicList.getListSeqNo() == null) {
                    dynamicList.setListSeqNo(i + 1);
                }
                dynamicList.setUserId(userId);
                dynamicList.setOrderMainId(orderMainId);
                dynamicList.setOrderCode(orderCode);
                dynamicList.setInvalidFlag(0);
                dynamicList.setCreatedUser(operateUser);
                dynamicList.setCreatedDate(new Date());
                dynamicList.setUpdatedUser(operateUser);
                dynamicList.setUpdatedDate(new Date());
                orderDynamicListService.insertNotNull(dynamicList);
            }
        }
    }
    
    /**
     * 保存货运险标的及标的详情信息
     */
    private void saveOrderCargo(OrderDto orderDto, BigInteger orderCode, BigInteger orderMainId, BigInteger userId, String operateUser) {
        OrderCargoDto cargo = orderDto.getCargo();
        List<OrderCargoDtlDto> cargoDtlList = orderDto.getCargoDtlList();
        if (cargo != null) {
            cargo.setUserId(userId);
            cargo.setOrderMainId(orderMainId);
            cargo.setOrderCode(orderCode);
            cargo.setCreatedDate(new Date());
            cargo.setCreatedUser(operateUser);
            cargo.setUpdatedDate(new Date());
            cargo.setUpdatedUser(operateUser);
            orderCargoService.insertNotNull(cargo);

            if (CollectionUtil.isNotEmpty(cargoDtlList)) {
                for (OrderCargoDtlDto cargoDtl : cargoDtlList) {
                    cargoDtl.setUserId(userId);
                    cargoDtl.setOrderMainId(orderMainId);
                    cargoDtl.setOrderCode(orderCode);
                    cargoDtl.setCreatedDate(new Date());
                    cargoDtl.setCreatedUser(operateUser);
                    cargoDtl.setUpdatedDate(new Date());
                    cargoDtl.setUpdatedUser(operateUser);
                    orderCargoDtlService.insertNotNull(cargoDtl);
                }
            }
        }
    }
    
    /**
     * 保存货运险缴费计划
     */
    private BigDecimal saveOrderPaymentPlan(OrderDto orderDto, BigInteger orderCode, BigInteger orderMainId, BigInteger userId, String operateUser) {
        List<OrderPaymentPlanDto> paymentPlanList = orderDto.getPaymentPlan();

        // 缴费计划第一期金额
        BigDecimal paymentPlan1SumFee = DecimalUtil.toBigDecimal(0.00);

        if (CollectionUtil.isNotEmpty(paymentPlanList)) {
            OrderPaymentPlanDto paymentPlanDto = null;
            for (int i = 0; i < paymentPlanList.size(); i++) {
                paymentPlanDto = paymentPlanList.get(i);
                paymentPlanDto.setUserId(userId);
                paymentPlanDto.setOrderMainId(orderMainId);
                paymentPlanDto.setOrderCode(orderCode);
                paymentPlanDto.setCreatedDate(new Date());
                paymentPlanDto.setCreatedUser(operateUser);
                paymentPlanDto.setUpdatedDate(new Date());
                paymentPlanDto.setUpdatedUser(operateUser);
                if (i == 0) {
                    paymentPlan1SumFee = paymentPlanDto.getPlanFee();
                }
                orderCargoPaymentPlanService.insertNotNull(paymentPlanDto);
            }
        }
        return paymentPlan1SumFee;
    }
    
    /**
     * 保存再保分期信息
     */
    private void saveOrderPaymentPlanReins(OrderDto orderDto, BigInteger orderCode, BigInteger orderMainId, BigInteger userId, String operateUser) {
        List<OrderPaymentPlanReinsDto> paymentPlanReinsList = orderDto.getPaymentPlanReins();
        
        if (CollectionUtil.isNotEmpty(paymentPlanReinsList)) {
        	OrderPaymentPlanReinsDto paymentPlanReinsDto = null;
        	for (int i = 0; i<paymentPlanReinsList.size(); i++) {
        		paymentPlanReinsDto = paymentPlanReinsList.get(i);
        		paymentPlanReinsDto.setUserId(userId);
        		paymentPlanReinsDto.setOrderMainId(orderMainId);
        		paymentPlanReinsDto.setOrderCode(orderCode);
        		paymentPlanReinsDto.setCurrency("CNY");
        		paymentPlanReinsDto.setCreatedDate(new Date());
        		paymentPlanReinsDto.setCreatedUser(operateUser);
        		paymentPlanReinsDto.setUpdatedDate(new Date());
        		paymentPlanReinsDto.setUpdatedUser(operateUser);
        		orderPaymentPlanReinsService.insertNotNull(paymentPlanReinsDto);
        	}
        }
    }
    /**
     * 保存意健险标的信息
     */
    private void saveOrderItemAcciInfo(OrderDto orderDto, BigInteger orderCode, BigInteger orderMainId, BigInteger userId,
            String operateUser) {
        List<OrderItemAcciDto> itemAcciList = orderDto.getItemAcciList();
        if (CollectionUtil.isNotEmpty(itemAcciList)) {
            for (OrderItemAcciDto itemAcciDto : itemAcciList) {
                itemAcciDto.setUserId(userId);
                itemAcciDto.setOrderMainId(orderMainId);
                itemAcciDto.setOrderCode(orderCode);
                itemAcciDto.setInvalidFlag(0);
                itemAcciDto.setCreatedUser(operateUser);
                itemAcciDto.setCreatedDate(new Date());
                itemAcciDto.setUpdatedUser(operateUser);
                itemAcciDto.setUpdatedDate(new Date());
                orderItemAcciService.insertNotNull(itemAcciDto);

                // 意外险人员清单
                List<OrderItemAcciLstDto> itemAcciLstDtoList = itemAcciDto.getAcciInsuredList();
                if (CollectionUtil.isNotEmpty(itemAcciLstDtoList)) {
                    for (OrderItemAcciLstDto itemAcciLst : itemAcciLstDtoList) {

                        String acciId = idGenerator.generate();
                        if (StringUtil.isEmpty(acciId)) {
                            throw new MessageException("生成意健险人员清单表id号失败");
                        }

                        itemAcciLst.setAcciListId(new BigInteger(acciId));
                        itemAcciLst.setOrderMainId(orderMainId);
                        itemAcciLst.setOrderCode(orderCode);
                        itemAcciLst.setUserId(userId);
                        itemAcciLst.setItemNo(itemAcciDto.getItemNo());
                        itemAcciLst.setInvalidFlag(0);
                        itemAcciLst.setCreatedUser(operateUser);
                        itemAcciLst.setCreatedDate(new Date());
                        itemAcciLst.setUpdatedUser(operateUser);
                        itemAcciLst.setUpdatedDate(new Date());
                        orderItemAcciLstService.insertNotNull(itemAcciLst);

                        BigInteger acciListId = itemAcciLst.getAcciListId();
                        // 意外险受益人清单
                        List<OrderItemAcciBenDto> itemAcciBenDtoList = itemAcciLst.getAcciBenefitList();
                        if (CollectionUtil.isNotEmpty(itemAcciBenDtoList)) {
                            for (OrderItemAcciBenDto itemAcciBen : itemAcciBenDtoList) {
                                itemAcciBen.setOrderMainId(orderMainId);
                                itemAcciBen.setOrderCode(orderCode);
                                itemAcciBen.setUserId(userId);
                                itemAcciBen.setAcciListId(acciListId);
                                itemAcciBen.setItemNo(itemAcciDto.getItemNo());
                                itemAcciBen.setInvalidFlag(0);
                                itemAcciBen.setCreatedUser(operateUser);
                                itemAcciBen.setCreatedDate(new Date());
                                itemAcciBen.setUpdatedUser(operateUser);
                                itemAcciBen.setUpdatedDate(new Date());
                                orderItemAcciBenService.insertNotNull(itemAcciBen);
                            }
                        }
                    }
                }
            }
        }
    }
    
    /**
     * 保存意健险险种动态信息
     */
    private void saveOrderRiskDynamic(ShopOrderGoodsDto shopOrderGoodsDto, OrderDto orderDto, BigInteger orderCode, 
    		BigInteger orderMainId, BigInteger userId, String operateUser) {
        List<OrderRiskDynamicDto> orderRiskDynamicList = orderDto.getRiskDynamicList();
        if (CollectionUtil.isNotEmpty(orderRiskDynamicList)) {
            OrderRiskDynamicDto orderRiskDynamicDto = null;
            for (int i = 0; i < orderRiskDynamicList.size(); i++) {
                orderRiskDynamicDto = orderRiskDynamicList.get(i);
                orderRiskDynamicDto.setRiskCode(shopOrderGoodsDto.getGoodsId());
                orderRiskDynamicDto.setUserId(userId);
                orderRiskDynamicDto.setOrderMainId(orderMainId);
                orderRiskDynamicDto.setOrderCode(orderCode);
                orderRiskDynamicDto.setInvalidFlag(0);
                orderRiskDynamicDto.setCreatedUser(operateUser);
                orderRiskDynamicDto.setCreatedDate(new Date());
                orderRiskDynamicDto.setUpdatedUser(operateUser);
                orderRiskDynamicDto.setUpdatedDate(new Date());
                orderRiskDynamicService.insertNotNull(orderRiskDynamicDto);
            }
        }
    }
    
    /**
     * 保存佣金信息列表
     */
    private void saveOrderCommission(OrderDto orderDto, BigInteger orderCode, BigInteger orderMainId, BigInteger userId, 
    		PdmsSolutionDto solutionMain, String operateUser) {
        List<OrderCommissionDto> orderCommissionList = orderDto.getCommissionList();
        if (CollectionUtil.isNotEmpty(orderCommissionList)) {
            OrderCommissionDto orderCommissionDto = null;
            for (int i = 0; i < orderCommissionList.size(); i++) {
                orderCommissionDto = orderCommissionList.get(i);
                orderCommissionDto.setUserId(userId);
                orderCommissionDto.setOrderMainId(orderMainId);
                orderCommissionDto.setOrderCode(orderCode);
                orderCommissionDto.setPlanCode("0000");
                orderCommissionDto.setSharerType("0");
                orderCommissionDto.setSharerCode(solutionMain.getIntermediaryCode());
                orderCommissionDto.setSerialNo(i + 1);
                orderCommissionDto.setItemNo(i + 1);
                orderCommissionDto.setInvalidFlag(0);
                orderCommissionDto.setCreatedUser(operateUser);
                orderCommissionDto.setCreatedDate(new Date());
                orderCommissionDto.setUpdatedUser(operateUser);
                orderCommissionDto.setUpdatedDate(new Date());
                orderCommissionService.insertNotNull(orderCommissionDto);
            }
        }
    }
    
    /**
     * 删除订单数据
     */
    private void deleteOrderInfo(ShopOrderGoodsDto goodsDto) {
        BigInteger orderCode = goodsDto.getOrderCode();
        BigInteger delOrderId = goodsDto.getGoodsNo();
        if (delOrderId == null) {
            throw new MessageException("订单商品关联表中商品货号为空");
        }
        // 佣金信息
        OrderCommissionDto commissionDto = new OrderCommissionDto();
        commissionDto.setOrderCode(orderCode);
        commissionDto.setOrderMainId(delOrderId);
        orderCommissionService.delete(commissionDto);
        
        // 共保信息
        OrderCoinsuranceDto coinsuranceDto = new OrderCoinsuranceDto();
        coinsuranceDto.setOrderCode(orderCode);
        coinsuranceDto.setOrderMainId(delOrderId);
        orderCoinsuranceService.delete(coinsuranceDto);
        
        // 共保责任
        OrderCoinsLiabDto coinsLiabDto = new OrderCoinsLiabDto();
        coinsLiabDto.setOrderCode(orderCode);
        coinsLiabDto.setOrderMainId(delOrderId);
        orderCoinsLiabService.delete(coinsLiabDto);

        // 意健险险种动态信息
        OrderRiskDynamicDto riskDynamicDto = new OrderRiskDynamicDto();
        riskDynamicDto.setOrderCode(orderCode);
        riskDynamicDto.setOrderMainId(delOrderId);
        orderRiskDynamicService.delete(riskDynamicDto);

        // 意外险受益人清单信息
        OrderItemAcciBenDto itemAcciBenDto = new OrderItemAcciBenDto();
        itemAcciBenDto.setOrderCode(orderCode);
        itemAcciBenDto.setOrderMainId(delOrderId);
        orderItemAcciBenService.delete(itemAcciBenDto);

        // 意外险人员清单信息
        OrderItemAcciLstDto itemAcciLstDto = new OrderItemAcciLstDto();
        itemAcciLstDto.setOrderCode(orderCode);
        itemAcciLstDto.setOrderMainId(delOrderId);
        orderItemAcciLstService.delete(itemAcciLstDto);

        // 意健险标的信息
        OrderItemAcciDto itemAcciDto = new OrderItemAcciDto();
        itemAcciDto.setOrderCode(orderCode);
        itemAcciDto.setOrderMainId(delOrderId);
        orderItemAcciService.delete(itemAcciDto);

        // 货运险缴费计划信息
        OrderPaymentPlanDto cargoPaymentPlanDto = new OrderPaymentPlanDto();
        cargoPaymentPlanDto.setOrderCode(orderCode);
        cargoPaymentPlanDto.setOrderMainId(delOrderId);
        orderCargoPaymentPlanService.delete(cargoPaymentPlanDto);

        // 货运险标的信息
        OrderCargoDtlDto cargoDtlDto = new OrderCargoDtlDto();
        cargoDtlDto.setOrderCode(orderCode);
        cargoDtlDto.setOrderMainId(delOrderId);
        orderCargoDtlService.delete(cargoDtlDto);

        OrderCargoDto cargoDto = new OrderCargoDto();
        cargoDto.setOrderCode(orderCode);
        cargoDto.setOrderMainId(delOrderId);
        orderCargoService.delete(cargoDto);

        // 动态清单信息
        OrderDynamicListDto dynamicListDto = new OrderDynamicListDto();
        dynamicListDto.setOrderCode(orderCode);
        dynamicListDto.setOrderMainId(delOrderId);
        orderDynamicListService.delete(dynamicListDto);

        // 动态标的信息
        OrderDynamicItemDto dynamicItemDto = new OrderDynamicItemDto();
        dynamicItemDto.setOrderCode(orderCode);
        dynamicItemDto.setOrderMainId(delOrderId);
        orderDynamicItemService.delete(dynamicItemDto);

        // 家财标的信息
        OrderPropertyDto propertyDto = new OrderPropertyDto();
        propertyDto.setOrderCode(orderCode);
        propertyDto.setOrderMainId(delOrderId);
        orderPropertyService.delete(propertyDto);

        // 客户信息列表
        OrderCustomerDto customerDto = new OrderCustomerDto();
        customerDto.setOrderCode(orderCode);
        customerDto.setOrderMainId(delOrderId);
        orderCustomerService.delete(customerDto);

        // 支付信息
        OrderPayinfoDto payinfo = new OrderPayinfoDto();
        payinfo.setOrderCode(orderCode);
        payinfo.setOrderMainId(delOrderId);
        orderPayinfoService.delete(payinfo);

        // 免赔信息列表
        OrderDeductibleDto deductibleDto = new OrderDeductibleDto();
        deductibleDto.setOrderCode(orderCode);
        deductibleDto.setOrderMainId(delOrderId);
        orderDeductibleService.delete(deductibleDto);

        // 限额信息列表
        OrderLimitDto orderLimitDto = new OrderLimitDto();
        orderLimitDto.setOrderCode(orderCode);
        orderLimitDto.setOrderMainId(delOrderId);
        orderLimitService.delete(orderLimitDto);

        // 特约信息列表
        OrderSpecialClausesDto specialClausesDto = new OrderSpecialClausesDto();
        specialClausesDto.setOrderCode(orderCode);
        specialClausesDto.setOrderMainId(delOrderId);
        orderSpecialClausesService.delete(specialClausesDto);

        // 条款信息列表
        OrderClausesDto clausesDto = new OrderClausesDto();
        clausesDto.setOrderCode(orderCode);
        clausesDto.setOrderMainId(delOrderId);
        orderClausesService.delete(clausesDto);

        // 险别信息列表
        OrderItemkindDto itemkindDto = new OrderItemkindDto();
        itemkindDto.setOrderCode(orderCode);
        itemkindDto.setOrderMainId(delOrderId);
        orderItemkindService.delete(itemkindDto);

        // 订单商品关联信息
        ShopOrderGoodsDto orderGoodsDto = new ShopOrderGoodsDto();
        orderGoodsDto.setOrderCode(orderCode);
        orderGoodsDto.setGoodsNo(delOrderId);
        shopOrderGoodsService.delete(orderGoodsDto);

        // 业务员信息
        OrderSalesmanDto salesmanDto = new OrderSalesmanDto();
        salesmanDto.setOrderCode(orderCode);
        salesmanDto.setOrderMainId(delOrderId);
        orderSalesmanService.delete(salesmanDto);
        
        // 合作方信息
        OrderPartnerDto partnerDto = new OrderPartnerDto();
        partnerDto.setOrderCode(orderCode);
        partnerDto.setOrderMainId(delOrderId);
        orderPartnerService.delete(partnerDto);
        
        // 订单信息
        OrderMainDto orderMainDto = new OrderMainDto();
        orderMainDto.setOrderCode(orderCode);
        orderMainDto.setOrderMainId(delOrderId);
        orderMainService.delete(orderMainDto);
        
        //救援信息
        OrderRescueDto  orderRescueDto = new OrderRescueDto();
        orderRescueDto.setOrderCode(orderCode);
        orderRescueDto.setOrderMainId(delOrderId);
        orderRescueService.delete(orderRescueDto);
    }
    
    /**
     * 协议号获取协议方案信息
     * 
     * @param agrtCode
     * @return
     *//*
    private PmResponseMessage getPmAgrtProject(String agrtCode) {
        PmRequestMessage pmRequestMessage = new PmRequestMessage();
        GetPmAgrtProjectReq pmAgrtProjectReq = new GetPmAgrtProjectReq();
        pmAgrtProjectReq.setAgrtCode(agrtCode);
        pmRequestMessage.getData().setGetPmAgrtProjectReq(pmAgrtProjectReq);
        return orderAgrtProjectService.getPmAgrtProject(pmRequestMessage);
    }
    
    *//**
     * 业务映射信息
     * 
     * @param businessMappingDto
     * @return
     *//*
    private PmResponseMessage getPmBizMapping(String userId, String referer, String riskCode) {
        PmRequestMessage pmRequestMessage = new PmRequestMessage();
        GetPmBizMappingReq pmBizMappingReq = new GetPmBizMappingReq();
        pmBizMappingReq.setUserId(userId);
        pmBizMappingReq.setReferer(referer);
        pmBizMappingReq.setRiskCode(riskCode);
        pmRequestMessage.getData().setGetPmBizMappingReq(pmBizMappingReq);
        return orderAgrtProjectService.getPmBizMapping(pmRequestMessage);
    }
    
    *//**
     * 方案信息
     * 
     * @param businessMappingDto
     * @return
     *//*
    private PmResponseMessage getPmProject(String projectCode) {
        PmRequestMessage pmRequestMessage = new PmRequestMessage();
        GetPmProjectReq pmProjectReq = new GetPmProjectReq();
        pmProjectReq.setProjectCode(projectCode);
        pmRequestMessage.getData().setGetPmProjectReq(pmProjectReq);
        return orderAgrtProjectService.getPmProject(pmRequestMessage);
    }*/
    
    /**
     * 销售方案、产品代码、险种代码获取销售方案对应险种信息
     * 
     * @param agrtCode
     * @return
     * @throws Exception 
     */
    public PdmsResponseMessage getPdmsSolutionProd(String agrtCode, String projectCode, String riskCode) throws Exception {
    	PdmsRequestMessage requestMessage = new PdmsRequestMessage();
    	GetSolutionProdReq getSolutionProdReq = new GetSolutionProdReq();
    	getSolutionProdReq.setAgrtCode(agrtCode);
    	getSolutionProdReq.setProdCode(projectCode);
    	getSolutionProdReq.setRiskCode(riskCode);
        requestMessage.getData().setGetPdmsSolutionProdReq(getSolutionProdReq);
        return orderSolutionProdService.getPdmsSolutionProd(requestMessage);
    }
    
    /**
     * 产品代码、险种代码获取产品信息对应险种信息
     * 
     * @param agrtCode
     * @return
     * @throws Exception 
     */
    private PdmsResponseMessage getPdmsProduct(String projectCode, String riskCode) throws Exception {
    	PdmsRequestMessage requestMessage = new PdmsRequestMessage();
    	GetPdmsProductReq getPdmsProductReq = new GetPdmsProductReq();
    	getPdmsProductReq.setProdCode(projectCode);
    	getPdmsProductReq.setRiskCode(riskCode);
        requestMessage.getData().setGetPdmsProductReq(getPdmsProductReq);
        return orderSolutionProdService.getPdmsSolutionProd(requestMessage);
    }
    
    /**
     * 5.2.2 查询订单详细信息
     * 
     * @Author: lujicong
     * @Date: 2015-12-24
     * @Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    @Override
    public ResponseMessage queryOrderDetailInfo(RequestMessage requestMessageObj) throws Exception {
        ResponseMessage responseMessage = new ResponseMessage();
        QueryOrderDetailInfoReq queryOrderDetailInfoReq = requestMessageObj.getData().getQueryOrderDetailInfoReq();

        String uid = requestMessageObj.getUserId(); // 用户ID
        String queryOrderCode = queryOrderDetailInfoReq.getOrderCode();

        // 传入信息校验
        StringBuffer checkMsg = new StringBuffer();
        if (StringUtil.isEmpty(uid)) {
            checkMsg.append("用户ID不能为空,");
        }  else {
            if(!StringUtil.isInteger(uid)){
            	checkMsg.append("用户ID不能含有字符串");
            }
        }
        if (StringUtil.isEmpty(queryOrderCode)) {
            checkMsg.append("订单号不能为空,");
        }
        if (StringUtil.isNotEmpty(checkMsg.toString())) {
            responseMessage.setMessage(checkMsg.substring(0, checkMsg.length() - 1));
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }
        // 用户ID
        BigInteger orderCode = new BigInteger(queryOrderCode);

        // 获取订单详情信息
        ShopOrderDto shopOrderDto = this.getOrderDetailInfo(orderCode);

        QueryOrderDetailInfoResp queryOrderDetailInfoResp = new QueryOrderDetailInfoResp();
        queryOrderDetailInfoResp.setShopOrderInfo(shopOrderDto.getShopOrderInfo());
        queryOrderDetailInfoResp.setShopOrderPayinfo(shopOrderDto.getShopOrderPayinfo());
        queryOrderDetailInfoResp.setShopOrderShipping(shopOrderDto.getShopOrderShipping());
        queryOrderDetailInfoResp.setOrderList(shopOrderDto.getOrderList());
        responseMessage.getData().setQueryOrderDetailInfoResp(queryOrderDetailInfoResp);

        responseMessage.setMessage(SUCCESS_MSG);
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);

        return responseMessage;
    }
    
    /**
     * 获取订单详情信息
     * 
     * <p>
     * User: lujicong
     * 
     * @Date: 2015-12-25
     * @Version: 1.0
     * @param userId
     * @param orderCode
     * @return
     */
    @Override
    public ShopOrderDto getOrderDetailInfo(BigInteger orderCode) {
        ShopOrderDto shopOrderDto = new ShopOrderDto();

        // 查询订单详情信息
        ShopOrderInfoDto shopOrderInfoDto = new ShopOrderInfoDto();
        shopOrderInfoDto.setOrderCode(orderCode);
        shopOrderInfoDto = shopOrderInfoService.selectByPrimaryKey(shopOrderInfoDto);
        if (shopOrderInfoDto == null) {
            throw new MessageException("该订单不存在");
        }
        shopOrderDto.setShopOrderInfo(shopOrderInfoDto);

        // 查询订单支付信息
        ShopOrderPayinfoDto shopOrderPayinfoDto = new ShopOrderPayinfoDto();
        shopOrderPayinfoDto.setOrderCode(orderCode);
        shopOrderPayinfoDto.setInvalidFlag(0);
        shopOrderPayinfoDto = shopOrderPayinfoService.selectOne(shopOrderPayinfoDto);
        shopOrderDto.setShopOrderPayinfo(shopOrderPayinfoDto);

        // 查询订单配送信息
        ShopOrderShippingDto shopOrderShippingDto = new ShopOrderShippingDto();
        shopOrderShippingDto.setOrderCode(orderCode);
        shopOrderShippingDto.setInvalidFlag(0);
        shopOrderShippingDto = shopOrderShippingService.selectOne(shopOrderShippingDto);
        shopOrderDto.setShopOrderShipping(shopOrderShippingDto);

        // 订单商品关联信息列表
        ShopOrderGoodsDto queryOrderGoodsDto = new ShopOrderGoodsDto();
        queryOrderGoodsDto.setOrderCode(orderCode);
        queryOrderGoodsDto.setInvalidFlag(0);
        List<ShopOrderGoodsDto> shopOrderGoodsList = shopOrderGoodsService.select(queryOrderGoodsDto);

        // 订单信息列表
        BigInteger orderId = null;
        OrderDto orderDto = null;
        List<OrderDto> orderList = new ArrayList<OrderDto>();
        if (CollectionUtil.isNotEmpty(shopOrderGoodsList)) {
            for (ShopOrderGoodsDto goodsDto : shopOrderGoodsList) {
                orderId = goodsDto.getGoodsNo();
                orderDto = new OrderDto();

                // 订单信息
                OrderMainDto orderMainDto = new OrderMainDto();
                orderMainDto.setOrderCode(orderCode);
                orderMainDto.setOrderMainId(orderId);
                orderMainDto = orderMainService.selectOne(orderMainDto);
                orderDto.setOrderMain(orderMainDto);

                // 合作方信息列表
                OrderPartnerDto orderPartnerDto = new OrderPartnerDto();
                orderPartnerDto.setOrderCode(orderCode);
                orderPartnerDto.setOrderMainId(orderId);
                List<OrderPartnerDto> partnerList = orderPartnerService.select(orderPartnerDto);
                orderDto.setPartnerList(partnerList);
				
                // 业务员信息列表
                OrderSalesmanDto orderSalesmanDto = new OrderSalesmanDto();
                orderSalesmanDto.setOrderCode(orderCode);
                orderSalesmanDto.setOrderMainId(orderId);
                List<OrderSalesmanDto> salesmanList = orderSalesmanService.select(orderSalesmanDto);
                orderDto.setSalesmanList(salesmanList);
                
                // 订单商品关联信息
                orderDto.setOrderGoods(goodsDto);

                // 险别信息列表
                OrderItemkindDto orderItemkindDto = new OrderItemkindDto();
                orderItemkindDto.setOrderCode(orderCode);
                orderItemkindDto.setOrderMainId(orderId);
                orderItemkindDto.setInvalidFlag(0);
                List<OrderItemkindDto> itemkindList = orderItemkindService.select(orderItemkindDto);
                orderDto.setItemkindList(itemkindList);

                // 条款信息列表
                OrderClausesDto orderClausesDto = new OrderClausesDto();
                orderClausesDto.setOrderCode(orderCode);
                orderClausesDto.setOrderMainId(orderId);
                orderClausesDto.setInvalidFlag(0);
                List<OrderClausesDto> clausesList = orderClausesService.select(orderClausesDto);
                orderDto.setClausesList(clausesList);

                // 特别约定信息列表
                OrderSpecialClausesDto orderSpecialClausesDto = new OrderSpecialClausesDto();
                orderSpecialClausesDto.setOrderCode(orderCode);
                orderSpecialClausesDto.setOrderMainId(orderId);
                orderSpecialClausesDto.setInvalidFlag(0);
                List<OrderSpecialClausesDto> orderSpecialClausesList = orderSpecialClausesService.select(orderSpecialClausesDto);
                orderDto.setSpecialClausesList(orderSpecialClausesList);

                // 限额信息列表
                OrderLimitDto orderLimitDto = new OrderLimitDto();
                orderLimitDto.setOrderCode(orderCode);
                orderLimitDto.setOrderMainId(orderId);
                orderLimitDto.setInvalidFlag(0);
                List<OrderLimitDto> orderLimitList = orderLimitService.select(orderLimitDto);
                orderDto.setLimitList(orderLimitList);

                // 免赔信息列表
                OrderDeductibleDto orderDeductibleDto = new OrderDeductibleDto();
                orderDeductibleDto.setOrderCode(orderCode);
                orderDeductibleDto.setOrderMainId(orderId);
                orderDeductibleDto.setInvalidFlag(0);
                List<OrderDeductibleDto> orderDeductibleList = orderDeductibleService.select(orderDeductibleDto);
                orderDto.setDeductibleList(orderDeductibleList);

                // 支付信息
                OrderPayinfoDto orderPayinfoDto = new OrderPayinfoDto();
                orderPayinfoDto.setOrderCode(orderCode);
                orderPayinfoDto.setOrderMainId(orderId);
                orderPayinfoDto.setInvalidFlag(0);
                orderPayinfoDto = orderPayinfoService.selectOne(orderPayinfoDto);
                orderDto.setPayinfo(orderPayinfoDto);

                // 客户信息列表
                OrderCustomerDto orderCustomerDto = new OrderCustomerDto();
                orderCustomerDto.setOrderCode(orderCode);
                orderCustomerDto.setOrderMainId(orderId);
                orderCustomerDto.setInvalidFlag(0);
                List<OrderCustomerDto> customerList = orderCustomerService.select(orderCustomerDto);
                orderDto.setCustomerList(customerList);

                // 意健险人员清单列表
                OrderItemAcciLstDto orderItemAcciLstDto = new OrderItemAcciLstDto();
                orderItemAcciLstDto.setOrderCode(orderCode);
                orderItemAcciLstDto.setOrderMainId(orderId);
                orderItemAcciLstDto.setInvalidFlag(0);
                List<OrderItemAcciLstDto> acciLstList = orderItemAcciLstService.select(orderItemAcciLstDto);
                orderDto.setAcciLstList(acciLstList);

                // 家财标的信息
                OrderPropertyDto orderPropertyDto = new OrderPropertyDto();
                orderPropertyDto.setOrderCode(orderCode);
                orderPropertyDto.setOrderMainId(orderId);
                orderPropertyDto.setInvalidFlag(0);
                orderPropertyDto = orderPropertyService.selectOne(orderPropertyDto);
                orderDto.setProperty(orderPropertyDto);

                // 动态标的信息
                OrderDynamicItemDto orderDynamicItemDto = new OrderDynamicItemDto();
                orderDynamicItemDto.setOrderCode(orderCode);
                orderDynamicItemDto.setOrderMainId(orderId);
                orderDynamicItemDto.setInvalidFlag(0);
                List<OrderDynamicItemDto> orderDynamicItemList = orderDynamicItemService.select(orderDynamicItemDto);
                orderDto.setDynamicItemList(orderDynamicItemList);

                // 动态清单信息
                OrderDynamicListDto orderDynamicListDto = new OrderDynamicListDto();
                orderDynamicListDto.setOrderCode(orderCode);
                orderDynamicListDto.setOrderMainId(orderId);
                orderDynamicListDto.setInvalidFlag(0);
                List<OrderDynamicListDto> orderDynamicListList = orderDynamicListService.select(orderDynamicListDto);
                orderDto.setDynamicListList(orderDynamicListList);

                // 货运险标的信息
                OrderCargoDto orderCargoDto = new OrderCargoDto();
                orderCargoDto.setOrderCode(orderCode);
                orderCargoDto.setOrderMainId(orderId);
                orderCargoDto.setInvalidFlag(0);
                orderCargoDto = orderCargoService.selectOne(orderCargoDto);
                orderDto.setCargo(orderCargoDto);

                // 货运险标的详情信息
                OrderCargoDtlDto orderCargoDtlDto = new OrderCargoDtlDto();
                orderCargoDtlDto.setOrderCode(orderCode);
                orderCargoDtlDto.setOrderMainId(orderId);
                orderCargoDtlDto.setInvalidFlag(0);
                List<OrderCargoDtlDto> orderCargoDtlList = orderCargoDtlService.select(orderCargoDtlDto);
                orderDto.setCargoDtlList(orderCargoDtlList);

                // 货运险缴费计划
                OrderPaymentPlanDto orderPaymentPlanDto = new OrderPaymentPlanDto();
                orderPaymentPlanDto.setOrderCode(orderCode);
                orderPaymentPlanDto.setOrderMainId(orderId);
                orderPaymentPlanDto.setInvalidFlag(0);
                List<OrderPaymentPlanDto> orderCargoPaymentPlanList = orderCargoPaymentPlanService.select(orderPaymentPlanDto);
                orderDto.setPaymentPlan(orderCargoPaymentPlanList);

                // 意健险险种动态标的
                OrderRiskDynamicDto orderRiskDynamicDto = new OrderRiskDynamicDto();
                orderRiskDynamicDto.setOrderCode(orderCode);
                orderRiskDynamicDto.setOrderMainId(orderId);
                orderRiskDynamicDto.setInvalidFlag(0);
                List<OrderRiskDynamicDto> orderRiskDynamicDtoList = orderRiskDynamicService.select(orderRiskDynamicDto);
                orderDto.setRiskDynamicList(orderRiskDynamicDtoList);

                // 意健险标的信息
                OrderItemAcciDto orderItemAcciDto = new OrderItemAcciDto();
                orderItemAcciDto.setOrderCode(orderCode);
                orderItemAcciDto.setOrderMainId(orderId);
                orderItemAcciDto.setInvalidFlag(0);
                List<OrderItemAcciDto> itemAcciList = orderItemAcciService.select(orderItemAcciDto);
                if (CollectionUtil.isNotEmpty(itemAcciList)) {
                    for (OrderItemAcciDto orderItemAcci : itemAcciList) {
                        // 意健险人员清单
                        OrderItemAcciLstDto orderItemAcciLst = new OrderItemAcciLstDto();
                        orderItemAcciLst.setOrderCode(orderCode);
                        orderItemAcciLst.setOrderMainId(orderId);
                        orderItemAcciLst.setItemNo(orderItemAcci.getItemNo());
                        orderItemAcciLst.setInvalidFlag(0);
                        List<OrderItemAcciLstDto> orderItemAcciLstDtoList = orderItemAcciLstService.select(orderItemAcciLst);
                        if (CollectionUtil.isNotEmpty(orderItemAcciLstDtoList)) {
                            for (OrderItemAcciLstDto itemAcciLstDto : orderItemAcciLstDtoList) {
                                BigInteger acciLstId = itemAcciLstDto.getAcciListId();
                                // 意外险受益人清单
                                OrderItemAcciBenDto orderItemAcciBenDto = new OrderItemAcciBenDto();
                                orderItemAcciBenDto.setOrderCode(orderCode);
                                orderItemAcciBenDto.setAcciListId(acciLstId);
                                orderItemAcciBenDto.setOrderMainId(orderId);
                                orderItemAcciBenDto.setItemNo(orderItemAcci.getItemNo());
                                orderItemAcciBenDto.setInvalidFlag(0);
                                List<OrderItemAcciBenDto> orderItemAcciBenDtoList = orderItemAcciBenService.select(orderItemAcciBenDto);
                                itemAcciLstDto.setAcciBenefitList(orderItemAcciBenDtoList);
                            }
                        }
                        orderItemAcci.setAcciInsuredList(orderItemAcciLstDtoList);
                    }
                    orderDto.setItemAcciList(itemAcciList);
                }

                // 佣金信息列表
                OrderCommissionDto orderCommissionDto = new OrderCommissionDto();
                orderCommissionDto.setOrderCode(orderCode);
                orderCommissionDto.setOrderMainId(orderId);
                orderCommissionDto.setInvalidFlag(0);
                List<OrderCommissionDto> orderCommissionList = orderCommissionService.select(orderCommissionDto);
                orderDto.setCommissionList(orderCommissionList);
                
                // 赔付信息列表
                OrderClaimDto orderClaimDto = new OrderClaimDto();
                orderClaimDto.setOrderCode(orderCode);
                orderClaimDto.setOrderMainId(orderId);
                orderClaimDto.setInvalidFlag(0);
                List<OrderClaimDto> orderClaimList = orderClaimService.select(orderClaimDto);
                orderDto.setOrderClaimList(orderClaimList);
                
                // 共保信息列表
                OrderCoinsuranceDto orderCoinsuranceDto = new OrderCoinsuranceDto();
                orderCoinsuranceDto.setOrderCode(orderCode);
                orderCoinsuranceDto.setOrderMainId(orderId);
                orderCoinsuranceDto.setInvalidFlag(0);
                List<OrderCoinsuranceDto> orderCoinsuranceList = orderCoinsuranceService.select(orderCoinsuranceDto);
                orderDto.setCoinsuranceList(orderCoinsuranceList);
                
                // 共保责任列表
                OrderCoinsLiabDto orderCoinsLiabDto = new OrderCoinsLiabDto();
                orderCoinsLiabDto.setOrderCode(orderCode);
                orderCoinsLiabDto.setOrderMainId(orderId);
                orderCoinsLiabDto.setInvalidFlag(0);
                List<OrderCoinsLiabDto> orderCoinsLiabList = orderCoinsLiabService.select(orderCoinsLiabDto);
                orderDto.setCoinsLiabList(orderCoinsLiabList);
                
                // 救援信息表
                OrderRescueDto orderRescueDto = new OrderRescueDto();
                orderRescueDto.setOrderCode(orderCode);
                orderRescueDto.setOrderMainId(orderId);
                orderRescueDto.setInvalidFlag(0);
                List<OrderRescueDto> orderRescueList = orderRescueService.select(orderRescueDto);
                orderDto.setRescueList(orderRescueList);
                
                // 再保分期信息表
                OrderPaymentPlanReinsDto orderPaymentPlanReinsDto = new OrderPaymentPlanReinsDto();
                orderPaymentPlanReinsDto.setOrderCode(orderCode);
                orderPaymentPlanReinsDto.setOrderMainId(orderId);
                orderCoinsLiabDto.setInvalidFlag(0);
                List<OrderPaymentPlanReinsDto> orderPaymentPlanReinsList = orderPaymentPlanReinsService.select(orderPaymentPlanReinsDto);
                orderDto.setPaymentPlanReins(orderPaymentPlanReinsList);

                orderList.add(orderDto);
            }
        }
        shopOrderDto.setOrderList(orderList);

        return shopOrderDto;
    }
    
    /**
     * 5.2.3 订单转投保
     * 
     * @Author: lujicong
     * @Date: 2015-12-24
     * @Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
    public ResponseMessage orderToProposal(RequestMessage requestMessageObj) throws Exception {
        ResponseMessage responseMessage = new ResponseMessage();
        OrderToProposalReq orderToProposalReq = requestMessageObj.getData().getOrderToProposalReq();
        // 用户ID
        String uid = requestMessageObj.getUserId();
        // 订单号
        String orderTmpCode = orderToProposalReq.getOrderCode();

        // 传入信息校验
        StringBuffer checkMsg = new StringBuffer();
        if (StringUtil.isEmpty(uid)) {
            checkMsg.append("用户ID不能为空,");
        }
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

        BigInteger userId = new BigInteger(uid);
        BigInteger orderCode = new BigInteger(orderTmpCode);

        // 更新订单详情信息
        ShopOrderInfoDto shopOrderInfoDto = new ShopOrderInfoDto();
        shopOrderInfoDto.setUserId(userId);
        shopOrderInfoDto.setOrderCode(orderCode);
        shopOrderInfoDto.setOrderStatus("1"); // 1-已确认
        shopOrderInfoDto.setConfirmTime(new Date());
        shopOrderInfoDto.setUpdatedUser(uid);
        shopOrderInfoDto.setUpdatedDate(new Date());
        shopOrderInfoService.updateByPrimaryKeyNotNull(shopOrderInfoDto);

        // 处理成功返回
        OrderToProposalResp orderToProposalResp = new OrderToProposalResp();
        orderToProposalResp.setOrderStatus("1");
        List<CallBackOrderInfoDto> callBackOrderInfoList = new ArrayList<CallBackOrderInfoDto>();
        callBackOrderInfoList.add(new CallBackOrderInfoDto());
        orderToProposalResp.setCallBackOrderInfoList(callBackOrderInfoList);
        responseMessage.getData().setOrderToProposalResp(orderToProposalResp);

        responseMessage.setMessage(SUCCESS_MSG);
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);

        return responseMessage;
    }
    
    /**
     * 5.2.4 回写订单信息
     * 
     * @Author: lujicong
     * @Date: 2015-12-24
     * @Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
    public ResponseMessage callBackOrderInfo(RequestMessage requestMessageObj) throws Exception {
        ResponseMessage responseMessage = new ResponseMessage();
        CallBackOrderInfoReq callBackOrderInfoReq = requestMessageObj.getData().getCallBackOrderInfoReq();

        // 用户ID
        String uid = requestMessageObj.getUserId();
        // 订单号
        String orderTmpCode = callBackOrderInfoReq.getOrderCode();
        // 订单状态 0-未确认,1-已确认,2-已完成
        String orderStatus = callBackOrderInfoReq.getOrderStatus();
        // 操作类型 0：订单转投保成功回写订单信息 1：转保单成功回写订单信息
        String actionType = callBackOrderInfoReq.getActionType();
        // 回写订单信息列表
        List<CallBackOrderInfoDto> callBackOrderInfoList = callBackOrderInfoReq.getCallBackOrderInfoList();

        // 传入信息校验
        StringBuffer checkMsg = new StringBuffer();
        if (StringUtil.isEmpty(uid)) {
            checkMsg.append("用户ID不能为空,");
        }
        if (StringUtil.isEmpty(orderTmpCode)) {
            checkMsg.append("订单号不能为空,");
        }
        if (StringUtil.isEmpty(orderStatus)) {
            checkMsg.append("订单状态不能为空,");
        }
        if (StringUtil.isEmpty(actionType)) {
            checkMsg.append("操作类型不能为空,");
        }
        if (CollectionUtil.isEmpty(callBackOrderInfoList)) {
            checkMsg.append("回写订单信息列表不能为空,");
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

        if ("0".equals(actionType)) {
            // 更新订单详情信息
            ShopOrderInfoDto shopOrderInfoDto = new ShopOrderInfoDto();
            shopOrderInfoDto.setUserId(userId);
            shopOrderInfoDto.setOrderCode(orderCode);
            shopOrderInfoDto.setOrderStatus(orderStatus);
            shopOrderInfoDto.setConfirmTime(new Date());
            shopOrderInfoDto.setUpdatedUser(UPDATED_USER);
            shopOrderInfoDto.setUpdatedDate(new Date());
            shopOrderInfoService.updateByPrimaryKeyNotNull(shopOrderInfoDto);

            String orderTmpId = "";
            String proposalNo = "";
            List<String> subProposalNoList = null;
            for (CallBackOrderInfoDto callBackOrderInfoDto : callBackOrderInfoList) {
                orderTmpId = callBackOrderInfoDto.getOrderId();
                proposalNo = callBackOrderInfoDto.getProposalNo();
                subProposalNoList = callBackOrderInfoDto.getSubProposalNoList();
                if (StringUtil.isEmpty(orderTmpId)) {
                    throw new MessageException("子订单号不能为空,");
                }
                if (StringUtil.isEmpty(proposalNo)) {
                    throw new MessageException("投保单号不能为空,");
                }
                if (CollectionUtil.isEmpty(subProposalNoList)) {
                    throw new MessageException("子投保单号不能为空,");
                }
                BigInteger orderId = new BigInteger(orderTmpId);

                // 更新订单信息
                OrderMainDto orderMainDto = new OrderMainDto();
                orderMainDto.setUserId(userId);
                orderMainDto.setOrderMainId(orderId);
                orderMainDto.setProposalNo(proposalNo);
                orderMainDto.setStatus("0".equals(callBackOrderInfoDto.getProposalPassFlag()) ? "1" : "2"); // 0-初始状态，1-转投保成功，2-转投保失败，3-转保单成功，4-转保单失败
                orderMainDto.setUpdatedUser(UPDATED_USER);
                orderMainDto.setUpdatedDate(new Date());
                Condition orderMainCond = new Condition(OrderMainDto.class);
                orderMainCond.createCriteria().andEqualTo("orderMainId", orderId).andEqualTo("orderCode", orderCode);
                orderMainService.updateByConditionNotNull(orderMainDto, orderMainCond);

                // 支付信息表
                OrderPayinfoDto orderPayinfoDto = new OrderPayinfoDto();
                orderPayinfoDto.setUserId(userId);
                orderPayinfoDto.setOrderMainId(orderId);
                orderPayinfoDto.setInvalidFlag(0);
                orderPayinfoDto = orderPayinfoService.selectOne(orderPayinfoDto);
                orderPayinfoDto.setUserId(userId);
                orderPayinfoDto.setPayNo(callBackOrderInfoDto.getTrandNo());
                orderPayinfoDto.setUpdatedUser(UPDATED_USER);
                orderPayinfoDto.setUpdatedDate(new Date());
                orderPayinfoDto.setOrderCode(null);
                Condition orderPayCond = new Condition(OrderPayinfoDto.class);
                orderPayCond.createCriteria().andEqualTo("payId", orderPayinfoDto.getPayId()).andEqualTo("orderCode", orderCode);
                orderPayinfoService.updateByConditionNotNull(orderPayinfoDto, orderPayCond);
            }
        } else if ("1".equals(actionType)) {
            // 更新订单详情信息
            ShopOrderInfoDto shopOrderInfoDto = new ShopOrderInfoDto();
            shopOrderInfoDto.setUserId(userId);
            shopOrderInfoDto.setOrderCode(orderCode);
            shopOrderInfoDto.setOrderStatus(orderStatus);
            shopOrderInfoDto.setUpdatedUser(UPDATED_USER);
            shopOrderInfoDto.setUpdatedDate(new Date());
            shopOrderInfoService.updateByPrimaryKeyNotNull(shopOrderInfoDto);

            String orderTmpId = "";
            String policyNo = "";
            List<String> subPolicyNoList = null;
            for (CallBackOrderInfoDto callBackOrderInfoDto : callBackOrderInfoList) {
                orderTmpId = callBackOrderInfoDto.getOrderId();
                policyNo = callBackOrderInfoDto.getPolicyNo();
                subPolicyNoList = callBackOrderInfoDto.getSubPolicyNoList();
                if (StringUtil.isEmpty(orderTmpId)) {
                    throw new MessageException("子订单号不能为空,");
                }
                if (StringUtil.isEmpty(policyNo)) {
                    throw new MessageException("保单号不能为空,");
                }
                if (CollectionUtil.isEmpty(subPolicyNoList)) {
                    throw new MessageException("子保单号列表不能为空,");
                }
                BigInteger orderId = new BigInteger(orderTmpId);

                // 更新订单信息
                OrderMainDto orderMainDto = new OrderMainDto();
                orderMainDto.setUserId(userId);
                orderMainDto.setOrderMainId(orderId);
                orderMainDto.setPolicyNo(policyNo);
                orderMainDto.setStatus("0".equals(callBackOrderInfoDto.getPolicyPassFlag()) ? "3" : "4"); // 0-初始状态，1-转投保成功，2-转投保失败，3-转保单成功，4-转保单失败
                orderMainDto.setUpdatedUser(UPDATED_USER);
                orderMainDto.setUpdatedDate(new Date());
                Condition orderMainCond = new Condition(OrderMainDto.class);
                orderMainCond.createCriteria().andEqualTo("orderMainId", orderId).andEqualTo("orderCode", orderCode);
                orderMainService.updateByConditionNotNull(orderMainDto, orderMainCond);
            }
        } else {
            responseMessage.setMessage("没有该操作类型");
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }
        responseMessage.setMessage(SUCCESS_MSG);
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);
        return responseMessage;
    }
    
    /**
     * 5.2.5 更新支付状态
     * 
     * @Author: lujicong
     * @Date: 2015-12-24
     * @Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
    public ResponseMessage updateOrderPayStatus(RequestMessage requestMessageObj) throws Exception {
        ResponseMessage responseMessage = new ResponseMessage();
        UpdateOrderPayStatusReq updateOrderPayStatusReq = requestMessageObj.getData().getUpdateOrderPayStatusReq();

        String uid = requestMessageObj.getUserId();
        String orderTmpCode = updateOrderPayStatusReq.getOrderCode();
        String payStatus = updateOrderPayStatusReq.getPayStatus();
        Date payDate = updateOrderPayStatusReq.getPayDate();

        // 传入信息校验
        StringBuffer checkMsg = new StringBuffer();
        if (StringUtil.isEmpty(uid)) {
            checkMsg.append("用户ID不能为空,");
        }
        if (StringUtil.isEmpty(orderTmpCode)) {
            checkMsg.append("订单号不能为空,");
        }
        if (StringUtil.isEmpty(payStatus)) {
            checkMsg.append("支付状态不能为空,");
        }
        if (payDate == null) {
            checkMsg.append("支付时间不能为空,");
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

        // 更新订单支付信息
        ShopOrderPayinfoDto shopOrderPayinfoDto = new ShopOrderPayinfoDto();
        shopOrderPayinfoDto.setUserId(userId);
        shopOrderPayinfoDto.setOrderCode(orderCode);
        shopOrderPayinfoDto = shopOrderPayinfoService.selectOne(shopOrderPayinfoDto);
        shopOrderPayinfoDto.setUserId(userId);
        shopOrderPayinfoDto.setPayStatus(payStatus);
        shopOrderPayinfoDto.setPayDate(payDate);
        shopOrderPayinfoDto.setUpdatedUser(uid);
        shopOrderPayinfoDto.setUpdatedDate(new Date());
        shopOrderPayinfoDto.setOrderCode(null);
        Condition shopPayInfoCond = new Condition(ShopOrderPayinfoDto.class);
        shopPayInfoCond.createCriteria().andEqualTo("payinfoId", shopOrderPayinfoDto.getPayinfoId()).andEqualTo("orderCode", orderCode);
        shopOrderPayinfoService.updateByConditionNotNull(shopOrderPayinfoDto, shopPayInfoCond);

        // 订单商品关联信息列表
        ShopOrderGoodsDto queryOrderGoodsDto = new ShopOrderGoodsDto();
        queryOrderGoodsDto.setUserId(userId);
        queryOrderGoodsDto.setOrderCode(orderCode);
        queryOrderGoodsDto.setInvalidFlag(0);
        List<ShopOrderGoodsDto> shopOrderGoodsList = shopOrderGoodsService.select(queryOrderGoodsDto);
        BigInteger orderId = null;
        for (ShopOrderGoodsDto goodsDto : shopOrderGoodsList) {
            orderId = goodsDto.getGoodsNo();
            // 更新支付信息表
            OrderPayinfoDto orderPayinfoDto = new OrderPayinfoDto();
            orderPayinfoDto.setUserId(userId);
            orderPayinfoDto.setOrderMainId(orderId);
            orderPayinfoDto.setInvalidFlag(0);
            orderPayinfoDto = orderPayinfoService.selectOne(orderPayinfoDto);
            orderPayinfoDto.setUserId(userId);
            orderPayinfoDto.setPayStatus(payStatus);
            orderPayinfoDto.setPayDate(payDate);
            orderPayinfoDto.setUpdatedUser(uid);
            orderPayinfoDto.setUpdatedDate(new Date());
            orderPayinfoDto.setOrderCode(null);
            Condition orderPayCond = new Condition(OrderPayinfoDto.class);
            orderPayCond.createCriteria().andEqualTo("payId", orderPayinfoDto.getPayId()).andEqualTo("orderCode", orderCode);
            orderPayinfoService.updateByConditionNotNull(orderPayinfoDto, orderPayCond);
        }

        responseMessage.setMessage(SUCCESS_MSG);
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);
        return responseMessage;
    }
    
    /**
     * 5.2.6 更新支付信息
     * 
     * @Author: lujicong
     * @Date: 2015-12-24
     * @Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
    public ResponseMessage updateOrderPayInfo(RequestMessage requestMessageObj) throws Exception {
        ResponseMessage responseMessage = new ResponseMessage();
        UpdateOrderPayInfoReq updateOrderPayInfoReq = requestMessageObj.getData().getUpdateOrderPayInfoReq();
        String uid = requestMessageObj.getUserId();
        String orderTmpCode = updateOrderPayInfoReq.getOrderCode();
        String payWay = updateOrderPayInfoReq.getPayWay();

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
        if (StringUtil.isNotEmpty(checkMsg.toString())) {
            responseMessage.setMessage(checkMsg.substring(0, checkMsg.length() - 1));
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }

        BigInteger userId = new BigInteger(uid);
        BigInteger orderCode = new BigInteger(orderTmpCode);

        ShopOrderPayinfoDto queryDto = new ShopOrderPayinfoDto();
        queryDto.setOrderCode(orderCode);
        ShopOrderPayinfoDto oldDto = shopOrderPayinfoService.selectOne(queryDto);
        if("1".equals(oldDto.getPayStatus()) && !"1".equals(updateOrderPayInfoReq.getPayStatus())){
        	responseMessage.setMessage("已支付成功的订单.");
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }
        
        // 更新订单支付信息
        ShopOrderPayinfoDto shopOrderPayinfoDto = new ShopOrderPayinfoDto();
        shopOrderPayinfoDto.setUserId(userId);
        shopOrderPayinfoDto.setOrderCode(orderCode);
        shopOrderPayinfoDto = shopOrderPayinfoService.selectOne(shopOrderPayinfoDto);
        shopOrderPayinfoDto.setUserId(userId);
        shopOrderPayinfoDto.setPayWay(payWay);
        shopOrderPayinfoDto.setPayNo(updateOrderPayInfoReq.getPayNo());
        shopOrderPayinfoDto.setPayDate(updateOrderPayInfoReq.getPayDate());
        
        shopOrderPayinfoDto.setPayStatus(updateOrderPayInfoReq.getPayStatus());
        shopOrderPayinfoDto.setDocNo(updateOrderPayInfoReq.getDocNo());
        shopOrderPayinfoDto.setDocType(updateOrderPayInfoReq.getDocType());
        shopOrderPayinfoDto.setDataSource(updateOrderPayInfoReq.getDataSource());
        shopOrderPayinfoDto.setPayeeName(updateOrderPayInfoReq.getPayeeName());
        shopOrderPayinfoDto.setBankCode(updateOrderPayInfoReq.getBankCode());
        shopOrderPayinfoDto.setBankAccount(updateOrderPayInfoReq.getBankAccount());
        shopOrderPayinfoDto.setPhoneNo(updateOrderPayInfoReq.getPhoneNo());
        
        shopOrderPayinfoDto.setUpdatedUser(uid);
        shopOrderPayinfoDto.setUpdatedDate(new Date());
        shopOrderPayinfoDto.setOrderCode(null);
        Condition shopPayInfoCond = new Condition(ShopOrderPayinfoDto.class);
        shopPayInfoCond.createCriteria().andEqualTo("payinfoId", shopOrderPayinfoDto.getPayinfoId()).andEqualTo("orderCode", orderCode);
        shopOrderPayinfoService.updateByConditionNotNull(shopOrderPayinfoDto, shopPayInfoCond);

        responseMessage.setMessage(SUCCESS_MSG);
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);
        return responseMessage;
    }
    
    /**
     * 5.2.7 查询订单列表
     * 
     * @Author: lujicong
     * @Date: 2015-12-24
     * @Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    @Override
    public ResponseMessage queryOrderList(RequestMessage requestMessageObj) throws Exception {
        ResponseMessage responseMessage = new ResponseMessage();
        QueryOrderListReq queryOrderListReq = requestMessageObj.getData().getQueryOrderListReq();

        String uid = requestMessageObj.getUserId();
        Date orderStartDate = queryOrderListReq.getOrderStartDate();
        Date orderEndDate = queryOrderListReq.getOrderEndDate();
        Integer startIndex = queryOrderListReq.getStartIndex();
        Integer pageSize = queryOrderListReq.getPageSize();
        String orderStatus = queryOrderListReq.getOrderStatus();
        String payStatus = queryOrderListReq.getPayStatus();

        // 传入信息校验
        StringBuffer checkMsg = new StringBuffer();
        if (StringUtil.isEmpty(uid)) {
            checkMsg.append("用户ID不能为空,");
        }
        if (startIndex == null) {
            checkMsg.append("开始位置不能为空,");
        }
        if (pageSize == null) {
            checkMsg.append("每页数量不能为空,");
        }
        if (StringUtil.isNotEmpty(checkMsg.toString())) {
            responseMessage.setMessage(checkMsg.substring(0, checkMsg.length() - 1));
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }

        BigInteger userId = new BigInteger(uid);

        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("userId", userId);
        paramMap.put("orderStartDate", orderStartDate);
        if (orderEndDate != null) {
            orderEndDate = new DateTime(orderEndDate).addDay(1);
        }
        paramMap.put("orderEndDate", orderEndDate);
        paramMap.put("startIndex", startIndex);
        paramMap.put("pageSize", pageSize);
        paramMap.put("orderStatus", orderStatus);
        paramMap.put("payStatus", payStatus);
        paramMap.put("objectCondition", " order by add_time desc"); // 自定义
        List<ShopOrderInfoDto> queryShopOrderInfoList = shopOrderInfoService.queryOrderList(paramMap);

        paramMap.put("actionType", "count");
        int total = shopOrderInfoService.queryOrderCount(paramMap);

        List<ShopOrderDto> shopOrderList = new ArrayList<ShopOrderDto>();
        if (CollectionUtil.isNotEmpty(queryShopOrderInfoList)) {

            if (queryShopOrderInfoList.size() > 1) {
                Collections.sort(queryShopOrderInfoList, new SortOrderInfo());
            }

            ShopOrderDto shopOrderDto = null;
            BigInteger orderCode = null;
            for (ShopOrderInfoDto shopOrderInfoDto : queryShopOrderInfoList) {
                orderCode = shopOrderInfoDto.getOrderCode();
                shopOrderDto = new ShopOrderDto();
                // 订单详情信息
                shopOrderDto.setShopOrderInfo(shopOrderInfoDto);

                // 订单支付信息
                ShopOrderPayinfoDto shopOrderPayinfoDto = new ShopOrderPayinfoDto();
                shopOrderPayinfoDto.setUserId(userId);
                shopOrderPayinfoDto.setOrderCode(orderCode);
                shopOrderPayinfoDto.setInvalidFlag(0);
                shopOrderPayinfoDto = shopOrderPayinfoService.selectOne(shopOrderPayinfoDto);
                shopOrderDto.setShopOrderPayinfo(shopOrderPayinfoDto);

                // 订单配送信息
                ShopOrderShippingDto shopOrderShippingDto = new ShopOrderShippingDto();
                shopOrderShippingDto.setUserId(userId);
                shopOrderShippingDto.setOrderCode(orderCode);
                shopOrderShippingDto.setInvalidFlag(0);
                shopOrderShippingDto = shopOrderShippingService.selectOne(shopOrderShippingDto);
                shopOrderDto.setShopOrderShipping(shopOrderShippingDto);

                // 订单商品关联信息列表
                ShopOrderGoodsDto queryOrderGoodsDto = new ShopOrderGoodsDto();
                queryOrderGoodsDto.setUserId(userId);
                queryOrderGoodsDto.setOrderCode(orderCode);
                queryOrderGoodsDto.setInvalidFlag(0);
                List<ShopOrderGoodsDto> shopOrderGoodsList = shopOrderGoodsService.select(queryOrderGoodsDto);

                List<OrderDto> orderList = new ArrayList<OrderDto>();
                BigInteger orderId = null;
                OrderDto orderDto = null;
                for (ShopOrderGoodsDto goodsDto : shopOrderGoodsList) {
                    orderDto = new OrderDto();
                    orderId = goodsDto.getGoodsNo();
                    // 订单信息
                    OrderMainDto orderMainDto = new OrderMainDto();
                    orderMainDto.setOrderCode(orderCode);
                    orderMainDto.setOrderMainId(orderId);
                    orderMainDto = orderMainService.selectOne(orderMainDto);
                    orderDto.setOrderMain(orderMainDto);

                    // 合作方信息列表
                    OrderPartnerDto orderPartnerDto = new OrderPartnerDto();
                    orderPartnerDto.setOrderCode(orderCode);
                    orderPartnerDto.setOrderMainId(orderId);
                    List<OrderPartnerDto> partnerList = orderPartnerService.select(orderPartnerDto);
                    orderDto.setPartnerList(partnerList);
					
                    // 业务员信息列表
                    OrderSalesmanDto orderSalesmanDto = new OrderSalesmanDto();
                    orderSalesmanDto.setOrderCode(orderCode);
                    orderSalesmanDto.setOrderMainId(orderId);
                    List<OrderSalesmanDto> salesmanList = orderSalesmanService.select(orderSalesmanDto);
                    orderDto.setSalesmanList(salesmanList);

                    // 订单商品关联信息
                    orderDto.setOrderGoods(goodsDto);

                    // 险别信息列表
                    OrderItemkindDto orderItemkindDto = new OrderItemkindDto();
                    orderItemkindDto.setOrderCode(orderCode);
                    orderItemkindDto.setOrderMainId(orderId);
                    orderItemkindDto.setInvalidFlag(0);
                    List<OrderItemkindDto> itemkindList = orderItemkindService.select(orderItemkindDto);
                    orderDto.setItemkindList(itemkindList);

                    // 条款信息
                    OrderClausesDto orderClausesDto = new OrderClausesDto();
                    orderClausesDto.setOrderCode(orderCode);
                    orderClausesDto.setOrderMainId(orderId);
                    orderClausesDto.setInvalidFlag(0);
                    List<OrderClausesDto> clausesList = orderClausesService.select(orderClausesDto);
                    orderDto.setClausesList(clausesList);

                    // 特别约定
                    OrderSpecialClausesDto orderSpecialClausesDto = new OrderSpecialClausesDto();
                    orderSpecialClausesDto.setOrderCode(orderCode);
                    orderSpecialClausesDto.setOrderMainId(orderId);
                    orderSpecialClausesDto.setInvalidFlag(0);
                    List<OrderSpecialClausesDto> orderSpecialClausesList = orderSpecialClausesService.select(orderSpecialClausesDto);
                    orderDto.setSpecialClausesList(orderSpecialClausesList);

                    // 限额信息列表
                    OrderLimitDto orderLimitDto = new OrderLimitDto();
                    orderLimitDto.setOrderCode(orderCode);
                    orderLimitDto.setOrderMainId(orderId);
                    orderLimitDto.setInvalidFlag(0);
                    List<OrderLimitDto> orderLimitList = orderLimitService.select(orderLimitDto);
                    orderDto.setLimitList(orderLimitList);

                    // 支付信息
                    OrderPayinfoDto orderPayinfoDto = new OrderPayinfoDto();
                    orderPayinfoDto.setOrderCode(orderCode);
                    orderPayinfoDto.setOrderMainId(orderId);
                    orderPayinfoDto.setInvalidFlag(0);
                    orderPayinfoDto = orderPayinfoService.selectOne(orderPayinfoDto);
                    orderDto.setPayinfo(orderPayinfoDto);

                    // 客户信息列表
                    OrderCustomerDto orderCustomerDto = new OrderCustomerDto();
                    orderCustomerDto.setOrderCode(orderCode);
                    orderCustomerDto.setOrderMainId(orderId);
                    orderCustomerDto.setInvalidFlag(0);
                    List<OrderCustomerDto> orderCustomerList = orderCustomerService.select(orderCustomerDto);
                    orderDto.setCustomerList(orderCustomerList);

                    // 家财标的信息
                    OrderPropertyDto orderPropertyDto = new OrderPropertyDto();
                    orderPropertyDto.setOrderCode(orderCode);
                    orderPropertyDto.setOrderMainId(orderId);
                    orderPropertyDto.setInvalidFlag(0);
                    orderPropertyDto = orderPropertyService.selectOne(orderPropertyDto);
                    orderDto.setProperty(orderPropertyDto);

                    // 动态标的信息
                    OrderDynamicItemDto orderDynamicItemDto = new OrderDynamicItemDto();
                    orderDynamicItemDto.setOrderCode(orderCode);
                    orderDynamicItemDto.setOrderMainId(orderId);
                    orderDynamicItemDto.setInvalidFlag(0);
                    List<OrderDynamicItemDto> orderDynamicItemList = orderDynamicItemService.select(orderDynamicItemDto);
                    orderDto.setDynamicItemList(orderDynamicItemList);

                    // 动态清单信息
                    OrderDynamicListDto orderDynamicListDto = new OrderDynamicListDto();
                    orderDynamicListDto.setOrderCode(orderCode);
                    orderDynamicListDto.setOrderMainId(orderId);
                    orderDynamicListDto.setInvalidFlag(0);
                    List<OrderDynamicListDto> orderDynamicListList = orderDynamicListService.select(orderDynamicListDto);
                    orderDto.setDynamicListList(orderDynamicListList);

                    orderList.add(orderDto);
                }
                shopOrderDto.setOrderList(orderList);
                shopOrderList.add(shopOrderDto);
            }
        }
        QueryOrderListResp queryOrderListResp = new QueryOrderListResp();
        queryOrderListResp.setShopOrderList(shopOrderList);
        queryOrderListResp.setTotal(total);
        responseMessage.getData().setQueryOrderListResp(queryOrderListResp);

        responseMessage.setMessage(SUCCESS_MSG);
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);
        return responseMessage;
    }
    
    /**
     * 5.2.8 查询订单数量
     * 
     * @Author: lujicong
     * @Date: 2015-12-24
     * @Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    @Override
    public ResponseMessage queryOrderCount(RequestMessage requestMessageObj) throws Exception {
        ResponseMessage responseMessage = new ResponseMessage();
        QueryOrderCountReq queryOrderCountReq = requestMessageObj.getData().getQueryOrderCountReq();

        String uid = requestMessageObj.getUserId();
        Date orderStartDate = queryOrderCountReq.getOrderStartDate();
        Date orderEndDate = queryOrderCountReq.getOrderEndDate();
        String orderStatus = queryOrderCountReq.getOrderStatus();
        String payStatus = queryOrderCountReq.getPayStatus();

        // 传入信息校验
        StringBuffer checkMsg = new StringBuffer();
        if (StringUtil.isEmpty(uid)) {
            checkMsg.append("用户ID不能为空,");
        }
        if (StringUtil.isNotEmpty(checkMsg.toString())) {
            responseMessage.setMessage(checkMsg.substring(0, checkMsg.length() - 1));
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }

        BigInteger userId = new BigInteger(uid);

        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("userId", userId);
        paramMap.put("orderStartDate", orderStartDate);
        if (orderEndDate != null) {
            orderEndDate = new DateTime(orderEndDate).addDay(1);
        }
        paramMap.put("orderEndDate", orderEndDate);
        paramMap.put("orderStatus", orderStatus);
        paramMap.put("payStatus", payStatus);
        int orderCount = shopOrderInfoService.queryOrderCount(paramMap);

        QueryOrderCountResp queryOrderCountResp = new QueryOrderCountResp();
        queryOrderCountResp.setOrderCount(orderCount);
        responseMessage.getData().setQueryOrderCountResp(queryOrderCountResp);

        responseMessage.setMessage(SUCCESS_MSG);
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);
        return responseMessage;
    }
    
    /**
     * 5.2.9 支付后订单处理
     * 
     * @Author: lujicong
     * @Date: 2015-12-24
     * @Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    @Override
    public ResponseMessage dealOrderAfterPay(RequestMessage requestMessageObj) throws Exception {
        ResponseMessage responseMessage = new ResponseMessage();
        DealOrderAfterPayReq dealOrderAfterPayReq = requestMessageObj.getData().getDealOrderAfterPayReq();

        String uid = requestMessageObj.getUserId(); // 用户ID
        String queryOrderCode = dealOrderAfterPayReq.getOrderCode();

        // 传入信息校验
        StringBuffer checkMsg = new StringBuffer();
        if (StringUtil.isEmpty(uid)) {
            checkMsg.append("用户ID不能为空,");
        }
        if (StringUtil.isEmpty(queryOrderCode)) {
            checkMsg.append("订单号不能为空,");
        }
        if (StringUtil.isNotEmpty(checkMsg.toString())) {
            responseMessage.setMessage(checkMsg.substring(0, checkMsg.length() - 1));
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }
        // 用户ID
        BigInteger orderCode = new BigInteger(queryOrderCode);

        // 获取订单详情信息
        ShopOrderDto shopOrderDto = this.getOrderDetailInfo(orderCode);

        // 处理成功返回
        DealOrderAfterPayResp dealOrderAfterPayResp = new DealOrderAfterPayResp();
        dealOrderAfterPayResp.setShopOrderInfo(shopOrderDto.getShopOrderInfo());
        dealOrderAfterPayResp.setShopOrderPayinfo(shopOrderDto.getShopOrderPayinfo());
        dealOrderAfterPayResp.setShopOrderShipping(shopOrderDto.getShopOrderShipping());
        dealOrderAfterPayResp.setOrderList(shopOrderDto.getOrderList());
        responseMessage.getData().setDealOrderAfterPayResp(dealOrderAfterPayResp);

        responseMessage.setMessage(SUCCESS_MSG);
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);

        return responseMessage;
    }
    
    /**
     * 5.2.10 全单批退
     * 
     * @Author: lujicong
     * @Date: 2015-12-29
     * @Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
    public ResponseMessage cancelInsurance(RequestMessage requestMessageObj) throws Exception {
        ResponseMessage responseMessage = new ResponseMessage();
        CancelInsuranceReq cancelInsuranceReq = requestMessageObj.getData().getCancelInsuranceReq();

        String uid = requestMessageObj.getUserId();
        String orderCodeTmp = cancelInsuranceReq.getOrderCode();
        String policyNo = cancelInsuranceReq.getPolicyNo();
        Date validDate = cancelInsuranceReq.getValidDate();
        Date endorDate = cancelInsuranceReq.getEndorDate();
        String asynFlag = cancelInsuranceReq.getAsynFlag();	//是否走异步化标识：Y-是，N-否

        String accountBank = cancelInsuranceReq.getAccountBank();
        String accountName = cancelInsuranceReq.getAccountName();
        String accountNumber = cancelInsuranceReq.getAccountNumber();

        // 传入信息校验
        StringBuffer checkMsg = new StringBuffer();
        if (StringUtil.isEmpty(uid)) {
            checkMsg.append("用户ID不能为空,");
        }
        if (StringUtil.isEmpty(orderCodeTmp)) {
            checkMsg.append("订单号不能为空,");
        }
        if (StringUtil.isEmpty(policyNo)) {
            checkMsg.append("保单号不能为空,");
        }
        if (validDate == null) {
            checkMsg.append("生效日期不能为空,");
        }
        if (StringUtil.isNotEmpty(checkMsg.toString())) {
            responseMessage.setMessage(checkMsg.substring(0, checkMsg.length() - 1));
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }

        BigInteger userId = new BigInteger(uid);
        BigInteger orderCode = new BigInteger(orderCodeTmp);

        if (endorDate == null) {
            endorDate = new Date();
        }

        // 查询订单支付信息及进行补数
        ShopOrderPayinfoDto shopOrderPayinfoDto = new ShopOrderPayinfoDto();
        shopOrderPayinfoDto.setUserId(userId);
        shopOrderPayinfoDto.setOrderCode(orderCode);
        shopOrderPayinfoDto.setInvalidFlag(0);
        shopOrderPayinfoDto = shopOrderPayinfoService.selectOne(shopOrderPayinfoDto);

        OrderPayinfoDto orderPayinfo = new OrderPayinfoDto();

        if (StringUtil.isEmpty(accountBank)) {
            if (shopOrderPayinfoDto != null) {
                orderPayinfo.setSurrenderAccountBank(shopOrderPayinfoDto.getBankCode());
            }
        } else {
            orderPayinfo.setSurrenderAccountBank(accountBank);
        }

        if (StringUtil.isEmpty(accountName)) {
            if (shopOrderPayinfoDto != null) {
                orderPayinfo.setSurrenderAccountName(shopOrderPayinfoDto.getPayeeName());
            }
        } else {
            orderPayinfo.setSurrenderAccountName(accountName);
        }

        if (StringUtil.isEmpty(accountNumber)) {
            if (shopOrderPayinfoDto != null) {
                orderPayinfo.setSurrenderAccountNo(shopOrderPayinfoDto.getBankAccount());
            }
        } else {
            orderPayinfo.setSurrenderAccountNo(accountNumber);
        }

        // 校验保单号
        OrderMainDto orderMainDto = new OrderMainDto();
        orderMainDto.setOrderCode(orderCode);
        orderMainDto.setPolicyNo(policyNo);
        orderMainDto = orderMainService.selectOne(orderMainDto);
        if (orderMainDto == null) {
            responseMessage.setMessage("不存在该保单信息");
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }

        // 判断能否进行全单批退及有效保单
        if ("5".equals(orderMainDto.getStatus())) {
            responseMessage.setMessage("该保单已经全单退保");
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        } else if ("7".equals(orderMainDto.getStatus())) {
            responseMessage.setMessage("该保单处于批改中状态");
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        } else if ("0,1,2,4".indexOf(orderMainDto.getStatus()) > -1) { // 0-初始状态,1-转投保成功,2-转投保失败,4-转保单失败
            responseMessage.setMessage("不存在该保单");
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }

        // 当生效日期小于起保日期时
        if (TimeUtil.beforeLatterDate(validDate, orderMainDto.getStartDate())) {
            validDate = orderMainDto.getStartDate();
        } else if (TimeUtil.afterLatterDate(validDate, orderMainDto.getEndDate())) {
            validDate = orderMainDto.getEndDate();
        }

        /* added by glizhen 2018/03/27 for RM-5836 为了麦芬-个人资金账户安全险产品-北京营业部-孙竟淞-退保优化需求进行的修改 begin */
        BigDecimal returnPremium = DecimalUtil.toBigDecimal(0);
        if ("N".equals(asynFlag)) {//不走异步化，直接调trans，返回数据
        	returnPremium = cancelInsuranceForTrans(orderCodeTmp, policyNo, validDate, orderPayinfo);
        	/* added by glizhen 2018/03/27 for RM-5836 为了麦芬-个人资金账户安全险产品-北京营业部-孙竟淞-退保优化需求进行的修改 end */
        } else {
        	// 更新订单主表信息
        	OrderMainDto orderMain = new OrderMainDto();
        	orderMain.setSurrenderValidDate(validDate);
        	orderMain.setEndorDate(endorDate);
        	orderMain.setStatus("5"); // 全单批退成功
        	orderMain.setUpdatedUser(uid);
        	orderMain.setUpdatedDate(new Date());
        	Condition orderMainCond = new Condition(OrderMainDto.class);
        	orderMainCond.createCriteria().andEqualTo("orderCode", orderCode).andEqualTo("orderMainId", orderMainDto.getOrderMainId())
        	.andNotEqualTo("status", "5");
        	int count = orderMainService.updateByConditionNotNull(orderMain, orderMainCond);
        	if (count == 0) {
        		responseMessage.setMessage("该保单已经全单退保");
        		responseMessage.setCode(FAIL_CODE);
        		responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
        		responseMessage.setState(FAIL_STATE);
        		return responseMessage;
        	}
        	
        	// 测试单标识为空或者测试单标识为N-否时，写入保单退保同步信息表
        	if(StringUtil.isEmpty(orderMainDto.getTestIssueFlag()) || "N".equals(orderMainDto.getTestIssueFlag())){
	        	// 写入保单退保同步信息表【t_syn_policy_surrender】
	        	SynPolicySurrenderDto synPolicySurrender = new SynPolicySurrenderDto();
	        	synPolicySurrender.setOrderCode(orderCode);
	        	synPolicySurrender.setPolicyNo(policyNo);
	        	synPolicySurrender.setDealStatus("0"); // 未处理
	        	synPolicySurrender.setCreatedUser(uid);
	        	synPolicySurrender.setCreatedDate(new Date());
	        	synPolicySurrender.setUpdatedUser(uid);
	        	synPolicySurrender.setUpdatedDate(synPolicySurrender.getCreatedDate());
	        	synPolicySurrenderService.insertNotNull(synPolicySurrender);
        	} else {
        		if("Y".equals(orderMainDto.getCodInd())) { // 见费出单标志:Y-是 N-否,见费出单调用资金系统告知退费
        			// 待完善
        		}
        	}
        }

        // 更新退保支付信息
        orderPayinfo.setUpdatedUser(uid);
        orderPayinfo.setUpdatedDate(new Date());
        Condition orderPayinfoCond = new Condition(OrderPayinfoDto.class);
        orderPayinfoCond.createCriteria().andEqualTo("orderCode", orderCode).andEqualTo("orderMainId", orderMainDto.getOrderMainId());
        orderPayinfoService.updateByConditionNotNull(orderPayinfo, orderPayinfoCond);

        // 清除保单缓存信息
        ShopOrderDto shopOrderDto = this.getOrderDetailInfo(orderCode);
        /** delete by hguoqing 2018/3/27 for order回调接口统一处理 begin **/
//        resetPolicyInfoRedisHset(shopOrderDto, policyNo);
        /** delete by hguoqing 2018/3/27 for order回调接口统一处理 end **/
        orderCallbackDysubData(shopOrderDto, policyNo, Constants.DEAL_TYPE_CANCEL);
        
        // 返回
        CancelInsuranceResp cancelInsuranceResp = new CancelInsuranceResp();
        cancelInsuranceResp.setPassFlag("Y");
        cancelInsuranceResp.setMeassage(policyNo);
        cancelInsuranceResp.setUnderWriteInd("6");
        cancelInsuranceResp.setEndorDate(endorDate);
        cancelInsuranceResp.setReturnPremium(returnPremium);	//应退保费
        responseMessage.getData().setCancelInsuranceResp(cancelInsuranceResp);

        responseMessage.setMessage(SUCCESS_MSG);
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);
        return responseMessage;
    }
    
    /**
     * 5.2.10 全单批退(直接调trans退保)
     * 
     * @Author: glizhen
     * @Date: 2018-03-26
     * @Version: 1.0
     * @param orderCodeTmp	订单号
     * @param policyNo		保单号
     * @param validDate		批改生效日期
     * @param orderPayinfo	账户信息
     * @return
     * @throws Exception
     */
    public BigDecimal cancelInsuranceForTrans(String orderCodeTmp, String policyNo, Date validDate, OrderPayinfoDto orderPayinfo) throws Exception {
    	BigDecimal returnPremium = DecimalUtil.toBigDecimal(0);
		String accountBank = orderPayinfo.getSurrenderAccountBank();
        if (StringUtil.isEmpty(accountBank)) {
            accountBank = ConfigUtil.getValue("account.bank");
        }
        String accountName = orderPayinfo.getSurrenderAccountName();
        if (StringUtil.isEmpty(accountName)) {
            accountName = ConfigUtil.getValue("account.name");
        }
        String accountNumber = orderPayinfo.getSurrenderAccountNo();
        if (StringUtil.isEmpty(accountNumber)) {
            accountNumber = ConfigUtil.getValue("account.number");
        }
        // 调用核心全单批退接口
        logger.info("-------------调用Trans全单批退接口开始---------------");
        TransRequestMessage transRequestMessage = new TransRequestMessage();
        transRequestMessage.setRequestTime(new Date());
        transRequestMessage.setInterfaceCode("CancelInsurance");
        
        TransCancelInsuranceReq transCancelInsuranceReq = new TransCancelInsuranceReq(); 
        transCancelInsuranceReq.setPolicyNo(policyNo);
        transCancelInsuranceReq.setValidDate(validDate);
        transCancelInsuranceReq.setAccountBank(accountBank);
        transCancelInsuranceReq.setAccountName(accountName);
        transCancelInsuranceReq.setAccountNumber(accountNumber);
        transRequestMessage.getData().setCancelInsuranceReq(transCancelInsuranceReq);
        
        HttpResponseWrapper transResult = new ClientUtils().connectServer(transRequestMessage, ConfigUtil.getValue("remote.trans.url"));
        if (transResult.getStatus()) {
            TransResponseMessage transResponseMessage = JSON.parseObject((String)transResult.getContent(), TransResponseMessage.class);
            String code = transResponseMessage.getCode();
            if(SUCCESS_CODE.equals(code)) {
                TransCancelInsuranceResp transCancelInsuranceResp = transResponseMessage.getData().getCancelInsuranceResp();
                String passFlag = transCancelInsuranceResp.getPassFlag();
                String message = transCancelInsuranceResp.getMeassage();
                String underWriteInd = transCancelInsuranceResp.getUnderWriteInd();
                returnPremium = transCancelInsuranceResp.getReturnPremium();//应退保费
                if("Y".equals(passFlag) && "6".equals(underWriteInd)) {
                	returnPremium = returnPremium.abs();	//应退保费取正数
                } else {
                	throw new MessageException("全单批退处理不通过:" + message);
                }
            }else {
            	logger.error("请求TRANS系统退保接口失败,响应状态为:{},响应信息为:{}",transResponseMessage.getStatusCode(),transResponseMessage.getMessage());
                throw new MessageException(transResponseMessage.getStatusCode(),"全单批退处理失败:" + transResponseMessage.getMessage());
            }
        } else {
        	String statusCode = Constants.STATUSCODE_PREFIX + StatusCodeProvider.getCode(transResult, FAIL_CODE);
        	throw new MessageException(statusCode,"调用Trans全单批退接口失败,原因:" + transResult.getErrorMessage());
        }
        logger.info("-------------调用Trans全单批退接口结束---------------");
    	return returnPremium;
    }
    
    /**
     * 5.2.11 更新订单状态
     * 
     * @Author: lujicong
     * @Date: 2015-12-29
     * @Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
    public ResponseMessage updateOrderStatus(RequestMessage requestMessageObj) throws Exception {
        ResponseMessage responseMessage = new ResponseMessage();
        UpdateOrderStatusReq updateOrderStatusReq = requestMessageObj.getData().getUpdateOrderStatusReq();

        String uid = requestMessageObj.getUserId();
        String orderCodeTmp = updateOrderStatusReq.getOrderCode();
        String orderStatus = updateOrderStatusReq.getOrderStatus();

        // 传入信息校验
        StringBuffer checkMsg = new StringBuffer();
        if (StringUtil.isEmpty(uid)) {
            checkMsg.append("用户ID不能为空,");
        }
        if (StringUtil.isEmpty(orderCodeTmp)) {
            checkMsg.append("订单号不能为空,");
        }
        if (StringUtil.isEmpty(orderStatus)) {
            checkMsg.append("订单状态不能为空,");
        }
        if (StringUtil.isNotEmpty(checkMsg.toString())) {
            responseMessage.setMessage(checkMsg.substring(0, checkMsg.length() - 1));
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }

        BigInteger userId = new BigInteger(uid);
        BigInteger orderCode = new BigInteger(orderCodeTmp);

        // 更新订单状态
        ShopOrderInfoDto shopOrderInfoDto = new ShopOrderInfoDto();
        shopOrderInfoDto.setUserId(userId);
        shopOrderInfoDto.setOrderCode(orderCode);
        shopOrderInfoDto.setOrderStatus(orderStatus);
        shopOrderInfoDto.setUpdatedUser(uid);
        shopOrderInfoDto.setUpdatedDate(new Date());
        shopOrderInfoService.updateByPrimaryKeyNotNull(shopOrderInfoDto);

        // 成功返回信息
        responseMessage.setMessage(SUCCESS_MSG);
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);
        return responseMessage;
    }
    
    /**
     * 5.2.12 全单批退回写(核心批改审核完成调用)
     * 
     * @Author: lujicong
     * @Date: 2015-12-29
     * @Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
    public ResponseMessage cancelInsuranceCallBack(RequestMessage requestMessageObj) throws Exception {
        ResponseMessage responseMessage = new ResponseMessage();
        CancelInsuranceCallBackReq cancelInsuranceCallBackReq = requestMessageObj.getData().getCancelInsuranceCallBackReq();

        String orderCodeTmp = cancelInsuranceCallBackReq.getOrderCode();
        String endorStatus = cancelInsuranceCallBackReq.getEndorStatus(); // 0:通过,1:不通过
        String policyNo = cancelInsuranceCallBackReq.getPolicyNo();
        double changePremium = cancelInsuranceCallBackReq.getChangePremium();	//保费变化量
        Date validDate = cancelInsuranceCallBackReq.getValidDate();
        Date endorDate = cancelInsuranceCallBackReq.getEndorDate();
        
        // 传入信息校验
        StringBuffer checkMsg = new StringBuffer();
        if (StringUtil.isEmpty(orderCodeTmp)) {
            checkMsg.append("订单号不能为空,");
        }
        if (StringUtil.isEmpty(endorStatus)) {
            checkMsg.append("批改状态不能为空,");
        }
        if (StringUtil.isEmpty(policyNo)) {
            checkMsg.append("保单号不能为空,");
        }
        if (StringUtil.isNotEmpty(checkMsg.toString())) {
            responseMessage.setMessage(checkMsg.substring(0, checkMsg.length() - 1));
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }

        BigInteger orderCode = new BigInteger(orderCodeTmp);

        if ("0".equals(endorStatus)) { // 全单批退成功
        	// 更新订单信息
        	OrderMainDto orderMainDto = new OrderMainDto();
        	orderMainDto.setSurrenderValidDate(validDate);
        	orderMainDto.setEndorDate(endorDate);
        	orderMainDto.setStatus("5"); // 全单批退
        	orderMainDto.setSynPolicySurrenderStatus("0"); // 已同步
        	orderMainDto.setUpdatedUser(UPDATED_USER);
        	orderMainDto.setUpdatedDate(new Date());
        	Condition orderMainCond = new Condition(OrderMainDto.class);
        	orderMainCond.createCriteria().andEqualTo("orderCode", orderCode).andEqualTo("policyNo", policyNo);
        	orderMainService.updateByConditionNotNull(orderMainDto, orderMainCond);

        	OrderMainDto orderMainForSelect = new OrderMainDto();
        	orderMainForSelect.setOrderCode(orderCode);
        	orderMainForSelect.setPolicyNo(policyNo);
        	orderMainForSelect.setInvalidFlag(0);
        	orderMainForSelect = orderMainService.selectOne(orderMainForSelect);

        	ShopOrderGoodsDto shopOrderGoodsDto = new ShopOrderGoodsDto();
        	shopOrderGoodsDto.setChangePremium(changePremium);
        	Condition shopOrderGoodsCond = new Condition(ShopOrderGoodsDto.class);
        	shopOrderGoodsCond.createCriteria().andEqualTo("orderCode", orderCode).andEqualTo("goodsNo", orderMainForSelect.getOrderMainId());
        	shopOrderGoodsService.updateByConditionNotNull(shopOrderGoodsDto, shopOrderGoodsCond);

        	// 更新任务表信息
        	Condition synPolicySurrenderCond = new Condition(SynPolicySurrenderDto.class);
        	synPolicySurrenderCond.createCriteria().andEqualTo("orderCode", orderCode).andEqualTo("policyNo", policyNo);
        	SynPolicySurrenderDto synPolicySurrenderDto = new SynPolicySurrenderDto();
        	synPolicySurrenderDto.setDealStatus("2"); // 处理成功
        	synPolicySurrenderDto.setUnderWriteInd("6"); // 承保确认
        	synPolicySurrenderDto.setUpdatedUser(UPDATED_USER);
        	synPolicySurrenderDto.setUpdatedDate(new Date());
        	synPolicySurrenderService.updateByConditionNotNull(synPolicySurrenderDto, synPolicySurrenderCond);

        	ShopOrderInfoDto shopOrderInfoDto = new ShopOrderInfoDto();
        	shopOrderInfoDto.setOrderCode(orderCode);
        	shopOrderInfoDto.setInvalidFlag(0);
        	shopOrderInfoDto = shopOrderInfoService.selectOne(shopOrderInfoDto);

        	BigInteger userId = shopOrderInfoDto.getUserId();

        	ShopOrderDto shopOrderDto = this.getOrderDetailInfo(orderCode);

        	//退保回调接口
        	if (shopOrderInfoDto != null && StringUtil.isNotEmpty(shopOrderInfoDto.getAppId())) {
        		String appId = shopOrderInfoDto.getAppId();
        		List<String> appIdList = Arrays.asList(ConfigUtil.getValue("appIds").split(","));
        		if (CollectionUtil.isNotEmpty(appIdList) && appIdList.contains(appId)) {
        			surrenderCallBack(appId, userId, orderCode, policyNo, endorStatus, changePremium);	
        		}
        	}
          	/* delete by hguoqing 2018/3/26 for FTP对账数据上传公共化,接口整改 begin */
        	// 清除保单缓存信息
        	// resetPolicyInfoRedisHset(shopOrderDto, policyNo);
        	/* added by lshuang 2017/12/29 for RM-4353 和包支付-航空意外险-SFTP每日对账 begin*/
        	/*List<OrderDto> orderList = shopOrderDto.getOrderList();
        	for (OrderDto orderDto : orderList) {
        		String agrtCode = orderDto.getOrderMain().getAgrtCode();
        		if (AgrtCodeEnums.fromArgtCode(agrtCode)) {
        			callBackFtpSurrenderStatus(shopOrderDto, policyNo);
        		}
        	}*/
        	/* added by lshuang 2017/12/29 for RM-4353 和包支付-航空意外险-SFTP每日对账 end*/
          	/* delete by hguoqing 2018/3/26 for FTP对账数据上传公共化,接口整改  end */


        	// 退保回调公共方法--具体逻辑写在DYSUB,ORDER不写处理逻辑
        	orderCallbackDysubData(shopOrderDto, policyNo, Constants.DEAL_TYPE_CANCEL);
        }

        // 成功返回信息
        responseMessage.setMessage(SUCCESS_MSG);
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);
        return responseMessage;
    }
    
    /**
     * 5.2.13 查询保单列表
     * 
     * @Author: lujicong
     * @Date: 2015-12-24
     * @Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    @Override
    public ResponseMessage queryPolicyList(RequestMessage requestMessageObj) throws Exception {
        ResponseMessage responseMessage = new ResponseMessage();
        QueryPolicyListReq queryPolicyListReq = requestMessageObj.getData().getQueryPolicyListReq();

        String uid = requestMessageObj.getUserId();
        Integer startIndex = queryPolicyListReq.getStartIndex();
        Integer pageSize = queryPolicyListReq.getPageSize();
        String invalidFlag = queryPolicyListReq.getInvalidFlag();
        String policyNo = queryPolicyListReq.getPolicyNo();
        String docType = queryPolicyListReq.getDocType();
        String docNo = queryPolicyListReq.getDocNo();
        String docName = queryPolicyListReq.getDocName();
        String queryFlag = queryPolicyListReq.getQueryFlag();//不传或1-常规查询；2-客制化查询（前端证件类型：身份证、护照、其他）

        // 传入信息校验
        StringBuffer checkMsg = new StringBuffer();
        if (StringUtil.isEmpty(uid)) {
            /*
             * if(StringUtil.isEmpty(policyNo)) { checkMsg.append("保单号不能为空,"); }
             */
        	/* modifeid by hbiao 2018/09/06 for [NP-127][TC-10619]客制化需求变更-身份验证页面-保单有效性验证问题 begin */
        	if (StringUtil.isEmpty(queryFlag) 
        			|| StringUtil.isNotEmpty(queryFlag) && ToolUtils.contains(queryFlag, "1")) {
        		if (StringUtil.isEmpty(docType)) {
        			checkMsg.append("证件类型不能为空,");
        		}
        	}
        	/* modifeid by hbiao 2018/09/06 for [NP-127][TC-10619]客制化需求变更-身份验证页面-保单有效性验证问题 end */
            if (StringUtil.isEmpty(docNo)) {
                checkMsg.append("证件号不能为空,");
            }
        } else {
            if (startIndex == null) {
                checkMsg.append("开始位置不能为空,");
            }
            if (pageSize == null) {
                checkMsg.append("每页数量不能为空,");
            }
        }
        if (StringUtil.isNotEmpty(checkMsg.toString())) {
            responseMessage.setMessage(checkMsg.substring(0, checkMsg.length() - 1));
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }

        List<PolicyInfo> policyInfoList = null;
        int total = 0;
        if (StringUtil.isNotEmpty(uid)) {
            BigInteger userId = new BigInteger(uid);
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("userId", userId);
            paramMap.put("startIndex", startIndex);
            paramMap.put("pageSize", pageSize);
            paramMap.put("invalidFlag", invalidFlag);
            paramMap.put("currentDate", new Date());
            paramMap.put("objectCondition", " order by a1.add_time desc"); // 自定义
            policyInfoList = orderMainService.queryPolicyList(paramMap);
            paramMap.put("actionType", "count");
            total = orderMainService.queryPolicyCount(paramMap);

        } else {
            if (StringUtil.isEmpty(policyNo)) {
                List<Object> orderCodeList = new ArrayList<Object>();

                OrderCustomerDto orderCustomerDto = new OrderCustomerDto();
                orderCustomerDto.setCustomerFlag("2");
                orderCustomerDto.setDocType(docType);
                orderCustomerDto.setDocNo(docNo);
                orderCustomerDto.setCustomerName(docName);
                List<OrderCustomerDto> customerList = orderCustomerService.select(orderCustomerDto);
                if (CollectionUtil.isNotEmpty(customerList)) {
                    for (OrderCustomerDto item : customerList) {
                    	/* modifeid by hbiao 2018/09/06 for [NP-127][TC-10619]客制化需求变更-身份验证页面-保单有效性验证问题 begin */
                    	if (StringUtil.isNotEmpty(queryFlag) && StringUtil.isEmpty(docType) && ToolUtils.contains(queryFlag, "2") && ToolUtils.contains(item.getDocType(), "01,03")) {
                    		continue;
                    	}
                    	/* modifeid by hbiao 2018/09/06 for [NP-127][TC-10619]客制化需求变更-身份验证页面-保单有效性验证问题 end */
                        this.getOrderCode4Customer(invalidFlag, orderCodeList, item.getOrderMainId(), item.getOrderCode(), queryFlag);
                    }
                }

                OrderItemAcciLstDto orderItemAcciLstDto = new OrderItemAcciLstDto();
                orderItemAcciLstDto.setDocType(docType);
                orderItemAcciLstDto.setDocNo(docNo);
                orderItemAcciLstDto.setCustomerName(docName);
                List<OrderItemAcciLstDto> acciLstList = orderItemAcciLstService.select(orderItemAcciLstDto);
                if (CollectionUtil.isNotEmpty(acciLstList)) {
                    for (OrderItemAcciLstDto item : acciLstList) {
                    	/* modifeid by hbiao 2018/09/06 for [NP-127][TC-10619]客制化需求变更-身份验证页面-保单有效性验证问题 begin */
                    	if (StringUtil.isNotEmpty(queryFlag) && StringUtil.isEmpty(docType) && ToolUtils.contains(queryFlag, "2") && ToolUtils.contains(item.getDocType(), "01,03")) {
                    		continue;
                    	}
                    	/* modifeid by hbiao 2018/09/06 for [NP-127][TC-10619]客制化需求变更-身份验证页面-保单有效性验证问题 end */
                        this.getOrderCode4Customer(invalidFlag, orderCodeList, item.getOrderMainId(), item.getOrderCode(), queryFlag);
                    }
                }

                if (CollectionUtil.isNotEmpty(orderCodeList)) {
                    Condition shopOrderInfoCond = new Condition(ShopOrderInfoDto.class);
                    shopOrderInfoCond.setOrderByClause("addTime desc");
                    shopOrderInfoCond.createCriteria().andIn("orderCode", orderCodeList);
                    PageDto<ShopOrderInfoDto> pageDto = new PageDto<ShopOrderInfoDto>();
                    pageDto.setPageNo(startIndex);
                    pageDto.setPageSize(pageSize);
                    PageDto<ShopOrderInfoDto> shopOrderPageDto = shopOrderInfoService.selectByPage(pageDto, shopOrderInfoCond);
                    List<ShopOrderInfoDto> shopOrderInfoList = shopOrderPageDto.getResults();
                    policyInfoList = new ArrayList<PolicyInfo>();
                    if (CollectionUtil.isNotEmpty(shopOrderInfoList)) {
                        PolicyInfo policyInfo = null;
                        ShopOrderGoodsDto orderGoodsDto = null;
                        List<ShopOrderGoodsDto> goodsList = null;
                        OrderMainDto orderMainDto = null;
                        for (ShopOrderInfoDto item : shopOrderInfoList) {

                            orderGoodsDto = new ShopOrderGoodsDto();
                            orderGoodsDto.setOrderCode(item.getOrderCode());
                            goodsList = shopOrderGoodsService.select(orderGoodsDto);

                            orderGoodsDto = goodsList.get(0);

                            orderMainDto = new OrderMainDto();
                            orderMainDto.setOrderMainId(orderGoodsDto.getGoodsNo());
                            orderMainDto.setOrderCode(orderGoodsDto.getOrderCode());
                            orderMainDto = orderMainService.selectOne(orderMainDto);

                            policyInfo = new PolicyInfo();
                            policyInfo.setUserId(String.valueOf(item.getUserId()));
                            policyInfo.setOrderCode(String.valueOf(item.getOrderCode()));
                            policyInfo.setOrderMainId(String.valueOf(orderMainDto.getOrderMainId()));
                            if (StringUtil.isEmpty(orderMainDto.getAssociatedNo())) {
                                policyInfo.setPolicyNo(orderMainDto.getPolicyNo());
                                policyInfo.setRiskCode(orderGoodsDto.getGoodsId());
                            } else {
                                policyInfo.setPolicyNo(orderMainDto.getAssociatedNo());
                                policyInfo.setRiskCode("9999");
                            }
                            policyInfo.setRiskName(orderMainDto.getProductName());
                            policyInfo.setStartDate(orderMainDto.getStartDate());
                            policyInfo.setEndDate(orderMainDto.getEndDate());
                            policyInfo.setInvalidFlag(invalidFlag);
                            policyInfo.setAddTime(item.getAddTime());
                            policyInfo.setGoodsAmount(item.getGoodsAmount());
                            policyInfo.setReferer(item.getReferer());
                            policyInfo.setStatus(orderMainDto.getStatus());
                            /*added by lshuang 2018/05/15 for RM-6546 爱马市-个人账户资金安全保险-家财险begin*/
                            policyInfo.setAgrtCode(orderMainDto.getAgrtCode());
                            /*added by lshuang 2018/05/15 for RM-6546 爱马市-个人账户资金安全保险-家财险end*/
                            policyInfoList.add(policyInfo);
                        }
                    }
                    total = (int) shopOrderPageDto.getTotalSize();
                }
            } else {
                OrderMainDto orderMainDto = new OrderMainDto();
                orderMainDto.setPolicyNo(policyNo);
                orderMainDto = orderMainService.selectOne(orderMainDto);
                if (orderMainDto == null) {
                    orderMainDto = new OrderMainDto();
                    orderMainDto.setAssociatedNo(policyNo);
                    orderMainDto = orderMainService.selectOne(orderMainDto);
                }

                boolean flag = false;
                if (orderMainDto != null) {
                    int status = Integer.parseInt(orderMainDto.getStatus());
                    if ("0".equals(invalidFlag)) {
                        if ((status == 5) || ((status == 3 || status == 6 || status == 8) && TimeUtil.isBeforeNow(orderMainDto.getEndDate()))) {
                            flag = true;
                        }
                    } else {
                        if ((status == 7) || ((status == 3 || status == 6 || status == 8) && TimeUtil.isAfterNow(orderMainDto.getEndDate()))) {
                            flag = true;
                        }
                    }
                }

                if (orderMainDto != null && flag) {
                    PolicyInfo policyInfo = new PolicyInfo();

                    ShopOrderInfoDto shopOrderInfoDto = new ShopOrderInfoDto();
                    shopOrderInfoDto.setOrderCode(orderMainDto.getOrderCode());
                    shopOrderInfoDto = shopOrderInfoService.selectByPrimaryKey(shopOrderInfoDto);

                    policyInfo.setUserId(String.valueOf(shopOrderInfoDto.getUserId()));
                    policyInfo.setOrderCode(String.valueOf(shopOrderInfoDto.getOrderCode()));
                    policyInfo.setOrderMainId(String.valueOf(orderMainDto.getOrderMainId()));
                    if (StringUtil.isEmpty(orderMainDto.getAssociatedNo())) {

                        ShopOrderGoodsDto orderGoodsDto = new ShopOrderGoodsDto();
                        orderGoodsDto.setOrderCode(orderMainDto.getOrderCode());
                        orderGoodsDto.setGoodsNo(orderMainDto.getOrderMainId());
                        orderGoodsDto = shopOrderGoodsService.selectOne(orderGoodsDto);

                        policyInfo.setPolicyNo(orderMainDto.getPolicyNo());
                        policyInfo.setRiskCode(orderGoodsDto.getGoodsId());
                    } else {
                        policyInfo.setPolicyNo(orderMainDto.getAssociatedNo());
                        policyInfo.setRiskCode("9999");
                    }
                    policyInfo.setRiskName(orderMainDto.getProductName());
                    policyInfo.setStartDate(orderMainDto.getStartDate());
                    policyInfo.setEndDate(orderMainDto.getEndDate());
                    policyInfo.setInvalidFlag(invalidFlag);
                    policyInfo.setAddTime(shopOrderInfoDto.getAddTime());
                    policyInfo.setGoodsAmount(shopOrderInfoDto.getGoodsAmount());
                    policyInfo.setReferer(shopOrderInfoDto.getReferer());
                    policyInfo.setStatus(orderMainDto.getStatus());

                    policyInfoList = new ArrayList<PolicyInfo>();
                    policyInfoList.add(policyInfo);
                }
            }
        }

        if (CollectionUtil.isNotEmpty(policyInfoList) && policyInfoList.size() > 1) {
            Collections.sort(policyInfoList, new SortPolicyInfo());
        }

        QueryPolicyListResp queryPolicyListResp = new QueryPolicyListResp();
        queryPolicyListResp.setPolicyInfoList(policyInfoList);
        queryPolicyListResp.setTotal(total);
        responseMessage.getData().setQueryPolicyListResp(queryPolicyListResp);

        responseMessage.setMessage(SUCCESS_MSG);
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);
        return responseMessage;
    }
   
    private void getOrderCode4Customer(String invalidFlag, List<Object> orderCodeList, BigInteger orderMainId, BigInteger orderCode, String queryFlag) {
        OrderMainDto orderMainDto = new OrderMainDto();
        orderMainDto.setOrderCode(orderCode);
        orderMainDto.setOrderMainId(orderMainId);
        List<OrderMainDto> mainList = orderMainService.select(orderMainDto);
        orderMainDto = mainList.get(0);
        int status = Integer.parseInt(orderMainDto.getStatus());
        if ("0".equals(invalidFlag)) {
        	/* modifeid by hbiao 2018/09/06 for [NP-127][TC-10619]客制化需求变更-身份验证页面-保单有效性验证问题(180天)  */
        	if (StringUtil.isNotEmpty(queryFlag) && ToolUtils.contains(queryFlag, "2")) {
        		if ((status == 5) || ((status == 3 || status == 6 || status == 8) && TimeUtil.isBeforeNow(TimeUtil.addDays(orderMainDto.getEndDate(), 180)))) {
        			orderCodeList.add(orderCode);
        		}
        	} else {
        		if ((status == 5) || ((status == 3 || status == 6 || status == 8) && TimeUtil.isBeforeNow(orderMainDto.getEndDate()))) {
        			orderCodeList.add(orderCode);
        		}
        	}
        } else {
        	/* modifeid by hbiao 2018/09/06 for [NP-127][TC-10619]客制化需求变更-身份验证页面-保单有效性验证问题(180天)  */
        	if (StringUtil.isNotEmpty(queryFlag) && ToolUtils.contains(queryFlag, "2")) {
        		if ((status == 7) || ((status == 3 || status == 6 || status == 8) && TimeUtil.isAfterNow(TimeUtil.addDays(orderMainDto.getEndDate(), 180)))) {
        			orderCodeList.add(orderCode);
        		}
        	} else {
        		if ((status == 7) || ((status == 3 || status == 6 || status == 8) && TimeUtil.isAfterNow(orderMainDto.getEndDate()))) {
        			orderCodeList.add(orderCode);
        		}
        	}
        }
    }
    
    /**
     * 5.2.14 查询保单详情
     * 
     * @Author: lujicong
     * @Date: 2015-12-24
     * @Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    @Override
    public ResponseMessage queryPolicyDetailInfo(RequestMessage requestMessageObj) throws Exception {
        ResponseMessage responseMessage = new ResponseMessage();
        QueryPolicyDetailInfoReq queryPolicyDetailInfoReq = requestMessageObj.getData().getQueryPolicyDetailInfoReq();

        String uid = requestMessageObj.getUserId();
        String orderIdTmp = queryPolicyDetailInfoReq.getOrderId();
        String policyNo = queryPolicyDetailInfoReq.getPolicyNo();
        // String docType = queryPolicyDetailInfoReq.getDocType();
        // String docNo = queryPolicyDetailInfoReq.getDocNo();
        // String docName=queryPolicyDetailInfoReq.getDocName();
        // 传入信息校验
        StringBuffer checkMsg = new StringBuffer();
        /*
         * if (StringUtil.isEmpty(uid)) { checkMsg.append("用户ID不能为空,"); }
         */
        /*
         * if (StringUtil.isEmpty(orderIdTmp)) { checkMsg.append("订单ID不能为空,"); }
         */
        if (StringUtil.isEmpty(policyNo)) {
            checkMsg.append("保单号不能为空,");
        } else {
        	if (policyNo.length() < 10) {
                checkMsg.append("保单号长度至少大于10,");
            } 
        }
        if (StringUtil.isNotEmpty(checkMsg.toString())) {
            responseMessage.setMessage(checkMsg.substring(0, checkMsg.length() - 1));
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }

        BigInteger userId = null;
        String riskCode = policyNo.substring(5, 9); // 鉴于保单号不为空
        OrderDto policyInfo = new OrderDto();

        // 订单信息
        OrderMainDto orderMainDto = null;
        BigInteger orderId = null;
        if (StringUtil.isNotEmpty(orderIdTmp) && StringUtil.isNotEmpty(uid)) { // 订单号和用户ID不为空
            userId = new BigInteger(uid);
            orderId = new BigInteger(orderIdTmp);
            orderMainDto = new OrderMainDto();
            orderMainDto.setUserId(userId);
            orderMainDto.setOrderMainId(orderId);
            if (!Constants.RISK_CODE_9999.equals(riskCode)) {
                orderMainDto.setPolicyNo(policyNo);
            } else {
                orderMainDto.setAssociatedNo(policyNo);
            }
            orderMainDto = orderMainService.selectOne(orderMainDto);
        } else if (StringUtil.isEmpty(orderIdTmp) && StringUtil.isNotEmpty(uid)) {
            userId = new BigInteger(uid);
            orderMainDto = new OrderMainDto();
            orderMainDto.setUserId(userId);
            if (!Constants.RISK_CODE_9999.equals(riskCode)) {
                orderMainDto.setPolicyNo(policyNo);
                orderMainDto = orderMainService.selectOne(orderMainDto);
            } else {
                orderMainDto.setAssociatedNo(policyNo);
                List<OrderMainDto> orderMainList = orderMainService.select(orderMainDto);
                if (CollectionUtil.isNotEmpty(orderMainList)) {
                    orderMainDto = orderMainList.get(0);
                } else {
                    orderMainDto = null;
                }
            }
        } else {
            OrderMainDto mainDto = new OrderMainDto();
            if (Constants.RISK_CODE_9999.equals(riskCode)) {
                mainDto.setAssociatedNo(policyNo);
            } else {
                mainDto.setPolicyNo(policyNo);
            }
            List<OrderMainDto> orderMainList = orderMainService.select(mainDto);

            if (CollectionUtil.isEmpty(orderMainList)) {
                responseMessage.setMessage("该保单数据不存在");
                responseMessage.setCode(FAIL_CODE);
                responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
                responseMessage.setState(FAIL_STATE);
                return responseMessage;
            }

            orderMainDto = orderMainList.get(0);

            if (Constants.RISK_CODE_9999.equals(riskCode)) {
                boolean flag = false;
                BigInteger orderCode = orderMainList.get(0).getOrderCode();
                for (OrderMainDto orderMain : orderMainList) {
                    if (!orderCode.equals(orderMain.getOrderCode())) {
                        flag = true;
                        break;
                    }
                }
                if (flag) { // 组合产品拆分不同订单情况
                    return this.queryPolicyDetailInfoList(policyNo, riskCode, orderMainList);
                }
            }
        }

        orderId = orderMainDto.getOrderMainId();

        QueryPolicyDetailInfoResp queryPolicyDetailInfoResp = new QueryPolicyDetailInfoResp();
        List<OrderDto> policyInfoList = this.getPolicyDetailInfo(orderId, riskCode, orderMainDto.getOrderCode());
        if (!Constants.RISK_CODE_9999.equals(riskCode)) {
            if (CollectionUtil.isNotEmpty(policyInfoList)) {
                policyInfo = policyInfoList.get(0);
            }
        } else {
            queryPolicyDetailInfoResp.setPolicyInfoList(policyInfoList);
        }

        queryPolicyDetailInfoResp.setPolicyInfo(policyInfo);

        responseMessage.getData().setQueryPolicyDetailInfoResp(queryPolicyDetailInfoResp);

        responseMessage.setMessage(SUCCESS_MSG);
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);
        return responseMessage;
    }
    
    /**
     * 查询组合险保单详情列表(存在一个大保单对应多个订单号和多个子保单号的情况)
     * <p>
     * User: lpengfei
     * <p>
     * Date: 2017年1月5日
     * <p>
     * Version: 1.0
     */
    public ResponseMessage queryPolicyDetailInfoList(String policyNo, String riskCode, List<OrderMainDto> orderMainList) throws Exception {
        ResponseMessage responseMessage = new ResponseMessage();
        List<OrderDto> policyInfoList = new ArrayList<OrderDto>();
        for (OrderMainDto orderMainDto : orderMainList) {

            if (orderMainDto == null || !policyNo.equals(orderMainDto.getAssociatedNo())) {
                responseMessage.setMessage("该保单数据不存在");
                responseMessage.setCode(FAIL_CODE);
                responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
                responseMessage.setState(FAIL_STATE);
                return responseMessage;
            }

            BigInteger orderId = orderMainDto.getOrderMainId();

            List<OrderDto> orderList = this.getPolicyDetailInfo(orderId, riskCode, orderMainDto.getOrderCode());
            for (OrderDto policyInfo : orderList) {
                policyInfoList.add(policyInfo);
            }
        }
        QueryPolicyDetailInfoResp queryPolicyDetailInfoResp = new QueryPolicyDetailInfoResp();
        queryPolicyDetailInfoResp.setPolicyInfoList(policyInfoList);
        responseMessage.getData().setQueryPolicyDetailInfoResp(queryPolicyDetailInfoResp);

        responseMessage.setMessage("success");
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);
        return responseMessage;
    }
    
    /**
     * 获取保单详情信息
     * 
     * <p>
     * User: lpengfei
     * 
     * @Date: 2016-12-12
     * @Version: 1.0
     * @param userId
     * @param orderCode
     * @return
     */
    public List<OrderDto> getPolicyDetailInfo(BigInteger orderId, String riskCode, BigInteger orderCode) {
        List<OrderDto> policyInfoList = new ArrayList<OrderDto>();

        // 订单信息列表
        OrderDto policyInfo = null;
        // 订单商品关联信息
        ShopOrderGoodsDto queryShopOrderGoods = new ShopOrderGoodsDto();
        if (!Constants.RISK_CODE_9999.equals(riskCode)) {
            queryShopOrderGoods.setGoodsNo(orderId);
        }
        queryShopOrderGoods.setOrderCode(orderCode);
        queryShopOrderGoods.setInvalidFlag(0);
        List<ShopOrderGoodsDto> shopOrderGoodsList = shopOrderGoodsService.select(queryShopOrderGoods);
        for (ShopOrderGoodsDto goodsDto : shopOrderGoodsList) {

            orderId = goodsDto.getGoodsNo();
            policyInfo = new OrderDto();

            // 订单信息
            OrderMainDto orderMainDto = new OrderMainDto();
            orderMainDto.setOrderCode(orderCode);
            orderMainDto.setOrderMainId(orderId);
            orderMainDto = orderMainService.selectOne(orderMainDto);

            // 是否有效标志
            if (ORDER_CANCEL_STATUS.equals(orderMainDto.getStatus())) {
                orderMainDto.setInvalidFlag(1); // 无效
            } else if (ORDER_DEAL_STATUS.indexOf(orderMainDto.getStatus()) > -1) {
                if (TimeUtil.isBeforeNow(orderMainDto.getEndDate())) {
                    orderMainDto.setInvalidFlag(1); // 无效
                } else {
                    orderMainDto.setInvalidFlag(0); // 有效
                }
            } else {
                orderMainDto.setInvalidFlag(0); // 有效
            }

            orderId = orderMainDto.getOrderMainId();
            orderCode = orderMainDto.getOrderCode();

            policyInfo.setOrderMain(orderMainDto);

            // 合作方信息列表
            OrderPartnerDto orderPartnerDto = new OrderPartnerDto();
            orderPartnerDto.setOrderCode(orderCode);
            orderPartnerDto.setOrderMainId(orderId);
            List<OrderPartnerDto> partnerList = orderPartnerService.select(orderPartnerDto);
            policyInfo.setPartnerList(partnerList);
			
            // 业务员信息列表
            OrderSalesmanDto orderSalesmanDto = new OrderSalesmanDto();
            orderSalesmanDto.setOrderCode(orderCode);
            orderSalesmanDto.setOrderMainId(orderId);
            List<OrderSalesmanDto> salesmanList = orderSalesmanService.select(orderSalesmanDto);
            policyInfo.setSalesmanList(salesmanList);
			
            // 订单商品关联信息
            policyInfo.setOrderGoods(goodsDto);

            // 订单详情信息
            ShopOrderInfoDto shopOrderInfoDto = new ShopOrderInfoDto();
            shopOrderInfoDto.setOrderCode(orderCode);
            shopOrderInfoDto = shopOrderInfoService.selectByPrimaryKey(shopOrderInfoDto);
            policyInfo.setShopOrderInfo(shopOrderInfoDto);

            // 险别信息列表
            OrderItemkindDto orderItemkindDto = new OrderItemkindDto();
            orderItemkindDto.setOrderCode(orderCode);
            orderItemkindDto.setOrderMainId(orderId);
            orderItemkindDto.setInvalidFlag(0);
            List<OrderItemkindDto> itemkindList = orderItemkindService.select(orderItemkindDto);

            policyInfo.setItemkindList(itemkindList);

            // 条款信息列表
            OrderClausesDto orderClausesDto = new OrderClausesDto();
            orderClausesDto.setOrderCode(orderCode);
            orderClausesDto.setOrderMainId(orderId);
            orderClausesDto.setInvalidFlag(0);
            List<OrderClausesDto> clausesList = orderClausesService.select(orderClausesDto);

            policyInfo.setClausesList(clausesList);

            // 特别约定信息列表
            OrderSpecialClausesDto orderSpecialClausesDto = new OrderSpecialClausesDto();
            orderSpecialClausesDto.setOrderCode(orderCode);
            orderSpecialClausesDto.setOrderMainId(orderId);
            orderSpecialClausesDto.setInvalidFlag(0);
            List<OrderSpecialClausesDto> orderSpecialClausesList = orderSpecialClausesService.select(orderSpecialClausesDto);

            policyInfo.setSpecialClausesList(orderSpecialClausesList);

            // 限额信息列表
            OrderLimitDto orderLimitDto = new OrderLimitDto();
            orderLimitDto.setOrderCode(orderCode);
            orderLimitDto.setOrderMainId(orderId);
            orderLimitDto.setInvalidFlag(0);
            List<OrderLimitDto> orderLimitList = orderLimitService.select(orderLimitDto);

            policyInfo.setLimitList(orderLimitList);

            // 免赔信息列表
            OrderDeductibleDto orderDeductibleDto = new OrderDeductibleDto();
            orderDeductibleDto.setOrderCode(orderCode);
            orderDeductibleDto.setOrderMainId(orderId);
            orderDeductibleDto.setInvalidFlag(0);
            List<OrderDeductibleDto> orderDeductibleList = orderDeductibleService.select(orderDeductibleDto);

            policyInfo.setDeductibleList(orderDeductibleList);
            
            // 赔付信息列表
            OrderClaimDto orderClaimDto = new OrderClaimDto();
            orderClaimDto.setOrderCode(orderCode);
            orderClaimDto.setOrderMainId(orderId);
            orderClaimDto.setInvalidFlag(0);
            List<OrderClaimDto> orderClaimList = orderClaimService.select(orderClaimDto);
            
            policyInfo.setOrderClaimList(orderClaimList);

            // 支付信息
            OrderPayinfoDto orderPayinfoDto = new OrderPayinfoDto();
            orderPayinfoDto.setOrderCode(orderCode);
            orderPayinfoDto.setOrderMainId(orderId);
            orderPayinfoDto.setInvalidFlag(0);
            orderPayinfoDto = orderPayinfoService.selectOne(orderPayinfoDto);

            policyInfo.setPayinfo(orderPayinfoDto);

            // 客户信息列表
            OrderCustomerDto orderCustomerDto = new OrderCustomerDto();
            orderCustomerDto.setOrderCode(orderCode);
            orderCustomerDto.setOrderMainId(orderId);
            orderCustomerDto.setInvalidFlag(0);
            List<OrderCustomerDto> customerList = orderCustomerService.select(orderCustomerDto);
            policyInfo.setCustomerList(customerList);

            // 意健险人员清单列表
            OrderItemAcciLstDto orderItemAcciLstDto = new OrderItemAcciLstDto();
            orderItemAcciLstDto.setOrderCode(orderCode);
            orderItemAcciLstDto.setOrderMainId(orderId);
            orderItemAcciLstDto.setInvalidFlag(0);
            List<OrderItemAcciLstDto> acciLstList = orderItemAcciLstService.select(orderItemAcciLstDto);

            policyInfo.setAcciLstList(acciLstList);

            // 家财标的信息
            OrderPropertyDto orderPropertyDto = new OrderPropertyDto();
            orderPropertyDto.setOrderCode(orderCode);
            orderPropertyDto.setOrderMainId(orderId);
            orderPropertyDto.setInvalidFlag(0);
            orderPropertyDto = orderPropertyService.selectOne(orderPropertyDto);

            policyInfo.setProperty(orderPropertyDto);

            // 动态标的信息
            OrderDynamicItemDto orderDynamicItemDto = new OrderDynamicItemDto();
            orderDynamicItemDto.setOrderCode(orderCode);
            orderDynamicItemDto.setOrderMainId(orderId);
            orderDynamicItemDto.setInvalidFlag(0);
            List<OrderDynamicItemDto> orderDynamicItemList = orderDynamicItemService.select(orderDynamicItemDto);

            policyInfo.setDynamicItemList(orderDynamicItemList);

            // 动态清单信息
            OrderDynamicListDto orderDynamicListDto = new OrderDynamicListDto();
            orderDynamicListDto.setOrderCode(orderCode);
            orderDynamicListDto.setOrderMainId(orderId);
            orderDynamicListDto.setInvalidFlag(0);
            List<OrderDynamicListDto> orderDynamicListList = orderDynamicListService.select(orderDynamicListDto);

            policyInfo.setDynamicListList(orderDynamicListList);

            // 货运险标的信息
            OrderCargoDto orderCargoDto = new OrderCargoDto();
            orderCargoDto.setOrderCode(orderCode);
            orderCargoDto.setOrderMainId(orderId);
            orderCargoDto.setInvalidFlag(0);
            orderCargoDto = orderCargoService.selectOne(orderCargoDto);

            policyInfo.setCargo(orderCargoDto);

            // 货运险标的详情信息列表
            OrderCargoDtlDto orderCargoDtlDto = new OrderCargoDtlDto();
            orderCargoDtlDto.setOrderCode(orderCode);
            orderCargoDtlDto.setOrderMainId(orderId);
            orderCargoDtlDto.setInvalidFlag(0);
            List<OrderCargoDtlDto> orderCargoDtlList = orderCargoDtlService.select(orderCargoDtlDto);

            policyInfo.setCargoDtlList(orderCargoDtlList);

            // 货运险缴费计划信息列表
            OrderPaymentPlanDto orderCargoPaymentPlanDto = new OrderPaymentPlanDto();
            orderCargoPaymentPlanDto.setOrderCode(orderCode);
            orderCargoPaymentPlanDto.setOrderMainId(orderId);
            orderCargoPaymentPlanDto.setInvalidFlag(0);
            List<OrderPaymentPlanDto> orderCargoPaymentPlanList = orderCargoPaymentPlanService.select(orderCargoPaymentPlanDto);

            policyInfo.setPaymentPlan(orderCargoPaymentPlanList);

            // 意健险险种动态标的
            OrderRiskDynamicDto orderRiskDynamicDto = new OrderRiskDynamicDto();
            orderRiskDynamicDto.setOrderCode(orderCode);
            orderRiskDynamicDto.setOrderMainId(orderId);
            orderRiskDynamicDto.setInvalidFlag(0);
            List<OrderRiskDynamicDto> orderRiskDynamicDtoList = orderRiskDynamicService.select(orderRiskDynamicDto);

            policyInfo.setRiskDynamicList(orderRiskDynamicDtoList);

            // 意健险标的信息
            OrderItemAcciDto orderItemAcciDto = new OrderItemAcciDto();
            orderItemAcciDto.setOrderCode(orderCode);
            orderItemAcciDto.setOrderMainId(orderId);
            orderItemAcciDto.setInvalidFlag(0);
            List<OrderItemAcciDto> itemAcciList = orderItemAcciService.select(orderItemAcciDto);
            if (CollectionUtil.isNotEmpty(itemAcciList)) {
                for (OrderItemAcciDto orderItemAcci : itemAcciList) {
                    // 意健险人员清单
                    OrderItemAcciLstDto orderItemAcciLst = new OrderItemAcciLstDto();
                    orderItemAcciLst.setOrderCode(orderCode);
                    orderItemAcciLst.setOrderMainId(orderId);
                    orderItemAcciLst.setItemNo(orderItemAcci.getItemNo());
                    orderItemAcciLst.setInvalidFlag(0);
                    List<OrderItemAcciLstDto> orderItemAcciLstDtoList = orderItemAcciLstService.select(orderItemAcciLst);
                    if (CollectionUtil.isNotEmpty(orderItemAcciLstDtoList)) {
                        for (OrderItemAcciLstDto itemAcciLstDto : orderItemAcciLstDtoList) {
                            BigInteger acciLstId = itemAcciLstDto.getAcciListId();
                            // 意外险受益人清单
                            OrderItemAcciBenDto orderItemAcciBenDto = new OrderItemAcciBenDto();
                            orderItemAcciBenDto.setOrderCode(orderCode);
                            orderItemAcciBenDto.setAcciListId(acciLstId);
                            orderItemAcciBenDto.setOrderMainId(orderId);
                            orderItemAcciBenDto.setItemNo(orderItemAcci.getItemNo());
                            orderItemAcciBenDto.setInvalidFlag(0);
                            List<OrderItemAcciBenDto> orderItemAcciBenDtoList = orderItemAcciBenService.select(orderItemAcciBenDto);
                            itemAcciLstDto.setAcciBenefitList(orderItemAcciBenDtoList);
                        }
                    }
                    orderItemAcci.setAcciInsuredList(orderItemAcciLstDtoList);
                }
                policyInfo.setItemAcciList(itemAcciList);
            }
            policyInfoList.add(policyInfo);
        }

        return policyInfoList;
    }
    
    /**
     * 5.2.15 通过订单号查询用户ID
     * 
     * @Author: lujicong
     * @Date: 2015-12-24
     * @Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    @Override
    public ResponseMessage queryUserIdByOrderCode(RequestMessage requestMessageObj) throws Exception {
        ResponseMessage responseMessage = new ResponseMessage();
        QueryUserIdByOrderCodeReq queryUserIdByOrderCodeReq = requestMessageObj.getData().getQueryUserIdByOrderCodeReq();

        String orderTmpCode = queryUserIdByOrderCodeReq.getOrderCode();

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

        // 订单号找到用户ID
        OrderIdxUserIdDto orderIdxUserIdDto = new OrderIdxUserIdDto();
        orderIdxUserIdDto.setOrderCode(orderCode);
        orderIdxUserIdDto = orderIdxUserIdService.selectByPrimaryKey(orderIdxUserIdDto);
        if (orderIdxUserIdDto == null) {
            responseMessage.setMessage("该订单号在订单用户ID索引表中没有找到记录");
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }
        QueryUserIdByOrderCodeResp queryUserIdByOrderCodeResp = new QueryUserIdByOrderCodeResp();
        queryUserIdByOrderCodeResp.setUserId(orderIdxUserIdDto.getUserId());
        responseMessage.getData().setQueryUserIdByOrderCodeResp(queryUserIdByOrderCodeResp);

        responseMessage.setMessage(SUCCESS_MSG);
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);
        return responseMessage;
    }
    
    /**
     * 5.2.18 查询订单支付情况
     * 
     * @Author: lujicong
     * @Date: 2015-02-17
     * @Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    @Override
    public ResponseMessage queryOrderPayStatus(RequestMessage requestMessageObj) throws Exception {
        ResponseMessage responseMessage = new ResponseMessage();
        QueryOrderPayStatusReq queryOrderPayStatusReq = requestMessageObj.getData().getQueryOrderPayStatusReq();

        String uid = requestMessageObj.getUserId(); // 用户ID
        String orderTmpCode = queryOrderPayStatusReq.getOrderCode();

        // 传入信息校验
        StringBuffer checkMsg = new StringBuffer();
        if (StringUtil.isEmpty(uid)) {
            checkMsg.append("用户ID不能为空,");
        }
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

        QueryOrderPayStatusResp queryOrderPayStatusResp = new QueryOrderPayStatusResp();

        Object payStatus = null;
        try {
            payStatus = redisTemplate.get(ODST_PREFIX + orderTmpCode);
        } catch (Exception e) {
            ShopOrderPayinfoDto orderPayinfoDto = new ShopOrderPayinfoDto();
            orderPayinfoDto.setUserId(new BigInteger(uid));
            orderPayinfoDto.setOrderCode(new BigInteger(orderTmpCode));
            orderPayinfoDto = shopOrderPayinfoService.selectOne(orderPayinfoDto);
            payStatus = orderPayinfoDto.getPayStatus();
        }

        if (payStatus == null) {
            ShopOrderPayinfoDto orderPayinfoDto = new ShopOrderPayinfoDto();
            orderPayinfoDto.setUserId(new BigInteger(uid));
            orderPayinfoDto.setOrderCode(new BigInteger(orderTmpCode));
            orderPayinfoDto = shopOrderPayinfoService.selectOne(orderPayinfoDto);
            queryOrderPayStatusResp.setPayStatus(orderPayinfoDto.getPayStatus());
            payStatus = orderPayinfoDto.getPayStatus();
        } else {
            queryOrderPayStatusResp.setPayStatus((String) payStatus);
        }

        // 支付状态写入缓存
        try {
            redisTemplate.set(ODST_PREFIX + orderTmpCode, (String) payStatus, Constants.EXPIRE_TIME);
        } catch (Exception e) {
            logger.error("ODST_[" + orderTmpCode + "]写入Redis缓存失败," + e);
        }

        responseMessage.getData().setQueryOrderPayStatusResp(queryOrderPayStatusResp);

        responseMessage.setMessage(SUCCESS_MSG);
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);
        return responseMessage;
    }
    
    /**
     * 5.2.19 订单转保单
     * 
     * @Author: lujicong
     * @Date: 2015-03-01
     * @Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
    public ResponseMessage orderToPolicy(RequestMessage requestMessageObj) throws Exception {
        ResponseMessage responseMessage = new ResponseMessage();
        OrderToPolicyReq orderToPolicyReq = requestMessageObj.getData().getOrderToPolicyReq();
        
        String uid = requestMessageObj.getUserId(); // 用户ID
        String queryOrderCode = orderToPolicyReq.getOrderCode();
        String disposeType = orderToPolicyReq.getDisposeType();
        if(StringUtil.isEmpty(requestMessageObj.getIsSubPolicy())){
        	requestMessageObj.setIsSubPolicy("N");
        }
        
        // 传入信息校验
        StringBuffer checkMsg = new StringBuffer();
        if (StringUtil.isEmpty(uid)) {
            checkMsg.append("用户ID不能为空,");
        }
        if(StringUtil.isEmpty(queryOrderCode)) {
            checkMsg.append("订单号不能为空,");
        }
        if (StringUtil.isNotEmpty(checkMsg.toString())) {
            responseMessage.setMessage(checkMsg.substring(0, checkMsg.length() - 1));
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }
        // 用户ID
        BigInteger userId = new BigInteger(uid);
        BigInteger orderCode = new BigInteger(queryOrderCode);
                
        // 更新订单详情信息
        List<Object> statusList = new ArrayList<Object>();
        statusList.add("0");
        statusList.add("1");
        statusList.add("3");
        Condition shopOrderInfoCond = new Condition(ShopOrderInfoDto.class);
        shopOrderInfoCond.createCriteria().andEqualTo("orderCode", orderCode)
                                          .andEqualTo("userId", userId)
                                          .andIn("orderStatus", statusList);
        ShopOrderInfoDto shopOrderInfoDto = new ShopOrderInfoDto();
        shopOrderInfoDto.setUserId(userId);
        shopOrderInfoDto.setOrderCode(orderCode);
        shopOrderInfoDto.setOrderStatus("2"); // 已完成
        shopOrderInfoDto.setConfirmTime(new Date());
        shopOrderInfoDto.setUpdatedUser(uid);
        shopOrderInfoDto.setUpdatedDate(new Date());
        int updateCount = shopOrderInfoService.updateByConditionNotNull(shopOrderInfoDto, shopOrderInfoCond);
        if(updateCount == 0) {
            responseMessage.setMessage("该订单处于完成或取消状态,不允许订单转保单");
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }
        
        // 更新订单总支付状态
        ShopOrderPayinfoDto shopOrderPayinfoDto = new ShopOrderPayinfoDto();
        shopOrderPayinfoDto.setPayStatus("1"); // 0-未支付，1-支付成功，2-支付失败
        shopOrderPayinfoDto.setUpdatedUser(UPDATED_USER);
        shopOrderPayinfoDto.setUpdatedDate(new Date());
        Condition shopPayInfoCond = new Condition(ShopOrderPayinfoDto.class);
        shopPayInfoCond.createCriteria().andEqualTo("orderCode", orderCode);
        shopOrderPayinfoService.updateByConditionNotNull(shopOrderPayinfoDto, shopPayInfoCond);
        
        // 订单商品关联信息列表
        ShopOrderGoodsDto queryOrderGoodsDto = new ShopOrderGoodsDto();
        queryOrderGoodsDto.setUserId(userId);
        queryOrderGoodsDto.setOrderCode(orderCode);
        queryOrderGoodsDto.setInvalidFlag(0);
        List<ShopOrderGoodsDto> shopOrderGoodsList = shopOrderGoodsService.select(queryOrderGoodsDto);
        
        // 订单明细列表
        List<SynPolicyDtlDto> synPolicyDtlList = new ArrayList<SynPolicyDtlDto>();
        boolean testIssueFlag = false;
        SynPolicyDtlDto synPolicyDtlDto = null;
        for (ShopOrderGoodsDto shopOrderGoodsDto : shopOrderGoodsList) {
            
            OrderMainDto orderMainDto = new OrderMainDto();
            orderMainDto.setOrderCode(orderCode);
            orderMainDto.setOrderMainId(shopOrderGoodsDto.getGoodsNo());
            orderMainDto = orderMainService.selectOne(orderMainDto);
            
            if("Y".equals(orderMainDto.getCodInd()) && StringUtil.isEmpty(orderMainDto.getPoaSerialNo())) { // 见费出单标志:Y-是 N-否
                throw new MessageException("见费非暂收款订单不允许订单直接转保单");
            }
            
            /* delete by zhaobaoyang 2018/08/14 for RM-6864 新收付暂收款功能需求-中台系统  begin  */
            /*
            //校验暂收款是否可用
            if(StringUtil.isNotEmpty(orderMainDto.getPoaSerialNo())){
                this.checkPoa(orderMainDto.getDataSource(),orderMainDto.getAgrtCode(),orderMainDto.getPoaSerialNo(),orderCode);
            }
            */
            /* delete by zhaobaoyang 2018/08/14 for RM-6864 新收付暂收款功能需求-中台系统  end  */
            /* add by zhaobaoyang 2018/8/3 for RM-6864 新收付暂收款功能需求-中台系统 begin */
            //新收付暂收款 校验暂收款是否可用
            if(StringUtil.isNotEmpty(orderMainDto.getPoaSerialNo())){
                this.nfinCheckPoa(orderMainDto.getDataSource(),orderMainDto.getAgrtCode(),orderMainDto.getPoaSerialNo(),orderCode);
            }
            /* add by zhaobaoyang 2018/8/3 for RM-6864 新收付暂收款功能需求-中台系统 end */
            if(StringUtil.isEmpty(orderMainDto.getPolicyNo())) {
                //////////////生成保单号/////////////
                orderMainDto.setPolicyNo(this.createPolicyNo("8G", orderMainDto.getChannelTip().substring(1, 4), shopOrderGoodsDto.getGoodsId()));
                logger.info("//////////////生成保单号:{}//////////////",orderMainDto.getPolicyNo());
            }
            
            // 判断是否测试单
            if(!testIssueFlag && StringUtil.isNotEmpty(orderMainDto.getTestIssueFlag()) && "Y".equals(orderMainDto.getTestIssueFlag())){
            	testIssueFlag = true;
            }
            
            // 更新订单信息
            orderMainDto.setStatus("3"); // 3-转保单成功
            orderMainDto.setUnderwriterInd("6"); // 6-承保确认
            orderMainDto.setUpdatedUser(UPDATED_USER);
            orderMainDto.setUpdatedDate(new Date());

            orderMainDto.setOrderCode(null);
            Condition orderMainCond = new Condition(OrderMainDto.class);
            orderMainCond.createCriteria().andEqualTo("orderMainId", shopOrderGoodsDto.getGoodsNo())
                                          .andEqualTo("orderCode", orderCode);
            orderMainService.updateByConditionNotNull(orderMainDto, orderMainCond);
            
            // 更新订单支付信息
            OrderPayinfoDto orderPayinfoDto = new OrderPayinfoDto();
            orderPayinfoDto.setPayStatus("1");
            orderPayinfoDto.setPayDate(new Date());
            orderPayinfoDto.setUpdatedUser(UPDATED_USER);
            orderPayinfoDto.setUpdatedDate(new Date());
            Condition orderPayCond = new Condition(OrderPayinfoDto.class);
            orderPayCond.createCriteria().andEqualTo("orderCode", orderCode)
                                         .andEqualTo("orderMainId", shopOrderGoodsDto.getGoodsNo());
            orderPayinfoService.updateByConditionNotNull(orderPayinfoDto, orderPayCond);
            
            synPolicyDtlDto = new SynPolicyDtlDto();
            synPolicyDtlDto.setOrderMainId(shopOrderGoodsDto.getGoodsNo());
            synPolicyDtlDto.setPolicyNo(orderMainDto.getPolicyNo());
            synPolicyDtlDto.setAgrtCode(orderMainDto.getAgrtCode());
            synPolicyDtlList.add(synPolicyDtlDto);
        }
        
        // 获取订单详情信息 
        ShopOrderDto shopOrderDto = this.getOrderDetailInfo(orderCode);
        
        // 激活卡流水号暂时只能一对一关系（即一个流水号对应一个保单号）
        if (StringUtil.isNotEmpty(disposeType)) {
            if(Constants.DISPOSE_JHK.equals(disposeType)){
            	shopOrderPayinfoDto = new ShopOrderPayinfoDto();
            	shopOrderPayinfoDto.setOrderCode(orderCode);
            	shopOrderPayinfoDto.setUserId(userId);
            	shopOrderPayinfoDto.setInvalidFlag(0);
            	shopOrderPayinfoDto = shopOrderPayinfoService.selectOne(shopOrderPayinfoDto);
                if(StringUtil.isNotEmpty(shopOrderPayinfoDto.getActivationCardNo())){
                    String associatedNo = shopOrderDto.getOrderList().get(0).getOrderMain().getAssociatedNo();
                    String policyNo = shopOrderDto.getOrderList().get(0).getOrderMain().getPolicyNo();
                    OrderActivationCardLogoutReq activationCardLogoutReq = new OrderActivationCardLogoutReq();
                    activationCardLogoutReq.setDocVerCode(shopOrderPayinfoDto.getDocVerCode());
                    activationCardLogoutReq.setBusinessNo(shopOrderPayinfoDto.getPayNo());
                    if(StringUtil.isEmpty(associatedNo)){
                        activationCardLogoutReq.setPolicyNo(policyNo);
                    }else{
                        activationCardLogoutReq.setPolicyNo(associatedNo);
                    }
                    activationCardLogoutReq.setActiveType("T");
                    activationCardLogoutReq.setActiveTime(new Date());
                    requestMessageObj.getData().setActivationCardLogoutReq(activationCardLogoutReq);
                    responseMessage = this.activationCardLogout(requestMessageObj);
                    if(SUCCESS_CODE.equals(responseMessage.getCode())) {
                        OrderActivationCardLogoutResp activationCardLogoutResp = responseMessage.getData().getActivationCardLogoutResp();
                        if("1".equals(activationCardLogoutResp.getLogoutStatus())){
                            logger.info("激活卡激活成功，激活卡卡号：{}，保单号：{}", shopOrderPayinfoDto.getActivationCardNo(), policyNo);
                        }else{
                            logger.info("激活卡激活失败，激活卡卡号：{}，保单号：{}", shopOrderPayinfoDto.getActivationCardNo(), policyNo);
                        }
                    }else{
                        logger.info("激活卡激活失败，激活卡卡号：{}，订单号：{}, 响应状态为 :{} ,响应信息为:{}", shopOrderPayinfoDto.getActivationCardNo(), orderCode, responseMessage.getStatusCode(),responseMessage.getMessage());
                    }
                }
            }
        }
        
        // 测试单内容不插入任务表中
        if (!testIssueFlag) {
	        // 任务表放到一起写入减低取数问题的可能性
	        for(SynPolicyDtlDto synPolicyDtl : synPolicyDtlList) {
	            // 写入保单同步明细信息表【t_syn_policy_dtl】
	            synPolicyDtl.setOrderCode(orderCode);
	            synPolicyDtl.setDealStatus("0"); // 0-初始状态
	            synPolicyDtl.setInvalidFlag(0);
	            synPolicyDtl.setCreatedUser(CREATE_USER);
	            synPolicyDtl.setCreatedDate(new Date());
	            synPolicyDtl.setUpdatedUser(UPDATED_USER);
	            synPolicyDtl.setUpdatedDate(new Date());
	            synPolicyDtlService.insertNotNull(synPolicyDtl);
	        }
	        
	        // 写入保单同步信息表【t_syn_policy】
	        SynPolicyDto synPolicyDto = new SynPolicyDto();
	        synPolicyDto.setOrderCode(orderCode);
	        synPolicyDto.setDetailCount(shopOrderGoodsList.size());
	        synPolicyDto.setDealStatus("0"); // 未处理
	        synPolicyDto.setInvalidFlag(0);
	        synPolicyDto.setCreatedUser(CREATE_USER);
	        synPolicyDto.setCreatedDate(new Date());
	        synPolicyDto.setUpdatedUser(UPDATED_USER);
	        synPolicyDto.setUpdatedDate(new Date());
	        synPolicyService.insertNotNull(synPolicyDto);
        }
        
        // 写入电子保单同步信息表【t_syn_epolicy】
        SynEpolicyDto synEpolicyDto = new SynEpolicyDto();
        synEpolicyDto.setOrderCode(orderCode);
        synEpolicyDto.setDealStatus("0"); // 未处理
        synEpolicyDto.setInvalidFlag(0);
        synEpolicyDto.setCreatedUser(CREATE_USER);
        synEpolicyDto.setCreatedDate(new Date());
        synEpolicyDto.setUpdatedUser(UPDATED_USER);
        synEpolicyDto.setUpdatedDate(new Date());
        synEpolicyService.insertNotNull(synEpolicyDto);
        
        // 处理成功返回
        OrderToPolicyResp orderToPolicyResp = new OrderToPolicyResp();
        orderToPolicyResp.setShopOrderInfo(shopOrderDto.getShopOrderInfo());
        orderToPolicyResp.setShopOrderPayinfo(shopOrderDto.getShopOrderPayinfo());
        orderToPolicyResp.setShopOrderShipping(shopOrderDto.getShopOrderShipping());
        orderToPolicyResp.setOrderList(shopOrderDto.getOrderList());
        responseMessage.getData().setOrderToPolicyResp(orderToPolicyResp);
        
        responseMessage.setMessage(SUCCESS_MSG);
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);
        
        return responseMessage;
    }
    
    /**
     * 5.2.20 获取支付交易流水号接口
     * <p>User: lipengfei
     * <p>Date: 2016年5月5日
     * <p>Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    @Override
    public ResponseMessage getBusinessNo(RequestMessage requestMessageObj) throws Exception {
        ResponseMessage responseMessage = new ResponseMessage();
    	List<NcmGetTrandNoReq> getBusinessNoList = requestMessageObj.getData().getGetTrandNoList();
    	String uid = requestMessageObj.getUserId();
    	String trandNo = null ;
    	// 传入信息校验
        StringBuffer checkMsg = new StringBuffer();
        if (StringUtil.isEmpty(uid)) {
            checkMsg.append("用户ID不能为空,");
        }
        if (getBusinessNoList == null) {
            checkMsg.append("请求内容不能为空,");
        }
		if (StringUtil.isNotEmpty(checkMsg.toString())) {
			responseMessage.setMessage(checkMsg.substring(0, checkMsg.length() - 1));
			responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }
		// 用户ID
        BigInteger userId = new BigInteger(uid);
        List<ShopOrderDto> shopOrderList = new ArrayList<ShopOrderDto>();
    	// 验证订单号是否转投保成功
    	for(NcmGetTrandNoReq getBusinessNoReq : getBusinessNoList){
    		// 查询订单号信息表
            BigInteger orderCode = new BigInteger(getBusinessNoReq.getOrderCode());
            ShopOrderDto shopOrderDto = this.getOrderDetailInfo(orderCode);
            shopOrderList.add(shopOrderDto);
    	}
    	
    	// 调用核心转投保接口
        logger.info("-------------调用核心获取交易流水号接口开始---------------");
        // 获取订单详情信息 
        
        TransRequestMessage transRequestMessage = new TransRequestMessage();
        transRequestMessage.setUserId(uid);
        transRequestMessage.setRequestTime(new Date());
        transRequestMessage.setInterfaceCode("GetBusinessNo");
        
        TransOrderToBusinessNoReq transOrderToBusinessNoReq = new TransOrderToBusinessNoReq(); 
        transOrderToBusinessNoReq.setShopOrderList(shopOrderList);
        transRequestMessage.getData().setTransOrderToBusinessNoReq(transOrderToBusinessNoReq);
        
        HttpResponseWrapper result = new ClientUtils().connectServer(transRequestMessage, ConfigUtil.getValue("remote.trans.url"));
        List<CallBackOrderInfoDto> callBackOrderInfoList = null; // 返回订单列表
        if (result.getStatus()) {
            TransResponseMessage transResponseMessage = JSON.parseObject((String)result.getContent(), TransResponseMessage.class);
            String code = transResponseMessage.getCode();
            if(SUCCESS_CODE.equals(code)) {
            	TransOrderToBusinessNoResp transOrderToBusinessNoResp = transResponseMessage.getData().getOrderToBusinessNoResp();
                callBackOrderInfoList = transOrderToBusinessNoResp.getCallBackOrderInfoList();
                for(ShopOrderDto shopOrderDto : shopOrderList){
                	// 回写订单信息列表
                	for(CallBackOrderInfoDto callBackOrderInfoDto : callBackOrderInfoList) {
                		trandNo = callBackOrderInfoDto.getTrandNo();
                 		// 支付信息表
                        OrderPayinfoDto orderPayinfoDto = shopOrderDto.getOrderList().get(0).getPayinfo();
                        orderPayinfoDto.setUserId(userId);
                        orderPayinfoDto.setPayNo(callBackOrderInfoDto.getTrandNo());
                        orderPayinfoDto.setUpdatedUser(uid);
                        orderPayinfoDto.setUpdatedDate(new Date());                        
                        orderPayinfoDto.setOrderCode(null);
                        Condition orderPayCond = new Condition(OrderPayinfoDto.class);
                        orderPayCond.createCriteria().andEqualTo("payId", orderPayinfoDto.getPayId())
                                                     .andEqualTo("orderCode", shopOrderDto.getShopOrderInfo().getOrderCode());
                        orderPayinfoService.updateByConditionNotNull(orderPayinfoDto, orderPayCond);
                     }
                	
                }
            }else {
                String message = transResponseMessage.getMessage();
                responseMessage.setMessage("orderList to businessNo fail:" + message);
                responseMessage.setCode(FAIL_CODE);
                responseMessage.setStatusCode(transResponseMessage.getStatusCode());
                responseMessage.setState(FAIL_STATE);
                logger.error("orderCodeList:{} to businessNo fail:{}", getBusinessNoList.get(0), message);
                return responseMessage;
            }
        }else {
            responseMessage.setMessage(result.getErrorMessage());
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + StatusCodeProvider.getCode(result,FAIL_CODE));
            responseMessage.setState(FAIL_STATE);
            logger.error("getBusinessNoList:{},fail:{}", getBusinessNoList.get(0), result.getErrorMessage());
            return responseMessage;
        }
        logger.info("-------------调用核心获取交易流水号接口结束---------------");
        
        // 处理成功返回
        NcmGetTrandNoResp getTrandNoResp = new NcmGetTrandNoResp();
        getTrandNoResp.setTrandNo(trandNo);
        responseMessage.getData().setGetTrandNoResp(getTrandNoResp);
        
        responseMessage.setMessage(SUCCESS_MSG);
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);
        
        return responseMessage;
    }
    
    /**
     * 5.2.21 流水号转保单接口
     * <p>User: lipengfei
     * <p>Date: 2016年5月6日
     * <p>Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    @Override
    public ResponseMessage trandNoToPay(RequestMessage requestMessageObj) throws Exception {
        ResponseMessage responseMessage = new ResponseMessage();
        NcmTrandNoToPayReq tranNoToPayReq = requestMessageObj.getData().getTrandNoToPayReq();
        String uid = requestMessageObj.getUserId();
        String trandNo = tranNoToPayReq.getTrandNo();

        // 传入信息校验
        StringBuffer checkMsg = new StringBuffer();
        if (StringUtil.isEmpty(trandNo)) {
            checkMsg.append("交易流水号不能为空,");
        }
        if (StringUtil.isNotEmpty(checkMsg.toString())) {
            responseMessage.setMessage(checkMsg.substring(0, checkMsg.length() - 1));
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }

        // 处理成功返回
	    List<NcmTrandNoToPayResp>  trandNoToPayRespList = new ArrayList<NcmTrandNoToPayResp>();
	    NcmTrandNoToPayResp  trandNoToPayResp ;
	    
        logger.info("-------------调用核心转保单接口开始---------------");
        TransRequestMessage transRequestMessage = new TransRequestMessage();
        transRequestMessage.setUserId(uid);
        transRequestMessage.setRequestTime(new Date());
        transRequestMessage.setInterfaceCode("TrandNoToPay");

        NcmTrandNoToPayReq transTranNoToPayReq = new NcmTrandNoToPayReq();
        transTranNoToPayReq.setTrandNo(trandNo);
        transRequestMessage.getData().setTrandNoToPayReq(transTranNoToPayReq);

        HttpResponseWrapper transResult = new ClientUtils().connectServer(transRequestMessage,ConfigUtil.getValue("remote.trans.url"));
        String orderStatus = null; // 订单状态
        BigInteger orderCode = null ;
        List<CallBackOrderInfoDto> callBackOrderInfoList = null; // 返回订单列表
        if (transResult.getStatus()) {
            TransResponseMessage transResponseMessage = JSON.parseObject((String)transResult.getContent(), TransResponseMessage.class);
            if (SUCCESS_CODE.equals(transResponseMessage.getCode())) {
            	TransTrandNoToPayResp transTrandNoToPayResp = transResponseMessage.getData().getTrandNoToPayResp();
                orderStatus = transTrandNoToPayResp.getOrderStatus();
                callBackOrderInfoList = transTrandNoToPayResp.getCallBackOrderInfoList();
                if("1".equals(orderStatus)){
                	responseMessage.setMessage(callBackOrderInfoList.get(0).getMessage());
                    responseMessage.setCode(FAIL_CODE);
                    responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
                    responseMessage.setState(FAIL_STATE);
                    return responseMessage;
                }
                for(CallBackOrderInfoDto callBackOrderInfoDto : callBackOrderInfoList){
                    // 订单号
                    String orderTmpCode = callBackOrderInfoDto.getOrderCode();
                    orderCode = new BigInteger(orderTmpCode);
                    // 订单号找到用户ID
                    OrderIdxUserIdDto orderIdxUserIdDto = new OrderIdxUserIdDto();
                    orderIdxUserIdDto.setOrderCode(orderCode);
                    orderIdxUserIdDto = orderIdxUserIdService.selectByPrimaryKey(orderIdxUserIdDto);
                    if (orderIdxUserIdDto == null) {
                        throw new MessageException("orderCode: " + orderCode + " can't fount userId from t_order_idx_user_id");
                    }
                    BigInteger userId = orderIdxUserIdDto.getUserId();
                    
                    logger.info("-------------回写保单信息接口开始---------------");
                    ShopOrderDto shopOrderDto = this.getOrderDetailInfo(orderCode);
                    // 更新订单总支付状态
                    ShopOrderPayinfoDto shopOrderPayinfoDto = new ShopOrderPayinfoDto();
                    shopOrderPayinfoDto.setUserId(orderIdxUserIdDto.getUserId());
                    shopOrderPayinfoDto.setOrderCode(orderCode);
                    shopOrderPayinfoDto.setInvalidFlag(0);
                    shopOrderPayinfoDto = shopOrderPayinfoService.selectOne(shopOrderPayinfoDto);
                    shopOrderPayinfoDto.setUserId(userId);
                    shopOrderPayinfoDto.setPayStatus("1"); // 0-未支付，1-支付成功，2-支付失败
                    shopOrderPayinfoDto.setUserId(userId);
                    shopOrderPayinfoDto.setUpdatedUser(UPDATED_USER);
                    shopOrderPayinfoDto.setUpdatedDate(new Date());
                    shopOrderPayinfoDto.setOrderCode(null);
                    Condition shopPayInfoCond = new Condition(ShopOrderPayinfoDto.class);
                    shopPayInfoCond.createCriteria().andEqualTo("payinfoId", shopOrderPayinfoDto.getPayinfoId())
                                                    .andEqualTo("orderCode", orderCode);
                    shopOrderPayinfoService.updateByConditionNotNull(shopOrderPayinfoDto, shopPayInfoCond);

                    // 订单商品关联信息列表
                    ShopOrderGoodsDto queryOrderGoodsDto = new ShopOrderGoodsDto();
                    queryOrderGoodsDto.setUserId(userId);
                    queryOrderGoodsDto.setOrderCode(orderCode);
                    queryOrderGoodsDto.setInvalidFlag(0);
                    List<ShopOrderGoodsDto> shopOrderGoodsList = shopOrderGoodsService.select(queryOrderGoodsDto);
                    
                    // 更新支付信息
                    OrderPayinfoDto orderPayinfoDto = null;
                    for (ShopOrderGoodsDto shopOrderGoodsDto : shopOrderGoodsList) {
                        orderPayinfoDto = new OrderPayinfoDto();
                        orderPayinfoDto.setUserId(userId);
                        orderPayinfoDto.setOrderMainId(shopOrderGoodsDto.getGoodsNo());
                        orderPayinfoDto.setOrderCode(orderCode);
                        orderPayinfoDto.setInvalidFlag(0);
                        orderPayinfoDto = orderPayinfoService.selectOne(orderPayinfoDto);
                        orderPayinfoDto.setUserId(userId);
                        orderPayinfoDto.setPayStatus("1");
                        orderPayinfoDto.setPayDate(new Date());
                        orderPayinfoDto.setUpdatedUser(UPDATED_USER);
                        orderPayinfoDto.setUpdatedDate(new Date());
                        orderPayinfoDto.setOrderCode(null);
                        Condition orderPayCond = new Condition(OrderPayinfoDto.class);
                        orderPayCond.createCriteria().andEqualTo("payId", orderPayinfoDto.getPayId())
                                                     .andEqualTo("orderCode", orderCode);
                        orderPayinfoService.updateByConditionNotNull(orderPayinfoDto, orderPayCond);
                    }
                    
                    ShopOrderInfoDto shopOrderInfoDto = new ShopOrderInfoDto();
                    shopOrderInfoDto.setUserId(userId);
                    shopOrderInfoDto.setOrderCode(orderCode);
                    shopOrderInfoDto = shopOrderInfoService.selectByPrimaryKey(shopOrderInfoDto);
                    // 更新订单详情信息
                    shopOrderInfoDto.setUserId(userId);
                    shopOrderInfoDto.setOrderCode(orderCode);
                    shopOrderInfoDto.setOrderStatus(orderStatus);
                    shopOrderInfoDto.setUpdatedUser(UPDATED_USER);
                    shopOrderInfoDto.setUpdatedDate(new Date());
                    shopOrderInfoService.updateByPrimaryKeyNotNull(shopOrderInfoDto);

                    BigInteger orderId = shopOrderDto.getOrderList().get(0).getOrderMain().getOrderMainId(); // 订单ID
                    String policyNo = callBackOrderInfoDto.getPolicyNo(); 				// 保单号
                    String policyPassFlag = callBackOrderInfoDto.getPolicyPassFlag(); 	// 转投保成功标志
                    /****    回写订单信息      ****/
                    // 更新订单信息
                    OrderMainDto orderMainDto = new OrderMainDto();
                    orderMainDto.setUserId(userId);
                    orderMainDto.setOrderMainId(orderId);
                    orderMainDto.setPolicyNo(policyNo);
                    orderMainDto.setStatus("0".equals(policyPassFlag) ? "3" : "4"); // 0-初始状态，1-转投保成功，2-转投保失败，3-转保单成功，4-转保单失败
                    orderMainDto.setUpdatedUser(UPDATED_USER);
                    orderMainDto.setUpdatedDate(new Date());
                    Condition orderMainCond = new Condition(OrderMainDto.class);
                    orderMainCond.createCriteria().andEqualTo("orderMainId", orderId)
                                                  .andEqualTo("orderCode", orderCode);
                    orderMainService.updateByConditionNotNull(orderMainDto, orderMainCond);
                    
                    // 支付信息表
                    OrderPayinfoDto payinfoDto = new OrderPayinfoDto();
                    payinfoDto.setUserId(userId);
                    payinfoDto.setOrderMainId(orderId);
                    payinfoDto.setOrderCode(orderCode);
                    payinfoDto.setInvalidFlag(0);
                    payinfoDto = orderPayinfoService.selectOne(payinfoDto);
                    payinfoDto.setUserId(userId);
                    payinfoDto.setPayNo(callBackOrderInfoDto.getTrandNo()); // 交易流水号
                    payinfoDto.setUpdatedUser(String.valueOf(userId));
                    payinfoDto.setUpdatedDate(new Date());
                    payinfoDto.setOrderCode(null);
                    Condition orderPayCond = new Condition(OrderPayinfoDto.class);
                    orderPayCond.createCriteria().andEqualTo("payId", payinfoDto.getPayId())
                                                 .andEqualTo("orderCode", orderCode);
                    orderPayinfoService.updateByConditionNotNull(payinfoDto, orderPayCond);

                    // 支付成功状态写入缓存
                    try {
                        redisTemplate.set(ODST_PREFIX + orderTmpCode, "1", Constants.EXPIRE_TIME); // 支付成功
                    } catch (Exception e) {
                        logger.error("ODST_["+orderTmpCode+"]写入Redis缓存失败," + e);
                    }
                    
                    // 处理成功返回数据
                    trandNoToPayResp = new NcmTrandNoToPayResp();
                    trandNoToPayResp.setOrderCode(orderTmpCode);
                    trandNoToPayResp.setOrderStatus("0".equals(policyPassFlag) ? "3" : "4"); // 0-初始状态，1-转投保成功，2-转投保失败，3-转保单成功，4-转保单失败
                    trandNoToPayResp.setPolicyNo(policyNo);
                    trandNoToPayResp.setTrandNo(trandNo);
                    trandNoToPayRespList.add(trandNoToPayResp);
                }
            } else {
	             logger.error("投保单转保单处理失败,订单号:{},{}",orderCode,transResponseMessage.getMessage());
	             responseMessage.setMessage("投保单转保单处理失败,订单号:" + orderCode + ";"+ (String)transResult.getContent());
	             responseMessage.setCode(FAIL_CODE);
	             responseMessage.setStatusCode(transResponseMessage.getStatusCode());
	             responseMessage.setState(FAIL_STATE);
	             return responseMessage;
	        }
	    } else {
	        logger.error("投保单转保单请求失败,订单号:{},{}",orderCode,transResult.getErrorMessage());
	        responseMessage.setMessage("投保单转保单请求失败,订单号:" + orderCode + ";"+ transResult.getErrorMessage());
	        responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + StatusCodeProvider.getCode(transResult, FAIL_CODE));
	        responseMessage.setState(FAIL_STATE);
	        return responseMessage;
	    }
	    logger.info("-------------调用核心转保单接口结束---------------");

	    responseMessage.getData().setTrandNoToPayRespList(trandNoToPayRespList);
        responseMessage.setMessage(SUCCESS_MSG);
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);
        
        return responseMessage;
    }
    
    /**
     * 5.2.23 重复投保查询接口
     * <p>User: lipengfei
     * <p>Date: 2016年5月30日
     * <p>Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    @Override
    @SuppressWarnings("unused")
    public ResponseMessage queryOrderRepeated(RequestMessage requestMessageObj) throws Exception {
        ResponseMessage responseMessage = new ResponseMessage();
        OrderDynamicItemDto queryOrderRepeatedReq = requestMessageObj.getData().getQueryOrderRepeatedReq();

        Integer invalidFlag = queryOrderRepeatedReq.getInvalidFlag();
        String riskCode = queryOrderRepeatedReq.getRiskCode();

        // 传入信息校验
        StringBuffer checkMsg = new StringBuffer();
        if (StringUtil.isEmpty(riskCode)) {
            checkMsg.append("险种代码不能为空,");
        }
        if (queryOrderRepeatedReq == null) {
            checkMsg.append("标的信息内容不能为空,");
        }
        if (StringUtil.isNotEmpty(checkMsg.toString())) {
            responseMessage.setMessage(checkMsg.substring(0, checkMsg.length() - 1));
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }

        QueryOrderRepeatedResp queryOrderRepeatedResp = new QueryOrderRepeatedResp();
        List<OrderDto> policyList = new ArrayList<OrderDto>();
        OrderDto policyInfo;
        int total = 0;
        String policyNo = "";
        String status = "";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("riskCode", riskCode);
        paramMap.put("fieldAa", queryOrderRepeatedReq.getFieldAA());
        paramMap.put("fieldAb", queryOrderRepeatedReq.getFieldAB());
        paramMap.put("fieldAc", queryOrderRepeatedReq.getFieldAC());
        paramMap.put("fieldAd", queryOrderRepeatedReq.getFieldAD());
        paramMap.put("fieldAe", queryOrderRepeatedReq.getFieldAE());
        paramMap.put("fieldAf", queryOrderRepeatedReq.getFieldAF());
        paramMap.put("fieldAg", queryOrderRepeatedReq.getFieldAG());
        paramMap.put("fieldAh", queryOrderRepeatedReq.getFieldAH());
        paramMap.put("fieldAi", queryOrderRepeatedReq.getFieldAI());
        paramMap.put("fieldAj", queryOrderRepeatedReq.getFieldAJ());
        paramMap.put("fieldAk", queryOrderRepeatedReq.getFieldAK());
        paramMap.put("fieldAl", queryOrderRepeatedReq.getFieldAL());
        paramMap.put("fieldAm", queryOrderRepeatedReq.getFieldAM());
        paramMap.put("fieldAn", queryOrderRepeatedReq.getFieldAN());
        paramMap.put("fieldAo", queryOrderRepeatedReq.getFieldAO());
        paramMap.put("fieldAp", queryOrderRepeatedReq.getFieldAP());
        paramMap.put("fieldAq", queryOrderRepeatedReq.getFieldAQ());
        paramMap.put("fieldAr", queryOrderRepeatedReq.getFieldAR());
        paramMap.put("fieldAs", queryOrderRepeatedReq.getFieldAS());
        paramMap.put("fieldAt", queryOrderRepeatedReq.getFieldAT());
        paramMap.put("fieldAu", queryOrderRepeatedReq.getFieldAU());
        paramMap.put("fieldAv", queryOrderRepeatedReq.getFieldAV());
        paramMap.put("fieldAw", queryOrderRepeatedReq.getFieldAW());
        paramMap.put("fieldAx", queryOrderRepeatedReq.getFieldAX());
        paramMap.put("fieldAy", queryOrderRepeatedReq.getFieldAY());
        paramMap.put("fieldAz", queryOrderRepeatedReq.getFieldAZ());
        paramMap.put("invalidFlag", invalidFlag);
        paramMap.put("currentDate", new Date());
        // paramMap.put("objectCondition", " order by a1.created_date desc"); //
        // 自定义
        paramMap.put("actionType", "count");
        logger.info("-------------重复投保查询接口开始---------------");
        // 重复投保查询列表
        List<VorderDynamicDto> vorderDynamicList = vorderDynamicService.queryOrderRepeated(paramMap);
        if (CollectionUtil.isNotEmpty(vorderDynamicList)) {
            queryOrderRepeatedResp.setRepeatedStatus("00");
            for (VorderDynamicDto vorderDynamicDto : vorderDynamicList) {
                String policyId = vorderDynamicDto.getPolicyNo();
                policyNo += policyId + ",";
                status += vorderDynamicDto.getStatus() + ",";
                logger.info("-------------查询保单详情接口开始---------------");
                policyInfo = new OrderDto();
                QueryPolicyDetailInfoReq queryPolicyDetailInfoReq = new QueryPolicyDetailInfoReq();
                queryPolicyDetailInfoReq.setPolicyNo(policyId);
                RequestMessage requestMessage = new RequestMessage();
                requestMessage.getData().setQueryPolicyDetailInfoReq(queryPolicyDetailInfoReq);
                responseMessage = this.queryPolicyDetailInfo(requestMessage);
                if (SUCCESS_CODE.equals(responseMessage.getCode())) {
                    policyInfo = responseMessage.getData().getQueryPolicyDetailInfoResp().getPolicyInfo();
                    policyList.add(policyInfo);
                }
                logger.info("-------------查询保单详情接口结束---------------");
            }
            queryOrderRepeatedResp.setPolicyList(policyList);
            queryOrderRepeatedResp.setPolicyNo(policyNo.substring(0, policyNo.length() - 1));
            queryOrderRepeatedResp.setStatus(status.substring(0, status.length() - 1));
        } else {
            queryOrderRepeatedResp.setRepeatedStatus("01");
        }
        total = vorderDynamicService.queryOrderRepeatCount(paramMap);
        queryOrderRepeatedResp.setTotal(total);
        logger.info("-------------重复投保查询接口结束---------------");
        responseMessage.getData().setQueryOrderRepeatedResp(queryOrderRepeatedResp);
        responseMessage.setMessage(SUCCESS_MSG);
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);
        return responseMessage;
    }
    
    /**
     * 5.2.24 查询是否投保并返回投保信息
     * <p>User: lishuang
     * <p>Date: 2016-6-23
     * <p>Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    @Override
    public ResponseMessage queryCustomerAndOrderInfo(RequestMessage requestMessageObj) throws Exception {
        ResponseMessage responseMessage = new ResponseMessage();
        QueryPropallReq queryPropallReq = requestMessageObj.getData().getQueryPropallReq();
        String docType = queryPropallReq.getDocType();
        String docNo = queryPropallReq.getDocNo();
        String customerName = queryPropallReq.getCustomerName();
        String phoneNo = queryPropallReq.getPhoneNo();
        String riskCode = queryPropallReq.getRiskCode();
        String customerFlag = queryPropallReq.getCustomerFlag();
        // 传入信息校验
        StringBuffer checkMsg = new StringBuffer();
        if (StringUtil.isEmpty(riskCode)) {
            checkMsg.append("险种代码不能为空,");
        }
        /*
         * if(StringUtil.isEmpty(docType)){ checkMsg.append("证件类型不能为空,"); }
         */
        if (StringUtil.isEmpty(docNo)) {
            checkMsg.append("证件号码不能为空,");
        }
        if (StringUtil.isNotEmpty(checkMsg.toString())) {
            responseMessage.setMessage(checkMsg.substring(0, checkMsg.length() - 1));
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("customerName", customerName);
        paramMap.put("docType", docType);
        paramMap.put("docNo", docNo);
        paramMap.put("phoneNo", phoneNo);
        paramMap.put("riskCode", riskCode);
        paramMap.put("customerFlag", customerFlag);
        //家财险、责任险 查询
        List<ShopOrderGoodsDto> shopOrderGoodsList = orderCustomerService.orderInfoQuery(paramMap);
        //意健险被保人保单信息 查询
        List<ShopOrderGoodsDto> shopOrderGoodsListAcci = orderItemAcciLstService.orderInfoQuery(paramMap);
        shopOrderGoodsList.addAll(shopOrderGoodsListAcci);
        List<QueryOrderDetailInfoResp> queryOrderDetailInfoRespList = new ArrayList<QueryOrderDetailInfoResp>();
        for (ShopOrderGoodsDto shopOrderGoods : shopOrderGoodsList) {
            BigInteger orderCode = shopOrderGoods.getOrderCode();
            // 获取订单详情信息
            ShopOrderDto shopOrderDto = this.getOrderDetailInfo(orderCode);
            String policyNo = shopOrderDto.getOrderList().get(0).getOrderMain().getPolicyNo();
            if (StringUtil.isEmpty(policyNo)) {
                continue;
            }
            QueryOrderDetailInfoResp queryOrderDetailInfoResp = new QueryOrderDetailInfoResp();
            queryOrderDetailInfoResp.setShopOrderInfo(shopOrderDto.getShopOrderInfo());
            queryOrderDetailInfoResp.setShopOrderPayinfo(shopOrderDto.getShopOrderPayinfo());
            queryOrderDetailInfoResp.setShopOrderShipping(shopOrderDto.getShopOrderShipping());
            queryOrderDetailInfoResp.setOrderList(shopOrderDto.getOrderList());
            // responseMessage.getData().setQueryOrderDetailInfoResp(queryOrderDetailInfoResp);
            queryOrderDetailInfoRespList.add(queryOrderDetailInfoResp);
        }

        responseMessage.getData().setqueryOrderDetailInfoRespList(queryOrderDetailInfoRespList);

        responseMessage.setMessage(SUCCESS_MSG);
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);

        return responseMessage;
    }
    
    /**
     * 5.2.25 查询家财险投保数
     * 
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    @Override
    public ResponseMessage queryPropertyPolicyCount(RequestMessage requestMessageObj) throws Exception {
        ResponseMessage responseMessage = new ResponseMessage();
        QueryPropertyCountReq queryPropertyCountReq = requestMessageObj.getData().getQueryPropertyCountReq();

        PropertyPolicyDto propertyPolicyDto = new PropertyPolicyDto();
        ObjectUtil.copyProperties(propertyPolicyDto, queryPropertyCountReq);

        int orderTotal = orderPropertyService.queryPropertyPolicyCount(propertyPolicyDto);

        QueryPropertyCountResp queryPropertyCountResp = new QueryPropertyCountResp();
        queryPropertyCountResp.setOrderTotal(orderTotal);
        responseMessage.getData().setQueryPropertyCountResp(queryPropertyCountResp);

        responseMessage.setMessage(SUCCESS_MSG);
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);

        return responseMessage;
    }
    
    /**
     * 5.2.26 订单转保单并插入参数
     * <p>User: lipengfei
     * <p>Date: 2016年7月14日
     * <p>Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    @Override
    public ResponseMessage orderToPolicyUpdateData(RequestMessage requestMessageObj) throws Exception {
        ResponseMessage responseMessage = new ResponseMessage();
        OrderToPolicyUpdateDataReq orderToPolicyUpdateDataReq = requestMessageObj.getData().getOrderToPolicyUpdateDataReq();
        String uid = requestMessageObj.getUserId();
        String orderCodeTmp = orderToPolicyUpdateDataReq.getOrderCode();
        ShopOrderPayinfoDto shopOrderPayinfoDto = orderToPolicyUpdateDataReq.getShopOrderPayinfoDto();
        // 传入信息校验
        StringBuffer checkMsg = new StringBuffer();
        if (StringUtil.isEmpty(orderCodeTmp)) {
            checkMsg.append("订单号不能为空,");
        }
        if (StringUtil.isNotEmpty(checkMsg.toString())) {
            responseMessage.setMessage(checkMsg.substring(0, checkMsg.length() - 1));
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }
        BigInteger userId = null;
        BigInteger orderCode = new BigInteger(orderCodeTmp);
        BigInteger orderId = null;
        String customerName = null;
        // 获取用户ID
        if (StringUtil.isEmpty(uid)) {
            OrderIdxUserIdDto orderIdxUserIdDto = new OrderIdxUserIdDto();
            orderIdxUserIdDto.setOrderCode(orderCode);
            orderIdxUserIdDto = orderIdxUserIdService.selectByPrimaryKey(orderIdxUserIdDto);
            if (orderIdxUserIdDto == null) {
                throw new MessageException("orderCode " + orderCode + " can't fount userId from t_order_idx_user_id");
            }
            userId = orderIdxUserIdDto.getUserId();
            uid = userId.toString();
        } else {
            userId = new BigInteger(uid);
        }

        // 订单商品关联信息列表
        ShopOrderGoodsDto queryOrderGoodsDto = new ShopOrderGoodsDto();
        queryOrderGoodsDto.setUserId(userId);
        queryOrderGoodsDto.setOrderCode(orderCode);
        queryOrderGoodsDto.setInvalidFlag(0);
        List<ShopOrderGoodsDto> shopOrderGoodsList = shopOrderGoodsService.select(queryOrderGoodsDto);

        for (ShopOrderGoodsDto goodsDto : shopOrderGoodsList) {
            orderId = goodsDto.getGoodsNo();

            // 更新总支付信息
            ShopOrderPayinfoDto shopOrderPayinfo = new ShopOrderPayinfoDto();
            shopOrderPayinfo.setUserId(userId);
            shopOrderPayinfo.setOrderCode(orderCode);
            shopOrderPayinfo = shopOrderPayinfoService.selectOne(shopOrderPayinfo);
            shopOrderPayinfo.setUserId(userId);
            shopOrderPayinfo.setPayWay(shopOrderPayinfoDto.getPayWay());
            shopOrderPayinfo.setPayeeName(shopOrderPayinfoDto.getPayeeName());
            shopOrderPayinfo.setPayDate(shopOrderPayinfoDto.getPayDate());
            shopOrderPayinfo.setPayOrderId(shopOrderPayinfoDto.getPayOrderId());
            shopOrderPayinfo.setCheckPayNo(shopOrderPayinfoDto.getCheckPayNo());
            shopOrderPayinfo.setBankAccount(shopOrderPayinfoDto.getBankAccount());
            shopOrderPayinfo.setUpdatedUser(uid);
            shopOrderPayinfo.setUpdatedDate(new Date());
            shopOrderPayinfo.setOrderCode(null);
            Condition shopPayInfoCond = new Condition(ShopOrderPayinfoDto.class);
            shopPayInfoCond.createCriteria().andEqualTo("payinfoId", shopOrderPayinfo.getPayinfoId()).andEqualTo("orderCode", orderCode);
            shopOrderPayinfoService.updateByConditionNotNull(shopOrderPayinfo, shopPayInfoCond);

            // 客户信息列表
            OrderCustomerDto orderCustomerDto = new OrderCustomerDto();
            orderCustomerDto.setOrderCode(orderCode);
            orderCustomerDto.setOrderMainId(orderId);
            orderCustomerDto.setInvalidFlag(0);
            List<OrderCustomerDto> orderCustomerList = orderCustomerService.select(orderCustomerDto);
            for (OrderCustomerDto orderCustomer : orderCustomerList) {
                if ("2".equals(orderCustomer.getCustomerFlag())) {
                    customerName = orderCustomer.getContactName();
                }
            }
            // 动态标的信息
            OrderDynamicItemDto orderDynamicItemDto = new OrderDynamicItemDto();
            orderDynamicItemDto.setOrderCode(orderCode);
            orderDynamicItemDto.setOrderMainId(orderId);
            orderDynamicItemDto.setInvalidFlag(0);
            List<OrderDynamicItemDto> orderDynamicItemDtoList = orderDynamicItemService.select(orderDynamicItemDto);
            if (CollectionUtil.isNotEmpty(orderDynamicItemDtoList)) {
                for (OrderDynamicItemDto orderDynamicItemDtoForUpdata : orderDynamicItemDtoList) {
                    orderDynamicItemDtoForUpdata.setUserId(userId);
                    orderDynamicItemDtoForUpdata.setOrderMainId(orderId);
                    orderDynamicItemDtoForUpdata.setFieldAP("支付宝");
                    orderDynamicItemDtoForUpdata.setFieldAQ(shopOrderPayinfoDto.getBankAccount());
                    orderDynamicItemDtoForUpdata.setFieldAR(customerName);
                    orderDynamicItemDtoForUpdata.setUpdatedUser(uid);
                    orderDynamicItemDtoForUpdata.setUpdatedDate(new Date());
                    orderDynamicItemDtoForUpdata.setOrderCode(null);
                    Condition dynamicItemCond = new Condition(OrderDynamicItemDto.class);
                    dynamicItemCond.createCriteria().andEqualTo("dynamicItemId", orderDynamicItemDtoForUpdata.getDynamicItemId())
                            .andEqualTo("orderCode", orderCode);
                    orderDynamicItemService.updateByConditionNotNull(orderDynamicItemDtoForUpdata, dynamicItemCond);

                }
            }
        }

        logger.info("-------------调用订单转保单接口开始---------------");
        requestMessageObj.setUserId(uid);
        OrderToPolicyReq orderToPolicyReq = new OrderToPolicyReq();
        orderToPolicyReq.setOrderCode(orderCodeTmp);
        requestMessageObj.getData().setOrderToPolicyReq(orderToPolicyReq);
        responseMessage = this.orderToPolicy(requestMessageObj);
        logger.info("-------------调用订单转保单接口结束---------------");

        return responseMessage;
    }
    
	/**
	 * 5.2.27 保单批改 动态标的批改
	 * <p>User: MASK
	 * <p>Date: 2016年7月30日
	 * <p>Version: 1.0
	 * @param requestMessageObj
	 * @return
	 * @throws Exception
	 */
    @Override
    public ResponseMessage endorForZ(RequestMessage requestMessageObj) throws Exception {
        ResponseMessage responseMessage = new ResponseMessage();
        EndorReq endorReq = requestMessageObj.getData().getEndorReq();

        // String uid = requestMessageObj.getUserId();
        String uid = endorReq.getOrderExt();
        String orderCodeTmp = endorReq.getOrderCode();
        // String orderIdTmp = cancelInsuranceReq.getOrderId();
        String policyNo = endorReq.getPolicyNo();
        Date validDate = endorReq.getValidDate();
        String accountBank = endorReq.getAccountBank();
        String accountName = endorReq.getAccountName();
        String accountNumber = endorReq.getAccountNumber();
        String endorType = endorReq.getEndorType();

        // 传入信息校验
        StringBuffer checkMsg = new StringBuffer();
        if (StringUtil.isEmpty(uid)) {
            checkMsg.append("用户ID不能为空,");
        }
        if (StringUtil.isEmpty(orderCodeTmp)) {
            checkMsg.append("订单号不能为空,");
        }
        /*
         * if (StringUtil.isEmpty(orderIdTmp)) { checkMsg.append("订单ID不能为空,"); }
         */
        if (StringUtil.isEmpty(policyNo)) {
            checkMsg.append("保单号不能为空,");
        }
        if (validDate == null) {
            checkMsg.append("生效日期不能为空,");
        }
        if (endorType == null) {
            checkMsg.append("批改类型不能为空,");
        }

        if (StringUtil.isEmpty(accountBank)) {
            // checkMsg.append("账户银行不能为空,");
            accountBank = ConfigUtil.getValue("account.bank"); // 因核心不支持暂收款,暂时补数处理
        }
        if (StringUtil.isEmpty(accountName)) {
            // checkMsg.append("账户名不能为空,");
            accountName = ConfigUtil.getValue("account.name");
        }
        if (StringUtil.isEmpty(accountNumber)) {
            // checkMsg.append("账户卡号不能为空,");
            accountNumber = ConfigUtil.getValue("account.number");
        }
        if (StringUtil.isNotEmpty(checkMsg.toString())) {
            responseMessage.setMessage(checkMsg.substring(0, checkMsg.length() - 1));
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }

        BigInteger userId = new BigInteger(uid);
        BigInteger orderCode = new BigInteger(orderCodeTmp);
        // Integer orderId = new Integer(orderIdTmp);

        // 订单商品关联信息列表
        ShopOrderGoodsDto queryOrderGoodsDto = new ShopOrderGoodsDto();
        queryOrderGoodsDto.setUserId(userId);
        queryOrderGoodsDto.setOrderCode(orderCode);
        queryOrderGoodsDto.setInvalidFlag(0);
        List<ShopOrderGoodsDto> shopOrderGoodsList = shopOrderGoodsService.select(queryOrderGoodsDto);

        if (CollectionUtil.isEmpty(shopOrderGoodsList)) {
            responseMessage.setMessage("不存在该订单信息");
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }

        OrderMainDto mainDto = null;
        BigInteger orderId = null;
        boolean hasPolicy = false;
        for (ShopOrderGoodsDto orderGoodsDto : shopOrderGoodsList) {
            mainDto = new OrderMainDto();
            mainDto.setOrderCode(orderCode);
            mainDto.setOrderMainId(orderGoodsDto.getGoodsNo());
            mainDto = orderMainService.selectOne(mainDto);
            if (policyNo.equals(mainDto.getPolicyNo())) {
                orderId = mainDto.getOrderMainId();
                hasPolicy = true;
                break;
            }
        }

        if (!hasPolicy) {
            responseMessage.setMessage("不存在该保单号");
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }

        // 判断能否进行批改
        if ("5".equals(mainDto.getStatus())) {
            responseMessage.setMessage("该保单已经全单退保");
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        } else {
            if (TimeUtil.isBeforeNow(mainDto.getEndDate())) {
                responseMessage.setMessage("该保单已过期");
                responseMessage.setCode(FAIL_CODE);
                responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
                responseMessage.setState(FAIL_STATE);
                return responseMessage;
            }
        }

        // 调用核心批改接口
        logger.info("-------------调用Trans批改接口开始---------------");
        TransRequestMessage transRequestMessage = new TransRequestMessage();
        transRequestMessage.setUserId(uid);
        transRequestMessage.setRequestTime(new Date());
        transRequestMessage.setInterfaceCode("EndorForZ");

        TransEndorReq transEndorReq = new TransEndorReq();
        transEndorReq.setPolicyNo(policyNo);
        transEndorReq.setValidDate(validDate);
        transEndorReq.setAccountBank(accountBank);
        transEndorReq.setAccountName(accountName);
        transEndorReq.setAccountNumber(accountNumber);
        transEndorReq.setEndorType(endorType);

        OrderDynamicItemDto orderDynamicItemDto = endorReq.getDynamicItem();
        transEndorReq.setDynamicItem(orderDynamicItemDto);

        transRequestMessage.getData().setTransEndorReq(transEndorReq);

        HttpResponseWrapper transResult = new ClientUtils().connectServer(transRequestMessage, ConfigUtil.getValue("remote.trans.url"));
        EndorResp endorResp = new EndorResp();
        if (transResult.getStatus()) {
            TransResponseMessage transResponseMessage = JSON.parseObject((String)transResult.getContent(), TransResponseMessage.class);
            if (SUCCESS_CODE.equals(transResponseMessage.getCode())) {
                TransEndorResp transEndorResp = transResponseMessage.getData().getTransEndorResp();
                String passFlag = transEndorResp.getPassFlag();
                String message = transEndorResp.getMeassage();
                String underWriteInd = transEndorResp.getUnderWriteInd();
                if ("Y".equals(passFlag) && StringUtil.isNotEmpty(message)) {
                    // 待完善处理,需要核心配合处理.
                    endorResp.setPassFlag(passFlag);
                    endorResp.setMeassage(message);
                    endorResp.setUnderWriteInd(underWriteInd);

                    OrderMainDto orderMainDto = new OrderMainDto();
                    orderMainDto.setUserId(userId);
                    orderMainDto.setOrderMainId(orderId);
                    orderMainDto.setUpdatedUser(uid);
                    orderMainDto.setUpdatedDate(new Date());
                    // 订单有效状态：0-初始状态，1-转投保成功，2-转投保失败，3-转保单成功，4-转保单失败
                    // ，5-全单批退成功，6-批改成功，7-批改中 ，8-批改失败
                    if ("6".equals(underWriteInd)) { // 批改确认
                        orderMainDto.setStatus("6"); // 批改成功
                        Condition orderMainCond = new Condition(OrderMainDto.class);
                        orderMainCond.createCriteria().andEqualTo("orderMainId", orderId).andEqualTo("orderCode", orderCode);
                        orderMainService.updateByConditionNotNull(orderMainDto, orderMainCond);

                        // 批改成功后回写动态标的表，
                        if (orderDynamicItemDto != null) {
                            OrderDynamicItemDto orderDynamicItemDtoTemp = new OrderDynamicItemDto();
                            orderDynamicItemDtoTemp.setUserId(userId);
                            orderDynamicItemDtoTemp.setOrderMainId(orderId);
                            List<OrderDynamicItemDto> orderDynamicItemDtoList = orderDynamicItemService.select(orderDynamicItemDtoTemp);
                            if (CollectionUtil.isNotEmpty(orderDynamicItemDtoList)) {
                                OrderDynamicItemDto orderDynamicItemDtoForUpdata = orderDynamicItemDtoList.get(0);
                                orderDynamicItemDtoForUpdata.setUserId(userId);
                                orderDynamicItemDtoForUpdata.setUpdatedUser(uid);
                                orderDynamicItemDtoForUpdata.setUpdatedDate(new Date());
                                ObjectUtil.copyProperties(orderDynamicItemDtoForUpdata, orderDynamicItemDto);// 动态标的
                                orderDynamicItemDtoForUpdata.setOrderCode(null);
                                Condition dynamicItemCond = new Condition(OrderDynamicItemDto.class);
                                dynamicItemCond.createCriteria().andEqualTo("dynamicItemId", orderDynamicItemDtoForUpdata.getDynamicItemId())
                                        .andEqualTo("orderCode", orderCode);
                                orderDynamicItemService.updateByConditionNotNull(orderDynamicItemDtoForUpdata, dynamicItemCond);
                            }
                        }

                    } else if ("1,9".indexOf(underWriteInd) > -1) { // 双核审核通过/待双核审核
                        orderMainDto.setStatus("7"); // 批改中
                        Condition orderMainCond = new Condition(OrderMainDto.class);
                        orderMainCond.createCriteria().andEqualTo("orderMainId", orderId).andEqualTo("orderCode", orderCode);
                        orderMainService.updateByConditionNotNull(orderMainDto, orderMainCond);
                    } else {
                        responseMessage.setMessage("批改处理失败" + message);
                        responseMessage.setCode(FAIL_CODE);
                        responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
                        responseMessage.setState(FAIL_STATE);
                        return responseMessage;
                    }
                } else {
                    responseMessage.setMessage("批改处理不通过:" + message);
                    responseMessage.setCode(FAIL_CODE);
                    responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
                    responseMessage.setState(FAIL_STATE);
                    return responseMessage;
                }
            } else {
                responseMessage.setMessage(transResponseMessage.getMessage());
                responseMessage.setCode(FAIL_CODE);
                responseMessage.setStatusCode(transResponseMessage.getStatusCode());
                responseMessage.setState(FAIL_STATE);
                logger.error("调用Trans批改接口失败,用户ID:{},订单号:{},订单ID:{},保单号:{},响应状态为:{},原因:{}", uid, orderCodeTmp, orderId, policyNo, transResponseMessage.getStatusCode(),transResponseMessage.getMessage());
                return responseMessage;
            }
        } else {
            responseMessage.setMessage(transResult.getErrorMessage());
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + StatusCodeProvider.getCode(transResult, FAIL_CODE));
            responseMessage.setState(FAIL_STATE);
            logger.error("调用Trans批改接口失败,用户ID:{},订单号:{},订单ID:{},保单号:{},原因:{}", uid, orderCodeTmp, orderId, policyNo, transResult.getErrorMessage());
            return responseMessage;
        }
        logger.info("-------------调用Trans批改接口结束---------------");

        responseMessage.getData().setEndorResp(endorResp);

        responseMessage.setMessage(SUCCESS_MSG);
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);
        return responseMessage;
    }
    
    /**
     * 第三方在线批改关系人信息
     * <p>User: admin
     * <p>Date: 2017-2-16
     * <p>Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    @Override
    public ResponseMessage endorForOuter(RequestMessage requestMessageObj) throws Exception {
        ResponseMessage responseMessage = new ResponseMessage();
        EndorReq endorReq = requestMessageObj.getData().getEndorReq();

        String orderCodeTmp = endorReq.getOrderCode();
        String policyNo = endorReq.getPolicyNo();
        Date validDate = endorReq.getValidDate();
        String endorType = endorReq.getEndorType();

        // 传入信息校验
        StringBuffer checkMsg = new StringBuffer();
        if (StringUtil.isEmpty(orderCodeTmp)) {
            checkMsg.append("订单号不能为空,");
        }
        if (StringUtil.isEmpty(policyNo)) {
            checkMsg.append("保单号不能为空,");
        }
        if (validDate == null) {
            checkMsg.append("生效日期不能为空,");
        }
        if (endorType == null) {
            checkMsg.append("批改类型不能为空,");
        }

        if (StringUtil.isNotEmpty(checkMsg.toString())) {
            responseMessage.setMessage(checkMsg.substring(0, checkMsg.length() - 1));
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }

        BigInteger orderCode = new BigInteger(orderCodeTmp);

        // 订单商品关联信息列表
        ShopOrderGoodsDto queryOrderGoodsDto = new ShopOrderGoodsDto();
        queryOrderGoodsDto.setOrderCode(orderCode);
        queryOrderGoodsDto.setInvalidFlag(0);
        List<ShopOrderGoodsDto> shopOrderGoodsList = shopOrderGoodsService.select(queryOrderGoodsDto);
        
        if (CollectionUtil.isEmpty(shopOrderGoodsList)) {
            responseMessage.setMessage("不存在该订单信息");
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }

        OrderMainDto mainDto = null;
        BigInteger orderId = null;
        boolean hasPolicy = false;
        for (ShopOrderGoodsDto orderGoodsDto : shopOrderGoodsList) {
            mainDto = new OrderMainDto();
            mainDto.setOrderCode(orderCode);
            mainDto.setOrderMainId(orderGoodsDto.getGoodsNo());
            mainDto = orderMainService.selectOne(mainDto);
            if (policyNo.equals(mainDto.getPolicyNo())) {
                orderId = mainDto.getOrderMainId();
                hasPolicy = true;
                break;
            }
        }

        if (!hasPolicy) {
            responseMessage.setMessage("不存在该保单号");
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }
        
        List<OrderCustomerDto> customerList = endorReq.getCustomerList();
        List<OrderItemAcciDto> itemAcciList = endorReq.getItemAcciList();
        List<OrderItemAcciLstDto> itemAcciLstList = endorReq.getItemAcciLstList();
        List<OrderItemAcciBenDto> itemAcciBenList = endorReq.getItemAcciBenList();
        List<OrderDynamicListDto> orderDynamicListDtoList = endorReq.getDynamicListList();
        List<OrderItemkindDto> itemkindDtoList = endorReq.getItemkindList();
        List<OrderDynamicItemDto> dynamicItemList = endorReq.getDynamicItemList();
        List<OrderRiskDynamicDto> riskDynamicItemList = endorReq.getRiskDynamicItemList();

        // 调用核心批改接口
        logger.info("-------------调用Trans批改接口开始---------------");
        TransRequestMessage transRequestMessage = new TransRequestMessage();
        transRequestMessage.setRequestTime(new Date());
        transRequestMessage.setInterfaceCode("EndorForOuter");

        TransEndorReq transEndorReq = new TransEndorReq();
        transEndorReq.setPolicyNo(policyNo);
        transEndorReq.setValidDate(validDate);
        transEndorReq.setEndorType(endorType);
        transEndorReq.setEndorNo(endorReq.getEndorNo());
        transEndorReq.setCustomerList(customerList);
        transEndorReq.setItemAcciList(itemAcciList);
        transEndorReq.setItemAcciLstList(itemAcciLstList);
        transEndorReq.setItemAcciBenList(itemAcciBenList);
        transEndorReq.setOrderDynamicListList(orderDynamicListDtoList);
        transEndorReq.setItemkindList(itemkindDtoList);
        transEndorReq.setEndDate(endorReq.getEndDate());
        transEndorReq.setDynamicItemList(endorReq.getDynamicItemList());
        transEndorReq.setRiskDynamicItemList(endorReq.getRiskDynamicItemList());
        transEndorReq.setPlanFee(endorReq.getPlanFee());
        
        transRequestMessage.getData().setTransEndorReq(transEndorReq);

        HttpResponseWrapper transResult = new ClientUtils().connectServer(transRequestMessage, ConfigUtil.getValue("remote.trans.url"));
        EndorResp endorResp = new EndorResp();
        if (transResult.getStatus()) {
            TransResponseMessage transResponseMessage = JSON.parseObject((String)transResult.getContent(), TransResponseMessage.class);
            String code = transResponseMessage.getCode();
            if (SUCCESS_CODE.equals(code)) {
                TransEndorResp transEndorResp = transResponseMessage.getData().getTransEndorResp();
                String passFlag = transEndorResp.getPassFlag();
                String message = transEndorResp.getMeassage();
                String underWriteInd = transEndorResp.getUnderWriteInd();
                if ("Y".equals(passFlag) && "6".equals(underWriteInd)) {

                    endorResp.setPassFlag(passFlag);
                    endorResp.setMeassage(message);
                    endorResp.setUnderWriteInd(underWriteInd);
                    endorResp.setAmount(transEndorResp.getAmount());
                    
                    // 更新投保人、被保人信息
                    if (CollectionUtil.isNotEmpty(customerList)) {
                        for (OrderCustomerDto customerDto : customerList) {
                            OrderCustomerDto customerForUpdate = new OrderCustomerDto();
                            OrderCustomerDto customerForFind = new OrderCustomerDto();
                            String docType = customerDto.getDocType();
                            String docNo = customerDto.getDocNo();
                            String[] docTypeArr = docType.split(FIELD_SEPARATOR);
                            String[] docNoArr = docNo.split(FIELD_SEPARATOR);
                            customerDto.setDocNo(docNoArr[1]);
                            customerDto.setDocType(docTypeArr[1]);
                            customerForFind.setOrderCode(orderCode);
                            customerForFind.setCustomerFlag(customerDto.getCustomerFlag());
                            customerForFind.setOrderMainId(orderId);
                            customerForFind.setDocNo(docNoArr[0]);
                            customerForFind.setDocType(docTypeArr[0]);
                            customerForFind = orderCustomerService.selectOne(customerForFind);
                            customerForUpdate.setCustomerId(customerForFind.getCustomerId());
                            ObjectUtil.copyProperties(customerForUpdate, customerDto);
                            orderCustomerService.updateByPrimaryKeyNotNull(customerForUpdate);
                        }
                    }

                    // 更新意外险被保险人信息
                    if (CollectionUtil.isNotEmpty(itemAcciLstList)) {
                        for (OrderItemAcciLstDto itemAcciLstDto : itemAcciLstList) {
                            OrderItemAcciLstDto itemAcciLstForFind = new OrderItemAcciLstDto();
                            OrderItemAcciLstDto itemAcciLstForUpdate = new OrderItemAcciLstDto();
                            String docType = itemAcciLstDto.getDocType();
                            String docNo = itemAcciLstDto.getDocNo();
                            String[] docTypeArr = docType.split(FIELD_SEPARATOR);
                            String[] docNoArr = docNo.split(FIELD_SEPARATOR);
                            try {
                            	itemAcciLstDto.setCustomerFlag(null);
                                itemAcciLstDto.setDocNo(docNoArr[1]);
                                itemAcciLstDto.setDocType(docTypeArr[1]);
                                itemAcciLstForFind.setOrderCode(orderCode);
                                itemAcciLstForFind.setOrderMainId(orderId);
                                itemAcciLstForFind.setDocNo(docNoArr[0]);
                                itemAcciLstForFind.setDocType(docTypeArr[0]);
                                itemAcciLstForFind = orderItemAcciLstService.selectOne(itemAcciLstForFind);
                                itemAcciLstForUpdate.setAcciListId(itemAcciLstForFind.getAcciListId());
                                ObjectUtil.copyProperties(itemAcciLstForUpdate, itemAcciLstDto);
                                orderItemAcciLstService.updateByPrimaryKeyNotNull(itemAcciLstForUpdate);

                                // 受益人同被保险人时
                                OrderItemAcciBenDto itemAcciBenForUpdate = new OrderItemAcciBenDto();
                                OrderItemAcciBenDto itemAcciBenForFind = new OrderItemAcciBenDto();
                                itemAcciBenForFind.setOrderCode(orderCode);
                                itemAcciBenForFind.setOrderMainId(orderId);
                                itemAcciBenForFind.setDocNo(docNoArr[0]);
                                itemAcciBenForFind.setDocType(docTypeArr[0]);
                                itemAcciBenForFind = orderItemAcciBenService.selectOne(itemAcciBenForFind);
                                if (itemAcciBenForFind != null) {
                                    itemAcciBenForUpdate.setAcciBenId(itemAcciBenForFind.getAcciBenId());
                                    ObjectUtil.copyProperties(itemAcciBenForUpdate, itemAcciLstDto);
                                    orderItemAcciBenService.updateByPrimaryKey(itemAcciBenForUpdate);
                                }
                            } catch (Exception e) {
                            	logger.error("更新意外险被保险人信息异常,异常原因:{}", e.getMessage());
                            }
                            
                        }
                    }

                    // 更新意外险受益人信息
                    if (CollectionUtil.isNotEmpty(itemAcciBenList)) {
                        for (OrderItemAcciBenDto itemAcciBenDto : itemAcciBenList) {
                            OrderItemAcciBenDto itemAcciBenForUpdate = new OrderItemAcciBenDto();
                            OrderItemAcciBenDto itemAcciBenForFind = new OrderItemAcciBenDto();
                            String docType = itemAcciBenDto.getDocType();
                            String docNo = itemAcciBenDto.getDocNo();
                            String[] docTypeArr = docType.split(FIELD_SEPARATOR);
                            String[] docNoArr = docNo.split(FIELD_SEPARATOR);
                            itemAcciBenDto.setCustomerFlag(null);
                            itemAcciBenDto.setDocNo(docNoArr[1]);
                            itemAcciBenDto.setDocType(docTypeArr[1]);
                            itemAcciBenForFind.setOrderCode(orderCode);
                            itemAcciBenForFind.setOrderMainId(orderId);
                            itemAcciBenForFind.setDocNo(docNoArr[0]);
                            itemAcciBenForFind.setDocType(docTypeArr[0]);
                            itemAcciBenForFind = orderItemAcciBenService.selectOne(itemAcciBenForFind);
                            itemAcciBenForUpdate.setAcciBenId(itemAcciBenForFind.getAcciBenId());
                            ObjectUtil.copyProperties(itemAcciBenForUpdate, itemAcciBenDto);
                            orderItemAcciBenService.updateByPrimaryKeyNotNull(itemAcciBenForUpdate);
                        }
                    }
                    
                    // 更新动态标的清单信息
                    /*modefiled by lshuang 2018/04/27 for RM-6656 企保360-雇主责任险线上批改优化begin*/
                    if (CollectionUtil.isNotEmpty(orderDynamicListDtoList)) {
                    	for (OrderDynamicListDto dynamicListDto : orderDynamicListDtoList) {
                     		OrderDynamicListDto orderDynamicListDtoForUpdate = new OrderDynamicListDto();
                    		OrderDynamicListDto dynamicListForFind = new OrderDynamicListDto();
                    		dynamicListForFind.setOrderCode(orderCode);
                    		dynamicListForFind.setOrderMainId(orderId);
                    		dynamicListForFind.setFieldAA(dynamicListDto.getFieldAA());
                    		dynamicListForFind.setFieldAB(dynamicListDto.getFieldAB());
                    		dynamicListForFind.setFieldAC(dynamicListDto.getFieldAC());
                    		dynamicListForFind.setFieldAD(dynamicListDto.getFieldAD());
                    		dynamicListForFind.setFieldAN(dynamicListDto.getFieldAN());
                    		dynamicListForFind.setFieldAO(dynamicListDto.getFieldAO());
                    		try {
                    			dynamicListForFind = orderDynamicListService.selectOne(dynamicListForFind);
							} catch (Exception e) {
								logger.error("查询动态清单数据异常,异常原因:{}", e.getMessage());
								continue;
							}
                    		if (dynamicListForFind != null) {
                    		    orderDynamicListDtoForUpdate.setDynamicListId(dynamicListForFind.getDynamicListId());
                    		    ObjectUtil.copyProperties(orderDynamicListDtoForUpdate, dynamicListDto);
                    		    orderDynamicListDtoForUpdate.setOrderCode(null);
                                orderDynamicListService.updateByPrimaryKeyNotNull(orderDynamicListDtoForUpdate);    
                    		}
                    	}
                    }
                    /*modefiled by lshuang 2018/04/27 for RM-6656 企保360-雇主责任险线上批改优化end*/

                    // 更新险别信息
                    if (CollectionUtil.isNotEmpty(itemkindDtoList)) {
                    	for (OrderItemkindDto orderItemkindDto : itemkindDtoList) {
                    		OrderItemkindDto orderItemkindDtoForUpdate = new OrderItemkindDto();
                    		OrderItemkindDto itemkindDtoListForFind = new OrderItemkindDto();
                    		itemkindDtoListForFind.setOrderCode(orderCode);
                    		itemkindDtoListForFind.setOrderMainId(orderId);
                    		itemkindDtoListForFind.setItemNo(orderItemkindDto.getItemNo());
                    		itemkindDtoListForFind.setKindCode(orderItemkindDto.getKindCode());
                    		itemkindDtoListForFind = orderItemkindService.selectOne(itemkindDtoListForFind);
                    		orderItemkindDtoForUpdate.setItemkindId(itemkindDtoListForFind.getItemkindId());
                    		ObjectUtil.copyProperties(orderItemkindDtoForUpdate, orderItemkindDto);
                    		orderItemkindService.updateByPrimaryKeyNotNull(orderItemkindDtoForUpdate);
                    	}
                    }
                    // 更新当期缴费金额暂存changepremium中
                    if (endorReq.getPlanFee() != null) {
	                    ShopOrderGoodsDto shopOrderGoodsDto = new ShopOrderGoodsDto();
	                    shopOrderGoodsDto.setChangePremium(endorReq.getPlanFee());
	                    Condition shopOrderGoodsCond = new Condition(ShopOrderGoodsDto.class);
	                    shopOrderGoodsCond.createCriteria().andEqualTo("orderCode", orderCode);
	                    shopOrderGoodsService.updateByConditionNotNull(shopOrderGoodsDto, shopOrderGoodsCond);
                    }
                    
                    /* added by glizhen 2018/01/16 for RM-4982 保掌柜租赁机动车驾驶人责任保险产品 begin */
                    // 更新主表中的终保日期
                    if (endorReq.getEndDate() != null) {
                    	OrderMainDto orderMainDtoForUpdate = new OrderMainDto();
                    	OrderMainDto orderMainDtoForFind = new OrderMainDto();
                    	orderMainDtoForFind.setOrderCode(orderCode);
                    	orderMainDtoForFind.setOrderMainId(orderId);
                    	orderMainDtoForFind = orderMainService.selectOne(orderMainDtoForFind);
                    	orderMainDtoForUpdate.setOrderMainId(orderMainDtoForFind.getOrderMainId());
                    	orderMainDtoForUpdate.setEndDate(endorReq.getEndDate());
                    	orderMainService.updateByPrimaryKeyNotNull(orderMainDtoForUpdate);
                    }
                    
                 // 更新动态标的信息(家财责任)
                    if (CollectionUtil.isNotEmpty(dynamicItemList)) {
                    	for (OrderDynamicItemDto dynamicItemDto : dynamicItemList) {
                    		OrderDynamicItemDto orderDynamicItemForUpdate = new OrderDynamicItemDto();
                    		OrderDynamicItemDto orderDynamicItemForFind = new OrderDynamicItemDto();
                    		orderDynamicItemForFind.setOrderCode(orderCode);
                    		orderDynamicItemForFind.setOrderMainId(orderId);
                			orderDynamicItemForFind = orderDynamicItemService.selectOne(orderDynamicItemForFind);
                			orderDynamicItemForUpdate.setDynamicItemId(orderDynamicItemForFind.getDynamicItemId());
                    		ObjectUtil.copyProperties(orderDynamicItemForUpdate, dynamicItemDto);
                    		orderDynamicItemService.updateByPrimaryKeyNotNull(orderDynamicItemForUpdate);	
                    	}
                    }
                    
                    // 更新动态标的信息(意健险)
                    if (CollectionUtil.isNotEmpty(riskDynamicItemList)) {
                    	for (OrderRiskDynamicDto riskDynamicDto : riskDynamicItemList) {
                    		OrderRiskDynamicDto orderRiskDynamicForUpdate = new OrderRiskDynamicDto();
                    		OrderRiskDynamicDto orderRiskDynamicForFind = new OrderRiskDynamicDto();
                    		orderRiskDynamicForFind.setOrderCode(orderCode);
                    		orderRiskDynamicForFind.setOrderMainId(orderId);
                    		orderRiskDynamicForFind = orderRiskDynamicService.selectOne(orderRiskDynamicForFind);
                    		if (ObjectUtil.isNotNull(orderRiskDynamicForFind)) {
                    			orderRiskDynamicForUpdate.setRiskDynamicId(orderRiskDynamicForFind.getRiskDynamicId());
                    			ObjectUtil.copyProperties(orderRiskDynamicForUpdate, riskDynamicDto);
                        		orderRiskDynamicService.updateByPrimaryKeyNotNull(orderRiskDynamicForUpdate);
                    		}
                    	}
                    }
                    /* added by glizhen 2018/01/16 for RM-4982 保掌柜租赁机动车驾驶人责任保险产品 begin */
                } else {
                    responseMessage.setMessage("批改处理不通过:" + message);
                    responseMessage.setCode(FAIL_CODE);
                    responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
                    responseMessage.setState(FAIL_STATE);
                    return responseMessage;
                }
            } else {
                responseMessage.setMessage(transResponseMessage.getMessage());
                responseMessage.setCode(FAIL_CODE);
                responseMessage.setStatusCode(transResponseMessage.getStatusCode());
                responseMessage.setState(FAIL_STATE);
                logger.error("调用Trans批改接口失败, 订单号:{},订单ID:{},保单号:{},响应状态为:{},原因:{}", orderCodeTmp, orderId, policyNo, transResponseMessage.getStatusCode(),transResponseMessage.getMessage());
                return responseMessage;
            }
        } else {
            responseMessage.setMessage(transResult.getErrorMessage());
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + StatusCodeProvider.getCode(transResult, FAIL_CODE));
            responseMessage.setState(FAIL_STATE);
            logger.error("调用Trans批改接口失败 ,订单号:{},订单ID:{},保单号:{},原因:{}", orderCodeTmp, orderId, policyNo, transResult.getErrorMessage());
            return responseMessage;
        }
        logger.info("-------------调用Trans批改接口结束---------------");

        responseMessage.getData().setEndorResp(endorResp);

        responseMessage.setMessage(SUCCESS_MSG);
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);
        return responseMessage;
    }
    
    /**
     * 将保单信息存储至缓存
     * <p>User: lipengfei
     * <p>Date: 2016年9月1日
     * <p>Version: 1.0
     */
    @Override
    public void addPolicyNoToRedis(ShopOrderDto shopOrder, String orderTmpCode) throws Exception {
    	List<OrderDto> orderList = shopOrder.getOrderList();
    	Object payStatus = redisTemplateCheckProp.get(ODST_PREFIX + "REDIS" + orderTmpCode);
    	if (StringUtil.isEmpty((String) payStatus)) {
	    	for (OrderDto orderDto : orderList) {
	    		OrderMainDto orderMain = orderDto.getOrderMain();
	    		String policyNo = orderMain.getPolicyNo();
	    		String associatedNo = orderMain.getAssociatedNo();
	    		if (StringUtil.isNotEmpty(associatedNo)) {
	    			policyNo = associatedNo;
		    	}
	    		hsetPolicyNoToRedis(shopOrder, policyNo);
    			break;
	    	}
	    	redisTemplateCheckProp.set(ODST_PREFIX + "REDIS" + orderTmpCode, "1", Constants.EXPIRE_TIME); // 支付成功
    	}
    }
    
    /**
     * 5.2.28 激活卡查询验真接口
     * @Author: lipengfei
     * @Date: 2016-12-1
     * @Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    @Override
    public ResponseMessage queryActivationCardInfo(RequestMessage requestMessageObj) throws Exception {
        ResponseMessage responseMessage = new ResponseMessage();
        QueryActivationCardInfoReq queryActivationCardInfoReq = requestMessageObj.getData().getQueryActivationCardInfoReq();
        String uid = requestMessageObj.getUserId(); // 用户ID
        String activationCardNo = queryActivationCardInfoReq.getActivationCardNo();
        String activationPassword = queryActivationCardInfoReq.getActivationPassword();
        String referer = queryActivationCardInfoReq.getReferer();

        StringBuffer checkMsg = new StringBuffer();
        if (StringUtil.isEmpty(activationCardNo)) {
            checkMsg.append("激活卡账号不能为空,");
        }
        if (StringUtil.isEmpty(referer)) {
            if (StringUtil.isEmpty(activationPassword)) {
                checkMsg.append("激活卡密码不能为空,");
            }
        }
        if (StringUtil.isNotEmpty(checkMsg.toString())) {
            responseMessage.setMessage(checkMsg.substring(0, checkMsg.length() - 1));
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }

        logger.info("-------------调单证系统查询校验激活卡信息接口开始---------------");
        QueryActivationCardInfoResp activationCardInfoResp = new QueryActivationCardInfoResp();
        OrderSalesInfoDto salesInfoDto = new OrderSalesInfoDto();
        TransRequestMessage transRequestMessage = new TransRequestMessage();
        transRequestMessage.setUserId(uid);
        transRequestMessage.setRequestTime(new Date());
        transRequestMessage.setInterfaceCode("QueryActivationCardInfo");

        TransQueryActivationCardInfoReq transQueryActivationCardInfoReq = new TransQueryActivationCardInfoReq();
        transQueryActivationCardInfoReq.setActivationCardNo(activationCardNo);
        transQueryActivationCardInfoReq.setActivationPassword(activationPassword);
        transRequestMessage.getData().setQueryActivationCardInfoReq(transQueryActivationCardInfoReq);

        HttpResponseWrapper result = new ClientUtils().connectServer(transRequestMessage, ConfigUtil.getValue("remote.trans.url"));
        if (result.getStatus()) {
            TransResponseMessage transResponseMessage = JSON.parseObject((String)result.getContent(), TransResponseMessage.class);
            if (SUCCESS_CODE.equals(transResponseMessage.getCode())) {
                TransQueryActivationCardInfoResp queryActivationCardInfoResp = transResponseMessage.getData().getQueryActivationCardInfoResp();
                ObjectUtil.copyProperties(activationCardInfoResp, queryActivationCardInfoResp);
                /*modifield by lshuang for TC-9316 官网官微重构-卡单激活-输入已激活的账号信息后进入报错页面 begin*/
                TransSalesInfoDto  transSalesInfoDto = queryActivationCardInfoResp.getSalesInfoDto();
                if(transSalesInfoDto != null) {
                    ObjectUtil.copyProperties(salesInfoDto, queryActivationCardInfoResp.getSalesInfoDto());
                    activationCardInfoResp.setSalesInfoDto(salesInfoDto);	
                }
                /*modifield by lshuang for TC-9316 官网官微重构-卡单激活-输入已激活的账号信息后进入报错页面 end*/
                responseMessage.getData().setQueryActivationCardInfoResp(activationCardInfoResp);

            } else {
                String message = transResponseMessage.getMessage();
                responseMessage.setMessage("fail:" + message);
                responseMessage.setCode(FAIL_CODE);
                responseMessage.setStatusCode(transResponseMessage.getStatusCode());
                responseMessage.setState(FAIL_STATE);
                logger.error("activationCardNo:" + activationCardNo + ",query activationCardNo info fail:" + message);
                return responseMessage;
            }
        } else {
            responseMessage.setMessage(result.getErrorMessage() + "(调用Trans)");
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + StatusCodeProvider.getCode(result, FAIL_CODE));
            responseMessage.setState(FAIL_STATE);
            logger.error("activationCardNo:" + activationCardNo + ",fail:" + result.getErrorMessage() + "(调用Trans)");
            return responseMessage;
        }
        logger.info("-------------调单证系统查询校验激活卡信息接口结束---------------");

        responseMessage.setMessage(SUCCESS_MSG);
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);

        return responseMessage;
    }
    
    /**
     * 5.2.29 激活卡 激活/核销
     * @author lipengfei
     * @date 2016-12-01
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    @Override
    public ResponseMessage activationCardLogout(RequestMessage requestMessageObj) throws Exception {
        ResponseMessage responseMessage = new ResponseMessage();
        OrderActivationCardLogoutReq activationCardLogoutReq = requestMessageObj.getData().getActivationCardLogoutReq();
        String uid = requestMessageObj.getUserId(); // 用户ID
        String docVerCode = activationCardLogoutReq.getDocVerCode();
        String businessNo = activationCardLogoutReq.getBusinessNo();
        String policyNo = activationCardLogoutReq.getPolicyNo();
        String activeType = activationCardLogoutReq.getActiveType();
        Date activeTime = activationCardLogoutReq.getActiveTime();

        StringBuffer checkMsg = new StringBuffer();
        if (StringUtil.isEmpty(docVerCode)) {
            checkMsg.append("单证类型代不能为空,");
        }
        if (StringUtil.isEmpty(businessNo)) {
            checkMsg.append("印刷流水号不能为空,");
        }
        if (StringUtil.isEmpty(policyNo)) {
            checkMsg.append("保单号不能为空,");
        }
        if (StringUtil.isEmpty(activeType)) {
            checkMsg.append("激活方式不能为空,");
        }
        if (activeTime == null) {
            checkMsg.append("激活时间不能为空,");
        }
        if (StringUtil.isNotEmpty(checkMsg.toString())) {
            responseMessage.setMessage(checkMsg.substring(0, checkMsg.length() - 1));
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }

        logger.info("-------------调单证系统激活卡 激活/核销接口开始---------------");
        OrderActivationCardLogoutResp activationCardLogoutResp = new OrderActivationCardLogoutResp();
        TransRequestMessage transRequestMessage = new TransRequestMessage();
        transRequestMessage.setUserId(uid);
        transRequestMessage.setRequestTime(new Date());
        transRequestMessage.setInterfaceCode("ActivationCardLogout");

        TransActivationCardLogoutReq transActivationCardLogoutReq = new TransActivationCardLogoutReq();
        transActivationCardLogoutReq.setDocVerCode(docVerCode);
        transActivationCardLogoutReq.setBusinessNo(businessNo);
        transActivationCardLogoutReq.setPolicyNo(policyNo);
        transActivationCardLogoutReq.setActiveType(activeType);
        transActivationCardLogoutReq.setActiveTime(activeTime);
        transRequestMessage.getData().setActivationCardLogoutReq(transActivationCardLogoutReq);

        HttpResponseWrapper result = new ClientUtils().connectServer(transRequestMessage, ConfigUtil.getValue("remote.trans.url"));
        if (result.getStatus()) {
            TransResponseMessage transResponseMessage = JSON.parseObject((String)result.getContent(), TransResponseMessage.class);
            TransActivationCardLogoutResp transActivationCardLogoutResp = transResponseMessage.getData().getActivationCardLogoutResp();
            if (SUCCESS_CODE.equals(transResponseMessage.getCode())) {
                activationCardLogoutResp.setLogoutStatus(transActivationCardLogoutResp.getLogoutStatus());
                responseMessage.getData().setActivationCardLogoutResp(activationCardLogoutResp);
                logger.info("激活卡激活/核销成功：{}", transResponseMessage.getMessage());
            } else {
                activationCardLogoutResp.setLogoutStatus("0");
                responseMessage.getData().setActivationCardLogoutResp(activationCardLogoutResp);
                String message = transResponseMessage.getMessage();
                responseMessage.setMessage(message);
                responseMessage.setCode(FAIL_CODE);
                responseMessage.setStatusCode(transResponseMessage.getStatusCode());
                responseMessage.setState(FAIL_STATE);

                logger.error("激活卡激活/核销失败,请求信息：docVerCode:" + docVerCode + " ,businessNo:" + businessNo + " ,policyNo:" + policyNo + " ,activeType:"
                        + activeType + " ,activeTime:" + activeTime + ",activation cardNo info fail:" + message);
                return responseMessage;
            }
        } else {
            responseMessage.setMessage(result.getErrorMessage() + "(调用Trans)");
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + StatusCodeProvider.getCode(result, FAIL_CODE));
            responseMessage.setState(FAIL_STATE);
            logger.error("policyNo:" + policyNo + ",fail:" + result.getErrorMessage() + "(调用Trans)");
            return responseMessage;
        }
        logger.info("-------------调单证系统激活卡 激活/核销接口结束---------------");

        responseMessage.setMessage(SUCCESS_MSG);
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);

        return responseMessage;
    }
    
    /** 退保成功清除数据库信息
     * @author lishuang
     * <p>Version: 1.0
     * @param shopOrderDto
     */
    /*public void dysubCallback(ShopOrderDto shopOrderDto, String policyNo){
        logger.info("----------------退保回调dysub库开始--------------------");
        DysubRequestMessage dysubRequestMessage = new DysubRequestMessage();
        dysubRequestMessage.setInterfaceCode("CancelInsuranceCallBack");
        dysubRequestMessage.setRequestTime(new Date());
        dysubRequestMessage.getData().setCancelInsuranceCallBackReq(shopOrderDto);
        String[] result = new ClientUtils().connectServer(dysubRequestMessage, ConfigUtil.getValue("remote.dysub.url"));
        if ("Y".equals(result[0])) {
            DysubResponseMessage responseMessage = JSON.parseObject(result[1], DysubResponseMessage.class);
            if (SUCCESS_CODE.equals(responseMessage.getCode())) {
                logger.info("DYSUB清除保单数据成功,保单号{}", policyNo);
            } else {
                logger.error("DYSUB清除保单数据失败,保单号{},失败原因:{}", policyNo, responseMessage.getMessage());
            }
        } else {
            logger.error("DYSUB清除保单数据失败,保单号{}", policyNo + ",失败原因:连接DYSUB服务失败");
        }
        logger.info("----------------退保回调dysub结束--------------------");
    }*/

    /**
     * 5.2.30 查询订单支付信息
     * @author chenguang
     * @date 2017-02-06
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    @Override
    public ResponseMessage queryOrderPayInfo(RequestMessage requestMessageObj) throws Exception {
        ResponseMessage responseMessage = new ResponseMessage();
        QueryOrderPayInfoReq queryOrderPayInfoReq = requestMessageObj.getData().getQueryOrderPayInfoReq();
        QueryOrderPayInfoResp queryOrderPayInfoResp = new QueryOrderPayInfoResp();
        String policyNo = queryOrderPayInfoReq.getPolicyNo();
        String orderId = queryOrderPayInfoReq.getOrderCode();

        StringBuffer checkMsg = new StringBuffer();
        if ((StringUtil.isEmpty(policyNo) && StringUtil.isEmpty(orderId)) ||
            (!StringUtil.isEmpty(policyNo) && !StringUtil.isEmpty(orderId))) {
            checkMsg.append("保单号和订单号能且仅能传一个,");
        }
        if (StringUtil.isNotEmpty(checkMsg.toString())) {
            responseMessage.setMessage(checkMsg.substring(0, checkMsg.length() - 1));
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }

        BigInteger orderCode = null;
        if(!StringUtil.isEmpty(policyNo)){
            logger.info("-------------根据保单查询订单支付信息开始---------------");
            OrderMainDto orderMainDto = new OrderMainDto();
            orderMainDto.setPolicyNo(policyNo);
            orderMainDto.setInvalidFlag(0);
            orderMainDto = orderMainService.selectOne(orderMainDto);
    
            orderCode = orderMainDto.getOrderCode();
        }else{
            orderCode = new BigInteger(orderId);
        }
        
        if (StringUtil.isEmpty(orderCode.toString())) {
            responseMessage.setMessage("订单号不能为空");
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }

        // 查询订单支付信息
        ShopOrderPayinfoDto shopOrderPayinfoDto = new ShopOrderPayinfoDto();
        shopOrderPayinfoDto.setOrderCode(orderCode);
        shopOrderPayinfoDto.setInvalidFlag(0);
        shopOrderPayinfoDto = shopOrderPayinfoService.selectOne(shopOrderPayinfoDto);

        queryOrderPayInfoResp.setPolicyNo(policyNo);
        queryOrderPayInfoResp.setOrderCode(orderCode);
        ObjectUtil.copyProperties(queryOrderPayInfoResp, shopOrderPayinfoDto);

        logger.info("-------------查询订单支付信息结束---------------");

        responseMessage.getData().setQueryOrderPayInfoResp(queryOrderPayInfoResp);
        responseMessage.setMessage(SUCCESS_MSG);
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);
        return responseMessage;
    }

	/**
	 * 保险责任切换接口
	 */
    @Override
    @Transactional
    public ResponseMessage liabilitySwitch(RequestMessage requestMessageObj) throws Exception {
        ResponseMessage responseMessage = new ResponseMessage();
        LiabilitySwitchReq liabilitySwitchReq = requestMessageObj.getData().getLiabilitySwitchReq();
        String policyNo = liabilitySwitchReq.getPolicyNo();
        String currentLiability = liabilitySwitchReq.getCurrentLiability();
        String currentLiabilityStartTime = liabilitySwitchReq.getCurrentLiabilityStartTime();

        logger.info("-------------调用Trans责任切换接口开始---------------");
        TransRequestMessage transRequestMessage = new TransRequestMessage();
        // transRequestMessage.setUserId(uid);
        transRequestMessage.setRequestTime(new Date());
        transRequestMessage.setInterfaceCode("LiabilitySwitch");

        TransLiabilitySwitchReq transLiabilitySwitchReq = new TransLiabilitySwitchReq();
        transLiabilitySwitchReq.setPolicyNo(policyNo);
        transLiabilitySwitchReq.setCurrentLiability(currentLiability);
        transLiabilitySwitchReq.setCurrentLiabilityStartTime(currentLiabilityStartTime);

        transRequestMessage.getData().setLiabilitySwitchReq(transLiabilitySwitchReq);

        HttpResponseWrapper transResult = new ClientUtils().connectServer(transRequestMessage, ConfigUtil.getValue("remote.trans.url"));
        LiabilitySwitchResp liabilitySwitchResp = new LiabilitySwitchResp();
        if (transResult.getStatus()) {
            TransResponseMessage transResponseMessage = JSON.parseObject((String)transResult.getContent(), TransResponseMessage.class);
            String code = transResponseMessage.getCode();
            if (SUCCESS_CODE.equals(code)) {
                TransLiabilitySwitchResp transLiabilitySwitchResp = transResponseMessage.getData().getLiabilitySwitchResp();
                String passFlag = transLiabilitySwitchResp.getPassFlag();
                String message = transLiabilitySwitchResp.getMeassage();
                if ("Y".equals(passFlag) && StringUtil.isEmpty(message)) {
                    liabilitySwitchResp.setPassFlag(passFlag);
                    liabilitySwitchResp.setMessage(message);
                } else {
                    responseMessage.setMessage("责任切换处理不通过:" + message);
                    responseMessage.setCode(FAIL_CODE);
                    responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
                    responseMessage.setState(FAIL_STATE);
                    return responseMessage;
                }
            } else {
                responseMessage.setMessage("责任切换处理失败:" + transResponseMessage.getMessage());
                responseMessage.setCode(FAIL_CODE);
                responseMessage.setStatusCode(transResponseMessage.getStatusCode());
                responseMessage.setState(FAIL_STATE);
                logger.error("责任切换处理失败,保单号:{},响应状态为:{},原因:{}", policyNo,transResponseMessage.getStatusCode(), transResponseMessage.getMessage());
                return responseMessage;
            }
        } else {
            responseMessage.setMessage(transResult.getErrorMessage());
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + StatusCodeProvider.getCode(transResult, FAIL_CODE));
            responseMessage.setState(FAIL_STATE);
            logger.error("调用Trans责任切换接口失败,保单号:{},原因:{}", policyNo, transResult.getErrorMessage());
            return responseMessage;
        }
        logger.info("-------------调用Trans责任切换接口结束---------------");

        responseMessage.getData().setLiabilitySwitchResp(liabilitySwitchResp);

        responseMessage.setMessage(SUCCESS_MSG);
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);
        return responseMessage;
    }
    
    /**
     * 退保回调处理
     * <p>User: lishuang
     * <p>Date: 2017-10-20
     * <p>Version: 1.0
     * @param appId
     * @param userId
     * @param orderCode
     * @param policyNo
     * @param endorStatus
     */
    public void surrenderCallBack(String appId, BigInteger userId, BigInteger orderCode, String policyNo, String endorStatus, double changePremium) throws Exception {
        logger.info("----------------退保回调开始--------------------");
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setUserId(userId.toString());
        QueryOrderDetailInfoReq queryOrderDetailInfoReq = new QueryOrderDetailInfoReq();
        queryOrderDetailInfoReq.setOrderCode(orderCode.toString());
        requestMessage.getData().setQueryOrderDetailInfoReq(queryOrderDetailInfoReq);
        
        ResponseMessage responseMessage = this.queryOrderDetailInfo(requestMessage);	//查询订单详情
        
        //接口请求信息
        SurrenderCallBackReq surrenderCallBackReq = new SurrenderCallBackReq();
        surrenderCallBackReq.setPolicyNo(policyNo);
        surrenderCallBackReq.setAppId(appId);
        surrenderCallBackReq.setBusinessNo(orderCode);
        surrenderCallBackReq.setDealType(Constants.DEAL_TYPE);
        JSONObject content = new JSONObject();
        content.put("policyNo", policyNo);
        content.put("orderCode", orderCode);
        content.put("orderExt", userId);
        content.put("status", "0".equals(endorStatus)?
                Constants.surrenderStatus.get("surrenderStatusSuccess"):Constants.surrenderStatus.get("surrenderStatusFail"));
        content.put("dealType", Constants.DEAL_TYPE);
        boolean flag = false;
        if (SUCCESS_CODE.equals(responseMessage.getCode())) {
            List<OrderDto> orderList = responseMessage.getData().getQueryOrderDetailInfoResp().getOrderList();
            for (OrderDto orderDto : orderList) {
            	String dataSource = orderDto.getOrderMain().getDataSource();	//数据来源
            	String associatedNo = orderDto.getOrderMain().getAssociatedNo();	//大保单
            	if ((Constants.DATA_SOURCE_QD.equals(dataSource) && StringUtil.isNotEmpty(associatedNo)) || Constants.DATA_SOURCE_XJQD.equals(dataSource)) {	//趣店回调退保数据
            		
                    surrenderCallBackReq.setBusinessNo(new BigInteger(policyNo.substring(2)));	//设置业务单号为保单号截取2位以后字符
                    
            		Map<String,String> surrenderCallBackData = new HashMap<String,String>();
            		surrenderCallBackData.put("bizCode", "YIANBAOXIAN");	//业务线
            		surrenderCallBackData.put("serviceCode", "qudian.insura.yanotify");	//服务接口
            		
                    content.put("refundAmount", Math.abs(changePremium)*100);	//退保金额(分)
                    
                    String inString = JSON.toJSONString(content) + ConfigUtil.getValue("qd.md5.key");	//生成MD5签名
                    String sign = MD5Helper.sign(inString);
            		surrenderCallBackData.put("sign", sign);	//签名
            		surrenderCallBackData.put("context", JSON.toJSONString(content));
            		surrenderCallBackReq.setContent(JSON.parseObject(JSON.toJSONString(surrenderCallBackData)));
            		flag = true;
                    logger.info("趣店回调,退保数据为：{},", JSON.toJSONString(surrenderCallBackData));
            	} else {
                    surrenderCallBackReq.setContent(content);
                    flag = true;
            	}
            	if (flag){
            		break;
            	}
            }
        } else {
        	logger.error("查询订单详情失败,订单号为:{},失败原因:{}", orderCode, responseMessage.getMessage());
        }
        
        HttpResponseWrapper result = new ClientUtils().connectServer(surrenderCallBackReq, ConfigUtil.getValue("sns.callback.url"));
        
        if (result.getStatus()) {
            responseMessage = JSON.parseObject((String)result.getContent(), ResponseMessage.class);
            if (SUCCESS_CODE.equals(responseMessage.getCode())) {
                logger.info("退保支付回调成功,请求信息{}", JSON.toJSONString(surrenderCallBackReq));
            } else {
                logger.error("退保支付回调失败,请求信息{},响应状态为:{},失败原因:{}",JSON.toJSONString(surrenderCallBackReq), responseMessage.getStatusCode(), responseMessage.getMessage());
            }
        } else {
            logger.error("退保支付回调失败,请求信息{}", JSON.toJSONString(surrenderCallBackReq) + ",失败原因:连接SNS服务失败");
        }
        logger.info("----------------退保回调结束--------------------");
    }
    
    /** 
     * 投保调dysub存缓存
     * <p>User: lipengfei
     * <p>Date: 2017年4月26日
     * <p>Version: 1.0
     */
    public void hsetPolicyNoToRedis(ShopOrderDto shopOrderDto, String policyNo){
        logger.info("----------------投保调dysub开始--------------------");
        PolicyNoToRedisReq policyNoToRedisReq = new PolicyNoToRedisReq();
        ObjectUtil.copyProperties(policyNoToRedisReq, shopOrderDto);
        DysubRequestMessage dysubRequestMessage = new DysubRequestMessage();
        dysubRequestMessage.setInterfaceCode("PolicyNoToRedis");
        dysubRequestMessage.setRequestTime(new Date());
        dysubRequestMessage.getData().setPolicyNoToRedisReq(policyNoToRedisReq);
        try {
        	HttpResponseWrapper result = new ClientUtils().connectServer(dysubRequestMessage, ConfigUtil.getValue("remote.dysub.url"));
	        if (result.getStatus()) {
	            DysubResponseMessage responseMessage = JSON.parseObject((String)result.getContent(), DysubResponseMessage.class);
	            if (SUCCESS_CODE.equals(responseMessage.getCode())) {
	                logger.info("DYSUB添加保单信息缓存成功,保单号{}", policyNo);
	            } else {
	                logger.error("DYSUB添加保单信息缓存失败,保单号{},失败原因:{}", policyNo, responseMessage.getMessage());
	            }
	        } else {
	            logger.error("DYSUB添加保单信息缓存失败,保单号{}", policyNo + ",失败原因:连接DYSUB服务失败");
	        }
        } catch (Exception e) {
        	logger.error("DYSUB添加保单信息缓存失败,保单号{}", policyNo + ",失败原因:{}", e);
        }
        logger.info("----------------投保调dysub结束--------------------");
    }
    
    /** delete by hguoqing 2018/3/27 for order回调接口统一处理 begin **/
    /** 
     * 退保调dysub清缓存
     * <p>User: lipengfei
     * <p>Date: 2017年4月26日
     * <p>Version: 1.0
     */
    /*public void resetPolicyInfoRedisHset(ShopOrderDto shopOrderDto, String policyNo){
        logger.info("----------------投保调dysub开始--------------------");
        PolicyNoToRedisReq policyNoToRedisReq = new PolicyNoToRedisReq();
        ObjectUtil.copyProperties(policyNoToRedisReq, shopOrderDto);
        DysubRequestMessage dysubRequestMessage = new DysubRequestMessage();
        dysubRequestMessage.setInterfaceCode("ResetPolicyNoToRedis");
        dysubRequestMessage.setRequestTime(new Date());
        dysubRequestMessage.getData().setPolicyNoToRedisReq(policyNoToRedisReq);
        try {
        	HttpResponseWrapper result = new ClientUtils().connectServer(dysubRequestMessage, ConfigUtil.getValue("remote.dysub.url"));
	        if (result.getStatus()) {
	            DysubResponseMessage responseMessage = JSON.parseObject((String)result.getContent(), DysubResponseMessage.class);
	            if (SUCCESS_CODE.equals(responseMessage.getCode())) {
	                logger.info("DYSUB清除保单信息缓存成功,保单号{}", policyNo);
	            } else {
	                logger.error("DYSUB清除保单信息缓存失败,保单号{},失败原因:{}", policyNo, responseMessage.getMessage());
	            }
	        } else {
	            logger.error("DYSUB清除保单信息缓存失败,保单号{}", policyNo + ",失败原因:连接DYSUB服务失败");
	        }
        } catch (Exception e) {
        	logger.error("DYSUB清除保单信息缓存失败,保单号{}", policyNo + ",失败原因:{}", e);
        }
        logger.info("----------------投保调dysub结束--------------------");
    }*/
    
    /** 
     * 退保数据回调至FTP
     * <p>User: lshuang
     * <p>Date: 2017-12-29
     * <p>Version: 1.0
     * @param policyNo
     * @return
     */
    /* added by lshuang 2017/12/29 for RM-4353 和包支付-航空意外险-SFTP每日对账 begin*/
/*	@Override
	public void callBackFtpSurrenderStatus(ShopOrderDto shopOrderDto, String policyNo) throws Exception {
		FtpCallBackReq ftpCallBackReq = new FtpCallBackReq();
        ObjectUtil.copyProperties(ftpCallBackReq, shopOrderDto);
	    DysubRequestMessage dysubRequestMessage = new DysubRequestMessage();
	    dysubRequestMessage.setInterfaceCode(Constants.CALLBACK_SURRENDER_RECONCILIATION);
	    dysubRequestMessage.setRequestTime(new Date());
	    dysubRequestMessage.getData().setFtpCallBackReq(ftpCallBackReq);
		try {
			HttpResponseWrapper result = new ClientUtils().connectServer(dysubRequestMessage, ConfigUtil.getValue("remote.dysub.url"));
	        if (result.getStatus()) {
	            DysubResponseMessage responseMessage = JSON.parseObject((String)result.getContent(), DysubResponseMessage.class);
	            if (SUCCESS_CODE.equals(responseMessage.getCode())) {
	                logger.info("dysub插入ftp库成功,保单号{}", policyNo);
	            } else {
	                logger.error("dysub插入ftp库失败,保单号{},失败原因:{}", policyNo, responseMessage.getMessage());
	            }
	        } else {
	            logger.error("dysub插入ftp库失败,保单号{}", policyNo + ",失败原因:连接DYSUB服务失败");
	        }
        } catch (Exception e) {
        	logger.error("dysub插入ftp库发生异常,保单号{}", policyNo + ",失败原因:{}", e);
        }
	}
     added by lshuang 2017/12/29 for RM-4353 和包支付-航空意外险-SFTP每日对账end
*/
    /** delete by hguoqing 2018/3/27 for order回调接口统一处理 end **/
    
    /*///////////////////////////统一生成保单号规则,不允许修改、清除Redis缓存,需备份各个险种的取号信息,否则取号会重新从1开始！/////////////////////////////*/
    /**
     * 取保单号
     * @param prefix 8A
     * @param channelCode 渠道编码 201
     * @param riskCode 险种代码
     * @return
     */
    @Override
    public String createPolicyNo(String prefix, String channelCode, String riskCode) {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        return prefix
                + channelCode
                + riskCode
                + year
                + String.format("%011d", redisTemplateTakeNo.getIncrBy("ORD_POLICY_NO_" + prefix + "_" + channelCode + "_" + riskCode + "_" + year));
    }
    /*//////////////////////////统一生成保单号规则,不允许修改、清除Redis缓存,需备份各个险种的取号信息,否则取号会重新从1开始！//////////////////////////////*/
    
    
    public ResponseMessage queryPolicyListForW(RequestMessage requestMessageObj) throws Exception {
        ResponseMessage responseMessage = new ResponseMessage();
        QueryPolicyListReq queryPolicyListReq = requestMessageObj.getData().getQueryPolicyListReq();
        
        String uid = requestMessageObj.getUserId();
        String invalidFlag = queryPolicyListReq.getInvalidFlag();
        String docType = queryPolicyListReq.getDocType();
        String docNo = queryPolicyListReq.getDocNo();
        String docName=queryPolicyListReq.getDocName();

        Integer startIndex = 0;
        Integer pageSize = 1000;
        // 传入信息校验
        StringBuffer checkMsg = new StringBuffer();
        if (StringUtil.isEmpty(uid)) {
            if(StringUtil.isEmpty(docType)) {
                checkMsg.append("证件类型不能为空,");
            }
            if(StringUtil.isEmpty(docNo)) {
                checkMsg.append("证件号不能为空,");
            }
            /* added by hbiao 2018/05/25 for [NP-73]官网官微系统重构-保单查询接口增加姓名条件（queryPolicyListForW） 进行的修改 begin */
            if(StringUtil.isEmpty(docName)) {
            	checkMsg.append("姓名不能为空,");
            }
            /* added by hbiao 2018/05/25 for [NP-73]官网官微系统重构-保单查询接口增加姓名条件（queryPolicyListForW） 进行的修改 begin */
        }
        if (StringUtil.isNotEmpty(checkMsg.toString())) {
            responseMessage.setMessage(checkMsg.substring(0, checkMsg.length() - 1));
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }

        // Modify by Qu Dihuai for ITPRO-721 start
        final Date currentDate = new Date();
        Set<String> policyNoSet = null;
        List<PolicyInfo> policyInfoList = null;
        Map<String, PolicyInfo> policyInfoMap = new HashMap<String,PolicyInfo>();
        if(StringUtil.isNotEmpty(uid)) {
            BigInteger userId = new BigInteger(uid);
            Map<String,Object> paramMap = new HashMap<String,Object>();
            paramMap.put("userId", userId);
            paramMap.put("startIndex", startIndex);
            paramMap.put("pageSize", pageSize);
            paramMap.put("invalidFlag", invalidFlag);
            paramMap.put("currentDate", currentDate);
            policyInfoList = orderMainService.queryPolicyList(paramMap);
            paramMap.put("actionType", "count");
			
			policyNoSet = new HashSet<String>();
			String policyNo;
			for (final PolicyInfo info : policyInfoList) {
				if (info != null && (policyNo = info.getPolicyNo()) != null) {
					policyNoSet.add(policyNo);
					policyInfoMap.put(policyNo, info);
				}
			}
			logger.info("根据用户ID查询, 查询参数为userId={}, invalidFlag={}, 符合的保单数量为{}, 保单号分别为: {}.", userId, invalidFlag, policyNoSet.size(), policyNoSet);
		}
		
		if (StringUtil.isNotEmpty(docNo) && StringUtil.isNotEmpty(docType)) {
			final Map<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("startIndex", startIndex);
			paramMap.put("pageSize", pageSize);
			paramMap.put("invalidFlag", invalidFlag);
			paramMap.put("docNo", docNo);
			paramMap.put("docType", docType);
			paramMap.put("docName", docName);
			paramMap.put("currentDate", currentDate);
			policyInfoList = orderMainService.queryPoliciesByDocNoAndType(paramMap);
			
			policyNoSet = new HashSet<String>();
			String policyNo;
			for (final PolicyInfo info : policyInfoList) {
				if (info != null && (policyNo = info.getPolicyNo()) != null) {
					policyNoSet.add(policyNo);
					policyInfoMap.put(policyNo, info);
				}
			}
			logger.info("根据证件查询, 查询参数为docNo={}, docType={}, docName={}, invalidFlag={}, 符合的保单数量为{}, 保单号分别为{}.", docNo, docType, docName, invalidFlag, policyNoSet.size(), policyNoSet);
		}
		
        if(policyInfoList == null){
            policyInfoList = new ArrayList<PolicyInfo>();
        } else{
            policyInfoList.clear();
        }
        
        policyNoSet = new HashSet<String>();
        for(Map.Entry<String, PolicyInfo> entry : policyInfoMap.entrySet()) {
            policyInfoList.add(entry.getValue());
            policyNoSet.add(entry.getKey());
        }
        logger.info("根据查询条件uid={}, docNo={}, docType={}, 所有符合条件的保单数量为{}, 保单号分别为{}.", value(uid), value(docNo), value(docType), policyNoSet.size(), policyNoSet);
        // Modify by Qu Dihuai for ITPRO-721 end
        
        Collections.sort(policyInfoList);
        
        QueryPolicyListResp queryPolicyListResp = new QueryPolicyListResp();
        queryPolicyListResp.setPolicyInfoList(policyInfoList);
        queryPolicyListResp.setTotal(policyInfoList.size());
        responseMessage.getData().setQueryPolicyListResp(queryPolicyListResp);
        
        responseMessage.setMessage("success");
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);
        return responseMessage;
    }
    
    /**
     * 查询暂收款是否可用
     * <p>User: wangwf
     * <p>Date: 2017-7-12
     * <p>Version: 1.0
     * @param dataSource
     * @param poaSerialNo
     * @return
     * @throws Exception 
     */
    /** delete by zhaobaoyang 2018/08/14 for RM-6864 新收付暂收款功能需求-中台系统  begin  */
    /*
    private void checkPoa(String dataSource,String agrtCode,String poaSerialNo,BigInteger orderCode) throws Exception{
    	String field = dataSource + FIELD_SEPARATOR + poaSerialNo ;
    	
    	//查询暂收款余额
    	List<FinReqBizData> bizDataList = new ArrayList<FinReqBizData>();
		FinReqBizData bizData = new FinReqBizData();
		bizData.setDataSource(dataSource);
		bizData.setPoaSerialNo(poaSerialNo);
		bizDataList.add(bizData);
	    FinRequestMessage requestMessage = new FinRequestMessage();
	    requestMessage.getData().setReqBizData(bizDataList);
	    FinResponseMessage responseMessage = finService.checkPoa(requestMessage);
	    if(!SUCCESS_CODE.equals(responseMessage.getCode())){
	    	logger.error("订单号{},暂收款{} 查询信息失败,响应状态为:{},失败原因:{}", orderCode, poaSerialNo , responseMessage.getStatusCode(), responseMessage.getMessage());
	    	throw new MessageException(responseMessage.getStatusCode(),"查询暂收款失败");
	    }
	    BigDecimal enabledAmount = responseMessage.getData().getResBizData().get(0).getEnabledAmount();
    	
    	//查询订单金额
    	ShopOrderInfoDto shopOrderInfoDto = new ShopOrderInfoDto();
    	shopOrderInfoDto.setOrderCode(orderCode);
    	shopOrderInfoDto = shopOrderInfoService.selectByPrimaryKey(shopOrderInfoDto);
    	BigDecimal orderAmount = shopOrderInfoDto.getOrderAmount();
    	if(DecimalUtil.greaterThanLatter(orderAmount, enabledAmount)){
    		throw new MessageException("该订单暂收款可用余额不足");
    	}
    	
    	//查询暂收款阈值相关配置信息
    	 modify by zhbaoyang 2018/05/04 for RM-6679暂收款业务-剩余金额提醒 begin 
    	String poaInfo = null;
    	if (StringUtils.contains(Constants.AGRTCODE_BBPT_3405, agrtCode)){
    		poaInfo = Constants.poaInfoMap.get(dataSource + FIELD_SEPARATOR + "AGRTCODE_BBPT_3405");
    	} else if (StringUtils.contains(Constants.AGRTCODE_ACM_3409, agrtCode)){
    		poaInfo = Constants.poaInfoMap.get(dataSource + FIELD_SEPARATOR + "AGRTCODE_ACM_3409");
    	} else if (StringUtils.contains(Constants.AGRTCODE_WKFBJ_2202, agrtCode)){
    		poaInfo = Constants.poaInfoMap.get(dataSource + FIELD_SEPARATOR + "AGRTCODE_WKFBJ_2202");
    	} else if (StringUtils.contains(Constants.AGRTCODE_SHHF_2202, agrtCode)){
    		poaInfo = Constants.poaInfoMap.get(dataSource + FIELD_SEPARATOR + "AGRTCODE_SHHF_2202");
    	} else if (StringUtils.contains(Constants.AGRTCODE_GZLB_3412, agrtCode)){
    		poaInfo = Constants.poaInfoMap.get(dataSource + FIELD_SEPARATOR + "AGRTCODE_GZLB_3412");
    	}
    	 modify by zhbaoyang 2018/05/04 for RM-6679暂收款业务-剩余金额提醒 end 
    	if(StringUtil.isNotEmpty(poaInfo)){
    		JSONObject jsonObject = JSONObject.parseObject(poaInfo);
    		Map<String,Object> paramMap = null;
    		//获取配置暂收款阈值
    		BigDecimal poaLimit = (BigDecimal) jsonObject.getBigDecimal("poaLimit");
    		
    		BigDecimal nowEnabledAmount = enabledAmount.subtract(orderAmount);
    		//暂收款阈值大于等于可用余额
    		if(DecimalUtil.greaterThanOrEqualsLatter(poaLimit, enabledAmount)){
    			String isEmail = (String) jsonObject.getString("isEmail");
    			String emailFlag = (String) redisTemplate.get(POA_EMAIL+field);
    			String subject = "";
    			String emailTo = "";
    			String emailCc = "";
    			// 1 每天仅发送一封邮件 ; 2  达到阈值即发送
    			if(StringUtil.isNotEmpty(isEmail) && StringUtil.isEmpty(emailFlag)){
    				paramMap = new HashMap<String, Object>();
    				Map<String,Object> templateModel = new HashMap<String, Object>();
    				 modify by zhbaoyang 2018/05/04 for RM-6679暂收款业务-剩余金额提醒 begin 
    				//保保平台
    				if(Constants.DATA_SOURCE_BBPT.equals(dataSource)){
    					subject = ConfigUtil.getValue("O-BBPT.poa.subject");
    					emailTo = ConfigUtil.getValue("O-BBPT.poa.emailTo");
    					emailCc = ConfigUtil.getValue("O-BBPT.poa.emailCc");
    				}
    				//爱出门
    				if(Constants.DATA_SOURCE_ACM.equals(dataSource)){
    					subject = ConfigUtil.getValue("O-ACM.poa.subject");
    					emailTo = ConfigUtil.getValue("O-ACM.poa.emailTo");
    					emailCc = ConfigUtil.getValue("O-ACM.poa.emailCc");
    				}
    				//北京无卡付
    				if(Constants.DATA_SOURCE_WKFBJ.equals(dataSource)){
    					subject = ConfigUtil.getValue("O-WKFBJ.poa.subject");
    					emailTo = ConfigUtil.getValue("O-WKFBJ.poa.emailTo");
    					emailCc = ConfigUtil.getValue("O-WKFBJ.poa.emailCc");
    				}
    				//上海和付
    				if(Constants.DATA_SOURCE_SHHF.equals(dataSource)){
    					subject = ConfigUtil.getValue("O-SHHF.poa.subject");
    					emailTo = ConfigUtil.getValue("O-SHHF.poa.emailTo");
    					emailCc = ConfigUtil.getValue("O-SHHF.poa.emailCc");
    				}
    				//广州联保
    				if(Constants.DATA_SOURCE_GZLB.equals(dataSource)){
    					subject = ConfigUtil.getValue("O-GZLB.poa.subject");
    					emailTo = ConfigUtil.getValue("O-GZLB.poa.emailTo");
    					emailCc = ConfigUtil.getValue("O-GZLB.poa.emailCc");
    				}
    				templateModel.put("channelName", jsonObject.getString("channelName"));
    				templateModel.put("poaAmount", nowEnabledAmount);
    				 modify by zhbaoyang 2018/05/04 for RM-6679暂收款业务-剩余金额提醒 end 
    				paramMap.put("subject", subject);
    				paramMap.put("emailTo", emailTo);
    				paramMap.put("emailCc", emailCc);
    				paramMap.put("businessNo", poaSerialNo);
    				paramMap.put("businessNo2", dataSource);
    				paramMap.put("emailModule", jsonObject.getString("emailModule"));
    				paramMap.put("templateModel", JSON.toJSONString(templateModel));
    				MailResponseDto responseDto = this.sendEmail(paramMap);
    				if(SUCCESS_CODE.equals(responseDto.getCode())){
    					if("1".equals(isEmail)){
    						Long seconds = TimeUtil.getIntervalSeconds(new Date(), TimeUtil.endOfDay(new Date())); //计算出当天23:59:59距离当前时间秒数差
    						redisTemplate.set(POA_EMAIL+field, "1", seconds.intValue());
    					}
    				} else{
    					logger.error("订单号{} 暂收款{} 发送至邮箱{} 的邮件失败,响应状态为:{},失败原因:{}",orderCode,poaSerialNo,emailTo,responseDto.getStatusCode(),responseDto.getMessage());
    				}
    			}
    		}
    	}
    }
    */
    /** delete by zhaobaoyang 2018/08/14 for RM-6864 新收付暂收款功能需求-中台系统  end  */
    /**
     * 新收付查询暂收款是否可用
     * <p>User: zhaobaoyang
     * <p>Date: 2018-06-14
     * <p>Version: 1.0
     * @param dataSource
     * @param agrtCode
     * @param poaSerialNo
     * @param orderCode
     * @throws Exception
     */
    private void nfinCheckPoa(String dataSource,String agrtCode,String poaSerialNo,BigInteger orderCode) throws Exception{
    	String field = dataSource + FIELD_SEPARATOR + poaSerialNo ;
    	//查询暂收款余额
	    NFinRequestMessage requestMessage = new NFinRequestMessage();
	    requestMessage.setPoaSerialNo(poaSerialNo);;
	    NFinResponseMessage responseMessage = nfinService.checkPoa(requestMessage);
	    if(!SUCCESS_CODE.equals(responseMessage.getReturnCode())){
	    	logger.error("订单号{},暂收款{} 查询信息失败,响应状态为:{},失败原因:{}", orderCode, poaSerialNo , responseMessage.getReturnCode(), responseMessage.getReturnMsg());
	    	throw new MessageException(responseMessage.getReturnCode(),"查询暂收款失败");
	    }
    	
		if (responseMessage.getValidInd().equals("1")) {
			BigDecimal enabledAmount = responseMessage.getEnabledAmount();// 可用余额
			BigDecimal minBalance = responseMessage.getMiniBalance();// 暂收款阈值
			//查询订单金额
			ShopOrderInfoDto shopOrderInfoDto = new ShopOrderInfoDto();
			shopOrderInfoDto.setOrderCode(orderCode);
			shopOrderInfoDto = shopOrderInfoService.selectByPrimaryKey(shopOrderInfoDto);
			BigDecimal orderAmount = shopOrderInfoDto.getOrderAmount();
			if (DecimalUtil.greaterThanLatter(orderAmount, enabledAmount)) {
				throw new MessageException("暂收款余额不足");
			}
			BigDecimal nowEnabledAmount = enabledAmount.subtract(orderAmount);
			//出单后可用余额小于等于暂收款阈值
			if(DecimalUtil.greaterThanOrEqualsLatter(minBalance, nowEnabledAmount)){
				
				//获取产品方案信息
				PdmsSolutionInfoDto pdmsSolutionInfoDto = null;
			    PdmsResponseMessage pdmsResponseMessage = getPdmsSolutionProd(agrtCode, null, null);
			    if (SUCCESS_CODE.equals(pdmsResponseMessage.getCode())) {
			    	pdmsSolutionInfoDto = pdmsResponseMessage.getData().getGetSolutionProdResp().getPdmsSolutionInfoDto();
				} else {
					logger.error("销售方案号:{},销售方案号信息有误,响应状态为:{},错误信息为:{}", agrtCode, pdmsResponseMessage.getStatusCode(), pdmsResponseMessage.getMessage());
					throw new MessageException(pdmsResponseMessage.getStatusCode(), pdmsResponseMessage.getMessage());
				}
			    
			    PdmsSolutionDto solutionMain = pdmsSolutionInfoDto.getSolutionMain();		    
			    if (solutionMain.getIsEmail().equals("1")) {
			    	List<PdmsSolutionMessageDto> pdmsSolutionMessageList = pdmsSolutionInfoDto.getSolutionMessageList();
				    PdmsSolutionMessageDto pdmsSolutionMessage = null;
				    for (PdmsSolutionMessageDto pdmsSolutionMessageDto : pdmsSolutionMessageList) {
				    	if(pdmsSolutionMessageDto.getInvalidFlag() == 1 && pdmsSolutionMessageDto.getMsgName().equals("暂收款余额提醒邮件")){
				    		pdmsSolutionMessage = pdmsSolutionMessageDto;
				    		break;
				    	}
					}
			    	if (ObjectUtil.isNotNull(pdmsSolutionMessage)) {
				    	String mailTo = pdmsSolutionMessage.getRdRecipientEmail();
				    	String mailCc = pdmsSolutionMessage.getRdCcpeopleEmail();
				    	String templateId = pdmsSolutionMessage.getMsgTmplId();
				    	
		    			String emailFlag = (String) redisTemplate.get(POA_EMAIL+field);
		    			// 每天仅发送一封邮件 
		    			if(StringUtil.isEmpty(emailFlag)){
		    				Map<String,Object> templateModel = new HashMap<String, Object>();
		    				templateModel.put("channelName",responseMessage.getOwnerName());
		    				templateModel.put("xxxx", poaSerialNo);
		    				templateModel.put("poaAmount", nowEnabledAmount);
		    				Map<String,Object> paramMap = new HashMap<String, Object>();
		    				paramMap.put("templateId", templateId);
		    				paramMap.put("subject", "【易安保险】预存款余额提醒");
		    				paramMap.put("emailTo", mailTo);
		    				paramMap.put("emailCc", mailCc);
		    				paramMap.put("businessNo", poaSerialNo);
		    				paramMap.put("businessNo2", dataSource);
		    				paramMap.put("templateModel", JSON.toJSONString(templateModel));
		    				MailResponseDto responseDto = this.sendEmail(paramMap);
		    				if(SUCCESS_CODE.equals(responseDto.getCode())){
		    					Long seconds = TimeUtil.getIntervalSeconds(new Date(), TimeUtil.endOfDay(new Date())); //计算出当天23:59:59距离当前时间秒数差
		    					redisTemplate.set(POA_EMAIL+field, "1", seconds.intValue());
		    				} else{
		    					logger.error("订单号{},暂收款{},发送至邮箱{}的邮件失败,响应状态为:{},失败原因:{}", orderCode, poaSerialNo, mailTo , responseDto.getStatusCode(), responseDto.getMessage());
		    				}
		    			}
				    } else {
				    	logger.error("订单号{},暂收款{},暂收款邮件发送失败原因:{}", orderCode, poaSerialNo, "未配置暂收款邮件");
				    }
			    }
			}
		} else {
	    	logger.error("订单号{},暂收款{},失败原因:{}", orderCode, poaSerialNo , "该订单暂收款无效!");
	    	throw new MessageException("该订单暂收款无效!");
	    }
    }
	
    /**
     * 发送邮件
     * <p>User: wangwf
     * <p>Date: 2017-7-13
     * <p>Version: 1.0
     * @param paramMap
     * @return
     */
    private MailResponseDto sendEmail(Map<String,Object> paramMap){
		MailRequestDto requestDto = new MailRequestDto();
		requestDto.setIsTime("1");//即时发送
		requestDto.setTemplateId((String)paramMap.get("templateId"));
        requestDto.setTemplateModel((String)paramMap.get("templateModel"));
        requestDto.setEmailTo((String)paramMap.get("emailTo"));
        requestDto.setEmailCc((String)paramMap.get("emailCc"));
        requestDto.setSubject((String)paramMap.get("subject"));
        requestDto.setBusinessNo((String)paramMap.get("businessNo"));
        requestDto.setBusinessNo2((String)paramMap.get("businessNo2"));
        return mailService.sendEmail(requestDto);
    }
    
	/**
	 * 查询保单的批单信息接口
	 * <p>User: lshuang
	 * <p>Date: 2017-11-30
	 * <p>Version: 1.0
	 * @param requestMessageObj
	 * @return
	 * @throws Exception
	 */
	@Override
	public ResponseMessage queryPolicyEndorInfo(RequestMessage requestMessageObj) throws Exception {
		ResponseMessage responseMessage = new ResponseMessage();
    	
		String policyNo = requestMessageObj.getData().getQueryPolicyEndorInfoReq().getPolicyNo();
		
    	// 传入信息校验
        StringBuffer checkMsg = new StringBuffer();
        
        if(StringUtil.isEmpty(policyNo)) {
        	checkMsg.append("保单号不能为空,");
        }
		
		if (StringUtil.isNotEmpty(checkMsg.toString())) {
			responseMessage.setMessage(checkMsg.substring(0, checkMsg.length() - 1));
			responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
			responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }
		HttpResponseWrapper result = new ClientUtils().connectServer(requestMessageObj, ConfigUtil.getValue("remote.trans.url"));
        if (result.getStatus()) {
        	responseMessage = JSON.parseObject((String)result.getContent(), ResponseMessage.class);
            if (SUCCESS_CODE.equals(responseMessage.getCode())) {
            	QueryPolicyEndorInfoResp queryPolicyDetailInfoResp = responseMessage.getData().getQueryPolicyEndorInfoResp();
                responseMessage.getData().setQueryPolicyEndorInfoResp(queryPolicyDetailInfoResp);
            } else {
                responseMessage.setCode(FAIL_CODE);
                responseMessage.setStatusCode(responseMessage.getStatusCode());
                responseMessage.setMessage(responseMessage.getMessage());
                responseMessage.setState(FAIL_STATE);
                return responseMessage;
            }
        } else {
            responseMessage.setMessage(result.getErrorMessage() + "(调用Trans)");
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + StatusCodeProvider.getCode(result, FAIL_CODE));
            responseMessage.setState(FAIL_STATE);
            logger.error("policyNo:" + policyNo + ",fail:" + result.getErrorMessage() + "(调用Trans)");
            return responseMessage;
        }
        responseMessage.setMessage(SUCCESS_MSG);
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);
		return responseMessage;
	}

	private String value(final String value) {
		if (StringUtil.isEmpty(value)) {
			return null;
		}
		return value;
	}
	
	/**
	 * 5.2.36 查询产品保单列表信息
	 * <p>User: lpengfei
	 * <p>Date: 2017年12月16日
	 * <p>Version: 1.0
	 */
	@Override
	public ResponseMessage queryProdToPolicyList(RequestMessage requestMessageObj) throws Exception {
		ResponseMessage responseMessage = new ResponseMessage();
		QueryProdToPolicyListReq queryProdToPolicyListReq = requestMessageObj.getData().getQueryProdToPolicyListReq();
		QueryProdToPolicyListResp queryProdToPolicyListResp = new QueryProdToPolicyListResp();
		String agrtCode = queryProdToPolicyListReq.getAgrtCode();
		String projectCode = queryProdToPolicyListReq.getProjectCode();
		Date orderDate = queryProdToPolicyListReq.getOrderDate();
		Integer startIndex = queryProdToPolicyListReq.getStartIndex();
		Integer pageSize = queryProdToPolicyListReq.getPageSize();
		
		StringBuffer checkMsg = new StringBuffer();
		if (StringUtil.isEmpty(agrtCode) && StringUtil.isEmpty(projectCode)) {
		    checkMsg.append("销售方案代码和产品代码不能都为空,");
		}
		if (orderDate == null) {
			checkMsg.append("查询订单时间 不能都为空,");
		}
		if (startIndex == null) {
		    checkMsg.append("开始位置不能为空,");
		}
		if (pageSize == null) {
		    checkMsg.append("每页数量不能为空,");
		}
		if (StringUtil.isNotEmpty(checkMsg.toString())) {
		    responseMessage.setMessage(checkMsg.substring(0, checkMsg.length() - 1));
		    responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
		    responseMessage.setState(FAIL_STATE);
		    return responseMessage;
		}
		
		logger.info("-------------查询产品保单列表信息结束---------------");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startIndex", startIndex);
		paramMap.put("pageSize", pageSize);
		paramMap.put("agrtCode", agrtCode);
		paramMap.put("projectCode", projectCode);
		paramMap.put("orderDate", orderDate);
		List<ProdToPolicyInfo> prodToPolicyList = orderMainService.queryProdToPolicyList(paramMap);
		queryProdToPolicyListResp.setProdToPolicyList(prodToPolicyList);
		logger.info("-------------查询产品保单列表信息结束---------------");
		
		responseMessage.getData().setQueryProdToPolicyListResp(queryProdToPolicyListResp);
		responseMessage.setMessage(SUCCESS_MSG);
		responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
		responseMessage.setState(SUCCESS_STATE);
		return responseMessage;
	}
	
	/**
	 * 5.2.38 回调中台DYSUB
	 * <p>User: hguoqing
	 * <p>Date: 2018年3月26日
	 * <p>Version: 1.0
	 */
	@Override
	public void orderCallbackDysubData(ShopOrderDto shopOrderDto, String policyNo, String requestType) throws Exception {
		OrderCallBackDysubReq orderCallBackDysubReq = new OrderCallBackDysubReq();
	    ObjectUtil.copyProperties(orderCallBackDysubReq, shopOrderDto);
	    orderCallBackDysubReq.setRequestType(requestType);
	    DysubRequestMessage dysubRequestMessage = new DysubRequestMessage();
	    dysubRequestMessage.setInterfaceCode(Constants.ORDER_CALLBACK_DYSUB_DATA);
	    dysubRequestMessage.setRequestTime(new Date());
	    dysubRequestMessage.getData().setOrderCallBackDysubReq(orderCallBackDysubReq);
		try {
	        HttpResponseWrapper result = new ClientUtils().connectServer(dysubRequestMessage, ConfigUtil.getValue("remote.dysub.url"));
	        if (result.getStatus()) {
	            DysubResponseMessage responseMessage = JSON.parseObject((String)result.getContent (), DysubResponseMessage.class);
	            if (SUCCESS_CODE.equals(responseMessage.getCode())) {
	                logger.info("回调DYSUB成功,保单号{}", policyNo);
	            } else {
	                logger.error("回调DYSUB成功,处理失败,保单号{},失败原因:{}", policyNo, responseMessage.getMessage());
	            }
	        } else {
	            logger.error("回调DYSUB失败,保单号{}", policyNo + ",失败原因:连接DYSUB服务失败");
	        }
	    } catch (Exception e) {
	    	logger.error("ORDER回调DYSUB发生异常,保单号{}", policyNo + ",失败原因:{}", e);
	    }
	}

	/**
	 * 核保回调（核心调用）
	 * @param requestMessageObj
	 * @return
	 * @throws Exception
	 */
	@Override
	public ResponseMessage underwriterCallBack(RequestMessage requestMessageObj) throws Exception {

        ResponseMessage responseMessage = new ResponseMessage();
        UnderwriterCallBackReq underwriterCallBackReq = requestMessageObj.getData().getUnderwriterCallBackReq();

        String orderCodeTemp = underwriterCallBackReq.getOrderCode();
        String auditingStatus = underwriterCallBackReq.getAuditingStatus(); // 0:通过,1:不通过
        String proposalNo = underwriterCallBackReq.getProposalNo();
        String policyNo = underwriterCallBackReq.getPolicyNo();
        String codInd = underwriterCallBackReq.getCodInd();
        String poaSerialNo = underwriterCallBackReq.getPoaSerialNo();
        
        // 传入信息校验
        StringBuffer checkMsg = new StringBuffer();
        if (StringUtil.isEmpty(orderCodeTemp)) {
            checkMsg.append("订单号不能为空,");
        }
        if (StringUtil.isEmpty(auditingStatus)) {
            checkMsg.append("审核状态不能为空,");
        }
        if (StringUtil.isEmpty(codInd)) {
        	checkMsg.append("见费标识不能为空,");
        }
        if ("Y".equals(codInd) && StringUtil.isEmpty(poaSerialNo)) {
        	if (StringUtil.isEmpty(proposalNo)) {
                checkMsg.append("投保单号不能为空,");
            }
        } else {
        	if (StringUtil.isEmpty(policyNo)) {
        		checkMsg.append("保单号不能为空,");
            }
        }
        
        if (StringUtil.isNotEmpty(checkMsg.toString())) {
            responseMessage.setMessage(checkMsg.substring(0, checkMsg.length() - 1));
            responseMessage.setCode(FAIL_CODE);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }
        
        BigInteger orderCode = new BigInteger(orderCodeTemp);
        OrderMainDto orderMainDto = new OrderMainDto();
    	if ("0".equals(auditingStatus)) {
    		orderMainDto.setUnderwriterInd("1"); //人工审核通过
    	} else if ("1".equals(auditingStatus)){
    		orderMainDto.setUnderwriterInd("2"); //人工审核未通过
    	} else if ("2".equals(auditingStatus)){
    		orderMainDto.setUnderwriterInd("4"); //拒保
    	}
    	orderMainDto.setSynPolicySurrenderStatus("0"); // 已同步
    	orderMainDto.setUpdatedUser(UPDATED_USER);
    	orderMainDto.setUpdatedDate(new Date());
    	Condition orderMainCond = new Condition(OrderMainDto.class);
    	orderMainCond.createCriteria().andEqualTo("orderCode", orderCode);
    	if ("Y".equals(codInd) && StringUtil.isEmpty(poaSerialNo)) {//见费出单
    		orderMainCond.createCriteria().andEqualTo("proposalNo", proposalNo);
    	} else {//非见费出单/暂收款出单
    		orderMainCond.createCriteria().andEqualTo("policyNo", policyNo);
    	}
    	orderMainService.updateByConditionNotNull(orderMainDto, orderMainCond);
    	
		ShopOrderInfoDto shopOrderInfoDto = new ShopOrderInfoDto();
		shopOrderInfoDto.setOrderCode(orderCode);
		shopOrderInfoDto.setInvalidFlag(0);
		shopOrderInfoDto = shopOrderInfoService.selectOne(shopOrderInfoDto);
		if (ObjectUtil.isNotNull(shopOrderInfoDto)) {
			BigInteger userId = shopOrderInfoDto.getUserId();
			// 人工审核通知回调
			if (shopOrderInfoDto != null && StringUtil.isNotEmpty(shopOrderInfoDto.getAppId())) {
				String appId = shopOrderInfoDto.getAppId();
				List<String> appIdList = Arrays.asList(ConfigUtil.getValue("auditingAppIds").split(","));
				if (CollectionUtil.isNotEmpty(appIdList) && appIdList.contains(appId)) {
					auditingCallBack(appId, userId, underwriterCallBackReq);
				}
			}
		} else {
            logger.info("未查询到相关产品信息,订单号{}", orderCode);
		}
		
        // 成功返回信息
        responseMessage.setMessage(SUCCESS_MSG);
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);
        return responseMessage;
	}
    
	/**
	 * 核保回调通知处理
	 * @param appId
	 * @param userId
	 * @param orderCode
	 * @param proposalNo
	 * @param auditingStatus
	 * @param auditingMsg
	 * @throws Exception
	 */
    public void auditingCallBack(String appId, BigInteger userId,UnderwriterCallBackReq underwriterCallBackReq) throws Exception {
        
        String orderCodeTemp = underwriterCallBackReq.getOrderCode();
        String auditingStatus = underwriterCallBackReq.getAuditingStatus(); // 0:通过,1:不通过
        String proposalNo = underwriterCallBackReq.getProposalNo();
        String codInd = underwriterCallBackReq.getCodInd();
        String poaSerialNo = underwriterCallBackReq.getPoaSerialNo();
        String auditingMsg = underwriterCallBackReq.getAuditingMsg();
        
        BigInteger orderCode = new BigInteger(orderCodeTemp);

    	logger.info("----------------人工审核通知回调开始--------------------");
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setUserId(userId.toString());
        QueryOrderDetailInfoReq queryOrderDetailInfoReq = new QueryOrderDetailInfoReq();
        queryOrderDetailInfoReq.setOrderCode(underwriterCallBackReq.getOrderCode().toString());
        requestMessage.getData().setQueryOrderDetailInfoReq(queryOrderDetailInfoReq);

        //接口请求信息
        SurrenderCallBackReq surrenderCallBackReq = new SurrenderCallBackReq();
        surrenderCallBackReq.setAppId(appId);
        surrenderCallBackReq.setDealType(Constants.AUDITING_TYPE);
        
        JSONObject content = new JSONObject();
        content.put("orderExt", userId);
        content.put("orderCode", orderCode);
        content.put("auditingMsg", auditingMsg);
        content.put("status", auditingStatus);
        content.put("dealType", Constants.AUDITING_TYPE);
        if ("Y".equals(codInd) && StringUtil.isEmpty(poaSerialNo)) {//见费出单
        	surrenderCallBackReq.setProposalNo(proposalNo);
    		surrenderCallBackReq.setBusinessNo(new BigInteger(proposalNo));
    		content.put("proposalNo", proposalNo);
    	} else {//非见费出单/暂收款出单
    		
    	}
        
        surrenderCallBackReq.setContent(content);
    	HttpResponseWrapper result = new ClientUtils().connectServer(surrenderCallBackReq, ConfigUtil.getValue("sns.callback.url"));
    	if (result.getStatus()) {
    		ResponseMessage responseMessage = JSON.parseObject((String)result.getContent(), ResponseMessage.class);
            if (SUCCESS_CODE.equals(responseMessage.getCode())) {
                logger.info("人工审核通知回调成功,请求信息{}", JSON.toJSONString(surrenderCallBackReq));
            } else {
                logger.error("人工审核通知回调失败,请求信息{},响应状态为:{},失败原因:{}",JSON.toJSONString(surrenderCallBackReq), responseMessage.getStatusCode(), responseMessage.getMessage());
            }
        } else {
            logger.error("人工审核通知回调失败,请求信息{}", JSON.toJSONString(surrenderCallBackReq) + ",失败原因:连接SNS服务失败");
        }
        logger.info("----------------人工审核通知回调结束--------------------");
    }
    
    /**
     * 人工审核
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
	@Override
	public ResponseMessage manuallyAuditing(RequestMessage requestMessageObj) throws Exception {

        ResponseMessage responseMessage = new ResponseMessage();
        ManuallyAuditingReq manuallyAuditingReq = requestMessageObj.getData().getManuallyAuditingReq();
        // 用户ID
        String uid = requestMessageObj.getUserId();
        // 订单号
        String orderTmpCode = manuallyAuditingReq.getOrderCode();

        // 传入信息校验
        StringBuffer checkMsg = new StringBuffer();
        if (StringUtil.isEmpty(uid)) {
            checkMsg.append("用户ID不能为空,");
        }
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

        BigInteger userId = new BigInteger(uid);
        BigInteger orderCode = new BigInteger(orderTmpCode);
        
        OrderMainDto orderMainDto = new OrderMainDto();
        orderMainDto.setOrderCode(orderCode);
        List<OrderMainDto> orderMainDtoList = orderMainService.select(orderMainDto);
        if (CollectionUtil.isEmpty(orderMainDtoList)) {
        	responseMessage.setMessage("未查询到该订单信息");
            responseMessage.setCode(FAIL_CODE);
    		responseMessage.setStatusCode(FAIL_CODE);
            responseMessage.setState(FAIL_STATE);
            return responseMessage;
        }
        
    	String codInd = orderMainDtoList.get(0).getCodInd();
    	String poaSerialNo = orderMainDtoList.get(0).getPoaSerialNo();
        
    	ShopOrderDto shopOrderDto = this.getOrderDetailInfo(orderCode);
        List<CallBackOrderInfoDto> callBackOrderInfoList = new ArrayList<CallBackOrderInfoDto>();
    	
    	if ("Y".equals(codInd) && StringUtil.isEmpty(poaSerialNo)){//见费出单同步订单转投保
            // trans同步转保单处理 调用核心订单转投保单
            logger.info("-------------调用Trans调用核心订单转投保单接口开始---------------");
            TransRequestMessage transRequestMessage = new TransRequestMessage();
            transRequestMessage.setRequestTime(new Date());
            transRequestMessage.setInterfaceCode("OrderToProposal");
            
            TransOrderToProposalReq transOrderToProposalReq = new TransOrderToProposalReq();   
            transOrderToProposalReq.setShopOrderDto(shopOrderDto); 
            transRequestMessage.getData().setOrderToProposalReq(transOrderToProposalReq);
    		
            HttpResponseWrapper transResult = new ClientUtils().connectServer(transRequestMessage, ConfigUtil.getValue("remote.trans.url"));
            
            if (transResult.getStatus()) {
                TransResponseMessage transResponseMessage = JSON.parseObject((String)transResult.getContent(), TransResponseMessage.class);
                if(SUCCESS_CODE.equals(transResponseMessage.getCode())) {
                    TransOrderToProposalResp transOrderToProposalResp = transResponseMessage.getData().getOrderToProposalResp();
                    callBackOrderInfoList = transOrderToProposalResp.getCallBackOrderInfoList();
                    for (CallBackOrderInfoDto callBackOrderInfo : callBackOrderInfoList) {
                		if ("0".equals(callBackOrderInfo.getProposalPassFlag())) {
                			OrderMainDto orderMain = new OrderMainDto();
                        	orderMain.setOrderMainId(new BigInteger(callBackOrderInfo.getOrderId()));
                        	if ("0".equals(orderMainService.selectOne(orderMain).getUnderwriterInd())) {
                        		orderMain.setUnderwriterInd("3");
                        	}
                        	orderMain.setProposalNo(callBackOrderInfo.getProposalNo());
                        	orderMain.setUpdatedUser(uid);
                        	orderMain.setUpdatedDate(new Date());
                        	orderMainService.updateByPrimaryKeyNotNull(orderMain);
                		} else {
                			logger.error("订单转投保失败,响应信息为:{}",callBackOrderInfo.getMessage());
                        	throw new MessageException(transResponseMessage.getStatusCode(),"订单转投保:" + callBackOrderInfo.getMessage());
                		}
                	}     	
                	ShopOrderInfoDto shopOrderInfo = new ShopOrderInfoDto();
                    shopOrderInfo.setUserId(userId);
                    shopOrderInfo.setOrderCode(orderCode);
                    shopOrderInfo.setOrderStatus("1"); // 1-已确认
                    shopOrderInfo.setConfirmTime(new Date());
                    shopOrderInfo.setUpdatedUser(uid);
                    shopOrderInfo.setUpdatedDate(new Date());
                    shopOrderInfoService.updateByPrimaryKeyNotNull(shopOrderInfo);
                } else {
                	logger.error("订单转投保失败,响应状态为:{},响应信息为:{}",transResponseMessage.getStatusCode(),transResponseMessage.getMessage());
                	throw new MessageException(transResponseMessage.getStatusCode(),"订单转投保:" + transResponseMessage.getMessage());
                }
            } else {
            	String statusCode = Constants.STATUSCODE_PREFIX + StatusCodeProvider.getCode(transResult, FAIL_CODE);
            	logger.error("请求TRANS系统订单转投保接口失败,响应状态为:{},响应信息为:{}",transResult.getStatusCode(),"连接TRANS服务失败");
            	throw new MessageException(statusCode,"调用Trans订单转投保接口失败,原因:" + transResult.getErrorMessage());
            }
            logger.info("-------------调用Trans调用核心订单转投保单接口结束---------------");
            
            OrderToProposalResp orderToProposalResp = new OrderToProposalResp();
            orderToProposalResp.setOrderStatus("1");
            callBackOrderInfoList.add(new CallBackOrderInfoDto());
            orderToProposalResp.setCallBackOrderInfoList(callBackOrderInfoList);
            responseMessage.getData().setOrderToProposalResp(orderToProposalResp);
    	} else {//非见费出单/暂收款出单同步订单转保单（待完善）
    		//转保单返回信息
    	}
    	
        responseMessage.setMessage(SUCCESS_MSG);
        responseMessage.setCode(SUCCESS_CODE);
		responseMessage.setStatusCode(SUCCESS_CODE);
        responseMessage.setState(SUCCESS_STATE);
        return responseMessage;
	}
    
}
