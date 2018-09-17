/*
 * Created By lujicong (2017-08-17 10:37:32)
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
 * 重复投保校验表
 */
@Table(name = "t_pdms_check_repeat")
public class PdmsCheckRepeatDto extends BaseDto implements Serializable {

    private static final long serialVersionUID = PdmsCheckRepeatDto.class.getName().hashCode();

    /** 主键ID */
    @Id
    private Integer chkRepId;
    
    /** 规则描述 */
    private String chkDesc;
    
    /** 险种代码 */
    private String riskCode;
    
    /** 是否循环校验标识 : 0-否(组合险时险种为9999), 1-是(组合险时险种为list中的子险种代码) */
    private String isListFlag;

    /** 产品名称校验标识 : 0-不校验名称, 1-产品名称, 2-个险名称校验 （缓存校验标识为1,2,3,4,5，此字段必填） */
    private String prodNameChkFlag;

    /** 缓存校验标识：对应t_pub_code 的 code_type=CacheType： 0-不存储缓存, 1-customer投保人, 2-customer被保人, 3-dynamicItem, 4-property, 5-dynamicList */
    private String cacheType;

    /** 特殊校验标识 : 0-常规校验, 1-特殊校验 （缓存校验标识为1,2,3,4,5，此字段必填） */
    private String spcialChkFlag;

    /** 重复投保份数校验标识  1-份数,2-总保额,3-每日总保额 */
    private String repeatChkFlag;

    /** 渠道限制份数 */
    private Integer countLimit;

    /** 渠道限制金额 */
    private java.math.BigDecimal amountLimit;

    /** 是否校验同一产品/险种代码所有渠道总份数  0-不计总份数, 1-计总份数, 2-记总保额, 3-记每日总保额 */
    private String countChkFlag;

    /** 同一产品所有渠道限制总份数 */
    private Integer countLimitChan;

    /** 同一产品所有渠道限制总金额 */
    private java.math.BigDecimal amountLimitChan;

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

    /** 产品代码 */
    private String  prodCode;
    
    
    /**
     * 获取属性主键ID的值
     */
    public Integer getChkRepId() {
        return this.chkRepId;
    }

    /**
     * 设置属性主键ID的值
     */
    public void setChkRepId(Integer chkRepId) {
        this.chkRepId = chkRepId;
    }

    
    public String getChkDesc() {
		return chkDesc;
	}

	public void setChkDesc(String chkDesc) {
		this.chkDesc = chkDesc;
	}

	/**
     * 获取属性险种代码的值
     */
    public String getRiskCode() {
        return this.riskCode;
    }

    /**
     * 设置属性险种代码的值
     */
    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    /**
     * 获取属性是否循环校验标识 : 0-否(组合险时险种为9999), 1-是(组合险时险种为list中的子险种代码)的值
     */
    public String getIsListFlag() {
        return this.isListFlag;
    }

    /**
     * 设置属性是否循环校验标识 : 0-否(组合险时险种为9999), 1-是(组合险时险种为list中的子险种代码)的值
     */
    public void setIsListFlag(String isListFlag) {
        this.isListFlag = isListFlag;
    }

    /**
     * 获取属性产品名称校验标识 : 0-不校验名称, 1-产品名称, 2-个险名称校验 （缓存校验标识为1,2,3,4,5，此字段必填）的值
     */
    public String getProdNameChkFlag() {
        return this.prodNameChkFlag;
    }

    /**
     * 设置属性产品名称校验标识 : 0-不校验名称, 1-产品名称, 2-个险名称校验 （缓存校验标识为1,2,3,4,5，此字段必填）的值
     */
    public void setProdNameChkFlag(String prodNameChkFlag) {
        this.prodNameChkFlag = prodNameChkFlag;
    }

    /**
     * 获取属性缓存校验标识：对应t_pub_code 的 code_type=CacheType： 0-不存储缓存, 1-customer投保人, 2-customer被保人, 3-dynamicItem, 4-property, 5-dynamicList的值
     */
    public String getCacheType() {
        return this.cacheType;
    }

    /**
     * 设置属性缓存校验标识：对应t_pub_code 的 code_type=CacheType： 0-不存储缓存, 1-customer投保人, 2-customer被保人, 3-dynamicItem, 4-property, 5-dynamicList的值
     */
    public void setCacheType(String cacheType) {
        this.cacheType = cacheType;
    }

    /**
     * 获取属性特殊校验标识 : 0-常规校验, 1-特殊校验 （缓存校验标识为1,2,3,4,5，此字段必填）的值
     */
    public String getSpcialChkFlag() {
        return this.spcialChkFlag;
    }

    /**
     * 设置属性特殊校验标识 : 0-常规校验, 1-特殊校验 （缓存校验标识为1,2,3,4,5，此字段必填）的值
     */
    public void setSpcialChkFlag(String spcialChkFlag) {
        this.spcialChkFlag = spcialChkFlag;
    }

    /**
     * 获取属性重复投保份数校验标识  1-份数,2-总保额,3-每日总保额的值
     */
    public String getRepeatChkFlag() {
        return this.repeatChkFlag;
    }

    /**
     * 设置属性重复投保份数校验标识  1-份数,2-总保额,3-每日总保额的值
     */
    public void setRepeatChkFlag(String repeatChkFlag) {
        this.repeatChkFlag = repeatChkFlag;
    }

    /**
     * 获取属性渠道限制份数的值
     */
    public Integer getCountLimit() {
        return this.countLimit;
    }

    /**
     * 设置属性渠道限制份数的值
     */
    public void setCountLimit(Integer countLimit) {
        this.countLimit = countLimit;
    }

    /**
     * 获取属性渠道限制金额的值
     */
    public java.math.BigDecimal getAmountLimit() {
        return this.amountLimit;
    }

    /**
     * 设置属性渠道限制金额的值
     */
    public void setAmountLimit(java.math.BigDecimal amountLimit) {
        this.amountLimit = amountLimit;
    }

    /**
     * 获取属性是否校验同一产品/险种代码所有渠道总份数  0-不计总份数, 1-计总份数, 2-记总保额, 3-记每日总保额的值
     */
    public String getCountChkFlag() {
        return this.countChkFlag;
    }

    /**
     * 设置属性是否校验同一产品/险种代码所有渠道总份数  0-不计总份数, 1-计总份数, 2-记总保额, 3-记每日总保额的值
     */
    public void setCountChkFlag(String countChkFlag) {
        this.countChkFlag = countChkFlag;
    }

    /**
     * 获取属性同一产品所有渠道限制总份数的值
     */
    public Integer getCountLimitChan() {
        return this.countLimitChan;
    }

    /**
     * 设置属性同一产品所有渠道限制总份数的值
     */
    public void setCountLimitChan(Integer countLimitChan) {
        this.countLimitChan = countLimitChan;
    }

    /**
     * 获取属性同一产品所有渠道限制总金额的值
     */
    public java.math.BigDecimal getAmountLimitChan() {
        return this.amountLimitChan;
    }

    /**
     * 设置属性同一产品所有渠道限制总金额的值
     */
    public void setAmountLimitChan(java.math.BigDecimal amountLimitChan) {
        this.amountLimitChan = amountLimitChan;
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

	public String getProdCode() {
		return prodCode;
	}

	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}
    
    

}