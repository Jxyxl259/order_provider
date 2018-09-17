/*
 * Created By lujicong (2017-05-11 10:25:33)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.syn.controller;

import java.util.Date;
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
import com.yaic.fa.util.UuidUtils;

import com.yaic.app.Constants;
import com.yaic.app.syn.dto.domain.SynPolicyFilterCfgDto;
import com.yaic.app.syn.service.SynPolicyFilterCfgService;

@Controller
@RequestMapping("synPolicyFilterCfg")
public class SynPolicyFilterCfgController {

    @Autowired
    private SynPolicyFilterCfgService synPolicyFilterCfgService;

    /**
     * 主页面
     */
    @RequestMapping
    public String index(HttpServletRequest request) {
        return "syn/synPolicyFilterCfg/synPolicyFilterCfg";
    }

    /**
     * 列表
     */
    @ResponseBody
    @RequestMapping(value = "list", method = RequestMethod.POST)
    public JqGridPageDto<SynPolicyFilterCfgDto> list(@RequestBody SynPolicyFilterCfgDto synPolicyFilterCfgDto)
            throws Exception {

        PageDto<SynPolicyFilterCfgDto> pageDto = new PageDto<SynPolicyFilterCfgDto>();
        pageDto.setPageNo(synPolicyFilterCfgDto.getPage());
        pageDto.setPageSize(synPolicyFilterCfgDto.getRows());
        pageDto = synPolicyFilterCfgService.selectByPage(
                pageDto, synPolicyFilterCfgDto, synPolicyFilterCfgDto.getSidx() + " " + synPolicyFilterCfgDto.getSord());

        JqGridPageDto<SynPolicyFilterCfgDto> pageDataDto = new JqGridPageDto<SynPolicyFilterCfgDto>();

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
    public Map<String, Object> prepareInsert(@RequestBody SynPolicyFilterCfgDto synPolicyFilterCfgDto) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        
        synPolicyFilterCfgDto.setInvalidFlag(0);
        resultMap.put("synPolicyFilterCfgDto", synPolicyFilterCfgDto);
        return resultMap;
    }

    /**
     * 新增
     */
    @ResponseBody
    @RequestMapping(value = "/insert")
    public Map<String, Object> insert(@RequestBody SynPolicyFilterCfgDto synPolicyFilterCfgDto, HttpServletRequest request) throws Exception {

        String loginUserId = (String)request.getSession().getAttribute(Constants.LOGIN_USER_ID_KEY);
        synPolicyFilterCfgDto.setCreatedUser(loginUserId);
        synPolicyFilterCfgDto.setCreatedDate(new Date());
        synPolicyFilterCfgDto.setUpdatedUser(loginUserId);
        synPolicyFilterCfgDto.setUpdatedDate(synPolicyFilterCfgDto.getCreatedDate());
        synPolicyFilterCfgDto.setFilterCfgId(UuidUtils.getUuid());
        synPolicyFilterCfgService.insertNotNull(synPolicyFilterCfgDto);

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
    public Map<String, Object> prepareUpdate(@RequestBody SynPolicyFilterCfgDto synPolicyFilterCfgDto) throws Exception {

        synPolicyFilterCfgDto = synPolicyFilterCfgService.selectByPrimaryKey(synPolicyFilterCfgDto);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("synPolicyFilterCfgDto", synPolicyFilterCfgDto);
        return resultMap;
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping(value = "/update")
    public Map<String, Object> update(@RequestBody SynPolicyFilterCfgDto synPolicyFilterCfgDto, HttpServletRequest request) throws Exception {

        synPolicyFilterCfgDto.setUpdatedUser((String)request.getSession().getAttribute(Constants.LOGIN_USER_ID_KEY));
        synPolicyFilterCfgDto.setUpdatedDate(new Date());
        synPolicyFilterCfgService.updateByPrimaryKey(synPolicyFilterCfgDto);

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
    public Map<String, Object> delete(@RequestBody JsonRequest<SynPolicyFilterCfgDto> jsonRequest) throws Exception {

        List<SynPolicyFilterCfgDto>  synPolicyFilterCfgList = JSON.parseArray((jsonRequest.getExtend().get("synPolicyFilterCfgList")), SynPolicyFilterCfgDto.class);

        for(SynPolicyFilterCfgDto synPolicyFilterCfgDto : synPolicyFilterCfgList) {
            synPolicyFilterCfgService.deleteByPrimaryKey(synPolicyFilterCfgDto);
        }

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("flag", "Y");
        resultMap.put("msg", "删除处理成功");
        return resultMap;
    }

}