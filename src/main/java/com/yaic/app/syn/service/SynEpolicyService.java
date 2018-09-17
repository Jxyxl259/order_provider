/*
 * Created By lujicong (2017-03-20 14:44:31)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.syn.service;

import java.util.List;

import com.yaic.app.epolicy.dto.msg.common.EpolicyResponseMessage;
import com.yaic.app.order.dto.msg.common.OrderDto;
import com.yaic.app.syn.dto.domain.SynEpolicyDto;
import com.yaic.fa.mybatis.pagehelper.PageInfo;
import com.yaic.fa.service.IBaseService;

public interface SynEpolicyService extends IBaseService<SynEpolicyDto> {

    public PageInfo<SynEpolicyDto> findPageInfo(int page, int rows, SynEpolicyDto synEpolicyDto, String orderBy);
    
    public int deleteSynEpolicyData(SynEpolicyDto synEpolicyDto);
    
    public String taskSynEpolicyDeal();
    
    public String taskSynEpolicyDealDesc();
    
    public int taskSynEpolicyDealProcess(List<SynEpolicyDto> synEpolicyList);
    
    public String taskSynEpolicyProcessDeal();
    
    public int synEpolicyProcessDeal(List<SynEpolicyDto> synEpolicyList);
    
    /**
	 * 获取电子保单模板，封装并传到电子保单系统
	 * <p>User: glizhen
	 * <p>Date: 2018年6月25日
	 * <p>Version: 1.0
	 * @throws Exception 
	 */
    public EpolicyResponseMessage dealEpolicyInfo(List<OrderDto> orderList) throws Exception;
}