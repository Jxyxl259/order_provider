/*
 * Created By lujicong (2017-08-17 10:37:29)
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
 * 业务校验映射表
 */
@Table(name = "t_pdms_check_mapping")
public class PdmsCheckMappingDto extends BaseDto implements Serializable {

    private static final long serialVersionUID = PdmsCheckMappingDto.class.getName().hashCode();

    /** 主键ID */
    @Id
    private Integer chkMapId;

    /** 校验层级对应t_pub_code 的 code_type=CheckLevel：1-方案；2-产品 */
    private String checkLevel;

/*    *//** 平台代码 *//*
    private String dataSource;*/

    /** 方案主键Id */
    private Integer solutionId;

    /** 产品主键ID */
    private Integer prodId;

    /**
     * 是否需要业务校验
     */
    private String chkFlag;
    
    /** 是否引用业务校验模版：0-否；1-是 */
    private String chkTmplFlag;

    /** 校验规则ID */
    private Integer chkId;
    
    /**
     * 是否需要重复校验
     */
    private String chkRepFlag;
    
    /** 是否引用重复校验模版：0-否；1-是 */
    private String chkRepTmplFlag;

    /** 重复校验规则ID */
    private Integer chkRepId;

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
    public Integer getChkMapId() {
        return this.chkMapId;
    }

    /**
     * 设置属性主键ID的值
     */
    public void setChkMapId(Integer chkMapId) {
        this.chkMapId = chkMapId;
    }

    /**
     * 获取属性校验层级对应t_pub_code 的 code_type=CheckLevel：1-方案；2-产品的值
     */
    public String getCheckLevel() {
        return this.checkLevel;
    }

    /**
     * 设置属性校验层级对应t_pub_code 的 code_type=CheckLevel：1-方案；2-产品的值
     */
    public void setCheckLevel(String checkLevel) {
        this.checkLevel = checkLevel;
    }

    /**
     * 获取属性平台代码的值
     */
   /* public String getDataSource() {
        return this.dataSource;
    }*/

    /**
     * 设置属性平台代码的值
     */
   /* public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }*/

    public Integer getSolutionId() {
    	return solutionId;
    }
    
    public void setSolutionId(Integer solutionId) {
    	this.solutionId = solutionId;
    }
    
	/**
     * 获取属性产品主键ID的值
     */
    public Integer getProdId() {
        return this.prodId;
    }


	/**
     * 设置属性产品主键ID的值
     */
    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    /**
     * 获取属性是否引用业务校验模版：0-否；1-是的值
     */
    public String getChkTmplFlag() {
        return this.chkTmplFlag;
    }

    /**
     * 设置属性是否引用业务校验模版：0-否；1-是的值
     */
    public void setChkTmplFlag(String chkTmplFlag) {
        this.chkTmplFlag = chkTmplFlag;
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
     * 获取属性是否引用重复校验模版：0-否；1-是的值
     */
    public String getChkRepTmplFlag() {
        return this.chkRepTmplFlag;
    }

    /**
     * 设置属性是否引用重复校验模版：0-否；1-是的值
     */
    public void setChkRepTmplFlag(String chkRepTmplFlag) {
        this.chkRepTmplFlag = chkRepTmplFlag;
    }

    /**
     * 获取属性重复校验规则ID的值
     */
    public Integer getChkRepId() {
        return this.chkRepId;
    }

    /**
     * 设置属性重复校验规则ID的值
     */
    public void setChkRepId(Integer chkRepId) {
        this.chkRepId = chkRepId;
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

	public String getChkFlag() {
		return chkFlag;
	}

	public void setChkFlag(String chkFlag) {
		this.chkFlag = chkFlag;
	}

	public String getChkRepFlag() {
		return chkRepFlag;
	}

	public void setChkRepFlag(String chkRepFlag) {
		this.chkRepFlag = chkRepFlag;
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