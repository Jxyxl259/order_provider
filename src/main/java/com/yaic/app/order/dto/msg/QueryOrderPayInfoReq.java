package com.yaic.app.order.dto.msg;

public class QueryOrderPayInfoReq {
	/** 保单号 **/
	private String policyNo;

	/** 订单号 **/
	private String orderCode;

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

}
