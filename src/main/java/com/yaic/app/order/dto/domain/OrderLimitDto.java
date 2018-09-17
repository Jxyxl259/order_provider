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

@Table(name = "t_order_limit")
public class OrderLimitDto implements Serializable {
    
    private static final long serialVersionUID = OrderLimitDto.class.getName().hashCode();
    
    /** 用户id */ 
    @Transient
    private BigInteger userId;
    
    /** 主键ID */ 
    @Id
    private java.lang.Integer limitId;
    
    /** 订单主表id */ 
    private BigInteger orderMainId;
    
    /** 订单编号 */ 
    private BigInteger orderCode;
    
    /** 序号 */ 
    private java.lang.Integer serialNo;
    
    /** 标的序号 */ 
    private java.lang.Integer itemNo;
    
    /** 险别代码 */ 
    private java.lang.String kindCode;
    
    /** 责任代码 */ 
    private java.lang.String limitCode;
    
    /** 责任名称 */ 
    private java.lang.String limitName;
    
    /** 单位：1-金额；2-天数；3-次数；4-月数 */ 
    private java.lang.String limitType;
    
    /** 币别 */ 
    private java.lang.String currency;
    
    /** 限额数值 */ 
    private java.math.BigDecimal limitValue;
    
    /** 备注 */ 
    private java.lang.String remark;
    
    /** 限额描述 */ 
    private java.lang.String limitDesc;
    
    /** 限额类型 */ 
    private java.lang.String limitClass;
    
    /** 责任日额保险金 */ 
    private java.math.BigDecimal unitLimit;
    
    /** 责任保费 */ 
    private java.math.BigDecimal grossPremium;
    
    /** 累计责任期(天) */ 
    private java.lang.Integer totalLiabPeriod;
    
    /** 每次事故责任期(天) */ 
    private java.lang.Integer eachLiabPeriod;
    
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
     * 设置属性主键ID的值
     */ 
    public void setLimitId(java.lang.Integer limitId) {
        this.limitId = limitId;
    }
    
    /**
     * 获取属性主键ID的值
     */ 
    public java.lang.Integer getLimitId() {
        return this.limitId;
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
     * 设置属性序号的值
     */ 
    public void setSerialNo(java.lang.Integer serialNo) {
        this.serialNo = serialNo;
    }
    
    /**
     * 获取属性序号的值
     */ 
    public java.lang.Integer getSerialNo() {
        return this.serialNo;
    }
    
    /**
     * 设置属性险别代码的值
     */ 
    public void setKindCode(java.lang.String kindCode) {
        this.kindCode = kindCode;
    }
    
    /**
     * 获取属性险别代码的值
     */ 
    public java.lang.String getKindCode() {
        return this.kindCode;
    }
    
    /**
     * 设置属性责任代码的值
     */ 
    public void setLimitCode(java.lang.String limitCode) {
        this.limitCode = limitCode;
    }
    
    /**
     * 获取属性责任代码的值
     */ 
    public java.lang.String getLimitCode() {
        return this.limitCode;
    }
    
    /**
     * 设置属性责任名称的值
     */ 
    public void setLimitName(java.lang.String limitName) {
        this.limitName = limitName;
    }
    
    /**
     * 获取属性责任名称的值
     */ 
    public java.lang.String getLimitName() {
        return this.limitName;
    }
    
    /**
     * 设置属性单位：1-金额；2-天数；3-次数；4-月数的值
     */ 
    public void setLimitType(java.lang.String limitType) {
        this.limitType = limitType;
    }
    
    /**
     * 获取属性单位：1-金额；2-天数；3-次数；4-月数的值
     */ 
    public java.lang.String getLimitType() {
        return this.limitType;
    }
    
    /**
     * 设置属性币别的值
     */ 
    public void setCurrency(java.lang.String currency) {
        this.currency = currency;
    }
    
    /**
     * 获取属性币别的值
     */ 
    public java.lang.String getCurrency() {
        return this.currency;
    }
    
    /**
     * 设置属性限额数值的值
     */ 
    public void setLimitValue(java.math.BigDecimal limitValue) {
        this.limitValue = limitValue;
    }
    
    /**
     * 获取属性限额数值的值
     */ 
    public java.math.BigDecimal getLimitValue() {
        return this.limitValue;
    }
    
    /**
     * 设置属性备注的值
     */ 
    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }
    
    /**
     * 获取属性备注的值
     */ 
    public java.lang.String getRemark() {
        return this.remark;
    }
    
    /**
	 * 获取属性限额描述的值
	 */
	public java.lang.String getLimitDesc() {
		return limitDesc;
	}

	/**
	 * 设置属性限额描述的值
	 */
	public void setLimitDesc(java.lang.String limitDesc) {
		this.limitDesc = limitDesc;
	}

	/**
	 * 获取属性限额类型的值
	 */
	public java.lang.String getLimitClass() {
		return limitClass;
	}

	/**
	 * 设置属性限额类型的值
	 */
	public void setLimitClass(java.lang.String limitClass) {
		this.limitClass = limitClass;
	}

	/**
	 * 获取属性责任日额保险金的值
	 */
	public java.math.BigDecimal getUnitLimit() {
		return unitLimit;
	}

	/**
	 * 设置属性责任日额保险金的值
	 */
	public void setUnitLimit(java.math.BigDecimal unitLimit) {
		this.unitLimit = unitLimit;
	}

	/**
	 * 获取属性责任保费的值
	 */
	public java.math.BigDecimal getGrossPremium() {
		return grossPremium;
	}

	/**
	 * 设置属性责任保费的值
	 */
	public void setGrossPremium(java.math.BigDecimal grossPremium) {
		this.grossPremium = grossPremium;
	}

	/**
	 * 获取属性累计责任期的值
	 */
	public java.lang.Integer getTotalLiabPeriod() {
		return totalLiabPeriod;
	}

	/**
	 * 设置属性累计责任期的值
	 */
	public void setTotalLiabPeriod(java.lang.Integer totalLiabPeriod) {
		this.totalLiabPeriod = totalLiabPeriod;
	}

	/**
	 * 获取属性每次事故责任期的值
	 */
	public java.lang.Integer getEachLiabPeriod() {
		return eachLiabPeriod;
	}

	/**
	 * 设置属性每次事故责任期的值
	 */
	public void setEachLiabPeriod(java.lang.Integer eachLiabPeriod) {
		this.eachLiabPeriod = eachLiabPeriod;
	}
    
    /**
     * 设置属性失效标志:0正常,1作废值的值
     */ 
    public void setInvalidFlag(java.lang.Integer invalidFlag) {
        this.invalidFlag = invalidFlag;
    }
    
    /**
     * 获取属性失效标志:0正常,1作废值的值
     */ 
    public java.lang.Integer getInvalidFlag() {
        return this.invalidFlag;
    }
    
    /**
     * 设置属性创建人的值
     */ 
    public void setCreatedUser(java.lang.String createdUser) {
        this.createdUser = createdUser;
    }
    
    /**
     * 获取属性创建人的值
     */ 
    public java.lang.String getCreatedUser() {
        return this.createdUser;
    }
    
    /**
     * 设置属性创建时间的值
     */ 
    public void setCreatedDate(java.util.Date createdDate) {
        this.createdDate = createdDate;
    }
    
    /**
     * 获取属性创建时间的值
     */ 
    public java.util.Date getCreatedDate() {
        return this.createdDate;
    }
    
    /**
     * 设置属性更新人的值
     */ 
    public void setUpdatedUser(java.lang.String updatedUser) {
        this.updatedUser = updatedUser;
    }
    
    /**
     * 获取属性更新人的值
     */ 
    public java.lang.String getUpdatedUser() {
        return this.updatedUser;
    }
    
    /**
     * 设置属性更新时间的值
     */ 
    public void setUpdatedDate(java.util.Date updatedDate) {
        this.updatedDate = updatedDate;
    }
    
    /**
     * 获取属性更新时间的值
     */ 
    public java.util.Date getUpdatedDate() {
        return this.updatedDate;
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