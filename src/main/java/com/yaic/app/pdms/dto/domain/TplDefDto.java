/*
 * 文件名: com.yaic.app.pdms.api.provider.dto
 * 文件编号:
 * 版权: Copyright (c) 2018, YAN Co.Ltd. and/or its affiliates. All rights reserved.Use is subject to license terms.
 * 描述:
 * 创建人: Administrator
 * 创建时间: 2018年06月26日 11:30
 * 修改人:
 * 修改时间: 2018年06月26日 11:30
 * 修改变更号:
 * 修改内容:
 */
package com.yaic.app.pdms.dto.domain;

import java.util.List;

/**
 * @author xruichang
 * @version V1.0
 * @Title TplDefDto
 * @Description
 * @date 2018年06月26日 11:30
 * @since V1.0
 */
public class TplDefDto {

	/** 模板代码 */
	private String tplCode;

	/** 模板名称 */
	private String tplName;

	/** 模板类型 */
	private String tplType;

	/** 产品线 */
	private String prodLine;

	/** 渠道类型 */
	private String chanType;

	/** 描述 */
	private String description;

	/** 模块详细信息 */
	private List<BlockDefDto> blockDefList;

	/** 模板代码 */
	public String getTplCode() {
		return tplCode;
	}

	/** 模板代码 */
	public TplDefDto setTplCode(String tplCode) {
		this.tplCode = tplCode;
		return this;
	}

	/** 模板名称 */
	public String getTplName() {
		return tplName;
	}

	/** 模板名称 */
	public TplDefDto setTplName(String tplName) {
		this.tplName = tplName;
		return this;
	}

	/** 模板类型 */
	public String getTplType() {
		return tplType;
	}

	/** 模板类型 */
	public TplDefDto setTplType(String tplType) {
		this.tplType = tplType;
		return this;
	}

	/** 产品线 */
	public String getProdLine() {
		return prodLine;
	}

	/** 产品线 */
	public TplDefDto setProdLine(String prodLine) {
		this.prodLine = prodLine;
		return this;
	}

	/** 渠道类型 */
	public String getChanType() {
		return chanType;
	}

	/** 渠道类型 */
	public TplDefDto setChanType(String chanType) {
		this.chanType = chanType;
		return this;
	}

	/** 描述 */
	public String getDescription() {
		return description;
	}

	/** 描述 */
	public TplDefDto setDescription(String description) {
		this.description = description;
		return this;
	}

	/** 模块详细信息 */
	public List<BlockDefDto> getBlockDefList() {
		return blockDefList;
	}

	/** 模块详细信息 */
	public TplDefDto setBlockDefList(List<BlockDefDto> blockDefList) {
		this.blockDefList = blockDefList;
		return this;
	}
}
