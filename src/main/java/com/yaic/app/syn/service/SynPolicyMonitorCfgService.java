/*
 * Created By lujicong (2017-03-31 20:02:28)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.syn.service;

import com.yaic.fa.service.IBaseService;
import com.yaic.fa.mybatis.pagehelper.PageInfo;
import com.yaic.app.syn.dto.domain.SynPolicyMonitorCfgDto;

public interface SynPolicyMonitorCfgService extends IBaseService<SynPolicyMonitorCfgDto> {

    public PageInfo<SynPolicyMonitorCfgDto> findPageInfo(int page, int rows, SynPolicyMonitorCfgDto synPolicyMonitorCfgDto, String orderBy);
    
    public String monitorSynPolicyData();
    
    public void synPolicyMonitor(String monitorType, int count);

}