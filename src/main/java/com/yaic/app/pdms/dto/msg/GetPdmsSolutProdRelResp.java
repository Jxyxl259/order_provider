package com.yaic.app.pdms.dto.msg;

import java.util.List;

import com.yaic.app.pdms.dto.domain.PdmsProductDto;

public class GetPdmsSolutProdRelResp {
	
	/** 方案代码 */
	private String agrtCode;
	
	/** 平台代码 */
	private String dataSource;
	
	/** 见费出单标志 */
	private String codInd;
	
	/** 产品信息列表 */
	private List<PdmsProductDto> productList;
	
	/** 外部协议代码 */
	private String outerAgrtCode;
	
	/** 外部产品代码 */
	private String outerProdCode;
	
	/** 暂收款编号 */
    private String poaSerialNo;
	
    /** 产品名称 */
    private String agrtName;
    
    /** 渠道小类 */ 
    private String channelTip;
    
    /**
	 * 获取销售方案代码
	 */
	public String getAgrtCode() {
		return agrtCode;
	}

	/**
	 * 设置销售方案代码
	 */
	public void setAgrtCode(String agrtCode) {
		this.agrtCode = agrtCode;
	}

	/**
	 * 获取平台代码
	 */
	public String getDataSource() {
		return dataSource;
	}

	/**
	 * 设置平台代码
	 */
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * 获取见费出单标志
	 */
	public String getCodInd() {
		return codInd;
	}

	/**
	 * 设置见费出单标志
	 */
	public void setCodInd(String codInd) {
		this.codInd = codInd;
	}

	/**
	 * 获取产品信息列表
	 */
	public List<PdmsProductDto> getProductList() {
		return productList;
	}

	/**
	 * 设置产品信息列表
	 */
	public void setProductList(List<PdmsProductDto> productList) {
		this.productList = productList;
	}

	/**
	 * 获取外部销售方案代码
	 */
	public String getOuterAgrtCode() {
		return outerAgrtCode;
	}
	
	/**
	 * 设置外部销售方案代码 
	 */
	public void setOuterAgrtCode(String outerAgrtCode) {
		this.outerAgrtCode = outerAgrtCode;
	}

	/**
	 * 获取外部产品代码
	 */
	public String getOuterProdCode() {
		return outerProdCode;
	}

	/**
	 * 设置外部产品代码
	 */
	public void setOuterProdCode(String outerProdCode) {
		this.outerProdCode = outerProdCode;
	}

	/**
	 * 获取暂收款编号 
	 */
	public String getPoaSerialNo() {
		return poaSerialNo;
	}
	
	/**
	 * 设置暂收款编号
	 */
	public void setPoaSerialNo(String poaSerialNo) {
		this.poaSerialNo = poaSerialNo;
	}

	/**
	 * 获取产品名称
	 */
	public String getAgrtName() {
		return agrtName;
	}

	/**
	 * 设置产品名称
	 */
	public void setAgrtName(String agrtName) {
		this.agrtName = agrtName;
	}

	/**
	 * 渠道小类
	 */ 
	public String getChannelTip() {
		return channelTip;
	}

	/**
	 * 渠道小类
	 */ 
	public void setChannelTip(String channelTip) {
		this.channelTip = channelTip;
	}
}
