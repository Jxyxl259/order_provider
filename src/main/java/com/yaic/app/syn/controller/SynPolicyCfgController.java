/*
 * Created By lujicong (2017-03-23 14:12:08)
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
import com.yaic.app.syn.dto.domain.SynPolicyCfgDto;
import com.yaic.app.syn.service.SynPolicyCfgService;

@Controller
@RequestMapping("synPolicyCfg")
public class SynPolicyCfgController {

    @Autowired
    private SynPolicyCfgService synPolicyCfgService;

    /**
     * 主页面
     */
    @RequestMapping
    public String index(HttpServletRequest request) {
        
        request.setAttribute("synPolicyCfgList", synPolicyCfgService.selectOrderBy(null, "dealType"));
        
        return "syn/synPolicyCfg/synPolicyCfg";
    }

    /**
     * 列表
     */
    @ResponseBody
    @RequestMapping(value = "list", method = RequestMethod.POST)
    public JqGridPageDto<SynPolicyCfgDto> list(@RequestBody SynPolicyCfgDto synPolicyCfgDto)
            throws Exception {

        PageDto<SynPolicyCfgDto> pageDto = new PageDto<SynPolicyCfgDto>();
        pageDto.setPageNo(synPolicyCfgDto.getPage());
        pageDto.setPageSize(synPolicyCfgDto.getRows());
        pageDto = synPolicyCfgService.selectByPage(
                pageDto, synPolicyCfgDto, synPolicyCfgDto.getSidx() + " " + synPolicyCfgDto.getSord());

        JqGridPageDto<SynPolicyCfgDto> pageDataDto = new JqGridPageDto<SynPolicyCfgDto>();

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
    public Map<String, Object> prepareInsert(@RequestBody SynPolicyCfgDto synPolicyCfgDto) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        
        synPolicyCfgDto = new SynPolicyCfgDto();
        
        resultMap.put("synPolicyCfgDto", synPolicyCfgDto);
        return resultMap;
    }

    /**
     * 新增
     */
    @ResponseBody
    @RequestMapping(value = "/insert")
    public Map<String, Object> insert(@RequestBody SynPolicyCfgDto synPolicyCfgDto, HttpServletRequest request) throws Exception {

        Map<String, Object> resultMap = new HashMap<String, Object>();
        if(synPolicyCfgService.selectByPrimaryKey(synPolicyCfgDto) != null) {
            resultMap.put("flag", "N");
            resultMap.put("msg", "已存在该取数类型");
            return resultMap;
        }
        
        String loginUserId = (String)request.getSession().getAttribute(Constants.LOGIN_USER_ID_KEY);
        synPolicyCfgDto.setCreatedUser(loginUserId);
        synPolicyCfgDto.setCreatedDate(new Date());
        synPolicyCfgDto.setUpdatedUser(loginUserId);
        synPolicyCfgDto.setUpdatedDate(synPolicyCfgDto.getCreatedDate());
        synPolicyCfgService.insertNotNull(synPolicyCfgDto);

        resultMap.put("flag", "Y");
        resultMap.put("msg", "保存处理成功");
        return resultMap;
    }

    /**
     * 预修改
     */
    @ResponseBody
    @RequestMapping(value = "/prepareUpdate")
    public Map<String, Object> prepareUpdate(@RequestBody SynPolicyCfgDto synPolicyCfgDto) throws Exception {

        synPolicyCfgDto = synPolicyCfgService.selectByPrimaryKey(synPolicyCfgDto);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("synPolicyCfgDto", synPolicyCfgDto);
        return resultMap;
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping(value = "/update")
    public Map<String, Object> update(@RequestBody SynPolicyCfgDto synPolicyCfgDto, HttpServletRequest request) throws Exception {
        
        Map<String, Object> resultMap = new HashMap<String, Object>();
        if("6,7".indexOf(synPolicyCfgDto.getDealType()) > -1) {
            if(synPolicyCfgDto.getDealBeforeDate() < 1) {
                resultMap.put("flag", "N");
                resultMap.put("msg", "处理多少天前数据的值不能小于1天");
                return resultMap;
            }
            if(synPolicyCfgDto.getLimitCount() > 5000) {
                resultMap.put("flag", "N");
                resultMap.put("msg", "一次获取处理条数的值不能大于5000条");
                return resultMap;
            }
        }
        
        synPolicyCfgDto.setUpdatedUser((String)request.getSession().getAttribute(Constants.LOGIN_USER_ID_KEY));
        synPolicyCfgDto.setUpdatedDate(new Date());
        synPolicyCfgService.updateByPrimaryKey(synPolicyCfgDto);

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
    public Map<String, Object> delete(@RequestBody JsonRequest<SynPolicyCfgDto> jsonRequest) throws Exception {

        List<SynPolicyCfgDto>  synPolicyCfgList = JSON.parseArray((jsonRequest.getExtend().get("synPolicyCfgList")), SynPolicyCfgDto.class);

        for(SynPolicyCfgDto synPolicyCfgDto : synPolicyCfgList) {
            synPolicyCfgService.deleteByPrimaryKey(synPolicyCfgDto);
        }

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("flag", "Y");
        resultMap.put("msg", "删除处理成功");
        return resultMap;
    }

}