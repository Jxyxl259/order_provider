/*
 * Created By lujicong (2017-03-21 14:21:47)
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

import com.yaic.app.syn.dao.SynPolicyCfgDao;
import com.yaic.app.syn.dto.domain.SynPolicyCfgDto;
import com.yaic.app.syn.service.SynPolicyCfgService;

@Service("synPolicyCfgService")
public class SynPolicyCfgServiceImpl extends BaseService<SynPolicyCfgDto> implements SynPolicyCfgService {

    @Autowired
    private SynPolicyCfgDao synPolicyCfgDao;

    public PageInfo<SynPolicyCfgDto> findPageInfo(int page, int rows, SynPolicyCfgDto synPolicyCfgDto, String orderBy) {
        PageHelper.startPage(page, rows, orderBy);
        List<SynPolicyCfgDto> list = synPolicyCfgDao.findPageInfo(synPolicyCfgDto);
        return new PageInfo<SynPolicyCfgDto>(list);
    }

}