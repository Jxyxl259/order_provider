/*
 * Created By lujicong (2017-05-11 10:25:33)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.syn.service;

import com.yaic.fa.service.IBaseService;
import com.yaic.fa.mybatis.pagehelper.PageInfo;
import com.yaic.app.syn.dto.domain.SynPolicyFilterCfgDto;

public interface SynPolicyFilterCfgService extends IBaseService<SynPolicyFilterCfgDto> {

    public PageInfo<SynPolicyFilterCfgDto> findPageInfo(int page, int rows, SynPolicyFilterCfgDto synPolicyFilterCfgDto, String orderBy);

}