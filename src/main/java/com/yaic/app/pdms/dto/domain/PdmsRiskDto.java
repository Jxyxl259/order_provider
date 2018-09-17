/*
 * Created By lujicong (2017-04-18 19:33:42)
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
 * 险种表
 */
@Table(name = "t_pdms_risk")
public class PdmsRiskDto extends BaseDto implements Serializable {
	
	private static final long serialVersionUID = PdmsRiskDto.class.getName().hashCode();
	
	/** 险种代码 */
	@Id
	private String riskCode;
	
	/** 险种名称 */
	private String riskName;
	
	/** 险类代码 */
	private String riskClass;
	
	/** 子险类代码 */
	private String riskClassSub;
	
	/** 失效状态标识：0-有效，1-失效 */
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
	
	/** 险类名 */
	@Transient
	private String className;
	
	/** 子险类名称 */
	@Transient
	private String classSubName;
	
	/** 定额类型 */ 
    private java.lang.String rationType;
    
	
	/**
	 * 获取子险类代码
	 */
	public String getRiskClassSub() {
		return riskClassSub;
	}
	
	/**
	 * 设置子险类代码
	 */
	public void setRiskClassSub(String riskClassSub) {
		this.riskClassSub = riskClassSub;
	}
	
	/**
	 * 获取子险类名称
	 */
	public String getClassSubName() {
		return classSubName;
	}
	
	/**
	 * 设置子险类名称
	 */
	public void setClassSubName(String classSubName) {
		this.classSubName = classSubName;
	}
	/**
	 * 获取险类代码
	 */
	public String getRiskClass() {
		return riskClass;
	}
	/**
	 * 设置险类代码
	 */
	public void setRiskClass(String riskClass) {
		this.riskClass = riskClass;
	}
	/**
	 * 获取险类名
	 */
	public String getClassName() {
		return className;
	}
	/**
	 * 设置险类名
	 */
	public void setClassName(String className) {
		this.className = className;
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
	 * 获取属性险种名称的值
	 */
	public String getRiskName() {
	    return this.riskName;
	}
	
	/**
	 * 设置属性险种名称的值
	 */
	public void setRiskName(String riskName) {
	    this.riskName = riskName;
	}
	
	/**
	 * 获取属性失效状态标识：0-有效，1-失效的值
	 */
	public Integer getInvalidFlag() {
	    return this.invalidFlag;
	}
	
	/**
	 * 设置属性失效状态标识：0-有效，1-失效的值
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
	
	/** 定额类型 */ 
	public void setRationType(java.lang.String rationType) {
		this.rationType = rationType;
	}
	
    /** 定额类型 */ 
	public java.lang.String getRationType() {
		return rationType;
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
