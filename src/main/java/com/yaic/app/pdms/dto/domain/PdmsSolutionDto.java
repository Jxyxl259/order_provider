/*
 * Created By lujicong (2017-08-02 11:07:36)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.pdms.dto.domain;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yaic.fa.dto.BaseDto;

/**
 * 销售方案表
 */
@Table(name = "t_pdms_solution")
public class PdmsSolutionDto extends BaseDto implements Serializable {
	
	private static final long serialVersionUID = PdmsSolutionDto.class.getName().hashCode();
	
	/** 主键ID */ 
	@Id
	private java.lang.Integer solutionId;
	
	/** 方案代码 */ 
	private java.lang.String agrtCode;
	
	/** 方案名称 */ 
	private java.lang.String agrtName;
	
	/** 业务方式：0-直接业务；1-间接业务，对应t_pub_code 的 code_type=BusinessMode */ 
	private java.lang.String businessMode;
	
	/** 平台代码 */ 
	private java.lang.String dataSource;
	
	/** 业务来源：对应t_pub_code 的 code_type=BusinessSource */ 
	private java.lang.String businessSource;
	
	/** 渠道类型：对应t_pub_code 的 code_type=ChannelType */ 
	private java.lang.String channelDetailCode;
	
	/** 渠道小类：对应t_pub_code 的 code_type=ChannelTip */ 
	private java.lang.String channelTip;
	
	/** 出单机构 */ 
	private java.lang.String companyCode;
	
	/** 业务归属机构 */ 
	private java.lang.String issueCompany;
	
	/** 业务员代码 */ 
	private java.lang.String salesmanCode;
	
	/** 业务员名称 */ 
	private java.lang.String salesmanName;
	
	/** 事业群代码 */ 
	private java.lang.String teamCode;
	
	/** 事业群名称 */ 
	private java.lang.String teamName;
	
	/** 团队归属机构 */ 
	private java.lang.String pioneerCode;
	
	/** 平台简称 */ 
	private java.lang.String dataSourceName;
	
	/** 平台全称 */ 
	private java.lang.String dataSourceDesc;
	
	/** 主合作方 */ 
	private java.lang.String intermediaryCode;
	
	/** 主协议号 */ 
	private java.lang.String agreementNo;
	
	/** 子协议号 */ 
	private java.lang.String solutionCode;
	
	/** 账期，单位:天 */ 
	private java.lang.Integer creditPeriod;
	
	/** 产品方案代码 */ 
	private java.lang.String projectCode;
	
	/** 网络平台 */ 
	private java.lang.String orgId;
	
	/** 网络平台协议 */ 
	private java.lang.String agreementNoSub;
	
	/** 出单方式：对应t_pub_code 的 code_type=IssueType */ 
	private java.lang.String issueType;
	
	/** 见费出单标志:Y－是 N－否 */ 
	private java.lang.String codInd;
	
	/** 暂收款编号 */ 
	private java.lang.String poaSerialNo;
	
	/** 审核状态 */ 
	private java.lang.String approvalStatus;
	
	/** 协议状态标志（由销管系统推送同步） */ 
	private java.lang.String agreementState;
	
	/** 产品代码（核心） */ 
	private java.lang.String productCode;
	
	/** 是否发送邮件: 0-否 ， 1-是 */ 
	private java.lang.String isEmail;
	
	/** 是否发送短信：0-否， 1-是 */ 
	private java.lang.String isSms;
	
	/** 支付失效时间（分钟） */ 
	private java.lang.Integer payExpired;
	
	/** 产品类别: 0 普通产品，1 理财产品，2 赠险产品 */ 
	private java.lang.String productClass;
	
	/** 是否允许倒签：0-否，1-是 */ 
	private java.lang.String backPolicyFlag;
	
	/** 生效日期 */ 
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private java.util.Date validDate;
	
	/** 失效日期 */ 
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private java.util.Date invalidDate;
	
	/** 联系人姓名 */ 
	private java.lang.String contactName;
	
	/** 联系人电话 */ 
	private java.lang.String contactPhone;
	
	/** 联系人邮箱 */ 
	private java.lang.String contactEmail;
	
	/** 渠道联系人姓名 */ 
	private java.lang.String chanContactName;
	
	/** 渠道联系人电话 */ 
	private java.lang.String chanContactPhone;
	
	/** 渠道联系人邮箱 */ 
	private java.lang.String chanContactEmail;
	
	/** 失效标志：0-有效，1-失效 */ 
	private java.lang.Integer invalidFlag;
	
	/** 创建人 */ 
	private java.lang.String createdUser;
	
	/** 创建时间 */ 
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private java.util.Date createdDate;
	
	/** 更新人 */ 
	private java.lang.String updatedUser;
	
	/** 更新时间 */ 
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private java.util.Date updatedDate;
	
	/** 产品名称 */
	private java.lang.String prodName;
	
	 /** 司法管辖代码*/
    public String judicalCode;
    
    /** 司法管辖名称*/
    public String judicalScope;
	
	/**
	 * 设置属性主键ID的值
	 */ 
	public void setSolutionId(java.lang.Integer solutionId) {
	    this.solutionId = solutionId;
	}
	
	/**
	 * 获取属性主键ID的值
	 */ 
	public java.lang.Integer getSolutionId() {
	    return this.solutionId;
	}
	
	/**
	 * 设置属性方案代码的值
	 */ 
	public void setAgrtCode(java.lang.String agrtCode) {
	    this.agrtCode = agrtCode;
	}
	
	/**
	 * 获取属性方案代码的值
	 */ 
	public java.lang.String getAgrtCode() {
	    return this.agrtCode;
	}
	
	/**
	 * 设置属性方案名称的值
	 */ 
	public void setAgrtName(java.lang.String agrtName) {
	    this.agrtName = agrtName;
	}
	
	/**
	 * 获取属性方案名称的值
	 */ 
	public java.lang.String getAgrtName() {
	    return this.agrtName;
	}
	
	/**
	 * 设置属性业务方式：0-直接业务；1-间接业务，对应t_pub_code 的 code_type=BusinessMode的值
	 */ 
	public void setBusinessMode(java.lang.String businessMode) {
	    this.businessMode = businessMode;
	}
	
	/**
	 * 获取属性业务方式：0-直接业务；1-间接业务，对应t_pub_code 的 code_type=BusinessMode的值
	 */ 
	public java.lang.String getBusinessMode() {
	    return this.businessMode;
	}
	
	/**
	 * 设置属性平台代码的值
	 */ 
	public void setDataSource(java.lang.String dataSource) {
	    this.dataSource = dataSource;
	}
	
	/**
	 * 获取属性平台代码的值
	 */ 
	public java.lang.String getDataSource() {
	    return this.dataSource;
	}
	
	/**
	 * 设置属性业务来源：对应t_pub_code 的 code_type=BusinessSource的值
	 */ 
	public void setBusinessSource(java.lang.String businessSource) {
	    this.businessSource = businessSource;
	}
	
	/**
	 * 获取属性业务来源：对应t_pub_code 的 code_type=BusinessSource的值
	 */ 
	public java.lang.String getBusinessSource() {
	    return this.businessSource;
	}
	
	/**
	 * 设置属性渠道类型：对应t_pub_code 的 code_type=ChannelType的值
	 */ 
	public void setChannelDetailCode(java.lang.String channelDetailCode) {
	    this.channelDetailCode = channelDetailCode;
	}
	
	/**
	 * 获取属性渠道类型：对应t_pub_code 的 code_type=ChannelType的值
	 */ 
	public java.lang.String getChannelDetailCode() {
	    return this.channelDetailCode;
	}
	
	/**
	 * 设置属性渠道小类：对应t_pub_code 的 code_type=ChannelTip的值
	 */ 
	public void setChannelTip(java.lang.String channelTip) {
	    this.channelTip = channelTip;
	}
	
	/**
	 * 获取属性渠道小类：对应t_pub_code 的 code_type=ChannelTip的值
	 */ 
	public java.lang.String getChannelTip() {
	    return this.channelTip;
	}
	
	/**
	 * 设置属性出单机构的值
	 */ 
	public void setCompanyCode(java.lang.String companyCode) {
	    this.companyCode = companyCode;
	}
	
	/**
	 * 获取属性出单机构的值
	 */ 
	public java.lang.String getCompanyCode() {
	    return this.companyCode;
	}
	
	/**
	 * 设置属性业务归属机构的值
	 */ 
	public void setIssueCompany(java.lang.String issueCompany) {
	    this.issueCompany = issueCompany;
	}
	
	/**
	 * 获取属性业务归属机构的值
	 */ 
	public java.lang.String getIssueCompany() {
	    return this.issueCompany;
	}
	
	/**
	 * 设置属性业务员代码的值
	 */ 
	public void setSalesmanCode(java.lang.String salesmanCode) {
	    this.salesmanCode = salesmanCode;
	}
	
	/**
	 * 获取属性业务员代码的值
	 */ 
	public java.lang.String getSalesmanCode() {
	    return this.salesmanCode;
	}
	
	/**
	 * 设置属性业务员名称的值
	 */ 
	public void setSalesmanName(java.lang.String salesmanName) {
	    this.salesmanName = salesmanName;
	}
	
	/**
	 * 获取属性业务员名称的值
	 */ 
	public java.lang.String getSalesmanName() {
	    return this.salesmanName;
	}
	
	/**
	 * 设置属性事业群代码的值
	 */ 
	public void setTeamCode(java.lang.String teamCode) {
	    this.teamCode = teamCode;
	}
	
	/**
	 * 获取属性事业群代码的值
	 */ 
	public java.lang.String getTeamCode() {
	    return this.teamCode;
	}
	
	/**
	 * 设置属性事业群名称的值
	 */ 
	public void setTeamName(java.lang.String teamName) {
	    this.teamName = teamName;
	}
	
	/**
	 * 获取属性事业群名称的值
	 */ 
	public java.lang.String getTeamName() {
	    return this.teamName;
	}
	
	/**
	 * 设置属性团队归属机构的值
	 */ 
	public void setPioneerCode(java.lang.String pioneerCode) {
	    this.pioneerCode = pioneerCode;
	}
	
	/**
	 * 获取属性团队归属机构的值
	 */ 
	public java.lang.String getPioneerCode() {
	    return this.pioneerCode;
	}
	
	/**
	 * 设置属性平台简称的值
	 */ 
	public void setDataSourceName(java.lang.String dataSourceName) {
	    this.dataSourceName = dataSourceName;
	}
	
	/**
	 * 获取属性平台简称的值
	 */ 
	public java.lang.String getDataSourceName() {
	    return this.dataSourceName;
	}
	
	/**
	 * 设置属性平台全称的值
	 */ 
	public void setDataSourceDesc(java.lang.String dataSourceDesc) {
	    this.dataSourceDesc = dataSourceDesc;
	}
	
	/**
	 * 获取属性平台全称的值
	 */ 
	public java.lang.String getDataSourceDesc() {
	    return this.dataSourceDesc;
	}
	
	/**
	 * 设置属性主合作方的值
	 */ 
	public void setIntermediaryCode(java.lang.String intermediaryCode) {
	    this.intermediaryCode = intermediaryCode;
	}
	
	/**
	 * 获取属性主合作方的值
	 */ 
	public java.lang.String getIntermediaryCode() {
	    return this.intermediaryCode;
	}
	
	/**
	 * 设置属性主协议号的值
	 */ 
	public void setAgreementNo(java.lang.String agreementNo) {
	    this.agreementNo = agreementNo;
	}
	
	/**
	 * 获取属性主协议号的值
	 */ 
	public java.lang.String getAgreementNo() {
	    return this.agreementNo;
	}
	
	/**
	 * 设置属性子协议号的值
	 */ 
	public void setSolutionCode(java.lang.String solutionCode) {
	    this.solutionCode = solutionCode;
	}
	
	/**
	 * 获取属性子协议号的值
	 */ 
	public java.lang.String getSolutionCode() {
	    return this.solutionCode;
	}
	
	/**
	 * 设置属性账期，单位:天的值
	 */ 
	public void setCreditPeriod(java.lang.Integer creditPeriod) {
	    this.creditPeriod = creditPeriod;
	}
	
	/**
	 * 获取属性账期，单位:天的值
	 */ 
	public java.lang.Integer getCreditPeriod() {
	    return this.creditPeriod;
	}
	
	/**
	 * 设置属性产品方案代码的值
	 */ 
	public void setProjectCode(java.lang.String projectCode) {
	    this.projectCode = projectCode;
	}
	
	/**
	 * 获取属性产品方案代码的值
	 */ 
	public java.lang.String getProjectCode() {
	    return this.projectCode;
	}
	
	/**
	 * 设置属性网络平台的值
	 */ 
	public void setOrgId(java.lang.String orgId) {
	    this.orgId = orgId;
	}
	
	/**
	 * 获取属性网络平台的值
	 */ 
	public java.lang.String getOrgId() {
	    return this.orgId;
	}
	
	/**
	 * 设置属性网络平台协议的值
	 */ 
	public void setAgreementNoSub(java.lang.String agreementNoSub) {
	    this.agreementNoSub = agreementNoSub;
	}
	
	/**
	 * 获取属性网络平台协议的值
	 */ 
	public java.lang.String getAgreementNoSub() {
	    return this.agreementNoSub;
	}
	
	/**
	 * 设置属性出单方式：对应t_pub_code 的 code_type=IssueType的值
	 */ 
	public void setIssueType(java.lang.String issueType) {
	    this.issueType = issueType;
	}
	
	/**
	 * 获取属性出单方式：对应t_pub_code 的 code_type=IssueType的值
	 */ 
	public java.lang.String getIssueType() {
	    return this.issueType;
	}
	
	/**
	 * 设置属性见费出单标志:Y－是 N－否的值
	 */ 
	public void setCodInd(java.lang.String codInd) {
	    this.codInd = codInd;
	}
	
	/**
	 * 获取属性见费出单标志:Y－是 N－否的值
	 */ 
	public java.lang.String getCodInd() {
	    return this.codInd;
	}
	
	/**
	 * 设置属性暂收款编号的值
	 */ 
	public void setPoaSerialNo(java.lang.String poaSerialNo) {
	    this.poaSerialNo = poaSerialNo;
	}
	
	/**
	 * 获取属性暂收款编号的值
	 */ 
	public java.lang.String getPoaSerialNo() {
	    return this.poaSerialNo;
	}
	
	/**
	 * 设置属性审核状态的值
	 */ 
	public void setApprovalStatus(java.lang.String approvalStatus) {
	    this.approvalStatus = approvalStatus;
	}
	
	/**
	 * 获取属性审核状态的值
	 */ 
	public java.lang.String getApprovalStatus() {
	    return this.approvalStatus;
	}
	
	/**
	 * 设置属性协议状态标志（由销管系统推送同步）的值
	 */ 
	public void setAgreementState(java.lang.String agreementState) {
	    this.agreementState = agreementState;
	}
	
	/**
	 * 获取属性协议状态标志（由销管系统推送同步）的值
	 */ 
	public java.lang.String getAgreementState() {
	    return this.agreementState;
	}
	
	/**
	 * 设置属性产品代码（核心）的值
	 */ 
	public void setProductCode(java.lang.String productCode) {
	    this.productCode = productCode;
	}
	
	/**
	 * 获取属性产品代码（核心）的值
	 */ 
	public java.lang.String getProductCode() {
	    return this.productCode;
	}
	
	/**
	 * 设置属性是否发送邮件: 0-否 ， 1-是的值
	 */ 
	public void setIsEmail(java.lang.String isEmail) {
	    this.isEmail = isEmail;
	}
	
	/**
	 * 获取属性是否发送邮件: 0-否 ， 1-是的值
	 */ 
	public java.lang.String getIsEmail() {
	    return this.isEmail;
	}
	
	/**
	 * 设置属性是否发送短信：0-否， 1-是的值
	 */ 
	public void setIsSms(java.lang.String isSms) {
	    this.isSms = isSms;
	}
	
	/**
	 * 获取属性是否发送短信：0-否， 1-是的值
	 */ 
	public java.lang.String getIsSms() {
	    return this.isSms;
	}
	
	/**
	 * 设置属性支付失效时间（分钟）的值
	 */ 
	public void setPayExpired(java.lang.Integer payExpired) {
	    this.payExpired = payExpired;
	}
	
	/**
	 * 获取属性支付失效时间（分钟）的值
	 */ 
	public java.lang.Integer getPayExpired() {
	    return this.payExpired;
	}
	
	/**
	 * 设置属性产品类别: 0 普通产品，1 理财产品，2 赠险产品的值
	 */ 
	public void setProductClass(java.lang.String productClass) {
	    this.productClass = productClass;
	}
	
	/**
	 * 获取属性产品类别: 0 普通产品，1 理财产品，2 赠险产品的值
	 */ 
	public java.lang.String getProductClass() {
	    return this.productClass;
	}
	
	/**
	 * 设置属性是否允许倒签：0-否，1-是的值
	 */ 
	public void setBackPolicyFlag(java.lang.String backPolicyFlag) {
	    this.backPolicyFlag = backPolicyFlag;
	}
	
	/**
	 * 获取属性是否允许倒签：0-否，1-是的值
	 */ 
	public java.lang.String getBackPolicyFlag() {
	    return this.backPolicyFlag;
	}
	
	/**
	 * 设置属性生效日期的值
	 */ 
	public void setValidDate(java.util.Date validDate) {
	    this.validDate = validDate;
	}
	
	/**
	 * 获取属性生效日期的值
	 */ 
	public java.util.Date getValidDate() {
	    return this.validDate;
	}
	
	/**
	 * 设置属性失效日期的值
	 */ 
	public void setInvalidDate(java.util.Date invalidDate) {
	    this.invalidDate = invalidDate;
	}
	
	/**
	 * 获取属性失效日期的值
	 */ 
	public java.util.Date getInvalidDate() {
	    return this.invalidDate;
	}
	
	/**
	 * 设置属性联系人姓名的值
	 */ 
	public void setContactName(java.lang.String contactName) {
	    this.contactName = contactName;
	}
	
	/**
	 * 获取属性联系人姓名的值
	 */ 
	public java.lang.String getContactName() {
	    return this.contactName;
	}
	
	/**
	 * 设置属性联系人电话的值
	 */ 
	public void setContactPhone(java.lang.String contactPhone) {
	    this.contactPhone = contactPhone;
	}
	
	/**
	 * 获取属性联系人电话的值
	 */ 
	public java.lang.String getContactPhone() {
	    return this.contactPhone;
	}
	
	/**
	 * 设置属性联系人邮箱的值
	 */ 
	public void setContactEmail(java.lang.String contactEmail) {
	    this.contactEmail = contactEmail;
	}
	
	/**
	 * 获取属性联系人邮箱的值
	 */ 
	public java.lang.String getContactEmail() {
	    return this.contactEmail;
	}
	
	/**
	 * 设置属性渠道联系人姓名的值
	 */ 
	public void setChanContactName(java.lang.String chanContactName) {
	    this.chanContactName = chanContactName;
	}
	
	/**
	 * 获取属性渠道联系人姓名的值
	 */ 
	public java.lang.String getChanContactName() {
	    return this.chanContactName;
	}
	
	/**
	 * 设置属性渠道联系人电话的值
	 */ 
	public void setChanContactPhone(java.lang.String chanContactPhone) {
	    this.chanContactPhone = chanContactPhone;
	}
	
	/**
	 * 获取属性渠道联系人电话的值
	 */ 
	public java.lang.String getChanContactPhone() {
	    return this.chanContactPhone;
	}
	
	/**
	 * 设置属性渠道联系人邮箱的值
	 */ 
	public void setChanContactEmail(java.lang.String chanContactEmail) {
	    this.chanContactEmail = chanContactEmail;
	}
	
	/**
	 * 获取属性渠道联系人邮箱的值
	 */ 
	public java.lang.String getChanContactEmail() {
	    return this.chanContactEmail;
	}
	
	/**
	 * 设置属性失效标志：0-有效，1-失效的值
	 */ 
	public void setInvalidFlag(java.lang.Integer invalidFlag) {
	    this.invalidFlag = invalidFlag;
	}
	
	/**
	 * 获取属性失效标志：0-有效，1-失效的值
	 */ 
	public java.lang.Integer getInvalidFlag() {
	    return this.invalidFlag;
	}
	
	/**
	 * 设置属性创建人的值
	 */ 
	public void setCreatedUser(java.lang.String createdUser) {
	    this.createdUser = createdUser;
	}
	
	/**
	 * 获取属性创建人的值
	 */ 
	public java.lang.String getCreatedUser() {
	    return this.createdUser;
	}
	
	/**
	 * 设置属性创建时间的值
	 */ 
	public void setCreatedDate(java.util.Date createdDate) {
	    this.createdDate = createdDate;
	}
	
	/**
	 * 获取属性创建时间的值
	 */ 
	public java.util.Date getCreatedDate() {
	    return this.createdDate;
	}
	
	/**
	 * 设置属性更新人的值
	 */ 
	public void setUpdatedUser(java.lang.String updatedUser) {
	    this.updatedUser = updatedUser;
	}
	
	/**
	 * 获取属性更新人的值
	 */ 
	public java.lang.String getUpdatedUser() {
	    return this.updatedUser;
	}
	
	/**
	 * 设置属性更新时间的值
	 */ 
	public void setUpdatedDate(java.util.Date updatedDate) {
	    this.updatedDate = updatedDate;
	}
	
	/**
	 * 获取属性更新时间的值
	 */ 
	public java.util.Date getUpdatedDate() {
	    return this.updatedDate;
	}
	
	/**
	 * 获取属性产品名称的值
	 */ 
	public java.lang.String getProdName() {
		return prodName;
	}
	
	/**
	 * 设置属性产品名称的值
	 */
	public void setProdName(java.lang.String prodName) {
		this.prodName = prodName;
	}
	
	/**
	 * 获取属性司法管辖代码的值
	 */
	public String getJudicalCode() {
		return judicalCode;
	}

	/**
	 * 设置属性司法管辖代码的值
	 */
	public void setJudicalCode(String judicalCode) {
		this.judicalCode = judicalCode;
	}

	/**
	 * 获取属性司法管辖名称的值
	 */
	public String getJudicalScope() {
		return judicalScope;
	}

	/**
	 * 设置属性司法管辖名称的值
	 */
	public void setJudicalScope(String judicalScope) {
		this.judicalScope = judicalScope;
	}

	@Override
	public boolean equals(Object obj) {
	    return EqualsBuilder.reflectionEquals(this, obj);
	}
	
	@Override
	public int hashCode() {
	    return HashCodeBuilder.reflectionHashCode(this);
	}
	
	@Override
	public String toString() {
	    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}