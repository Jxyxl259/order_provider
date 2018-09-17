package com.yaic.app.order.dto.msg;

import java.util.Date;

public class CancelInsuranceCallBackReq {
	
	/** 订单号 **/
	private String orderCode;
	
	/** 批改状态 0:通过 1:不通过 **/
	private String endorStatus;
	
	/** 保单号 **/
	private String policyNo;
	
	/**保费变化量**/
	private double changePremium;
	
	/**批改日期**/
	private Date endorDate;
	
	/** 生效日期 **/
	private Date validDate;
	
	public String getOrderCode() {
	    return orderCode;
	}
	
	public void setOrderCode(String orderCode) {
	    this.orderCode = orderCode;
	}
	
	public String getEndorStatus() {
	    return endorStatus;
	}
	
	public void setEndorStatus(String endorStatus) {
	    this.endorStatus = endorStatus;
	}
	
	public String getPolicyNo() {
	    return policyNo;
	}
	
	public void setPolicyNo(String policyNo) {
	    this.policyNo = policyNo;
	}
	
	public double getChangePremium() {
		return changePremium;
	}
	
	public void setChangePremium(double changePremium) {
		this.changePremium = changePremium;
	}
	
	/**批改日期**/
	public Date getEndorDate() {
		return endorDate;
	}
	
	/**批改日期**/
	public void setEndorDate(Date endorDate) {
		this.endorDate = endorDate;
	}
	
	/** 生效日期 **/
	public Date getValidDate() {
		return validDate;
	}
	
	/** 生效日期 **/
	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}
	
}
