package com.yaic.app.trans.dto.msg;

public class TransSalesInfoDto{

	/** 业务方式：0-直接业务；1-间接业务 */
	private String businessMode;
	
	/** 业务来源 */
	private String businessSource;
	
	/** 渠道类型 */
	private String channelDetailCode;
	
	/** 渠道小类 */ 
	private java.lang.String channelTip;
    
	/** 业务员代码 */
	private String salesmanCode;
	
	/** 业务员名称 */
	private String salesmanName;
	
	/** 出单机构 */
	private String companyCode;
	
	/** 业务归属机构 */
	private String issueCompany;
	
	/** 业务归属机构名称 */
	private String saleOrgName;
	
	/** 事业群代码 */
	private String teamCode;
	
	/** 事业群名称 */
	private String teamName;
	
	/** 中介代码 */
	private String intermediaryCode;
	
	/** 中介协议号 */
	private String agreementNo;
	
	/** 跟单业务员代码 */
	private String handlerCode;
	
	/** 跟单业务员名称 */
	private String handlerName;

	/** 业务方式：0-直接业务；1-间接业务 */
	public String getBusinessMode() {
		return businessMode;
	}

	/** 业务方式：0-直接业务；1-间接业务 */
	public void setBusinessMode(String businessMode) {
		this.businessMode = businessMode;
	}

	/** 业务来源 */
	public String getBusinessSource() {
		return businessSource;
	}

	/** 业务来源 */
	public void setBusinessSource(String businessSource) {
		this.businessSource = businessSource;
	}
	
	/** 渠道类型 */
	public String getChannelDetailCode() {
		return channelDetailCode;
	}

	/** 渠道类型 */
	public void setChannelDetailCode(String channelDetailCode) {
		this.channelDetailCode = channelDetailCode;
	}

	/**
	 * 设置属性渠道小类的值
	 */ 
	public void setChannelTip(java.lang.String channelTip) {
	    this.channelTip = channelTip;
	}
	
	/**
	 * 获取属性渠道小类的值
	 */ 
	public java.lang.String getChannelTip() {
	    return this.channelTip;
	}

	/** 业务员代码 */
	public String getSalesmanCode() {
		return salesmanCode;
	}

	/** 业务员代码 */
	public void setSalesmanCode(String salesmanCode) {
		this.salesmanCode = salesmanCode;
	}

	/** 业务员名称 */
	public String getSalesmanName() {
		return salesmanName;
	}

	/** 业务员名称 */
	public void setSalesmanName(String salesmanName) {
		this.salesmanName = salesmanName;
	}

	/** 出单机构机构 */
	public String getCompanyCode() {
		return companyCode;
	}

	/** 出单机构机构 */
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	/**
	 * 设置属性业务归属机构的值
	 */ 
	public java.lang.String getIssueCompany() {
		return issueCompany;
	}
	
	/**
	 * 获取属性业务归属机构的值
	 */ 
	public void setIssueCompany(java.lang.String issueCompany) {
		this.issueCompany = issueCompany;
	}
	
	/** 业务归属机构名称 */
	public String getSaleOrgName() {
		return saleOrgName;
	}

	/** 业务归属机构名称 */
	public void setSaleOrgName(String saleOrgName) {
		this.saleOrgName = saleOrgName;
	}

	/** 事业群代码 */
	public String getTeamCode() {
		return teamCode;
	}

	/** 事业群代码 */
	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}

	/** 事业群名称 */
	public String getTeamName() {
		return teamName;
	}

	/** 事业群名称 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	/** 中介代码 */
	public String getIntermediaryCode() {
		return intermediaryCode;
	}

	/** 中介代码 */
	public void setIntermediaryCode(String intermediaryCode) {
		this.intermediaryCode = intermediaryCode;
	}

	/** 中介协议号 */
	public String getAgreementNo() {
		return agreementNo;
	}

	/** 中介协议号 */
	public void setAgreementNo(String agreementNo) {
		this.agreementNo = agreementNo;
	}

	/** 跟单业务员代码 */
	public String getHandlerCode() {
		return handlerCode;
	}

	/** 跟单业务员代码 */
	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}

	/** 跟单业务员名称 */
	public String getHandlerName() {
		return handlerName;
	}

	/** 跟单业务员名称 */
	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}
	
}
