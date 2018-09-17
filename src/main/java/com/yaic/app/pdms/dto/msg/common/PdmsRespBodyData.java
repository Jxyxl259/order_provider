package com.yaic.app.pdms.dto.msg.common;

import com.yaic.app.pdms.dto.msg.GetPdmsMessageResp;
import com.yaic.app.pdms.dto.msg.GetPdmsProductResp;
import com.yaic.app.pdms.dto.msg.GetPdmsSolutProdRelResp;
import com.yaic.app.pdms.dto.msg.GetPdmsSolutionResp;
import com.yaic.app.pdms.dto.msg.GetSolutionProdResp;

public class PdmsRespBodyData {
	
	/** 获取产品工厂销售方案及产品的详细信息 */
	private GetSolutionProdResp getSolutionProdResp;
	
	/** 获取产品工厂产品信息 */
	private GetPdmsProductResp getPdmsProductResp;
	
	/** 获取产品工厂中销售方案和产品关系信息 */
	private GetPdmsSolutProdRelResp getPdmsSolutProdRelResp;
	
	/** 获取产品工厂销售方案信息 */
	private GetPdmsSolutionResp getPdmsSolutionResp;
	
	/** 获取消息通知配置表 */
	private GetPdmsMessageResp getPdmsMessageResp;

	/** 获取产品工厂销售方案及产品的详细信息 */
	public GetSolutionProdResp getGetSolutionProdResp() {
		return getSolutionProdResp;
	}

	/** 获取产品工厂销售方案及产品的详细信息 */
	public void setGetSolutionProdResp(GetSolutionProdResp getSolutionProdResp) {
		this.getSolutionProdResp = getSolutionProdResp;
	}

	/** 获取产品工厂产品信息 */
	public GetPdmsProductResp getGetPdmsProductResp() {
		return getPdmsProductResp;
	}

	/** 获取产品工厂产品信息 */
	public void setGetPdmsProductResp(GetPdmsProductResp getPdmsProductResp) {
		this.getPdmsProductResp = getPdmsProductResp;
	}

	/** 获取产品工厂中销售方案和产品关系信息 */
	public GetPdmsSolutProdRelResp getGetPdmsSolutProdRelResp() {
		return getPdmsSolutProdRelResp;
	}

	/** 获取产品工厂中销售方案和产品关系信息 */
	public void setGetPdmsSolutProdRelResp(GetPdmsSolutProdRelResp getPdmsSolutProdRelResp) {
		this.getPdmsSolutProdRelResp = getPdmsSolutProdRelResp;
	}

	/** 获取产品工厂销售方案信息 */
	public GetPdmsSolutionResp getGetPdmsSolutionResp() {
		return getPdmsSolutionResp;
	}

	/** 获取产品工厂销售方案信息 */
	public void setGetPdmsSolutionResp(GetPdmsSolutionResp getPdmsSolutionResp) {
		this.getPdmsSolutionResp = getPdmsSolutionResp;
	}
	
	/** 获取消息通知配置表 */
	public GetPdmsMessageResp getGetPdmsMessageResp() {
		return getPdmsMessageResp;
	}

	/** 获取消息通知配置表 */
	public void setGetPdmsMessageResp(GetPdmsMessageResp getPdmsMessageResp) {
		this.getPdmsMessageResp = getPdmsMessageResp;
	}

}
