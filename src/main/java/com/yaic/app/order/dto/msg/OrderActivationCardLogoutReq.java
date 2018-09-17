package com.yaic.app.order.dto.msg;

import java.util.Date;

public class OrderActivationCardLogoutReq {
    
    /** 单证类型代码 */
    private String docVerCode;
    
    /** 印刷流水号 */
    private String businessNo;
    
    /** 保单号 */
    private String policyNo;
    
    /** 激活方式 默认为： "T" */
    private String activeType;
    
    /** 激活时间 */
    private Date activeTime;

    /** 单证类型代码 */
	public String getDocVerCode() {
		return docVerCode;
	}

	 /** 单证类型代码 */
	public void setDocVerCode(String docVerCode) {
		this.docVerCode = docVerCode;
	}

	/** 印刷流水号 */
	public String getBusinessNo() {
		return businessNo;
	}

	/** 印刷流水号 */
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	/** 保单号 */
	public String getPolicyNo() {
		return policyNo;
	}

	/** 保单号 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	/** 激活方式 默认为： "T" */
	public String getActiveType() {
		return activeType;
	}

	/** 激活方式 默认为： "T" */
	public void setActiveType(String activeType) {
		this.activeType = activeType;
	}

	/** 激活时间 */
	public Date getActiveTime() {
		return activeTime;
	}

	/** 激活时间 */
	public void setActiveTime(Date activeTime) {
		this.activeTime = activeTime;
	}
    
}