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

@Table(name = "t_order_clauses")
public class OrderClausesDto implements Serializable {
    
    private static final long serialVersionUID = OrderClausesDto.class.getName().hashCode();
    
    /** 用户id */ 
    @Transient
    private BigInteger userId;
    
    /** 主键ID */ 
    @Id
    private java.lang.Integer clausesId;
    
    /** 订单主表id */ 
    private BigInteger orderMainId;
    
    /** 订单编号 */ 
    private BigInteger orderCode;
    
    /** 序号 */ 
    private java.lang.Integer serialNo;
    
    /** 条款代码 */ 
    private java.lang.String clauseCode;
    
    /** 条款名称 */ 
    private java.lang.String clauseLongName;
    
    /** 条款内容 */ 
    private java.lang.String clauses;
    
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
    public void setClausesId(java.lang.Integer clausesId) {
        this.clausesId = clausesId;
    }
    
    /**
     * 获取属性主键ID的值
     */ 
    public java.lang.Integer getClausesId() {
        return this.clausesId;
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
    
    /**
     * 设置属性条款名称的值
     */ 
    public void setClauseLongName(java.lang.String clauseLongName) {
        this.clauseLongName = clauseLongName;
    }
    
    /**
     * 获取属性条款名称的值
     */ 
    public java.lang.String getClauseLongName() {
        return this.clauseLongName;
    }
    
    /**
     * 设置属性条款内容的值
     */ 
    public void setClauses(java.lang.String clauses) {
        this.clauses = clauses;
    }
    
    /**
     * 获取属性条款内容的值
     */ 
    public java.lang.String getClauses() {
        return this.clauses;
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