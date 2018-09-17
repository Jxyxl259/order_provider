/*
 * Created By lujicong (2017-03-20 14:44:31)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.syn.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaic.app.syn.dto.domain.SynEpolicyDto;
import com.yaic.app.syn.dto.domain.SynPolicyCfgDto;
import com.yaic.app.syn.dto.domain.SynPolicyDtlDto;
import com.yaic.app.syn.dto.domain.SynPolicyDto;
import com.yaic.app.syn.dto.domain.SynPolicySurrenderDto;
import com.yaic.app.syn.service.SynEpolicyService;
import com.yaic.app.syn.service.SynPolicyCfgService;
import com.yaic.app.syn.service.SynPolicyDataService;
import com.yaic.app.syn.service.SynPolicyDtlService;
import com.yaic.app.syn.service.SynPolicyMonitorCfgService;
import com.yaic.app.syn.service.SynPolicyService;
import com.yaic.app.syn.service.SynPolicySurrenderService;
import com.yaic.servicelayer.datetime.DateTime;

@Service("synPolicyDataService")
public class SynPolicyDataServiceImpl implements SynPolicyDataService {

    private static final Logger synPolicyLogger = LoggerFactory.getLogger("synPolicyLogger");

    @Autowired
    private SynPolicyService synPolicyService;
    @Autowired
    private SynPolicyDtlService synPolicyDtlService;
    @Autowired
    private SynPolicySurrenderService synPolicySurrenderService;
    @Autowired
    private SynPolicyCfgService synPolicyCfgService;
    @Autowired
    private SynPolicyMonitorCfgService synPolicyMonitorCfgService;
    @Autowired
    private SynEpolicyService synEpolicyService;

    @Override
    public String clearSynPolicyData() {

        DateTime startTime = new DateTime(new DateTime(), DateTime.YEAR_TO_MILLISECOND);
        
        boolean eflag = false;

        // 获取同步保单承保配置信息
        SynPolicyCfgDto synPolicyCfgDto = new SynPolicyCfgDto();
        synPolicyCfgDto.setDealType("6");
        synPolicyCfgDto = synPolicyCfgService.selectByPrimaryKey(synPolicyCfgDto);
        if (synPolicyCfgDto == null) {
            eflag = true;
            synPolicyLogger.error("【清除承保任务数据】获取配置信息失败");
            return "【清除承保任务数据】获取配置信息失败";
        }

        Date nowTime = new Date();
        
        // t_syn_policy_dtl
        int policyDtlCount = 0;
        try {
            SynPolicyDtlDto synPolicyDtlDto = new SynPolicyDtlDto();
            synPolicyDtlDto.setDealBeforeDate(synPolicyCfgDto.getDealBeforeDate());
            synPolicyDtlDto.setLimitCount(synPolicyCfgDto.getLimitCount());
            synPolicyDtlDto.setNowTime(nowTime);
            int dealCount = 0;
            while (true) {
                dealCount = synPolicyDtlService.deleteSynPolicyDtlData(synPolicyDtlDto);
                policyDtlCount += dealCount;
                if (dealCount == 0) {
                    break;
                }
            }
        } catch (Exception e) {
            eflag = true;
            synPolicyLogger.error("【清除承保任务数据】清除t_syn_policy_dtl数据异常,原因:{}", e);
        } catch (Throwable t) {
            eflag = true;
            synPolicyLogger.error("【清除承保任务数据】清除t_syn_policy_dtl数据异常,原因:{}", t);
        }

        // t_syn_policy
        int policyCount = 0;
        try {
            SynPolicyDto synPolicyDto = new SynPolicyDto();
            synPolicyDto.setDealBeforeDate(synPolicyCfgDto.getDealBeforeDate());
            synPolicyDto.setLimitCount(synPolicyCfgDto.getLimitCount());
            synPolicyDto.setNowTime(nowTime);
            int dealCount = 0;
            while (true) {
                dealCount = synPolicyService.deleteSynPolicyData(synPolicyDto);
                policyCount += dealCount;
                if (dealCount == 0) {
                    break;
                }
            }
        } catch (Exception e) {
            eflag = true;
            synPolicyLogger.error("【清除承保任务数据】清除t_syn_policy数据异常,原因:{}", e);
        } catch (Throwable t) {
            eflag = true;
            synPolicyLogger.error("【清除承保任务数据】清除t_syn_policy数据异常,原因:{}", t);
        }

        // 获取同步保单退保配置信息
        SynPolicyCfgDto synPolicySurrenderCfgDto = new SynPolicyCfgDto();
        synPolicySurrenderCfgDto.setDealType("7");
        synPolicySurrenderCfgDto = synPolicyCfgService.selectByPrimaryKey(synPolicySurrenderCfgDto);
        if (synPolicySurrenderCfgDto == null) {
            eflag = true;
            synPolicyLogger.error("【清除退保任务数据】获取配置信息失败");
            return "【清除退保任务数据】获取配置信息失败";
        }

        // t_syn_policy_surrender
        int policySurrenderCount = 0;
        try {
            SynPolicySurrenderDto synPolicySurrenderDto = new SynPolicySurrenderDto();
            synPolicySurrenderDto.setDealBeforeDate(synPolicySurrenderCfgDto.getDealBeforeDate());
            synPolicySurrenderDto.setLimitCount(synPolicySurrenderCfgDto.getLimitCount());
            synPolicySurrenderDto.setNowTime(nowTime);
            int dealCount = 0;
            while (true) {
                dealCount = synPolicySurrenderService.deleteSynPolicySurrenderData(synPolicySurrenderDto);
                policySurrenderCount += dealCount;
                if (dealCount == 0) {
                    break;
                }
            }
        } catch (Exception e) {
            eflag = true;
            synPolicyLogger.error("【清除退保任务数据】清除t_syn_policy_surrender数据异常,原因:{}", e);
        } catch (Throwable t) {
            eflag = true;
            synPolicyLogger.error("【清除退保任务数据】清除t_syn_policy_surrender数据异常,原因:{}", t);
        }
        
        // t_syn_epolicy
        int epolicyCount = 0;
        try {
        	SynEpolicyDto synEpolicyDto = new SynEpolicyDto();
        	synEpolicyDto.setDealBeforeDate(synPolicySurrenderCfgDto.getDealBeforeDate());
        	synEpolicyDto.setLimitCount(synPolicySurrenderCfgDto.getLimitCount());
        	synEpolicyDto.setNowTime(nowTime);
        	int dealCount = 0;
        	while (true) {
        		dealCount = synEpolicyService.deleteSynEpolicyData(synEpolicyDto);
        		epolicyCount += dealCount;
        		if (dealCount == 0) {
        			break;
        		}
        	}
        } catch (Exception e) {
        	eflag = true;
        	synPolicyLogger.error("【清除退保任务数据】清除t_syn_policy_surrender数据异常,原因:{}", e);
        } catch (Throwable t) {
        	eflag = true;
        	synPolicyLogger.error("【清除退保任务数据】清除t_syn_policy_surrender数据异常,原因:{}", t);
        }

        // 异常触发短信通知
        if(eflag) {
            synPolicyMonitorCfgService.synPolicyMonitor("3", 1);
        }
        
        DateTime endTime = new DateTime(new DateTime(), DateTime.YEAR_TO_MILLISECOND);
        
        synPolicyLogger.warn("【清除任务数据】{} - {}, t_syn_policy_dtl:{}, t_syn_policy:{}, t_syn_policy_surrender:{}, t_syn_epolicy:{}", 
        		startTime, endTime, policyDtlCount, policyCount, policySurrenderCount, epolicyCount);
        
        return "执行情况=" + startTime + " - " + endTime + ", t_syn_policy_dtl:" + policyDtlCount + ", t_syn_policy:" + 
    		policyCount + ", t_syn_policy_surrender:" + policySurrenderCount + ", t_syn_epolicy:" + epolicyCount;
    }

    @Override
    public String clearSynPolicyPrpallData() {

        DateTime startTime = new DateTime(new DateTime(), DateTime.YEAR_TO_MILLISECOND);
        int count = 0;

        // 获取同步保单承保配置信息
        SynPolicyCfgDto synPolicyCfgDto = new SynPolicyCfgDto();
        synPolicyCfgDto.setDealType("6");
        synPolicyCfgDto = synPolicyCfgService.selectByPrimaryKey(synPolicyCfgDto);
        if (synPolicyCfgDto == null) {
            synPolicyLogger.error("【清除承保任务数据】获取配置信息失败");
            return "【清除承保任务数据】获取配置信息失败";
        }

        Date nowTime = new Date();
        
        // t_syn_policy_dtl
        try {
            SynPolicyDtlDto synPolicyDtlDto = new SynPolicyDtlDto();
            synPolicyDtlDto.setDealBeforeDate(synPolicyCfgDto.getDealBeforeDate());
            synPolicyDtlDto.setLimitCount(synPolicyCfgDto.getLimitCount());
            synPolicyDtlDto.setNowTime(nowTime);
            int dealCount = 0;
            while (true) {
                dealCount = synPolicyDtlService.deleteSynPolicyDtlData(synPolicyDtlDto);
                count += dealCount;
                if (dealCount == 0) {
                    break;
                }
            }
        } catch (Exception e) {
            synPolicyLogger.error("【清除承保任务数据】清除t_syn_policy_dtl数据异常,原因:{}", e);
        } catch (Throwable t) {
            synPolicyLogger.error("【清除承保任务数据】清除t_syn_policy_dtl数据异常,原因:{}", t);
        }

        // t_syn_policy
        try {
            SynPolicyDto synPolicyDto = new SynPolicyDto();
            synPolicyDto.setDealBeforeDate(synPolicyCfgDto.getDealBeforeDate());
            synPolicyDto.setLimitCount(synPolicyCfgDto.getLimitCount());
            synPolicyDto.setNowTime(nowTime);
            int dealCount = 0;
            while (true) {
                dealCount = synPolicyService.deleteSynPolicyData(synPolicyDto);
                count += dealCount;
                if (dealCount == 0) {
                    break;
                }
            }
        } catch (Exception e) {
            synPolicyLogger.error("【清除承保任务数据】清除t_syn_policy数据异常,原因:{}", e);
        } catch (Throwable t) {
            synPolicyLogger.error("【清除承保任务数据】清除t_syn_policy数据异常,原因:{}", t);
        }

        DateTime endTime = new DateTime(new DateTime(), DateTime.YEAR_TO_MILLISECOND);
        return "执行情况=" + startTime + " - " + endTime + ", 处理条数:" + count;
    }

    @Override
    public String clearSynPolicySurrenderData() {

        DateTime startTime = new DateTime(new DateTime(), DateTime.YEAR_TO_MILLISECOND);
        int count = 0;

        // 获取同步保单退保配置信息
        SynPolicyCfgDto synPolicyCfgDto = new SynPolicyCfgDto();
        synPolicyCfgDto.setDealType("7");
        synPolicyCfgDto = synPolicyCfgService.selectByPrimaryKey(synPolicyCfgDto);
        if (synPolicyCfgDto == null) {
            synPolicyLogger.error("【清除退保任务数据】获取配置信息失败");
            return "【清除退保任务数据】获取配置信息失败";
        }

        // t_syn_policy_surrender
        try {
            SynPolicySurrenderDto synPolicySurrenderDto = new SynPolicySurrenderDto();
            synPolicySurrenderDto.setDealBeforeDate(synPolicyCfgDto.getDealBeforeDate());
            synPolicySurrenderDto.setLimitCount(synPolicyCfgDto.getLimitCount());
            synPolicySurrenderDto.setNowTime(new Date());
            int dealCount = 0;
            while (true) {
                dealCount = synPolicySurrenderService.deleteSynPolicySurrenderData(synPolicySurrenderDto);
                count += dealCount;
                if (dealCount == 0) {
                    break;
                }
            }
        } catch (Exception e) {
            synPolicyLogger.error("【清除退保任务数据】清除t_syn_policy_surrender数据异常,原因:{}", e);
        } catch (Throwable t) {
            synPolicyLogger.error("【清除退保任务数据】清除t_syn_policy_surrender数据异常,原因:{}", t);
        }

        DateTime endTime = new DateTime(new DateTime(), DateTime.YEAR_TO_MILLISECOND);
        return "执行情况=" + startTime + " - " + endTime + ", 处理条数:" + count;
    }

}