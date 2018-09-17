package com.yaic.app.order.service;

import java.math.BigInteger;

import com.yaic.app.order.dto.msg.common.RequestMessage;
import com.yaic.app.order.dto.msg.common.ResponseMessage;
import com.yaic.app.order.dto.msg.common.ShopOrderDto;
import com.yaic.app.pdms.dto.msg.common.PdmsResponseMessage;

/**
 * 订单管理服务
 * @Author: lujicong
 * @Date: 2015-12-23
 * @Version: 1.0
 */
public interface OrderService {

    /**
     * 5.2.1 创建/修改订单
     * 
     * @Author lujicong
     * @Date: 2015-12-23
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    public ResponseMessage createOrder(RequestMessage requestMessageObj) throws Exception;

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
    public ResponseMessage queryOrderDetailInfo(RequestMessage requestMessageObj) throws Exception;

    /**
     * 获取订单详情信息
     * 
     * <p>User: lujicong
     * @Date: 2015-12-25
     * @Version: 1.0
     * @param userId
     * @param orderCode
     * @return
     */
    public ShopOrderDto getOrderDetailInfo(BigInteger orderCode);

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
    public ResponseMessage orderToProposal(RequestMessage requestMessageObj) throws Exception;

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
    public ResponseMessage callBackOrderInfo(RequestMessage requestMessageObj) throws Exception;

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
    public ResponseMessage updateOrderPayStatus(RequestMessage requestMessageObj) throws Exception;

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
    public ResponseMessage updateOrderPayInfo(RequestMessage requestMessageObj) throws Exception;

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
    public ResponseMessage queryOrderList(RequestMessage requestMessageObj) throws Exception;

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
    public ResponseMessage queryOrderCount(RequestMessage requestMessageObj) throws Exception;

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
    public ResponseMessage dealOrderAfterPay(RequestMessage requestMessageObj) throws Exception;

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
    public ResponseMessage cancelInsurance(RequestMessage requestMessageObj) throws Exception;

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
    public ResponseMessage updateOrderStatus(RequestMessage requestMessageObj) throws Exception;

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
    public ResponseMessage cancelInsuranceCallBack(RequestMessage requestMessageObj) throws Exception;

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
    public ResponseMessage queryPolicyList(RequestMessage requestMessageObj) throws Exception;

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
    public ResponseMessage queryPolicyDetailInfo(RequestMessage requestMessageObj) throws Exception;

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
    public ResponseMessage queryUserIdByOrderCode(RequestMessage requestMessageObj) throws Exception;

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
    public ResponseMessage queryOrderPayStatus(RequestMessage requestMessageObj) throws Exception;

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
    public ResponseMessage orderToPolicy(RequestMessage requestMessageObj) throws Exception;

    /**
     * 5.2.20 获取支付交易流水号接口
     * <p>User: lipengfei
     * <p>Date: 2016年5月5日
     * <p>Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    public ResponseMessage getBusinessNo(RequestMessage requestMessageObj) throws Exception;

    /**
     * 5.2.21 流水号转保单接口
     * <p>User: lipengfei
     * <p>Date: 2016年5月6日
     * <p>Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    public ResponseMessage trandNoToPay(RequestMessage requestMessageObj) throws Exception;

    /**
     * 5.2.23 重复投保查询接口
     * <p>User: lipengfei
     * <p>Date: 2016年5月30日
     * <p>Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    public ResponseMessage queryOrderRepeated(RequestMessage requestMessageObj) throws Exception;

    /**
     * 5.2.24 查询是否投保并返回投保信息
     * <p>User: lishuang
     * <p>Date: 2016-6-23
     * <p>Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    public ResponseMessage queryCustomerAndOrderInfo(RequestMessage requestMessageObj) throws Exception;

    /**
     * 5.2.25 查询家财险投保数
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    public ResponseMessage queryPropertyPolicyCount(RequestMessage requestMessageObj) throws Exception;

    /**
     * 5.2.26 订单转保单并插入参数
     * <p>User: lipengfei
     * <p>Date: 2016年7月14日
     * <p>Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    public ResponseMessage orderToPolicyUpdateData(RequestMessage requestMessageObj) throws Exception;

    /**
     * 5.2.27 保单批改 动态标的批改
     * <p>User: MASK
     * <p>Date: 2016年7月30日
     * <p>Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    public ResponseMessage endorForZ(RequestMessage requestMessageObj) throws Exception;

    /**
     * 将保单信息存储至缓存
     * <p>User: lipengfei
     * <p>Date: 2016年9月1日
     * <p>Version: 1.0
     */
    public void addPolicyNoToRedis(ShopOrderDto shopOrder, String orderTmpCode) throws Exception;

    /**
     * 5.2.28 激活卡查询验真接口
     * @Author: lipengfei
     * @Date: 2016-12-1
     * @Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    public ResponseMessage queryActivationCardInfo(RequestMessage requestMessageObj) throws Exception;
    
    /**
     * 5.2.29 激活卡 激活/核销
     * @author lipengfei
     * @date 2016-12-01
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    public ResponseMessage activationCardLogout(RequestMessage requestMessageObj) throws Exception;
    
    
    /**
     * 第三方在线批改关系人
     * <p>User: admin
     * <p>Date: 2017-2-16
     * <p>Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    public ResponseMessage endorForOuter(RequestMessage requestMessageObj) throws Exception;
    
    /**
     * 5.2.30 查询订单支付信息
     * @author chenguang
     * @date 2017-02-06
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    public ResponseMessage queryOrderPayInfo(RequestMessage requestMessageObj) throws Exception;
    
    /**
     * 保险责任切换接口
     * <p>User: MASK
     * <p>Date: 2017年3月14日
     * <p>Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    public ResponseMessage liabilitySwitch(RequestMessage requestMessageObj) throws Exception;
    
    /**
     * 取保单号
     * @param prefix 8A
     * @param channelCode 渠道编码 201
     * @param riskCode 险种代码
     * @return
     */
    public String createPolicyNo(String prefix, String channelCode, String riskCode);
    
    /**
     * 保单查询（根据被保人证件号和userID,三官专用）
     * <p>User: MP1145TP
     * <p>Date: 2017年6月3日
     * <p>Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
	public ResponseMessage queryPolicyListForW(RequestMessage requestMessageObj) throws Exception ;
	
	/**
	 * 查询保单的批单信息接口
	 * <p>User: lshuang
	 * <p>Date: 2017-11-30
	 * <p>Version: 1.0
	 * @param requestMessageObj
	 * @return
	 * @throws Exception
	 */
	public ResponseMessage queryPolicyEndorInfo(RequestMessage requestMessageObj) throws Exception ;
	
	/**
     * 5.2.36 查询产品保单列表信息
     * <p>User: lpengfei
     * <p>Date: 2017年12月16日
     * <p>Version: 1.0
     */
    public ResponseMessage queryProdToPolicyList(RequestMessage requestMessageObj) throws Exception ;
    
    /** delete by hguoqing 2018/3/27 for order回调接口统一处理 begin **/
    /**
     * 退保数据回调至FTP
     * <p>User: lshuang
     * <p>Date: 2017-12-29
     * <p>Version: 1.0
     * @param policyNo
     * @return
     */
/*    public void callBackFtpSurrenderStatus(ShopOrderDto shopOrderDto, String policyNo)throws Exception ;*/
    /** delete by hguoqing 2018/3/27 for order回调接口统一处理 end **/
    
    /**
     * 
     * <p>User: hguoqing
     * <p>Date: 2018年3月26日
     * <p>Version: 1.0
     * @param shopOrderDto
     * @param policyNo
     * @throws Exception
     */
    public void orderCallbackDysubData(ShopOrderDto shopOrderDto, String policyNo, String requestType) throws Exception;
    
    /**
     * 销售方案、产品代码、险种代码获取销售方案对应险种信息
     * 
     * @param agrtCode
     * @return
     * @throws Exception 
     */
    public PdmsResponseMessage getPdmsSolutionProd(String agrtCode, String projectCode, String riskCode) throws Exception;
    
   /**
    * 核保回调（核心调用）
    * @param requestMessageObj
    * @return
    * @throws Exception
    */
    public ResponseMessage underwriterCallBack(RequestMessage requestMessageObj) throws Exception;
    
    /**
     * 人工审核
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    public ResponseMessage manuallyAuditing(RequestMessage requestMessageObj) throws Exception;
}
