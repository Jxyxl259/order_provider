/*
 * Created By lujicong (2017-06-19 10:59:37)
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
 * 方案产品关联表
 */
@Table(name = "t_pdms_solution_product")
public class PdmsSolutionProductDto extends BaseDto implements Serializable {
	
	private static final long serialVersionUID = PdmsSolutionProductDto.class.getName().hashCode();
	
	/** 主键ID */
	@Id
	private Integer solutionProdId;
	
	/** 方案主键ID */
	private Integer solutionId;
	
	/** 产品主键ID */
	private Integer prodId;    
	/** 产品名称**/
	@Transient
	private String prodName;
	
	/** 销售费用ID */
	private String salesFeeId;
	
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
	
	@Transient
	private String prodCode;
	
	
	/**
	 * 获取属性主键ID的值
	 */
	public Integer getSolutionProdId() {
	    return this.solutionProdId;
	}
	
	/**
	 * 设置属性主键ID的值
	 */
	public void setSolutionProdId(Integer solutionProdId) {
	    this.solutionProdId = solutionProdId;
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
	 * 获取属性产品主键ID的值
	 */
	public Integer getProdId() {
	    return this.prodId;
	}
	
	/**
	 * 设置属性产品主键ID的值
	 */
	public void setProdId(Integer prodId) {
	    this.prodId = prodId;
	}
	
	/**
	 * 获取属性产品名称的值
	 */
	public String getProdName() {
		return prodName;
	}
	/**
	 * 设置属性产品名称的值
	 */
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	
	/**
	 * 获取属性销售费用ID的值
	 */
	public String getSalesFeeId() {
	    return this.salesFeeId;
	}
	
	/**
	 * 设置属性销售费用ID的值
	 */
	public void setSalesFeeId(String salesFeeId) {
	    this.salesFeeId = salesFeeId;
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
	
	public String getProdCode() {
		return prodCode;
	}
	
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
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