package com.yaic.app.pdms.dto.msg;

import java.util.List;

import com.yaic.app.pdms.dto.custom.PdmsProdInfoDto;
import com.yaic.app.pdms.dto.custom.PdmsSolutionInfoDto;

/**
 * 销售方案、产品信息返回实体类
 * <p>User: xruichang
 * <p>Date: 2017年9月12日
 * <p>Version: 1.0
 */
public class GetSolutionProdResp {
	
	/**
	 * 产品信息（包含产品往下险种、险别、条款、赔付、免赔、限额信息）
	 */
	private List<PdmsProdInfoDto> productList;
	
	/**
	 * 方案信息（包含方案往下第三方、信息模版信息）
	 */
	private PdmsSolutionInfoDto pdmsSolutionInfoDto;
	
	/**
	 * 获取产品信息（包含产品往下险种、险别、条款、赔付、免赔、限额信息）
	 */
	public List<PdmsProdInfoDto> getProductList() {
		return productList;
	}
	
	/**
	 * 设置产品信息（包含产品往下险种、险别、条款、赔付、免赔、限额信息）
	 */
	public void setProductList(List<PdmsProdInfoDto> productList) {
		this.productList = productList;
	}
	
	/**
	 * 获取方案信息（包含方案往下第三方、信息模版信息）
	 */
	public PdmsSolutionInfoDto getPdmsSolutionInfoDto() {
		return pdmsSolutionInfoDto;
	}
	
	/**
	 * 设置方案信息（包含方案往下第三方、信息模版信息）
	 */
	public void setPdmsSolutionInfoDto(PdmsSolutionInfoDto pdmsSolutionInfoDto) {
		this.pdmsSolutionInfoDto = pdmsSolutionInfoDto;
	}
	
	
}
