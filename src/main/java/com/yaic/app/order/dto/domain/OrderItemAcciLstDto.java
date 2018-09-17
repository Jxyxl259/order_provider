/*
 * Created By lujicong (2016-05-25 17:42:32)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2016
 */
package com.yaic.app.order.dto.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Table(name = "t_order_item_acci_lst")
public class OrderItemAcciLstDto implements Serializable {

	private static final long serialVersionUID = OrderItemAcciLstDto.class.getName().hashCode();
	/** 用户id */
	@Transient
	private BigInteger userId;

	/** 意健险人员清单表id */
	@Id
	private BigInteger acciListId;

	/** 意健险标的信息表id */
	private java.lang.Integer acciId;

	/** 订单主表id */
	private BigInteger orderMainId;

	/** 订单编号 */
	private BigInteger orderCode;

	/** 标的序号 */
	private java.lang.Integer itemNo;

	/** 中文姓名 */
	private java.lang.String customerName;

	/** 证件类型 */
	private java.lang.String docType;

	/** 性别 */
	private java.lang.String sex;

	/** 出生日期 */
	private java.util.Date birthDate;

	/** 证件类型A */
	private java.lang.String docNo;

	/** 住址联络电话 */
	private java.lang.String phoneNo;

	/** postCode */
	private java.lang.String postCode;

	/** E_Mail信箱 */
	private java.lang.String email;

	/** 与投保人关系 */
	private java.lang.String appliRelation;

	/** 客户类型 */
	private java.lang.String customerFlag;

	/** 被保险人类型:01-主被保险人（默认）02-连带被保人 09-其他 */
	private java.lang.String mainInsuredInd;

	/** 与主被保险人关系 */
	private java.lang.String relationShip;

	/** 主被保险人编码:主被保险人的证件类型代码+#+主被保险人的证件号码 */
	private java.lang.String memberNo;

	/** 在职标识:01-在职（默认）02-退休 09-其他 */
	private java.lang.String incumbencyInd;

	/** 医保标识:0-否（默认）1-是 */
	private java.lang.String medicareInd;

	/** 社保卡号 */
	private java.lang.String socialSecurityNo;

	/** 是否与主被保人共享保费:0-否（默认）1-是 */
	private java.lang.String shareInsured;

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

	/** -----------------批改意健险信息参数 START---------------- **/
	/** 批改标识：I-新增，D-删除，U-修改 */
	@Transient
	private java.lang.String flag;

	/** 年龄 */
	@Transient
	private java.lang.Integer age;

	/** 职业代码 */
	@Transient
	private java.lang.String occupationCode;
	/** -----------------批改意健险信息参数 END---------------- **/

	/** 受益人清单 */
	@Transient
	private List<OrderItemAcciBenDto> acciBenefitList;

	/** -----------------电子保单封装信息参数 START---------------- **/
	/** 客户类型:1-个人，2-企业 */
	@Transient
	private java.lang.String customerType;

	/** -----------------电子保单封装信息参数 END---------------- **/

	public java.lang.Integer getItemNo() {
		return itemNo;
	}

	public void setItemNo(java.lang.Integer itemNo) {
		this.itemNo = itemNo;
	}

	public BigInteger getUserId() {
		return userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

	/**
	 * 获取属性意健险人员清单表id的值
	 */
	public BigInteger getAcciListId() {
		return acciListId;
	}

	/**
	 * 设置属性意健险人员清单表id的值
	 */
	public void setAcciListId(BigInteger acciListId) {
		this.acciListId = acciListId;
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
	 * 设置属性证件类型A的值
	 */
	public void setDocNo(java.lang.String docNo) {
		this.docNo = docNo;
	}

	/**
	 * 获取属性证件类型A的值
	 */
	public java.lang.String getDocNo() {
		return this.docNo;
	}

	/**
	 * 设置属性住址联络电话的值
	 */
	public void setPhoneNo(java.lang.String phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * 获取属性住址联络电话的值
	 */
	public java.lang.String getPhoneNo() {
		return this.phoneNo;
	}

	/**
	 * 设置属性postCode的值
	 */
	public void setPostCode(java.lang.String postCode) {
		this.postCode = postCode;
	}

	/**
	 * 获取属性postCode的值
	 */
	public java.lang.String getPostCode() {
		return this.postCode;
	}

	/**
	 * 设置属性E_Mail信箱的值
	 */
	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	/**
	 * 获取属性E_Mail信箱的值
	 */
	public java.lang.String getEmail() {
		return this.email;
	}

	/**
	 * 设置属性与投保人关系的值
	 */
	public void setAppliRelation(java.lang.String appliRelation) {
		this.appliRelation = appliRelation;
	}

	/**
	 * 获取属性与投保人关系的值
	 */
	public java.lang.String getAppliRelation() {
		return this.appliRelation;
	}

	/**
	 * 设置属性客户类型的值
	 */
	public void setCustomerFlag(java.lang.String customerFlag) {
		this.customerFlag = customerFlag;
	}

	/**
	 * 获取属性客户类型的值
	 */
	public java.lang.String getCustomerFlag() {
		return this.customerFlag;
	}

	/**
	 * 设置属性被保险人类型:01-主被保险人（默认）02-连带被保人 09-其他的值
	 */
	public void setMainInsuredInd(java.lang.String mainInsuredInd) {
		this.mainInsuredInd = mainInsuredInd;
	}

	/**
	 * 获取属性被保险人类型:01-主被保险人（默认）02-连带被保人 09-其他的值
	 */
	public java.lang.String getMainInsuredInd() {
		return this.mainInsuredInd;
	}

	/**
	 * 设置属性与主被保险人关系的值
	 */
	public void setRelationShip(java.lang.String relationShip) {
		this.relationShip = relationShip;
	}

	/**
	 * 获取属性与主被保险人关系的值
	 */
	public java.lang.String getRelationShip() {
		return this.relationShip;
	}

	/**
	 * 设置属性主被保险人编码:主被保险人的证件类型代码+#+主被保险人的证件号码的值
	 */
	public void setMemberNo(java.lang.String memberNo) {
		this.memberNo = memberNo;
	}

	/**
	 * 获取属性主被保险人编码:主被保险人的证件类型代码+#+主被保险人的证件号码的值
	 */
	public java.lang.String getMemberNo() {
		return this.memberNo;
	}

	/**
	 * 设置属性在职标识:01-在职（默认）02-退休 09-其他的值
	 */
	public void setIncumbencyInd(java.lang.String incumbencyInd) {
		this.incumbencyInd = incumbencyInd;
	}

	/**
	 * 获取属性在职标识:01-在职（默认）02-退休 09-其他的值
	 */
	public java.lang.String getIncumbencyInd() {
		return this.incumbencyInd;
	}

	/**
	 * 设置属性医保标识:0-否（默认）1-是的值
	 */
	public void setMedicareInd(java.lang.String medicareInd) {
		this.medicareInd = medicareInd;
	}

	/**
	 * 获取属性医保标识:0-否（默认）1-是的值
	 */
	public java.lang.String getMedicareInd() {
		return this.medicareInd;
	}

	/**
	 * 设置属性社保卡号的值
	 */
	public void setSocialSecurityNo(java.lang.String socialSecurityNo) {
		this.socialSecurityNo = socialSecurityNo;
	}

	/**
	 * 获取属性社保卡号的值
	 */
	public java.lang.String getSocialSecurityNo() {
		return this.socialSecurityNo;
	}

	/**
	 * 设置属性是否与主被保人共享保费:0-否（默认）1-是的值
	 */
	public void setShareInsured(java.lang.String shareInsured) {
		this.shareInsured = shareInsured;
	}

	/**
	 * 获取属性是否与主被保人共享保费:0-否（默认）1-是的值
	 */
	public java.lang.String getShareInsured() {
		return this.shareInsured;
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

	/** 批改标识：I-新增，D-删除，U-修改 */
	public java.lang.String getFlag() {
		return flag;
	}

	/** 批改标识：I-新增，D-删除，U-修改 */
	public void setFlag(java.lang.String flag) {
		this.flag = flag;
	}

	/** 年龄 */
	public java.lang.Integer getAge() {
		return age;
	}

	/** 年龄 */
	public void setAge(java.lang.Integer age) {
		this.age = age;
	}

	/** 职业代码 */
	public java.lang.String getOccupationCode() {
		return occupationCode;
	}

	/** 职业代码 */
	public void setOccupationCode(java.lang.String occupationCode) {
		this.occupationCode = occupationCode;
	}
	
	/** 受益人清单 */
	public void setAcciBenefitList(List<OrderItemAcciBenDto> acciBenefitList) {
		this.acciBenefitList = acciBenefitList;
	}

	/** 受益人清单 */
	public List<OrderItemAcciBenDto> getAcciBenefitList() {
		return acciBenefitList;
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