/*
 * Created By lujicong (2017-03-21 14:21:47)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.syn.service;

import com.yaic.fa.service.IBaseService;
import com.yaic.fa.mybatis.pagehelper.PageInfo;
import com.yaic.app.syn.dto.domain.SynPolicyCfgDto;

public interface SynPolicyCfgService extends IBaseService<SynPolicyCfgDto> {

    public PageInfo<SynPolicyCfgDto> findPageInfo(int page, int rows, SynPolicyCfgDto synPolicyCfgDto, String orderBy);

}