/*
 * Created By lujicong (2017-05-11 10:25:33)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.syn.dao;

import java.util.List;

import com.yaic.app.syn.dto.domain.SynPolicyFilterCfgDto;
import com.yaic.fa.dao.BaseDao;

public interface SynPolicyFilterCfgDao extends BaseDao<SynPolicyFilterCfgDto> {

    public List<SynPolicyFilterCfgDto> findPageInfo(SynPolicyFilterCfgDto synPolicyFilterCfgDto);

}