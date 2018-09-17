/*
 * Created By lujicong (2017-04-18 19:33:49)
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
 * 险别条款表
 */
@Table(name = "t_pdms_kind_clause")
public class PdmsKindClauseDto extends BaseDto implements Serializable {

    private static final long serialVersionUID = PdmsKindClauseDto.class.getName().hashCode();

    /** 主键ID */
    @Id
    private Integer kindClauseId;

    /** 险别代码 */
    private String kindCode;

    /** 条款编码 */
    private String clauseCode;

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
    public Integer getKindClauseId() {
        return this.kindClauseId;
    }

    /**
     * 设置属性主键ID的值
     */
    public void setKindClauseId(Integer kindClauseId) {
        this.kindClauseId = kindClauseId;
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