/*
 * Created By lujicong (2017-09-01 11:25:05)
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
 * 方案业务员信息表
 */
@Table(name = "t_pdms_solution_salesman")
public class PdmsSolutionSalesmanDto extends BaseDto implements Serializable {
	
	private static final long serialVersionUID = PdmsSolutionSalesmanDto.class.getName().hashCode();
	
	/** 主键ID */
	@Id
	private Integer salesmanId;
	
	/** 方案主键ID */
	private Integer solutionId;
	
	/** 序号 */
	private Integer serialNo;
	
	/** 业务员代码 */
	private String salesmanCode;
	
	/** 业务员名称 */
	private String salesmanName;
	
	/** 团队代码 */
	private String teamCode;
	
	/** 团队代码 */
	private String teamName;
	
	/** 业务员标识 */
	private String salesFlag;
	
	/** 业务员有效标识 */
	private String salesValidInd;
	
	/** 有效起期 */
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date startDate;
	
	/** 有效止期 */
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date endDate;
	
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
	public Integer getSalesmanId() {
	    return this.salesmanId;
	}
	
	/**
	 * 设置属性主键ID的值
	 */
	public void setSalesmanId(Integer salesmanId) {
	    this.salesmanId = salesmanId;
	}
	
	/**
	 * 获取属性方案主键ID的值
	 */
	public Integer getSolutionId() {
	    return this.solutionId;
	}
	
	/**
	 * 设置属性方案主键ID的值
	 */
	public void setSolutionId(Integer solutionId) {
	    this.solutionId = solutionId;
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
	 * 获取属性业务员代码的值
	 */
	public String getSalesmanCode() {
	    return this.salesmanCode;
	}
	
	/**
	 * 设置属性业务员代码的值
	 */
	public void setSalesmanCode(String salesmanCode) {
	    this.salesmanCode = salesmanCode;
	}
	
	/**
	 * 获取属性业务员名称的值
	 */
	public String getSalesmanName() {
	    return this.salesmanName;
	}
	
	/**
	 * 设置属性业务员名称的值
	 */
	public void setSalesmanName(String salesmanName) {
	    this.salesmanName = salesmanName;
	}
	
	/**
	 * 获取属性团队代码的值
	 */
	public String getTeamCode() {
	    return this.teamCode;
	}
	
	/**
	 * 设置属性团队代码的值
	 */
	public void setTeamCode(String teamCode) {
	    this.teamCode = teamCode;
	}
	
	
	public String getTeamName() {
		return teamName;
	}
	
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	/**
	 * 获取属性业务员标识的值
	 */
	public String getSalesFlag() {
	    return this.salesFlag;
	}
	
	/**
	 * 设置属性业务员标识的值
	 */
	public void setSalesFlag(String salesFlag) {
	    this.salesFlag = salesFlag;
	}
	
	/**
	 * 获取属性业务员有效标识的值
	 */
	public String getSalesValidInd() {
	    return this.salesValidInd;
	}
	
	/**
	 * 设置属性业务员有效标识的值
	 */
	public void setSalesValidInd(String salesValidInd) {
	    this.salesValidInd = salesValidInd;
	}
	
	/**
	 * 获取属性有效起期的值
	 */
	public Date getStartDate() {
	    return this.startDate;
	}
	
	/**
	 * 设置属性有效起期的值
	 */
	public void setStartDate(Date startDate) {
	    this.startDate = startDate;
	}
	
	/**
	 * 获取属性有效止期的值
	 */
	public Date getEndDate() {
	    return this.endDate;
	}
	
	/**
	 * 设置属性有效止期的值
	 */
	public void setEndDate(Date endDate) {
	    this.endDate = endDate;
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