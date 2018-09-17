package com.yaic.app.order.dto.msg;

import java.math.BigDecimal;

public class EndorResp {

	/** 是否通过标示 **/
	private String passFlag;
	
	/** 批改返回信息 **/
	private String meassage;
	
	/** 核保状态 **/
	private String underWriteInd;
	
	/** 批改后总保额 **/
	private BigDecimal amount;
	
	
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
	
	/** 批改后总保额 **/
	public BigDecimal getAmount() {
		return amount;
	}
	
	/** 批改后总保额 **/
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
