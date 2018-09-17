/*
 * Created By lujicong (2015-12-21 16:02:16)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2015
 */
package com.yaic.app.order.dto.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.yaic.fa.dto.BaseDto;

@Table(name = "t_order_main")
public class OrderMainDto extends BaseDto implements Serializable {
	
	private static final long serialVersionUID = OrderMainDto.class.getName().hashCode();
	
	/** 用户id */ 
	@Transient
	private BigInteger userId;
	
	/** 订单主表id */ 
	@Id
	private BigInteger orderMainId;
	
	/** 订单编号 */ 
	private BigInteger orderCode;
	
	/** 订单创建时间 */ 
	private java.util.Date orderDate;
	
	/** 业务来源ID */ 
	private java.lang.String businessSourceId;
	
	/** 投保单号 */ 
	private java.lang.String proposalNo;
	
	/** 投保所在地区 */ 
	private java.lang.String orderCity;
	
	/** 保单号 */ 
	private java.lang.String policyNo;
	
	/** 第三方保单号 */ 
	private java.lang.String othPolicyNo;
	
	/** 保险起期 */ 
	private java.util.Date startDate;
	
	/** 保险止期 */ 
	private java.util.Date endDate;
	
	/** 订单有效状态：0-初始状态，1-转投保成功，2-转投保失败，3-转保单成功，4-转保单失败 ，5-全单批退成功，6-批改成功，7-批改中 ，8-批改失败*/ 
	private java.lang.String status;
	
	/** 创建人 */ 
	private java.lang.String createdUser;
	
	/** 创建时间 */ 
	private java.util.Date createdDate;
	
	/** 更新人 */ 
	private java.lang.String updatedUser;
	
	/** 更新时间 */ 
	private java.util.Date updatedDate;
	
	/** 是否有效:0正常,1作废值 */ 
	private Integer invalidFlag;
	
	/** 合同争议解决方式 : 1-诉讼  2-仲裁  3-协商  */
	private String argueSolution;
	
	/** 协议号 */ 
	private String agrtCode;
	/** 组织机构代码 */ 
	private String orgId;
	/** 业务方式：0-直接业务；1-间接业务 */ 
	private String businessMode;
	/** 业务来源 */ 
	private String businessSource;
	/** 渠道类型 */ 
	private String channelDetailCode;
	/** 渠道小类 */ 
	private String channelTip;
	/** 出单机构 */ 
	private String companyCode;
	/** 业务归属机构 */ 
	private String issueCompany;
	/** 业务员代码 */ 
	private String salesmanCode;
	/** 业务员代码 */ 
	private String salesmanName;
	/** 事业群代码 */ 
	private String teamCode;
	/** 事业群代码 */ 
	private String teamName;
	/** 中介代码 */ 
	private String intermediaryCode;
	/** 中介协议号 */ 
	private String agreementNo;
	/** 子协议号 */ 
	private String solutionCode;
	/** 账期，单位:天 */ 
	private Integer creditPeriod;
	/** 方案代码 */ 
	private String projectCode;
	/** 暂收款号 */ 
	private String poaSerialNo;
	/** 见费出单标志:Y-是 N-否 */ 
	private String codInd;
	/** 关联单号 */ 
	private String associatedNo;
	/** 定额类型 */ 
	private java.lang.String rationType;
	/** 渠道来源 */ 
	private java.lang.String dataSource;
	/** 组合险产品名称 */ 
	private java.lang.String productName;
	
	/** 技术服务费协议号 */ 
	private java.lang.String agreementNoSub;
	
	/** 退保生效时间 */ 
	private java.util.Date surrenderValidDate;
	/** 批改时间 */ 
	private java.util.Date endorDate;
	/** 同步保单状态:0-已同步 */ 
	private String synPolicyStatus;
	/** 同步退保保单状态:0-已同步 */ 
	private String synPolicySurrenderStatus;
	
	/** 团队归属机构 */ 
	private java.lang.String pioneerCode;
	
	/** 产品类别: 0 普通产品，1 理财产品，2 赠险产品 */ 
	private java.lang.String productClass;
	
	/** 最低保费值 */ 
	private BigDecimal lowestPremium;
	
	/** 出单员 */ 
	private java.lang.String operatorCode;
	
	/** 续保旧单号码 */ 
	private java.lang.String renewalNo;
	
	/** 续保新单号码 */ 
	private java.lang.String replacedPolicyNo;
	
	/** 新/续保标志 0：新保；1：续保 */ 
	private java.lang.String renewInd;
	
	/** 被续保标志 0-未被续保；1：已被续保 */ 
	private java.lang.String renewedInd;
	
	/** 是否测试单Y-是，N-否，为空默认为非测试单 */ 
	private String testIssueFlag;
	
	/** 核保状态标识： 0-初始状态，1-核保通过，2-核保不通过（下发修改），3-自动核保通过，4-拒保，6-承保确认，9-待核保 */ 
	private String underwriterInd;
	
	/**
	 * 设置属性用户id的值
	 */ 
	public void setUserId(BigInteger userId) {
	    this.userId = userId;
	}
	
	/**
	 * 获取属性用户id的值
	 */ 
	public BigInteger getUserId() {
	    return this.userId;
	}
	
	/**
	 * 设置属性订单主表id的值
	 */ 
	public void setOrderMainId(BigInteger orderMainId) {
	    this.orderMainId = orderMainId;
	}
	
	/**
	 * 获取属性订单主表id的值
	 */ 
	public BigInteger getOrderMainId() {
	    return orderMainId;
	}
	
	/**
	 * 设置属性订单编号的值
	 */ 
	public BigInteger getOrderCode() {
	    return orderCode;
	}
	
	/**
	 * 获取属性订单编号的值
	 */ 
	public void setOrderCode(BigInteger orderCode) {
	    this.orderCode = orderCode;
	}
	
	/**
	 * 设置属性订单创建时间的值
	 */ 
	public void setOrderDate(java.util.Date orderDate) {
	    this.orderDate = orderDate;
	}
	
	/**
	 * 获取属性订单创建时间的值
	 */ 
	public java.util.Date getOrderDate() {
	    return this.orderDate;
	}
	
	/**
	 * 设置属性业务来源ID的值
	 */ 
	public void setBusinessSourceId(java.lang.String businessSourceId) {
	    this.businessSourceId = businessSourceId;
	}
	
	/**
	 * 获取属性业务来源ID的值
	 */ 
	public java.lang.String getBusinessSourceId() {
	    return this.businessSourceId;
	}
	
	/**
	 * 设置属性投保单号的值
	 */ 
	public void setProposalNo(java.lang.String proposalNo) {
	    this.proposalNo = proposalNo;
	}
	
	/**
	 * 获取属性投保单号的值
	 */ 
	public java.lang.String getProposalNo() {
	    return this.proposalNo;
	}
	
	/**
	 * 设置属性投保所在地区的值
	 */ 
	public void setOrderCity(java.lang.String orderCity) {
	    this.orderCity = orderCity;
	}
	
	/**
	 * 获取属性投保所在地区的值
	 */ 
	public java.lang.String getOrderCity() {
	    return this.orderCity;
	}
	
	/**
	 * 设置属性保单号的值
	 */ 
	public void setPolicyNo(java.lang.String policyNo) {
	    this.policyNo = policyNo;
	}
	
	/**
	 * 获取属性保单号的值
	 */ 
	public java.lang.String getPolicyNo() {
	    return this.policyNo;
	}
	
	/**
	 * 设置属性第三方保单号的值
	 */
	public void setOthPolicyNo(java.lang.String othPolicyNo) {
	    this.othPolicyNo = othPolicyNo;
	}
	
	/**
	 * 获取属性第三方保单号的值
	 */ 
	public java.lang.String getOthPolicyNo() {
	    return othPolicyNo;
	}
	
	/**
	 * 设置属性保险起期的值
	 */ 
	public void setStartDate(java.util.Date startDate) {
	    this.startDate = startDate;
	}
	
	/**
	 * 获取属性保险起期的值
	 */ 
	public java.util.Date getStartDate() {
	    return this.startDate;
	}
	
	/**
	 * 设置属性保险止期的值
	 */ 
	public void setEndDate(java.util.Date endDate) {
	    this.endDate = endDate;
	}
	
	/**
	 * 获取属性保险止期的值
	 */ 
	public java.util.Date getEndDate() {
	    return this.endDate;
	}
	
	/**
	 * 设置属性订单有效状态：0-初始状态，1-转投保成功，2-转投保失败，3-转保单成功，4-转保单失败 ，5-全单批退成功，6-批改成功，7-批改中 ，8-批改失败，9-待人工审核，A-拒保 
	 */ 
	public void setStatus(java.lang.String status) {
	    this.status = status;
	}
	
	/**
	 * 设置属性订单有效状态：0-初始状态，1-转投保成功，2-转投保失败，3-转保单成功，4-转保单失败 ，5-全单批退成功，6-批改成功，7-批改中 ，8-批改失败，9-待人工审核，A-拒保 
	 */ 
	public java.lang.String getStatus() {
	    return this.status;
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
	 * 设置属性是否有效:0正常,1作废值的值
	 */ 
	public void setInvalidFlag(Integer invalidFlag) {
	    this.invalidFlag = invalidFlag;
	}
	
	/**
	 * 获取属性是否有效:0正常,1作废值的值
	 */ 
	public Integer getInvalidFlag() {
	    return this.invalidFlag;
	}
	
	/**
	 * 获取合同争议解决方式 : 1-诉讼  2-仲裁  3-协商
	 */ 
	public String getArgueSolution() {
		return argueSolution;
	}
	
	/**
	 * 设置合同争议解决方式 : 1-诉讼  2-仲裁  3-协商
	 */ 
	public void setArgueSolution(String argueSolution) {
		this.argueSolution = argueSolution;
	}
	
	public String getAgrtCode() {
	    return agrtCode;
	}
	
	public void setAgrtCode(String agrtCode) {
	    this.agrtCode = agrtCode;
	}
	
	public String getOrgId() {
	    return orgId;
	}
	
	public void setOrgId(String orgId) {
	    this.orgId = orgId;
	}
	
	public String getBusinessMode() {
	    return businessMode;
	}
	
	public void setBusinessMode(String businessMode) {
	    this.businessMode = businessMode;
	}
	
	public String getBusinessSource() {
	    return businessSource;
	}
	
	public void setBusinessSource(String businessSource) {
	    this.businessSource = businessSource;
	}
	
	public String getChannelDetailCode() {
	    return channelDetailCode;
	}
	
	public void setChannelDetailCode(String channelDetailCode) {
	    this.channelDetailCode = channelDetailCode;
	}
	
	public String getChannelTip() {
	    return channelTip;
	}
	
	public void setChannelTip(String channelTip) {
	    this.channelTip = channelTip;
	}
	
	public String getCompanyCode() {
	    return companyCode;
	}
	
	public void setCompanyCode(String companyCode) {
	    this.companyCode = companyCode;
	}
	
	public String getIssueCompany() {
		return issueCompany;
	}
	
	public void setIssueCompany(String issueCompany) {
		this.issueCompany = issueCompany;
	}
	
	public String getSalesmanCode() {
	    return salesmanCode;
	}
	
	public void setSalesmanCode(String salesmanCode) {
	    this.salesmanCode = salesmanCode;
	}
	
	public String getSalesmanName() {
	    return salesmanName;
	}
	
	public void setSalesmanName(String salesmanName) {
	    this.salesmanName = salesmanName;
	}
	
	public String getTeamCode() {
	    return teamCode;
	}
	
	public void setTeamCode(String teamCode) {
	    this.teamCode = teamCode;
	}
	
	public String getTeamName() {
	    return teamName;
	}
	
	public void setTeamName(String teamName) {
	    this.teamName = teamName;
	}
	
	public String getIntermediaryCode() {
	    return intermediaryCode;
	}
	
	public void setIntermediaryCode(String intermediaryCode) {
	    this.intermediaryCode = intermediaryCode;
	}
	
	public String getAgreementNo() {
	    return agreementNo;
	}
	
	public void setAgreementNo(String agreementNo) {
	    this.agreementNo = agreementNo;
	}
	
	public String getSolutionCode() {
	    return solutionCode;
	}
	
	public void setSolutionCode(String solutionCode) {
	    this.solutionCode = solutionCode;
	}
	
	public Integer getCreditPeriod() {
	    return creditPeriod;
	}
	
	public void setCreditPeriod(Integer creditPeriod) {
	    this.creditPeriod = creditPeriod;
	}
	
	public String getProjectCode() {
	    return projectCode;
	}
	
	public void setProjectCode(String projectCode) {
	    this.projectCode = projectCode;
	}
	
	public String getPoaSerialNo() {
	    return poaSerialNo;
	}
	
	public void setPoaSerialNo(String poaSerialNo) {
	    this.poaSerialNo = poaSerialNo;
	}
	
	public String getCodInd() {
	    return codInd;
	}
	
	public void setCodInd(String codInd) {
	    this.codInd = codInd;
	}
	
	public String getAssociatedNo() {
	    return associatedNo;
	}
	
	public void setAssociatedNo(String associatedNo) {
	    this.associatedNo = associatedNo;
	}
	
	/**
	 * 获取属性定额类型的值
	 */ 
	public java.lang.String getRationType() {
	    return this.rationType;
	}
	
	/**
	 * 设置属性定额类型的值
	 */ 
	public void setRationType(java.lang.String rationType) {
	    this.rationType = rationType;
	}
	
	/**
	 * 设置属性渠道来源的值
	 */ 
	public void setDataSource(java.lang.String dataSource) {
	    this.dataSource = dataSource;
	}
	
	/**
	 * 获取属性渠道来源的值
	 */ 
	public java.lang.String getDataSource() {
	    return this.dataSource;
	}
	
	/**
	 * 设置属性组合险产品名称的值
	 */ 
	public void setProductName(java.lang.String productName) {
	    this.productName = productName;
	}
	
	/**
	 * 获取属性组合险产品名称的值
	 */ 
	public java.lang.String getProductName() {
	    return this.productName;
	}
	
	/**
	 * 设置属性技术服务费协议号的值
	 */ 
	public void setAgreementNoSub(java.lang.String agreementNoSub) {
	    this.agreementNoSub = agreementNoSub;
	}
	
	/**
	 * 获取属性技术服务费协议号的值
	 */ 
	public java.lang.String getAgreementNoSub() {
	    return this.agreementNoSub;
	}
	
	/**
	 * 获取属性退保生效时间的值
	 */ 
	public java.util.Date getSurrenderValidDate() {
	    return surrenderValidDate;
	}
	
	/**
	 * 设置属性退保生效时间的值
	 */ 
	public void setSurrenderValidDate(java.util.Date surrenderValidDate) {
	    this.surrenderValidDate = surrenderValidDate;
	}
	
	/**
	 * 获取属性批改时间的值
	 */
	public java.util.Date getEndorDate() {
	    return endorDate;
	}
	
	/**
	 * 设置属性批改时间的值
	 */
	public void setEndorDate(java.util.Date endorDate) {
	    this.endorDate = endorDate;
	}
	
	/**
	 * 获取属性同步保单状态:0-已同步的值
	 */
	public String getSynPolicyStatus() {
	    return synPolicyStatus;
	}
	
	/**
	 * 设置属性同步保单状态:0-已同步的值
	 */
	public void setSynPolicyStatus(String synPolicyStatus) {
	    this.synPolicyStatus = synPolicyStatus;
	}
	
	/**
	 * 获取属性同步退保保单状态:0-已同步的值
	 */
	public String getSynPolicySurrenderStatus() {
	    return synPolicySurrenderStatus;
	}
	
	/**
	 * 设置属性同步退保保单状态:0-已同步的值
	 */
	public void setSynPolicySurrenderStatus(String synPolicySurrenderStatus) {
	    this.synPolicySurrenderStatus = synPolicySurrenderStatus;
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
	 * 获取属性产品类别: 0 普通产品，1 理财产品，2 赠险产品的值
	 */ 
	public java.lang.String getProductClass() {
	    return productClass;
	}
	
	/**
	 * 设置属性产品类别: 0 普通产品，1 理财产品，2 赠险产品的值
	 */ 
	public void setProductClass(java.lang.String productClass) {
	    this.productClass = productClass;
	}
	
	/**
	 * 获取属性最低保费的值
	 */ 
	public BigDecimal getLowestPremium() {
		return lowestPremium;
	}
	
	/**
	 * 设置属性最低保费的值
	 */ 
	public void setLowestPremium(BigDecimal lowestPremium) {
		this.lowestPremium = lowestPremium;
	}
	
	/**
	 * 获取属性出单员的值
	 */ 
	public java.lang.String getOperatorCode() {
		return operatorCode;
	}
	
	/**
	 * 设置属性出单员的值
	 */
	public void setOperatorCode(java.lang.String operatorCode) {
		this.operatorCode = operatorCode;
	}
	
	/**
	 * 设置属性续保旧单号码的值
	 */ 
	public void setRenewalNo(java.lang.String renewalNo) {
	    this.renewalNo = renewalNo;
	}
	
	/**
	 * 获取属性续保旧单号码的值
	 */ 
	public java.lang.String getRenewalNo() {
	    return this.renewalNo;
	}
	
	/**
	 * 设置属性续保新单号码的值
	 */ 
	public void setReplacedPolicyNo(java.lang.String replacedPolicyNo) {
	    this.replacedPolicyNo = replacedPolicyNo;
	}
	
	/**
	 * 获取属性续保新单号码的值
	 */ 
	public java.lang.String getReplacedPolicyNo() {
	    return this.replacedPolicyNo;
	}
	
	/**
	 * 设置属性新/续保标志 0：新保；1：续保的值
	 */ 
	public void setRenewInd(java.lang.String renewInd) {
	    this.renewInd = renewInd;
	}
	
	/**
	 * 获取属性新/续保标志 0：新保；1：续保的值
	 */ 
	public java.lang.String getRenewInd() {
	    return this.renewInd;
	}
	
	/**
	 * 设置属性被续保标志 0-未被续保；1：已被续保的值
	 */ 
	public void setRenewedInd(java.lang.String renewedInd) {
	    this.renewedInd = renewedInd;
	}
	
	/**
	 * 获取属性被续保标志 0-未被续保；1：已被续保的值
	 */ 
	public java.lang.String getRenewedInd() {
	    return this.renewedInd;
	}
	
	/** 是否测试单Y-是，N-否，为空默认为非测试单 */ 
	public String getTestIssueFlag() {
		return testIssueFlag;
	}
	
	/** 是否测试单Y-是，N-否，为空默认为非测试单 */ 
	public void setTestIssueFlag(String testIssueFlag) {
		this.testIssueFlag = testIssueFlag;
	}

	/** 核保状态标识： 0-初始状态，1-核保通过，2-核保不通过（下发修改），3-自动核保通过，4-拒保，6-承保确认，9-待核保 */ 
	public String getUnderwriterInd() {
		return underwriterInd;
	}
	
	/** 核保状态标识： 0-初始状态，1-核保通过，2-核保不通过（下发修改），3-自动核保通过，4-拒保，6-承保确认，9-待核保 */ 
	public void setUnderwriterInd(String underwriterInd) {
		this.underwriterInd = underwriterInd;
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