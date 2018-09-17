package com.yaic.app.epolicy.dto.domain;

import javax.persistence.Transient;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class EpolicyBenefitDto {

	/** 序号 */
	@XStreamAlias("SERIALNO")
	private String serialNo;
	
	/** 客户号码 */
	@XStreamAlias("CLIENTNO")
	private String clientNo;
	
	/** 被保人名称 */
	@XStreamAlias("INSUREDNAME")
	private String insuredName;
	
	/** 被保人证件类型 */
	@XStreamAlias("INSUREDIDENTIFYTYPE")
	private String insuredIdentifyType;
	
	/** 被保人证件号码 */
	@XStreamAlias("INSUREDIDENTIFYTYPE")
	private String insuredIdentifyNumber;
	
	/** 受益人名称 */
	@XStreamAlias("BENEFITNAME")
	private String benefitName;
	
	/** 受益人证件类型 */
	@XStreamAlias("BENEFITIDENTIFYTYPE")
	private String benefitIdentifyType;
	
	/** 受益人证件号码 */
	@XStreamAlias("BENEFITIDENTIFYNO")
	private String benefitIdentifyNo;
	
	/** 与被保险人关系 */
	@XStreamAlias("BENEINSURELATION")
	private String beneInsuRelation;
	
	/** 受益顺序 */
	@XStreamAlias("BENEFITFLAG")
	private String benefitFlag;
	
	/** 受益份额 */
	@XStreamAlias("BENEFITPERCENT")
	private String benefitPercent;
	
	/** 备注 */
	@XStreamAlias("REMARK")
	private String remark;
	
    /** 被保人客户类型:1-个人，2-企业 */ 
    @Transient
    @XStreamAlias("INSUREDCUSTOMERTYPE")
    private String insuredCustomerType;
    
    /** 受益人客户类型:1-个人，2-企业 */ 
    @Transient
    @XStreamAlias("BENEFITCUSTOMERTYPE")
    private String benefitCustomerType;

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

	/** 受益人名称 */
	public String getBenefitName() {
		return benefitName;
	}

	/** 受益人名称 */
	public void setBenefitName(String benefitName) {
		this.benefitName = benefitName;
	}

	/** 受益人证件类型 */
	public String getBenefitIdentifyType() {
		return benefitIdentifyType;
	}

	/** 受益人证件类型 */
	public void setBenefitIdentifyType(String benefitIdentifyType) {
		this.benefitIdentifyType = benefitIdentifyType;
	}

	/** 受益人证件号码 */
	public String getBenefitIdentifyNo() {
		return benefitIdentifyNo;
	}

	/** 受益人证件号码 */
	public void setBenefitIdentifyNo(String benefitIdentifyNo) {
		this.benefitIdentifyNo = benefitIdentifyNo;
	}

	/** 与被保险人关系 */
	public String getBeneInsuRelation() {
		return beneInsuRelation;
	}

	/** 与被保险人关系 */
	public void setBeneInsuRelation(String beneInsuRelation) {
		this.beneInsuRelation = beneInsuRelation;
	}

	/** 受益顺序 */
	public String getBenefitFlag() {
		return benefitFlag;
	}

	/** 受益顺序 */
	public void setBenefitFlag(String benefitFlag) {
		this.benefitFlag = benefitFlag;
	}

	/** 受益份额 */
	public String getBenefitPercent() {
		return benefitPercent;
	}

	/** 受益份额 */
	public void setBenefitPercent(String benefitPercent) {
		this.benefitPercent = benefitPercent;
	}

	/** 备注 */
	public String getRemark() {
		return remark;
	}

	/** 备注 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/** 被保人客户类型:1-个人，2-企业 */ 
	public String getInsuredCustomerType() {
		return insuredCustomerType;
	}

	/** 被保人客户类型:1-个人，2-企业 */ 
	public void setInsuredCustomerType(String insuredCustomerType) {
		this.insuredCustomerType = insuredCustomerType;
	}

	/** 受益人客户类型:1-个人，2-企业 */ 
	public String getBenefitCustomerType() {
		return benefitCustomerType;
	}

	/** 受益人客户类型:1-个人，2-企业 */ 
	public void setBenefitCustomerType(String benefitCustomerType) {
		this.benefitCustomerType = benefitCustomerType;
	}

}
