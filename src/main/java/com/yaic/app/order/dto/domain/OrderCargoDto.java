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

@Table(name = "t_order_cargo")
public class OrderCargoDto implements Serializable {
    
    private static final long serialVersionUID = OrderCargoDto.class.getName().hashCode();
    /** 用户id */ 
    @Transient
    private BigInteger userId;
    
    /** 货运标的Id */ 
    @Id
    private java.lang.Integer cargoId;
    
    /** 订单主表id */ 
    private BigInteger orderMainId;
    
    /** 订单编号 */ 
    private BigInteger orderCode;
    
    /** 币别 */ 
    private java.lang.String currency;
    
    /** 运输方式 */ 
    private java.lang.String conveyanceType;
    
    /** 运输工具编码 */ 
    private java.lang.String conveyanceCode;
    
    /** 运输工具名称 */ 
    private java.lang.String conveyanceName;
    
    /** 航程描述 */ 
    private java.lang.String voyageDesc;
    
    /** 起运日期 */ 
    private java.util.Date startDate;
    
    /** 启始地，省市区 */ 
    private java.lang.String startSiteCode;
    
    /** 目的地，省市区 */ 
    private java.lang.String targetSiteCode;
    
    /** 中转地，省市区 */ 
    private java.lang.String viaSiteCode;
    
    /** 车牌号 */ 
    private java.lang.String licenseNo;
    
    /** 发票号 */ 
    private java.lang.String invoiceNo;
    
    /** 货运单号 */ 
    private java.lang.String blno;
    
    /** 责任范围 */ 
    private java.lang.String scopeCover;
    
    /** 货物运输装载方式 */ 
    private java.lang.String cargoLoadMethod;
    
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
     * 设置属性货运标的Id的值
     */ 
    public void setCargoId(java.lang.Integer cargoId) {
        this.cargoId = cargoId;
    }
    
    /**
     * 获取属性货运标的Id的值
     */ 
    public java.lang.Integer getCargoId() {
        return this.cargoId;
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
     * 设置属性运输方式的值
     */ 
    public void setConveyanceType(java.lang.String conveyanceType) {
        this.conveyanceType = conveyanceType;
    }
    
    /**
     * 获取属性运输方式的值
     */ 
    public java.lang.String getConveyanceType() {
        return this.conveyanceType;
    }
    
    /**
     * 设置属性运输工具编码的值
     */ 
    public void setConveyanceCode(java.lang.String conveyanceCode) {
        this.conveyanceCode = conveyanceCode;
    }
    
    /**
     * 获取属性运输工具编码的值
     */ 
    public java.lang.String getConveyanceCode() {
        return this.conveyanceCode;
    }
    
    /**
     * 设置属性运输工具名称的值
     */ 
    public void setConveyanceName(java.lang.String conveyanceName) {
        this.conveyanceName = conveyanceName;
    }
    
    /**
     * 获取属性运输工具名称的值
     */ 
    public java.lang.String getConveyanceName() {
        return this.conveyanceName;
    }
    
    /**
     * 设置属性航程描述的值
     */ 
    public void setVoyageDesc(java.lang.String voyageDesc) {
        this.voyageDesc = voyageDesc;
    }
    
    /**
     * 获取属性航程描述的值
     */ 
    public java.lang.String getVoyageDesc() {
        return this.voyageDesc;
    }
    
    /**
     * 设置属性起运日期的值
     */ 
    public void setStartDate(java.util.Date startDate) {
        this.startDate = startDate;
    }
    
    /**
     * 获取属性起运日期的值
     */ 
    public java.util.Date getStartDate() {
        return this.startDate;
    }
    
    /**
     * 设置属性启始地，省市区的值
     */ 
    public void setStartSiteCode(java.lang.String startSiteCode) {
        this.startSiteCode = startSiteCode;
    }
    
    /**
     * 获取属性启始地，省市区的值
     */ 
    public java.lang.String getStartSiteCode() {
        return this.startSiteCode;
    }
    
    /**
     * 设置属性目的地，省市区的值
     */ 
    public void setTargetSiteCode(java.lang.String targetSiteCode) {
        this.targetSiteCode = targetSiteCode;
    }
    
    /**
     * 获取属性目的地，省市区的值
     */ 
    public java.lang.String getTargetSiteCode() {
        return this.targetSiteCode;
    }
    
    /**
     * 设置属性中转地，省市区的值
     */ 
    public void setViaSiteCode(java.lang.String viaSiteCode) {
        this.viaSiteCode = viaSiteCode;
    }
    
    /**
     * 获取属性中转地，省市区的值
     */ 
    public java.lang.String getViaSiteCode() {
        return this.viaSiteCode;
    }
    
    /**
     * 设置属性车牌号的值
     */ 
    public void setLicenseNo(java.lang.String licenseNo) {
        this.licenseNo = licenseNo;
    }
    
    /**
     * 获取属性车牌号的值
     */ 
    public java.lang.String getLicenseNo() {
        return this.licenseNo;
    }
    
    /**
     * 设置属性发票号的值
     */ 
    public void setInvoiceNo(java.lang.String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }
    
    /**
     * 获取属性发票号的值
     */ 
    public java.lang.String getInvoiceNo() {
        return this.invoiceNo;
    }
    
	 /**
     * 获取货运单号的值
     */ 
	public java.lang.String getBlno() {
		return blno;
	}
	
	/**
     * 设置货运单号的值
     */ 
	public void setBlno(java.lang.String blno) {
		this.blno = blno;
	}

	/**
     * 设置属性责任范围的值
     */ 
    public void setScopeCover(java.lang.String scopeCover) {
        this.scopeCover = scopeCover;
    }
    
    /**
     * 获取属性责任范围的值
     */ 
    public java.lang.String getScopeCover() {
        return this.scopeCover;
    }
    
    /**
     * 设置属性货物运输装载方式的值
     */ 
    public void setCargoLoadMethod(java.lang.String cargoLoadMethod) {
        this.cargoLoadMethod = cargoLoadMethod;
    }
    
    /**
     * 获取属性货物运输装载方式的值
     */ 
    public java.lang.String getCargoLoadMethod() {
        return this.cargoLoadMethod;
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