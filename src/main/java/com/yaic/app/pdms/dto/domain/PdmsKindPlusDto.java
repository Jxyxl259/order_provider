/*
 * Created By lujicong (2017-04-18 19:33:45)
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
 * 险别附加信息表
 */
@Table(name = "t_pdms_kind_plus")
public class PdmsKindPlusDto extends BaseDto implements Serializable {

    private static final long serialVersionUID = PdmsKindPlusDto.class.getName().hashCode();

    /** 主键ID */
    @Id
    private Integer kindPlusId;

    /** 附加险种代码 */
    private String riskCode;

    /** 险别代码 */
    private String kindCode;

    /** 险类代码 */
    private String riskClass;

    /** 子险类代码 */
    private String riskClassSub;

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
    public Integer getKindPlusId() {
        return this.kindPlusId;
    }

    /**
     * 设置属性主键ID的值
     */
    public void setKindPlusId(Integer kindPlusId) {
        this.kindPlusId = kindPlusId;
    }

    /**
     * 获取属性附加险种代码的值
     */
    public String getRiskCode() {
        return this.riskCode;
    }

    /**
     * 设置属性附加险种代码的值
     */
    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
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
     * 获取属性险类代码的值
     */
    public String getRiskClass() {
        return this.riskClass;
    }

    /**
     * 设置属性险类代码的值
     */
    public void setRiskClass(String riskClass) {
        this.riskClass = riskClass;
    }

    /**
     * 获取属性子险类代码的值
     */
    public String getRiskClassSub() {
        return this.riskClassSub;
    }

    /**
     * 设置属性子险类代码的值
     */
    public void setRiskClassSub(String riskClassSub) {
        this.riskClassSub = riskClassSub;
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
