/*
 * Created By lujicong (2017-06-19 10:59:24)
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
 * 特别约定表
 */
@Table(name = "t_pdms_special_clauses")
public class PdmsSpecialClausesDto extends BaseDto implements Serializable {
	
	private static final long serialVersionUID = PdmsSpecialClausesDto.class.getName().hashCode();
	
	/** 条款编码 */
	@Id
	private String clauseCode;
	
	/** 条款名称 */
	private String clauseName;
	
	/** 特约条款内容 */
	private String clauseContext;
	
	/** 失效标识：0-有效，1-失效 */
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
	 * 获取属性条款编码的值
	 */
	public String getClauseCode() {
	    return this.clauseCode;
	}
	
	/**
	 * 设置属性条款编码的值
	 */
	public void setClauseCode(String clauseCode) {
	    this.clauseCode = clauseCode;
	}
	
	/**
	 * 获取属性条款名称的值
	 */
	public String getClauseName() {
	    return this.clauseName;
	}
	
	/**
	 * 设置属性条款名称的值
	 */
	public void setClauseName(String clauseName) {
	    this.clauseName = clauseName;
	}
	
	/**
	 * 获取属性特约条款内容的值
	 */
	public String getClauseContext() {
	    return this.clauseContext;
	}
	
	/**
	 * 设置属性特约条款内容的值
	 */
	public void setClauseContext(String clauseContext) {
	    this.clauseContext = clauseContext;
	}
	
	/**
	 * 获取属性失效标识：0-有效，1-失效的值
	 */
	public Integer getInvalidFlag() {
	    return this.invalidFlag;
	}
	
	/**
	 * 设置属性失效标识：0-有效，1-失效的值
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