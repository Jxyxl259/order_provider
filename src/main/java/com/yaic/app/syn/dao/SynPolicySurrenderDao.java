/*
 * Created By lujicong (2017-03-22 10:38:44)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.syn.dao;

import java.util.List;

import com.yaic.app.syn.dto.domain.SynPolicySurrenderDto;
import com.yaic.fa.dao.BaseDao;

public interface SynPolicySurrenderDao extends BaseDao<SynPolicySurrenderDto> {

    public List<SynPolicySurrenderDto> findPageInfo(SynPolicySurrenderDto synPolicySurrenderDto);
    
    public List<SynPolicySurrenderDto> findSynPolicySurrenderData(SynPolicySurrenderDto synPolicySurrenderDto);
    
    public List<SynPolicySurrenderDto> findSynPolicySurrenderProcessData(SynPolicySurrenderDto synPolicySurrenderDto);
    
    public int updateSynPolicySurrenderProcessData(SynPolicySurrenderDto synPolicySurrenderDto);
    
    public int deleteSynPolicySurrenderData(SynPolicySurrenderDto synPolicySurrenderDto);

}