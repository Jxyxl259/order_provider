package com.yaic.app.order.dto.msg.common;

import java.util.List;

import com.yaic.app.order.dto.msg.CallBackOrderInfoResp;
import com.yaic.app.order.dto.msg.CallBackThirdPayResp;
import com.yaic.app.order.dto.msg.CancelInsuranceCallBackResp;
import com.yaic.app.order.dto.msg.CancelInsuranceResp;
import com.yaic.app.order.dto.msg.CreateOrderResp;
import com.yaic.app.order.dto.msg.DealOrderAfterPayResp;
import com.yaic.app.order.dto.msg.EndorResp;
import com.yaic.app.order.dto.msg.GetWxSignResp;
import com.yaic.app.order.dto.msg.InitOrderPayResp;
import com.yaic.app.order.dto.msg.LiabilitySwitchResp;
import com.yaic.app.order.dto.msg.NcmGetTrandNoResp;
import com.yaic.app.order.dto.msg.NcmTrandNoToPayResp;
import com.yaic.app.order.dto.msg.OrderActivationCardLogoutResp;
import com.yaic.app.order.dto.msg.OrderToPolicyResp;
import com.yaic.app.order.dto.msg.OrderToProposalResp;
import com.yaic.app.order.dto.msg.QueryActivationCardInfoResp;
import com.yaic.app.order.dto.msg.QueryOrderCountResp;
import com.yaic.app.order.dto.msg.QueryOrderDetailInfoResp;
import com.yaic.app.order.dto.msg.QueryOrderListResp;
import com.yaic.app.order.dto.msg.QueryOrderPayInfoResp;
import com.yaic.app.order.dto.msg.QueryOrderPayStatusResp;
import com.yaic.app.order.dto.msg.QueryOrderRepeatedResp;
import com.yaic.app.order.dto.msg.QueryPolicyDetailInfoResp;
import com.yaic.app.order.dto.msg.QueryPolicyEndorInfoResp;
import com.yaic.app.order.dto.msg.QueryPolicyListResp;
import com.yaic.app.order.dto.msg.QueryProdToPolicyListResp;
import com.yaic.app.order.dto.msg.QueryPropertyCountResp;
import com.yaic.app.order.dto.msg.QueryUserIdByOrderCodeResp;
import com.yaic.app.order.dto.msg.UpdateOrderPayInfoResp;
import com.yaic.app.order.dto.msg.UpdateOrderPayStatusResp;
import com.yaic.app.order.dto.msg.UpdateOrderStatusResp;

/**
 * 请求Body部分
 * <p>
 * User: lujicong
 * <p>
 * Date: 2015-12-23
 * <p>
 * Version: 1.0
 */
public class RespBodyData {

	/** 创建订单 **/
	private CreateOrderResp createOrderResp;
	
	/** 查询订单详细信息 **/
	private QueryOrderDetailInfoResp queryOrderDetailInfoResp;
	
	/** 订单转投保 **/
	private OrderToProposalResp orderToProposalResp;
	
	/** 回写订单信息 **/
	private CallBackOrderInfoResp backOrderInfoResp;
	
	/** 更新支付状态 **/
	private UpdateOrderPayStatusResp updateOrderPayStatusResp;
	
	/** 更新支付信息 **/
	private UpdateOrderPayInfoResp updateOrderPayInfoResp;
	
	/** 查询订单列表 **/
	private QueryOrderListResp queryOrderListResp;
	
	/** 查询订单数量 **/
	private QueryOrderCountResp queryOrderCountResp;
	
	/** 支付后订单处理 **/
	private DealOrderAfterPayResp dealOrderAfterPayResp;
	
	/** 全单批退 **/
	private CancelInsuranceResp cancelInsuranceResp;
	
	/** 更新订单状态 **/
	private UpdateOrderStatusResp updateOrderStatusResp;
	
	/** 全单批退 **/
	private CancelInsuranceCallBackResp cancelInsuranceCallBackResp;
	
	/** 查询保单列表 **/
	private QueryPolicyListResp queryPolicyListResp;
	
	/** 查询保单详情 **/
	private QueryPolicyDetailInfoResp queryPolicyDetailInfoResp;
	
	/** 通过订单号查询用户ID **/
	private QueryUserIdByOrderCodeResp queryUserIdByOrderCodeResp;
	
	/** 第三方支付回调 **/
	private CallBackThirdPayResp callBackThirdPayResp;
	
	/** 发起订单支付 **/
	private InitOrderPayResp initOrderPayResp;
	
	/** 查询订单支付情况 **/
	private QueryOrderPayStatusResp queryOrderPayStatusResp;
	
	/** 订单转保单 **/
	private OrderToPolicyResp orderToPolicyResp;
	
	/** 获取交易流水号 **/
	private NcmGetTrandNoResp getTrandNoResp;
	
	/** 到账确认  */
	private List<NcmTrandNoToPayResp> trandNoToPayRespList;
	
	/** 获取微信签名  **/
	private GetWxSignResp getWxSignResp;
	
	/** 重复投保查询结果  **/
	private QueryOrderRepeatedResp queryOrderRepeatedResp;
	
	/** 查询是否投保并返回投保信息  **/
	private List<QueryOrderDetailInfoResp> 	queryOrderDetailInfoRespList;
	
	/** 查询家财险投保数 **/
	private QueryPropertyCountResp queryPropertyCountResp;
	
	/** 批改 **/
	private EndorResp endorResp;
	
	/** 调单证系统查询校验激活卡信息 **/
	private QueryActivationCardInfoResp queryActivationCardInfoResp;
	
	/** 激活卡 激活/核销  */
	private OrderActivationCardLogoutResp activationCardLogoutResp;
	
	/** 查询订单支付信息 **/
	private QueryOrderPayInfoResp queryOrderPayInfoResp;
	
	/** 保险责任切换接口 **/
	private LiabilitySwitchResp liabilitySwitchResp;
	
	/** 查询保单的批单信息接口 **/
	private QueryPolicyEndorInfoResp queryPolicyEndorInfoResp;
	
	/** 查询产品保单列表信息接口 **/
	private QueryProdToPolicyListResp queryProdToPolicyListResp;
	
	
	public CreateOrderResp getCreateOrderResp() {
	    return createOrderResp;
	}
	
	public void setCreateOrderResp(CreateOrderResp createOrderResp) {
	    this.createOrderResp = createOrderResp;
	}
	
	public QueryOrderDetailInfoResp getQueryOrderDetailInfoResp() {
	    return queryOrderDetailInfoResp;
	}
	
	public void setQueryOrderDetailInfoResp(QueryOrderDetailInfoResp queryOrderDetailInfoResp) {
	    this.queryOrderDetailInfoResp = queryOrderDetailInfoResp;
	}
	
	public OrderToProposalResp getOrderToProposalResp() {
	    return orderToProposalResp;
	}
	
	public void setOrderToProposalResp(OrderToProposalResp orderToProposalResp) {
	    this.orderToProposalResp = orderToProposalResp;
	}
	
	public CallBackOrderInfoResp getBackOrderInfoResp() {
	    return backOrderInfoResp;
	}
	
	public void setBackOrderInfoResp(CallBackOrderInfoResp backOrderInfoResp) {
	    this.backOrderInfoResp = backOrderInfoResp;
	}
	
	public UpdateOrderPayStatusResp getUpdateOrderPayStatusResp() {
	    return updateOrderPayStatusResp;
	}
	
	public void setUpdateOrderPayStatusResp(UpdateOrderPayStatusResp updateOrderPayStatusResp) {
	    this.updateOrderPayStatusResp = updateOrderPayStatusResp;
	}
	
	public UpdateOrderPayInfoResp getUpdateOrderPayInfoResp() {
	    return updateOrderPayInfoResp;
	}
	
	public void setUpdateOrderPayInfoResp(UpdateOrderPayInfoResp updateOrderPayInfoResp) {
	    this.updateOrderPayInfoResp = updateOrderPayInfoResp;
	}
	
	public QueryOrderListResp getQueryOrderListResp() {
	    return queryOrderListResp;
	}
	
	public void setQueryOrderListResp(QueryOrderListResp queryOrderListResp) {
	    this.queryOrderListResp = queryOrderListResp;
	}
	
	public QueryOrderCountResp getQueryOrderCountResp() {
	    return queryOrderCountResp;
	}
	
	public void setQueryOrderCountResp(QueryOrderCountResp queryOrderCountResp) {
	    this.queryOrderCountResp = queryOrderCountResp;
	}
	
	public DealOrderAfterPayResp getDealOrderAfterPayResp() {
	    return dealOrderAfterPayResp;
	}
	
	public void setDealOrderAfterPayResp(DealOrderAfterPayResp dealOrderAfterPayResp) {
	    this.dealOrderAfterPayResp = dealOrderAfterPayResp;
	}
	
	public CancelInsuranceResp getCancelInsuranceResp() {
	    return cancelInsuranceResp;
	}
	
	public void setCancelInsuranceResp(CancelInsuranceResp cancelInsuranceResp) {
	    this.cancelInsuranceResp = cancelInsuranceResp;
	}
	
	public UpdateOrderStatusResp getUpdateOrderStatusResp() {
	    return updateOrderStatusResp;
	}
	
	public void setUpdateOrderStatusResp(UpdateOrderStatusResp updateOrderStatusResp) {
	    this.updateOrderStatusResp = updateOrderStatusResp;
	}
	
	public CancelInsuranceCallBackResp getCancelInsuranceCallBackResp() {
	    return cancelInsuranceCallBackResp;
	}
	
	public void setCancelInsuranceCallBackResp(CancelInsuranceCallBackResp cancelInsuranceCallBackResp) {
	    this.cancelInsuranceCallBackResp = cancelInsuranceCallBackResp;
	}
	
	public QueryPolicyListResp getQueryPolicyListResp() {
	    return queryPolicyListResp;
	}
	
	public void setQueryPolicyListResp(QueryPolicyListResp queryPolicyListResp) {
	    this.queryPolicyListResp = queryPolicyListResp;
	}
	
	public QueryPolicyDetailInfoResp getQueryPolicyDetailInfoResp() {
	    return queryPolicyDetailInfoResp;
	}
	
	public void setQueryPolicyDetailInfoResp(QueryPolicyDetailInfoResp queryPolicyDetailInfoResp) {
	    this.queryPolicyDetailInfoResp = queryPolicyDetailInfoResp;
	}
	
	public QueryUserIdByOrderCodeResp getQueryUserIdByOrderCodeResp() {
	    return queryUserIdByOrderCodeResp;
	}
	
	public void setQueryUserIdByOrderCodeResp(QueryUserIdByOrderCodeResp queryUserIdByOrderCodeResp) {
	    this.queryUserIdByOrderCodeResp = queryUserIdByOrderCodeResp;
	}
	
	public CallBackThirdPayResp getCallBackThirdPayResp() {
	    return callBackThirdPayResp;
	}
	
	public void setCallBackThirdPayResp(CallBackThirdPayResp callBackThirdPayResp) {
	    this.callBackThirdPayResp = callBackThirdPayResp;
	}
	
	public InitOrderPayResp getInitOrderPayResp() {
	    return initOrderPayResp;
	}
	
	public void setInitOrderPayResp(InitOrderPayResp initOrderPayResp) {
	    this.initOrderPayResp = initOrderPayResp;
	}
	
	public QueryOrderPayStatusResp getQueryOrderPayStatusResp() {
	    return queryOrderPayStatusResp;
	}
	
	public void setQueryOrderPayStatusResp(QueryOrderPayStatusResp queryOrderPayStatusResp) {
	    this.queryOrderPayStatusResp = queryOrderPayStatusResp;
	}
	
	public OrderToPolicyResp getOrderToPolicyResp() {
	    return orderToPolicyResp;
	}
	
	public void setOrderToPolicyResp(OrderToPolicyResp orderToPolicyResp) {
	    this.orderToPolicyResp = orderToPolicyResp;
	}
	
	/** 获取交易流水号 **/
	public NcmGetTrandNoResp getGetTrandNoResp() {
		return getTrandNoResp;
	}
	
	/** 获取交易流水号 **/
	public void setGetTrandNoResp(NcmGetTrandNoResp getTrandNoResp) {
		this.getTrandNoResp = getTrandNoResp;
	}
	
	/** 到账确认  */
	public List<NcmTrandNoToPayResp> getTrandNoToPayRespList() {
		return trandNoToPayRespList;
	}
	
	/** 到账确认  */
	public void setTrandNoToPayRespList(List<NcmTrandNoToPayResp> trandNoToPayRespList) {
		this.trandNoToPayRespList = trandNoToPayRespList;
	}
	
	public GetWxSignResp getGetWxSignResp() {
	    return getWxSignResp;
	}
	
	public void setGetWxSignResp(GetWxSignResp getWxSignResp) {
	    this.getWxSignResp = getWxSignResp;
	}
	
	/** 重复投保查询结果  **/
	public QueryOrderRepeatedResp getQueryOrderRepeatedResp() {
		return queryOrderRepeatedResp;
	}
	
	/** 重复投保查询结果  **/
	public void setQueryOrderRepeatedResp(QueryOrderRepeatedResp queryOrderRepeatedResp) {
		this.queryOrderRepeatedResp = queryOrderRepeatedResp;
	}
	
	/** 查询是否投保并返回投保信息  **/
	public List<QueryOrderDetailInfoResp> getQueryOrderDetailInfoRespList() {
		return queryOrderDetailInfoRespList;
	}
	
	/** 查询是否投保并返回投保信息  **/
	public void setqueryOrderDetailInfoRespList(List<QueryOrderDetailInfoResp> queryOrderDetailInfoRespList) {
		this.queryOrderDetailInfoRespList = queryOrderDetailInfoRespList;
	}
	
	public QueryPropertyCountResp getQueryPropertyCountResp() {
	    return queryPropertyCountResp;
	}
	
	public void setQueryPropertyCountResp(QueryPropertyCountResp queryPropertyCountResp) {
	    this.queryPropertyCountResp = queryPropertyCountResp;
	}
	
	public EndorResp getEndorResp() {
		return endorResp;
	}
	
	public void setEndorResp(EndorResp endorResp) {
		this.endorResp = endorResp;
	}
	
	/** 调单证系统查询校验激活卡信息 **/
	public QueryActivationCardInfoResp getQueryActivationCardInfoResp() {
		return queryActivationCardInfoResp;
	}
	
	/** 调单证系统查询校验激活卡信息 **/
	public void setQueryActivationCardInfoResp(QueryActivationCardInfoResp queryActivationCardInfoResp) {
		this.queryActivationCardInfoResp = queryActivationCardInfoResp;
	}
	
	/** 激活卡 激活/核销  */
	public OrderActivationCardLogoutResp getActivationCardLogoutResp() {
		return activationCardLogoutResp;
	}
	
	/** 激活卡 激活/核销  */
	public void setActivationCardLogoutResp(OrderActivationCardLogoutResp activationCardLogoutResp) {
		this.activationCardLogoutResp = activationCardLogoutResp;
	}
	
	/** 查询订单支付信息 **/
	public QueryOrderPayInfoResp getQueryOrderPayInfoResp() {
		return queryOrderPayInfoResp;
	}
	
	/** 查询订单支付信息 **/
	public void setQueryOrderPayInfoResp(QueryOrderPayInfoResp queryOrderPayInfoResp) {
		this.queryOrderPayInfoResp = queryOrderPayInfoResp;
	}
	
	public LiabilitySwitchResp getLiabilitySwitchResp() {
		return liabilitySwitchResp;
	}
	
	public void setLiabilitySwitchResp(
			LiabilitySwitchResp liabilitySwitchResp) {
		this.liabilitySwitchResp = liabilitySwitchResp;
	}
	
	/** 查询保单的批单信息接口 **/
	public QueryPolicyEndorInfoResp getQueryPolicyEndorInfoResp() {
		return queryPolicyEndorInfoResp;
	}
	
	/** 查询保单的批单信息接口 **/
	public void setQueryPolicyEndorInfoResp(QueryPolicyEndorInfoResp queryPolicyEndorInfoResp) {
		this.queryPolicyEndorInfoResp = queryPolicyEndorInfoResp;
	}
	
	/** 查询产品保单列表信息接口 **/
	public QueryProdToPolicyListResp getQueryProdToPolicyListResp() {
		return queryProdToPolicyListResp;
	}
	
	/** 查询产品保单列表信息接口 **/
	public void setQueryProdToPolicyListResp(QueryProdToPolicyListResp queryProdToPolicyListResp) {
		this.queryProdToPolicyListResp = queryProdToPolicyListResp;
	}

}
