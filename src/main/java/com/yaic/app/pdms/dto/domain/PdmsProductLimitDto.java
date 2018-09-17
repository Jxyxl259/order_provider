/*
 * Created By lujicong (2017-06-29 10:39:43)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.pdms.dto.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yaic.fa.dto.BaseDto;

/**
 * 产品限额表
 */
@Table(name = "t_pdms_product_limit")
public class PdmsProductLimitDto extends BaseDto implements Serializable {
	
	private static final long serialVersionUID = PdmsProductLimitDto.class.getName().hashCode();
	
	/** 产品代码 */
	private Integer prodId;
	
	/** 限额级别：对应t_pub_code 的 code_type=LimitLevel */
	private String limitLevel;
	
	/** 序号 */
	private Integer serialNo;
	
	/** 险种代码 */
	private String riskCode;
	
	/** 险别代码 */
	private String kindCode;
	
	/** 责任代码 */
	private String liabCode;
	
	/** 限额代码 */
	private String limitCode;
	
	@Transient
	private String limitType;
	
	@Transient
	private String limitTypeName;
	
	@Transient
	private String limitName;
	
	@Transient
	private String limitDesc;
	
	@Transient
	private String limitClass;
	
	@Transient
	private String limitClassName;
	
	/** 币别 */
	private String currency;
	
	/** 币别名称 */
	@Transient
	private String currencyName;
	
	/** 限额数值 */
	private java.math.BigDecimal limitValue;
	
	/** 责任日额保险金 */
	private java.math.BigDecimal unitLimit;
	
	/** 责任保费 */
	private java.math.BigDecimal grossPremium;
	
	/** 每次事故责任期(天) */
	private Integer eachLiabPeriod;
	
	/** 累计责任期(天) */
	private Integer totalLiabPeriod;
	
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
	
	/** 限额类型名称 */
	@Transient
	private String codeCName;
	
	
	public Integer getProdId() {
		return prodId;
	}
	
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}
	
	/**
	 * 获取属性限额级别：对应t_pub_code 的 code_type=LimitLevel的值
	 */
	public String getLimitLevel() {
	    return this.limitLevel;
	}
	
	/**
	 * 设置属性限额级别：对应t_pub_code 的 code_type=LimitLevel的值
	 */
	public void setLimitLevel(String limitLevel) {
	    this.limitLevel = limitLevel;
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
	
	public String getCurrencyName() {
		return currencyName;
	}
	
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	
	/**
	 * 获取属性限额数值的值
	 */
	public java.math.BigDecimal getLimitValue() {
	    return this.limitValue;
	}
	
	/**
	 * 设置属性限额数值的值
	 */
	public void setLimitValue(java.math.BigDecimal limitValue) {
	    this.limitValue = limitValue;
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
	
	public String getLimitType() {
		return limitType;
	}
	
	public void setLimitType(String limitType) {
		this.limitType = limitType;
	}
	
	/** 限额类型名称 */
	public String getCodeCName() {
		return codeCName;
	}
	
	/** 限额类型名称 */
	public void setCodeCName(String codeCName) {
		this.codeCName = codeCName;
	}
	
	public String getLimitName() {
		return limitName;
	}
	
	public void setLimitName(String limitName) {
		this.limitName = limitName;
	}
	
	public String getLimitDesc() {
		return limitDesc;
	}
	
	public void setLimitDesc(String limitDesc) {
		this.limitDesc = limitDesc;
	}
	
	public String getLimitClass() {
		return limitClass;
	}
	
	public void setLimitClass(String limitClass) {
		this.limitClass = limitClass;
	}
	
	public java.math.BigDecimal getUnitLimit() {
		return unitLimit;
	}
	
	public void setUnitLimit(java.math.BigDecimal unitLimit) {
		this.unitLimit = unitLimit;
	}
	
	public java.math.BigDecimal getGrossPremium() {
		return grossPremium;
	}
	
	public void setGrossPremium(java.math.BigDecimal grossPremium) {
		this.grossPremium = grossPremium;
	}
	
	public Integer getEachLiabPeriod() {
		return eachLiabPeriod;
	}
	
	public void setEachLiabPeriod(Integer eachLiabPeriod) {
		this.eachLiabPeriod = eachLiabPeriod;
	}
	
	public Integer getTotalLiabPeriod() {
		return totalLiabPeriod;
	}
	
	public void setTotalLiabPeriod(Integer totalLiabPeriod) {
		this.totalLiabPeriod = totalLiabPeriod;
	}
	
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getLimitTypeName() {
		return limitTypeName;
	}
	
	public void setLimitTypeName(String limitTypeName) {
		this.limitTypeName = limitTypeName;
	}
	
	public String getLimitClassName() {
		return limitClassName;
	}
	
	public void setLimitClassName(String limitClassName) {
		this.limitClassName = limitClassName;
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