package com.yaic.app.order.dto.msg;

/**
 * 华道征信系统请求报文
 * <p>Date: 2016-4-25
 * <p>Version: 1.0
 */
public class NcmTrandNoToPayResp {
	
	/** 订单号 **/
    private String orderCode;
    
	/**订单状态 0-初始状态，1-转投保成功，2-转投保失败，3-转保单成功，4-转保单失败 **/
    private String orderStatus;
    
    /** 交易流水号 **/
    private String trandNo;
    
    /** 保单号 **/
    private String policyNo;

    /** 订单号 **/
	public String getOrderCode() {
		return orderCode;
	}

	/** 订单号 **/
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	/**订单状态 0-初始状态，1-转投保成功，2-转投保失败，3-转保单成功，4-转保单失败 **/
	public String getOrderStatus() {
		return orderStatus;
	}

	/**订单状态 0-初始状态，1-转投保成功，2-转投保失败，3-转保单成功，4-转保单失败 **/
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	/** 交易流水号 **/
	public String getTrandNo() {
		return trandNo;
	}

	/** 交易流水号 **/
	public void setTrandNo(String trandNo) {
		this.trandNo = trandNo;
	}

	/** 保单号 **/
	public String getPolicyNo() {
		return policyNo;
	}

	/** 保单号 **/
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
    
}
