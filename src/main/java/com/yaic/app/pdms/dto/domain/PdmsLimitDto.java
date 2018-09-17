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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yaic.fa.dto.BaseDto;

/**
 * 赔偿限额表
 */
@Table(name = "t_pdms_limit")
public class PdmsLimitDto extends BaseDto implements Serializable {

    private static final long serialVersionUID = PdmsLimitDto.class.getName().hashCode();

    /** 限额代码 */
    @Id
    private String limitCode;

    /** 限额名称 */
    private String limitName;
    
    /** 限额描述 */
    private String limitDesc;
    
    /** 限额单位：对应t_pub_code 的 code_type=LimitType */
    private String limitType;
      
    /** 限额类型：对应t_pub_code 的 code_type=LimitClass */
    private String limitClass;
    
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

    /** 险别代码*/
    @Transient
    private String kindCode;
    
    /** 限额单位名称*/
    @Transient
    private String limitTypeName;
    
    /** 限额类型名称*/
    @Transient
    private String limitClassName;
    
    
	public String getKindCode() {
		return kindCode;
	}

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
    
    /**
     * 获取属性限额描述的值
     */
    public String getLimitDesc() {
		return limitDesc;
	}

	public void setLimitDesc(String limitDesc) {
		this.limitDesc = limitDesc;
	}

	public String getLimitTypeName() {
		return limitTypeName;
	}

	public void setLimitTypeName(String limitTypeName) {
		this.limitTypeName = limitTypeName;
	}

	public String getLimitClassName() {
		return limitClassName;
	}

	public void setLimitClassName(String limitClassName) {
		this.limitClassName = limitClassName;
	}

	/**
     * 获取属性限额类型：对应t_pub_code 的 code_type=LimitClass的值
     */
	public String getLimitClass() {
		return limitClass;
	}

	/**
     * 获取属性限额类型：对应t_pub_code 的 code_type=LimitClass的值
     */
	public void setLimitClass(String limitClass) {
		this.limitClass = limitClass;
	}

}