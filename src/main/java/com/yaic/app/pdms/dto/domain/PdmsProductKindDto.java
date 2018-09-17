/*
 * Created By lujicong (2017-06-29 10:39:42)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.pdms.dto.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
 * 产品险别表
 */
@Table(name = "t_pdms_product_kind")
public class PdmsProductKindDto extends BaseDto implements Serializable {
	
	private static final long serialVersionUID = PdmsProductKindDto.class.getName().hashCode();
	
	/** 产品代码 */
	@Id
	private Integer prodKindId;
	
	/** 产品险种主键ID */
	private Integer prodRiskId;
	
	/** 序号 */
	private Integer serialNo;
	
	/** 险别代码 */
	private String kindCode;
	
	/** 险别名称 */
	@Transient
	private String kindName;
	
	/** 主/附加险标识 */
	@Transient
	private String kindInd;
	
	/** 币别 */
	private String currency;
	
	/** 保额 */
	private java.math.BigDecimal amount;
	
	/** 费率 */
	private java.math.BigDecimal rate;
	
	/** 保费 */
	private java.math.BigDecimal premium;
	
	/** 是否计入总保额标志:0-否,1-是 */
	private String calculateInd;
	
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
	
	/** 产品代码 */
	@Transient
	private Integer prodId;
	
	/** 险种代码 */
	@Transient
	private String riskCode;
	
	@Transient
	private String kindType;
	
	/**
	 * 产品限额列表
	 */
	@Transient
	private List<PdmsProductLimitDto> productLimitList;
	
	/**
	 * 产品免赔列表
	 */
	@Transient
	private List<PdmsProductDeductibleDto> productDeductibleList;
	
	/**
	 * 产品赔付列表
	 */
	@Transient
	private List<PdmsProductClaimDto> productClaimList;
	
	@Transient
	private List<PdmsClauseDto> productClause;
	
	
	/**
	 * 获取属性产品代码的值
	 */
	public Integer getProdKindId() {
	    return this.prodKindId;
	}
	
	/**
	 * 设置属性产品代码的值
	 */
	public void setProdKindId(Integer prodKindId) {
	    this.prodKindId = prodKindId;
	}
	
	/**
	 * 获取属性产品险种主键ID的值
	 */
	public Integer getProdRiskId() {
	    return this.prodRiskId;
	}
	
	/**
	 * 设置属性产品险种主键ID的值
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
	
	
	public String getKindName() {
		return kindName;
	}
	
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}
	/**
	 * 设置主险/附加险标识的值
	 */
	public String getKindInd() {
		return kindInd;
	}
	
	public void setKindInd(String kindInd) {
		this.kindInd = kindInd;
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
	 * 获取属性保额的值
	 */
	public java.math.BigDecimal getAmount() {
	    return this.amount;
	}
	
	/**
	 * 设置属性保额的值
	 */
	public void setAmount(java.math.BigDecimal amount) {
	    this.amount = amount;
	}
	
	/**
	 * 获取属性费率的值
	 */
	public java.math.BigDecimal getRate() {
	    return this.rate;
	}
	
	/**
	 * 设置属性费率的值
	 */
	public void setRate(java.math.BigDecimal rate) {
	    this.rate = rate;
	}
	
	/**
	 * 获取属性保费的值
	 */
	public java.math.BigDecimal getPremium() {
	    return this.premium;
	}
	
	/**
	 * 设置属性保费的值
	 */
	public void setPremium(java.math.BigDecimal premium) {
	    this.premium = premium;
	}
	
	/**
	 * 获取属性是否计入总保额标志:0-否,1-是的值
	 */
	public String getCalculateInd() {
	    return this.calculateInd;
	}
	
	/**
	 * 设置属性是否计入总保额标志:0-否,1-是的值
	 */
	public void setCalculateInd(String calculateInd) {
	    this.calculateInd = calculateInd;
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
	
	public Integer getProdId() {
		return prodId;
	}
	
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}
	
	public String getRiskCode() {
		return riskCode;
	}
	
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	
	public String getKindType() {
		return kindType;
	}
	
	public void setKindType(String kindType) {
		this.kindType = kindType;
	}
	
	/**
	 * 产品限额列表
	 */
	public List<PdmsProductLimitDto> getProductLimitList() {
		return productLimitList;
	}
	
	/**
	 * 产品限额列表
	 */
	public void setProductLimitList(List<PdmsProductLimitDto> productLimitList) {
		this.productLimitList = productLimitList;
	}
	
	/**
	 * 产品免赔列表
	 */
	public List<PdmsProductDeductibleDto> getProductDeductibleList() {
		return productDeductibleList;
	}
	
	/**
	 * 产品免赔列表
	 */
	public void setProductDeductibleList(
			List<PdmsProductDeductibleDto> productDeductibleList) {
		this.productDeductibleList = productDeductibleList;
	}
	
	/**
	 * 产品赔付列表
	 */
	public List<PdmsProductClaimDto> getProductClaimList() {
		return productClaimList;
	}
	
	/**
	 * 产品赔付列表
	 */
	public void setProductClaimList(List<PdmsProductClaimDto> productClaimList) {
		this.productClaimList = productClaimList;
	}
	
	public List<PdmsClauseDto> getProductClause() {
		return productClause;
	}
	
	public void setProductClause(List<PdmsClauseDto> productClause) {
		this.productClause = productClause;
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