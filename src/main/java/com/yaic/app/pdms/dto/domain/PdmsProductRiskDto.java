/*
 * Created By lujicong (2017-06-29 10:39:41)
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
 * 产品险种表
 */
@Table(name = "t_pdms_product_risk")
public class PdmsProductRiskDto extends BaseDto implements Serializable {
	
	private static final long serialVersionUID = PdmsProductRiskDto.class.getName().hashCode();
	
	/** 主键ID */
	@Id
	private Integer prodRiskId;
	
	/** 产品代码 */
	private Integer prodId;
	
	/** 险种代码 */
	private String riskCode;
	
	/** 险种名称 */
	@Transient
	private String riskName;
	
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
	 * 产品险别集合
	 */
	@Transient
	private List<PdmsProductKindDto> productKindList;
	
	/** 产品特约 */
	@Transient
	private List<PdmsProductSpecialClsDto> productSpecialClsList;
	
	/** 定额类型 */
    private String rationType;
    
    
	/**
	 * 获取属性主键ID的值
	 */
	public Integer getProdRiskId() {
	    return this.prodRiskId;
	}
	
	/**
	 * 设置属性主键ID的值
	 */
	public void setProdRiskId(Integer prodRiskId) {
	    this.prodRiskId = prodRiskId;
	}
	 
	public Integer getProdId() {
		return prodId;
	}
	
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
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
	
	
	public String getRiskName() {
		return riskName;
	}
	
	public void setRiskName(String riskName) {
		this.riskName = riskName;
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
	
	/**
	 * 产品险别集合
	 */
	public List<PdmsProductKindDto> getProductKindList() {
		return productKindList;
	}
	
	/**
	 * 产品险别集合
	 */
	public void setProductKindList(List<PdmsProductKindDto> productKindList) {
		this.productKindList = productKindList;
	}
	
	/** 产品特约 */
	public List<PdmsProductSpecialClsDto> getProductSpecialClsList() {
		return productSpecialClsList;
	}
	
	/** 产品特约 */
	public void setProductSpecialClsList(List<PdmsProductSpecialClsDto> productSpecialClsList) {
		this.productSpecialClsList = productSpecialClsList;
	}
	
	/**
     * 获取定额类型的值
     */
    public String getRationType() {
		return rationType;
	}
    
    /**
     * 设置定额类型的值
     */
	public void setRationType(String rationType) {
		this.rationType = rationType;
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