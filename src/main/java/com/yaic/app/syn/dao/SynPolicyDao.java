/*
 * Created By lujicong (2017-03-20 14:44:31)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.syn.dao;

import java.util.List;

import com.yaic.app.syn.dto.domain.SynPolicyDto;
import com.yaic.fa.dao.BaseDao;

public interface SynPolicyDao extends BaseDao<SynPolicyDto> {

    public List<SynPolicyDto> findPageInfo(SynPolicyDto synPolicyDto);
    
    public List<SynPolicyDto> findSynPolicyData(SynPolicyDto synPolicyDto);
    
    public List<SynPolicyDto> findSynPolicyProcessData(SynPolicyDto synPolicyDto);
    
    public int updateSynPolicyProcessData(SynPolicyDto synPolicyDto);
    
    public int deleteSynPolicyData(SynPolicyDto synPolicyDto);
    
    public int querySynPolicyCount(SynPolicyDto synPolicyDto);

}