/*
 * Created By lujicong (2017-03-20 14:44:32)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.syn.service;

import com.yaic.fa.service.IBaseService;
import com.yaic.fa.mybatis.pagehelper.PageInfo;
import com.yaic.app.syn.dto.domain.SynPolicyDtlDto;

public interface SynPolicyDtlService extends IBaseService<SynPolicyDtlDto> {

    public PageInfo<SynPolicyDtlDto> findPageInfo(int page, int rows, SynPolicyDtlDto synPolicyDtlDto, String orderBy);

    public int deleteSynPolicyDtlData(SynPolicyDtlDto synPolicyDtlDto);
    
}