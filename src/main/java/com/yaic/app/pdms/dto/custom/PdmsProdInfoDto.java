package com.yaic.app.pdms.dto.custom;

import java.io.Serializable;
import java.util.List;

import com.yaic.app.pdms.dto.domain.PdmsProductRiskDto;
import com.yaic.fa.dto.BaseDto;

public class PdmsProdInfoDto extends BaseDto implements Serializable{
	
	private static final long serialVersionUID = PdmsProdInfoDto.class.getName().hashCode();
	
	/** 产品Id */
	private Integer prodId;
	
	/** 产品代码 */
	private String prodCode;
	
	/** 产品名称 */
	private String prodName;
	
	/** 产品版本 */
	private String prodVersion;
	
	/** 助记码 */
	private String mnemonicCode;
	
	/** 产品系列 */
	private String prodLine;
	
	/** 产品系列名称 */
	private String prodLineName;
	
	/** 产品状态 */
	private String prodStatus;
	
	/** 产品类型 */
	private String prodType;
	
	/** 生效日期 */
	private String validDate;
	
	/** 失效日期 */
	private String invalidDate;
	
	/** 产品类别: 0 普通产品，1 理财产品，2 赠险产品 */ 
    private java.lang.String productClass;
    
	/** 是否救援: 0为否 1为是 */
	private String isRescue;
	
	/** 救援公司 */
	private String rescueCompany;
	
	/** 救援方案 */
	private String rescueProgram;
	
	/** 保障计划 */
	private String assProCode;
	
	/** 重复投保标识 */
	private String repeatCode;
	
	/** 产品险种列表 */
	private List<PdmsProductRiskDto> productRiskList;
	
	/** 产品险种列表（为把险别、限额、免赔、赔付、条款、特约放到同一级而准备的dto对象） */
	private List<PdmsProdRiskInfoDto> pdmsProdRiskInfoList;
	
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
	 * 获取产品险种信息列表
	 */
	public List<PdmsProdRiskInfoDto> getPdmsProdRiskInfoList() {
		return pdmsProdRiskInfoList;
	}

	/**
	 * 设置产品险种信息列表
	 */
	public void setPdmsProdRiskInfoList(List<PdmsProdRiskInfoDto> pdmsProdRiskInfoList) {
		this.pdmsProdRiskInfoList = pdmsProdRiskInfoList;
	}
	
	/**
	 * 获取产品代码
	 */
	public String getProdCode() {
		return prodCode;
	}

	/**
	 * 设置产品代码
	 */
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}
	
	/**
	 * 获取产品名称
	 */
	public String getProdName() {
		return prodName;
	}

	/**
	 * 设置产品名称
	 */
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	
	/**
	 * 获取产品版本
	 */
	public String getProdVersion() {
		return prodVersion;
	}

	/**
	 * 设置产品版本
	 */
	public void setProdVersion(String prodVersion) {
		this.prodVersion = prodVersion;
	}

	/**
	 * 获取助记码
	 */
	public String getMnemonicCode() {
		return mnemonicCode;
	}

	/**
	 * 设置助记码
	 */
	public void setMnemonicCode(String mnemonicCode) {
		this.mnemonicCode = mnemonicCode;
	}

	/**
	 * 获取产品系列
	 */
	public String getProdLine() {
		return prodLine;
	}

	/**
	 * 设置产品系列
	 */
	public void setProdLine(String prodLine) {
		this.prodLine = prodLine;
	}

	/**
	 * 获取产品系列名称
	 */
	public String getProdLineName() {
		return prodLineName;
	}

	/**
	 * 设置产品系列名称
	 */
	public void setProdLineName(String prodLineName) {
		this.prodLineName = prodLineName;
	}

	/**
	 * 获取产品状态
	 */
	public String getProdStatus() {
		return prodStatus;
	}

	/**
	 * 设置产品状态
	 */
	public void setProdStatus(String prodStatus) {
		this.prodStatus = prodStatus;
	}

	/**
	 * 获取产品类型
	 */
	public String getProdType() {
		return prodType;
	}

	/**
	 * 设置产品类型
	 */
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}

	/**
	 * 获取生效日期
	 */
	public String getValidDate() {
		return validDate;
	}

	/**
	 * 设置失效日期
	 */
	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}

	/**
	 * 获取失效日期
	 */
	public String getInvalidDate() {
		return invalidDate;
	}

	/**
	 * 设置失效日期
	 */
	public void setInvalidDate(String invalidDate) {
		this.invalidDate = invalidDate;
	}

	/**
     * 获取属性产品类别: 0 普通产品，1 理财产品，2 赠险产品的值
     */ 
    public java.lang.String getProductClass() {
        return productClass;
    }

    /**
     * 设置属性产品类别: 0 普通产品，1 理财产品，2 赠险产品的值
     */ 
    public void setProductClass(java.lang.String productClass) {
        this.productClass = productClass;
    }
    
	/** 是否救援: 0为否 1为是 */
	public String getIsRescue() {
		return isRescue;
	}

	/** 是否救援: 0为否 1为是 */
	public void setIsRescue(String isRescue) {
		this.isRescue = isRescue;
	}

	/** 救援公司 */
	public String getRescueCompany() {
		return rescueCompany;
	}

	/** 救援公司 */
	public void setRescueCompany(String rescueCompany) {
		this.rescueCompany = rescueCompany;
	}

	/** 救援方案 */
	public String getRescueProgram() {
		return rescueProgram;
	}

	/** 救援方案 */
	public void setRescueProgram(String rescueProgram) {
		this.rescueProgram = rescueProgram;
	}

	/** 重复投保标识 */
	public String getRepeatCode() {
		return repeatCode;
	}

	/** 重复投保标识 */
	public void setRepeatCode(String repeatCode) {
		this.repeatCode = repeatCode;
	}

	/**
	 * 获取产品险种列表
	 */
	public List<PdmsProductRiskDto> getProductRiskList() {
		return productRiskList;
	}

	/**
	 * 设置产品险种列表
	 */
	public void setProductRiskList(List<PdmsProductRiskDto> productRiskList) {
		this.productRiskList = productRiskList;
	}

	public String getAssProCode() {
		return assProCode;
	}

	public void setAssProCode(String assProCode) {
		this.assProCode = assProCode;
	}

		
}
