/*
 * Created By lujicong (2017-06-29 10:39:42)
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
 * 产品免赔表
 */
@Table(name = "t_pdms_product_deductible")
public class PdmsProductDeductibleDto extends BaseDto implements Serializable {
	
	private static final long serialVersionUID = PdmsProductDeductibleDto.class.getName().hashCode();
	
	/** 产品代码 */
	private Integer prodId;
	
	/** 免赔级别：对应t_pub_code 的 code_type=DeductibleLevel */
	private String deductibleLevel;
	
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
	
	/** 责任名称 */
	private String liabName;
	
	/** 免赔代码 */
	private String deductibleCode;
	
	/** 免赔名称*/
	@Transient
	private String deductibleName;
	
	/** 币别 */
	private String currency;
	
	/** 免赔数值 */
	private java.math.BigDecimal deductible;
	
	/** 免赔率 */
	private java.math.BigDecimal deductibleRate;
	
	/** 免赔期 */
	private Integer waitingPeriod;
	
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
	
	
    public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	/**
	 * 获取属性免赔级别：对应t_pub_code 的 code_type=DeductibleLevel的值
	 */
	public String getDeductibleLevel() {
	    return this.deductibleLevel;
	}
	
	/**
	 * 设置属性免赔级别：对应t_pub_code 的 code_type=DeductibleLevel的值
	 */
	public void setDeductibleLevel(String deductibleLevel) {
	    this.deductibleLevel = deductibleLevel;
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
	 * 获取属性免赔数值的值
	 */
	public java.math.BigDecimal getDeductible() {
	    return this.deductible;
	}
	
	/**
	 * 设置属性免赔数值的值
	 */
	public void setDeductible(java.math.BigDecimal deductible) {
	    this.deductible = deductible;
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
	
	/** 免赔名称*/
	public String getDeductibleName() {
		return deductibleName;
	}
	
	/** 免赔名称*/
	public void setDeductibleName(String deductibleName) {
		this.deductibleName = deductibleName;
	}
	
	/** 责任名称 */
	public String getLiabName() {
		return liabName;
	}
	
	/** 责任名称 */
	public void setLiabName(String liabName) {
		this.liabName = liabName;
	}
	
	/** 免赔率 */
	public java.math.BigDecimal getDeductibleRate() {
		return deductibleRate;
	}
	
	/** 免赔率 */
	public void setDeductibleRate(java.math.BigDecimal deductibleRate) {
		this.deductibleRate = deductibleRate;
	}
	
	/** 免赔期 */
	public Integer getWaitingPeriod() {
		return waitingPeriod;
	}
	
	/** 免赔期 */
	public void setWaitingPeriod(Integer waitingPeriod) {
		this.waitingPeriod = waitingPeriod;
	}
	
	/** 备注 */
	public String getRemark() {
		return remark;
	}
	
	/** 备注 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/** 限额代码 */
	public String getLimitCode() {
		return limitCode;
	}
	
	/** 限额代码*/
	public void setLimitCode(String limitCode) {
		this.limitCode = limitCode;
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