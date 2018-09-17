package com.yaic.app.order.dto.msg;

import java.math.BigDecimal;

public class CancelInsuranceResp {

	/** 是否通过标示 **/
	private String passFlag;
	
	/** 全单批退返回信息 **/
	private String meassage;
	
	/** 核保状态 **/
	private String underWriteInd;
	
	/** 批改时间 **/
	private java.util.Date endorDate;
	
	/** 应退保费 **/
	private BigDecimal returnPremium;
	
	public String getPassFlag() {
	    return passFlag;
	}
	
	public void setPassFlag(String passFlag) {
	    this.passFlag = passFlag;
	}
	
	public String getMeassage() {
	    return meassage;
	}
	
	public void setMeassage(String meassage) {
	    this.meassage = meassage;
	}
	
	public String getUnderWriteInd() {
	    return underWriteInd;
	}
	
	public void setUnderWriteInd(String underWriteInd) {
	    this.underWriteInd = underWriteInd;
	}

	/** 批改时间 **/
	public java.util.Date getEndorDate() {
		return endorDate;
	}

	/** 批改时间 **/
	public void setEndorDate(java.util.Date endorDate) {
		this.endorDate = endorDate;
	}

	/** 应退保费 **/
	public BigDecimal getReturnPremium() {
		return returnPremium;
	}

	/** 应退保费 **/
	public void setReturnPremium(BigDecimal returnPremium) {
		this.returnPremium = returnPremium;
	}
	
}
