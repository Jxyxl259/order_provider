/*
 * Created By lujicong (2017-03-20 14:44:31)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.syn.dao;

import java.util.List;

import com.yaic.app.syn.dto.domain.SynEpolicyDto;
import com.yaic.fa.dao.BaseDao;

public interface SynEpolicyDao extends BaseDao<SynEpolicyDto> {

    public List<SynEpolicyDto> findPageInfo(SynEpolicyDto synEpolicyDto);
    
    public List<SynEpolicyDto> findSynEpolicyData(SynEpolicyDto synEpolicyDto);
    
    public List<SynEpolicyDto> findSynEpolicyProcessData(SynEpolicyDto synEpolicyDto);
    
    public int updateSynEpolicyProcessData(SynEpolicyDto synEpolicyDto);
    
    public int deleteSynEpolicyData(SynEpolicyDto synEpolicyDto);
    
}