package com.yaic.app.order.enums;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
 * <p>
 * User: Admin
 * <p>
 * Date: 2018年3月20日
 * <p>
 * Version: 1.0
 */
public enum OrderServiceInterfaceEnum implements InterfaceEnumerable
{
	/**
	 * 5.2.1 创建订单
	 */
	CREATE_ORDER("CreateOrder", "createOrder"),
	/**
	 * 5.2.2 查询订单详细信息
	 */
	QUERY_ORDER_DETAIL_INFO("QueryOrderDetailInfo", "queryOrderDetailInfo"),
	/**
	 * 5.2.3 订单转投保
	 */
	ORDER_TO_PROPOSAL("OrderToProposal", "orderToProposal"),
	/**
	 * 5.2.4 回写订单信息
	 */
	CALL_BACK_ORDER_INFO("CallBackOrderInfo", "callBackOrderInfo"),
	/**
	 * 5.2.5 更新支付状态
	 */
	UPDATE_ORDER_PAY_STATUS("UpdateOrderPayStatus", "updateOrderPayStatus"),
	/**
	 * 5.2.6 更新资金返回支付信息
	 */
	UPDATE_ORDER_PAY_INFO("UpdateOrderPayInfo", "updateOrderPayInfo"),
	/**
	 * 5.2.7 查询订单列表
	 */
	QUERY_ORDER_LIST("QueryOrderList", "queryOrderList"),
	/**
	 * 5.2.8 查询订单数量
	 */
	QUERY_ORDER_COUNT("QueryOrderCount", "queryOrderCount"),
	/**
	 * 5.2.9 支付后订单处理
	 */
	DEAL_ORDER_AFTER_PAY("DealOrderAfterPay", "dealOrderAfterPay"),
	/**
	 * 5.2.10 全单批退
	 */
	CANCEL_INSURANCE("CancelInsurance", "cancelInsurance"),
	/**
	 * 5.2.11 更新订单状态
	 */
	UPDATE_ORDER_STATUS("UpdateOrderStatus", "updateOrderStatus"),
	/**
	 * 5.2.12 全单批退回写
	 */
	CANCEL_INSURANCE_CALL_BACK("CancelInsuranceCallBack", "cancelInsuranceCallBack"),
	/**
	 * 5.2.13 查询保单列表
	 */
	QUERY_POLICY_LIST("QueryPolicyList", "queryPolicyList"),
	/**
	 * 5.2.14 查询保单详情
	 */
	QUERY_POLICY_DETAIL_INFO("QueryPolicyDetailInfo", "queryPolicyDetailInfo"),
	/**
	 * 5.2.15 通过订单号查询用户ID
	 */
	QUERY_USER_ID_BY_ORDER_CODE("QueryUserIdByOrderCode", "queryUserIdByOrderCode"),
	/**
	 * 5.2.18 查询订单支付情况
	 */
	QUERY_ORDER_PAY_STATUS("QueryOrderPayStatus", "queryOrderPayStatus"),
	/**
	 * 5.2.19 订单转保单
	 */
	ORDER_TO_POLICY("OrderToPolicy", "orderToPolicy"),
	/**
	 * 5.2.20 获取支付交易流水号接口
	 */
	GET_BUSINESS_NO("GetBusinessNo", "getBusinessNo"),
	/**
	 * 5.2.21 流水号转保单接口
	 */
	TRAND_NO_TO_PAY("TrandNoToPay", "trandNoToPay"),
	/**
	 * 5.2.23 重复投保查询接口
	 */
	QUERY_ORDER_REPEATED("QueryOrderRepeated", "queryOrderRepeated"),
	/**
	 * 5.2.24 查询承保信息
	 */
	PROPALL_QUERY("PropallQuery", "queryCustomerAndOrderInfo"),
	/**
	 * 5.2.25 查询家财险投保数
	 */
	QUERY_PROPERTY_POLICY_COUNT("QueryPropertyPolicyCount", "queryPropertyPolicyCount"),
	/**
	 * 5.2.26 订单转保单并存储参数
	 */
	ORDER_TO_POLICY_UPDATE_DATA("OrderToPolicyUpdateData", "orderToPolicyUpdateData"),
	/**
	 * 5.2.27 批改
	 */
	ENDOR_FOR_Z("EndorForZ", "endorForZ"),
	/**
	 * 5.2.28 激活卡查询验真接口
	 */
	QUERY_ACTIVATION_CARD_INFO("QueryActivationCardInfo", "queryActivationCardInfo"),
	/**
	 * 5.2.29 激活卡 激活/核销
	 */
	ACTIVATION_CARD_LOGOUT("ActivationCardLogout", "activationCardLogout"),
	/**
	 * 5.2.30 查询订单支付信息
	 */
	QUERY_ORDER_PAYINFO("QueryOrderPayInfo", "queryOrderPayInfo"),
	/**
	 * 5.2.31 第三方在线批改
	 */
	ENDOR_FOR_OUTER("EndorForOuter", "endorForOuter"),
	/**
	 * 保险责任切换接口
	 */
	LIABILITY_SWITCH("LiabilitySwitch", "liabilitySwitch"),
	/**
	 * 保单查询（根据被保人证件号和userID,三官专用）
	 */
	QUERY_POLICY_LIST_FOR_W("QueryPolicyListForW", "queryPolicyListForW"),
	/**
	 * 查询保单的批单信息接口
	 */
	QUERY_POLICY_ENDOR_INFO("QueryPolicyEndorInfo", "queryPolicyEndorInfo"),
	/**
	 * 5.2.36 查询产品保单列表信息
	 */
	QUERY_PROD_TO_POLICY_LIST("QueryProdToPolicyList", "queryProdToPolicyList"),
	/**
	 * 核保回调（核心调用）
	 */
	AUDITING_INSURANCE_CALL_BACK("UnderwriterCallBack", "underwriterCallBack"),
	/**
	 * 人工审核
	 */
	MANUALLY_AUDITING("ManuallyAuditing", "manuallyAuditing");
	
	private String interfaceCode;
	private String methodName;

	public static Map<String, OrderServiceInterfaceEnum> cache;
	static
	{
		final OrderServiceInterfaceEnum[] enums = OrderServiceInterfaceEnum.values();
		final Map<String, OrderServiceInterfaceEnum> map = new HashMap<>(enums.length);
		for (final OrderServiceInterfaceEnum e : enums)
		{
			map.put(e.interfaceCode, e);
		}
		cache = Collections.unmodifiableMap(map);
	}

	/**
	 * @param interfaceCode
	 * @param methodName
	 */
	private OrderServiceInterfaceEnum(final String interfaceCode, final String methodName)
	{
		this.interfaceCode = interfaceCode;
		this.methodName = methodName;
	}

	/**
	 * @return the interfaceCode
	 */
	@Override
	public String interfaceCode()
	{
		return interfaceCode;
	}

	/**
	 * @return the methodName
	 */
	@Override
	public String methodName()
	{
		return methodName;
	}

	/**
	 * @param interfaceCode
	 * @return the InterfaceCodeEnum
	 */
	public static OrderServiceInterfaceEnum fromCode(final String interfaceCode)
	{
		return cache.get(interfaceCode);
	}
}
