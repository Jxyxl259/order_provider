/*
 * Created By lujicong (2017-08-17 10:38:52)
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
 * 方案关系映射表(迁移历史数据)
 */
@Table(name = "t_pdms_solution_mapping")
public class PdmsSolutionMappingDto extends BaseDto implements Serializable {
	
	private static final long serialVersionUID = PdmsSolutionMappingDto.class.getName().hashCode();
	
	/** 主键ID */
	@Id
	private Integer solutionMappingId;
	
	/** 外部方案代码 */
	private String outerAgrtCode;
	
	/** 外部产品代码 */
	private String outerProdCode;
	
	/** 方案主键ID */
	private Integer solutionId;
	
	/** 方案代码 */
	private String agrtCode;
	
	/** 对外产品名称 */
	private String prodName;
	
	/** 显示序号 */
	private Integer displayNo;
	
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
	public Integer getSolutionMappingId() {
	    return this.solutionMappingId;
	}
	
	/**
	 * 设置属性主键ID的值
	 */
	public void setSolutionMappingId(Integer solutionMappingId) {
	    this.solutionMappingId = solutionMappingId;
	}
	
	/**
	 * 获取属性外部方案代码的值
	 */
	public String getOuterAgrtCode() {
	    return this.outerAgrtCode;
	}
	
	/**
	 * 设置属性外部方案代码的值
	 */
	public void setOuterAgrtCode(String outerAgrtCode) {
	    this.outerAgrtCode = outerAgrtCode;
	}
	
	/**
	 * 获取属性外部产品代码的值
	 */
	public String getOuterProdCode() {
		return outerProdCode;
	}
	
	/**
	 * 设置属性外部产品代码的值
	 */
	public void setOuterProdCode(String outerProdCode) {
		this.outerProdCode = outerProdCode;
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
	 * 获取属性方案代码的值
	 */
	public String getAgrtCode() {
	    return this.agrtCode;
	}
	
	/**
	 * 设置属性方案代码的值
	 */
	public void setAgrtCode(String agrtCode) {
	    this.agrtCode = agrtCode;
	}
	
	/**
	 * 获取属性对外产品名称的值
	 */
	public String getProdName() {
	    return this.prodName;
	}
	
	/**
	 * 设置属性对外产品名称的值
	 */
	public void setProdName(String prodName) {
	    this.prodName = prodName;
	}
	
	/**
	 * 获取属性显示序号的值
	 */
	public Integer getDisplayNo() {
	    return this.displayNo;
	}
	
	/**
	 * 设置属性显示序号的值
	 */
	public void setDisplayNo(Integer displayNo) {
	    this.displayNo = displayNo;
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