/*
 * Created By lujicong (2017-06-06 14:48:02)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.pdms.dto.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.yaic.fa.dto.BaseDto;

/**
 * 产品免赔表
 */
@Table(name = "t_pdms_risk_deductible")
public class PdmsRiskDeductibleDto extends BaseDto implements Serializable {
	
	private static final long serialVersionUID = PdmsRiskDeductibleDto.class.getName().hashCode();
	
	/** 主键ID */
	@Id
	private Integer deductibleId;
	
	/** 免赔级别：对应t_pub_code 的 code_type=DeductibleLevel */
	private String deductibleLevel;
	
	/** 序号 */
	private Integer serialNo;
	
	/** 险别代码 */
	private String kindCode;
	
	/** 免赔代码 */
	private String deductibleCode;
	
	/** 免赔名称 */
	private String deductibleName;
	
	/** 免赔类型：对应t_pub_code 的 code_type=DeductibleType */
	private String deductibleType;
	
	/** 币别 */
	private String currency;
	
	/** 免赔数值 */
	private java.math.BigDecimal deductible;
	
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
	
	
	/**
	 * 获取属性主键ID的值
	 */
	public Integer getDeductibleId() {
	    return this.deductibleId;
	}
	
	/**
	 * 设置属性主键ID的值
	 */
	public void setDeductibleId(Integer deductibleId) {
	    this.deductibleId = deductibleId;
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
	 * 获取属性免赔名称的值
	 */
	public String getDeductibleName() {
	    return this.deductibleName;
	}
	
	/**
	 * 设置属性免赔名称的值
	 */
	public void setDeductibleName(String deductibleName) {
	    this.deductibleName = deductibleName;
	}
	
	/**
	 * 获取属性免赔类型：对应t_pub_code 的 code_type=DeductibleType的值
	 */
	public String getDeductibleType() {
	    return this.deductibleType;
	}
	
	/**
	 * 设置属性免赔类型：对应t_pub_code 的 code_type=DeductibleType的值
	 */
	public void setDeductibleType(String deductibleType) {
	    this.deductibleType = deductibleType;
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