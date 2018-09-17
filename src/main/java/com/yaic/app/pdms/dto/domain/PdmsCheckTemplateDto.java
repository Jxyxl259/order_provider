/*
 * Created By lujicong (2017-08-17 10:37:36)
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
 * 校验模版表
 */
@Table(name = "t_pdms_check_template")
public class PdmsCheckTemplateDto extends BaseDto implements Serializable {

    private static final long serialVersionUID = PdmsCheckTemplateDto.class.getName().hashCode();

    /** 主键ID */
    @Id
    private Integer chkTmplId;

    /** 模版代码 */
    private String tmplCode;

    /** 模版名称 */
    private String tmplName;

    /** 模版描述 */
    private String tmplDesc;

    /** 模版类型：对应t_pub_code 的 code_type=TmplType：1-业务校验；2-重复校验。 */
    private String tmplType;

    /** 校验规则ID */
    private Integer chkId;

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
    public Integer getChkTmplId() {
        return this.chkTmplId;
    }

    /**
     * 设置属性主键ID的值
     */
    public void setChkTmplId(Integer chkTmplId) {
        this.chkTmplId = chkTmplId;
    }

    /**
     * 获取属性模版代码的值
     */
    public String getTmplCode() {
        return this.tmplCode;
    }

    /**
     * 设置属性模版代码的值
     */
    public void setTmplCode(String tmplCode) {
        this.tmplCode = tmplCode;
    }

    /**
     * 获取属性模版名称的值
     */
    public String getTmplName() {
        return this.tmplName;
    }

    /**
     * 设置属性模版名称的值
     */
    public void setTmplName(String tmplName) {
        this.tmplName = tmplName;
    }

    /**
     * 获取属性模版描述的值
     */
    public String getTmplDesc() {
        return this.tmplDesc;
    }

    /**
     * 设置属性模版描述的值
     */
    public void setTmplDesc(String tmplDesc) {
        this.tmplDesc = tmplDesc;
    }

    /**
     * 获取属性模版类型：对应t_pub_code 的 code_type=TmplType：1-业务校验；2-重复校验。的值
     */
    public String getTmplType() {
        return this.tmplType;
    }

    /**
     * 设置属性模版类型：对应t_pub_code 的 code_type=TmplType：1-业务校验；2-重复校验。的值
     */
    public void setTmplType(String tmplType) {
        this.tmplType = tmplType;
    }

    /**
     * 获取属性校验规则ID的值
     */
    public Integer getChkId() {
        return this.chkId;
    }

    /**
     * 设置属性校验规则ID的值
     */
    public void setChkId(Integer chkId) {
        this.chkId = chkId;
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