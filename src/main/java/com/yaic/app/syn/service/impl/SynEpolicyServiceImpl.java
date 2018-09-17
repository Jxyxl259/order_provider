/*
 * Created By lujicong (2017-03-20 14:44:31)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.syn.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.yaic.app.Constants;
import com.yaic.app.epolicy.dto.domain.EpolicyAllKindRoot;
import com.yaic.app.epolicy.dto.domain.EpolicyApplyDto;
import com.yaic.app.epolicy.dto.domain.EpolicyApplyRoot;
import com.yaic.app.epolicy.dto.domain.EpolicyAvgpremDto;
import com.yaic.app.epolicy.dto.domain.EpolicyAvgpremRoot;
import com.yaic.app.epolicy.dto.domain.EpolicyBenefitDto;
import com.yaic.app.epolicy.dto.domain.EpolicyBenefitRoot;
import com.yaic.app.epolicy.dto.domain.EpolicyClauseDto;
import com.yaic.app.epolicy.dto.domain.EpolicyClausesRoot;
import com.yaic.app.epolicy.dto.domain.EpolicyDynamicItemDto;
import com.yaic.app.epolicy.dto.domain.EpolicyDynamicItemRoot;
import com.yaic.app.epolicy.dto.domain.EpolicyDynamicListDto;
import com.yaic.app.epolicy.dto.domain.EpolicyDynamicListRoot;
import com.yaic.app.epolicy.dto.domain.EpolicyInsuredDto;
import com.yaic.app.epolicy.dto.domain.EpolicyInsuredRoot;
import com.yaic.app.epolicy.dto.domain.EpolicyItemCargoDto;
import com.yaic.app.epolicy.dto.domain.EpolicyItemCargoRoot;
import com.yaic.app.epolicy.dto.domain.EpolicyItemkindDto;
import com.yaic.app.epolicy.dto.domain.EpolicyMainKindRoot;
import com.yaic.app.epolicy.dto.domain.EpolicyMinorKindRoot;
import com.yaic.app.epolicy.dto.domain.EpolicyPaymentDto;
import com.yaic.app.epolicy.dto.domain.EpolicyPaymentRoot;
import com.yaic.app.epolicy.dto.domain.EpolicyRootDto;
import com.yaic.app.epolicy.dto.msg.PrintEpolicyReq;
import com.yaic.app.epolicy.dto.msg.common.EpolicyRequestMessage;
import com.yaic.app.epolicy.dto.msg.common.EpolicyResponseMessage;
import com.yaic.app.epolicy.service.IEpolicyService;
import com.yaic.app.order.dto.domain.OrderCargoDtlDto;
import com.yaic.app.order.dto.domain.OrderCargoDto;
import com.yaic.app.order.dto.domain.OrderClausesDto;
import com.yaic.app.order.dto.domain.OrderCustomerDto;
import com.yaic.app.order.dto.domain.OrderDeductibleDto;
import com.yaic.app.order.dto.domain.OrderDynamicItemDto;
import com.yaic.app.order.dto.domain.OrderDynamicListDto;
import com.yaic.app.order.dto.domain.OrderItemAcciBenDto;
import com.yaic.app.order.dto.domain.OrderItemAcciDto;
import com.yaic.app.order.dto.domain.OrderItemAcciLstDto;
import com.yaic.app.order.dto.domain.OrderItemkindDto;
import com.yaic.app.order.dto.domain.OrderLimitDto;
import com.yaic.app.order.dto.domain.OrderMainDto;
import com.yaic.app.order.dto.domain.OrderPayinfoDto;
import com.yaic.app.order.dto.domain.OrderPropertyDto;
import com.yaic.app.order.dto.domain.OrderRiskDynamicDto;
import com.yaic.app.order.dto.domain.OrderSpecialClausesDto;
import com.yaic.app.order.dto.domain.ShopOrderGoodsDto;
import com.yaic.app.order.dto.msg.common.OrderDto;
import com.yaic.app.order.dto.msg.common.ShopOrderDto;
import com.yaic.app.order.service.OrderService;
import com.yaic.app.order.utils.EpolicyDynamicConverter;
import com.yaic.app.order.utils.EpolicyUtils;
import com.yaic.app.order.utils.ToolUtils;
import com.yaic.app.pdms.dto.custom.PdmsProdInfoDto;
import com.yaic.app.pdms.dto.custom.PdmsProdRiskInfoDto;
import com.yaic.app.pdms.dto.custom.PdmsSolutionInfoDto;
import com.yaic.app.pdms.dto.domain.BlockDefDto;
import com.yaic.app.pdms.dto.domain.FieldDefDto;
import com.yaic.app.pdms.dto.domain.PdmsSolutionDto;
import com.yaic.app.pdms.dto.domain.PdmsSolutionMessageDto;
import com.yaic.app.pdms.dto.domain.SolutionEpolicyDto;
import com.yaic.app.pdms.dto.msg.GetSolutionProdResp;
import com.yaic.app.pdms.dto.msg.common.PdmsResponseMessage;
import com.yaic.app.pubs.dto.msg.MailRequestDto;
import com.yaic.app.pubs.dto.msg.MailResponseDto;
import com.yaic.app.syn.dao.SynEpolicyDao;
import com.yaic.app.syn.dto.domain.SynEpolicyDto;
import com.yaic.app.syn.dto.domain.SynPolicyCfgDto;
import com.yaic.app.syn.dto.domain.SynPolicyDto;
import com.yaic.app.syn.service.SynEpolicyService;
import com.yaic.app.syn.service.SynPolicyCfgService;
import com.yaic.fa.mybatis.mapper.entity.Condition;
import com.yaic.fa.mybatis.pagehelper.PageHelper;
import com.yaic.fa.mybatis.pagehelper.PageInfo;
import com.yaic.fa.service.BaseService;
import com.yaic.servicelayer.datetime.DateTime;
import com.yaic.servicelayer.http.HttpTransceiver;
import com.yaic.servicelayer.http.wrapper.HttpResponseWrapper;
import com.yaic.servicelayer.util.CollectionUtil;
import com.yaic.servicelayer.util.ConfigUtil;
import com.yaic.servicelayer.util.DecimalUtil;
import com.yaic.servicelayer.util.ObjectUtil;
import com.yaic.servicelayer.util.StringUtil;
import com.yaic.servicelayer.util.TimeUtil;

@Service("synEpolicyService")
public class SynEpolicyServiceImpl extends BaseService<SynEpolicyDto> implements SynEpolicyService {

    private static final Logger synEpolicyLogger = LoggerFactory.getLogger("synEpolicyLogger");
    
    private static final String SUCCESS_CODE = "0000";
    private static final String UPDATED_USER = "SYN";

    @Autowired
    private SynEpolicyDao synEpolicyDao;
    @Autowired
    private SynPolicyCfgService synPolicyCfgService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private IEpolicyService epolicyService;

    @Override
    public PageInfo<SynEpolicyDto> findPageInfo(int page, int rows, SynEpolicyDto synEpolicyDto, String orderBy) {
        PageHelper.startPage(page, rows, orderBy);
        List<SynEpolicyDto> list = synEpolicyDao.findPageInfo(synEpolicyDto);
        return new PageInfo<SynEpolicyDto>(list);
    }

    @Override
    public int deleteSynEpolicyData(SynEpolicyDto synEpolicyDto) {
        return synEpolicyDao.deleteSynEpolicyData(synEpolicyDto);
    }
    
    // ----------------------------------------------------------------------------------------------------------------------
    /**
     * 同步保单升序获取数据
     */
    @Override
    public String taskSynEpolicyDeal() {
        DateTime startTime = new DateTime(new DateTime(), DateTime.YEAR_TO_MILLISECOND);
        // 获取同步保单配置信息
        SynPolicyCfgDto synPolicyCfgDto = new SynPolicyCfgDto();
        synPolicyCfgDto.setDealType("0");
        synPolicyCfgDto = synPolicyCfgService.selectByPrimaryKey(synPolicyCfgDto);
        if (synPolicyCfgDto == null) {
        	synEpolicyLogger.error("【同步电子保单-升序】获取同步保单配置信息失败,SynEpolicyService.taskSynEpolicyDeal()同步方法");
            return "获取同步保单配置信息失败";
        }

        // 获取需要同步订单信息
        SynEpolicyDto synEpolicyCond = new SynEpolicyDto();
        synEpolicyCond.setDealCount(synPolicyCfgDto.getFailRetryCount());
        synEpolicyCond.setDealBeforeDate(synPolicyCfgDto.getDealBeforeDate());
        synEpolicyCond.setLimitCount(synPolicyCfgDto.getLimitCount());
        synEpolicyCond.setNowTime(new Date());
        synEpolicyCond.setSortType("ASC");
        List<SynEpolicyDto> synEpolicyList = synEpolicyDao.findSynEpolicyData(synEpolicyCond);

        int count = this.taskSynEpolicyDealProcess(synEpolicyList);

        DateTime endTime = new DateTime(new DateTime(), DateTime.YEAR_TO_MILLISECOND);
        return "执行情况=" + startTime + " - " + endTime + ", 处理条数:" + count;
    }
    
    // ----------------------------------------------------------------------------------------------------------------------
    /**
     * 同步保单降序获取数据
     */
    @Override
    public String taskSynEpolicyDealDesc() {
        DateTime startTime = new DateTime(new DateTime(), DateTime.YEAR_TO_MILLISECOND);
        // 获取同步保单配置信息
        SynPolicyCfgDto synPolicyCfgDto = new SynPolicyCfgDto();
        synPolicyCfgDto.setDealType("1");
        synPolicyCfgDto = synPolicyCfgService.selectByPrimaryKey(synPolicyCfgDto);
        if (synPolicyCfgDto == null) {
        	synEpolicyLogger.error("【同步电子保单-降序】获取同步保单配置信息失败,SynEpolicyService.taskSynEpolicyDealDesc()同步方法");
            return "获取同步保单配置信息失败";
        }

        // 获取需要同步订单信息
        SynEpolicyDto synEpolicyCond = new SynEpolicyDto();
        synEpolicyCond.setDealCount(synPolicyCfgDto.getFailRetryCount());
        synEpolicyCond.setDealBeforeDate(synPolicyCfgDto.getDealBeforeDate());
        synEpolicyCond.setLimitCount(synPolicyCfgDto.getLimitCount());
        synEpolicyCond.setNowTime(new Date());
        synEpolicyCond.setSortType("DESC");
        List<SynEpolicyDto> synEpolicyList = synEpolicyDao.findSynEpolicyData(synEpolicyCond);

        int count = this.taskSynEpolicyDealProcess(synEpolicyList);

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
    public int taskSynEpolicyDealProcess(List<SynEpolicyDto> synEpolicyList) {
        int factDealCount = 0;
        if (CollectionUtil.isNotEmpty(synEpolicyList)) {
            // 批量锁定待处理记录
            List<SynEpolicyDto> synEpolicyRecords = new ArrayList<SynEpolicyDto>();
            SynEpolicyDto synEpolicyUpdate = null;
            for (SynEpolicyDto synEpolicyDto : synEpolicyList) {
            	synEpolicyUpdate = new SynEpolicyDto();
            	synEpolicyUpdate.setDealStatus("1"); // 处理中
            	synEpolicyUpdate.setUpdatedUser(UPDATED_USER);
            	synEpolicyUpdate.setUpdatedDate(new Date());
                Condition condition = new Condition(SynPolicyDto.class);
                List<Object> statusList = new ArrayList<Object>();
                statusList.add("0"); // 未处理
                statusList.add("3"); // 处理失败
                condition.createCriteria().andEqualTo("orderCode", synEpolicyDto.getOrderCode()).andIn("dealStatus", statusList);
                int count = synEpolicyDao.updateByConditionNotNull(synEpolicyUpdate, condition);
                if (count == 0) {
                    continue;
                }
                synEpolicyRecords.add(synEpolicyDto);
            }
            
            // 生成电子保单
            if (CollectionUtil.isNotEmpty(synEpolicyRecords)) {
                factDealCount = synEpolicyRecords.size();
                for (SynEpolicyDto synEpolicyDto : synEpolicyRecords) {
                    try {
                        // 电子保单封装
                        ShopOrderDto shopOrderDto = orderService.getOrderDetailInfo(synEpolicyDto.getOrderCode());
                    	List<OrderDto> orderOldList = shopOrderDto.getOrderList();
                    	EpolicyResponseMessage responseMessage = null;
                    	boolean allSuccess = true;
                    	if (orderOldList.size() > 1) {
                    		// 获取订单号里面的保单号列表（考虑批量出单情况）
                    		Set<String> policyNoSet = new HashSet<String>();
                    		for (OrderDto orderDto : orderOldList) {
                    			OrderMainDto orderMainDto = orderDto.getOrderMain();
                    			String policyNo = orderMainDto.getPolicyNo();
                    			if (StringUtil.isNotEmpty(orderMainDto.getAssociatedNo())) {
                    				policyNo = orderMainDto.getAssociatedNo();
                    			}
                    			policyNoSet.add(policyNo);
                    		}
                    		
                    		// 保单号列表循环获取对应保单信息
                    		for (String policyNo : policyNoSet) {
                    			List<OrderDto> orderList = new ArrayList<OrderDto>();
                    			for (OrderDto orderOldDto : orderOldList) {
                    				OrderMainDto orderMainDto = orderOldDto.getOrderMain();
                    				String policyNoOld = orderMainDto.getAssociatedNo();
                    				if (StringUtil.isEmpty(policyNoOld)) {
                    					policyNoOld = orderMainDto.getPolicyNo();
                    				}
                    				if (policyNo.equals(policyNoOld)) {
                    					orderList.add(orderOldDto);
                    				}
                    			}
                    			responseMessage = this.dealEpolicyInfo(orderList);
                    			if (responseMessage == null) {
                    				allSuccess = false;
                    				break;
                    			}
                    		}
                    	} else {
                    		responseMessage = this.dealEpolicyInfo(orderOldList);
                    	}
                    	if (responseMessage != null && allSuccess) {
                    		if (SUCCESS_CODE.equals(responseMessage.getCode())) {
                    			synEpolicyDto.setDealStatus("2");
                			} else {
                				synEpolicyDto.setDealStatus("3");
                				synEpolicyLogger.error("调用EPOLICY打印电子保单接口异常,异常原因:{}", responseMessage.getMessage());
                			}
                    	} else {
                    		synEpolicyDto.setDealStatus("2");
                    	}
                    } catch (Exception e) {
                    	synEpolicyDto.setDealStatus("3");
                    	synEpolicyLogger.error("【同步电子保单】打印电子保单失败,订单号:{},原因:{}", synEpolicyDto.getOrderCode(), e);
                    } catch (Throwable t) {
                    	synEpolicyDto.setDealStatus("3");
                    	synEpolicyLogger.error("【同步电子保单】打印电子保单失败,订单号:{},原因:{}", synEpolicyDto.getOrderCode(), t);
                    }
                    
                    Condition synEpolicyCond = new Condition(SynEpolicyDto.class);
                    synEpolicyCond.createCriteria().andEqualTo("orderCode", synEpolicyDto.getOrderCode());
                    synEpolicyDto.setUpdatedUser(UPDATED_USER);
                    synEpolicyDto.setUpdatedDate(new Date());
                    synEpolicyDto.setDealCount(synEpolicyDto.getDealCount() + 1);
                    synEpolicyDto.setOrderCode(null);
                    synEpolicyDao.updateByConditionNotNull(synEpolicyDto, synEpolicyCond);
                }
            }
        }
        return factDealCount;
    }
    
    /**
     * 处理保单同步异常情况状态一直处于处理中数据
     */
    @Override
    public String taskSynEpolicyProcessDeal() {
        DateTime startTime = new DateTime(new DateTime(), DateTime.YEAR_TO_MILLISECOND);
        // 获取同步保单配置信息
        SynPolicyCfgDto synPolicyCfgDto = new SynPolicyCfgDto();
        synPolicyCfgDto.setDealType("4");
        synPolicyCfgDto = synPolicyCfgService.selectByPrimaryKey(synPolicyCfgDto);
        if (synPolicyCfgDto == null) {
        	synEpolicyLogger.error("【处理同步保单异常处理中数据】获取处理承保处理中配置信息失败,SynPolicyService.taskSynPolicyProcessDeal()同步方法");
            return "获取处理承保处理中配置信息失败";
        }

        // 获取需要同步订单信息
        SynEpolicyDto synEpolicyCond = new SynEpolicyDto();
        synEpolicyCond.setDealCount(synPolicyCfgDto.getFailRetryCount());
        synEpolicyCond.setDealBeforeDate(synPolicyCfgDto.getDealBeforeDate());
        synEpolicyCond.setLimitCount(synPolicyCfgDto.getLimitCount());
        synEpolicyCond.setNowTime(new Date());
        List<SynEpolicyDto> synEpolicyList = synEpolicyDao.findSynEpolicyProcessData(synEpolicyCond);

        int count = this.synEpolicyProcessDeal(synEpolicyList);

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
    public int synEpolicyProcessDeal(List<SynEpolicyDto> synEpolicyList) {
        int factDealCount = 0;
        if (CollectionUtil.isNotEmpty(synEpolicyList)) {
            for (SynEpolicyDto synEpolicyDto : synEpolicyList) {
                try {
                    // 防止并发处理原子化切断
                	synEpolicyDto.setUpdatedUser(UPDATED_USER);
                	synEpolicyDto.setNowTime(new Date());
                    int count = synEpolicyDao.updateSynEpolicyProcessData(synEpolicyDto);
                    if(count == 0) {
                        continue;
                    }
                    
                    factDealCount++;
                    
                    // 电子保单封装
                    ShopOrderDto shopOrderDto = orderService.getOrderDetailInfo(synEpolicyDto.getOrderCode());
                	List<OrderDto> orderOldList = shopOrderDto.getOrderList();
                	EpolicyResponseMessage responseMessage = null;
                	boolean allSuccess = true;
                	if (orderOldList.size() > 1) {
                		// 订单列表循环获取保单号列表信息
                		Set<String> policyNoSet = new HashSet<String>();
                		for (OrderDto orderDto : orderOldList) {
                			OrderMainDto orderMainDto = orderDto.getOrderMain();
                			String policyNo = orderMainDto.getPolicyNo();
                			if (StringUtil.isNotEmpty(orderMainDto.getAssociatedNo())) {
                				policyNo = orderMainDto.getAssociatedNo();
                			}
                			policyNoSet.add(policyNo);
                		}
                		
                		// 保单号列表循环获取对应订单号列表信息并进行电子保单模板信息封装上传
                		for (String policyNo : policyNoSet) {
                			List<OrderDto> orderList = new ArrayList<OrderDto>();
                			for (OrderDto orderOldDto : orderOldList) {
                				String policyNoOld = orderOldDto.getOrderMain().getAssociatedNo();
                				if (StringUtil.isEmpty(policyNoOld)) {
                					policyNoOld = orderOldDto.getOrderMain().getPolicyNo();
                				}
                				if (policyNo.equals(policyNoOld)) {
                					orderList.add(orderOldDto);
                				}
                			}
                			// 调用电子保单模板封装方法
                			responseMessage = this.dealEpolicyInfo(orderList);
                			if (responseMessage == null) {
                				allSuccess = false;
                				break;
                			}
                		}
                	} else {
                		// 调用电子保单模板封装方法
                		responseMessage = this.dealEpolicyInfo(orderOldList);
                	}
                	if (responseMessage != null && allSuccess) {
                		if (SUCCESS_CODE.equals(responseMessage.getCode())) {
                			synEpolicyDto.setDealStatus("2");
            			} else {
            				synEpolicyDto.setDealStatus("3");
            				synEpolicyLogger.error("调用EPOLICY打印电子保单接口异常,异常原因:{}", responseMessage.getMessage());
            			}
                	} else {
                		synEpolicyDto.setDealStatus("2");
                	}
                } catch (Exception e) {
                	synEpolicyDto.setDealStatus("3");
                	synEpolicyLogger.error("【处理同步保单异常处理中数据】处理失败,订单号:{},原因:{}", synEpolicyDto.getOrderCode(), e);
                } catch (Throwable t) {
                	synEpolicyDto.setDealStatus("3");
                	synEpolicyLogger.error("【处理同步保单异常处理中数据】处理失败,订单号:{},原因:{}", synEpolicyDto.getOrderCode(), t);
                }
                
                Condition synEpolicyCond = new Condition(SynEpolicyDto.class);
                synEpolicyCond.createCriteria().andEqualTo("orderCode", synEpolicyDto.getOrderCode());
                synEpolicyDto.setUpdatedUser(UPDATED_USER);
                synEpolicyDto.setUpdatedDate(new Date());
                synEpolicyDto.setDealCount(synEpolicyDto.getDealCount() + 1);
                synEpolicyDto.setOrderCode(null);
                synEpolicyDao.updateByConditionNotNull(synEpolicyDto, synEpolicyCond);
            }
        }
        return factDealCount;
    }
    
	/**
	 * 获取电子保单模板，封装并传到电子保单系统
	 * <p>User: glizhen
	 * <p>Date: 2018年6月25日
	 * <p>Version: 1.0
	 * @throws Exception 
	 */
	@Override
	public EpolicyResponseMessage dealEpolicyInfo(List<OrderDto> orderList) throws Exception {
		EpolicyResponseMessage responseMessage = null;
		OrderMainDto orderMainDto = orderList.get(0).getOrderMain();
		String agrtCode = orderMainDto.getAgrtCode();
		String prodCode = orderMainDto.getProjectCode();
		String productName = orderMainDto.getProductName();
		//查询销售方案、产品详情信息
		PdmsResponseMessage pdmsResponseMessage = orderService.getPdmsSolutionProd(agrtCode, prodCode, null);
		if (SUCCESS_CODE.equals(pdmsResponseMessage.getCode())) {
			GetSolutionProdResp getSolutionProdResp = pdmsResponseMessage.getData().getGetSolutionProdResp();
			SolutionEpolicyDto solutionEpolicyDto = getSolutionProdResp.getPdmsSolutionInfoDto().getSolutionEpolicyDto();
			if (solutionEpolicyDto != null && StringUtil.isNotEmpty(solutionEpolicyDto.getEModelCode())) {
				List<EpolicyDynamicItemDto> epolicyDynamicItemList = new ArrayList<EpolicyDynamicItemDto>();
				List<EpolicyDynamicListDto> epolicyDynamicListList = new ArrayList<EpolicyDynamicListDto>();
				// 封装电子保单信息 
				EpolicyRootDto epolicyRoot = this.getEpolicyData(getSolutionProdResp, orderList, agrtCode, prodCode,
						solutionEpolicyDto, epolicyDynamicItemList, epolicyDynamicListList);
				
				String epolicyXml = "";
				if (CollectionUtil.isNotEmpty(epolicyDynamicItemList) || CollectionUtil.isNotEmpty(epolicyDynamicListList)) {
					//动态标的和动态清单信息特殊封装
					epolicyXml = insertDynamicInfo(epolicyRoot, epolicyDynamicItemList, epolicyDynamicListList);
				} else {
					epolicyXml = ToolUtils.toXML(epolicyRoot);
				}
				// 请求epolicy系统上传电子保单模板信息
				EpolicyRequestMessage requestMessage = new EpolicyRequestMessage();
				requestMessage.setRequestSource("ORDER");
				PrintEpolicyReq printEpolicyReq = new PrintEpolicyReq();
				printEpolicyReq.setPolicyNo(epolicyRoot.getPolicyNo());
				printEpolicyReq.setEndorSeqno("000");
				printEpolicyReq.setRiskCode(epolicyRoot.getRiskCode());
				printEpolicyReq.setDoctypeCode("AE");
				printEpolicyReq.setBusinessData(epolicyXml);
				requestMessage.getData().setReqBizData(printEpolicyReq);
				responseMessage = epolicyService.printEpolicy(requestMessage);
				synEpolicyLogger.info("上传电子保单模板保单号：{}，打印电子保单请求参数：{}，打印电子保单返回报文：{}", epolicyRoot.getPolicyNo(), 
						JSON.toJSONString(requestMessage), JSON.toJSONString(responseMessage));
				if (SUCCESS_CODE.equals(responseMessage.getCode())) {
					this.sendPrpallMail(getSolutionProdResp, epolicyRoot, productName);
				} else {
					synEpolicyLogger.error("调用EPOLICY打印电子保单接口异常,异常原因:{}", responseMessage.getMessage());
				}
			} else {// 历史产品未配置模板时默认为同步成功状态（订单同步核心已处理）
				synEpolicyLogger.info("销售方案代码为:{}未配置电子保单模板信息", agrtCode);
			}
		} else {
			responseMessage = new EpolicyResponseMessage();
			responseMessage.setCode(pdmsResponseMessage.getCode());
			responseMessage.setMessage("查询销售方案、产品详情信息接口失败:" + pdmsResponseMessage.getMessage());
			synEpolicyLogger.error("销售方案代码为:{},产品代码为:{},查询销售方案、产品详情信息接口失败,原因:{}", agrtCode, prodCode, pdmsResponseMessage.getMessage());
		}
		return responseMessage;
	}
	
	/**
	 * 封装电子保单信息
	 * <p>User: glizhen
	 * <p>Date: 2018年6月25日
	 * <p>Version: 1.0
	 * @throws Exception 
	 */
	public EpolicyRootDto getEpolicyData(GetSolutionProdResp getSolutionProdResp, List<OrderDto> orderList, String agrtCode, String prodCode, 
			SolutionEpolicyDto solutionEpolicyDto, List<EpolicyDynamicItemDto> epolicyDynamicItemList, 
			List<EpolicyDynamicListDto> epolicyDynamicListList) throws Exception {
		EpolicyRootDto epolicyRoot = new EpolicyRootDto();
        
		Integer uwCount = 0;
		String policyNo = "";
		String riskCode = "";
		String payNo = "";
		Date payDate = null;	// 支付日期
		BigDecimal payFee = DecimalUtil.toBigDecimal(0); // 支付金额
    	Date startDate = null;	// 起保日期
    	Map<Integer, Object> orderItemAcciMap = new HashMap<Integer, Object>();
		List<OrderCustomerDto> applyList = new ArrayList<OrderCustomerDto>();				// 投保人
		List<OrderItemAcciLstDto> insuredList = new ArrayList<OrderItemAcciLstDto>();		// 被保人
		List<OrderItemAcciBenDto> benefitList = new ArrayList<OrderItemAcciBenDto>();		// 受益人
    	OrderCargoDto cargoDto = new OrderCargoDto();										// 货运险标的详情
    	List<OrderCargoDtlDto> cargoDtlList = new ArrayList<OrderCargoDtlDto>(); 			// 货运险标的详情
    	OrderPropertyDto propertyDto = new OrderPropertyDto();								// 货运险标的详情
    	List<OrderDynamicItemDto> dynamicItemList = new ArrayList<OrderDynamicItemDto>();	// 动态标的
    	List<OrderRiskDynamicDto> riskDynamicList = new ArrayList<OrderRiskDynamicDto>();	// 意健险动态标的
    	List<OrderDynamicListDto> dynamicListList = new ArrayList<OrderDynamicListDto>();	// 动态标的清单
    	List<OrderItemkindDto> itemkindList = new ArrayList<OrderItemkindDto>();			// 险别信息
    	List<OrderLimitDto> limitList = new ArrayList<OrderLimitDto>();						// 限额信息
    	List<OrderDeductibleDto> deductibleList = new ArrayList<OrderDeductibleDto>();		// 条款信息
    	List<OrderClausesDto> clausesList = new ArrayList<OrderClausesDto>();				// 条款信息
    	List<OrderSpecialClausesDto> specialClausesList = new ArrayList<OrderSpecialClausesDto>(); // 特约信息
    	Set<String> occupationSet = new HashSet<String>();									//存储意健险职业信息
    	
		for (OrderDto orderDto : orderList) {
			List<OrderItemAcciDto> itemAcciList = orderDto.getItemAcciList();
			OrderMainDto orderMainDto = orderDto.getOrderMain();
			ShopOrderGoodsDto orderGoods = orderDto.getOrderGoods();
			OrderPayinfoDto payinfo = orderDto.getPayinfo();
			propertyDto = orderDto.getProperty();
    		cargoDto = orderDto.getCargo();
    		
			String associatedNo = orderMainDto.getAssociatedNo();
			if (StringUtil.isEmpty(associatedNo)) {
				policyNo = orderMainDto.getPolicyNo();
				riskCode = orderGoods.getGoodsId();
			} else {
				policyNo = associatedNo;
				riskCode = "9999";
			}
			uwCount = orderGoods.getGoodsNumber();
			startDate = orderMainDto.getStartDate();
    		payNo = payinfo.getPayNo();
    		payDate = payinfo.getPayDate();
    		payFee = payFee.add(payinfo.getPayAmount());
    		
			List<OrderCustomerDto> customerList = orderDto.getCustomerList();
			// 区分投保人和被保人数据
			if (CollectionUtil.isNotEmpty(itemAcciList)) {
				applyList.addAll(customerList);
				for (OrderItemAcciDto itemAcciDto : itemAcciList) {
					orderItemAcciMap.put(itemAcciDto.getItemNo(), itemAcciDto);
					
					insuredList.addAll(itemAcciDto.getAcciInsuredList());
					for (OrderItemAcciLstDto itemAcciLstDto : itemAcciDto.getAcciInsuredList()) {
						benefitList.addAll(itemAcciLstDto.getAcciBenefitList());
					}
					
					String occupationInfo = itemAcciDto.getOccupationLevel() + "_" + itemAcciDto.getOccupation();
					if (!occupationSet.contains(occupationInfo)) {
						occupationSet.add(occupationInfo);
					}
				}
			} else {
				for (OrderCustomerDto orderCustomerDto : customerList) {
					if ("1".equals(orderCustomerDto.getCustomerFlag())) {
						applyList.add(orderCustomerDto);
					} else if ("2".equals(orderCustomerDto.getCustomerFlag())) {
						OrderItemAcciLstDto phCustomer = new OrderItemAcciLstDto();
						ObjectUtil.copyProperties(phCustomer, orderCustomerDto);
						phCustomer.setAppliRelation(orderCustomerDto.getCustomerRelations());
						phCustomer.setAcciListId(BigInteger.valueOf(orderCustomerDto.getCustomerId()));
						insuredList.add(phCustomer);
					} else if ("4".equals(orderCustomerDto.getCustomerFlag())) {
						OrderItemAcciBenDto benCustomer = new OrderItemAcciBenDto();
						ObjectUtil.copyProperties(benCustomer, orderCustomerDto);
						benefitList.add(benCustomer);
					}
				}
			}
			
			if (CollectionUtil.isNotEmpty(orderDto.getItemkindList())) {
				for (OrderItemkindDto orderItemkindDto : orderDto.getItemkindList()) {
					BigDecimal unitInsured = new BigDecimal(0);
					BigDecimal amount = orderItemkindDto.getAmount();
					if (CollectionUtil.isNotEmpty(itemAcciList)) {
						for (OrderItemAcciDto orderItemAcciDto : itemAcciList) {
							if (orderItemkindDto.getItemNo().equals(orderItemAcciDto.getItemNo())) {
								Integer quantity = orderItemAcciDto.getQuantity();
								unitInsured = amount.divide(new BigDecimal(uwCount)).divide(new BigDecimal(quantity));
							}
						}
					} else {
						unitInsured = amount.divide(new BigDecimal(uwCount));
					}
					orderItemkindDto.setUnitInsured(unitInsured);//每人保额
					itemkindList.add(orderItemkindDto);
				}
			}
			dynamicItemList.addAll(orderDto.getDynamicItemList());
			riskDynamicList.addAll(orderDto.getRiskDynamicList());
			cargoDtlList.addAll(orderDto.getCargoDtlList());
			dynamicListList.addAll(orderDto.getDynamicListList());
    		limitList.addAll(orderDto.getLimitList());
    		deductibleList.addAll(orderDto.getDeductibleList());
    		clausesList.addAll(orderDto.getClausesList());
    		specialClausesList.addAll(orderDto.getSpecialClausesList());
		}
    	//封装基础信息
		epolicyRoot = this.getBasisInfo(orderList, epolicyRoot, policyNo, startDate, riskCode, agrtCode, prodCode,
				solutionEpolicyDto, getSolutionProdResp);
    	//封装投保人
		epolicyRoot = this.getApplyInfo(epolicyRoot, applyList, startDate);
    	//封装被保人
		epolicyRoot = this.getInsuredInfo(epolicyRoot, insuredList, startDate, orderItemAcciMap);
    	//封装受益人
		epolicyRoot = this.getBenefitInfo(epolicyRoot, benefitList, insuredList);
    	//标的信息
		epolicyRoot = this.getDynamicItemInfo(epolicyRoot, propertyDto, cargoDto, occupationSet);
    	//封装货运险标的详情
		epolicyRoot = this.getCargoDtlListInfo(epolicyRoot, cargoDtlList);
    	//封装险别信息
    	epolicyRoot = this.getItemkindInfo(epolicyRoot, itemkindList, limitList, uwCount);
    	//封装免赔信息
    	epolicyRoot = this.getDeductibleInfo(epolicyRoot, deductibleList);
    	//封装特别约定信息
    	epolicyRoot = this.getSpecialClausesInfo(epolicyRoot, specialClausesList);
    	//封装条款信息
    	epolicyRoot = this.getClausesInfo(epolicyRoot, clausesList);
    	//封装支付信息
    	epolicyRoot = this.getPaymentInfo(epolicyRoot, payNo, payDate, payFee);
    	
    	//获取产品险种信息
    	List<PdmsProdRiskInfoDto> pdmsProdRiskInfoList = new ArrayList<PdmsProdRiskInfoDto>(); //产品对应的动态标的信息
    	for (PdmsProdInfoDto pdmsProdInfoDto : getSolutionProdResp.getProductList()) {
    		pdmsProdRiskInfoList.addAll(pdmsProdInfoDto.getPdmsProdRiskInfoList());
    	}
    	//动态标的特殊封装
    	if (CollectionUtil.isNotEmpty(dynamicItemList)) {
    		String blockType = "10";
    		for (OrderDynamicItemDto orderDynamicItemDto : dynamicItemList) {
    			EpolicyDynamicItemDto dynamicItemDto = new EpolicyDynamicItemDto();
    			String dynamicItemRiskCode = orderDynamicItemDto.getRiskCode();
    			Map<String, String> dynamicItemMap = this.getDynamicInfo(pdmsProdRiskInfoList, dynamicItemRiskCode, blockType, orderDynamicItemDto);
    			dynamicItemDto.setDynamicItemMap(dynamicItemMap);
    			epolicyDynamicItemList.add(dynamicItemDto);
    		}
    	}
    	if (CollectionUtil.isNotEmpty(riskDynamicList)) {
    		String blockType = "09";
    		for (OrderRiskDynamicDto orderRiskDynamicDto : riskDynamicList) {
    			EpolicyDynamicItemDto riskDynamicDto = new EpolicyDynamicItemDto();
    			String dynamicListRiskCode = orderRiskDynamicDto.getRiskCode();
    			Map<String, String> riskDynamicMap = this.getDynamicInfo(pdmsProdRiskInfoList, dynamicListRiskCode, blockType, orderRiskDynamicDto);
    			riskDynamicDto.setDynamicItemMap(riskDynamicMap);
    			epolicyDynamicItemList.add(riskDynamicDto);
    		}
    	}
    	//动态标的清单特殊封装
    	if (CollectionUtil.isNotEmpty(dynamicListList)) {
    		String blockType = "11";
			for (OrderDynamicListDto orderDynamicListDto : dynamicListList) {
				EpolicyDynamicListDto epolicyDynamicListDto = new EpolicyDynamicListDto();
				String dynamicListRiskCode = orderDynamicListDto.getRiskCode();
				Map<String, String> dynamicListMap = this.getDynamicInfo(pdmsProdRiskInfoList, dynamicListRiskCode, blockType, orderDynamicListDto);
				epolicyDynamicListDto.setDynamicListMap(dynamicListMap);
				epolicyDynamicListList.add(epolicyDynamicListDto);
			}
    	}
    	
		return epolicyRoot;
	}
	
	/**
	 * 封装基础信息
	 * <p>User: glizhen
	 * <p>Date: 2018年6月25日
	 * <p>Version: 1.0
	 * @throws Exception 
	 */
	private EpolicyRootDto getBasisInfo(List<OrderDto> orderList, EpolicyRootDto epolicyRoot, String policyNo, 
			Date startDate, String riskCode, String agrtCode, String prodCode, SolutionEpolicyDto solutionEpolicyDto, 
			GetSolutionProdResp getSolutionProdResp) throws Exception {
		PdmsSolutionInfoDto pdmsSolutionInfoDto = getSolutionProdResp.getPdmsSolutionInfoDto();
        PdmsSolutionDto solutionMain = pdmsSolutionInfoDto.getSolutionMain();
        PdmsProdInfoDto prodInfoDto = getSolutionProdResp.getProductList().get(0);
		OrderMainDto orderMainDto = orderList.get(0).getOrderMain();
		Date inputDate = orderMainDto.getOrderDate();				//订单创建时间
		Date endDate = orderMainDto.getEndDate();					//终保日期
		String argueSolutionCode = orderMainDto.getArgueSolution();	//争议处理:1-诉讼 2-仲裁 3-协商
		String argueSolution = Constants.argueSolutionMap.get(argueSolutionCode);
		String judicalScope = solutionMain.getJudicalScope();		//司法管辖
		String agrtName = solutionMain.getAgrtName();				//销售方案名称
		String prodName = prodInfoDto.getProdName();				//产品名称
		epolicyRoot.setFileName("AE-" + policyNo + "-000");
		epolicyRoot.setInsuranceCode(solutionEpolicyDto.getEModelCode());//模板Id
		epolicyRoot.setIsTest(orderMainDto.getTestIssueFlag());		//是否测试单:Y-是，N-否
		epolicyRoot.setPolicyNo(policyNo);
		epolicyRoot.setRiskCode(riskCode);
		epolicyRoot.setPrintDate(TimeUtil.format(new Date(), TimeUtil.ISO_DATETIME_NO_SEC_FORMAT));
		epolicyRoot.setAcceptDate(TimeUtil.format(inputDate, TimeUtil.ISO_DATETIME_NO_SEC_FORMAT));
		String[] inputDateArr = TimeUtil.format(inputDate, TimeUtil.ISO_DATE_FORMAT).split("-");
		epolicyRoot.setIssueDate(inputDateArr[0] + "年" + inputDateArr[1] + "月" + inputDateArr[2] + "日");
		
		//起终保日期的封装
		String stDate = TimeUtil.format(startDate, TimeUtil.ISO_DATETIME_FORMAT);
    	String edDate = TimeUtil.format(endDate, TimeUtil.ISO_DATETIME_FORMAT);
    	String[] startDateArr =  TimeUtil.format(startDate, TimeUtil.ISO_DATE_FORMAT).split("-");
    	String[] endDateArr = TimeUtil.format(endDate, TimeUtil.ISO_DATE_FORMAT).split("-");
    	String startTime = stDate.substring(stDate.length()-8);
    	String endTime = edDate.substring(edDate.length()-8);
    	int period = EpolicyUtils.getDayInterval(startDate, endDate);
    	epolicyRoot.setStartYear(startDateArr[0]);
    	epolicyRoot.setStartMonth(startDateArr[1]);
    	epolicyRoot.setStartDay(startDateArr[2]);
    	epolicyRoot.setStartTime(startTime);
    	epolicyRoot.setEndYear(endDateArr[0]);
    	epolicyRoot.setEndMonth(endDateArr[1]);
    	epolicyRoot.setEndDay(endDateArr[2]);
    	epolicyRoot.setEndTime(endTime);
    	epolicyRoot.setPeriod(String.valueOf(period));
    	
    	epolicyRoot.setRetroActiveStartDate("--");					//追溯起期
    	epolicyRoot.setRetroActiveEndDate("--");					//追溯止期
    	epolicyRoot.setAgrtCode(agrtCode);
    	epolicyRoot.setAgrtName(agrtName);
    	epolicyRoot.setProdCode(prodCode);
    	epolicyRoot.setProdName(prodName);
    	epolicyRoot.setChannel(orderMainDto.getDataSource());		//渠道来源
    	epolicyRoot.setCompanyCode(orderMainDto.getIssueCompany());	//业务归属
    	epolicyRoot.setGeographicalArea("中华人民共和国境内（港澳台除外）");
    	epolicyRoot.setJudicalScope(StringUtil.isNotEmpty(judicalScope) ? judicalScope : "中华人民共和国管辖(港澳台除外)");
    	epolicyRoot.setArgueSolution(argueSolution);
    	epolicyRoot.setAppInstructions(solutionEpolicyDto.getPolicyDeclare());
    	epolicyRoot.setInform(solutionEpolicyDto.getHealthInform());
		return epolicyRoot;
	}
	
	/**
	 * 封装投保人信息
	 * <p>User: glizhen
	 * <p>Date: 2018年6月25日
	 * <p>Version: 1.0
	 * @throws Exception 
	 */
	private EpolicyRootDto getApplyInfo(EpolicyRootDto epolicyRoot, List<OrderCustomerDto> applyList, Date startDate) 
			throws Exception {
    	EpolicyApplyRoot applyRoot = new EpolicyApplyRoot();
    	List<EpolicyApplyDto> applyRownum = new ArrayList<EpolicyApplyDto>();
    	Set<String> applySet = new HashSet<String>();
    	if (CollectionUtil.isNotEmpty(applyList)) {
	    	for (OrderCustomerDto orderCustomerDto : applyList) {
	    		String applyInfo = orderCustomerDto.getCustomerName() + orderCustomerDto.getDocType() + orderCustomerDto.getDocNo();
	    		if (!applySet.contains(applyInfo)) {
	    			applySet.add(applyInfo);
	    			EpolicyApplyDto applyDto = new EpolicyApplyDto();
	    			applyDto.setAppliName(orderCustomerDto.getCustomerName());
	    			applyDto.setAppliSex(Constants.sexMap.get(orderCustomerDto.getSex()));
	    			if (orderCustomerDto.getBirthDate() != null) {
	    				applyDto.setAppliBirthdate(TimeUtil.format(orderCustomerDto.getBirthDate(), TimeUtil.ISO_DATE_FORMAT));
	    				int age = TimeUtil.getActualAge(orderCustomerDto.getBirthDate(), new Date());
	    				applyDto.setAppliAge(Integer.toString(age));
	    			}
	    			applyDto.setCustomerType(orderCustomerDto.getCustomerType());
	    			applyDto.setAppliIdentifyType(orderCustomerDto.getDocType());
	    			applyDto.setAppliIdentifyNumber(orderCustomerDto.getDocNo());
	    			applyDto.setAppliAddress(orderCustomerDto.getCustomerAddress());
	    			applyDto.setAppliMobilephone(orderCustomerDto.getPhoneNo());
	    			applyDto.setAppliEmail(orderCustomerDto.getEmail());
	    			applyDto.setAppliIndustryType("");
	    			applyRownum.add(applyDto);
	    		}
	    	}
	    	applyRoot.setApplyRownum(applyRownum);
	    	epolicyRoot.setApplyInfor(applyRoot);
    	}
    	return epolicyRoot;
	}
	
	/**
	 * 封装被保人信息
	 * <p>User: glizhen
	 * <p>Date: 2018年6月25日
	 * <p>Version: 1.0
	 * @throws Exception 
	 */
	private EpolicyRootDto getInsuredInfo(EpolicyRootDto epolicyRoot, List<OrderItemAcciLstDto> insuredList, Date startDate, 
			Map<Integer, Object> orderItemAcciMap) throws Exception {
    	EpolicyInsuredRoot insuredRoot = new EpolicyInsuredRoot();
    	List<EpolicyInsuredDto> insuredRownum = new ArrayList<EpolicyInsuredDto>();
    	Set<String> insuredSet = new HashSet<String>();
    	if (CollectionUtil.isNotEmpty(insuredList)) {
	    	int insuredSerialNo = 0;
	    	for (OrderItemAcciLstDto itemAcciLstDto : insuredList) {
	    		String insuredInfo = itemAcciLstDto.getCustomerName() + itemAcciLstDto.getDocType() + itemAcciLstDto.getDocNo();
	    		if (!insuredSet.contains(insuredInfo)) {
	    			insuredSet.add(insuredInfo);
		    		EpolicyInsuredDto insuredDto = new EpolicyInsuredDto();
		    		insuredDto.setSerialNo(Integer.toString(++ insuredSerialNo));
		    		insuredDto.setClientNo(itemAcciLstDto.getAcciListId().toString());
		    		insuredDto.setInsuredName(itemAcciLstDto.getCustomerName());
		    		insuredDto.setInsuredSex(Constants.sexMap.get(itemAcciLstDto.getSex()));
		    		if (itemAcciLstDto.getBirthDate() != null) {
		    			insuredDto.setInsuredBirthdate(TimeUtil.format(itemAcciLstDto.getBirthDate(), TimeUtil.ISO_DATE_FORMAT));
		    			int age = TimeUtil.getActualAge(itemAcciLstDto.getBirthDate(), startDate);
		    			insuredDto.setInsuredAge(Integer.toString(age));
		    		}
		    		insuredDto.setCustomerType(itemAcciLstDto.getCustomerType());
		    		insuredDto.setInsuredIdentifyType(itemAcciLstDto.getDocType());
		    		insuredDto.setInsuredIdentifyNumber(itemAcciLstDto.getDocNo());
		    		insuredDto.setInsuredMobilephone(itemAcciLstDto.getPhoneNo());
		    		insuredDto.setInsuredAddress("--");
		    		insuredDto.setInsuredPostcode("--");
		    		if (!orderItemAcciMap.isEmpty()) {
		    			OrderItemAcciDto itemAcciDto = (OrderItemAcciDto) orderItemAcciMap.get(itemAcciLstDto.getItemNo());
		    			if (itemAcciDto != null) {
		    				insuredDto.setOccupationType(itemAcciDto.getOccupationLevel());
		    				insuredDto.setOccupation(itemAcciDto.getOccupation());
		    			}
		    		}
		    		insuredDto.setEmail(itemAcciLstDto.getEmail());
		    		insuredDto.setInsuredAppRelation(itemAcciLstDto.getAppliRelation());
		    		insuredRownum.add(insuredDto);
	    		}
	    	}
	    	insuredRoot.setInsuredRownum(insuredRownum);
	    	epolicyRoot.setInsuredCount(Integer.toString(insuredRoot.getInsuredRownum().size()));
	    	epolicyRoot.setInsured(insuredRoot);
    	}
    	return epolicyRoot;
	}
	
	/**
	 * 封装受益人信息
	 * <p>User: glizhen
	 * <p>Date: 2018年6月25日
	 * <p>Version: 1.0
	 * @throws Exception 
	 */
	private EpolicyRootDto getBenefitInfo(EpolicyRootDto epolicyRoot, List<OrderItemAcciBenDto> benefitList, 
			List<OrderItemAcciLstDto> insuredList) throws Exception {
		EpolicyBenefitRoot benefitRoot = new EpolicyBenefitRoot();
		List<EpolicyBenefitDto> benefitRownum = new ArrayList<EpolicyBenefitDto>();
    	if (CollectionUtil.isNotEmpty(benefitList)) {
    		int benefitSerialNo = 0;
    		for (OrderItemAcciBenDto itemAcciBenDto : benefitList) {
				EpolicyBenefitDto benefitDto = new EpolicyBenefitDto();
				benefitDto.setSerialNo(Integer.toString(++ benefitSerialNo));
				if (CollectionUtil.isNotEmpty(insuredList)) {
					for (OrderItemAcciLstDto itemAcciLstDto : insuredList) {
    					if (itemAcciBenDto.getAcciListId() == null || 
    							itemAcciBenDto.getAcciListId().equals(itemAcciLstDto.getAcciListId())) {
    						benefitDto.setClientNo(itemAcciLstDto.getAcciListId().toString());
    						benefitDto.setInsuredName(itemAcciLstDto.getCustomerName());
    						benefitDto.setInsuredCustomerType(itemAcciLstDto.getCustomerType());
    						benefitDto.setInsuredIdentifyType(itemAcciLstDto.getDocType());
    						benefitDto.setInsuredIdentifyNumber(itemAcciLstDto.getDocNo());
    					}
    				}
				}
				benefitDto.setBenefitName(itemAcciBenDto.getCustomerName());
				benefitDto.setBenefitCustomerType(itemAcciBenDto.getCustomerType());
				benefitDto.setBenefitIdentifyType(itemAcciBenDto.getDocType());
				benefitDto.setBenefitIdentifyNo(itemAcciBenDto.getDocNo());
				benefitDto.setBeneInsuRelation(itemAcciBenDto.getInsuredRelation());
				benefitDto.setBenefitFlag(itemAcciBenDto.getBenifitFlag());
				String benifitPercent = itemAcciBenDto.getBenifitPercent() != null ? 
						String.valueOf(itemAcciBenDto.getBenifitPercent()) : null;
				benefitDto.setBenefitPercent(benifitPercent);
				benefitDto.setRemark(itemAcciBenDto.getRemark());
				benefitRownum.add(benefitDto);
    		}
    		benefitRoot.setBenefitRownum(benefitRownum);
    		epolicyRoot.setBenefit(benefitRoot);
    	}
    	return epolicyRoot;
	}
    	
	/**
	 * 封装动态标的信息
	 * <p>User: glizhen
	 * <p>Date: 2018年6月25日
	 * <p>Version: 1.0
	 * @throws Exception 
	 */
	private EpolicyRootDto getDynamicItemInfo(EpolicyRootDto epolicyRoot, OrderPropertyDto propertyDto,
			OrderCargoDto cargoDto, Set<String> occupationSet) throws Exception {
		EpolicyDynamicItemRoot dynamicItemRoot = new EpolicyDynamicItemRoot();
    	List<EpolicyDynamicItemDto> dynamicItemRownum = new ArrayList<EpolicyDynamicItemDto>();
    	//标的信息
    	EpolicyDynamicItemDto epolicyDynamicItemDto = new EpolicyDynamicItemDto();
    	if (propertyDto != null) {
    		String situation = propertyDto.getItemProvinceCname() + propertyDto.getItemCityCname() + 
    				propertyDto.getItemDistrictCname() + propertyDto.getSituation();
			epolicyDynamicItemDto.setSituation(situation);
		}
		if (cargoDto != null) {
			epolicyDynamicItemDto.setBlno(cargoDto.getBlno());
			epolicyDynamicItemDto.setConveyanceName(cargoDto.getConveyanceName());
			epolicyDynamicItemDto.setConveyanceType(cargoDto.getConveyanceType());
			epolicyDynamicItemDto.setStartDate(cargoDto.getStartDate() != null ? 
					TimeUtil.format(cargoDto.getStartDate(), TimeUtil.ISO_DATETIME_FORMAT) : null);
			epolicyDynamicItemDto.setStartsiteName(cargoDto.getStartSiteCode());
			epolicyDynamicItemDto.setViasiteName(cargoDto.getViaSiteCode());
			epolicyDynamicItemDto.setTargetsiteName(cargoDto.getTargetSiteCode());
		}
    	if (CollectionUtil.isNotEmpty(occupationSet)) {
    		for (String occupationInfo : occupationSet) {
    			EpolicyDynamicItemDto dynamicItemDto = new EpolicyDynamicItemDto();
    			String[] occupation = occupationInfo.split("_");
    			ObjectUtil.copyProperties(dynamicItemDto, epolicyDynamicItemDto);
    			dynamicItemDto.setOccupationLevel(occupation[0]);
    			dynamicItemDto.setOccupation(occupation[1]);
    			dynamicItemRownum.add(dynamicItemDto);
    		}
    	} else {
    		dynamicItemRownum.add(epolicyDynamicItemDto);
    	}
    	dynamicItemRownum = CollectionUtil.distinctElements(dynamicItemRownum);
    	dynamicItemRoot.setDynamicItemRownum(dynamicItemRownum);
    	epolicyRoot.setDynamicItem(dynamicItemRoot);
    	return epolicyRoot;
	}
	
	/**
	 * 对应产品工厂标的含义
	 * <p>User: glizhen
	 * <p>Date: 2018年6月25日
	 * <p>Version: 1.0
	 * @throws Exception 
	 */
	private Map<String, String> getDynamicInfo(List<PdmsProdRiskInfoDto> pdmsProdRiskInfoList, String riskCode, String blockType, 
			Object object) throws Exception {
		Map<String, String> dynamicMap = new HashMap<String, String>();
		Map<String, Object> fieldMap = EpolicyUtils.getFields(object);
		if (CollectionUtil.isNotEmpty(pdmsProdRiskInfoList)) {
			for (PdmsProdRiskInfoDto pdmsProdRiskInfoDto : pdmsProdRiskInfoList) {
				if (riskCode.equals(pdmsProdRiskInfoDto.getRiskCode()) && pdmsProdRiskInfoDto.getTplDefDto() != null) {
					List<BlockDefDto> blockDefList = pdmsProdRiskInfoDto.getTplDefDto().getBlockDefList();
					if (CollectionUtil.isNotEmpty(blockDefList)) {
						for (BlockDefDto blockDefDto : blockDefList) {
							if (ToolUtils.contains(blockDefDto.getBlockType(), blockType)) {
								for (FieldDefDto fieldDefDto : blockDefDto.getFieldList()) {
									String fieldCode = fieldDefDto.getFieldCode().toUpperCase();
									if (fieldMap.containsKey(fieldCode)) {
										dynamicMap.put(fieldDefDto.getField(), (String) fieldMap.get(fieldCode));
									}
								}
							}
						}
					}
				}
			}
		}
		return dynamicMap;
	}
	
	/**
	 * 封装货运险标的详情
	 * <p>User: glizhen
	 * <p>Date: 2018年6月25日
	 * <p>Version: 1.0
	 * @throws Exception 
	 */
	private EpolicyRootDto getCargoDtlListInfo(EpolicyRootDto epolicyRoot, List<OrderCargoDtlDto> cargoDtlList) 
			throws Exception {
    	EpolicyItemCargoRoot itemCargoRoot = new EpolicyItemCargoRoot();
    	List<EpolicyItemCargoDto> itemCargoRownum = new ArrayList<EpolicyItemCargoDto>();
    	if (CollectionUtil.isNotEmpty(cargoDtlList)) {
    		int cargoDtlSerialNo = 0;
    		for (OrderCargoDtlDto cargoDtlDto : cargoDtlList) {
				EpolicyItemCargoDto epolicyItemCargoDto = new EpolicyItemCargoDto();
				epolicyItemCargoDto.setSerialNo(Integer.toString(++ cargoDtlSerialNo));
				epolicyItemCargoDto.setItemDetailName(cargoDtlDto.getItemDetailName());
				epolicyItemCargoDto.setItemDetailList(cargoDtlDto.getItemDetailList());
				epolicyItemCargoDto.setPacking(cargoDtlDto.getPacking());
				epolicyItemCargoDto.setQuantity(String.valueOf(cargoDtlDto.getQuantity()));
				epolicyItemCargoDto.setSumInsured(String.valueOf(cargoDtlDto.getSumInsured()));
				itemCargoRownum.add(epolicyItemCargoDto);
    		}
    		itemCargoRownum = CollectionUtil.distinctElements(itemCargoRownum);
    		itemCargoRoot.setItemCargoRownum(itemCargoRownum);
    		epolicyRoot.setItemCargoDtl(itemCargoRoot);
    	}
    	return epolicyRoot;
	}
	
	/**
	 * 封装险别列表,保额保费等信息
	 * <p>User: glizhen
	 * <p>Date: 2018年6月25日
	 * <p>Version: 1.0
	 * @throws Exception 
	 */
	private EpolicyRootDto getItemkindInfo(EpolicyRootDto epolicyRoot, List<OrderItemkindDto> itemkindList, 
			List<OrderLimitDto> limitList, Integer uwCount) throws Exception {
		EpolicyAllKindRoot allKindRoot = new EpolicyAllKindRoot();
    	EpolicyMainKindRoot mainKindRoot = new EpolicyMainKindRoot();
    	EpolicyMinorKindRoot minorKindRoot = new EpolicyMinorKindRoot();
    	List<EpolicyItemkindDto> allKindRownum = new ArrayList<EpolicyItemkindDto>();
    	List<EpolicyItemkindDto> mainKindRownum = new ArrayList<EpolicyItemkindDto>();
    	List<EpolicyItemkindDto> minorKindRownum = new ArrayList<EpolicyItemkindDto>();
    	Set<String> itemkindSet = new HashSet<String>();
    	BigDecimal totalPremium = DecimalUtil.toBigDecimal(0);
    	BigDecimal totalAmount = DecimalUtil.toBigDecimal(0);
    	if (CollectionUtil.isNotEmpty(itemkindList)) {
    		for (OrderItemkindDto itemkindDto : itemkindList) {
    			String itemkindInfo = itemkindDto.getKindCode() + itemkindDto.getItemNo();
    			if (!itemkindSet.contains(itemkindInfo)) {
    				itemkindSet.add(itemkindInfo);
    				EpolicyItemkindDto epolicyItemkindDto = new EpolicyItemkindDto();
    				BigDecimal premium = itemkindDto.getPremium();
    				BigDecimal amount = itemkindDto.getAmount();
    				epolicyItemkindDto.setKindName(itemkindDto.getKindName());
    				epolicyItemkindDto.setGrossPremium(String.valueOf(premium));
    				totalPremium = totalPremium.add(premium);
    				epolicyItemkindDto.setSumInsured(String.valueOf(amount));
    				totalAmount = totalAmount.add(amount);
    				epolicyItemkindDto.setUnitInsured(String.valueOf(itemkindDto.getUnitInsured()));
    				Set<String> orderLimitSet = new HashSet<String>();
    				if (CollectionUtil.isNotEmpty(limitList)) {
    					for (OrderLimitDto orderLimitDto : limitList) {
    						String limitInfo = orderLimitDto.getLimitCode() + orderLimitDto.getItemNo();
    						if (!orderLimitSet.contains(limitInfo)) {
    							orderLimitSet.add(limitInfo);
    							if (itemkindDto.getKindCode().equals(orderLimitDto.getKindCode())
    									&& itemkindDto.getItemNo().equals(orderLimitDto.getItemNo())) {
    								EpolicyItemkindDto itemkindLimitDto = new EpolicyItemkindDto();
    								ObjectUtil.copyProperties(itemkindLimitDto, epolicyItemkindDto);
    								itemkindLimitDto.setKindType(orderLimitDto.getLimitName());
    								itemkindLimitDto.setLimit(String.valueOf(orderLimitDto.getLimitValue()));
    								itemkindLimitDto.setLimitDesc(orderLimitDto.getLimitDesc());
    								itemkindLimitDto.setLimitCode(orderLimitDto.getLimitCode());
    								itemkindLimitDto.setLimitType(orderLimitDto.getLimitType());
    								itemkindLimitDto.setLimitClass(orderLimitDto.getLimitClass());
    								itemkindLimitDto.setRemark(orderLimitDto.getRemark());
    								itemkindLimitDto.setUnitLimit(String.valueOf(orderLimitDto.getUnitLimit()));
    								if ("1".equals(itemkindDto.getKindInd())) {
    									mainKindRownum.add(itemkindLimitDto);
    								} else {
    									minorKindRownum.add(itemkindLimitDto);
    								}
    								allKindRownum.add(itemkindLimitDto);
    							}
    						}
    					}
    				} else {
    					if ("1".equals(itemkindDto.getKindInd())) {
							mainKindRownum.add(epolicyItemkindDto);
						} else {
							minorKindRownum.add(epolicyItemkindDto);
						}
						allKindRownum.add(epolicyItemkindDto);
    				}
    			}
    		}
    		allKindRoot.setAllKindRownum(allKindRownum);
    		mainKindRoot.setMainKindRownum(mainKindRownum);
    		minorKindRoot.setMinorKindRownum(minorKindRownum);
    		epolicyRoot.setAllKind(allKindRoot);
    		epolicyRoot.setMainKind(mainKindRoot);
    		epolicyRoot.setMinorKind(minorKindRoot);
    	}
    	
    	//封装份数信息
    	EpolicyAvgpremRoot avgpremRoot = new EpolicyAvgpremRoot();
    	List<EpolicyAvgpremDto> avgpremRownum = new ArrayList<EpolicyAvgpremDto>();
    	EpolicyAvgpremDto avgpremDto = new EpolicyAvgpremDto();
    	avgpremDto.setUwCount(Integer.toString(uwCount));
    	avgpremDto.setAvgPremium(String.valueOf(totalPremium.divide(DecimalUtil.toBigDecimal(uwCount))));
    	avgpremDto.setAvsumInsured(String.valueOf(totalAmount.divide(DecimalUtil.toBigDecimal(uwCount))));
    	avgpremRownum.add(avgpremDto);
    	avgpremRoot.setAvgpremRownum(avgpremRownum);
    	epolicyRoot.setAvgprem(avgpremRoot);
    	
    	//封装总保额保费信息
    	epolicyRoot.setCurrency("CNY");
    	epolicyRoot.setUppsumInsured("人民币" + EpolicyUtils.numberCNMontrayUnit(totalAmount));
    	epolicyRoot.setSumInsured(String.valueOf(totalAmount));
    	epolicyRoot.setUppSumGrossPremium("人民币" + EpolicyUtils.numberCNMontrayUnit(totalPremium));
    	epolicyRoot.setSumGrossPremium(String.valueOf(totalPremium));
		return epolicyRoot;
	}
	
	/**
	 * 封装免赔信息
	 * <p>User: glizhen
	 * <p>Date: 2018年6月25日
	 * <p>Version: 1.0
	 * @throws Exception 
	 */
	private EpolicyRootDto getDeductibleInfo(EpolicyRootDto epolicyRoot, List<OrderDeductibleDto> deductibleList) throws Exception {
    	StringBuffer deductibleContext = new StringBuffer();
    	Set<String> deductibleSet = new HashSet<String>();
    	if (CollectionUtil.isNotEmpty(deductibleList)) {
	    	for (OrderDeductibleDto deductibleDto : deductibleList) {
	    		String deductibleInfo = deductibleDto.getRemark();
	    		if (!deductibleSet.contains(deductibleInfo)) {
	    			deductibleSet.add(deductibleInfo);
	    			deductibleContext.append(deductibleInfo + "\n");
	    		}
	    	}
	    	epolicyRoot.setDeductible(deductibleContext.toString());
    	}
		return epolicyRoot;
	}
	
	/**
	 * 封装特别约定信息
	 * <p>User: glizhen
	 * <p>Date: 2018年6月25日
	 * <p>Version: 1.0
	 * @throws Exception 
	 */
	private EpolicyRootDto getSpecialClausesInfo(EpolicyRootDto epolicyRoot,
			List<OrderSpecialClausesDto> specialClausesList) throws Exception {
		StringBuffer specialClausesContext = new StringBuffer();
		Set<String> specialClausesSet = new HashSet<String>();
    	if (CollectionUtil.isNotEmpty(specialClausesList)) {
    		for (OrderSpecialClausesDto specialClausesDto : specialClausesList) {
    			String specialClausesInfo = specialClausesDto.getClausecontext();
    			if (!specialClausesSet.contains(specialClausesInfo)) {
    				specialClausesSet.add(specialClausesInfo);
    				specialClausesContext.append(specialClausesInfo + "\n");
    			}
    		}
    		epolicyRoot.setClauseconText(specialClausesContext.toString());
    	}
		return epolicyRoot;
	}
	
	/**
	 * 封装条款信息
	 * <p>User: glizhen
	 * <p>Date: 2018年6月25日
	 * <p>Version: 1.0
	 * @throws Exception 
	 */
	private EpolicyRootDto getClausesInfo(EpolicyRootDto epolicyRoot, List<OrderClausesDto> clausesList) throws Exception {
		EpolicyClausesRoot clausesRoot = new EpolicyClausesRoot();
    	List<EpolicyClauseDto> clausesRownum = new ArrayList<EpolicyClauseDto>();
    	StringBuffer clausesName = new StringBuffer();
    	Set<String> clausesSet = new HashSet<String>();
    	if (CollectionUtil.isNotEmpty(clausesList)) {
	    	for (OrderClausesDto orderClausesDto : clausesList) {
	    		String clausesInfo = orderClausesDto.getClauseCode() + orderClausesDto.getClauseLongName();
	    		if (!clausesSet.contains(clausesInfo)) {
	    			clausesSet.add(clausesInfo);
		    		EpolicyClauseDto clausesDto = new EpolicyClauseDto();
					clausesDto.setClauseID(orderClausesDto.getClauseCode());
		    		clausesName.append("《易安财产保险股份有限公司");
		    		clausesName.append(orderClausesDto.getClauseLongName());
		    		clausesName.append("》\n");
		    		clausesRownum.add(clausesDto);
	    		}
	    	}
	    	clausesRoot.setClauseRownum(clausesRownum);
	    	epolicyRoot.setClauses(clausesName.toString());
	    	epolicyRoot.setClausesList(clausesRoot);
    	}
		return epolicyRoot;
	}
	
	/**
	 * 封装支付信息
	 * <p>User: glizhen
	 * <p>Date: 2018年6月25日
	 * <p>Version: 1.0
	 * @throws Exception 
	 */
	private EpolicyRootDto getPaymentInfo(EpolicyRootDto epolicyRoot, String payNo, Date payDate, 
			BigDecimal payFee) throws Exception {
		EpolicyPaymentRoot paymentRoot = new EpolicyPaymentRoot();
    	List<EpolicyPaymentDto> paymentRownum = new ArrayList<EpolicyPaymentDto>();
    	EpolicyPaymentDto paymentDto = new EpolicyPaymentDto();
    	paymentDto.setPayNo(payNo);
    	paymentDto.setPayDate(payDate != null ? TimeUtil.format(payDate, TimeUtil.ISO_DATETIME_FORMAT) : null);
    	paymentDto.setPayFee(String.valueOf(payFee));
    	paymentRownum.add(paymentDto);
    	paymentRoot.setPaymentRownum(paymentRownum);
    	epolicyRoot.setPayment(paymentRoot);
		return epolicyRoot;
	}
	
	/**
	 * 往已封装过的EpolicyRootDto中插入标的信息
	 * User: glizhen
	 * Date: 2018年6月25日
	 * Version: 1.0
	 * 
	 * @throws Exception
	 */
	public String insertDynamicInfo(EpolicyRootDto epolicyRoot, List<EpolicyDynamicItemDto> epolicyDynamicItemList,
			List<EpolicyDynamicListDto> epolicyDynamicListList) throws Exception {
		if (CollectionUtil.isNotEmpty(epolicyDynamicItemList)) {	//动态标的信息不为空时
			epolicyDynamicItemList = CollectionUtil.distinctElements(epolicyDynamicItemList);
			Map<String, String> epolicyDynamicItemMap = new HashMap<String, String>();
			for (EpolicyDynamicItemDto dynamicItemDto : epolicyDynamicItemList) {
				Map<String, String> dynamicItemMap = dynamicItemDto.getDynamicItemMap();
				epolicyDynamicItemMap.putAll(dynamicItemMap);
			}
			EpolicyDynamicItemRoot epolicyDynamicItemRoot = epolicyRoot.getDynamicItem();
			if (epolicyDynamicItemRoot != null) {
				List<EpolicyDynamicItemDto> epolicyDynamicItemDtoList = epolicyDynamicItemRoot.getDynamicItemRownum();
				if (CollectionUtil.isNotEmpty(epolicyDynamicItemDtoList)) {
					for (EpolicyDynamicItemDto epolicyDynamicItemDto : epolicyDynamicItemDtoList) {
						epolicyDynamicItemDto.setDynamicItemMap(epolicyDynamicItemMap);
					}
				} else {
					List<EpolicyDynamicItemDto> dynamicItemRownum = new ArrayList<EpolicyDynamicItemDto>();
					EpolicyDynamicItemDto epolicyDynamicItemDto = new EpolicyDynamicItemDto();
					epolicyDynamicItemDto.setDynamicItemMap(epolicyDynamicItemMap);
					dynamicItemRownum.add(epolicyDynamicItemDto);
					epolicyDynamicItemRoot.setDynamicItemRownum(dynamicItemRownum);
				}
			} else {
				List<EpolicyDynamicItemDto> dynamicItemRownum = new ArrayList<EpolicyDynamicItemDto>();
				EpolicyDynamicItemDto epolicyDynamicItemDto = new EpolicyDynamicItemDto();
				epolicyDynamicItemDto.setDynamicItemMap(epolicyDynamicItemMap);
				dynamicItemRownum.add(epolicyDynamicItemDto);
				EpolicyDynamicItemRoot dynamicItemRoot = new EpolicyDynamicItemRoot();
				dynamicItemRoot.setDynamicItemRownum(dynamicItemRownum);
				epolicyRoot.setDynamicItem(dynamicItemRoot);
			}
		}
		
		if (CollectionUtil.isNotEmpty(epolicyDynamicListList)) {	//动态标的清单信息不为空时
			epolicyDynamicListList = CollectionUtil.distinctElements(epolicyDynamicListList);
			EpolicyDynamicListRoot dynamicListRoot = new EpolicyDynamicListRoot();
			List<EpolicyDynamicListDto> dynamicListRownum = new ArrayList<EpolicyDynamicListDto>();
			int dynamicListSerialNo = 0;
			for (EpolicyDynamicListDto dynamicListDto : epolicyDynamicListList) {
				Map<String, String> dynamicListMap = dynamicListDto.getDynamicListMap();
				EpolicyDynamicListRoot epolicyDynamicListRoot = epolicyRoot.getItemList();
				if (epolicyDynamicListRoot == null) {
					EpolicyDynamicListDto epolicyDynamicListDto = new EpolicyDynamicListDto();
					epolicyDynamicListDto.setSerialNo(Integer.toString(++ dynamicListSerialNo));
					epolicyDynamicListDto.setDynamicListMap(dynamicListMap);
					dynamicListRownum.add(epolicyDynamicListDto);
				}
			}
			dynamicListRoot.setDynamicListRownum(dynamicListRownum);
			epolicyRoot.setItemList(dynamicListRoot);
		}
		//自定义json转xml的方法
		String epolicyXml = ToolUtils.toXML(epolicyRoot, new EpolicyDynamicConverter());
		
		return epolicyXml;
	}

	
    /**
     * 发送承保邮件
     * @param orderDto
     * @param policyNo
     * @throws Exception 
     */
    private void sendPrpallMail(GetSolutionProdResp getSolutionProdResp, EpolicyRootDto epolicyRoot, String productName) throws Exception {
    	String policyNo = epolicyRoot.getPolicyNo();
    	String agrtCode = epolicyRoot.getAgrtCode();
    	List<PdmsSolutionMessageDto> pdmsSolutionMessageList = getSolutionProdResp.getPdmsSolutionInfoDto().getSolutionMessageList();
		if (CollectionUtil.isNotEmpty(pdmsSolutionMessageList)) {
			for (PdmsSolutionMessageDto pdmsSolutionMessageDto : pdmsSolutionMessageList) {
				if ("2".equals(pdmsSolutionMessageDto.getMsgKind()) && "1".equals(pdmsSolutionMessageDto.getBusinessType())) {
					String riskCode = epolicyRoot.getRiskCode();
					String msgTmplId = pdmsSolutionMessageDto.getMsgTmplId();
					List<EpolicyApplyDto> applyList = epolicyRoot.getApplyInfor().getApplyRownum();//投保人信息
					List<EpolicyInsuredDto> insuredList = epolicyRoot.getInsured().getInsuredRownum();//被保人信息
					
					String mailTo = "";
					Set<String> mailToSet = new HashSet<String>();
					if ("01".equals(pdmsSolutionMessageDto.getTargetType())) {
						for (EpolicyApplyDto epolicyApplyDto : applyList) {
							mailToSet.add(epolicyApplyDto.getAppliEmail());
						}
					} else if ("11".equals(pdmsSolutionMessageDto.getTargetType())) {
						for (EpolicyInsuredDto epolicyInsuredDto : insuredList) {
							mailToSet.add(epolicyInsuredDto.getEmail());
						}
					}
					mailTo = StringUtils.join(mailToSet, ",");
					if (StringUtil.isNotEmpty(mailTo)) {
						this.commonSendMail(policyNo, riskCode, productName, mailTo, msgTmplId);
					} else {
						synEpolicyLogger.info("保单号为:{}，发送邮件失败,原因:收件人邮箱为空", policyNo);
					}
				}
			}
		} else {
			synEpolicyLogger.error("保单号为:{}发送邮件失败,原因该销售方案:{}未配置消息通知配置信息,销售信息返回值为:{}", policyNo, agrtCode, JSON.toJSONString(pdmsSolutionMessageList));
		}
	}
    
    /**
     * 调邮件服务器发送邮件
     * @param policyNo
     * @param riskCode
     * @param riskName
     * @param mailTo
     */
    private void commonSendMail(final String policyNo, final String riskCode, final String riskName, final String mailTo, final String msgTmpId) {
        try {
            new Thread() {
                public void run() {
                    try {
                        MailRequestDto mailRequestDto = new MailRequestDto();
                        mailRequestDto.setModuleId("01");
                        mailRequestDto.setBusinessType("001");
                        mailRequestDto.setIsTime("0");
                        mailRequestDto.setTemplateId(msgTmpId);
                        Map<String, String> modelMap = new HashMap<String, String>();
                        modelMap.put("riskName", riskName);
                        modelMap.put("policyNo", policyNo);
                        mailRequestDto.setTemplateModel(JSON.toJSONString(modelMap));
                        mailRequestDto.setEmailTo(mailTo);
                        mailRequestDto.setSubject("易安保险" + riskName + "电子保单");
                        mailRequestDto.setBusinessNo(policyNo);
                        mailRequestDto.setBusinessNo2(riskCode);
                        mailRequestDto.setFieldAa("0");
                        mailRequestDto.setFieldAb("易安保险" + riskName + "电子保单.pdf");

						final String jsonData = JSON.toJSONString(mailRequestDto);

						final Map<String, String> headers = new HashMap<>(2);
						headers.put("Content-type", "application/json");
						headers.put("Accept", "application/json");

						final HttpResponseWrapper httpResponseWrapper = HttpTransceiver.doPostRaw(headers, ConfigUtil.getValue("remote.mls.url"), jsonData, false, false);
						int statusCode = httpResponseWrapper.getStatusCode();
						if (httpResponseWrapper.getStatus()) {
							MailResponseDto mailResponseDto = JSON.parseObject((String)httpResponseWrapper.getContent(), MailResponseDto.class);
							if (!SUCCESS_CODE.equals(mailResponseDto.getCode())) {
								synEpolicyLogger.error("调邮件服务器发送邮件失败,保单号:{},原因:{},错误码：{}", policyNo, mailResponseDto.getMessage(),mailResponseDto.getStatusCode());
							}
						} else {
							synEpolicyLogger.error("保单号为:{},发送邮件失败,原因:{},响应状态为:{}", policyNo, httpResponseWrapper.getErrorMessage(),statusCode);
						}
					} catch (Exception e) {
						synEpolicyLogger.error("保单号为:{},线程中发送邮件失败,原因:{}", policyNo, e.getMessage(),e);
					}
				}
            }.start();
        } catch (Exception e) {
        	synEpolicyLogger.error("保单号为:{},新增线程发送邮件失败,原因:{}", policyNo, e.getMessage(),e);
        }
    }
}