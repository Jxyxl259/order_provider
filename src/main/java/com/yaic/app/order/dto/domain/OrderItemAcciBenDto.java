/*
 * Created By lujicong (2016-05-25 17:42:38)
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

@Table(name = "t_order_item_acci_ben")
public class OrderItemAcciBenDto implements Serializable {
    
    private static final long serialVersionUID = OrderItemAcciBenDto.class.getName().hashCode();
    /** 用户id */ 
    @Transient
    private BigInteger userId;
    
    /** 意健险受益人id */ 
    @Id
    private java.lang.Integer acciBenId;
    
    /** 意健险标的信息表id */ 
    private java.lang.Integer acciId;
    
    /** 人员清单表Id */ 
    private BigInteger acciListId;
    
    /** 订单主表id */ 
    private BigInteger orderMainId;
    
    /** 订单编号 */ 
    private BigInteger orderCode;
    
    /**标的序号*/
    private java.lang.Integer itemNo;
    
    /** 中文姓名 */ 
    private java.lang.String customerName;
    
    /** 证件类型 */ 
    private java.lang.String docType;
    
    /** 证件号码 */ 
    private java.lang.String docNo;
    
    /** 备注 */ 
    private java.lang.String remark;
    
    /** 性别 */ 
    private java.lang.String sex;
    
    /** 出生日期 */ 
    private java.util.Date birthDate;
    
    /** 邮政编码 */ 
    private java.lang.String postCode;
    
    /** 与被保人关系*/ 
    private java.lang.String insuredRelation;
    
    /** 客户标志 */ 
    private java.lang.String customerFlag;
    
    /** 邮箱 */ 
    private java.lang.String email;
    
    /** 联络电话 */ 
    private java.lang.String phoneNo;
    
    /** 收益人顺序 */ 
    private java.lang.String benifitFlag;
    
    /** 收益比例 */ 
    private java.math.BigDecimal benifitPercent;

    /** 受益分配方式:01-未指定（默认）02-指定顺序 03-指定份额 04-其他 */ 
    private java.lang.String benefitDistribution;
    
    /** 是否有效:0正常,1作废值 */ 
    private java.lang.Integer invalidFlag;
    
    /** 创建人 */ 
    private java.lang.String createdUser;
    
    /** 创建时间 */ 
    private java.util.Date createdDate;
    
    /** 更新人 */ 
    private java.lang.String updatedUser;
    
    /** 更新时间 */ 
    private java.util.Date updatedDate;
    
    /**-----------------电子保单封装信息参数 START----------------**/
    /** 客户类型:1-个人，2-企业 */ 
    @Transient
    private java.lang.String customerType;
    /**-----------------电子保单封装信息参数 END----------------**/
    
    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public java.lang.String getBenifitFlag() {
        return benifitFlag;
    }

    public void setBenifitFlag(java.lang.String benifitFlag) {
        this.benifitFlag = benifitFlag;
    }
    
    public java.math.BigDecimal getBenifitPercent() {
        return benifitPercent;
    }

    public void setBenifitPercent(java.math.BigDecimal benifitPercent) {
        this.benifitPercent = benifitPercent;
    }

    public java.lang.Integer getItemNo() {
        return itemNo;
    }

    public void setItemNo(java.lang.Integer itemNo) {
        this.itemNo = itemNo;
    }

    /**
     * 设置属性意健险受益人id的值
     */ 
    public void setAcciBenId(java.lang.Integer acciBenId) {
        this.acciBenId = acciBenId;
    }
    
    /**
     * 获取属性意健险受益人id的值
     */ 
    public java.lang.Integer getAcciBenId() {
        return this.acciBenId;
    }
    
    /**
     * 设置属性意健险标的信息表id的值
     */ 
    public void setAcciId(java.lang.Integer acciId) {
        this.acciId = acciId;
    }
    
    /**
     * 获取属性意健险标的信息表id的值
     */ 
    public java.lang.Integer getAcciId() {
        return this.acciId;
    }
    
    /**
     * 设置属性人员清单表Id的值
     */ 
    public void setAcciListId(BigInteger acciListId) {
        this.acciListId = acciListId;
    }
    
    /**
     * 获取属性人员清单表Id的值
     */ 
    public BigInteger getAcciListId() {
        return acciListId;
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
     * 设置属性中文姓名的值
     */ 
    public void setCustomerName(java.lang.String customerName) {
        this.customerName = customerName;
    }
    
    /**
     * 获取属性中文姓名的值
     */ 
    public java.lang.String getCustomerName() {
        return this.customerName;
    }
    
    /**
     * 设置属性证件类型的值
     */ 
    public void setDocType(java.lang.String docType) {
        this.docType = docType;
    }
    
    /**
     * 获取属性证件类型的值
     */ 
    public java.lang.String getDocType() {
        return this.docType;
    }
    
    /**
     * 设置属性证件号码的值
     */ 
    public void setDocNo(java.lang.String docNo) {
        this.docNo = docNo;
    }
    
    /**
     * 获取属性证件号码的值
     */ 
    public java.lang.String getDocNo() {
        return this.docNo;
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
     * 设置属性性别的值
     */ 
    public void setSex(java.lang.String sex) {
        this.sex = sex;
    }
    
    /**
     * 获取属性性别的值
     */ 
    public java.lang.String getSex() {
        return this.sex;
    }
    
    /**
     * 设置属性出生日期的值
     */ 
    public void setBirthDate(java.util.Date birthDate) {
        this.birthDate = birthDate;
    }
    
    /**
     * 获取属性出生日期的值
     */ 
    public java.util.Date getBirthDate() {
        return this.birthDate;
    }
    
    /**
     * 设置属性邮政编码的值
     */ 
    public void setPostCode(java.lang.String postCode) {
        this.postCode = postCode;
    }
    
    /**
     * 获取属性邮政编码的值
     */ 
    public java.lang.String getPostCode() {
        return this.postCode;
    }
    
    /**
     * 设置属性insuredRelation的值
     */ 
    public void setInsuredRelation(java.lang.String insuredRelation) {
        this.insuredRelation = insuredRelation;
    }
    
    /**
     * 获取属性insuredRelation的值
     */ 
    public java.lang.String getInsuredRelation() {
        return this.insuredRelation;
    }
    
    /**
     * 设置属性客户代码的值
     */ 
    public void setCustomerFlag(java.lang.String customerFlag) {
        this.customerFlag = customerFlag;
    }
    
    /**
     * 获取属性客户代码的值
     */ 
    public java.lang.String getCustomerFlag() {
        return this.customerFlag;
    }
    
    /**
     * 设置属性联络地址的值
     */ 
    public void setEmail(java.lang.String email) {
        this.email = email;
    }
    
    /**
     * 获取属性联络地址的值
     */ 
    public java.lang.String getEmail() {
        return this.email;
    }
    
    /**
     * 设置属性联络电话的值
     */ 
    public void setPhoneNo(java.lang.String phoneNo) {
        this.phoneNo = phoneNo;
    }
    
    /**
     * 获取属性联络电话的值
     */ 
    public java.lang.String getPhoneNo() {
        return this.phoneNo;
    }
    
    /**
     * 设置属性受益分配方式:01-未指定（默认）02-指定顺序 03-指定份额 04-其他的值
     */ 
    public void setBenefitDistribution(java.lang.String benefitDistribution) {
        this.benefitDistribution = benefitDistribution;
    }
    
    /**
     * 获取属性受益分配方式:01-未指定（默认）02-指定顺序 03-指定份额 04-其他的值
     */ 
    public java.lang.String getBenefitDistribution() {
        return this.benefitDistribution;
    }
    
    /**
     * 设置属性是否有效:0正常,1作废值的值
     */ 
    public void setInvalidFlag(java.lang.Integer invalidFlag) {
        this.invalidFlag = invalidFlag;
    }
    
    /**
     * 获取属性是否有效:0正常,1作废值的值
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
    
    /** 客户类型:1-个人，2-企业 */ 
    public java.lang.String getCustomerType() {
		return customerType;
	}

    /** 客户类型:1-个人，2-企业 */ 
	public void setCustomerType(java.lang.String customerType) {
		this.customerType = customerType;
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