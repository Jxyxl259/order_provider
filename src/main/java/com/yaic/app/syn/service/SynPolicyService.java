/*
 * Created By lujicong (2017-03-20 14:44:31)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.syn.service;

import java.util.List;

import com.yaic.fa.service.IBaseService;
import com.yaic.fa.mybatis.pagehelper.PageInfo;
import com.yaic.app.syn.dto.domain.SynPolicyDto;

public interface SynPolicyService extends IBaseService<SynPolicyDto> {

    public PageInfo<SynPolicyDto> findPageInfo(int page, int rows, SynPolicyDto synPolicyDto, String orderBy);
    
    public int deleteSynPolicyData(SynPolicyDto synPolicyDto);
    
    public String taskSynPolicyDeal();
    
    public String taskSynPolicyDealDesc();
    
    public int taskSynPolicyDealProcess(List<SynPolicyDto> synPolicyList);
    
    public String taskSynPolicyProcessDeal();
    
    public int synPolicyProcessDeal(List<SynPolicyDto> synPolicyList);
    
    public int querySynPolicyCount(SynPolicyDto synPolicyDto);
}