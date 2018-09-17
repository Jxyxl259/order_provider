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

@Table(name = "t_order_deductible")
public class OrderDeductibleDto implements Serializable {
    
    private static final long serialVersionUID = OrderDeductibleDto.class.getName().hashCode();
    
    /** 用户id */ 
    @Transient
    private BigInteger userId;
    
    /** 主键ID */ 
    @Id
    private java.lang.Integer deductibleId;
    
    /** 订单主表id */ 
    private BigInteger orderMainId;
    
    /** 订单编号 */ 
    private BigInteger orderCode;
    
    /** 序号 */ 
    private java.lang.Integer serialNo;
    
    /** 险别代码 */ 
    private java.lang.String kindCode;
    
    /** 责任代码 */ 
    private java.lang.String liabCode;
    
    /** 免赔级别 */ 
    private java.lang.String deductibleLevel;
    
    /** 免赔代码 */ 
    private java.lang.String deductibleCode;
    
    /** 免赔名称 */ 
    private java.lang.String deductibleName;
    
    /** 免赔类型 */ 
    private java.lang.String deductibleType;
    
    /** 币别 */ 
    private java.lang.String currency;
    
    /** 免赔金额 */ 
    private java.math.BigDecimal deductible;
    
    /** 免赔率 */ 
    private java.math.BigDecimal deductibleRate;
    
    /** 原始免赔金额*/ 
    private java.math.BigDecimal originDeductible;
    
    /** 原始免赔率 */ 
    private java.math.BigDecimal originDeductibleRate;
    
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
    
    /** 标的序号 */ 
    private java.lang.Integer itemNo;
    
    /** 免责期 */ 
    private java.lang.Integer waitingPeriod;
    
    
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
    public java.lang.Integer getDeductibleId() {
		return deductibleId;
	}

    /**
     * 设置属性主键ID的值
     */ 
	public void setDeductibleId(java.lang.Integer deductibleId) {
		this.deductibleId = deductibleId;
	}

	/**
     * 设置属性订单主表id的值
     */ 
    public void setOrderMainId(BigInteger orderMainId) {
        this.orderMainId = orderMainId;
    }
    
    /**
     * 获取属性订单主表id的值
     */ 
    public BigInteger getOrderMainId() {
        return orderMainId;
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
	 * 获取属性责任代码的值
	 */ 
	public java.lang.String getLiabCode() {
		return liabCode;
	}

	/**
	 * 设置属性责任代码的值
	 */ 
	public void setLiabCode(java.lang.String liabCode) {
		this.liabCode = liabCode;
	}

	/**
	 * 获取属性免赔级别的值
	 */ 
	public java.lang.String getDeductibleLevel() {
		return deductibleLevel;
	}

	/**
	 * 设置属性免赔级别的值
	 */ 
	public void setDeductibleLevel(java.lang.String deductibleLevel) {
		this.deductibleLevel = deductibleLevel;
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
	 * 获取属性免赔名称的值
	 */ 
	public java.lang.String getDeductibleName() {
		return deductibleName;
	}

	/**
	 * 设置属性免赔名称的值
	 */ 
	public void setDeductibleName(java.lang.String deductibleName) {
		this.deductibleName = deductibleName;
	}

	/**
	 * 获取属性免赔类型的值
	 */ 
	public java.lang.String getDeductibleType() {
		return deductibleType;
	}

	/**
	 * 设置属性免赔类型的值
	 */ 
	public void setDeductibleType(java.lang.String deductibleType) {
		this.deductibleType = deductibleType;
	}

	/**
	 * 获取属性币别的值
	 */ 
	public java.lang.String getCurrency() {
		return currency;
	}

	/**
	 * 设置属性币别的值
	 */ 
	public void setCurrency(java.lang.String currency) {
		this.currency = currency;
	}

	/**
	 * 获取属性免赔金额的值
	 */ 
	public java.math.BigDecimal getDeductible() {
		return deductible;
	}

	/**
	 * 设置属性免赔金额的值
	 */ 
	public void setDeductible(java.math.BigDecimal deductible) {
		this.deductible = deductible;
	}

	/**
	 * 获取属性免赔率的值
	 */ 
	public java.math.BigDecimal getDeductibleRate() {
		return deductibleRate;
	}

	/**
	 * 设置属性免赔率的值
	 */ 
	public void setDeductibleRate(java.math.BigDecimal deductibleRate) {
		this.deductibleRate = deductibleRate;
	}

	/**
	 * 获取属性原始免赔金额的值
	 */ 
	public java.math.BigDecimal getOriginDeductible() {
		return originDeductible;
	}

	/**
	 * 设置属性原始免赔金额的值
	 */ 
	public void setOriginDeductible(java.math.BigDecimal originDeductible) {
		this.originDeductible = originDeductible;
	}

	/**
	 * 获取属性原始免赔率的值
	 */ 
	public java.math.BigDecimal getOriginDeductibleRate() {
		return originDeductibleRate;
	}

	/**
	 * 设置属性原始免赔率的值
	 */ 
	public void setOriginDeductibleRate(java.math.BigDecimal originDeductibleRate) {
		this.originDeductibleRate = originDeductibleRate;
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
     * 获取属性免责期的值
     */
	public java.lang.Integer getWaitingPeriod() {
		return waitingPeriod;
	}

	/**
     * 设置属性免责期的值
     */
	public void setWaitingPeriod(java.lang.Integer waitingPeriod) {
		this.waitingPeriod = waitingPeriod;
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