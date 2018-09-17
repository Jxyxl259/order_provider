/*
 * Created By lujicong (2017-03-20 14:44:31)
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
import com.yaic.fa.mybatis.mapper.entity.Condition;
import com.yaic.fa.mybatis.mapper.entity.Condition.Criteria;
import com.yaic.fa.mybatis.pagehelper.PageInfo;
import com.yaic.servicelayer.util.CollectionUtil;
import com.yaic.servicelayer.util.StringUtil;
import com.yaic.app.order.dto.domain.OrderMainDto;
import com.yaic.app.order.service.OrderMainService;
import com.yaic.app.syn.dto.domain.SynPolicyDto;
import com.yaic.app.syn.service.SynPolicyDataService;
import com.yaic.app.syn.service.SynPolicyService;

@Controller
@RequestMapping("synPolicy")
public class SynPolicyController {

    @Autowired
    private SynPolicyService synPolicyService;
    @Autowired
    private OrderMainService orderMainService;
    @Autowired
    private SynPolicyDataService synPolicyDataService;

    /**
     * 主页面
     */
    @RequestMapping
    public String index(HttpServletRequest request) {
        request.setAttribute("processPage", "0");
        return "syn/synPolicy/synPolicy";
    }

    /**
     * 处理中主页面
     */
    @RequestMapping(value = "/indexProcess")
    public String indexProcess(HttpServletRequest request) {
        request.setAttribute("processPage", "1");
        return "syn/synPolicy/synPolicy";
    }

    /**
     * 列表
     */
    @ResponseBody
    @RequestMapping(value = "list", method = RequestMethod.POST)
    public JqGridPageDto<SynPolicyDto> list(@RequestBody SynPolicyDto synPolicyDto) throws Exception {

        JqGridPageDto<SynPolicyDto> pageDataDto = new JqGridPageDto<SynPolicyDto>();

        Condition condition = new Condition(SynPolicyDto.class);
        Criteria criteria = condition.createCriteria();
        if (synPolicyDto.getOrderCode() != null) {
            criteria.andEqualTo("orderCode", synPolicyDto.getOrderCode());
        }
        if (StringUtil.isNotEmpty(synPolicyDto.getDealStatus())) {
            criteria.andEqualTo("dealStatus", synPolicyDto.getDealStatus());
        }

        condition.setOrderByClause(synPolicyDto.getSidx() + " " + synPolicyDto.getSord());

        if (synPolicyDto.getOrderCode() == null && StringUtil.isNotEmpty(synPolicyDto.getPolicyNo())) {
            OrderMainDto orderMainDto = new OrderMainDto();
            orderMainDto.setPolicyNo(synPolicyDto.getPolicyNo());
            List<OrderMainDto> orderMainList = orderMainService.select(orderMainDto);
            if (CollectionUtil.isNotEmpty(orderMainList)) {
                List<Object> orderList = new ArrayList<Object>();
                for (OrderMainDto mainDto : orderMainList) {
                    orderList.add(mainDto.getOrderCode());
                }
                criteria.andIn("orderCode", orderList);
            } else {
                orderMainDto.setPolicyNo(null);
                orderMainDto.setAssociatedNo(synPolicyDto.getPolicyNo());
                orderMainList = orderMainService.select(orderMainDto);
                if (CollectionUtil.isNotEmpty(orderMainList)) {
                    List<Object> orderList = new ArrayList<Object>();
                    for (OrderMainDto mainDto : orderMainList) {
                        orderList.add(mainDto.getOrderCode());
                    }
                    criteria.andIn("orderCode", orderList);
                } else {
                    pageDataDto.setPage(1);
                    pageDataDto.setRecords(0);
                    pageDataDto.setRows(new ArrayList<SynPolicyDto>());
                    pageDataDto.setTotal(0);
                    return pageDataDto;
                }
            }
        }

        PageDto<SynPolicyDto> pageDto = new PageDto<SynPolicyDto>();
        pageDto.setPageNo(synPolicyDto.getPage());
        pageDto.setPageSize(synPolicyDto.getRows());
        pageDto = synPolicyService.selectByPage(pageDto, condition);

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
    public JqGridPageDto<SynPolicyDto> processList(@RequestBody SynPolicyDto synPolicyDto) throws Exception {

        JqGridPageDto<SynPolicyDto> pageDataDto = new JqGridPageDto<SynPolicyDto>();

        if (synPolicyDto.getOrderCode() == null && StringUtil.isNotEmpty(synPolicyDto.getPolicyNo())) {
            OrderMainDto orderMainDto = new OrderMainDto();
            orderMainDto.setPolicyNo(synPolicyDto.getPolicyNo());
            List<OrderMainDto> orderMainList = orderMainService.select(orderMainDto);
            if (CollectionUtil.isNotEmpty(orderMainList)) {
                synPolicyDto.setOrderCode(orderMainList.get(0).getOrderCode());
            } else {
                pageDataDto.setPage(1);
                pageDataDto.setRecords(0);
                pageDataDto.setRows(new ArrayList<SynPolicyDto>());
                pageDataDto.setTotal(0);
                return pageDataDto;
            }
        }

        // 固定查询条件:处理中及最后更新时间为前三个小时
        Calendar rightNow = Calendar.getInstance();
        rightNow.set(Calendar.HOUR_OF_DAY, rightNow.get(Calendar.HOUR_OF_DAY) - 3);
        synPolicyDto.setUpdatedDate(rightNow.getTime());
        synPolicyDto.setDealStatus("1");

        PageInfo<SynPolicyDto> pageInfo = synPolicyService.findPageInfo(synPolicyDto.getPage(), synPolicyDto.getRows(), synPolicyDto,
                synPolicyDto.getSidx() + " " + synPolicyDto.getSord());

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
    public Map<String, Object> prepareInsert(@RequestBody SynPolicyDto synPolicyDto) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        synPolicyDto = new SynPolicyDto();

        resultMap.put("synPolicyDto", synPolicyDto);
        return resultMap;
    }

    /**
     * 新增
     */
    @ResponseBody
    @RequestMapping(value = "/insert")
    public Map<String, Object> insert(@RequestBody SynPolicyDto synPolicyDto) throws Exception {

        synPolicyService.insertNotNull(synPolicyDto);

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
    public Map<String, Object> prepareUpdate(@RequestBody SynPolicyDto synPolicyDto) throws Exception {

        synPolicyDto = synPolicyService.selectByPrimaryKey(synPolicyDto);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("synPolicyDto", synPolicyDto);
        return resultMap;
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping(value = "/update")
    public Map<String, Object> update(@RequestBody SynPolicyDto synPolicyDto) throws Exception {

        synPolicyService.updateByPrimaryKey(synPolicyDto);

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
    public Map<String, Object> delete(@RequestBody JsonRequest<SynPolicyDto> jsonRequest) throws Exception {

        List<SynPolicyDto> synPolicyList = JSON.parseArray((jsonRequest.getExtend().get("synPolicyList")), SynPolicyDto.class);

        for (SynPolicyDto synPolicyDto : synPolicyList) {
            synPolicyService.deleteByPrimaryKey(synPolicyDto);
        }

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("flag", "Y");
        resultMap.put("msg", "删除处理成功");
        return resultMap;
    }

    /**
     * 手工触发保单同步
     */
    @ResponseBody
    @RequestMapping(value = "/synPolicyDealManual")
    public Map<String, Object> synPolicyDealManual(@RequestBody JsonRequest<SynPolicyDto> jsonRequest) throws Exception {

        Map<String, Object> resultMap = new HashMap<String, Object>();

        List<SynPolicyDto> synPolicys = JSON.parseArray((jsonRequest.getExtend().get("synPolicyList")), SynPolicyDto.class);

        int count = 0;
        if (CollectionUtil.isNotEmpty(synPolicys)) {
            List<SynPolicyDto> synPolicyList = new ArrayList<SynPolicyDto>();
            SynPolicyDto synPolicyDto = null;
            for (SynPolicyDto item : synPolicys) {
                synPolicyDto = new SynPolicyDto();
                synPolicyDto.setOrderCode(item.getOrderCode());
                synPolicyDto = synPolicyService.selectByPrimaryKey(synPolicyDto);
                if (synPolicyDto != null) {
                    synPolicyList.add(synPolicyDto);
                }
            }
            count = synPolicyService.taskSynPolicyDealProcess(synPolicyList);
        } else {
            resultMap.put("flag", "N");
            resultMap.put("msg", "请选择记录");
            return resultMap;
        }
        resultMap.put("flag", "Y");
        resultMap.put("msg", "手工触发处理成功,实际处理" + count + "条,请查看同步情况");
        return resultMap;
    }

    /**
     * 手工触发保单同步异常情况状态一直处于处理中数据处理
     */
    @ResponseBody
    @RequestMapping(value = "/synPolicyProcessDealManual")
    public Map<String, Object> synPolicyProcessDealManual(@RequestBody JsonRequest<SynPolicyDto> jsonRequest) throws Exception {

        Map<String, Object> resultMap = new HashMap<String, Object>();

        List<SynPolicyDto> synPolicyList = JSON.parseArray((jsonRequest.getExtend().get("synPolicyList")), SynPolicyDto.class);

        int count = 0;
        if (CollectionUtil.isNotEmpty(synPolicyList)) {
            count = synPolicyService.synPolicyProcessDeal(synPolicyList);
        } else {
            resultMap.put("flag", "N");
            resultMap.put("msg", "请选择记录");
            return resultMap;
        }
        resultMap.put("flag", "Y");
        resultMap.put("msg", "手工触发处理成功,实际处理" + count + "条,请查看同步情况");
        return resultMap;
    }

    /**
     * 手工清除保单同步任务数据
     */
    @RequestMapping(value = "/clearSynDataManual")
    public String clearSynDataManual(HttpServletRequest request) {
        return "syn/synPolicy/clearSynPolicy";
    }
    
    /**
     * 清除保单同步任务承保数据
     */
    @ResponseBody
    @RequestMapping(value = "/clearSynPolicyPrpallData")
    public String clearSynPolicyPrpallData() throws Exception {

        return synPolicyDataService.clearSynPolicyPrpallData();
    }
    
    /**
     * 清除保单同步任务退保数据
     */
    @ResponseBody
    @RequestMapping(value = "/clearSynPolicySurrenderData")
    public String clearSynPolicySurrenderData() throws Exception {

        return synPolicyDataService.clearSynPolicySurrenderData();
    }

}