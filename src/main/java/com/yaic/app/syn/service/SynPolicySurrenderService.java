/*
 * Created By lujicong (2017-03-22 10:38:44)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.syn.service;

import java.util.List;

import com.yaic.fa.service.IBaseService;
import com.yaic.fa.mybatis.pagehelper.PageInfo;
import com.yaic.app.syn.dto.domain.SynPolicySurrenderDto;

public interface SynPolicySurrenderService extends IBaseService<SynPolicySurrenderDto> {

    public PageInfo<SynPolicySurrenderDto> findPageInfo(int page, int rows, SynPolicySurrenderDto synPolicySurrenderDto, String orderBy);
    
    public int deleteSynPolicySurrenderData(SynPolicySurrenderDto synPolicySurrenderDto);

    public String taskSynPolicySurrenderDeal();
    
    public String taskSynPolicySurrenderDealDesc();
    
    public int taskSynPolicySurrenderDealProcess(List<SynPolicySurrenderDto> synPolicySurrenderList);
    
    public String taskSynPolicySurrenderProcessDeal();
    
    public int synPolicySurrenderProcessDeal(List<SynPolicySurrenderDto> synPolicySurrenderList);
}