/*
 * 文件名: com.yaic.app.pdms.api.provider.dto
 * 文件编号:
 * 版权: Copyright (c) 2018, YAN Co.Ltd. and/or its affiliates. All rights reserved.Use is subject to license terms.
 * 描述:
 * 创建人: Administrator
 * 创建时间: 2018年06月26日 11:46
 * 修改人:
 * 修改时间: 2018年06月26日 11:46
 * 修改变更号:
 * 修改内容:
 */
package com.yaic.app.pdms.dto.domain;

/**
 * @author xruichang
 * @version V1.0
 * @Title FieldDefDto
 * @Description
 * @date 2018年06月26日 11:46
 * @since V1.0
 */
public class FieldDefDto {
	/** 主键 */
	private Integer fieldId;

	/** 字段 */
	private String fieldCode;

	/** 名称 */
	private String fieldName;

	/** 字段类型 */
	private String fieldType;

	/** 是否必须：N-否，Y-是 */
	private String isRequired;

	/** 描述 */
	private String description;

	/** 默认值 */
	private String defaultValue;

	/** 参考值（测试） */
	private String refValue;

	/** 是否固定值：0-否，1-是 */
	private Integer isFixed;

	/** 固定值 */
	private String fixedValue;

	/** 对应属性 */
	private String field;

	/** 从属对象 */
	private String object;

	/**
	 * 获取属性主键的值
	 */
	public Integer getFieldId() {
		return this.fieldId;
	}

	/**
	 * 设置属性主键的值
	 */
	public void setFieldId(Integer fieldId) {
		this.fieldId = fieldId;
	}

	/**
	 * 获取属性字段的值
	 */
	public String getFieldCode() {
		return this.fieldCode;
	}

	/**
	 * 设置属性字段的值
	 */
	public void setFieldCode(String fieldCode) {
		this.fieldCode = fieldCode;
	}

	/**
	 * 获取属性名称的值
	 */
	public String getFieldName() {
		return this.fieldName;
	}

	/**
	 * 设置属性名称的值
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * 获取属性字段类型的值
	 */
	public String getFieldType() {
		return this.fieldType;
	}

	/**
	 * 设置属性字段类型的值
	 */
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	/**
	 * 获取属性是否必须：N-否，Y-是的值
	 */
	public String getIsRequired() {
		return this.isRequired;
	}

	/**
	 * 设置属性是否必须：N-否，Y-是的值
	 */
	public void setIsRequired(String isRequired) {
		this.isRequired = isRequired;
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

	/**
	 * 获取属性默认值的值
	 */
	public String getDefaultValue() {
		return this.defaultValue;
	}

	/**
	 * 设置属性默认值的值
	 */
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	/**
	 * 获取属性参考值（测试）的值
	 */
	public String getRefValue() {
		return this.refValue;
	}

	/**
	 * 设置属性参考值（测试）的值
	 */
	public void setRefValue(String refValue) {
		this.refValue = refValue;
	}

	/**
	 * 获取属性是否固定值：0-否，1-是的值
	 */
	public Integer getIsFixed() {
		return this.isFixed;
	}

	/**
	 * 设置属性是否固定值：0-否，1-是的值
	 */
	public void setIsFixed(Integer isFixed) {
		this.isFixed = isFixed;
	}

	/**
	 * 获取属性固定值的值
	 */
	public String getFixedValue() {
		return this.fixedValue;
	}

	/**
	 * 设置属性固定值的值
	 */
	public void setFixedValue(String fixedValue) {
		this.fixedValue = fixedValue;
	}

	/**
	 * 获取属性对应属性的值
	 */
	public String getField() {
		return this.field;
	}

	/**
	 * 设置属性对应属性的值
	 */
	public void setField(String field) {
		this.field = field;
	}

	/**
	 * 获取属性从属对象的值
	 */
	public String getObject() {
		return this.object;
	}

	/**
	 * 设置属性从属对象的值
	 */
	public void setObject(String object) {
		this.object = object;
	}
}
