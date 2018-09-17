/*
 * Created By lujicong (2015-12-26 09:33:33)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2015
 */
package com.yaic.app.order.dto.domain;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Table(name = "t_order_idx_user_id")
public class OrderIdxUserIdDto implements Serializable {
    
    private static final long serialVersionUID = OrderIdxUserIdDto.class.getName().hashCode();
    
    /** 订单号 */ 
    @Id
    private java.math.BigInteger orderCode;
    
    /** 用户ID */ 
    private java.math.BigInteger userId;
    
    
    /**
     * 设置属性订单号的值
     */ 
    public void setOrderCode(java.math.BigInteger orderCode) {
        this.orderCode = orderCode;
    }
    
    /**
     * 获取属性订单号的值
     */ 
    public java.math.BigInteger getOrderCode() {
        return this.orderCode;
    }
    
    /**
     * 设置属性用户ID的值
     */ 
    public void setUserId(java.math.BigInteger userId) {
        this.userId = userId;
    }
    
    /**
     * 获取属性用户ID的值
     */ 
    public java.math.BigInteger getUserId() {
        return this.userId;
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