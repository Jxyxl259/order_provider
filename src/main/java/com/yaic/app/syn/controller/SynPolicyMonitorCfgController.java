/*
 * Created By lujicong (2017-03-31 20:02:28)
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

import com.yaic.app.Constants;
import com.yaic.app.syn.dto.domain.SynPolicyMonitorCfgDto;
import com.yaic.app.syn.service.SynPolicyMonitorCfgService;

@Controller
@RequestMapping("synPolicyMonitorCfg")
public class SynPolicyMonitorCfgController {

    @Autowired
    private SynPolicyMonitorCfgService synPolicyMonitorCfgService;

    /**
     * 主页面
     */
    @RequestMapping
    public String index(HttpServletRequest request) {
        
        request.setAttribute("synPolicyMonitorCfgList",synPolicyMonitorCfgService.selectOrderBy(null, "monitorType"));
        
        return "syn/synPolicyMonitorCfg/synPolicyMonitorCfg";
    }

    /**
     * 列表
     */
    @ResponseBody
    @RequestMapping(value = "list", method = RequestMethod.POST)
    public JqGridPageDto<SynPolicyMonitorCfgDto> list(@RequestBody SynPolicyMonitorCfgDto synPolicyMonitorCfgDto)
            throws Exception {

        PageDto<SynPolicyMonitorCfgDto> pageDto = new PageDto<SynPolicyMonitorCfgDto>();
        pageDto.setPageNo(synPolicyMonitorCfgDto.getPage());
        pageDto.setPageSize(synPolicyMonitorCfgDto.getRows());
        pageDto = synPolicyMonitorCfgService.selectByPage(
                pageDto, synPolicyMonitorCfgDto, synPolicyMonitorCfgDto.getSidx() + " " + synPolicyMonitorCfgDto.getSord());

        JqGridPageDto<SynPolicyMonitorCfgDto> pageDataDto = new JqGridPageDto<SynPolicyMonitorCfgDto>();

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
    public Map<String, Object> prepareInsert(@RequestBody SynPolicyMonitorCfgDto synPolicyMonitorCfgDto) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        
        synPolicyMonitorCfgDto = new SynPolicyMonitorCfgDto();
        synPolicyMonitorCfgDto.setSmsSwitch(0);
        synPolicyMonitorCfgDto.setEmailSwitch(0);
        resultMap.put("synPolicyMonitorCfgDto", synPolicyMonitorCfgDto);
        return resultMap;
    }

    /**
     * 新增
     */
    @ResponseBody
    @RequestMapping(value = "/insert")
    public Map<String, Object> insert(@RequestBody SynPolicyMonitorCfgDto synPolicyMonitorCfgDto, HttpServletRequest request) throws Exception {

        Map<String, Object> resultMap = new HashMap<String, Object>();
        if(synPolicyMonitorCfgService.selectByPrimaryKey(synPolicyMonitorCfgDto) != null) {
            resultMap.put("flag", "N");
            resultMap.put("msg", "已存在该取数类型");
            return resultMap;
        }
        
        String loginUserId = (String)request.getSession().getAttribute(Constants.LOGIN_USER_ID_KEY);
        synPolicyMonitorCfgDto.setCreatedUser(loginUserId);
        synPolicyMonitorCfgDto.setCreatedDate(new Date());
        synPolicyMonitorCfgDto.setUpdatedUser(loginUserId);
        synPolicyMonitorCfgDto.setUpdatedDate(synPolicyMonitorCfgDto.getCreatedDate());
        synPolicyMonitorCfgService.insertNotNull(synPolicyMonitorCfgDto);

        resultMap.put("flag", "Y");
        resultMap.put("msg", "保存处理成功");
        return resultMap;
    }

    /**
     * 预修改
     */
    @ResponseBody
    @RequestMapping(value = "/prepareUpdate")
    public Map<String, Object> prepareUpdate(@RequestBody SynPolicyMonitorCfgDto synPolicyMonitorCfgDto) throws Exception {

        synPolicyMonitorCfgDto = synPolicyMonitorCfgService.selectByPrimaryKey(synPolicyMonitorCfgDto);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("synPolicyMonitorCfgDto", synPolicyMonitorCfgDto);
        return resultMap;
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping(value = "/update")
    public Map<String, Object> update(@RequestBody SynPolicyMonitorCfgDto synPolicyMonitorCfgDto, HttpServletRequest request) throws Exception {

        synPolicyMonitorCfgDto.setUpdatedUser((String)request.getSession().getAttribute(Constants.LOGIN_USER_ID_KEY));
        synPolicyMonitorCfgDto.setUpdatedDate(new Date());
        synPolicyMonitorCfgService.updateByPrimaryKey(synPolicyMonitorCfgDto);

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
    public Map<String, Object> delete(@RequestBody JsonRequest<SynPolicyMonitorCfgDto> jsonRequest) throws Exception {

        List<SynPolicyMonitorCfgDto>  synPolicyMonitorCfgList = JSON.parseArray((jsonRequest.getExtend().get("synPolicyMonitorCfgList")), SynPolicyMonitorCfgDto.class);

        for(SynPolicyMonitorCfgDto synPolicyMonitorCfgDto : synPolicyMonitorCfgList) {
            synPolicyMonitorCfgService.deleteByPrimaryKey(synPolicyMonitorCfgDto);
        }

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("flag", "Y");
        resultMap.put("msg", "删除处理成功");
        return resultMap;
    }

}