package com.yaic.app.pdms.dto.custom;

import java.util.List;

import javax.persistence.Transient;

import com.yaic.app.pdms.dto.domain.PdmsClauseDto;
import com.yaic.app.pdms.dto.domain.PdmsProductClaimDto;
import com.yaic.app.pdms.dto.domain.PdmsProductDeductibleDto;
import com.yaic.app.pdms.dto.domain.PdmsProductKindDto;
import com.yaic.app.pdms.dto.domain.PdmsProductLimitDto;
import com.yaic.app.pdms.dto.domain.PdmsProductSpecialClsDto;
import com.yaic.app.pdms.dto.domain.TplDefDto;

public class PdmsProdRiskInfoDto {

	private Integer prodRiskId;

	/** 产品代码 */
	private Integer prodId;

	/** 险种代码 */
	private String riskCode;

	/** 险种名称 */
	@Transient
	private String riskName;

	/** 显示序号 */
	private Integer displayNo;
	
	/** 定额类型 */
	private String rationType;

	/** 产品险别列表 */
	private List<PdmsProductKindDto> productKindList;

	/** 产品特约列表 */
	private List<PdmsProductSpecialClsDto> productSpecialClsList;

	/** 产品限额列表 */
	private List<PdmsProductLimitDto> productLimitList;

	/** 产品免赔列表 */
	private List<PdmsProductDeductibleDto> productDeductibleList;

	/** 产品赔付列表 */
	private List<PdmsProductClaimDto> productClaimList;

	/** 产品条款列表 */
	private List<PdmsClauseDto> productClauseList;

	/** 模板配置信息 */
	private TplDefDto tplDefDto;
	
	/**
	 * 获取产品险种主键ID
	 */
	public Integer getProdRiskId() {
		return prodRiskId;
	}

	/**
	 * 设置产品险种主键ID
	 */
	public void setProdRiskId(Integer prodRiskId) {
		this.prodRiskId = prodRiskId;
	}

	/**
	 * 获取产品主键ID
	 */
	public Integer getProdId() {
		return prodId;
	}

	/**
	 * 设置产品主键ID
	 */
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	/**
	 * 获取产品险种代码
	 */
	public String getRiskCode() {
		return riskCode;
	}

	/**
	 * 设置产品险种代码
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	/**
	 * 获取产品险种名称
	 */
	public String getRiskName() {
		return riskName;
	}

	/**
	 * 设置产品险种名称
	 */
	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}

	/**
	 * 获取序号
	 */
	public Integer getDisplayNo() {
		return displayNo;
	}

	/**
	 * 设置序号
	 */
	public void setDisplayNo(Integer displayNo) {
		this.displayNo = displayNo;
	}
	
	/** 定额类型 */
	public String getRationType() {
		return rationType;
	}
	
	/** 定额类型 */
	public void setRationType(String rationType) {
		this.rationType = rationType;
	}

	/**
	 * 获取产品险别列表
	 */
	public List<PdmsProductKindDto> getProductKindList() {
		return productKindList;
	}

	/**
	 * 设置产品险别列表
	 */
	public void setProductKindList(List<PdmsProductKindDto> productKindList) {
		this.productKindList = productKindList;
	}

	/**
	 * 获取产品特约列表
	 */
	public List<PdmsProductSpecialClsDto> getProductSpecialClsList() {
		return productSpecialClsList;
	}

	/**
	 * 设置产品特约列表
	 */
	public void setProductSpecialClsList(List<PdmsProductSpecialClsDto> productSpecialClsList) {
		this.productSpecialClsList = productSpecialClsList;
	}

	/**
	 * 获取产品限额列表
	 */
	public List<PdmsProductLimitDto> getProductLimitList() {
		return productLimitList;
	}

	/**
	 * 设置产品限额列表
	 */
	public void setProductLimitList(List<PdmsProductLimitDto> productLimitList) {
		this.productLimitList = productLimitList;
	}

	/**
	 * 获取产品免赔列表
	 */
	public List<PdmsProductDeductibleDto> getProductDeductibleList() {
		return productDeductibleList;
	}

	/** 产品免赔列表 */
	public void setProductDeductibleList(List<PdmsProductDeductibleDto> productDeductibleList) {
		this.productDeductibleList = productDeductibleList;
	}

	/** 产品赔付列表 */
	public List<PdmsProductClaimDto> getProductClaimList() {
		return productClaimList;
	}

	/** 产品赔付列表 */
	public void setProductClaimList(List<PdmsProductClaimDto> productClaimList) {
		this.productClaimList = productClaimList;
	}

	/** 产品条款列表 */
	public List<PdmsClauseDto> getProductClauseList() {
		return productClauseList;
	}

	/** 产品条款列表 */
	public void setProductClauseList(List<PdmsClauseDto> productClauseList) {
		this.productClauseList = productClauseList;
	}
	
	/** 模板配置信息 */
	public TplDefDto getTplDefDto () {
		return tplDefDto;
	}

	/** 模板配置信息 */
	public PdmsProdRiskInfoDto setTplDefDto ( TplDefDto tplDefDto ) {
		this.tplDefDto = tplDefDto;
		return this;
	}
	
}
