/*
 * Created By lujicong (2017-06-06 14:48:03)
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
 * 产品赔偿限额表
 */
@Table(name = "t_pdms_risk_limit")
public class PdmsRiskLimitDto extends BaseDto implements Serializable {
	
	private static final long serialVersionUID = PdmsRiskLimitDto.class.getName().hashCode();
	
	/** 主键ID */
	@Id
	private Integer limitId;
	
	/** 限额级别：对应t_pub_code 的 code_type=LimitLevel */
	private String limitLevel;
	
	/** 序号 */
	private Integer serialNo;
	
	/** 险别代码 */
	private String kindCode;
	
	/** 限额代码 */
	private String limitCode;
	
	/** 限额名称 */
	private String limitName;
	
	/** 限额类型：对应t_pub_code 的 code_type=LimitType */
	private String limitType;
	
	/** 币别 */
	private String currency;
	
	/** 限额数值 */
	private java.math.BigDecimal limitValue;
	
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
	public Integer getLimitId() {
	    return this.limitId;
	}
	
	/**
	 * 设置属性主键ID的值
	 */
	public void setLimitId(Integer limitId) {
	    this.limitId = limitId;
	}
	
	/**
	 * 获取属性限额级别：对应t_pub_code 的 code_type=LimitLevel的值
	 */
	public String getLimitLevel() {
	    return this.limitLevel;
	}
	
	/**
	 * 设置属性限额级别：对应t_pub_code 的 code_type=LimitLevel的值
	 */
	public void setLimitLevel(String limitLevel) {
	    this.limitLevel = limitLevel;
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
	 * 获取属性险别代码的值
	 */
	public String getKindCode() {
	    return this.kindCode;
	}
	
	/**
	 * 设置属性险别代码的值
	 */
	public void setKindCode(String kindCode) {
	    this.kindCode = kindCode;
	}
	
	/**
	 * 获取属性限额代码的值
	 */
	public String getLimitCode() {
	    return this.limitCode;
	}
	
	/**
	 * 设置属性限额代码的值
	 */
	public void setLimitCode(String limitCode) {
	    this.limitCode = limitCode;
	}
	
	/**
	 * 获取属性限额名称的值
	 */
	public String getLimitName() {
	    return this.limitName;
	}
	
	/**
	 * 设置属性限额名称的值
	 */
	public void setLimitName(String limitName) {
	    this.limitName = limitName;
	}
	
	/**
	 * 获取属性限额类型：对应t_pub_code 的 code_type=LimitType的值
	 */
	public String getLimitType() {
	    return this.limitType;
	}
	
	/**
	 * 设置属性限额类型：对应t_pub_code 的 code_type=LimitType的值
	 */
	public void setLimitType(String limitType) {
	    this.limitType = limitType;
	}
	
	/**
	 * 获取属性币别的值
	 */
	public String getCurrency() {
	    return this.currency;
	}
	
	/**
	 * 设置属性币别的值
	 */
	    public void setCurrency(String currency) {
	        this.currency = currency;
	    }
	
	  
	    public java.math.BigDecimal getLimitValue() {
			return limitValue;
		}
	
		public void setLimitValue(java.math.BigDecimal limitValue) {
			this.limitValue = limitValue;
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