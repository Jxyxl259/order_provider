/*
 * Created By lujicong (2017-03-20 14:44:32)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.syn.dao;

import java.util.List;

import com.yaic.app.syn.dto.domain.SynPolicyDtlDto;
import com.yaic.fa.dao.BaseDao;

public interface SynPolicyDtlDao extends BaseDao<SynPolicyDtlDto> {

    public List<SynPolicyDtlDto> findPageInfo(SynPolicyDtlDto synPolicyDtlDto);
    
    public int deleteSynPolicyDtlData(SynPolicyDtlDto synPolicyDtlDto);

}