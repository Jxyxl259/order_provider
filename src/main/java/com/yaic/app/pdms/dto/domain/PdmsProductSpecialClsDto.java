/*
 * Created By lujicong (2017-06-29 10:39:44)
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
 * 产品特约表
 */
@Table(name = "t_pdms_product_special_cls")
public class PdmsProductSpecialClsDto extends BaseDto implements Serializable {
	
	private static final long serialVersionUID = PdmsProductSpecialClsDto.class.getName().hashCode();
	
	/** 主键ID */
	@Id
	private Integer specialClsId;
	
	/** 产品险种代码 */
	private Integer prodRiskId;
	
	/** 序号 */
	private Integer serialNo;
	
	/** 特约代码 */
	private String clauseCode;
	
	/** 特约名称 */
	private String clauseName;
	
	/** 特约内容 */
	private String clauseContext;
	
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
	
	/** 险种代码 */
	@Transient
	private String riskCode;
	
	
	/**
	 * 获取属性主键ID的值
	 */
	public Integer getSpecialClsId() {
	    return this.specialClsId;
	}
	
	/**
	 * 设置属性主键ID的值
	 */
	public void setSpecialClsId(Integer specialClsId) {
	    this.specialClsId = specialClsId;
	}
	
	/**
	 * 获取属性产品代码的值
	 */
	
	public Integer getProdRiskId() {
		return prodRiskId;
	}
	
	/**
	 * 设置属性产品代码的值
	 */
	public void setProdRiskId(Integer prodRiskId) {
		this.prodRiskId = prodRiskId;
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
	 * 获取属性特约代码的值
	 */
	public String getClauseCode() {
	    return this.clauseCode;
	}
	
	/**
	 * 设置属性特约代码的值
	 */
	public void setClauseCode(String clauseCode) {
	    this.clauseCode = clauseCode;
	}
	
	/**
	 * 获取属性特约名称的值
	 */
	public String getClauseName() {
	    return this.clauseName;
	}
	
	/**
	 * 设置属性特约名称的值
	 */
	public void setClauseName(String clauseName) {
	    this.clauseName = clauseName;
	}
	
	/**
	 * 获取属性特约内容的值
	 */
	public String getClauseContext() {
	    return this.clauseContext;
	}
	
	/**
	 * 设置属性特约内容的值
	 */
	public void setClauseContext(String clauseContext) {
	    this.clauseContext = clauseContext;
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
	
	/** 险种代码 */
	public String getRiskCode() {
		return riskCode;
	}
	
	/** 险种代码 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
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