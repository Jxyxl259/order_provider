/*
 * Created By lujicong (2017-03-20 14:44:31)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.syn.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.yaic.fa.mybatis.mapper.entity.Condition;
import com.yaic.fa.mybatis.pagehelper.PageHelper;
import com.yaic.fa.mybatis.pagehelper.PageInfo;
import com.yaic.fa.service.BaseService;
import com.yaic.servicelayer.datetime.DateTime;
import com.yaic.servicelayer.http.wrapper.HttpResponseWrapper;
import com.yaic.servicelayer.util.CollectionUtil;
import com.yaic.servicelayer.util.ConfigUtil;
import com.yaic.app.order.dto.domain.OrderMainDto;
import com.yaic.app.order.dto.domain.OrderPayinfoDto;
import com.yaic.app.order.dto.domain.ShopOrderInfoDto;
import com.yaic.app.order.service.OrderMainService;
import com.yaic.app.order.service.OrderPayinfoService;
import com.yaic.app.order.service.OrderService;
import com.yaic.app.order.service.ShopOrderInfoService;
import com.yaic.app.order.utils.ClientUtils;
import com.yaic.app.syn.dao.SynPolicyDao;
import com.yaic.app.syn.dto.custom.BodyDto;
import com.yaic.app.syn.dto.custom.HeadDto;
import com.yaic.app.syn.dto.custom.PolicyMainDto;
import com.yaic.app.syn.dto.custom.PolicyTransDto;
import com.yaic.app.syn.dto.custom.SynPolicyInfo;
import com.yaic.app.syn.dto.domain.SynPolicyCfgDto;
import com.yaic.app.syn.dto.domain.SynPolicyDtlDto;
import com.yaic.app.syn.dto.domain.SynPolicyDto;
import com.yaic.app.syn.service.SynPolicyCfgService;
import com.yaic.app.syn.service.SynPolicyDtlService;
import com.yaic.app.syn.service.SynPolicyService;
import com.yaic.app.trans.dto.custom.SynPolicyDetail;
import com.yaic.app.trans.dto.msg.TransSynPolicyReq;
import com.yaic.app.trans.dto.msg.TransSynPolicyResp;
import com.yaic.app.trans.dto.msg.common.TransRequestMessage;
import com.yaic.app.trans.dto.msg.common.TransResponseMessage;

@Service("synPolicyService")
public class SynPolicyServiceImpl extends BaseService<SynPolicyDto> implements SynPolicyService {

    private static final Logger synPolicyLogger = LoggerFactory.getLogger("synPolicyLogger");
    
    private static final String TASK_SYN_POLICY = "TaskSynPolicy";
    private static final String QUERY_POLICY = "queryPolicy";
    private static final String SUCCESS_CODE = "0000";
    private static final String UPDATED_USER = "SYN";

    @Autowired
    private SynPolicyDao synPolicyDao;
    @Autowired
    private SynPolicyDtlService synPolicyDtlService;
    @Autowired
    private SynPolicyCfgService synPolicyCfgService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderMainService orderMainService;
    @Autowired
    private OrderPayinfoService orderPayinfoService;
    @Autowired
    private ShopOrderInfoService shopOrderInfoService;

    @Override
    public PageInfo<SynPolicyDto> findPageInfo(int page, int rows, SynPolicyDto synPolicyDto, String orderBy) {
        PageHelper.startPage(page, rows, orderBy);
        List<SynPolicyDto> list = synPolicyDao.findPageInfo(synPolicyDto);
        return new PageInfo<SynPolicyDto>(list);
    }

    @Override
    public int deleteSynPolicyData(SynPolicyDto synPolicyDto) {
        return synPolicyDao.deleteSynPolicyData(synPolicyDto);
    }
    
    // ----------------------------------------------------------------------------------------------------------------------
    /**
     * 同步保单升序获取数据
     */
    @Override
    public String taskSynPolicyDeal() {
        DateTime startTime = new DateTime(new DateTime(), DateTime.YEAR_TO_MILLISECOND);
        // 获取同步保单配置信息
        SynPolicyCfgDto synPolicyCfgDto = new SynPolicyCfgDto();
        synPolicyCfgDto.setDealType("0");
        synPolicyCfgDto = synPolicyCfgService.selectByPrimaryKey(synPolicyCfgDto);
        if (synPolicyCfgDto == null) {
            synPolicyLogger.error("【同步保单-升序】获取同步保单配置信息失败,SynPolicyService.taskSynPolicyDeal()同步方法");
            return "获取同步保单配置信息失败";
        }

        // 获取需要同步订单信息
        SynPolicyDto synPolicyCond = new SynPolicyDto();
        synPolicyCond.setDealCount(synPolicyCfgDto.getFailRetryCount());
        synPolicyCond.setDealBeforeDate(synPolicyCfgDto.getDealBeforeDate());
        synPolicyCond.setLimitCount(synPolicyCfgDto.getLimitCount());
        synPolicyCond.setNowTime(new Date());
        synPolicyCond.setSortType("ASC");
        List<SynPolicyDto> synPolicyList = synPolicyDao.findSynPolicyData(synPolicyCond);

        int count = this.taskSynPolicyDealProcess(synPolicyList);

        DateTime endTime = new DateTime(new DateTime(), DateTime.YEAR_TO_MILLISECOND);
        return "执行情况=" + startTime + " - " + endTime + ", 处理条数:" + count;
    }
    
    // ----------------------------------------------------------------------------------------------------------------------
    /**
     * 同步保单降序获取数据
     */
    @Override
    public String taskSynPolicyDealDesc() {
        DateTime startTime = new DateTime(new DateTime(), DateTime.YEAR_TO_MILLISECOND);
        // 获取同步保单配置信息
        SynPolicyCfgDto synPolicyCfgDto = new SynPolicyCfgDto();
        synPolicyCfgDto.setDealType("1");
        synPolicyCfgDto = synPolicyCfgService.selectByPrimaryKey(synPolicyCfgDto);
        if (synPolicyCfgDto == null) {
            synPolicyLogger.error("【同步保单-降序】获取同步保单配置信息失败,SynPolicyService.taskSynPolicyDeal()同步方法");
            return "获取同步保单配置信息失败";
        }

        // 获取需要同步订单信息
        SynPolicyDto synPolicyCond = new SynPolicyDto();
        synPolicyCond.setDealCount(synPolicyCfgDto.getFailRetryCount());
        synPolicyCond.setDealBeforeDate(synPolicyCfgDto.getDealBeforeDate());
        synPolicyCond.setLimitCount(synPolicyCfgDto.getLimitCount());
        synPolicyCond.setNowTime(new Date());
        synPolicyCond.setSortType("DESC");
        List<SynPolicyDto> synPolicyList = synPolicyDao.findSynPolicyData(synPolicyCond);

        int count = this.taskSynPolicyDealProcess(synPolicyList);

        DateTime endTime = new DateTime(new DateTime(), DateTime.YEAR_TO_MILLISECOND);
        return "执行情况=" + startTime + " - " + endTime + ", 处理条数:" + count;
    }

    // ----------------------------------------------------------------------------------------------------------------------
    /**
     * 同步保单处理过程
     * 
     * @param synPolicyList
     */
    @Override
    public int taskSynPolicyDealProcess(List<SynPolicyDto> synPolicyList) {
        int factDealCount = 0;
        if (CollectionUtil.isNotEmpty(synPolicyList)) {
            // 批量锁定待处理记录
            List<SynPolicyDto> synPolicyRecords = new ArrayList<SynPolicyDto>();
            SynPolicyDto synPolicyUpdate = null;
            for (SynPolicyDto synPolicyDto : synPolicyList) {
                synPolicyUpdate = new SynPolicyDto();
                synPolicyUpdate.setDealStatus("1"); // 处理中
                synPolicyUpdate.setUpdatedUser(UPDATED_USER);
                synPolicyUpdate.setUpdatedDate(new Date());
                Condition condition = new Condition(SynPolicyDto.class);
                List<Object> statusList = new ArrayList<Object>();
                statusList.add("0"); // 未处理
                statusList.add("3"); // 处理失败
                condition.createCriteria().andEqualTo("orderCode", synPolicyDto.getOrderCode()).andIn("dealStatus", statusList);
                int count = synPolicyDao.updateByConditionNotNull(synPolicyUpdate, condition);
                if (count == 0) {
                    continue;
                }
                synPolicyRecords.add(synPolicyDto);
            }
            // 转保单
            if (CollectionUtil.isNotEmpty(synPolicyRecords)) {
                factDealCount = synPolicyRecords.size();
                TransRequestMessage transRequestMessage = null;
                SynPolicyInfo synPolicyInfo = null;
                for (SynPolicyDto synPolicyDto : synPolicyRecords) {
                    try {
                        // 准备数据
                        synPolicyInfo = new SynPolicyInfo();
                        synPolicyInfo.setSynPolicy(synPolicyDto);
                        SynPolicyDtlDto synPolicyDtlDto = new SynPolicyDtlDto();
                        synPolicyDtlDto.setOrderCode(synPolicyDto.getOrderCode());
                        List<SynPolicyDtlDto> synPolicyDtlList = synPolicyDtlService.select(synPolicyDtlDto);
                        if (!synPolicyDto.getDetailCount().equals(synPolicyDtlList.size())) {
                            //synPolicyLogger.warn("【同步保单】同步保单任务表数据跟订单数据对不上,订单号:{}", synPolicyDto.getOrderCode());
                            Condition synPolicyCond = new Condition(SynPolicyDto.class);
                            synPolicyCond.createCriteria().andEqualTo("orderCode", synPolicyDto.getOrderCode());
                            synPolicyDto.setDealStatus("3");
                            synPolicyDto.setUpdatedUser(UPDATED_USER);
                            synPolicyDto.setUpdatedDate(new Date());
                            synPolicyDto.setDealCount(synPolicyDto.getDealCount() + 1);
                            synPolicyDto.setOrderCode(null);
                            synPolicyDao.updateByConditionNotNull(synPolicyDto, synPolicyCond);
                            continue;
                        }
                        
                        boolean allSuccess = false;
                        // ---------------------------------------------------------------------------
                        // 如果是失败优先取查询核心
                        if("3".equals(synPolicyDto.getDealStatus())) {
                            if(CollectionUtil.isNotEmpty(synPolicyDtlList)) {
                                List<SynPolicyDetail> synPolicyDetails = new ArrayList<SynPolicyDetail>();
                                SynPolicyDetail synPolicyDetail = null;
                                for(SynPolicyDtlDto item : synPolicyDtlList) {
                                    synPolicyDetail = new SynPolicyDetail();
                                    synPolicyDetail.setOrderMainId(item.getOrderMainId());
                                    synPolicyDetail.setPolicyNo(item.getPolicyNo());
                                    synPolicyDetails.add(synPolicyDetail);
                                }
                                // 处理失败去查询核心是否有保单
                                if(this.judgeFromNBZ(synPolicyDto.getOrderCode(), synPolicyDetails)) {
                                    allSuccess = true;
                                }else {
                                    synPolicyDtlList = synPolicyDtlService.select(synPolicyDtlDto);
                                }
                            }
                        }
                        // ---------------------------------------------------------------------------
                        if(!allSuccess) {
                            synPolicyInfo.setSynPolicyDtlList(synPolicyDtlList);
                            // 系统交互
                            transRequestMessage = new TransRequestMessage();
                            transRequestMessage.setRequestTime(new Date());
                            transRequestMessage.setInterfaceCode(TASK_SYN_POLICY);
                            TransSynPolicyReq synPolicyReq = new TransSynPolicyReq();
                            synPolicyReq.setShopOrderDto(orderService.getOrderDetailInfo(synPolicyDto.getOrderCode()));
                            synPolicyReq.setSynPolicyInfo(synPolicyInfo);
                            transRequestMessage.getData().setSynPolicyReq(synPolicyReq);
                            //synPolicyLogger.info("【同步保单】调用同步保单接口开始,订单号:{}",synPolicyDto.getOrderCode());
                            HttpResponseWrapper transResult = new ClientUtils().connectServer(transRequestMessage, ConfigUtil.getValue("remote.trans.url"));
                            //synPolicyLogger.info("【同步保单】调用同步保单接口结束,订单号:{},返回:{}",synPolicyDto.getOrderCode(),transResult[1]);
                            if (transResult.getStatus()) {
                                TransResponseMessage transResponseMessage = JSON.parseObject((String)transResult.getContent(), TransResponseMessage.class);
                                if (SUCCESS_CODE.equals(transResponseMessage.getCode())) {
                                    TransSynPolicyResp synPolicyResp = transResponseMessage.getData().getSynPolicyResp();
                                    BigInteger orderCode = synPolicyResp.getOrderCode();
                                    String synPolicyStatus = synPolicyResp.getSynPolicyStatus();
                                    List<SynPolicyDetail> synPolicyDetailList = synPolicyResp.getSynPolicyDetailList();

                                    if ("1".equals(synPolicyStatus)) { // 处理成功
                                        synPolicyDto.setDealStatus("2");
                                        // 更新任务及业务数据
                                        this.updateTaskBizInfo(orderCode, synPolicyDetailList);
                                    } else {
                                        synPolicyDto.setDealStatus("3");
                                        // 更新业务数据
                                        this.updateTaskBizInfo(orderCode, synPolicyDetailList);
                                        // 处理失败去查询核心是否有保单
                                        if(this.judgeFromNBZ(orderCode, synPolicyDetailList)) {
                                            synPolicyDto.setDealStatus("2");
                                        }
                                    }
                                } else {
                                    synPolicyDto.setDealStatus("3");
                                    synPolicyLogger.error("【同步保单】转保单失败,订单号:{},响应状态为:{},原因:{}", synPolicyDto.getOrderCode(), transResponseMessage.getStatusCode(),transResponseMessage.getMessage());
                                }
                            } else {
                                synPolicyDto.setDealStatus("3");
                                synPolicyLogger.error("【同步保单】转保单失败,订单号:{},原因:{}", synPolicyDto.getOrderCode(), transResult.getErrorMessage());
                            }
                        }else {
                            synPolicyDto.setDealStatus("2");
                        }
                        
                    } catch (Exception e) {
                        synPolicyDto.setDealStatus("3");
                        synPolicyLogger.error("【同步保单】转保单失败,订单号:{},原因:{}", synPolicyDto.getOrderCode(), e);
                    } catch (Throwable t) {
                        synPolicyDto.setDealStatus("3");
                        synPolicyLogger.error("【同步保单】转保单失败,订单号:{},原因:{}", synPolicyDto.getOrderCode(), t);
                    }
                    
                    if("2".equals(synPolicyDto.getDealStatus())) { // 2-处理成功
                        // t_shop_order_info
                        ShopOrderInfoDto shopOrderInfoDto = new ShopOrderInfoDto();
                        shopOrderInfoDto.setSynPolicyStatus("0"); // 已同步
                        shopOrderInfoDto.setUpdatedUser(UPDATED_USER);
                        shopOrderInfoDto.setUpdatedDate(new Date());
                        Condition shopOrderInfoCond = new Condition(ShopOrderInfoDto.class);
                        shopOrderInfoCond.createCriteria().andEqualTo("orderCode", synPolicyDto.getOrderCode());
                        shopOrderInfoService.updateByConditionNotNull(shopOrderInfoDto, shopOrderInfoCond);
                    }
                    
                    Condition synPolicyCond = new Condition(SynPolicyDto.class);
                    synPolicyCond.createCriteria().andEqualTo("orderCode", synPolicyDto.getOrderCode());
                    synPolicyDto.setUpdatedUser(UPDATED_USER);
                    synPolicyDto.setUpdatedDate(new Date());
                    synPolicyDto.setDealCount(synPolicyDto.getDealCount() + 1);
                    synPolicyDto.setOrderCode(null);
                    synPolicyDao.updateByConditionNotNull(synPolicyDto, synPolicyCond);
                }
            }
        }
        return factDealCount;
    }
    
    /**
     * 处理失败去查询核心是否有保单
     * @param orderCode
     * @param synPolicyDetailList
     * @return
     */
    private boolean judgeFromNBZ(BigInteger orderCode, List<SynPolicyDetail> synPolicyDetailList) {
        boolean allSuccess = false;
        if (CollectionUtil.isNotEmpty(synPolicyDetailList)) {
            allSuccess = true;
            for (SynPolicyDetail item : synPolicyDetailList) {
                // 查询核心是否有这个保单
                PolicyTransDto requestDto = new PolicyTransDto();
                HeadDto headRequestDto = new HeadDto();
                headRequestDto.setInterfaceCode(QUERY_POLICY);
                requestDto.setHeadRequest(headRequestDto);
                BodyDto bodyRequestDto = new BodyDto();
                PolicyMainDto queryPolicyInfoDto = new PolicyMainDto();
                queryPolicyInfoDto.setPolicyNo(item.getPolicyNo());
                queryPolicyInfoDto.setOrderCode(String.valueOf(orderCode));
                bodyRequestDto.setGuPolicyMainDto(queryPolicyInfoDto);
                requestDto.setBodyRequest(bodyRequestDto);
                //synPolicyLogger.info("【同步保单】调用保单数据查询接口开始,保单号:{}",item.getPolicyNo());
                HttpResponseWrapper result = new ClientUtils().connectServer(requestDto, ConfigUtil.getValue("remote.prpall.url"));
                //synPolicyLogger.info("【同步保单】调用保单数据查询接口结束,保单号:{}",item.getPolicyNo());
                if (result.getStatus()) {
                    PolicyTransDto queryResult = JSON.parseObject((String)result.getContent(), PolicyTransDto.class);
                    if ("0".equals(queryResult.getHeadResponse().getResponseCode())) { // 核心存在该保单数据
                        // t_order_main
                        OrderMainDto orderMainDto = new OrderMainDto();
                        orderMainDto.setSynPolicyStatus("0"); // 已同步
                        orderMainDto.setUnderwriterInd("6"); // 承保确认
                        orderMainDto.setUpdatedUser(UPDATED_USER);
                        orderMainDto.setUpdatedDate(new Date());
                        Condition orderMainCond = new Condition(OrderMainDto.class);
                        orderMainCond.createCriteria().andEqualTo("orderMainId", item.getOrderMainId())
                                                      .andEqualTo("orderCode", orderCode);
                        orderMainService.updateByConditionNotNull(orderMainDto, orderMainCond);
                        // 更新任务表信息
                        SynPolicyDtlDto policyDtlDto = new SynPolicyDtlDto();
                        policyDtlDto.setDealStatus("3");
                        policyDtlDto.setUpdatedUser(UPDATED_USER);
                        policyDtlDto.setUpdatedDate(orderMainDto.getUpdatedDate());
                        Condition synPolicyDtlCond = new Condition(SynPolicyDtlDto.class);
                        synPolicyDtlCond.createCriteria().andEqualTo("orderCode", orderCode)
                                                         .andEqualTo("orderMainId", item.getOrderMainId());
                        synPolicyDtlService.updateByConditionNotNull(policyDtlDto,synPolicyDtlCond);
                    }else {
                        allSuccess = false;
                    }
                }else {
                    allSuccess = false;
                }
            }
        }
        return allSuccess;
    }
    
    /**
     * 更新任务及业务数据
     * @param orderCode
     * @param synPolicyDetailList
     * @param needTask
     */
    private void updateTaskBizInfo(BigInteger orderCode, List<SynPolicyDetail> synPolicyDetailList) {
        if (CollectionUtil.isNotEmpty(synPolicyDetailList)) {
            for (SynPolicyDetail item : synPolicyDetailList) {
                Date updatedDate = new Date();
                // 更新业务表信息
                // t_order_main
                OrderMainDto orderMainDto = new OrderMainDto();
                if("3".equals(item.getSynDealStatus())) { // 3-转保单成功
                    orderMainDto.setSynPolicyStatus("0"); // 已同步
                    orderMainDto.setUnderwriterInd("6"); // 承保确认
                }
                orderMainDto.setProposalNo(item.getProposalNo());
                orderMainDto.setUpdatedUser(UPDATED_USER);
                orderMainDto.setUpdatedDate(updatedDate);
                Condition orderMainCond = new Condition(OrderMainDto.class);
                orderMainCond.createCriteria().andEqualTo("orderMainId", item.getOrderMainId())
                                              .andEqualTo("orderCode", orderCode);
                orderMainService.updateByConditionNotNull(orderMainDto, orderMainCond);
                // t_order_payinfo
                OrderPayinfoDto orderPayinfoDto = new OrderPayinfoDto();
                orderPayinfoDto.setPayNo(item.getTrandNo()); // 交易流水号
                orderPayinfoDto.setUpdatedUser(UPDATED_USER);
                orderPayinfoDto.setUpdatedDate(updatedDate);
                Condition orderPayCond = new Condition(OrderPayinfoDto.class);
                orderPayCond.createCriteria().andEqualTo("orderMainId", item.getOrderMainId())
                                             .andEqualTo("orderCode", orderCode);
                orderPayinfoService.updateByConditionNotNull(orderPayinfoDto, orderPayCond);
                // 更新任务表信息
                SynPolicyDtlDto policyDtlDto = new SynPolicyDtlDto();
                policyDtlDto.setDealStatus(item.getSynDealStatus());
                policyDtlDto.setUpdatedUser(UPDATED_USER);
                policyDtlDto.setUpdatedDate(updatedDate);
                Condition synPolicyDtlCond = new Condition(SynPolicyDtlDto.class);
                synPolicyDtlCond.createCriteria().andEqualTo("orderMainId", item.getOrderMainId())
                                                 .andEqualTo("orderCode", orderCode);
                synPolicyDtlService.updateByConditionNotNull(policyDtlDto,synPolicyDtlCond);
            }
        }
    }
    
    // ----------------------------------------------------------------------------------------------------------------------
    /**
     * 处理保单同步异常情况状态一直处于处理中数据
     */
    @Override
    public String taskSynPolicyProcessDeal() {
        DateTime startTime = new DateTime(new DateTime(), DateTime.YEAR_TO_MILLISECOND);
        // 获取同步保单配置信息
        SynPolicyCfgDto synPolicyCfgDto = new SynPolicyCfgDto();
        synPolicyCfgDto.setDealType("4");
        synPolicyCfgDto = synPolicyCfgService.selectByPrimaryKey(synPolicyCfgDto);
        if (synPolicyCfgDto == null) {
            synPolicyLogger.error("【处理同步保单异常处理中数据】获取处理承保处理中配置信息失败,SynPolicyService.taskSynPolicyProcessDeal()同步方法");
            return "获取处理承保处理中配置信息失败";
        }

        // 获取需要同步订单信息
        SynPolicyDto synPolicyCond = new SynPolicyDto();
        synPolicyCond.setDealCount(synPolicyCfgDto.getFailRetryCount());
        synPolicyCond.setDealBeforeDate(synPolicyCfgDto.getDealBeforeDate());
        synPolicyCond.setLimitCount(synPolicyCfgDto.getLimitCount());
        synPolicyCond.setNowTime(new Date());
        List<SynPolicyDto> synPolicyList = synPolicyDao.findSynPolicyProcessData(synPolicyCond);

        int count = this.synPolicyProcessDeal(synPolicyList);

        DateTime endTime = new DateTime(new DateTime(), DateTime.YEAR_TO_MILLISECOND);
        return "执行情况=" + startTime + " - " + endTime + ", 处理条数:" + count;
    }
    
    // ----------------------------------------------------------------------------------------------------------------------
    /**
     * 保单同步异常情况状态一直处于处理中数据处理过程
     * 
     * @param synPolicyList
     */
    @Override
    public int synPolicyProcessDeal(List<SynPolicyDto> synPolicyList) {
        int factDealCount = 0;
        if (CollectionUtil.isNotEmpty(synPolicyList)) {
            SynPolicyDtlDto synPolicyDtlDto = null;
            for (SynPolicyDto synPolicyDto : synPolicyList) {
                try {
                    // 防止并发处理原子化切断
                    synPolicyDto.setUpdatedUser(UPDATED_USER);
                    synPolicyDto.setNowTime(new Date());
                    int count = synPolicyDao.updateSynPolicyProcessData(synPolicyDto);
                    if(count == 0) {
                        continue;
                    }
                    
                    factDealCount++;
                    
                    synPolicyDtlDto = new SynPolicyDtlDto();
                    synPolicyDtlDto.setOrderCode(synPolicyDto.getOrderCode());
                    List<SynPolicyDtlDto> synPolicyDtlList = synPolicyDtlService.select(synPolicyDtlDto);
                    if (!synPolicyDto.getDetailCount().equals(synPolicyDtlList.size())) {
                        synPolicyLogger.error("【处理同步保单异常处理中数据】同步保单任务表数据跟订单数据对不上,订单号:{}", synPolicyDto.getOrderCode());
                        Condition synPolicyCond = new Condition(SynPolicyDto.class);
                        synPolicyCond.createCriteria().andEqualTo("orderCode", synPolicyDto.getOrderCode());
                        synPolicyDto.setDealStatus("3");
                        synPolicyDto.setUpdatedUser(UPDATED_USER);
                        synPolicyDto.setUpdatedDate(new Date());
                        synPolicyDto.setDealCount(synPolicyDto.getDealCount() + 1);
                        synPolicyDto.setOrderCode(null);
                        synPolicyDao.updateByConditionNotNull(synPolicyDto, synPolicyCond);
                        continue;
                    }
                    
                    synPolicyDto.setDealStatus("2");
                    if(CollectionUtil.isNotEmpty(synPolicyDtlList)) {
                        OrderMainDto orderMainDto = null;
                        for (SynPolicyDtlDto item : synPolicyDtlList) {
                            // 准备数据
                            orderMainDto = new OrderMainDto();
                            orderMainDto.setOrderCode(item.getOrderCode());
                            orderMainDto.setOrderMainId(item.getOrderMainId());
                            orderMainDto = orderMainService.selectOne(orderMainDto);
                            
                            // 查询核心是否有这个保单
                            PolicyTransDto requestDto = new PolicyTransDto();
                            HeadDto headRequestDto = new HeadDto();
                            headRequestDto.setInterfaceCode(QUERY_POLICY);
                            requestDto.setHeadRequest(headRequestDto);
                            BodyDto bodyRequestDto = new BodyDto();
                            PolicyMainDto queryPolicyInfoDto = new PolicyMainDto();
                            queryPolicyInfoDto.setPolicyNo(orderMainDto.getPolicyNo());
                            queryPolicyInfoDto.setOrderCode(String.valueOf(orderMainDto.getOrderCode()));
                            bodyRequestDto.setGuPolicyMainDto(queryPolicyInfoDto);
                            requestDto.setBodyRequest(bodyRequestDto);
                            //synPolicyLogger.info("【处理同步保单异常处理中数据】调用保单数据查询接口开始,保单号:{}",orderMainDto.getPolicyNo());
                            HttpResponseWrapper result = new ClientUtils().connectServer(requestDto, ConfigUtil.getValue("remote.prpall.url"));
                            //synPolicyLogger.info("【处理同步保单异常处理中数据】调用保单数据查询接口结束,保单号:{}",orderMainDto.getPolicyNo());
                            if (result.getStatus()) {
                                PolicyTransDto transResult = JSON.parseObject((String)result.getContent(), PolicyTransDto.class);
                                if ("0".equals(transResult.getHeadResponse().getResponseCode())) { // 核心存在该保单数据
                                    // t_order_main
                                    OrderMainDto orderMain = new OrderMainDto();
                                    orderMain.setSynPolicyStatus("0"); // 已同步
                                    orderMain.setUpdatedUser(UPDATED_USER);
                                    orderMain.setUpdatedDate(new Date());
                                    Condition orderMainCond = new Condition(OrderMainDto.class);
                                    orderMainCond.createCriteria().andEqualTo("orderMainId", item.getOrderMainId())
                                                                  .andEqualTo("orderCode", item.getOrderCode());
                                    orderMainService.updateByConditionNotNull(orderMain, orderMainCond);
                                    // 更新任务表信息
                                    SynPolicyDtlDto policyDtlDto = new SynPolicyDtlDto();
                                    policyDtlDto.setDealStatus("3");
                                    policyDtlDto.setUpdatedUser(UPDATED_USER);
                                    policyDtlDto.setUpdatedDate(orderMain.getUpdatedDate());
                                    Condition synPolicyDtlCond = new Condition(SynPolicyDtlDto.class);
                                    synPolicyDtlCond.createCriteria().andEqualTo("orderMainId", item.getOrderMainId())
                                                                     .andEqualTo("orderCode", item.getOrderCode());
                                    synPolicyDtlService.updateByConditionNotNull(policyDtlDto,synPolicyDtlCond);
                                }else {
                                    synPolicyDto.setDealStatus("3"); 
                                }
                            }else {
                                synPolicyDto.setDealStatus("3"); 
                                synPolicyLogger.error("【处理同步保单异常处理中数据】查询保单数据请求失败,订单号:{},订单主表id:{}",item.getOrderCode(),item.getOrderMainId());
                            }
                        }
                    }
                } catch (Exception e) {
                    synPolicyDto.setDealStatus("3");
                    synPolicyLogger.error("【处理同步保单异常处理中数据】处理失败,订单号:{},原因:{}", synPolicyDto.getOrderCode(), e);
                } catch (Throwable t) {
                    synPolicyDto.setDealStatus("3");
                    synPolicyLogger.error("【处理同步保单异常处理中数据】处理失败,订单号:{},原因:{}", synPolicyDto.getOrderCode(), t);
                }
                
                if("2".equals(synPolicyDto.getDealStatus())) { // 2-处理成功
                    // t_shop_order_info
                    ShopOrderInfoDto shopOrderInfoDto = new ShopOrderInfoDto();
                    shopOrderInfoDto.setSynPolicyStatus("0"); // 已同步
                    shopOrderInfoDto.setUpdatedUser(UPDATED_USER);
                    shopOrderInfoDto.setUpdatedDate(new Date());
                    Condition shopOrderInfoCond = new Condition(ShopOrderInfoDto.class);
                    shopOrderInfoCond.createCriteria().andEqualTo("orderCode", synPolicyDto.getOrderCode());
                    shopOrderInfoService.updateByConditionNotNull(shopOrderInfoDto, shopOrderInfoCond);
                }
                
                Condition synPolicyCond = new Condition(SynPolicyDto.class);
                synPolicyCond.createCriteria().andEqualTo("orderCode", synPolicyDto.getOrderCode());
                synPolicyDto.setUpdatedUser(UPDATED_USER);
                synPolicyDto.setUpdatedDate(new Date());
                synPolicyDto.setDealCount(synPolicyDto.getDealCount() + 1);
                synPolicyDto.setOrderCode(null);
                synPolicyDao.updateByConditionNotNull(synPolicyDto, synPolicyCond);
            }
        }
        return factDealCount;
    }
    
    @Override
    public int querySynPolicyCount(SynPolicyDto synPolicyDto) {
        return synPolicyDao.querySynPolicyCount(synPolicyDto);
    }
}