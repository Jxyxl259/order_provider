/*
 * Created By lujicong (2017-06-29 10:39:41)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.pdms.dto.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.yaic.fa.dto.BaseDto;

/**
 * 产品责任表
 */
@Table(name = "t_pdms_product_liability")
public class PdmsProductLiabilityDto extends BaseDto implements Serializable {

    private static final long serialVersionUID = PdmsProductLiabilityDto.class.getName().hashCode();

    /** 主键ID */
    @Id
    private Integer prodLiabId;

    /** 产品险别主键ID */
    private Integer prodKindId;

    /** 序号 */
    private Integer serialNo;

    /** 责任代码 */
    private String liabCode;

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
    
    //责任名称
    @Transient
    private String liabName;

    
    /**
     * 获取属性主键ID的值
     */
    public Integer getProdLiabId() {
        return this.prodLiabId;
    }

    /**
     * 设置属性主键ID的值
     */
    public void setProdLiabId(Integer prodLiabId) {
        this.prodLiabId = prodLiabId;
    }

    /**
     * 获取属性产品险别主键ID的值
     */
    public Integer getProdKindId() {
        return this.prodKindId;
    }

    /**
     * 设置属性产品险别主键ID的值
     */
    public void setProdKindId(Integer prodKindId) {
        this.prodKindId = prodKindId;
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

    public String getLiabName() {
		return liabName;
	}

	public void setLiabName(String liabName) {
		this.liabName = liabName;
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