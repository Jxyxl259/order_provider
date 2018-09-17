package com.yaic.app.pdms.dto.msg.common;

import com.yaic.app.pdms.dto.msg.GetPdmsProductReq;
import com.yaic.app.pdms.dto.msg.GetPdmsSolutProdRelReq;
import com.yaic.app.pdms.dto.msg.GetPdmsSolutionReq;
import com.yaic.app.pdms.dto.msg.GetSolutionProdReq;

public class PdmsReqBodyData {
	
	/** 获取产品工厂销售方案及产品的详细信息 */
	private GetSolutionProdReq getPdmsSolutionProdReq;
	
	/** 获取产品工厂产品信息 */
	private GetPdmsProductReq getPdmsProductReq;
	
	/** 获取产品工厂中销售方案和产品关系信息 */
	private GetPdmsSolutProdRelReq getPdmsSolutProdRelReq;
	
	/** 获取产品工厂销售方案信息 */
	private GetPdmsSolutionReq getPdmsSolutionReq;

	/** 获取产品工厂销售方案及产品的详细信息 */
	public GetSolutionProdReq getGetPdmsSolutionProdReq() {
		return getPdmsSolutionProdReq;
	}

	/** 获取产品工厂销售方案及产品的详细信息 */
	public void setGetPdmsSolutionProdReq(GetSolutionProdReq getPdmsSolutionProdReq) {
		this.getPdmsSolutionProdReq = getPdmsSolutionProdReq;
	}

	/** 获取产品工厂产品信息 */
	public GetPdmsProductReq getGetPdmsProductReq() {
		return getPdmsProductReq;
	}

	/** 获取产品工厂产品信息 */
	public void setGetPdmsProductReq(GetPdmsProductReq getPdmsProductReq) {
		this.getPdmsProductReq = getPdmsProductReq;
	}

	/** 获取产品工厂中销售方案和产品关系信息 */
	public GetPdmsSolutProdRelReq getGetPdmsSolutProdRelReq() {
		return getPdmsSolutProdRelReq;
	}

	/** 获取产品工厂中销售方案和产品关系信息 */
	public void setGetPdmsSolutProdRelReq(GetPdmsSolutProdRelReq getPdmsSolutProdRelReq) {
		this.getPdmsSolutProdRelReq = getPdmsSolutProdRelReq;
	}

	/** 获取产品工厂销售方案信息 */
	public GetPdmsSolutionReq getGetPdmsSolutionReq() {
		return getPdmsSolutionReq;
	}

	/** 获取产品工厂销售方案信息 */
	public void setGetPdmsSolutionReq(GetPdmsSolutionReq getPdmsSolutionReq) {
		this.getPdmsSolutionReq = getPdmsSolutionReq;
	}
	
}
