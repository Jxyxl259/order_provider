/*
 * Created By lujicong (2017-03-31 20:02:28)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.syn.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.emay.mydes.MyDes;
import com.yaic.app.common.dto.SmsDto;
import com.yaic.app.common.util.SendSmsUtil;
import com.yaic.app.order.dto.msg.common.ResponseMessage;
import com.yaic.app.syn.dao.SynPolicyMonitorCfgDao;
import com.yaic.app.syn.dto.domain.SynPolicyDto;
import com.yaic.app.syn.dto.domain.SynPolicyMonitorCfgDto;
import com.yaic.app.syn.service.SynPolicyMonitorCfgService;
import com.yaic.app.syn.service.SynPolicyService;
import com.yaic.fa.mybatis.pagehelper.PageHelper;
import com.yaic.fa.mybatis.pagehelper.PageInfo;
import com.yaic.fa.service.BaseService;
import com.yaic.servicelayer.charset.StandardCharset;
import com.yaic.servicelayer.datetime.DateTime;
import com.yaic.servicelayer.http.wrapper.HttpResponseWrapper;
import com.yaic.servicelayer.util.ArrayUtil;
import com.yaic.servicelayer.util.RandomUtil;
import com.yaic.servicelayer.util.StringUtil;
import com.yaic.servicelayer.util.TimeUtil;

@Service("synPolicyMonitorCfgService")
public class SynPolicyMonitorCfgServiceImpl extends BaseService<SynPolicyMonitorCfgDto> implements SynPolicyMonitorCfgService {

    private static final Logger synPolicyLogger = LoggerFactory.getLogger("synPolicyLogger");

    @Autowired
    private SynPolicyMonitorCfgDao synPolicyMonitorCfgDao;
    @Autowired
    private SynPolicyService synPolicyService;

    @Override
    public PageInfo<SynPolicyMonitorCfgDto> findPageInfo(int page, int rows, SynPolicyMonitorCfgDto synPolicyMonitorCfgDto, String orderBy) {
        PageHelper.startPage(page, rows, orderBy);
        List<SynPolicyMonitorCfgDto> list = synPolicyMonitorCfgDao.findPageInfo(synPolicyMonitorCfgDto);
        return new PageInfo<SynPolicyMonitorCfgDto>(list);
    }

    @Override
    public String monitorSynPolicyData() {
        DateTime startTime = new DateTime(new DateTime(), DateTime.YEAR_TO_MILLISECOND);

        SynPolicyDto synPolicyDto = new SynPolicyDto();
        synPolicyDto.setDealStatus("1"); // 处理中
        int synPolicyProcessCount = synPolicyService.querySynPolicyCount(synPolicyDto);
        this.synPolicyMonitor("0", synPolicyProcessCount);

        synPolicyDto.setDealStatus("3"); // 处理失败
        int synPolicyFailCount = synPolicyService.querySynPolicyCount(synPolicyDto);
        this.synPolicyMonitor("1", synPolicyFailCount);
        
        synPolicyDto.setDealStatus("0"); // 未处理
        int synPolicyInitCount = synPolicyService.querySynPolicyCount(synPolicyDto);
        this.synPolicyMonitor("2", synPolicyInitCount);

        DateTime endTime = new DateTime(new DateTime(), DateTime.YEAR_TO_MILLISECOND);
        return "执行情况=" + startTime + " - " + endTime + ", 处理中条数:" + synPolicyProcessCount + ", 处理失败条数:" + synPolicyFailCount + ", 未处理条数:" + synPolicyInitCount;
    }

    /**
     * 监控保单同步数据
     * @param monitorType
     * @param count
     */
    @Override
    public void synPolicyMonitor(String monitorType, int count) {
        SynPolicyMonitorCfgDto synPolicyMonitorCfgDto = new SynPolicyMonitorCfgDto();
        synPolicyMonitorCfgDto.setMonitorType(monitorType);
        synPolicyMonitorCfgDto = synPolicyMonitorCfgDao.selectByPrimaryKey(synPolicyMonitorCfgDto);
        if (synPolicyMonitorCfgDto == null) {
            synPolicyLogger.error("【监控保单同步数据】获取配置信息失败,监控类型:{}", monitorType);
            return;
        }
        if (synPolicyMonitorCfgDto.getThreshold() <= count && synPolicyMonitorCfgDto.getSmsSwitch() == 0) { // 短信开关:0-开启,1-关闭
            try {
                String warnMsg = StringUtil.replace(synPolicyMonitorCfgDto.getWarnMsg(), "$COUNT$", String.valueOf(count));
                String[] mobileArray = synPolicyMonitorCfgDto.getMobile().split(";");
                if (ArrayUtil.isNotEmpty(mobileArray)) {
                    for (String mobile : mobileArray) {
                        if (StringUtil.isNotEmpty(mobile)) {
                            this.sendSms(mobile, warnMsg);
                        }
                    }
                }
            } catch (Exception e) {
                synPolicyLogger.error("【监控保单同步数据】发送预警短信失败,原因:{}", e);
            }
        }
    }

    /**
     * 发送短信
     * @param mobile
     * @param msg
     */
    private void sendSms(String mobile, String msg) {
        SmsDto smsDto = new SmsDto();
        String smsid = (Math.random() + "").substring(2, 10);
        smsDto.setCmd(SendSmsUtil.getSmsCmd());
        smsDto.setUsername(SendSmsUtil.getEmasUser());
        smsDto.setUserpassword(new MyDes(SendSmsUtil.getPubKey()).encrypt(SendSmsUtil.getEmasPwd()));
        smsDto.setKey(SendSmsUtil.getPubKey());
        smsDto.setTimestamp(TimeUtil.format(new Date(), "yyyyMMddHHmmss") + Integer.toString(RandomUtil.nextInt(10000)));
        smsDto.setChannel_id("1");
        smsDto.setMobiles(mobile);
        smsDto.setSmscontent(SendSmsUtil.getSmsSign() + msg);
        smsDto.setSrccharset(StandardCharset.GBK.name());
        smsDto.setSmsid(smsid);
        smsDto.setBusiness_id("1");

		final HttpResponseWrapper result = SendSmsUtil.sendSms(smsDto, SendSmsUtil.getEmasServer());
		if (result.getStatus())
		{
			final ResponseMessage respMsg = JSON.parseObject((String) result.getContent(), ResponseMessage.class);
			synPolicyLogger.info("【监控保单同步数据】发送预警短信, 短信服务器的状态标识码为[{}], 响应内容为[{}]", respMsg.getStatusCode(), respMsg.getMessage());
		}
		else
		{
			synPolicyLogger.error("【监控保单同步数据】发送预警短信失败, 原因:{}", result.getErrorMessage());
		}
	}

}