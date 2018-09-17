/*
 * Created By lujicong (2017-03-20 14:44:31)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.syn.controller;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yaic.app.order.dto.domain.OrderMainDto;
import com.yaic.app.order.service.OrderMainService;
import com.yaic.app.syn.dto.domain.SynEpolicyDto;
import com.yaic.app.syn.service.SynEpolicyService;
import com.yaic.servicelayer.util.CollectionUtil;
import com.yaic.servicelayer.util.StringUtil;

@Controller
@RequestMapping("synEpolicy")
public class SynEpolicyController {

    @Autowired
    private SynEpolicyService synEpolicyService;
    @Autowired
    private OrderMainService orderMainService;

    /**
     * 手工触发电子保单同步
     */
    @ResponseBody
    @RequestMapping(value = "/synEpolicyDealManual")
    public Map<String, Object> synPolicyDealManual(@RequestParam BigInteger orderCode, @RequestParam String policyNo) throws Exception {

        Map<String, Object> resultMap = new HashMap<String, Object>();

        int count = 0;
        if (orderCode == null && StringUtil.isNotEmpty(policyNo)) {
            OrderMainDto orderMainDto = new OrderMainDto();
            orderMainDto.setPolicyNo(policyNo);
            List<OrderMainDto> orderMainList = orderMainService.select(orderMainDto);
            if (CollectionUtil.isNotEmpty(orderMainList)) {
            	orderCode = orderMainList.get(0).getOrderCode();
            } else {
                orderMainDto.setPolicyNo(null);
                orderMainDto.setAssociatedNo(policyNo);
                orderMainList = orderMainService.select(orderMainDto);
                if (CollectionUtil.isNotEmpty(orderMainList)) {
                	orderCode = orderMainList.get(0).getOrderCode();
                } else {
                	resultMap.put("flag", "N");
                	resultMap.put("msg", "保单号不存在");
                	return resultMap;
                }
            }
        }
        if (orderCode != null) {
        	SynEpolicyDto synEpolicyDto = new SynEpolicyDto();
    		synEpolicyDto.setOrderCode(orderCode);
    		List<SynEpolicyDto> synEpolicyList = synEpolicyService.select(synEpolicyDto);
        	count = synEpolicyService.taskSynEpolicyDealProcess(synEpolicyList);
        } else {
        	resultMap.put("flag", "N");
        	resultMap.put("msg", "请输入订单号或保单号");
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
    @RequestMapping(value = "/synEpolicyProcessDealManual")
    public Map<String, Object> synPolicyProcessDealManual(@RequestParam BigInteger orderCode, @RequestParam String policyNo) throws Exception {

        Map<String, Object> resultMap = new HashMap<String, Object>();

        int count = 0;
        if (orderCode == null && StringUtil.isNotEmpty(policyNo)) {
            OrderMainDto orderMainDto = new OrderMainDto();
            orderMainDto.setPolicyNo(policyNo);
            List<OrderMainDto> orderMainList = orderMainService.select(orderMainDto);
            if (CollectionUtil.isNotEmpty(orderMainList)) {
            	orderCode = orderMainList.get(0).getOrderCode();
            } else {
                orderMainDto.setPolicyNo(null);
                orderMainDto.setAssociatedNo(policyNo);
                orderMainList = orderMainService.select(orderMainDto);
                if (CollectionUtil.isNotEmpty(orderMainList)) {
                	orderCode = orderMainList.get(0).getOrderCode();
                } else {
                	resultMap.put("flag", "N");
                	resultMap.put("msg", "保单号不存在");
                	return resultMap;
                }
            }
        }
        if (orderCode != null) {
        	SynEpolicyDto synEpolicyDto = new SynEpolicyDto();
    		synEpolicyDto.setOrderCode(orderCode);
    		List<SynEpolicyDto> synEpolicyList = synEpolicyService.select(synEpolicyDto);
        	count = synEpolicyService.synEpolicyProcessDeal(synEpolicyList);
        } else {
        	resultMap.put("flag", "N");
        	resultMap.put("msg", "请输入订单号或保单号");
        	return resultMap;
        }
        resultMap.put("flag", "Y");
        resultMap.put("msg", "手工触发处理成功,实际处理" + count + "条,请查看同步情况");
        return resultMap;
    }

}