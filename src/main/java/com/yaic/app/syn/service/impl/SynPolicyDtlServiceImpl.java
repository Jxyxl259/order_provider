/*
 * Created By lujicong (2017-03-20 14:44:32)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.syn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaic.fa.mybatis.pagehelper.PageHelper;
import com.yaic.fa.mybatis.pagehelper.PageInfo;
import com.yaic.fa.service.BaseService;

import com.yaic.app.syn.dao.SynPolicyDtlDao;
import com.yaic.app.syn.dto.domain.SynPolicyDtlDto;
import com.yaic.app.syn.service.SynPolicyDtlService;

@Service("synPolicyDtlService")
public class SynPolicyDtlServiceImpl extends BaseService<SynPolicyDtlDto> implements SynPolicyDtlService {

    @Autowired
    private SynPolicyDtlDao synPolicyDtlDao;

    @Override
    public PageInfo<SynPolicyDtlDto> findPageInfo(int page, int rows, SynPolicyDtlDto synPolicyDtlDto, String orderBy) {
        PageHelper.startPage(page, rows, orderBy);
        List<SynPolicyDtlDto> list = synPolicyDtlDao.findPageInfo(synPolicyDtlDto);
        return new PageInfo<SynPolicyDtlDto>(list);
    }

    @Override
    public int deleteSynPolicyDtlData(SynPolicyDtlDto synPolicyDtlDto) {
        return synPolicyDtlDao.deleteSynPolicyDtlData(synPolicyDtlDto);
    }
}