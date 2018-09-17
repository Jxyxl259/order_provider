/*
 * 文件名: com.yaic.app.pdms.api.provider.dto
 * 文件编号:
 * 版权: Copyright (c) 2018, YAN Co.Ltd. and/or its affiliates. All rights reserved.Use is subject to license terms.
 * 描述:
 * 创建人: Administrator
 * 创建时间: 2018年06月26日 11:49
 * 修改人:
 * 修改时间: 2018年06月26日 11:49
 * 修改变更号:
 * 修改内容:
 */
package com.yaic.app.pdms.dto.domain;

import java.util.List;

/**
 * @author xruichang
 * @version V1.0
 * @Title BlockDefDto
 * @Description
 * @date 2018年06月26日 11:49
 * @since V1.0
 */
public class BlockDefDto {
	private Integer blockId;

	/** 模块代码 */
	private String blockCode;

	/** 模块名称 */
	private String blockName;

	/** 模块分类 */
	private String blockType;

	/** 是否包含子模块：0-否，1-是 */
	private String isIncSub;

	/** 清单类型 */
	private String listType;

	/** 描述 */
	private String description;

	/** 子模块 */
	private List<BlockDefDto> subBlockList;

	/** 字段列表 */
	private List<FieldDefDto> fieldList;

	/**
	 * 获取属性主键的值
	 */
	public Integer getBlockId() {
		return this.blockId;
	}

	/**
	 * 设置属性主键的值
	 */
	public void setBlockId(Integer blockId) {
		this.blockId = blockId;
	}

	/**
	 * 获取属性模块代码的值
	 */
	public String getBlockCode() {
		return this.blockCode;
	}

	/**
	 * 设置属性模块代码的值
	 */
	public void setBlockCode(String blockCode) {
		this.blockCode = blockCode;
	}

	/**
	 * 获取属性模块名称的值
	 */
	public String getBlockName() {
		return this.blockName;
	}

	/**
	 * 设置属性模块名称的值
	 */
	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}

	/**
	 * 获取属性模块分类的值
	 */
	public String getBlockType() {
		return this.blockType;
	}

	/**
	 * 设置属性模块分类的值
	 */
	public void setBlockType(String blockType) {
		this.blockType = blockType;
	}

	/**
	 * 获取属性是否包含子模块：0-否，1-是的值
	 */
	public String getIsIncSub() {
		return this.isIncSub;
	}

	/**
	 * 设置属性是否包含子模块：0-否，1-是的值
	 */
	public void setIsIncSub(String isIncSub) {
		this.isIncSub = isIncSub;
	}

	/** 清单类型 */
	public String getListType() {
		return listType;
	}

	/** 清单类型 */
	public void setListType(String listType) {
		this.listType = listType;
	}

	/**
	 * 获取属性描述的值
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * 设置属性描述的值
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/** 子模块 */
	public List<BlockDefDto> getSubBlockList() {
		return subBlockList;
	}

	/** 子模块 */
	public BlockDefDto setSubBlockList(List<BlockDefDto> subBlockList) {
		this.subBlockList = subBlockList;
		return this;
	}

	/** 字段列表 */
	public List<FieldDefDto> getFieldList() {
		return fieldList;
	}

	/** 字段列表 */
	public BlockDefDto setFieldList(List<FieldDefDto> fieldList) {
		this.fieldList = fieldList;
		return this;
	}
}
