/*
 * Created By lujicong (2015-12-23 10:04:01)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2015
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

@Table(name = "t_order_customer")
public class OrderCustomerDto implements Serializable {
    
    private static final long serialVersionUID = OrderCustomerDto.class.getName().hashCode();
    
    /** 用户id */ 
    @Transient
    private BigInteger userId;
    
    /** 客户信息表id */ 
    @Id
    private java.lang.Integer customerId;
    
    /** 订单主表id */ 
    private BigInteger orderMainId;
    
    /** 订单编号 */ 
    private BigInteger orderCode;
    
    /** 客户类型:1-个人，2-企业 */ 
    private java.lang.String customerType;
    
    /** 客户名称 */ 
    private java.lang.String customerName;
    
    /** 证件类型 */ 
    private java.lang.String docType;
    
    /** 证件号码 */ 
    private java.lang.String docNo;
    
    /** 客户性别 */ 
    private java.lang.String sex;
    
    /** 出生日期 */ 
    private java.util.Date birthDate;
    
    /** 邮政编码 */ 
    private java.lang.String postCode;
    
    /** 联系电话 */ 
    private java.lang.String phoneNo;
    
    /** 客户年龄 */ 
    private java.lang.String age;
    
    /** 电子邮箱 */ 
    private java.lang.String email;
    
    /** 所在省 */ 
    private java.lang.String customerProvinces;
    
    /** 所在市 */ 
    private java.lang.String customerCity;
    
    /** 详细地址 */ 
    private java.lang.String customerAddress;
    
    /** 与投保人关系 */ 
    private java.lang.String customerRelations;
    
    /** 关系人标志:1:投保人，2：被保险人 */ 
    private java.lang.String customerFlag;
    
    /** 是否同投保人：1:是，0：否 */ 
    private java.lang.String customerSameInd;
    
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
    
    /** 联系人 */ 
    private java.lang.String contactName;
    
    /** 办公电话 */ 
    private java.lang.String officePhone;
    
    /** 联系人手机 */ 
    private java.lang.String contactMobile;
	
    /** 单位性质 */ 
    private java.lang.String companyNature;
    
    /** 单位总人数 */ 
    private java.lang.Integer totalQuantity;
    
    /** 备注 */ 
    private java.lang.String remark;

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
     * 设置属性客户信息表id的值
     */ 
    public void setCustomerId(java.lang.Integer customerId) {
        this.customerId = customerId;
    }
    
    /**
     * 获取属性客户信息表id的值
     */ 
    public java.lang.Integer getCustomerId() {
        return this.customerId;
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
     * 设置属性客户类型:1-个人，2-企业的值
     */ 
    public void setCustomerType(java.lang.String customerType) {
        this.customerType = customerType;
    }
    
    /**
     * 获取属性客户类型:1-个人，2-企业的值
     */ 
    public java.lang.String getCustomerType() {
        return this.customerType;
    }
    
    /**
     * 设置属性客户名称的值
     */ 
    public void setCustomerName(java.lang.String customerName) {
        this.customerName = customerName;
    }
    
    /**
     * 获取属性客户名称的值
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
     * 设置属性客户性别的值
     */ 
    public void setSex(java.lang.String sex) {
        this.sex = sex;
    }
    
    /**
     * 获取属性客户性别的值
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
     * 设置属性联系电话的值
     */ 
    public void setPhoneNo(java.lang.String phoneNo) {
        this.phoneNo = phoneNo;
    }
    
    /**
     * 获取属性联系电话的值
     */ 
    public java.lang.String getPhoneNo() {
        return this.phoneNo;
    }
    
    /**
     * 设置属性客户年龄的值
     */ 
    public void setAge(java.lang.String age) {
        this.age = age;
    }
    
    /**
     * 获取属性客户年龄的值
     */ 
    public java.lang.String getAge() {
        return this.age;
    }
    
    /**
     * 设置属性联系电话的值
     */ 
    public void setEmail(java.lang.String email) {
        this.email = email;
    }
    
    /**
     * 获取属性联系电话的值
     */ 
    public java.lang.String getEmail() {
        return this.email;
    }
    
    /**
     * 设置属性所在省的值
     */ 
    public void setCustomerProvinces(java.lang.String customerProvinces) {
        this.customerProvinces = customerProvinces;
    }
    
    /**
     * 获取属性所在省的值
     */ 
    public java.lang.String getCustomerProvinces() {
        return this.customerProvinces;
    }
    
    /**
     * 设置属性所在市的值
     */ 
    public void setCustomerCity(java.lang.String customerCity) {
        this.customerCity = customerCity;
    }
    
    /**
     * 获取属性所在市的值
     */ 
    public java.lang.String getCustomerCity() {
        return this.customerCity;
    }
    
    /**
     * 设置属性详细地址的值
     */ 
    public void setCustomerAddress(java.lang.String customerAddress) {
        this.customerAddress = customerAddress;
    }
    
    /**
     * 获取属性详细地址的值
     */ 
    public java.lang.String getCustomerAddress() {
        return this.customerAddress;
    }
    
    /**
     * 设置属性与投保人关系的值
     */ 
    public void setCustomerRelations(java.lang.String customerRelations) {
        this.customerRelations = customerRelations;
    }
    
    /**
     * 获取属性与投保人关系的值
     */ 
    public java.lang.String getCustomerRelations() {
        return this.customerRelations;
    }
    
    /**
     * 设置属性关系人标志:1:投保人，2：被保险人的值
     */ 
    public void setCustomerFlag(java.lang.String customerFlag) {
        this.customerFlag = customerFlag;
    }
    
    /**
     * 获取属性关系人标志:1:投保人，2：被保险人的值
     */ 
    public java.lang.String getCustomerFlag() {
        return this.customerFlag;
    }
    
    /**
     * 设置属性是否同投保人：1:是，0：否的值
     */ 
    public void setCustomerSameInd(java.lang.String customerSameInd) {
        this.customerSameInd = customerSameInd;
    }
    
    /**
     * 获取属性是否同投保人：1:是，0：否的值
     */ 
    public java.lang.String getCustomerSameInd() {
        return this.customerSameInd;
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
    
    public java.lang.String getContactName() {
        return contactName;
    }

    public void setContactName(java.lang.String contactName) {
        this.contactName = contactName;
    }

    public java.lang.String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(java.lang.String officePhone) {
        this.officePhone = officePhone;
    }

    public java.lang.String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(java.lang.String contactMobile) {
        this.contactMobile = contactMobile;
    }

    /**
     * 设置属性单位性质的值
     */ 
    public void setCompanyNature(java.lang.String companyNature) {
        this.companyNature = companyNature;
    }
    
    /**
     * 获取属性单位性质的值
     */ 
    public java.lang.String getCompanyNature() {
        return this.companyNature;
    }
    
    /**
     * 设置属性单位总人数的值
     */ 
    public void setTotalQuantity(java.lang.Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
    
    /**
     * 获取属性单位总人数的值
     */ 
    public java.lang.Integer getTotalQuantity() {
        return this.totalQuantity;
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