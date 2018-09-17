/*
 * Created By lujicong (2017-05-11 10:25:33)
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

import com.yaic.app.syn.dao.SynPolicyFilterCfgDao;
import com.yaic.app.syn.dto.domain.SynPolicyFilterCfgDto;
import com.yaic.app.syn.service.SynPolicyFilterCfgService;

@Service("synPolicyFilterCfgService")
public class SynPolicyFilterCfgServiceImpl extends BaseService<SynPolicyFilterCfgDto> implements SynPolicyFilterCfgService {

    @Autowired
    private SynPolicyFilterCfgDao synPolicyFilterCfgDao;

    @Override
    public PageInfo<SynPolicyFilterCfgDto> findPageInfo(int page, int rows, SynPolicyFilterCfgDto synPolicyFilterCfgDto, String orderBy) {
        PageHelper.startPage(page, rows, orderBy);
        List<SynPolicyFilterCfgDto> list = synPolicyFilterCfgDao.findPageInfo(synPolicyFilterCfgDto);
        return new PageInfo<SynPolicyFilterCfgDto>(list);
    }

}