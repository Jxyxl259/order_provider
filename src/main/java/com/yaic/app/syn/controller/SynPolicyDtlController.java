/*
 * Created By lujicong (2017-03-20 14:44:32)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.syn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.yaic.fa.dto.JqGridPageDto;
import com.yaic.fa.dto.JsonRequest;
import com.yaic.fa.dto.PageDto;

import com.yaic.app.syn.dto.domain.SynPolicyDtlDto;
import com.yaic.app.syn.service.SynPolicyDtlService;

@Controller
@RequestMapping("synPolicyDtl")
public class SynPolicyDtlController {

    @Autowired
    private SynPolicyDtlService synPolicyDtlService;

    /**
     * 主页面
     */
    @RequestMapping
    public String index(HttpServletRequest request) {
        return "syn/synPolicyDtl/synPolicyDtl";
    }

    /**
     * 列表
     */
    @ResponseBody
    @RequestMapping(value = "list", method = RequestMethod.POST)
    public JqGridPageDto<SynPolicyDtlDto> list(@RequestBody SynPolicyDtlDto synPolicyDtlDto)
            throws Exception {

        PageDto<SynPolicyDtlDto> pageDto = new PageDto<SynPolicyDtlDto>();
        pageDto.setPageNo(synPolicyDtlDto.getPage());
        pageDto.setPageSize(synPolicyDtlDto.getRows());
        pageDto = synPolicyDtlService.selectByPage(
                pageDto, synPolicyDtlDto, synPolicyDtlDto.getSidx() + " " + synPolicyDtlDto.getSord());

        JqGridPageDto<SynPolicyDtlDto> pageDataDto = new JqGridPageDto<SynPolicyDtlDto>();

        pageDataDto.setPage(pageDto.getPageNo());
        pageDataDto.setRecords(pageDto.getTotalSize());
        pageDataDto.setRows(pageDto.getResults());
        pageDataDto.setTotal(pageDto.getTotalPage());
        return pageDataDto;
    }

    /**
     * 预新增
     */
    @ResponseBody
    @RequestMapping(value = "/prepareInsert")
    public Map<String, Object> prepareInsert(@RequestBody SynPolicyDtlDto synPolicyDtlDto) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        
        synPolicyDtlDto = new SynPolicyDtlDto();
        
        resultMap.put("synPolicyDtlDto", synPolicyDtlDto);
        return resultMap;
    }

    /**
     * 新增
     */
    @ResponseBody
    @RequestMapping(value = "/insert")
    public Map<String, Object> insert(@RequestBody SynPolicyDtlDto synPolicyDtlDto) throws Exception {

        synPolicyDtlService.insertNotNull(synPolicyDtlDto);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("flag", "Y");
        resultMap.put("msg", "保存处理成功");
        return resultMap;
    }

    /**
     * 预修改
     */
    @ResponseBody
    @RequestMapping(value = "/prepareUpdate")
    public Map<String, Object> prepareUpdate(@RequestBody SynPolicyDtlDto synPolicyDtlDto) throws Exception {

        synPolicyDtlDto = synPolicyDtlService.selectByPrimaryKey(synPolicyDtlDto);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("synPolicyDtlDto", synPolicyDtlDto);
        return resultMap;
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping(value = "/update")
    public Map<String, Object> update(@RequestBody SynPolicyDtlDto synPolicyDtlDto) throws Exception {

        synPolicyDtlService.updateByPrimaryKey(synPolicyDtlDto);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("flag", "Y");
        resultMap.put("msg", "修改处理成功");
        return resultMap;
    }

    /**
     * 删除
     */
    @ResponseBody
    @Transactional
    @RequestMapping(value = "/delete")
    public Map<String, Object> delete(@RequestBody JsonRequest<SynPolicyDtlDto> jsonRequest) throws Exception {

        List<SynPolicyDtlDto>  synPolicyDtlList = JSON.parseArray((jsonRequest.getExtend().get("synPolicyDtlList")), SynPolicyDtlDto.class);

        for(SynPolicyDtlDto synPolicyDtlDto : synPolicyDtlList) {
            synPolicyDtlService.deleteByPrimaryKey(synPolicyDtlDto);
        }

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("flag", "Y");
        resultMap.put("msg", "删除处理成功");
        return resultMap;
    }

}