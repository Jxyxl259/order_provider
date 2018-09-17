/*
 * Created By lujicong (2017-03-31 20:02:28)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.syn.dao;

import java.util.List;

import com.yaic.app.syn.dto.domain.SynPolicyMonitorCfgDto;
import com.yaic.fa.dao.BaseDao;

public interface SynPolicyMonitorCfgDao extends BaseDao<SynPolicyMonitorCfgDto> {

    public List<SynPolicyMonitorCfgDto> findPageInfo(SynPolicyMonitorCfgDto synPolicyMonitorCfgDto);

}