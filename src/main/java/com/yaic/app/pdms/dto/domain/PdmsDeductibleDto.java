/*
 * Created By lujicong (2017-06-06 14:48:01)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.pdms.dto.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yaic.fa.dto.BaseDto;

/**
 * 免赔表
 */
@Table(name = "t_pdms_deductible")
public class PdmsDeductibleDto extends BaseDto implements Serializable {

    private static final long serialVersionUID = PdmsDeductibleDto.class.getName().hashCode();

    /** 免赔代码 */
    @Id
    private String deductibleCode;

    /** 免赔名称 */
    private String deductibleName;

    /** 免赔类型：对应t_pub_code 的 code_type=DeductibleType */
    private String deductibleType;

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
     * 获取属性免赔代码的值
     */
    public String getDeductibleCode() {
        return this.deductibleCode;
    }

    /**
     * 设置属性免赔代码的值
     */
    public void setDeductibleCode(String deductibleCode) {
        this.deductibleCode = deductibleCode;
    }

    /**
     * 获取属性免赔名称的值
     */
    public String getDeductibleName() {
        return this.deductibleName;
    }

    /**
     * 设置属性免赔名称的值
     */
    public void setDeductibleName(String deductibleName) {
        this.deductibleName = deductibleName;
    }

    /**
     * 获取属性免赔类型：对应t_pub_code 的 code_type=DeductibleType的值
     */
    public String getDeductibleType() {
        return this.deductibleType;
    }

    /**
     * 设置属性免赔类型：对应t_pub_code 的 code_type=DeductibleType的值
     */
    public void setDeductibleType(String deductibleType) {
        this.deductibleType = deductibleType;
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