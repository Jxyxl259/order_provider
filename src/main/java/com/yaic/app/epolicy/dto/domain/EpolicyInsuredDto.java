package com.yaic.app.epolicy.dto.domain;

import javax.persistence.Transient;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class EpolicyInsuredDto {

	/** 序号 */
	@XStreamAlias("SERIALNO")
	private String serialNo;
	
	/** 客户号码 */
	@XStreamAlias("CLIENTNO")
	private String clientNo;
	
	/** 被保人名称 */
	@XStreamAlias("INSUREDNAME")
	private String insuredName;
	
	/** 被保人性别 */
	@XStreamAlias("INSUREDSEX")
	private String insuredSex;
	
	/** 被保人年龄 */
	@XStreamAlias("INSUREDAGE")
	private String insuredAge;
	
	/** 被保人证件类型 */
	@XStreamAlias("INSUREDIDENTIFYTYPE")
	private String insuredIdentifyType;
	
	/** 被保人证件号码 */
	@XStreamAlias("INSUREDIDENTIFYNUMBER")
	private String insuredIdentifyNumber;
	
	/** 被保人生日 */
	@XStreamAlias("INSUREDBIRTHDATE")
	private String insuredBirthdate;
	
	/** 被保人电话 */
	@XStreamAlias("INSUREDMOBILEPHONE")
	private String insuredMobilephone;
	
	/** 被保人地址 */
	@XStreamAlias("INSUREDADDRESS")
	private String insuredAddress;
	
	/** 被保人邮编 */
	@XStreamAlias("INSUREDPOSTCODE")
	private String insuredPostcode;
	
	/** 职业类别 */
	@XStreamAlias("OCCUPATIONTYPE")
	private String occupationType;
	
	/** 职业名称 */
	@XStreamAlias("OCCUPATION")
	private String occupation;
	
	/** 职务 */
	@XStreamAlias("JOBTITLE")
	private String jobTitle;
	
	/** 工作单位 */
	@XStreamAlias("JOBUNITNAME")
	private String jobUnitname;
	
	/** 邮箱 */
	@XStreamAlias("EMAIL")
	private String email;
	
	/** 与投保人关系 */
	@XStreamAlias("INSUREDAPPRELATION")
	private String insuredAppRelation;
	
    /** 客户类型:1-个人，2-企业 */ 
    @Transient
    @XStreamAlias("CUSTOMERTYPE")
    private String customerType;
	
	/** 序号 */
	public String getSerialNo() {
		return serialNo;
	}

	/** 序号 */
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	/** 客户号码 */
	public String getClientNo() {
		return clientNo;
	}

	/** 客户号码 */
	public void setClientNo(String clientNo) {
		this.clientNo = clientNo;
	}

	/** 被保人名称 */
	public String getInsuredName() {
		return insuredName;
	}

	/** 被保人名称 */
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	/** 被保人性别 */
	public String getInsuredSex() {
		return insuredSex;
	}

	/** 被保人性别 */
	public void setInsuredSex(String insuredSex) {
		this.insuredSex = insuredSex;
	}

	/** 被保人年龄 */
	public String getInsuredAge() {
		return insuredAge;
	}

	/** 被保人年龄 */
	public void setInsuredAge(String insuredAge) {
		this.insuredAge = insuredAge;
	}

	/** 被保人证件类型 */
	public String getInsuredIdentifyType() {
		return insuredIdentifyType;
	}

	/** 被保人证件类型 */
	public void setInsuredIdentifyType(String insuredIdentifyType) {
		this.insuredIdentifyType = insuredIdentifyType;
	}

	/** 被保人证件号码 */
	public String getInsuredIdentifyNumber() {
		return insuredIdentifyNumber;
	}

	/** 被保人证件号码 */
	public void setInsuredIdentifyNumber(String insuredIdentifyNumber) {
		this.insuredIdentifyNumber = insuredIdentifyNumber;
	}

	/** 被保人生日 */
	public String getInsuredBirthdate() {
		return insuredBirthdate;
	}

	/** 被保人生日 */
	public void setInsuredBirthdate(String insuredBirthdate) {
		this.insuredBirthdate = insuredBirthdate;
	}

	/** 被保人电话 */
	public String getInsuredMobilephone() {
		return insuredMobilephone;
	}

	/** 被保人电话 */
	public void setInsuredMobilephone(String insuredMobilephone) {
		this.insuredMobilephone = insuredMobilephone;
	}

	/** 被保人地址 */
	public String getInsuredAddress() {
		return insuredAddress;
	}

	/** 被保人地址 */
	public void setInsuredAddress(String insuredAddress) {
		this.insuredAddress = insuredAddress;
	}

	/** 被保人邮编 */
	public String getInsuredPostcode() {
		return insuredPostcode;
	}

	/** 被保人邮编 */
	public void setInsuredPostcode(String insuredPostcode) {
		this.insuredPostcode = insuredPostcode;
	}

	/** 职业类别 */
	public String getOccupationType() {
		return occupationType;
	}

	/** 职业类别 */
	public void setOccupationType(String occupationType) {
		this.occupationType = occupationType;
	}

	/** 职业名称 */
	public String getOccupation() {
		return occupation;
	}

	/** 职业名称 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	/** 职务 */
	public String getJobTitle() {
		return jobTitle;
	}

	/** 职务 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	/** 工作单位 */
	public String getJobUnitname() {
		return jobUnitname;
	}

	/** 工作单位 */
	public void setJobUnitname(String jobUnitname) {
		this.jobUnitname = jobUnitname;
	}

	/** 邮箱 */
	public String getEmail() {
		return email;
	}

	/** 邮箱 */
	public void setEmail(String email) {
		this.email = email;
	}

	/** 与投保人关系 */
	public String getInsuredAppRelation() {
		return insuredAppRelation;
	}

	/** 与投保人关系 */
	public void setInsuredAppRelation(String insuredAppRelation) {
		this.insuredAppRelation = insuredAppRelation;
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
