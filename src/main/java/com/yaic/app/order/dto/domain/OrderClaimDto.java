/*
 * Created By lujicong (2016-05-20 22:23:33)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2016
 */
package com.yaic.app.order.dto.domain;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Table(name = "t_order_claim")
public class OrderClaimDto implements Serializable {
    
    private static final long serialVersionUID = OrderClaimDto.class.getName().hashCode();
    
    /** 用户id */ 
    @Transient
    private BigInteger userId;
    
    /** 主键ID */ 
    @Id
    private java.lang.Integer claimId;
    
    /** 订单主表id */ 
    private BigInteger orderMainId;
    
    /** 订单编号 */ 
    private BigInteger orderCode;
    
    /** 序号 */ 
    private java.lang.Integer serialNo;
    
    /** 标的序号 */ 
    private java.lang.Integer itemNo;
    
    /** 段序 */ 
    private java.lang.String sectionNo;
    
    /** 险别代码 */ 
    private java.lang.String kindCode;
    
    /** 赔付标识:0-标准赔付;1-级距赔付;2-医保赔付 */ 
    private java.lang.String claimInd;
    
    /** 限额代码 */ 
    private java.lang.String limitCode;
    
    /** 免赔代码 */ 
    private java.lang.String deductibleCode;
    
    /** 免赔额 */ 
    private java.math.BigDecimal deductible;
    
    /** 费用起线 */ 
    private java.math.BigDecimal costStart;
    
    /** 费用止线 */ 
    private java.math.BigDecimal costEnd;
    
    /** 赔付比率 */ 
    private java.math.BigDecimal claimRate;
    
    /** 备注*/ 
    private java.lang.String remark;
    
    /** 失效标志:0正常,1作废值 */ 
    private java.lang.Integer invalidFlag;
    
    /** 创建人 */ 
    private java.lang.String createdUser;
    
    /** 创建时间 */ 
    private java.util.Date createdDate;
    
    /** 更新人 */ 
    private java.lang.String updatedUser;
    
    /** 更新时间 */ 
    private java.util.Date updatedDate;

    
    
	/**
	 * 获取属性用户id的值
	 */
	public BigInteger getUserId() {
		return userId;
	}

	/**
	 * 设置属性用户id的值
	 */
	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

	/**
	 * 获取属性主键ID的值
	 */
	public java.lang.Integer getClaimId() {
		return claimId;
	}

	/**
	 * 设置属性主键ID的值
	 */
	public void setClaimId(java.lang.Integer claimId) {
		this.claimId = claimId;
	}

	/**
	 * 获取属性订单主表id的值
	 */
	public BigInteger getOrderMainId() {
		return orderMainId;
	}

	/**
	 * 设置属性订单主表id的值
	 */
	public void setOrderMainId(BigInteger orderMainId) {
		this.orderMainId = orderMainId;
	}

	/**
	 * 获取属性订单编号的值
	 */
	public BigInteger getOrderCode() {
		return orderCode;
	}

	/**
	 * 设置属性订单编号的值
	 */
	public void setOrderCode(BigInteger orderCode) {
		this.orderCode = orderCode;
	}

	/**
	 * 获取属性序号的值
	 */
	public java.lang.Integer getSerialNo() {
		return serialNo;
	}

	/**
	 * 设置属性序号的值
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	}

	/**
	 * 获取属性标的序号的值
	 */
	public java.lang.Integer getItemNo() {
		return itemNo;
	}

	/**
	 * 设置属性标的序号的值
	 */
	public void setItemNo(java.lang.Integer itemNo) {
		this.itemNo = itemNo;
	}

	/**
	 * 获取属性段序的值
	 */
	public java.lang.String getSectionNo() {
		return sectionNo;
	}

	/**
	 * 设置属性段序的值
	 */
	public void setSectionNo(java.lang.String sectionNo) {
		this.sectionNo = sectionNo;
	}

	/**
	 * 获取属性险别代码的值
	 */
	public java.lang.String getKindCode() {
		return kindCode;
	}

	/**
	 * 设置属性险别代码的值
	 */
	public void setKindCode(java.lang.String kindCode) {
		this.kindCode = kindCode;
	}

	/**
	 * 获取属性赔付标识:0-标准赔付;1-级距赔付;2-医保赔付的值
	 */
	public java.lang.String getClaimInd() {
		return claimInd;
	}

	/**
	 * 设置属性赔付标识:0-标准赔付;1-级距赔付;2-医保赔付的值
	 */
	public void setClaimInd(java.lang.String claimInd) {
		this.claimInd = claimInd;
	}

	/**
	 * 获取属性限额代码的值
	 */
	public java.lang.String getLimitCode() {
		return limitCode;
	}

	/**
	 * 设置属性限额代码的值
	 */
	public void setLimitCode(java.lang.String limitCode) {
		this.limitCode = limitCode;
	}

	/**
	 * 获取属性免赔代码的值
	 */
	public java.lang.String getDeductibleCode() {
		return deductibleCode;
	}

	/**
	 * 设置属性免赔代码的值
	 */
	public void setDeductibleCode(java.lang.String deductibleCode) {
		this.deductibleCode = deductibleCode;
	}

	/**
	 * 获取属性免赔额的值
	 */
	public java.math.BigDecimal getDeductible() {
		return deductible;
	}

	/**
	 * 设置属性免赔额的值
	 */
	public void setDeductible(java.math.BigDecimal deductible) {
		this.deductible = deductible;
	}

	/**
	 * 获取属性费用起线的值
	 */
	public java.math.BigDecimal getCostStart() {
		return costStart;
	}

	/**
	 * 设置属性费用起线的值
	 */
	public void setCostStart(java.math.BigDecimal costStart) {
		this.costStart = costStart;
	}

	/**
	 * 获取属性费用止线的值
	 */
	public java.math.BigDecimal getCostEnd() {
		return costEnd;
	}

	/**
	 * 设置属性费用止线的值
	 */
	public void setCostEnd(java.math.BigDecimal costEnd) {
		this.costEnd = costEnd;
	}

	/**
	 * 获取属性赔付比率的值
	 */
	public java.math.BigDecimal getClaimRate() {
		return claimRate;
	}

	/**
	 * 设置属性赔付比率的值
	 */
	public void setClaimRate(java.math.BigDecimal claimRate) {
		this.claimRate = claimRate;
	}

	/**
	 * 获取属性备注的值
	 */
	public java.lang.String getRemark() {
		return remark;
	}

	/**
	 * 设置属性备注的值
	 */
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	/**
	 * 获取属性失效标志:0正常,1作废值的值
	 */
	public java.lang.Integer getInvalidFlag() {
		return invalidFlag;
	}

	/**
	 * 设置属性失效标志:0正常,1作废值的值
	 */
	public void setInvalidFlag(java.lang.Integer invalidFlag) {
		this.invalidFlag = invalidFlag;
	}

	/**
	 * 获取属性创建人的值
	 */
	public java.lang.String getCreatedUser() {
		return createdUser;
	}

	/**
	 * 设置属性创建人的值
	 */
	public void setCreatedUser(java.lang.String createdUser) {
		this.createdUser = createdUser;
	}

	/**
	 * 获取属性创建时间的值
	 */
	public java.util.Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * 设置属性创建时间的值
	 */
	public void setCreatedDate(java.util.Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * 获取属性更新人的值
	 */
	public java.lang.String getUpdatedUser() {
		return updatedUser;
	}

	/**
	 * 设置属性更新人的值
	 */
	public void setUpdatedUser(java.lang.String updatedUser) {
		this.updatedUser = updatedUser;
	}

	/**
	 * 获取属性更新时间的值
	 */
	public java.util.Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * 设置属性更新时间的值
	 */
	public void setUpdatedDate(java.util.Date updatedDate) {
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