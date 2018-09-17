/*
 * Created By lujicong (2017-04-18 19:33:43)
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
 * 责任信息表
 */
@Table(name = "t_pdms_liability")
public class PdmsLiabilityDto extends BaseDto implements Serializable {

    private static final long serialVersionUID = PdmsLiabilityDto.class.getName().hashCode();

    /** 责任代码 */
    @Id
    private String liabCode;
    
    /** 险类代码*/
    @Transient
    private String riskClass;
    
    /** 险类名称*/
    @Transient
    private String className;
    
    /** 险类Id*/
    @Transient
    private String riskClassId;

	/** 险种代码*/
    @Transient
    private String riskCode;
    
    /** 险种名称*/
    @Transient
    private String riskName;
    
    /** 险别代码*/
    @Transient
    private String kindCode;
    
    /** 险别名称*/
    @Transient
    private String kindName;
    
    @Transient
    private String kindLiabilityId;

	/** 责任名称 */
    private String liabName;

    /** 责任说明 */
    private String liabDesc;

    /** 状态：1-有效，0-无效 */
    private String liabStatus;

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

    
	public String getKindLiabilityId() {
		return kindLiabilityId;
	}

	public void setKindLiabilityId(String kindLiabilityId) {
		this.kindLiabilityId = kindLiabilityId;
	}
	
    public String getRiskClassId() {
    	return riskClassId;
    }
    
    public void setRiskClassId(String riskClassId) {
    	this.riskClassId = riskClassId;
    }
    /**
     * 获取属性责任代码的值
     */
    public String getLiabCode() {
        return this.liabCode;
    }

    /**
     * 设置属性责任代码的值
     */
    public void setLiabCode(String liabCode) {
        this.liabCode = liabCode;
    }
    /**
     * 获取险类名的值
     */
    public String getClassName() {
    	return className;
    }
    /**
     * 设置险类名
     */
    public void setClassName(String className) {
    	this.className = className;
    }
    
    /**
     * 获取险种名的值
     */
    public String getRiskName() {
    	return riskName;
    }
    /**
     * 设置险种名
     */
    public void setRiskName(String riskName) {
    	this.riskName = riskName;
    }
    /**
     * 获取险别名的值
     */
    public String getKindName() {
    	return kindName;
    }
    /**
     * 设置险别名
     */
    public void setKindName(String kindName) {
    	this.kindName = kindName;
    }
    
    /**
     * 获取险类代码的值
     */
    public String getRiskClass() {
		return riskClass;
	}

    /**
     * 设置险类代码的值
     */
	public void setRiskClass(String riskClass) {
		this.riskClass = riskClass;
	}

	/**
     * 获取险种代码的值
     */
	public String getRiskCode() {
		return riskCode;
	}

    /**
     * 设置险类代码的值
     */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	
    /**
     * 获取险别代码的值
     */
    public String getKindCode() {
		return kindCode;
	}
    
    /**
     * 设置险别代码的值
     */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}

    /**
     * 获取属性责任名称的值
     */
    public String getLiabName() {
        return this.liabName;
    }

    /**
     * 设置属性责任名称的值
     */
    public void setLiabName(String liabName) {
        this.liabName = liabName;
    }

    /**
     * 获取属性责任说明的值
     */
    public String getLiabDesc() {
        return this.liabDesc;
    }

    /**
     * 设置属性责任说明的值
     */
    public void setLiabDesc(String liabDesc) {
        this.liabDesc = liabDesc;
    }

    /**
     * 获取属性状态：1-有效，0-无效的值
     */
    public String getLiabStatus() {
        return this.liabStatus;
    }

    /**
     * 设置属性状态：1-有效，0-无效的值
     */
    public void setLiabStatus(String liabStatus) {
        this.liabStatus = liabStatus;
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

}