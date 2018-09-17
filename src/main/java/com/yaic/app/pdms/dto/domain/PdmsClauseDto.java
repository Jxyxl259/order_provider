/*
 * Created By lujicong (2017-04-18 19:33:47)
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
 * 条款表
 */
/**
 * <p>User: chenghao
 * <p>Date: 2017年4月24日
 * <p>Version: 1.0
 */
@Table(name = "t_pdms_clause")
public class PdmsClauseDto extends BaseDto implements Serializable {

    private static final long serialVersionUID = PdmsClauseDto.class.getName().hashCode();

    /** 条款编码 */
    @Id
    private String clauseCode;

    /** 条款名称 */
    private String clauseName;

    /** 注册号 */
    private String registerNo;

    /** 注册时间 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date registerTime;

    /** 备案号 */
    private String recordNo;

    /** 备案时间 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date recordTime;

    /** 条款状态：1-有效，2-失效，3-废止 */
    private String clauseStatus;

    /** 生效日期 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date validDate;

    /** 失效日期 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date invalidDate;

    /** 失效原因 */
    private String invalidReason;
    
    /** 财务代码（一年期以内） */
    private String financeCode;

    /** 财务名称（一年期以内） */
    private String financeName;

    /** 财务代码（一年期及以上） */
    private String financeAbove;

    /** 财务名称（一年期及以上） */
    private String financeAboveName;

    /** 失效标识：0-有效，1-失效 */
    private Integer invalidFlag;

    /** 创建人 */
    private String createdUser;

    /** 创建时间 */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdDate;

    /** 更新人 */
    private String updatedUser;

	/** 更新时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updatedDate;
	
	@Transient
	private String remark;

	/**
	 * 险别,险种，险类
	 */
	@Transient
	private String  kindCode;
	
	@Transient
	private String  kindName;
	
	@Transient
	private String  riskCode;
	
	@Transient
	private String  riskName;
	
	@Transient
	private String  riskClass;
	
	@Transient
	private String  riskClassSub;
	
	@Transient
	private String  className;
	
	@Transient
	private String  classSubName;
	
	@Transient
	private String  fid;
	
	@Transient
	private String  kindInd;
	
	/** 中台用于条款排序，字段来源：险别的serialNo */
	@Transient
	private Integer displayNo;
	
	/** 条款内容 */ 
    private java.lang.String clauseContext;
	
	public Integer getDisplayNo() {
		return displayNo;
	}

	public void setDisplayNo(Integer displayNo) {
		this.displayNo = displayNo;
	}

	public String getKindInd() {
		return kindInd;
	}

	public void setKindInd(String kindInd) {
		this.kindInd = kindInd;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getKindCode() {
		return kindCode;
	}

	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}

	public String getKindName() {
		return kindName;
	}

	public void setKindName(String kindName) {
		this.kindName = kindName;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getRiskName() {
		return riskName;
	}

	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}

	public String getRiskClass() {
		return riskClass;
	}

	public void setRiskClass(String riskClass) {
		this.riskClass = riskClass;
	}
	
	public String getRiskClassSub() {
		return riskClassSub;
	}

	public void setRiskClassSub(String riskClassSub) {
		this.riskClassSub = riskClassSub;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassSubName() {
		return classSubName;
	}

	public void setClassSubName(String classSubName) {
		this.classSubName = classSubName;
	}

	/**
     * 获取属性条款编码的值
     */
    public String getClauseCode() {
        return this.clauseCode;
    }

   
	/**
     * 设置属性条款编码的值
     */
    public void setClauseCode(String clauseCode) {
        this.clauseCode = clauseCode;
    }

    /**
     * 获取属性条款名称的值
     */
    public String getClauseName() {
        return this.clauseName;
    }

    /**
     * 设置属性条款名称的值
     */
    public void setClauseName(String clauseName) {
        this.clauseName = clauseName;
    }

    /**
     * 获取属性注册号的值
     */
    public String getRegisterNo() {
        return this.registerNo;
    }

    /**
     * 设置属性注册号的值
     */
    public void setRegisterNo(String registerNo) {
        this.registerNo = registerNo;
    }

    /**
     * 获取属性注册时间的值
     */
    public Date getRegisterTime() {
        return this.registerTime;
    }

    /**
     * 设置属性注册时间的值
     */
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    /**
     * 获取属性备案号的值
     */
    public String getRecordNo() {
        return this.recordNo;
    }

    /**
     * 设置属性备案号的值
     */
    public void setRecordNo(String recordNo) {
        this.recordNo = recordNo;
    }

    /**
     * 获取属性备案时间的值
     */
    public Date getRecordTime() {
        return this.recordTime;
    }

    /**
     * 设置属性备案时间的值
     */
    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }
    
    /**
     * 获取属性生效日期的值
     */
    public Date getValidDate() {
		return validDate;
	}
    /**
     * 设置属性生效日期的值
     */
	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}
	 /**
     * 获取属性失效日期的值
     */
	public Date getInvalidDate() {
		return invalidDate;
	}
	/**
     * 设置属性失效日期的值
     */
	public void setInvalidDate(Date invalidDate) {
		this.invalidDate = invalidDate;
	}

	     
    public String getClauseStatus() {
		return clauseStatus;
	}

	public void setClauseStatus(String clauseStatus) {
		this.clauseStatus = clauseStatus;
	}

	public String getInvalidReason() {
		return invalidReason;
	}

	public void setInvalidReason(String invalidReason) {
		this.invalidReason = invalidReason;
	}

	/**
     * 获取属性财务代码（一年期以内）的值
     */
    public String getFinanceCode() {
        return this.financeCode;
    }

    /**
     * 设置属性财务代码（一年期以内）的值
     */
    public void setFinanceCode(String financeCode) {
        this.financeCode = financeCode;
    }

    /**
     * 获取属性财务名称（一年期以内）的值
     */
    public String getFinanceName() {
        return this.financeName;
    }

    /**
     * 设置属性财务名称（一年期以内）的值
     */
    public void setFinanceName(String financeName) {
        this.financeName = financeName;
    }

    /**
     * 获取属性财务代码（一年期及以上）的值
     */
    public String getFinanceAbove() {
        return this.financeAbove;
    }

    /**
     * 设置属性财务代码（一年期及以上）的值
     */
    public void setFinanceAbove(String financeAbove) {
        this.financeAbove = financeAbove;
    }

    /**
     * 获取属性财务名称（一年期及以上）的值
     */
    public String getFinanceAboveName() {
        return this.financeAboveName;
    }

    /**
     * 设置属性财务名称（一年期及以上）的值
     */
    public void setFinanceAboveName(String financeAboveName) {
        this.financeAboveName = financeAboveName;
    }

    /**
     * 获取属性失效标识：0-有效，1-失效的值
     */
    public Integer getInvalidFlag() {
        return this.invalidFlag;
    }

    /**
     * 设置属性失效标识：0-有效，1-失效的值
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
     * 设置属性条款内容的值
     */ 
    public void setClauseContext(java.lang.String clauseContext) {
        this.clauseContext = clauseContext;
    }
    
    /**
     * 获取属性条款内容的值
     */ 
    public java.lang.String getClauseContext() {
        return this.clauseContext;
    }
    
}