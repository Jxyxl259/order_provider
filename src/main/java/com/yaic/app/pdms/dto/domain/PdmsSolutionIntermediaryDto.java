/*
 * Created By lujicong (2017-08-17 10:38:49)
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
 * 方案合作方信息表
 */
@Table(name = "t_pdms_solution_intermediary")
public class PdmsSolutionIntermediaryDto extends BaseDto implements Serializable {
	
	private static final long serialVersionUID = PdmsSolutionIntermediaryDto.class.getName().hashCode();
	
	/** 主键ID */
	@Id
	private Integer intermediaryId;
	
	/** 方案主键ID */
	private Integer solutionId;
	
	/** 序号 */
	private Integer serialNo;
	
	/** 合作方代码 */
	private String intermediaryCode;
	
	/** 合作方名称 */
	private String intermediaryName;
	
	/** 合作方别名 */
	private String intermediaryAlias;
	
	/** 合作方类型 */
	private String intermediaryKind;
	
	/** 合作方标识 */
	private String intermediaryFlag;
	
	/** 有效起期 */
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date startDate;
	
	/** 有效止期 */
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date endDate;
	
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
	public Integer getIntermediaryId() {
	    return this.intermediaryId;
	}
	
	/**
	 * 设置属性主键ID的值
	 */
	public void setIntermediaryId(Integer intermediaryId) {
	    this.intermediaryId = intermediaryId;
	}
	
	/**
	 * 获取属性方案主键ID的值
	 */
	public Integer getSolutionId() {
	    return this.solutionId;
	}
	
	/**
	 * 设置属性方案主键ID的值
	 */
	public void setSolutionId(Integer solutionId) {
	    this.solutionId = solutionId;
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
	 * 获取属性合作方代码的值
	 */
	public String getIntermediaryCode() {
	    return this.intermediaryCode;
	}
	
	/**
	 * 设置属性合作方代码的值
	 */
	public void setIntermediaryCode(String intermediaryCode) {
	    this.intermediaryCode = intermediaryCode;
	}
	
	/**
	 * 获取属性合作方名称的值
	 */
	public String getIntermediaryName() {
	    return this.intermediaryName;
	}
	
	/**
	 * 设置属性合作方名称的值
	 */
	public void setIntermediaryName(String intermediaryName) {
	    this.intermediaryName = intermediaryName;
	}
	
	/**
	 * 获取属性合作方别名的值
	 */
	public String getIntermediaryAlias() {
	    return this.intermediaryAlias;
	}
	
	/**
	 * 设置属性合作方别名的值
	 */
	public void setIntermediaryAlias(String intermediaryAlias) {
	    this.intermediaryAlias = intermediaryAlias;
	}
	
	/**
	 * 获取属性合作方类型的值
	 */
	public String getIntermediaryKind() {
	    return this.intermediaryKind;
	}
	
	/**
	 * 设置属性合作方类型的值
	 */
	public void setIntermediaryKind(String intermediaryKind) {
	    this.intermediaryKind = intermediaryKind;
	}
	
	/**
	 * 获取属性合作方标识的值
	 */
	public String getIntermediaryFlag() {
	    return this.intermediaryFlag;
	}
	
	/**
	 * 设置属性合作方标识的值
	 */
	public void setIntermediaryFlag(String intermediaryFlag) {
	    this.intermediaryFlag = intermediaryFlag;
	}
	
	/**
	 * 获取属性有效起期的值
	 */
	public Date getStartDate() {
	    return this.startDate;
	}
	
	/**
	 * 设置属性有效起期的值
	 */
	public void setStartDate(Date startDate) {
	    this.startDate = startDate;
	}
	
	/**
	 * 获取属性有效止期的值
	 */
	public Date getEndDate() {
	    return this.endDate;
	}
	
	/**
	 * 设置属性有效止期的值
	 */
	public void setEndDate(Date endDate) {
	    this.endDate = endDate;
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