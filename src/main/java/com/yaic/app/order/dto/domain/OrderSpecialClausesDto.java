/*
 * Created By lujicong (2016-05-20 10:59:27)
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

@Table(name = "t_order_special_clauses")
public class OrderSpecialClausesDto implements Serializable {
    
    private static final long serialVersionUID = OrderSpecialClausesDto.class.getName().hashCode();
    
    /** 用户id */ 
    @Transient
    private BigInteger userId;
    
    /** 主键ID */ 
    @Id
    private java.lang.Integer specialClausesId;
    
    /** 订单主表id */ 
    private BigInteger orderMainId;
    
    /** 订单编号 */ 
    private BigInteger orderCode;
    
    /** 序号 */ 
    private java.lang.Integer serialNo;
    
    /** 条款代码 */ 
    private java.lang.String clauseCode;
    
    /** 条款名称 */ 
    private java.lang.String clauseCName;
    
    /** 条款内容 */ 
    private java.lang.String clausecontext;
    
    /** 显示序号 */ 
    private java.lang.Integer displayNo;
    
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
    
    
    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    /**
     * 设置属性主键ID的值
     */ 
    public void setSpecialClausesId(java.lang.Integer specialClausesId) {
        this.specialClausesId = specialClausesId;
    }
    
    /**
     * 获取属性主键ID的值
     */ 
    public java.lang.Integer getSpecialClausesId() {
        return this.specialClausesId;
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
     * 设置属性条款代码的值
     */ 
    public void setClauseCode(java.lang.String clauseCode) {
        this.clauseCode = clauseCode;
    }
    
    /**
     * 获取属性条款代码的值
     */ 
    public java.lang.String getClauseCode() {
        return this.clauseCode;
    }
    
    public java.lang.String getClauseCName() {
        return clauseCName;
    }

    public void setClauseCName(java.lang.String clauseCName) {
        this.clauseCName = clauseCName;
    }

    /**
     * 设置属性条款内容的值
     */ 
    public void setClausecontext(java.lang.String clausecontext) {
        this.clausecontext = clausecontext;
    }
    
    /**
     * 获取属性条款内容的值
     */ 
    public java.lang.String getClausecontext() {
        return this.clausecontext;
    }
    
    /**
     * 设置属性显示序号的值
     */ 
    public void setDisplayNo(java.lang.Integer displayNo) {
        this.displayNo = displayNo;
    }
    
    /**
     * 获取属性显示序号的值
     */ 
    public java.lang.Integer getDisplayNo() {
        return this.displayNo;
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