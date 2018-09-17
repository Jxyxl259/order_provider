package com.yaic.app.epolicy.dto.domain;

import javax.persistence.Transient;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class EpolicyApplyDto {

	/** 投保人名称 */
	@XStreamAlias("APPLINAME")
	private String appliName;
	
	/** 投保人性别 */
	@XStreamAlias("APPLISEX")
	private String appliSex;
	
	/** 投保人年龄 */
	@XStreamAlias("APPLIAGE")
	private String appliAge;
	
	/** 投保人证件类型 */
	@XStreamAlias("APPLIIDENTIFYTYPE")
	private String appliIdentifyType;
	
	/** 投保人证件号码 */
	@XStreamAlias("APPLIIDENTIFYNUMBER")
	private String appliIdentifyNumber;
	
	/** 投保人地址 */
	@XStreamAlias("APPLIADDRESS")
	private String appliAddress;
	
	/** 投保人生日 */
	@XStreamAlias("APPLIBIRTHDATE")
	private String appliBirthdate;
	
	/** 投保人电话 */
	@XStreamAlias("APPLIMOBILEPHONE")
	private String appliMobilephone;
	
	/** 投保人邮箱 */
	@XStreamAlias("APPLIEMAIL")
	private String appliEmail;
	
	/** 投保人行业类别 */
	@XStreamAlias("APPLIINDUSTRYTYPE")
	private String appliIndustryType;
	
    /** 客户类型:1-个人，2-企业 */ 
    @Transient
    @XStreamAlias("CUSTOMERTYPE")
    private String customerType;

	/** 投保人名称 */
	public String getAppliName() {
		return appliName;
	}

	/** 投保人名称 */
	public void setAppliName(String appliName) {
		this.appliName = appliName;
	}

	/** 投保人性别 */
	public String getAppliSex() {
		return appliSex;
	}

	/** 投保人性别 */
	public void setAppliSex(String appliSex) {
		this.appliSex = appliSex;
	}

	/** 投保人年龄 */
	public String getAppliAge() {
		return appliAge;
	}

	/** 投保人年龄 */
	public void setAppliAge(String appliAge) {
		this.appliAge = appliAge;
	}

	/** 投保人证件类型 */
	public String getAppliIdentifyType() {
		return appliIdentifyType;
	}

	/** 投保人证件类型 */
	public void setAppliIdentifyType(String appliIdentifyType) {
		this.appliIdentifyType = appliIdentifyType;
	}

	/** 投保人证件号码 */
	public String getAppliIdentifyNumber() {
		return appliIdentifyNumber;
	}

	/** 投保人证件号码 */
	public void setAppliIdentifyNumber(String appliIdentifyNumber) {
		this.appliIdentifyNumber = appliIdentifyNumber;
	}

	/** 投保人地址 */
	public String getAppliAddress() {
		return appliAddress;
	}

	/** 投保人地址 */
	public void setAppliAddress(String appliAddress) {
		this.appliAddress = appliAddress;
	}

	/** 投保人生日 */
	public String getAppliBirthdate() {
		return appliBirthdate;
	}

	/** 投保人生日 */
	public void setAppliBirthdate(String appliBirthdate) {
		this.appliBirthdate = appliBirthdate;
	}

	/** 投保人电话 */
	public String getAppliMobilephone() {
		return appliMobilephone;
	}

	/** 投保人电话 */
	public void setAppliMobilephone(String appliMobilephone) {
		this.appliMobilephone = appliMobilephone;
	}

	/** 投保人邮箱 */
	public String getAppliEmail() {
		return appliEmail;
	}

	/** 投保人邮箱 */
	public void setAppliEmail(String appliEmail) {
		this.appliEmail = appliEmail;
	}

	/** 投保人行业类别 */
	public String getAppliIndustryType() {
		return appliIndustryType;
	}

	/** 投保人行业类别 */
	public void setAppliIndustryType(String appliIndustryType) {
		this.appliIndustryType = appliIndustryType;
	}

	/** 客户类型:1-个人，2-企业 */
	public String getCustomerType() {
		return customerType;
	}

	/** 客户类型:1-个人，2-企业 */
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

}
