package com.yaic.app.pdms.dto.custom;

import java.util.List;

import com.yaic.app.pdms.dto.domain.PdmsSolutionDto;
import com.yaic.app.pdms.dto.domain.PdmsSolutionIntermediaryDto;
import com.yaic.app.pdms.dto.domain.PdmsSolutionMappingDto;
import com.yaic.app.pdms.dto.domain.PdmsSolutionMessageDto;
import com.yaic.app.pdms.dto.domain.PdmsSolutionSalesmanDto;
import com.yaic.app.pdms.dto.domain.SolutionEpolicyDto;
import com.yaic.app.pdms.dto.domain.TplDefDto;

public class PdmsSolutionInfoDto {
	
	/** 销售方案主表信息 */
	private PdmsSolutionDto solutionMain;
	
	/** 方案合作方信息表 */
	private List<PdmsSolutionIntermediaryDto> solutionIntermediaryList;
	
	/** 销售方案业务映射表 */
	private List<PdmsSolutionMappingDto> solutionMappingList;
	
	/** 消息通知配置表 */
	private List<PdmsSolutionMessageDto> solutionMessageList;
	
	/** 方案业务员信息表 */
	private List<PdmsSolutionSalesmanDto> solutionSalesmanList;
	
	/** 模板配置信息 */
	private TplDefDto tplDefDto;
	
	/** 电子保单信息 */
	private SolutionEpolicyDto solutionEpolicyDto;
	
	/**
	 * 获取销售方案信息主表
	 */
	public PdmsSolutionDto getSolutionMain() {
		return solutionMain;
	}
	
	/**
	 * 设置销售方案信息主表
	 */
	public void setSolutionMain(PdmsSolutionDto solutionMain) {
		this.solutionMain = solutionMain;
	}
	
	/**
	 * 获取方案合作方信息表
	 */
	public List<PdmsSolutionIntermediaryDto> getSolutionIntermediaryList() {
		return solutionIntermediaryList;
	}
	
	/**
	 * 设置方案合作方信息表
	 */
	public void setSolutionIntermediaryList(List<PdmsSolutionIntermediaryDto> solutionIntermediaryList) {
		this.solutionIntermediaryList = solutionIntermediaryList;
	}
	
	/**
	 * 获取方案业务映射表
	 */
	public List<PdmsSolutionMappingDto> getSolutionMappingList() {
		return solutionMappingList;
	}
	
	/**
	 * 设置方案业务映射表
	 */
	public void setSolutionMappingList(List<PdmsSolutionMappingDto> solutionMappingList) {
		this.solutionMappingList = solutionMappingList;
	}
	
	/**
	 * 获取方案消息通知配置表
	 */
	public List<PdmsSolutionMessageDto> getSolutionMessageList() {
		return solutionMessageList;
	}
	
	/**
	 * 设置方案消息通知配置表
	 */
	public void setSolutionMessageList(List<PdmsSolutionMessageDto> solutionMessageList) {
		this.solutionMessageList = solutionMessageList;
	}
	
	/**
	 * 获取方案业务员信息表
	 */
	public List<PdmsSolutionSalesmanDto> getSolutionSalesmanList() {
		return solutionSalesmanList;
	}
	
	/**
	 * 设置方案业务员信息表
	 */
	public void setSolutionSalesmanList(List<PdmsSolutionSalesmanDto> solutionSalesmanList) {
		this.solutionSalesmanList = solutionSalesmanList;
	}

	/**
	 * 获取模板配置信息
	 */
	public TplDefDto getTplDefDto() {
		return tplDefDto;
	}

	/**
	 * 设置模板配置信息
	 */
	public void setTplDefDto(TplDefDto tplDefDto) {
		this.tplDefDto = tplDefDto;
	}

	/** 电子保单信息 */
	public SolutionEpolicyDto getSolutionEpolicyDto () {
		return solutionEpolicyDto;
	}

	/** 电子保单信息 */
	public void setSolutionEpolicyDto ( SolutionEpolicyDto solutionEpolicyDto ) {
		this.solutionEpolicyDto = solutionEpolicyDto;
	}
}
