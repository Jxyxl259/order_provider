/*
 * Created By lujicong (2017-08-01 13:44:38)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.pdms.dto.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.yaic.fa.dto.BaseDto;

/**
 * 产品赔付信息表
 */
@Table(name = "t_pdms_product_claim")
public class PdmsProductClaimDto extends BaseDto implements Serializable {
	
	private static final long serialVersionUID = PdmsProductClaimDto.class.getName().hashCode();
	
	/** 主键ID */
	@Id
	private Integer claimId;
	
	/** 产品代码 */
	private Integer prodId;
	
	/** 赔付级别：对应t_pub_code 的 code_type=ClaimLevel */
	private String claimLevel;
	
	/** 序号 */
	private Integer serialNo;
	
	/** 险种代码 */
	private String riskCode;
	
	/** 险别代码 */
	private String kindCode;
	
	/** 责任代码 */
	private String liabCode;
	
	/** 赔付标识：对应t_pub_code 的 code_type=ClaimInd */
	private String claimInd;
	
	//赔付标识名
	@Transient
	private String ClaimIndName;
	
	/** 限额代码 */
	private String limitCode;
	
	/** 免赔代码 */
	private String deductibleCode;
	
	/** 段序 */
	private Integer sectionNo;
	
	/** 币别 */
	private String currency;
	
	/** 免赔额 */
	private java.math.BigDecimal deductible;
	
	/** 费用起线 */
	private java.math.BigDecimal costStart;
	
	/** 费用止线 */
	private java.math.BigDecimal costEnd;
	
	/** 赔付比例 */
	private java.math.BigDecimal claimRate;
	
	/** 备注 */
	private String remark;
	
	/** 失效标志：0-有效，1-失效 */
	private Integer invalidFlag;
	
	/** 创建人 */
	private String createdUser;
	
	/** 创建时间 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createdDate;
	
	/** 更新人 */
	private String updatedUser;
	
	/** 更新时间 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date updatedDate;
	
	@Transient
	private String limitName;
	
	@Transient
	private String deductibleName;
	
	
	/**
	 * 获取属性主键ID的值
	 */
	public Integer getClaimId() {
	    return this.claimId;
	}
	
	/**
	 * 设置属性主键ID的值
	 */
	public void setClaimId(Integer claimId) {
	    this.claimId = claimId;
	}   
	
	/** 产品代码 */
	public Integer getProdId() {
		return prodId;
	}
	
	/** 产品代码 */
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}
	
	/**
	 * 获取属性赔付级别：对应t_pub_code 的 code_type=ClaimLevel的值
	 */
	public String getClaimLevel() {
	    return this.claimLevel;
	}
	
	/**
	 * 设置属性赔付级别：对应t_pub_code 的 code_type=ClaimLevel的值
	 */
	public void setClaimLevel(String claimLevel) {
	    this.claimLevel = claimLevel;
	}
	
	/**
	 * 获取属性序号的值
	 */
	public Integer getSerialNo() {
	    return this.serialNo;
	}
	
	/**
	 * 设置属性序号的值
	 */
	public void setSerialNo(Integer serialNo) {
	    this.serialNo = serialNo;
	}
	
	/**
	 * 获取属性险种代码的值
	 */
	public String getRiskCode() {
	    return this.riskCode;
	}
	
	/**
	 * 设置属性险种代码的值
	 */
	public void setRiskCode(String riskCode) {
	    this.riskCode = riskCode;
	}
	
	/**
	 * 获取属性险别代码的值
	 */
	public String getKindCode() {
	    return this.kindCode;
	}
	
	/**
	 * 设置属性险别代码的值
	 */
	public void setKindCode(String kindCode) {
	    this.kindCode = kindCode;
	}
	
	/**
	 * 获取属性责任代码的值
	 */
	public String getLiabCode() {
	    return this.liabCode;
	}
	
	/**
	 * 设置属性责任代码的值
	 */
	public void setLiabCode(String liabCode) {
	    this.liabCode = liabCode;
	}
	
	/**
	 * 获取属性赔付标识：对应t_pub_code 的 code_type=ClaimInd的值
	 */
	public String getClaimInd() {
	    return this.claimInd;
	}
	
	/**
	 * 设置属性赔付标识：对应t_pub_code 的 code_type=ClaimInd的值
	 */
	public void setClaimInd(String claimInd) {
	    this.claimInd = claimInd;
	}
	
	/**
	 * 获取属性限额代码的值
	 */
	public String getLimitCode() {
	    return this.limitCode;
	}
	
	/**
	 * 设置属性限额代码的值
	 */
	public void setLimitCode(String limitCode) {
	    this.limitCode = limitCode;
	}
	
	/**
	 * 获取属性免赔代码的值
	 */
	public String getDeductibleCode() {
	    return this.deductibleCode;
	}
	
	/**
	 * 设置属性免赔代码的值
	 */
	public void setDeductibleCode(String deductibleCode) {
	    this.deductibleCode = deductibleCode;
	}
	
	/**
	 * 获取属性段序的值
	 */
	public Integer getSectionNo() {
	    return this.sectionNo;
	}
	
	/**
	 * 设置属性段序的值
	 */
	public void setSectionNo(Integer sectionNo) {
	    this.sectionNo = sectionNo;
	}
	
	/**
	 * 获取属性币别的值
	 */
	public String getCurrency() {
	    return this.currency;
	}
	
	/**
	 * 设置属性币别的值
	 */
	public void setCurrency(String currency) {
	    this.currency = currency;
	}
	
	/**
	 * 获取属性免赔额的值
	 */
	public java.math.BigDecimal getDeductible() {
	    return this.deductible;
	}
	
	/**
	 * 设置属性免赔额的值
	 */
	public void setDeductible(java.math.BigDecimal deductible) {
	    this.deductible = deductible;
	}
	
	/**
	 * 获取属性费用起线的值
	 */
	public java.math.BigDecimal getCostStart() {
	    return this.costStart;
	}
	
	/**
	 * 设置属性费用起线的值
	 */
	public void setCostStart(java.math.BigDecimal costStart) {
	    this.costStart = costStart;
	}
	
	/**
	 * 获取属性费用止线的值
	 */
	public java.math.BigDecimal getCostEnd() {
	    return this.costEnd;
	}
	
	/**
	 * 设置属性费用止线的值
	 */
	public void setCostEnd(java.math.BigDecimal costEnd) {
	    this.costEnd = costEnd;
	}
	
	/**
	 * 获取属性赔付比例的值
	 */
	public java.math.BigDecimal getClaimRate() {
	    return this.claimRate;
	}
	
	/**
	 * 设置属性赔付比例的值
	 */
	public void setClaimRate(java.math.BigDecimal claimRate) {
	    this.claimRate = claimRate;
	}
	
	/**
	 * 获取属性备注的值
	 */
	public String getRemark() {
	    return this.remark;
	}
	
	/**
	 * 设置属性备注的值
	 */
	public void setRemark(String remark) {
	    this.remark = remark;
	}
	
	/**
	 * 获取属性失效标志：0-有效，1-失效的值
	 */
	public Integer getInvalidFlag() {
	    return this.invalidFlag;
	}
	
	/**
	 * 设置属性失效标志：0-有效，1-失效的值
	 */
	public void setInvalidFlag(Integer invalidFlag) {
	    this.invalidFlag = invalidFlag;
	}
	
	/**
	 * 获取属性创建人的值
	 */
	public String getCreatedUser() {
	    return this.createdUser;
	}
	
	/**
	 * 设置属性创建人的值
	 */
	public void setCreatedUser(String createdUser) {
	    this.createdUser = createdUser;
	}
	
	/**
	 * 获取属性创建时间的值
	 */
	public Date getCreatedDate() {
	    return this.createdDate;
	}
	
	/**
	 * 设置属性创建时间的值
	 */
	public void setCreatedDate(Date createdDate) {
	    this.createdDate = createdDate;
	}
	
	/**
	 * 获取属性更新人的值
	 */
	public String getUpdatedUser() {
	    return this.updatedUser;
	}
	
	/**
	 * 设置属性更新人的值
	 */
	public void setUpdatedUser(String updatedUser) {
	    this.updatedUser = updatedUser;
	}
	
	/**
	 * 获取属性更新时间的值
	 */
	public Date getUpdatedDate() {
	    return this.updatedDate;
	}
	
	/**
	 * 设置属性更新时间的值
	 */
	public void setUpdatedDate(Date updatedDate) {
	    this.updatedDate = updatedDate;
	}
	
	public String getLimitName() {
		return limitName;
	}
	
	public void setLimitName(String limitName) {
		this.limitName = limitName;
	}
	
	public String getDeductibleName() {
		return deductibleName;
	}
	
	public void setDeductibleName(String deductibleName) {
		this.deductibleName = deductibleName;
	}
	
	public String getClaimIndName() {
		return ClaimIndName;
	}
	
	public void setClaimIndName(String claimIndName) {
		ClaimIndName = claimIndName;
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