/*
 * Created By lujicong (2015-12-21 16:02:19)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2015
 */
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

@Table(name = "t_shop_order_goods")
public class ShopOrderGoodsDto implements Serializable {
    
    private static final long serialVersionUID = ShopOrderGoodsDto.class.getName().hashCode();
    
    /** 用户id */ 
    @Transient
    private BigInteger userId;
    
    /** 订单编号，取自order_info的order_code */ 
    @Id
    private BigInteger orderCode;
    
    /** 商品的id */ 
    @Id
    private java.lang.String goodsId;
    
    /** 商品货号(与orderMain表中的order_main_id对应) */ 
    private BigInteger goodsNo;
    
    /** 商品名称 */ 
    private java.lang.String goodsName;
    
    /** 商品价格 */ 
    private BigDecimal goodsPrice;
    
    /** 商品的购买数量,默认1 */ 
    private java.lang.Integer goodsNumber;
    
    /** 商品类型，1：订单主体（保险类）；2：商品；3：礼品 */ 
    private java.lang.String goodsType;
    
	/**保费变化量*/
	private java.lang.Double changePremium;
    
    /** 创建人 */ 
    private java.lang.String createdUser;
    
    /** 创建时间 */ 
    private java.util.Date createdDate;
    
    /** 更新人 */ 
    private java.lang.String updatedUser;
    
    /** 更新时间 */ 
    private java.util.Date updatedDate;
    
    /** 是否有效:0正常,1作废值 */ 
    private Integer invalidFlag;
    
    /**
     * 设置属性用户id的值
     */ 
    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }
    
    /**
     * 获取属性用户id的值
     */ 
    public BigInteger getUserId() {
        return this.userId;
    }
    
    /**
     * 设置属性订单编号，取自order_info的order_code的值
     */ 
    public void setOrderCode(BigInteger orderCode) {
        this.orderCode = orderCode;
    }
    
    /**
     * 获取属性订单编号，取自order_info的order_code的值
     */ 
    public BigInteger getOrderCode() {
        return this.orderCode;
    }
    
    /**
     * 设置属性商品的id的值
     */ 
    public void setGoodsId(java.lang.String goodsId) {
        this.goodsId = goodsId;
    }
    
    /**
     * 获取属性商品的id的值
     */ 
    public java.lang.String getGoodsId() {
        return this.goodsId;
    }
    
    /**
     * 设置属性商品货号(与orderMain表中的order_main_id对应)的值
     */ 
    public void setGoodsNo(BigInteger goodsNo) {
        this.goodsNo = goodsNo;
    }
    
    /**
     * 获取属性商品货号(与orderMain表中的order_main_id对应)的值
     */
    public BigInteger getGoodsNo() {
        return goodsNo;
    }

    /**
     * 设置属性商品名称的值
     */ 
    public void setGoodsName(java.lang.String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * 获取属性商品名称的值
     */ 
    public java.lang.String getGoodsName() {
        return this.goodsName;
    }
    
    /**
     * 设置属性商品价格的值
     */ 
    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
    
    /**
     * 获取属性商品价格的值
     */ 
    public BigDecimal getGoodsPrice() {
        return this.goodsPrice;
    }
    
    /**
     * 设置属性商品的购买数量,默认1的值
     */ 
    public void setGoodsNumber(java.lang.Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }
    
    /**
     * 获取属性商品的购买数量,默认1的值
     */ 
    public java.lang.Integer getGoodsNumber() {
        return this.goodsNumber;
    }
    
    /**
     * 设置属性商品类型，1：订单主体（保险类）；2：商品；3：礼品的值
     */ 
    public void setGoodsType(java.lang.String goodsType) {
        this.goodsType = goodsType;
    }
    
    /**
     * 获取属性商品类型，1：订单主体（保险类）；2：商品；3：礼品的值
     */ 
    public java.lang.String getGoodsType() {
        return this.goodsType;
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
     * 设置属性是否有效:0正常,1作废值的值
     */ 
    public void setInvalidFlag(Integer invalidFlag) {
        this.invalidFlag = invalidFlag;
    }
    
    /**
     * 获取属性是否有效:0正常,1作废值的值
     */ 
    public Integer getInvalidFlag() {
        return this.invalidFlag;
    }
    
	/**
	 * 设置属性保费变化量的值
	 */ 
	public java.lang.Double getChangePremium() {
		return changePremium;
	}
	
	/**
	 * 设置属性保费变化量的值
	 */ 
	public void setChangePremium(java.lang.Double changePremium) {
		this.changePremium = changePremium;
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