/*
 * Created By lujicong (2017-06-29 10:39:46)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.pdms.dto.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.yaic.fa.dto.BaseDto;

/**
 * 方案指定关系人表
 */
@Table(name = "t_pdms_solution_rltd_party")
public class PdmsSolutionRltdPartyDto extends BaseDto implements Serializable {
	
	private static final long serialVersionUID = PdmsSolutionRltdPartyDto.class.getName().hashCode();
	
	/** 主键ID */
	@Id
	private Integer rltdPartyId;
	
	/** 方案主键ID */
	private Integer solutionId;
	
	/** 序号 */
	private Integer serialNo;
	
	/** 关系人标志：1 投保人;2 被保险人;3 连带被保险人;4 受益人 */
	private String insuredFlag;
	
	/** 关系人类型：1 个人;2 单位 */
	private String insuredType;
	
	/** 关系人代码 */
	private String insuredCode;
	
	/** 关系人名称 */
	private String insuredName;
	
	/** 关系人地址 */
	private String insuredAddress;
	
	/** 证件类型：01 身份证/02 户口簿/03 护照/04 军官证/05 驾驶执照/06 返乡证/99 其他 */
	private String identifyType;
	
	/** 证件号码 */
	private String identifyNumber;
	
	/** 邮政编码 */
	private String postCode;
	
	/** 电子邮箱 */
	private String email;
	
	/** 手机号码 */
	private String mobilePhone;
	
	/** 性别 */
	private String sex;
	
	/** 出生日期 */
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date birthDate;
	
	/** 联系人 */
	private String contactName;
	
	/** 手机号码 */
	private String contactPhone;
	
	/** 办公电话 */
	private String officePhone;
	
	/** 被保险人同投保人标志：1-是，0-否 */
	private String appliSameInd;
	
	/** 失效标志：0-有效，1-失效 */
	private Integer invalidFlag;
	
	/** 创建人 */
	private String createdUser;
	
	/** 创建时间 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createdDate;
	
	/** 更新人 */
	private String updatedUser;
	
	/** 更新时间 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date updatedDate;
	
	
	/**
	 * 获取属性主键ID的值
	 */
	public Integer getRltdPartyId() {
	    return this.rltdPartyId;
	}
	
	/**
	 * 设置属性主键ID的值
	 */
	public void setRltdPartyId(Integer rltdPartyId) {
	    this.rltdPartyId = rltdPartyId;
	}
	
	/**
	 * 获取属性方案主键ID的值
	 */
	public Integer getSolutionId() {
	    return this.solutionId;
	}
	
	/**
	 * 设置属性方案主键ID的值
	 */
	public void setSolutionId(Integer solutionId) {
	    this.solutionId = solutionId;
	}
	
	/**
	 * 获取属性序号的值
	 */
	public Integer getSerialNo() {
	    return this.serialNo;
	}
	
	/**
	 * 设置属性序号的值
	 */
	public void setSerialNo(Integer serialNo) {
	    this.serialNo = serialNo;
	}
	
	/**
	 * 获取属性关系人标志：1 投保人;2 被保险人;3 连带被保险人;4 受益人的值
	 */
	public String getInsuredFlag() {
	    return this.insuredFlag;
	}
	
	/**
	 * 设置属性关系人标志：1 投保人;2 被保险人;3 连带被保险人;4 受益人的值
	 */
	public void setInsuredFlag(String insuredFlag) {
	    this.insuredFlag = insuredFlag;
	}
	
	/**
	 * 获取属性关系人类型：1 个人;2 单位的值
	 */
	public String getInsuredType() {
	    return this.insuredType;
	}
	
	/**
	 * 设置属性关系人类型：1 个人;2 单位的值
	 */
	public void setInsuredType(String insuredType) {
	    this.insuredType = insuredType;
	}
	
	/**
	 * 获取属性关系人代码的值
	 */
	public String getInsuredCode() {
	    return this.insuredCode;
	}
	
	/**
	 * 设置属性关系人代码的值
	 */
	public void setInsuredCode(String insuredCode) {
	    this.insuredCode = insuredCode;
	}
	
	/**
	 * 获取属性关系人名称的值
	 */
	public String getInsuredName() {
	    return this.insuredName;
	}
	
	/**
	 * 设置属性关系人名称的值
	 */
	public void setInsuredName(String insuredName) {
	    this.insuredName = insuredName;
	}
	
	/**
	 * 获取属性关系人地址的值
	 */
	public String getInsuredAddress() {
	    return this.insuredAddress;
	}
	
	/**
	 * 设置属性关系人地址的值
	 */
	public void setInsuredAddress(String insuredAddress) {
	    this.insuredAddress = insuredAddress;
	}
	
	/**
	 * 获取属性证件类型：01 身份证/02 户口簿/03 护照/04 军官证/05 驾驶执照/06 返乡证/99 其他的值
	 */
	public String getIdentifyType() {
	    return this.identifyType;
	}
	
	/**
	 * 设置属性证件类型：01 身份证/02 户口簿/03 护照/04 军官证/05 驾驶执照/06 返乡证/99 其他的值
	 */
	public void setIdentifyType(String identifyType) {
	    this.identifyType = identifyType;
	}
	
	/**
	 * 获取属性证件号码的值
	 */
	public String getIdentifyNumber() {
	    return this.identifyNumber;
	}
	
	/**
	 * 设置属性证件号码的值
	 */
	public void setIdentifyNumber(String identifyNumber) {
	    this.identifyNumber = identifyNumber;
	}
	
	/**
	 * 获取属性邮政编码的值
	 */
	public String getPostCode() {
	    return this.postCode;
	}
	
	/**
	 * 设置属性邮政编码的值
	 */
	public void setPostCode(String postCode) {
	    this.postCode = postCode;
	}
	
	/**
	 * 获取属性电子邮箱的值
	 */
	public String getEmail() {
	    return this.email;
	}
	
	/**
	 * 设置属性电子邮箱的值
	 */
	public void setEmail(String email) {
	    this.email = email;
	}
	
	/**
	 * 获取属性手机号码的值
	 */
	public String getMobilePhone() {
	    return this.mobilePhone;
	}
	
	/**
	 * 设置属性手机号码的值
	 */
	public void setMobilePhone(String mobilePhone) {
	    this.mobilePhone = mobilePhone;
	}
	
	/**
	 * 获取属性性别的值
	 */
	public String getSex() {
	    return this.sex;
	}
	
	/**
	 * 设置属性性别的值
	 */
	public void setSex(String sex) {
	    this.sex = sex;
	}
	
	/**
	 * 获取属性出生日期的值
	 */
	public Date getBirthDate() {
	    return this.birthDate;
	}
	
	/**
	 * 设置属性出生日期的值
	 */
	public void setBirthDate(Date birthDate) {
	    this.birthDate = birthDate;
	}
	
	/**
	 * 获取属性联系人的值
	 */
	public String getContactName() {
	    return this.contactName;
	}
	
	/**
	 * 设置属性联系人的值
	 */
	public void setContactName(String contactName) {
	    this.contactName = contactName;
	}
	
	/**
	 * 获取属性手机号码的值
	 */
	public String getContactPhone() {
	    return this.contactPhone;
	}
	
	/**
	 * 设置属性手机号码的值
	 */
	public void setContactPhone(String contactPhone) {
	    this.contactPhone = contactPhone;
	}
	
	/**
	 * 获取属性办公电话的值
	 */
	public String getOfficePhone() {
	    return this.officePhone;
	}
	
	/**
	 * 设置属性办公电话的值
	 */
	public void setOfficePhone(String officePhone) {
	    this.officePhone = officePhone;
	}
	
	/**
	 * 获取属性被保险人同投保人标志：1-是，0-否的值
	 */
	public String getAppliSameInd() {
	    return this.appliSameInd;
	}
	
	/**
	 * 设置属性被保险人同投保人标志：1-是，0-否的值
	 */
	public void setAppliSameInd(String appliSameInd) {
	    this.appliSameInd = appliSameInd;
	}
	
	/**
	 * 获取属性失效标志：0-有效，1-失效的值
	 */
	public Integer getInvalidFlag() {
	    return this.invalidFlag;
	}
	
	/**
	 * 设置属性失效标志：0-有效，1-失效的值
	 */
	public void setInvalidFlag(Integer invalidFlag) {
	    this.invalidFlag = invalidFlag;
	}
	
	/**
	 * 获取属性创建人的值
	 */
	public String getCreatedUser() {
	    return this.createdUser;
	}
	
	/**
	 * 设置属性创建人的值
	 */
	public void setCreatedUser(String createdUser) {
	    this.createdUser = createdUser;
	}
	
	/**
	 * 获取属性创建时间的值
	 */
	public Date getCreatedDate() {
	    return this.createdDate;
	}
	
	/**
	 * 设置属性创建时间的值
	 */
	public void setCreatedDate(Date createdDate) {
	    this.createdDate = createdDate;
	}
	
	/**
	 * 获取属性更新人的值
	 */
	public String getUpdatedUser() {
	    return this.updatedUser;
	}
	
	/**
	 * 设置属性更新人的值
	 */
	public void setUpdatedUser(String updatedUser) {
	    this.updatedUser = updatedUser;
	}
	
	/**
	 * 获取属性更新时间的值
	 */
	public Date getUpdatedDate() {
	    return this.updatedDate;
	}
	
	/**
	 * 设置属性更新时间的值
	 */
	public void setUpdatedDate(Date updatedDate) {
	    this.updatedDate = updatedDate;
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