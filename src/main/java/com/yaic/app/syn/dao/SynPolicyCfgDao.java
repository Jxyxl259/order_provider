/*
 * Created By lujicong (2017-03-23 14:12:08)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.syn.dao;

import java.util.List;

import com.yaic.app.syn.dto.domain.SynPolicyCfgDto;
import com.yaic.fa.dao.BaseDao;

public interface SynPolicyCfgDao extends BaseDao<SynPolicyCfgDto> {

    public List<SynPolicyCfgDto> findPageInfo(SynPolicyCfgDto synPolicyCfgDto);

}