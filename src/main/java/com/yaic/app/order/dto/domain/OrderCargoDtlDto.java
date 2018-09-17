package com.yaic.app.order.dto.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Table(name = "t_order_cargo_dtl")
public class OrderCargoDtlDto implements Serializable {
    
    private static final long serialVersionUID = OrderCargoDtlDto.class.getName().hashCode();
    /** 用户id */ 
    @Transient
    private BigInteger userId;
    
    /** 货运标的物Id */ 
    @Id
    private java.lang.Integer cargoDtlId;
    
    /** 订单主表id */ 
    private BigInteger orderMainId;
    
    /** 订单编号 */ 
    private BigInteger orderCode;
    
    /** 标的物序号 */ 
    private java.lang.Integer itemDetailNo;
    
    /** 标的物代码 */ 
    private java.lang.String itemDetailCode;
    
    /** 标的物名称 */ 
    private java.lang.String itemDetailName;
    
    /** 标的物明细名称 */ 
    private java.lang.String itemDetailList;
    
    /** 备注 */ 
    private java.lang.String remark;
    
    /** 数量 */ 
    private java.math.BigDecimal quantity;
    
    /** 包装 */ 
    private java.lang.String packing;
    
    /** 保险总额 */ 
    private BigDecimal sumInsured;
    
    /** 是否有效:0正常,1作废值 */ 
    private Integer invalidFlag;
    
    /** 创建人 */ 
    private java.lang.String createdUser;
    
    /** 创建时间 */ 
    private java.util.Date createdDate;
    
    /** 更新人 */ 
    private java.lang.String updatedUser;
    
    /** 更新时间 */ 
    private java.util.Date updatedDate;
    
    
    public BigInteger getUserId() {
		return userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

	public Integer getInvalidFlag() {
		return invalidFlag;
	}

	public void setInvalidFlag(Integer invalidFlag) {
		this.invalidFlag = invalidFlag;
	}

	/**
     * 设置属性货运标的物Id的值
     */ 
    public void setCargoDtlId(java.lang.Integer cargoDtlId) {
        this.cargoDtlId = cargoDtlId;
    }
    
    /**
     * 获取属性货运标的物Id的值
     */ 
    public java.lang.Integer getCargoDtlId() {
        return this.cargoDtlId;
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
     * 设置属性订单编号的值
     */ 
    public BigInteger getOrderCode() {
        return orderCode;
    }
    
    /**
     * 获取属性订单编号的值
     */ 
    public void setOrderCode(BigInteger orderCode) {
        this.orderCode = orderCode;
    }
    
    /**
     * 设置属性标的物序号的值
     */ 
    public void setItemDetailNo(java.lang.Integer itemDetailNo) {
        this.itemDetailNo = itemDetailNo;
    }
    
    /**
     * 获取属性标的物序号的值
     */ 
    public java.lang.Integer getItemDetailNo() {
        return this.itemDetailNo;
    }
    
    /**
     * 设置属性标的物代码的值
     */ 
    public void setItemDetailCode(java.lang.String itemDetailCode) {
        this.itemDetailCode = itemDetailCode;
    }
    
    /**
     * 获取属性标的物代码的值
     */ 
    public java.lang.String getItemDetailCode() {
        return this.itemDetailCode;
    }
    
    /**
     * 设置属性标的物名称的值
     */ 
    public void setItemDetailName(java.lang.String itemDetailName) {
        this.itemDetailName = itemDetailName;
    }
    
    /**
     * 获取属性标的物名称的值
     */ 
    public java.lang.String getItemDetailName() {
        return this.itemDetailName;
    }
    
    /**
     * 设置属性标的物明细名称的值
     */ 
    public void setItemDetailList(java.lang.String itemDetailList) {
        this.itemDetailList = itemDetailList;
    }
    
    /**
     * 获取属性标的物明细名称的值
     */ 
    public java.lang.String getItemDetailList() {
        return this.itemDetailList;
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
     * 设置属性数量的值
     */ 
    public void setQuantity(java.math.BigDecimal quantity) {
        this.quantity = quantity;
    }
    
    /**
     * 获取属性数量的值
     */ 
    public java.math.BigDecimal getQuantity() {
        return this.quantity;
    }
    
    /**
     * 设置属性包装的值
     */ 
    public void setPacking(java.lang.String packing) {
        this.packing = packing;
    }
    
    /**
     * 获取属性包装的值
     */ 
    public java.lang.String getPacking() {
        return this.packing;
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
    
    /**
     *  保险总额
     */ 
    public BigDecimal getSumInsured() {
    	return sumInsured;
    }
    /**
     *  保险总额
     */ 
    public void setSumInsured(BigDecimal sumInsured) {
    	this.sumInsured = sumInsured;
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