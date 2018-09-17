/*
 * Created By lujicong (2017-04-18 19:33:44)
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
 * 险别表
 */
@Table(name = "t_pdms_kind")
public class PdmsKindDto extends BaseDto implements Serializable {

    private static final long serialVersionUID = PdmsKindDto.class.getName().hashCode();

    /** 险别代码 */
    @Id
    private String kindCode;

    /** 险别名称 */
    private String kindName;

    /** 主/附加险标识：1-主险，2-附加险 */
    private String kindInd;

    /** 险别类型：对应t_pub_code 的 code_type=KindType：0-主险险别，1-通用附加险，2-专用附加险，3-混用附加险，4-跨险类附加险 */
    private String kindType;

    /** 险种代码（主险则非空） */
    private String riskCode;
    
    /** 险种名称 */
    @Transient
    private String riskName;
    
    /** 险类代码 */
    private String riskClass;
	
	/** 险类名称 */
	@Transient
	private String className;
	
	/** 子险类代码 */
    private String riskClassSub;
    
	/** 子险类名称 */
	@Transient
	private String classSubName;

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
    
    
    public String getRiskClass() {
		return riskClass;
	}

	public void setRiskClass(String riskClass) {
		this.riskClass = riskClass;
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
     * 获取属性险别名称的值
     */
    public String getKindName() {
        return this.kindName;
    }

    /**
     * 设置属性险别名称的值
     */
    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    /**
     * 获取属性主/附加险标识：1-主险，2-附加险的值
     */
    public String getKindInd() {
        return this.kindInd;
    }

    /**
     * 设置属性主/附加险标识：1-主险，2-附加险的值
     */
    public void setKindInd(String kindInd) {
        this.kindInd = kindInd;
    }

    /**
     * 险别类型：对应t_pub_code 的 code_type=KindType：0-主险险别，1-通用附加险，2-专用附加险，3-混用附加险，4-跨险类附加险
     */
    public String getKindType() {
        return this.kindType;
    }

    /**
     * 险别类型：对应t_pub_code 的 code_type=KindType：0-主险险别，1-通用附加险，2-专用附加险，3-混用附加险，4-跨险类附加险
     */
    public void setKindType(String kindType) {
        this.kindType = kindType;
    }

    /**
     * 获取属性险种代码（主险则非空）的值
     */
    public String getRiskCode() {
        return this.riskCode;
    }

    /**
     * 设置属性险种代码（主险则非空）的值
     */
    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
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
     * 获取险种名称的值
     */
    public String getRiskName() {
		return riskName;
	}
    /**
     * 设置险种名称的值
     */
	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}
	/**
     * 获取险类名称的值
     */
    public String getClassName() {
		return className;
	}
    /**
     * 设置险类名称的值
     */
	public void setClassName(String className) {
		this.className = className;
	}
	
	/**
     * 获取子险类代码的值
     */
	public String getRiskClassSub() {
		return riskClassSub;
	}
	/**
     * 设置子险类代码的值
     */
	public void setRiskClassSub(String riskClassSub) {
		this.riskClassSub = riskClassSub;
	}
	/**
     * 获取子险类名称的值
     */
	public String getClassSubName() {
		return classSubName;
	}
	/**
     * 设置子险类名称的值
     */
	public void setClassSubName(String classSubName) {
		this.classSubName = classSubName;
	}

}
