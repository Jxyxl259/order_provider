package com.yaic.app.order.dto.msg;


public class QueryPropallReq {
	
    /** 客户名称  **/
    private String customerName;
    
    /** 证件类型 **/
    private String docType;
    
    /** 证件号码**/
    private String docNo;
    
    /** 手机号码 **/
    private String phoneNo;
    
    /** 险种代码 **/
    private String riskCode;
    
    /** 关系人标志 1:投保人,2:被保险人 **/
    private String customerFlag;
    /** 客户名称  **/
	public String getCustomerName() {
		return customerName;
	}

	/** 客户名称  **/
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/** 证件类型 **/
	public String getDocType() {
		return docType;
	}

	/** 证件类型 **/
	public void setDocType(String docType) {
		this.docType = docType;
	}

	/** 证件号码**/
	public String getDocNo() {
		return docNo;
	}

	/** 证件号码**/
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	/** 手机号码 **/
	public String getPhoneNo() {
		return phoneNo;
	}

	/** 手机号码 **/
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	/** 险种代码 **/
	public String getRiskCode() {
		return riskCode;
	}

	/** 险种代码 **/
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	
	 /** 关系人标志 1:投保人,2:被保险人 **/
	public String getCustomerFlag() {
		return customerFlag;
	}
	
	 /** 关系人标志 1:投保人,2:被保险人 **/
	public void setCustomerFlag(String customerFlag) {
		this.customerFlag = customerFlag;
	}
	
	
}
