/*
 * Created By lujicong (2017-03-20 14:44:31)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.syn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yaic.app.syn.service.SynEpolicyService;
import com.yaic.app.syn.service.SynPolicyDataService;
import com.yaic.app.syn.service.SynPolicyMonitorCfgService;
import com.yaic.app.syn.service.SynPolicyService;
import com.yaic.app.syn.service.SynPolicySurrenderService;

@Controller
@RequestMapping("synPolicyRest")
public class SynPolicyRestController {

    @Autowired
    private SynPolicyService synPolicyService;
    @Autowired
    private SynPolicySurrenderService synPolicySurrenderService;
    @Autowired
    private SynPolicyDataService synPolicyDataService;
    @Autowired
    private SynPolicyMonitorCfgService synPolicyMonitorCfgService;
    @Autowired
    private SynEpolicyService synEpolicyService;
    
    //--------------------------------------------------------------------------------------------------------------
    /**
     * 同步保单升序获取数据
     */
    @ResponseBody
    @RequestMapping(value = "/taskSynPolicyDeal")
    public String taskSynPolicyDeal() throws Exception {
        
        return synPolicyService.taskSynPolicyDeal();
    }
    
    /**
     * 同步保单降序获取数据
     */
    @ResponseBody
    @RequestMapping(value = "/taskSynPolicyDealDesc")
    public String taskSynPolicyDealDesc() throws Exception {
        
        return synPolicyService.taskSynPolicyDealDesc();
    }
    
    /**
     * 同步保单获取数据(升序+降序)
     */
    @ResponseBody
    @RequestMapping(value = "/taskSynPolicyDealAll")
    public String taskSynPolicyDealAll() throws Exception {
        
        return "同步保单:\r\n升序"+synPolicyService.taskSynPolicyDeal()+"\r\n降序"+synPolicyService.taskSynPolicyDealDesc();
    }
    
    /**
     * 保单同步异常情况状态一直处于处理中数据处理
     */
    @ResponseBody
    @RequestMapping(value = "/taskSynPolicyProcessDeal")
    public String taskSynPolicyProcessDeal() throws Exception {

        return synPolicyService.taskSynPolicyProcessDeal();
    }
    //--------------------------------------------------------------------------------------------------------------
    /**
     * 同步退保保单升序获取数据
     */
    @ResponseBody
    @RequestMapping(value = "/taskSynPolicySurrenderDeal")
    public String taskSynPolicySurrenderDeal() throws Exception {
        
        return synPolicySurrenderService.taskSynPolicySurrenderDeal();
    }
    
    /**
     * 同步退保保单降序获取数据
     */
    @ResponseBody
    @RequestMapping(value = "/taskSynPolicySurrenderDealDesc")
    public String taskSynPolicySurrenderDealDesc() throws Exception {
        
        return synPolicySurrenderService.taskSynPolicySurrenderDealDesc();
    }
    
    /**
     * 同步退保保单获取数据(升序+降序)
     */
    @ResponseBody
    @RequestMapping(value = "/taskSynPolicySurrenderDealAll")
    public String taskSynPolicySurrenderDealAll() throws Exception {
        
        return "同步保单:\r\n升序"+synPolicySurrenderService.taskSynPolicySurrenderDeal()+"\r\n降序"+synPolicySurrenderService.taskSynPolicySurrenderDealDesc();
    }
    
    /**
     * 退保保单同步异常情况状态一直处于处理中数据处理
     */
    @ResponseBody
    @RequestMapping(value = "/taskSynPolicySurrenderProcessDeal")
    public String taskSynPolicySurrenderProcessDeal() throws Exception {

        return synPolicySurrenderService.taskSynPolicySurrenderProcessDeal();
    }
    
    //--------------------------------------------------------------------------------------------------------------
    /**
     * 清除保单同步任务数据
     */
    @ResponseBody
    @RequestMapping(value = "/clearSynPolicyData")
    public String clearSynPolicyData() throws Exception {

        return synPolicyDataService.clearSynPolicyData();
    }
    
    //--------------------------------------------------------------------------------------------------------------
    /**
     * 监控保单同步数据
     */
    @ResponseBody
    @RequestMapping(value = "/monitorSynPolicyData")
    public String monitorSynPolicyData() throws Exception {
        
        return synPolicyMonitorCfgService.monitorSynPolicyData();
    }
    
    /**
     * 同步电子保单升序获取数据
     */
    @ResponseBody
    @RequestMapping(value = "/taskSynEpolicyDeal")
    public String taskSynEpolicyDeal() throws Exception {
        
        return synEpolicyService.taskSynEpolicyDeal();
    }
    
    /**
     * 同步电子保单降序获取数据
     */
    @ResponseBody
    @RequestMapping(value = "/taskSynEpolicyDealDesc")
    public String taskSynEpolicyDealDesc() throws Exception {
        
        return synEpolicyService.taskSynEpolicyDealDesc();
    }
    
    /**
     * 同步电子保单获取数据(升序+降序)
     */
    @ResponseBody
    @RequestMapping(value = "/taskSynEpolicyDealAll")
    public String taskSynEpolicyDealAll() throws Exception {
        
        return "同步保单:\r\n升序"+synEpolicyService.taskSynEpolicyDeal()+"\r\n降序"+synEpolicyService.taskSynEpolicyDealDesc();
    }
    
    /**
     * 电子保单同步异常情况状态一直处于处理中数据处理
     */
    @ResponseBody
    @RequestMapping(value = "/taskSynEpolicyProcessDeal")
    public String taskSynEpolicyProcessDeal() throws Exception {

        return synEpolicyService.taskSynEpolicyProcessDeal();
    }
}