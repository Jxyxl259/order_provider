/*
 * 文件名: com.yaic.app.pdms.api.provider.dto
 * 文件编号:
 * 版权: Copyright (c) 2018, YAN Co.Ltd. and/or its affiliates. All rights reserved.Use is subject to license terms.
 * 描述:
 * 创建人: Administrator
 * 创建时间: 2018年07月03日 10:33
 * 修改人:
 * 修改时间: 2018年07月03日 10:33
 * 修改变更号:
 * 修改内容:
 */
package com.yaic.app.pdms.dto.domain;

/**
 * @author xruichang
 * @version V1.0
 * @Title SolutionEpolicyDto
 * @Description
 * @date 2018年07月03日 10:33
 * @since V1.0
 */
public class SolutionEpolicyDto {

	/** 电子保单模板代码 */
	private String eModelCode;

	/** 电子保单报文 */
	private String eModel;

	/** 健康告知 */
	private String healthInform;

	/** 投保申明 */
	private String policyDeclare;

	/** 电子保单模板代码 */
	public String getEModelCode() {
		return eModelCode;
	}

	/** 电子保单模板代码 */
	public void setEModelCode(String eModelCode) {
		this.eModelCode = eModelCode;
	}

	/** 电子保单报文 */
	public String getEModel() {
		return eModel;
	}

	/** 电子保单报文 */
	public void setEModel(String eModel) {
		this.eModel = eModel;
	}

	/** 健康告知 */
	public String getHealthInform() {
		return healthInform;
	}

	/** 健康告知 */
	public void setHealthInform(String healthInform) {
		this.healthInform = healthInform;
	}

	/** 投保申明 */
	public String getPolicyDeclare() {
		return policyDeclare;
	}

	/** 投保申明 */
	public void setPolicyDeclare(String policyDeclare) {
		this.policyDeclare = policyDeclare;
	}
}
