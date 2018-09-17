package com.yaic.app.order.dto.msg.common;

import java.util.List;

import com.yaic.app.order.dto.domain.OrderDynamicItemDto;
import com.yaic.app.order.dto.msg.UnderwriterCallBackReq;
import com.yaic.app.order.dto.msg.CallBackOrderInfoReq;
import com.yaic.app.order.dto.msg.CallBackThirdPayReq;
import com.yaic.app.order.dto.msg.CancelInsuranceCallBackReq;
import com.yaic.app.order.dto.msg.CancelInsuranceReq;
import com.yaic.app.order.dto.msg.CreateOrderReq;
import com.yaic.app.order.dto.msg.DealOrderAfterPayReq;
import com.yaic.app.order.dto.msg.EndorReq;
import com.yaic.app.order.dto.msg.GetWxSignReq;
import com.yaic.app.order.dto.msg.InitOrderPayReq;
import com.yaic.app.order.dto.msg.LiabilitySwitchReq;
import com.yaic.app.order.dto.msg.ManuallyAuditingReq;
import com.yaic.app.order.dto.msg.NcmGetTrandNoReq;
import com.yaic.app.order.dto.msg.NcmTrandNoToPayReq;
import com.yaic.app.order.dto.msg.OrderActivationCardLogoutReq;
import com.yaic.app.order.dto.msg.OrderToPolicyReq;
import com.yaic.app.order.dto.msg.OrderToPolicyUpdateDataReq;
import com.yaic.app.order.dto.msg.OrderToProposalReq;
import com.yaic.app.order.dto.msg.PeopleReq;
import com.yaic.app.order.dto.msg.QueryActivationCardInfoReq;
import com.yaic.app.order.dto.msg.QueryOrderCountReq;
import com.yaic.app.order.dto.msg.QueryOrderDetailInfoReq;
import com.yaic.app.order.dto.msg.QueryOrderListReq;
import com.yaic.app.order.dto.msg.QueryOrderPayInfoReq;
import com.yaic.app.order.dto.msg.QueryOrderPayStatusReq;
import com.yaic.app.order.dto.msg.QueryPolicyDetailInfoReq;
import com.yaic.app.order.dto.msg.QueryPolicyEndorInfoReq;
import com.yaic.app.order.dto.msg.QueryPolicyListReq;
import com.yaic.app.order.dto.msg.QueryProdToPolicyListReq;
import com.yaic.app.order.dto.msg.QueryPropallReq;
import com.yaic.app.order.dto.msg.QueryPropertyCountReq;
import com.yaic.app.order.dto.msg.QueryUserIdByOrderCodeReq;
import com.yaic.app.order.dto.msg.SurrenderCallBackReq;
import com.yaic.app.order.dto.msg.UpdateOrderPayInfoReq;
import com.yaic.app.order.dto.msg.UpdateOrderPayStatusReq;
import com.yaic.app.order.dto.msg.UpdateOrderStatusReq;

/**
 * 请求Body部分
 * <p>User: lujicong
 * <p>Date: 2015-12-10
 * <p>Version: 1.0
 */
public class ReqBodyData {

	/** 创建订单 **/
	private CreateOrderReq createOrderReq;
	
	/** 查询订单详细信息 **/
	private QueryOrderDetailInfoReq queryOrderDetailInfoReq;
	
	/** 订单转投保 **/
	private OrderToProposalReq orderToProposalReq;
	
	/** 回写订单信息 **/
	private CallBackOrderInfoReq callBackOrderInfoReq;
	
	/** 更新支付状态 **/
	private UpdateOrderPayStatusReq updateOrderPayStatusReq;
	
	/** 更新支付信息 **/
	private UpdateOrderPayInfoReq updateOrderPayInfoReq;
	
	/** 查询订单列表 **/
	private QueryOrderListReq queryOrderListReq;
	
	/** 查询订单数量 **/
	private QueryOrderCountReq queryOrderCountReq;
	
	/** 支付后订单处理 **/
	private DealOrderAfterPayReq dealOrderAfterPayReq;
	
	/** 全单批退 **/
	private CancelInsuranceReq cancelInsuranceReq;
	
	/** 更新订单状态 **/
	private UpdateOrderStatusReq updateOrderStatusReq;
	
	/** 全单批退回写  **/
	private CancelInsuranceCallBackReq cancelInsuranceCallBackReq;
	
	/** 批改 **/
	private EndorReq endorReq;
	
	/** 查询保单列表  **/
	private QueryPolicyListReq queryPolicyListReq;
	
	/** 查询保单详情  **/
	private QueryPolicyDetailInfoReq queryPolicyDetailInfoReq;
	
	/** 通过订单号查询用户ID **/
	private QueryUserIdByOrderCodeReq queryUserIdByOrderCodeReq;
	
	/** 第三方支付回调 **/
	private CallBackThirdPayReq callBackThirdPayReq;
	
	/** 发起订单支付 **/
	private InitOrderPayReq initOrderPayReq;
	
	/** 查询订单支付情况 **/
	private QueryOrderPayStatusReq queryOrderPayStatusReq;
	
	/** 订单转保单 **/
	private OrderToPolicyReq orderToPolicyReq;
	
	/** 获取交易流水号列表  */
	private List<NcmGetTrandNoReq> getTrandNoList;
	
	/** 到账确认  */
	private NcmTrandNoToPayReq trandNoToPayReq;
	
	/** 获取微信签名  **/
	private GetWxSignReq getWxSignReq;
	
	/**常用投保人*/
	private PeopleReq peopleReq;
	
	/**重复投保查询接口*/
	private OrderDynamicItemDto queryOrderRepeatedReq;
	
	/** 查询是否投保 **/
	private QueryPropallReq queryPropallReq;
	
	/** 查询家财险投保数 **/
	private QueryPropertyCountReq queryPropertyCountReq;
	
	/** 订单转保单并存储参数 **/
	private OrderToPolicyUpdateDataReq orderToPolicyUpdateDataReq;
	
	/** 激活卡查询验真接口 **/
	private QueryActivationCardInfoReq queryActivationCardInfoReq;
	
	/** 激活卡 激活/核销 **/
	private OrderActivationCardLogoutReq activationCardLogoutReq;
	
	/** 查询订单支付信息 **/
	private QueryOrderPayInfoReq queryOrderPayInfoReq;
	
	/** 佰盈-随心“易”灵活交通意外险-责任切换接口 **/
	private LiabilitySwitchReq liabilitySwitchReq;
	
	/** 退保回调接口 **/
	private SurrenderCallBackReq surrenderCallBackReq;
	
	/** 查询保单的批单信息接口 **/
	private QueryPolicyEndorInfoReq queryPolicyEndorInfoReq;
	
	/** 查询产品保单的列表信息 **/
	private QueryProdToPolicyListReq queryProdToPolicyListReq;
	
	/** 核保回调*/
	private UnderwriterCallBackReq underwriterCallBackReq;
	
	/** 人工审核 **/
	private ManuallyAuditingReq manuallyAuditingReq;
	
	public PeopleReq getPeopleReq() {
		return peopleReq;
	}
	
	public void setPeopleReq(PeopleReq peopleReq) {
		this.peopleReq = peopleReq;
	}
	
	public CreateOrderReq getCreateOrderReq() {
	    return createOrderReq;
	}
	
	public void setCreateOrderReq(CreateOrderReq createOrderReq) {
	    this.createOrderReq = createOrderReq;
	}
	
	public QueryOrderDetailInfoReq getQueryOrderDetailInfoReq() {
	    return queryOrderDetailInfoReq;
	}
	
	public void setQueryOrderDetailInfoReq(QueryOrderDetailInfoReq queryOrderDetailInfoReq) {
	    this.queryOrderDetailInfoReq = queryOrderDetailInfoReq;
	}
	
	public OrderToProposalReq getOrderToProposalReq() {
	    return orderToProposalReq;
	}
	
	public void setOrderToProposalReq(OrderToProposalReq orderToProposalReq) {
	    this.orderToProposalReq = orderToProposalReq;
	}
	
	public CallBackOrderInfoReq getCallBackOrderInfoReq() {
	    return callBackOrderInfoReq;
	}
	
	public void setCallBackOrderInfoReq(CallBackOrderInfoReq callBackOrderInfoReq) {
	    this.callBackOrderInfoReq = callBackOrderInfoReq;
	}
	
	public UpdateOrderPayStatusReq getUpdateOrderPayStatusReq() {
	    return updateOrderPayStatusReq;
	}
	
	public void setUpdateOrderPayStatusReq(UpdateOrderPayStatusReq updateOrderPayStatusReq) {
	    this.updateOrderPayStatusReq = updateOrderPayStatusReq;
	}
	
	public UpdateOrderPayInfoReq getUpdateOrderPayInfoReq() {
	    return updateOrderPayInfoReq;
	}
	
	public void setUpdateOrderPayInfoReq(UpdateOrderPayInfoReq updateOrderPayInfoReq) {
	    this.updateOrderPayInfoReq = updateOrderPayInfoReq;
	}
	
	public QueryOrderListReq getQueryOrderListReq() {
	    return queryOrderListReq;
	}
	
	public void setQueryOrderListReq(QueryOrderListReq queryOrderListReq) {
	    this.queryOrderListReq = queryOrderListReq;
	}
	
	public QueryOrderCountReq getQueryOrderCountReq() {
	    return queryOrderCountReq;
	}
	
	public void setQueryOrderCountReq(QueryOrderCountReq queryOrderCountReq) {
	    this.queryOrderCountReq = queryOrderCountReq;
	}
	
	public DealOrderAfterPayReq getDealOrderAfterPayReq() {
	    return dealOrderAfterPayReq;
	}
	
	public void setDealOrderAfterPayReq(DealOrderAfterPayReq dealOrderAfterPayReq) {
	    this.dealOrderAfterPayReq = dealOrderAfterPayReq;
	}
	
	public CancelInsuranceReq getCancelInsuranceReq() {
	    return cancelInsuranceReq;
	}
	
	public void setCancelInsuranceReq(CancelInsuranceReq cancelInsuranceReq) {
	    this.cancelInsuranceReq = cancelInsuranceReq;
	}
	
	public EndorReq getEndorReq() {
		return endorReq;
	}
	
	public void setEndorReq(EndorReq endorReq) {
		this.endorReq = endorReq;
	}
	
	public UpdateOrderStatusReq getUpdateOrderStatusReq() {
	    return updateOrderStatusReq;
	}
	
	public void setUpdateOrderStatusReq(UpdateOrderStatusReq updateOrderStatusReq) {
	    this.updateOrderStatusReq = updateOrderStatusReq;
	}
	
	public CancelInsuranceCallBackReq getCancelInsuranceCallBackReq() {
	    return cancelInsuranceCallBackReq;
	}
	
	public void setCancelInsuranceCallBackReq(CancelInsuranceCallBackReq cancelInsuranceCallBackReq) {
	    this.cancelInsuranceCallBackReq = cancelInsuranceCallBackReq;
	}
	
	public QueryPolicyListReq getQueryPolicyListReq() {
	    return queryPolicyListReq;
	}
	
	public void setQueryPolicyListReq(QueryPolicyListReq queryPolicyListReq) {
	    this.queryPolicyListReq = queryPolicyListReq;
	}
	
	public QueryPolicyDetailInfoReq getQueryPolicyDetailInfoReq() {
	    return queryPolicyDetailInfoReq;
	}
	
	public void setQueryPolicyDetailInfoReq(QueryPolicyDetailInfoReq queryPolicyDetailInfoReq) {
	    this.queryPolicyDetailInfoReq = queryPolicyDetailInfoReq;
	}
	
	public QueryUserIdByOrderCodeReq getQueryUserIdByOrderCodeReq() {
	    return queryUserIdByOrderCodeReq;
	}
	
	public void setQueryUserIdByOrderCodeReq(QueryUserIdByOrderCodeReq queryUserIdByOrderCodeReq) {
	    this.queryUserIdByOrderCodeReq = queryUserIdByOrderCodeReq;
	}
	
	public CallBackThirdPayReq getCallBackThirdPayReq() {
	    return callBackThirdPayReq;
	}
	
	public void setCallBackThirdPayReq(CallBackThirdPayReq callBackThirdPayReq) {
	    this.callBackThirdPayReq = callBackThirdPayReq;
	}
	
	public InitOrderPayReq getInitOrderPayReq() {
	    return initOrderPayReq;
	}
	
	public void setInitOrderPayReq(InitOrderPayReq initOrderPayReq) {
	    this.initOrderPayReq = initOrderPayReq;
	}
	
	public QueryOrderPayStatusReq getQueryOrderPayStatusReq() {
	    return queryOrderPayStatusReq;
	}
	
	public void setQueryOrderPayStatusReq(QueryOrderPayStatusReq queryOrderPayStatusReq) {
	    this.queryOrderPayStatusReq = queryOrderPayStatusReq;
	}
	
	public OrderToPolicyReq getOrderToPolicyReq() {
	    return orderToPolicyReq;
	}
	
	public void setOrderToPolicyReq(OrderToPolicyReq orderToPolicyReq) {
	    this.orderToPolicyReq = orderToPolicyReq;
	}
	
	/** 获取交易流水号列表  */	
	public List<NcmGetTrandNoReq> getGetTrandNoList() {
		return getTrandNoList;
	}
	/** 获取交易流水号列表  */
	public void setGetTrandNoList(List<NcmGetTrandNoReq> getTrandNoList) {
		this.getTrandNoList = getTrandNoList;
	}
	
	/** 到账确认  */
	public NcmTrandNoToPayReq getTrandNoToPayReq() {
		return trandNoToPayReq;
	}
	
	/** 到账确认  */
	public void setTrandNoToPayReq(NcmTrandNoToPayReq trandNoToPayReq) {
		this.trandNoToPayReq = trandNoToPayReq;
	}
	
	public GetWxSignReq getGetWxSignReq() {
	    return getWxSignReq;
	}
	
	public void setGetWxSignReq(GetWxSignReq getWxSignReq) {
	    this.getWxSignReq = getWxSignReq;
	}
	
	/**重复投保查询接口*/
	public OrderDynamicItemDto getQueryOrderRepeatedReq() {
		return queryOrderRepeatedReq;
	}
	
	/**重复投保查询接口*/
	public void setQueryOrderRepeatedReq(OrderDynamicItemDto queryOrderRepeatedReq) {
		this.queryOrderRepeatedReq = queryOrderRepeatedReq;
	}
	
	/** 查询是否投保 **/
	public QueryPropallReq getQueryPropallReq() {
		return queryPropallReq;
	}
	
	/** 查询是否投保 **/
	public void setQueryPropallReq(QueryPropallReq queryPropallReq) {
		this.queryPropallReq = queryPropallReq;
	}
	
	public QueryPropertyCountReq getQueryPropertyCountReq() {
	    return queryPropertyCountReq;
	}
	
	public void setQueryPropertyCountReq(QueryPropertyCountReq queryPropertyCountReq) {
	    this.queryPropertyCountReq = queryPropertyCountReq;
	}
	
	/** 订单转保单并存储参数 **/
	public OrderToPolicyUpdateDataReq getOrderToPolicyUpdateDataReq() {
		return orderToPolicyUpdateDataReq;
	}
	
	/** 订单转保单并存储参数 **/
	public void setOrderToPolicyUpdateDataReq(OrderToPolicyUpdateDataReq orderToPolicyUpdateDataReq) {
		this.orderToPolicyUpdateDataReq = orderToPolicyUpdateDataReq;
	}
	
	/** 激活卡查询验真接口 **/
	public QueryActivationCardInfoReq getQueryActivationCardInfoReq() {
	    return queryActivationCardInfoReq;
	}
	
	/** 激活卡查询验真接口 **/
	public void setQueryActivationCardInfoReq(QueryActivationCardInfoReq queryActivationCardInfoReq) {
	    this.queryActivationCardInfoReq = queryActivationCardInfoReq;
	}
	
	/** 激活卡 激活/核销 **/
	public OrderActivationCardLogoutReq getActivationCardLogoutReq() {
	    return activationCardLogoutReq;
	}
	
	/** 激活卡 激活/核销 **/
	public void setActivationCardLogoutReq(OrderActivationCardLogoutReq activationCardLogoutReq) {
	    this.activationCardLogoutReq = activationCardLogoutReq;
	}
	
	/** 查询订单支付信息 **/
	public QueryOrderPayInfoReq getQueryOrderPayInfoReq() {
		return queryOrderPayInfoReq;
	}
	
	/** 查询订单支付信息 **/
	public void setQueryOrderPayInfoReq(QueryOrderPayInfoReq queryOrderPayInfoReq) {
		this.queryOrderPayInfoReq = queryOrderPayInfoReq;
	}
	
	public LiabilitySwitchReq getLiabilitySwitchReq() {
		return liabilitySwitchReq;
	}
	
	public void setLiabilitySwitchReq(
			LiabilitySwitchReq liabilitySwitchReq) {
		this.liabilitySwitchReq = liabilitySwitchReq;
	}
	
	public SurrenderCallBackReq getSurrenderCallBackReq() {
		return surrenderCallBackReq;
	}
	
	public void setSurrenderCallBackReq(SurrenderCallBackReq surrenderCallBackReq) {
		this.surrenderCallBackReq = surrenderCallBackReq;
	}
	
	/** 查询保单的批单信息接口 **/
	public QueryPolicyEndorInfoReq getQueryPolicyEndorInfoReq() {
		return queryPolicyEndorInfoReq;
	}
	
	/** 查询保单的批单信息接口 **/
	public void setQueryPolicyEndorInfoReq(
			QueryPolicyEndorInfoReq queryPolicyEndorInfoReq) {
		this.queryPolicyEndorInfoReq = queryPolicyEndorInfoReq;
	}
	
	/** 查询产品保单的列表信息 **/
	public QueryProdToPolicyListReq getQueryProdToPolicyListReq() {
		return queryProdToPolicyListReq;
	}
	
	/** 查询产品保单的列表信息 **/
	public void setQueryProdToPolicyListReq(QueryProdToPolicyListReq queryProdToPolicyListReq) {
		this.queryProdToPolicyListReq = queryProdToPolicyListReq;
	}
	
	/** 核保回调*/
	public UnderwriterCallBackReq getUnderwriterCallBackReq() {
		return underwriterCallBackReq;
	}
	
	/** 核保回调*/
	public void setUnderwriterCallBackReq(UnderwriterCallBackReq underwriterCallBackReq) {
		this.underwriterCallBackReq = underwriterCallBackReq;
	}

	/** 人工审核 **/
	public ManuallyAuditingReq getManuallyAuditingReq() {
		return manuallyAuditingReq;
	}

	/** 人工审核 **/
	public void setManuallyAuditingReq(ManuallyAuditingReq manuallyAuditingReq) {
		this.manuallyAuditingReq = manuallyAuditingReq;
	}
	
}
