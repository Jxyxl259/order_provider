/*
 * Created By lujicong (2017-03-22 10:38:44)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.syn.controller;

import java.util.ArrayList;
import java.util.Calendar;
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
import com.yaic.fa.mybatis.pagehelper.PageInfo;
import com.yaic.servicelayer.util.CollectionUtil;
import com.yaic.app.syn.dto.domain.SynPolicySurrenderDto;
import com.yaic.app.syn.service.SynPolicySurrenderService;

@Controller
@RequestMapping("synPolicySurrender")
public class SynPolicySurrenderController {

    @Autowired
    private SynPolicySurrenderService synPolicySurrenderService;

    /**
     * 主页面
     */
    @RequestMapping
    public String index(HttpServletRequest request) {
        request.setAttribute("processPage", "0");
        return "syn/synPolicySurrender/synPolicySurrender";
    }
    
    /**
     * 处理中主页面
     */
    @RequestMapping(value = "/indexProcess")
    public String indexProcess(HttpServletRequest request) {
        request.setAttribute("processPage", "1");
        return "syn/synPolicySurrender/synPolicySurrender";
    }

    /**
     * 列表
     */
    @ResponseBody
    @RequestMapping(value = "list", method = RequestMethod.POST)
    public JqGridPageDto<SynPolicySurrenderDto> list(@RequestBody SynPolicySurrenderDto synPolicySurrenderDto)
            throws Exception {

        PageDto<SynPolicySurrenderDto> pageDto = new PageDto<SynPolicySurrenderDto>();
        pageDto.setPageNo(synPolicySurrenderDto.getPage());
        pageDto.setPageSize(synPolicySurrenderDto.getRows());
        pageDto = synPolicySurrenderService.selectByPage(
                pageDto, synPolicySurrenderDto, synPolicySurrenderDto.getSidx() + " " + synPolicySurrenderDto.getSord());

        JqGridPageDto<SynPolicySurrenderDto> pageDataDto = new JqGridPageDto<SynPolicySurrenderDto>();

        pageDataDto.setPage(pageDto.getPageNo());
        pageDataDto.setRecords(pageDto.getTotalSize());
        pageDataDto.setRows(pageDto.getResults());
        pageDataDto.setTotal(pageDto.getTotalPage());
        return pageDataDto;
    }
    
    /**
     * 列表
     */
    @ResponseBody
    @RequestMapping(value = "processList", method = RequestMethod.POST)
    public JqGridPageDto<SynPolicySurrenderDto> processList(@RequestBody SynPolicySurrenderDto synPolicySurrenderDto)
            throws Exception {
        
        // 固定查询条件:处理中及最后更新时间为前三个小时
        Calendar rightNow = Calendar.getInstance();
        rightNow.set(Calendar.HOUR_OF_DAY, rightNow.get(Calendar.HOUR_OF_DAY) - 3);
        synPolicySurrenderDto.setUpdatedDate(rightNow.getTime());
        synPolicySurrenderDto.setDealStatus("1");
        
        PageInfo<SynPolicySurrenderDto> pageInfo = synPolicySurrenderService.findPageInfo(synPolicySurrenderDto.getPage(), 
                synPolicySurrenderDto.getRows(), synPolicySurrenderDto, synPolicySurrenderDto.getSidx() + " " + synPolicySurrenderDto.getSord());

        JqGridPageDto<SynPolicySurrenderDto> pageDataDto = new JqGridPageDto<SynPolicySurrenderDto>();

        pageDataDto.setPage(pageInfo.getPageNum());
        pageDataDto.setRecords(pageInfo.getTotal());
        pageDataDto.setRows(pageInfo.getList());
        pageDataDto.setTotal(pageInfo.getPages());
        return pageDataDto;
    }

    /**
     * 预新增
     */
    @ResponseBody
    @RequestMapping(value = "/prepareInsert")
    public Map<String, Object> prepareInsert(@RequestBody SynPolicySurrenderDto synPolicySurrenderDto) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        
        synPolicySurrenderDto = new SynPolicySurrenderDto();
        
        resultMap.put("synPolicySurrenderDto", synPolicySurrenderDto);
        return resultMap;
    }

    /**
     * 新增
     */
    @ResponseBody
    @RequestMapping(value = "/insert")
    public Map<String, Object> insert(@RequestBody SynPolicySurrenderDto synPolicySurrenderDto) throws Exception {

        synPolicySurrenderService.insertNotNull(synPolicySurrenderDto);

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
    public Map<String, Object> prepareUpdate(@RequestBody SynPolicySurrenderDto synPolicySurrenderDto) throws Exception {

        synPolicySurrenderDto = synPolicySurrenderService.selectByPrimaryKey(synPolicySurrenderDto);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("synPolicySurrenderDto", synPolicySurrenderDto);
        return resultMap;
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping(value = "/update")
    public Map<String, Object> update(@RequestBody SynPolicySurrenderDto synPolicySurrenderDto) throws Exception {

        synPolicySurrenderService.updateByPrimaryKey(synPolicySurrenderDto);

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
    public Map<String, Object> delete(@RequestBody JsonRequest<SynPolicySurrenderDto> jsonRequest) throws Exception {

        List<SynPolicySurrenderDto>  synPolicySurrenderList = JSON.parseArray((jsonRequest.getExtend().get("synPolicySurrenderList")), SynPolicySurrenderDto.class);

        for(SynPolicySurrenderDto synPolicySurrenderDto : synPolicySurrenderList) {
            synPolicySurrenderService.deleteByPrimaryKey(synPolicySurrenderDto);
        }

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("flag", "Y");
        resultMap.put("msg", "删除处理成功");
        return resultMap;
    }
    
    /**
     * 手工触发退保保单同步
     */
    @ResponseBody
    @RequestMapping(value = "/synPolicySurrenderDealManual")
    public Map<String, Object> synPolicySurrenderDealManual(@RequestBody JsonRequest<SynPolicySurrenderDto> jsonRequest) throws Exception {

        Map<String, Object> resultMap = new HashMap<String, Object>();
        
        List<SynPolicySurrenderDto>  synPolicySurrenders = JSON.parseArray((jsonRequest.getExtend().get("synPolicySurrenderList")), SynPolicySurrenderDto.class);
        
        int count = 0;
        if(CollectionUtil.isNotEmpty(synPolicySurrenders)) {
            List<SynPolicySurrenderDto> synPolicySurrenderList = new ArrayList<SynPolicySurrenderDto>();
            SynPolicySurrenderDto synPolicySurrenderDto = null;
            for(SynPolicySurrenderDto item : synPolicySurrenders) {
                synPolicySurrenderDto = new SynPolicySurrenderDto();
                synPolicySurrenderDto.setOrderCode(item.getOrderCode());
                synPolicySurrenderDto.setPolicyNo(item.getPolicyNo());
                synPolicySurrenderDto = synPolicySurrenderService.selectByPrimaryKey(synPolicySurrenderDto);
                if(synPolicySurrenderDto != null) {
                    synPolicySurrenderList.add(synPolicySurrenderDto);
                }
            }
            count = synPolicySurrenderService.taskSynPolicySurrenderDealProcess(synPolicySurrenderList);
        }else {
            resultMap.put("flag", "N");
            resultMap.put("msg", "请选择记录");
            return resultMap;
        }
        resultMap.put("flag", "Y");
        resultMap.put("msg", "手工触发处理成功,实际处理"+count+"条,请查看同步情况");
        return resultMap;
    }
    
    /**
     * 手工触发退保保单同步异常情况状态一直处于处理中数据处理
     */
    @ResponseBody
    @RequestMapping(value = "/synPolicySurrenderProcessDealManual")
    public Map<String, Object> synPolicySurrenderProcessDealManual(@RequestBody JsonRequest<SynPolicySurrenderDto> jsonRequest) throws Exception {

        Map<String, Object> resultMap = new HashMap<String, Object>();
        
        List<SynPolicySurrenderDto>  synPolicySurrenderList = JSON.parseArray((jsonRequest.getExtend().get("synPolicySurrenderList")), SynPolicySurrenderDto.class);
        
        int count = 0;
        if(CollectionUtil.isNotEmpty(synPolicySurrenderList)) {
            count = synPolicySurrenderService.synPolicySurrenderProcessDeal(synPolicySurrenderList);
        }else {
            resultMap.put("flag", "N");
            resultMap.put("msg", "请选择记录");
            return resultMap;
        }
        resultMap.put("flag", "Y");
        resultMap.put("msg", "手工触发处理成功,实际处理"+count+"条,请查看同步情况");
        return resultMap;
    }

}