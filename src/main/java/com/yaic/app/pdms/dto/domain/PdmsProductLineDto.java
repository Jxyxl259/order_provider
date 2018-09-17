/*
 * Created By lujicong (2017-06-19 10:59:26)
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
 * 产品系列表
 */
@Table(name = "t_pdms_product_line")
public class PdmsProductLineDto extends BaseDto implements Serializable {

    private static final long serialVersionUID = PdmsProductLineDto.class.getName().hashCode();

    /** 产品系列 */
    @Id
    private String prodLine;

    /** 产品系列名称 */
    private String prodLineName;

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
     * 获取属性产品系列的值
     */
    public String getProdLine() {
        return this.prodLine;
    }

    /**
     * 设置属性产品系列的值
     */
    public void setProdLine(String prodLine) {
        this.prodLine = prodLine;
    }

    /**
     * 获取属性产品系列名称的值
     */
    public String getProdLineName() {
        return this.prodLineName;
    }

    /**
     * 设置属性产品系列名称的值
     */
    public void setProdLineName(String prodLineName) {
        this.prodLineName = prodLineName;
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