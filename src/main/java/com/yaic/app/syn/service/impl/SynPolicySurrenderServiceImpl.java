/*
 * Created By lujicong (2017-03-22 10:38:44)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.syn.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.yaic.servicelayer.datetime.DateTime;
import com.yaic.fa.mybatis.mapper.entity.Condition;
import com.yaic.fa.mybatis.pagehelper.PageHelper;
import com.yaic.fa.mybatis.pagehelper.PageInfo;
import com.yaic.fa.service.BaseService;
import com.yaic.servicelayer.http.wrapper.HttpResponseWrapper;
import com.yaic.servicelayer.util.CollectionUtil;
import com.yaic.servicelayer.util.ConfigUtil;
import com.yaic.servicelayer.util.StringUtil;
import com.yaic.app.order.dto.domain.OrderMainDto;
import com.yaic.app.order.dto.domain.OrderPayinfoDto;
import com.yaic.app.order.service.OrderMainService;
import com.yaic.app.order.service.OrderPayinfoService;
import com.yaic.app.order.utils.ClientUtils;
import com.yaic.app.syn.dao.SynPolicySurrenderDao;
import com.yaic.app.syn.dto.custom.BodyDto;
import com.yaic.app.syn.dto.custom.HeadDto;
import com.yaic.app.syn.dto.custom.PolicyMainDto;
import com.yaic.app.syn.dto.custom.PolicyTransDto;
import com.yaic.app.syn.dto.domain.SynPolicyCfgDto;
import com.yaic.app.syn.dto.domain.SynPolicyDto;
import com.yaic.app.syn.dto.domain.SynPolicySurrenderDto;
import com.yaic.app.syn.service.SynPolicyCfgService;
import com.yaic.app.syn.service.SynPolicyService;
import com.yaic.app.syn.service.SynPolicySurrenderService;
import com.yaic.app.trans.dto.msg.TransCancelInsuranceReq;
import com.yaic.app.trans.dto.msg.TransCancelInsuranceResp;
import com.yaic.app.trans.dto.msg.common.TransRequestMessage;
import com.yaic.app.trans.dto.msg.common.TransResponseMessage;

@Service("synPolicySurrenderService")
public class SynPolicySurrenderServiceImpl extends BaseService<SynPolicySurrenderDto> implements SynPolicySurrenderService {

    private static final Logger synPolicyLogger = LoggerFactory.getLogger("synPolicyLogger");
    
    private static final String CANCEL_INSURANCE = "CancelInsurance";
    private static final String QUERY_POLICY = "queryPolicy";
    private static final String SUCCESS_CODE = "0000";
    private static final String UPDATED_USER = "SYN";

    @Autowired
    private SynPolicySurrenderDao synPolicySurrenderDao;
    @Autowired
    private SynPolicyCfgService synPolicyCfgService;
    @Autowired
    private OrderMainService orderMainService;
    @Autowired
    private OrderPayinfoService orderPayinfoService;
    @Autowired
    private SynPolicyService synPolicyService;

    @Override
    public PageInfo<SynPolicySurrenderDto> findPageInfo(int page, int rows, SynPolicySurrenderDto synPolicySurrenderDto, String orderBy) {
        PageHelper.startPage(page, rows, orderBy);
        List<SynPolicySurrenderDto> list = synPolicySurrenderDao.findPageInfo(synPolicySurrenderDto);
        return new PageInfo<SynPolicySurrenderDto>(list);
    }

    @Override
    public int deleteSynPolicySurrenderData(SynPolicySurrenderDto synPolicySurrenderDto) {
        return synPolicySurrenderDao.deleteSynPolicySurrenderData(synPolicySurrenderDto);
    }
    
    // ----------------------------------------------------------------------------------------------------------------------
    /**
     * 同步退保保单升序获取数据
     */
    @Override
    public String taskSynPolicySurrenderDeal() {
        DateTime startTime = new DateTime(new DateTime(), DateTime.YEAR_TO_MILLISECOND);
        // 获取同步保单配置信息
        SynPolicyCfgDto synPolicyCfgDto = new SynPolicyCfgDto();
        synPolicyCfgDto.setDealType("2");
        synPolicyCfgDto = synPolicyCfgService.selectByPrimaryKey(synPolicyCfgDto);
        if (synPolicyCfgDto == null) {
            synPolicyLogger.error("【同步退保保单-升序】获取同步退保保单配置信息失败,SynPolicySurrenderService.taskSynPolicySurrenderDeal()同步方法");
            return "获取同步退保保单配置信息失败";
        }

        // 获取需要同步订单信息
        SynPolicySurrenderDto synPolicySurrenderCond = new SynPolicySurrenderDto();
        synPolicySurrenderCond.setDealCount(synPolicyCfgDto.getFailRetryCount());
        synPolicySurrenderCond.setDealBeforeDate(synPolicyCfgDto.getDealBeforeDate());
        synPolicySurrenderCond.setLimitCount(synPolicyCfgDto.getLimitCount());
        synPolicySurrenderCond.setNowTime(new Date());
        synPolicySurrenderCond.setSortType("ASC");
        List<SynPolicySurrenderDto> synPolicySurrenderList = synPolicySurrenderDao.findSynPolicySurrenderData(synPolicySurrenderCond);

        int count = this.taskSynPolicySurrenderDealProcess(synPolicySurrenderList);

        DateTime endTime = new DateTime(new DateTime(), DateTime.YEAR_TO_MILLISECOND);
        return "执行情况=" + startTime + " - " + endTime + ", 处理条数:" + count;
    }
    
    // ----------------------------------------------------------------------------------------------------------------------
    /**
     * 同步退保保单降序获取数据
     */
    @Override
    public String taskSynPolicySurrenderDealDesc() {
        DateTime startTime = new DateTime(new DateTime(), DateTime.YEAR_TO_MILLISECOND);
        // 获取同步保单配置信息
        SynPolicyCfgDto synPolicyCfgDto = new SynPolicyCfgDto();
        synPolicyCfgDto.setDealType("3");
        synPolicyCfgDto = synPolicyCfgService.selectByPrimaryKey(synPolicyCfgDto);
        if (synPolicyCfgDto == null) {
            synPolicyLogger.error("【同步退保保单-降序】获取同步退保保单配置信息失败,SynPolicySurrenderService.taskSynPolicySurrenderDealDesc()同步方法");
            return "获取同步退保保单配置信息失败";
        }

        // 获取需要同步订单信息
        SynPolicySurrenderDto synPolicySurrenderCond = new SynPolicySurrenderDto();
        synPolicySurrenderCond.setDealCount(synPolicyCfgDto.getFailRetryCount());
        synPolicySurrenderCond.setDealBeforeDate(synPolicyCfgDto.getDealBeforeDate());
        synPolicySurrenderCond.setLimitCount(synPolicyCfgDto.getLimitCount());
        synPolicySurrenderCond.setNowTime(new Date());
        synPolicySurrenderCond.setSortType("DESC");
        List<SynPolicySurrenderDto> synPolicySurrenderList = synPolicySurrenderDao.findSynPolicySurrenderData(synPolicySurrenderCond);

        int count = this.taskSynPolicySurrenderDealProcess(synPolicySurrenderList);

        DateTime endTime = new DateTime(new DateTime(), DateTime.YEAR_TO_MILLISECOND);
        return "执行情况=" + startTime + " - " + endTime + ", 处理条数:" + count;
    }

    // ----------------------------------------------------------------------------------------------------------------------
    /**
     * 同步退保保单处理过程
     * 
     * @param synPolicyList
     */
    @Override
    public int taskSynPolicySurrenderDealProcess(List<SynPolicySurrenderDto> synPolicySurrenderList) {
        int factDealCount = 0;
        if (CollectionUtil.isNotEmpty(synPolicySurrenderList)) {
            // 批量锁定待处理记录
            List<SynPolicySurrenderDto> synPolicySurrenderRecords = new ArrayList<SynPolicySurrenderDto>();
            SynPolicySurrenderDto synPolicySurrenderUpdate = null;
            for (SynPolicySurrenderDto synPolicySurrenderDto : synPolicySurrenderList) {
                synPolicySurrenderUpdate = new SynPolicySurrenderDto();
                synPolicySurrenderUpdate.setDealStatus("1"); // 处理中
                synPolicySurrenderUpdate.setUpdatedUser(UPDATED_USER);
                synPolicySurrenderUpdate.setUpdatedDate(new Date());
                Condition condition = new Condition(SynPolicySurrenderDto.class);
                List<Object> statusList = new ArrayList<Object>();
                statusList.add("0"); // 未处理
                statusList.add("3"); // 处理失败
                condition.createCriteria().andEqualTo("orderCode", synPolicySurrenderDto.getOrderCode())
                        .andEqualTo("policyNo", synPolicySurrenderDto.getPolicyNo()).andIn("dealStatus", statusList);
                int count = synPolicySurrenderDao.updateByConditionNotNull(synPolicySurrenderUpdate, condition);
                if (count == 0) {
                    continue;
                }
                synPolicySurrenderRecords.add(synPolicySurrenderDto);
            }
            if (CollectionUtil.isNotEmpty(synPolicySurrenderRecords)) {
                factDealCount = synPolicySurrenderRecords.size();
                for (SynPolicySurrenderDto synPolicySurrenderDto : synPolicySurrenderRecords) {
                    try {
                        // 查询核心是否有这个保单
                        PolicyTransDto requestDto = new PolicyTransDto();
                        HeadDto headRequestDto = new HeadDto();
                        headRequestDto.setInterfaceCode(QUERY_POLICY);
                        requestDto.setHeadRequest(headRequestDto);
                        BodyDto bodyRequestDto = new BodyDto();
                        PolicyMainDto queryPolicyInfoDto = new PolicyMainDto();
                        queryPolicyInfoDto.setPolicyNo(synPolicySurrenderDto.getPolicyNo());
                        queryPolicyInfoDto.setOrderCode(String.valueOf(synPolicySurrenderDto.getOrderCode()));
                        bodyRequestDto.setGuPolicyMainDto(queryPolicyInfoDto);
                        requestDto.setBodyRequest(bodyRequestDto);
                        //synPolicyLogger.info("【同步退保保单】调用保单数据查询接口开始,保单号:{}",synPolicySurrenderDto.getPolicyNo());
                        HttpResponseWrapper result = new ClientUtils().connectServer(requestDto, ConfigUtil.getValue("remote.prpall.url"));
                        //synPolicyLogger.info("【同步退保保单】调用保单数据查询接口结束,保单号:{}",synPolicySurrenderDto.getPolicyNo());
                        if (result.getStatus()) {
                            PolicyTransDto transResult = JSON.parseObject((String)result.getContent(), PolicyTransDto.class);
                            if ("0".equals(transResult.getHeadResponse().getResponseCode())) { // 核心存在该保单数据
                                if ("0".equals(transResult.getBodyResponse().getPolicyMainMap().getSurrenderInd())) { // 未退保
                                    // 准备数据
                                    OrderMainDto orderMainDto = new OrderMainDto();
                                    orderMainDto.setOrderCode(synPolicySurrenderDto.getOrderCode());
                                    orderMainDto.setPolicyNo(synPolicySurrenderDto.getPolicyNo());
                                    orderMainDto = orderMainService.selectOne(orderMainDto);

                                    OrderPayinfoDto orderPayinfoDto = new OrderPayinfoDto();
                                    orderPayinfoDto.setOrderCode(orderMainDto.getOrderCode());
                                    orderPayinfoDto.setOrderMainId(orderMainDto.getOrderMainId());
                                    orderPayinfoDto = orderPayinfoService.selectOne(orderPayinfoDto);

                                    // 调全单批退
                                    TransRequestMessage transRequestMessage = new TransRequestMessage();
                                    transRequestMessage.setRequestTime(new Date());
                                    transRequestMessage.setInterfaceCode(CANCEL_INSURANCE);

                                    TransCancelInsuranceReq transCancelInsuranceReq = new TransCancelInsuranceReq();
                                    transCancelInsuranceReq.setPolicyNo(synPolicySurrenderDto.getPolicyNo());
                                    transCancelInsuranceReq.setValidDate(orderMainDto.getSurrenderValidDate());
                                    transCancelInsuranceReq.setEndorDate(orderMainDto.getEndorDate());
                                    String accountBank = orderPayinfoDto.getSurrenderAccountBank();
                                    if (StringUtil.isEmpty(accountBank)) {
                                        accountBank = ConfigUtil.getValue("account.bank");
                                    }
                                    transCancelInsuranceReq.setAccountBank(accountBank);
                                    String accountName = orderPayinfoDto.getSurrenderAccountName();
                                    if (StringUtil.isEmpty(accountName)) {
                                        accountName = ConfigUtil.getValue("account.name");
                                    }
                                    transCancelInsuranceReq.setAccountName(accountName);
                                    String accountNumber = orderPayinfoDto.getSurrenderAccountNo();
                                    if (StringUtil.isEmpty(accountNumber)) {
                                        accountNumber = ConfigUtil.getValue("account.number");
                                    }
                                    transCancelInsuranceReq.setAccountNumber(accountNumber);
                                    transRequestMessage.getData().setCancelInsuranceReq(transCancelInsuranceReq);
                                    //synPolicyLogger.info("【同步退保保单】调用全单退保接口开始,保单号:{}",synPolicySurrenderDto.getPolicyNo());
                                    HttpResponseWrapper cancelResult = new ClientUtils().connectServer(transRequestMessage, ConfigUtil.getValue("remote.trans.url"));
                                    //synPolicyLogger.info("【同步退保保单】调用全单退保接口结束,保单号:{}",synPolicySurrenderDto.getPolicyNo());
                                    if (cancelResult.getStatus()) {
                                        TransResponseMessage transResponseMessage = JSON.parseObject((String)cancelResult.getContent(), TransResponseMessage.class);
                                        if(SUCCESS_CODE.equals(transResponseMessage.getCode())) {
                                            TransCancelInsuranceResp transCancelInsuranceResp = transResponseMessage.getData().getCancelInsuranceResp();
                                            String passFlag = transCancelInsuranceResp.getPassFlag();
                                            String message = transCancelInsuranceResp.getMeassage();
                                            String underWriteInd = transCancelInsuranceResp.getUnderWriteInd();
                                            if("Y".equals(passFlag) && StringUtil.isNotEmpty(message)) {
                                                if("6".equals(underWriteInd)) {  // 承保确认
                                                    synPolicySurrenderDto.setDealStatus("2"); // 处理成功
                                                }else if("1,9".indexOf(underWriteInd) > -1) { // 双核审核通过/待双核审核
                                                    synPolicySurrenderDto.setDealStatus("2");
                                                }else { // 其他情况
                                                    synPolicySurrenderDto.setDealStatus("3");
                                                    
                                                }
                                                synPolicySurrenderDto.setUnderWriteInd(underWriteInd);
                                            }else {
                                                synPolicySurrenderDto.setDealStatus("3");
                                                synPolicyLogger.error("【同步退保保单】核心退保处理不通过,订单号:{},保单号:{}",synPolicySurrenderDto.getOrderCode(),synPolicySurrenderDto.getPolicyNo());
                                            }
                                        }else {
                                            synPolicySurrenderDto.setDealStatus("3");
                                            synPolicyLogger.error("【同步退保保单】核心退保处理失败,订单号:{},保单号:{},响应状态为:{},响应信息为:{}",synPolicySurrenderDto.getOrderCode(),synPolicySurrenderDto.getPolicyNo(),transResponseMessage.getStatusCode(),transResponseMessage.getMessage());
                                        }
                                    }else {
                                        synPolicySurrenderDto.setDealStatus("3"); 
                                        synPolicyLogger.error("【同步退保保单】核心退保请求失败,订单号:{},保单号:{}",synPolicySurrenderDto.getOrderCode(),synPolicySurrenderDto.getPolicyNo());
                                    }
                                } else { // 已退保
                                    synPolicySurrenderDto.setDealStatus("2");
                                    synPolicySurrenderDto.setUnderWriteInd("6");
                                }
                            } else {
                                // 连带触发该保单同步
                                try {
                                    SynPolicyDto synPolicyDto = new SynPolicyDto();
                                    synPolicyDto.setOrderCode(synPolicySurrenderDto.getOrderCode());
                                    synPolicyDto = synPolicyService.selectByPrimaryKey(synPolicyDto);
                                    if(synPolicyDto != null) {
                                        List<SynPolicyDto> synPolicyList = new ArrayList<SynPolicyDto>();
                                        synPolicyList.add(synPolicyDto);
                                        synPolicyService.taskSynPolicyDealProcess(synPolicyList);
                                    }
                                }catch (Exception e) {
                                    synPolicyLogger.error("【同步退保保单】连带触发该保单同步异常,订单号:{},保单号:{},原因:{}",synPolicySurrenderDto.getOrderCode(),synPolicySurrenderDto.getPolicyNo(),e);
                                }catch (Throwable t) {
                                    synPolicyLogger.error("【同步退保保单】连带触发该保单同步异常,订单号:{},保单号:{},原因:{}",synPolicySurrenderDto.getOrderCode(),synPolicySurrenderDto.getPolicyNo(),t);
                                }
                                synPolicySurrenderDto.setDealStatus("3"); 
                                synPolicyLogger.warn("【同步退保保单】核心保单数据还没同步完成,已连带触发该保单同步,订单号:{},保单号:{}",synPolicySurrenderDto.getOrderCode(),synPolicySurrenderDto.getPolicyNo());
                            }
                        } else {
                            synPolicySurrenderDto.setDealStatus("3"); 
                            synPolicyLogger.error("【同步退保保单】查询保单数据请求失败,订单号:{},保单号:{}",synPolicySurrenderDto.getOrderCode(),synPolicySurrenderDto.getPolicyNo());
                        }
                    } catch (Exception e) {
                        synPolicySurrenderDto.setDealStatus("3"); 
                        synPolicyLogger.error("【同步退保保单】同步退保保单失败,订单号:{},保单号:{},原因:{}",synPolicySurrenderDto.getOrderCode(),synPolicySurrenderDto.getPolicyNo(),e);
                    } catch (Throwable t) {
                        synPolicySurrenderDto.setDealStatus("3"); 
                        synPolicyLogger.error("【同步退保保单】同步退保保单失败,订单号:{},保单号:{},原因:{}",synPolicySurrenderDto.getOrderCode(),synPolicySurrenderDto.getPolicyNo(),t);
                    }
                    
                    if("2".equals(synPolicySurrenderDto.getDealStatus())) { // 处理成功
                        // t_order_main
                        OrderMainDto orderMain = new OrderMainDto();
                        orderMain.setSynPolicySurrenderStatus("0"); // 已同步
                        orderMain.setUpdatedDate(new Date());
                        orderMain.setUpdatedUser(UPDATED_USER);
                        Condition orderMainCond = new Condition(OrderMainDto.class);
                        orderMainCond.createCriteria().andEqualTo("orderCode", synPolicySurrenderDto.getOrderCode())
                                                      .andEqualTo("policyNo", synPolicySurrenderDto.getPolicyNo());
                        orderMainService.updateByConditionNotNull(orderMain, orderMainCond);
                    }
                    
                    Condition synPolicySurrenderCond = new Condition(SynPolicySurrenderDto.class);
                    synPolicySurrenderCond.createCriteria().andEqualTo("orderCode", synPolicySurrenderDto.getOrderCode())
                                                           .andEqualTo("policyNo", synPolicySurrenderDto.getPolicyNo())
                                                           .andNotEqualTo("dealStatus", "2"); // 处理成功(避免其他情况)
                    synPolicySurrenderDto.setUpdatedDate(new Date());
                    synPolicySurrenderDto.setUpdatedUser(UPDATED_USER);
                    synPolicySurrenderDto.setDealCount(synPolicySurrenderDto.getDealCount() + 1);
                    synPolicySurrenderDto.setOrderCode(null);
                    synPolicySurrenderDao.updateByConditionNotNull(synPolicySurrenderDto, synPolicySurrenderCond);
                }
            }
        }
        return factDealCount;
    }

    // ----------------------------------------------------------------------------------------------------------------------
    /**
     * 处理退保保单同步异常情况状态一直处于处理中数据
     */
    @Override
    public String taskSynPolicySurrenderProcessDeal() {
        DateTime startTime = new DateTime(new DateTime(), DateTime.YEAR_TO_MILLISECOND);
        // 获取同步保单配置信息
        SynPolicyCfgDto synPolicyCfgDto = new SynPolicyCfgDto();
        synPolicyCfgDto.setDealType("5");
        synPolicyCfgDto = synPolicyCfgService.selectByPrimaryKey(synPolicyCfgDto);
        if (synPolicyCfgDto == null) {
            synPolicyLogger.error("【处理同步保单异常处理中数据】获取处理退保处理中配置信息失败,SynPolicySurrenderService.taskSynPolicySurrenderProcessDeal()同步方法");
            return "获取处理退保处理中配置信息失败";
        }

        // 获取需要同步订单信息
        SynPolicySurrenderDto synPolicySurrenderCond = new SynPolicySurrenderDto();
        synPolicySurrenderCond.setDealCount(synPolicyCfgDto.getFailRetryCount());
        synPolicySurrenderCond.setDealBeforeDate(synPolicyCfgDto.getDealBeforeDate());
        synPolicySurrenderCond.setLimitCount(synPolicyCfgDto.getLimitCount());
        synPolicySurrenderCond.setNowTime(new Date());
        List<SynPolicySurrenderDto> synPolicySurrenderList = synPolicySurrenderDao.findSynPolicySurrenderProcessData(synPolicySurrenderCond);

        int count = this.synPolicySurrenderProcessDeal(synPolicySurrenderList);

        DateTime endTime = new DateTime(new DateTime(), DateTime.YEAR_TO_MILLISECOND);
        return "执行情况=" + startTime + " - " + endTime + ", 处理条数:" + count;
    }
    
    // ----------------------------------------------------------------------------------------------------------------------
    /**
     * 退保保单同步异常情况状态一直处于处理中数据处理过程
     * 
     * @param synPolicySurrenderList
     */
    @Override
    public int synPolicySurrenderProcessDeal(List<SynPolicySurrenderDto> synPolicySurrenderList) {
        int factDealCount = 0;
        if (CollectionUtil.isNotEmpty(synPolicySurrenderList)) {
            for(SynPolicySurrenderDto synPolicySurrenderDto : synPolicySurrenderList) {
                try {
                    // 防止并发处理原子化切断
                    synPolicySurrenderDto.setUpdatedUser(UPDATED_USER);
                    synPolicySurrenderDto.setNowTime(new Date());
                    int count = synPolicySurrenderDao.updateSynPolicySurrenderProcessData(synPolicySurrenderDto);
                    if(count == 0) {
                        continue;
                    }
                    
                    factDealCount++;
                    
                    // 查询核心是否有这个保单
                    PolicyTransDto requestDto = new PolicyTransDto();
                    HeadDto headRequestDto = new HeadDto();
                    headRequestDto.setInterfaceCode(QUERY_POLICY);
                    requestDto.setHeadRequest(headRequestDto);
                    BodyDto bodyRequestDto = new BodyDto();
                    PolicyMainDto queryPolicyInfoDto = new PolicyMainDto();
                    queryPolicyInfoDto.setPolicyNo(synPolicySurrenderDto.getPolicyNo());
                    queryPolicyInfoDto.setOrderCode(String.valueOf(synPolicySurrenderDto.getOrderCode()));
                    bodyRequestDto.setGuPolicyMainDto(queryPolicyInfoDto);
                    requestDto.setBodyRequest(bodyRequestDto);
                    //synPolicyLogger.info("【处理同步保单异常处理中数据】调用保单数据查询接口开始,保单号:{}",synPolicySurrenderDto.getPolicyNo());
                    HttpResponseWrapper result = new ClientUtils().connectServer(requestDto, ConfigUtil.getValue("remote.prpall.url"));
                    //synPolicyLogger.info("【处理同步保单异常处理中数据】调用保单数据查询接口结束,保单号:{}",synPolicySurrenderDto.getPolicyNo());
                    if (result.getStatus()) {
                        PolicyTransDto transResult = JSON.parseObject((String)result.getContent(), PolicyTransDto.class);
                        if ("0".equals(transResult.getHeadResponse().getResponseCode())) { // 核心存在该保单数据
                            if ("0".equals(transResult.getBodyResponse().getPolicyMainMap().getSurrenderInd())) { // 未退保
                                synPolicySurrenderDto.setDealStatus("3"); 
                            }else {
                                synPolicySurrenderDto.setDealStatus("2"); 
                            }
                        }else {
                            synPolicySurrenderDto.setDealStatus("3"); 
                        }
                    }else {
                        synPolicySurrenderDto.setDealStatus("3"); 
                        synPolicyLogger.error("【处理同步退保保单异常处理中数据】查询保单数据请求失败,订单号:{},保单号:{}", synPolicySurrenderDto.getOrderCode(),synPolicySurrenderDto.getPolicyNo());
                    }
                    
                } catch (Exception e) {
                    synPolicySurrenderDto.setDealStatus("3");
                    synPolicyLogger.error("【处理同步退保保单异常处理中数据】处理失败,订单号:{},保单号:{},原因:{}", synPolicySurrenderDto.getOrderCode(),synPolicySurrenderDto.getPolicyNo(), e);
                } catch (Throwable t) {
                    synPolicySurrenderDto.setDealStatus("3");
                    synPolicyLogger.error("【处理同步退保保单异常处理中数据】处理失败,订单号:{},保单号:{},原因:{}", synPolicySurrenderDto.getOrderCode(),synPolicySurrenderDto.getPolicyNo(), t);
                }
                
                if("2".equals(synPolicySurrenderDto.getDealStatus())) { // 处理成功
                    // t_order_main
                    OrderMainDto orderMain = new OrderMainDto();
                    orderMain.setSynPolicySurrenderStatus("0"); // 已同步
                    orderMain.setUpdatedUser(UPDATED_USER);
                    orderMain.setUpdatedDate(new Date());
                    Condition orderMainCond = new Condition(OrderMainDto.class);
                    orderMainCond.createCriteria().andEqualTo("orderCode", synPolicySurrenderDto.getOrderCode())
                                                  .andEqualTo("policyNo", synPolicySurrenderDto.getPolicyNo());
                    orderMainService.updateByConditionNotNull(orderMain, orderMainCond);
                }
                
                Condition synPolicySurrenderCond = new Condition(SynPolicySurrenderDto.class);
                synPolicySurrenderCond.createCriteria().andEqualTo("orderCode", synPolicySurrenderDto.getOrderCode())
                                                       .andEqualTo("policyNo", synPolicySurrenderDto.getPolicyNo())
                                                       .andNotEqualTo("dealStatus", "2"); // 处理成功(避免其他情况)
                synPolicySurrenderDto.setUpdatedDate(new Date());
                synPolicySurrenderDto.setUpdatedUser(UPDATED_USER);
                synPolicySurrenderDto.setDealCount(synPolicySurrenderDto.getDealCount() + 1);
                synPolicySurrenderDto.setOrderCode(null);
                synPolicySurrenderDao.updateByConditionNotNull(synPolicySurrenderDto, synPolicySurrenderCond);
            }
        }
        
        return factDealCount;
    }
}