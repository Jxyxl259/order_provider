/*
 * Created By lujicong (2017-04-06 17:12:00)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.order.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.yaic.app.common.util.JsonUtil;
import com.yaic.app.order.dto.domain.OrderMainDto;
import com.yaic.app.order.dto.domain.ShopOrderInfoDto;
import com.yaic.app.order.service.OrderMainService;
import com.yaic.app.order.service.OrderService;
import com.yaic.app.order.service.ShopOrderInfoService;
import com.yaic.fa.dto.JqGridPageDto;
import com.yaic.fa.dto.PageDto;
import com.yaic.fa.mybatis.mapper.entity.Condition;
import com.yaic.fa.mybatis.mapper.entity.Condition.Criteria;
import com.yaic.servicelayer.charset.StandardCharset;
import com.yaic.servicelayer.util.CollectionUtil;
import com.yaic.servicelayer.util.StringUtil;

@Controller
public class OrderInfoController {

    @Autowired
    private ShopOrderInfoService shopOrderInfoService;
    @Autowired
    private OrderMainService orderMainService;
    @Autowired
    private OrderService orderService;

    /**
     * 主页面
     */
    @RequestMapping("shopOrderInfo")
    public String index(HttpServletRequest request) {
        return "order/shopOrderInfo/shopOrderInfo";
    }

    /**
     * 列表
     */
    @RequestMapping(value = "shopOrderInfo/list", method = RequestMethod.POST)
    public void list(@RequestBody ShopOrderInfoDto shopOrderInfoDto, HttpServletRequest request, HttpServletResponse response) throws Exception {

        JqGridPageDto<ShopOrderInfoDto> pageDataDto = new JqGridPageDto<ShopOrderInfoDto>();

        Condition condition = new Condition(ShopOrderInfoDto.class);
        Criteria criteria = condition.createCriteria();
        if (shopOrderInfoDto.getOrderCode() != null) {
            criteria.andEqualTo("orderCode", shopOrderInfoDto.getOrderCode());
        }
        if (shopOrderInfoDto.getUserId() != null) {
            criteria.andEqualTo("userId", shopOrderInfoDto.getUserId());
        }
        if (StringUtil.isNotEmpty(shopOrderInfoDto.getOrderStatus())) {
            criteria.andEqualTo("orderStatus", shopOrderInfoDto.getOrderStatus());
        }
        if ("0".equals(shopOrderInfoDto.getSynPolicyStatus())) {
            criteria.andEqualTo("synPolicyStatus", shopOrderInfoDto.getSynPolicyStatus());
        }else if("1".equals(shopOrderInfoDto.getSynPolicyStatus())) {
            criteria.andIsNull("synPolicyStatus");
        }
        
        condition.setOrderByClause(shopOrderInfoDto.getSidx() + " " + shopOrderInfoDto.getSord());

        if (shopOrderInfoDto.getOrderCode() == null && StringUtil.isNotEmpty(shopOrderInfoDto.getPolicyNo())) {
            OrderMainDto orderMainDto = new OrderMainDto();
            orderMainDto.setPolicyNo(shopOrderInfoDto.getPolicyNo());
            List<OrderMainDto> orderMainList = orderMainService.select(orderMainDto);
            if (CollectionUtil.isNotEmpty(orderMainList)) {
                List<Object> orderList = new ArrayList<Object>();
                for (OrderMainDto mainDto : orderMainList) {
                    orderList.add(mainDto.getOrderCode());
                }
                criteria.andIn("orderCode", orderList);
            } else {
                orderMainDto.setPolicyNo(null);
                orderMainDto.setAssociatedNo(shopOrderInfoDto.getPolicyNo());
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
                    pageDataDto.setRows(new ArrayList<ShopOrderInfoDto>());
                    pageDataDto.setTotal(0);
                    this.printWriteObject(response, pageDataDto);
                    return;
                }
            }
        }

        PageDto<ShopOrderInfoDto> pageDto = new PageDto<ShopOrderInfoDto>();
        pageDto.setPageNo(shopOrderInfoDto.getPage());
        pageDto.setPageSize(shopOrderInfoDto.getRows());
        pageDto = shopOrderInfoService.selectByPage(pageDto, condition);

        pageDataDto.setPage(pageDto.getPageNo());
        pageDataDto.setRecords(pageDto.getTotalSize());
        pageDataDto.setRows(pageDto.getResults());
        pageDataDto.setTotal(pageDto.getTotalPage());

        this.printWriteObject(response, pageDataDto);
    }

    /**
     * 将obj转为json数据,向客户端写入
     * 
     * @param response
     * @param obj
     * @throws IOException
     */
    private void printWriteObject(HttpServletResponse response, Object obj) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding(StandardCharset.UTF_8.name());
        PrintWriter write = response.getWriter();
        write.write(JsonUtil.toCompatibleJSON(obj, "yyyy-MM-dd HH:mm:ss"));
        write.flush();
        write.close();
    }

    /**
     * 列表
     */
    @RequestMapping(value = "shopOrderInfo/orderMain/list", method = RequestMethod.POST)
    public void list(@RequestBody OrderMainDto orderMainDto, HttpServletResponse response) throws Exception {

        PageDto<OrderMainDto> pageDto = new PageDto<OrderMainDto>();
        pageDto.setPageNo(orderMainDto.getPage());
        pageDto.setPageSize(orderMainDto.getRows());
        pageDto = orderMainService.selectByPage(pageDto, orderMainDto, orderMainDto.getSidx() + " " + orderMainDto.getSord());

        JqGridPageDto<OrderMainDto> pageDataDto = new JqGridPageDto<OrderMainDto>();

        pageDataDto.setPage(pageDto.getPageNo());
        pageDataDto.setRecords(pageDto.getTotalSize());
        pageDataDto.setRows(pageDto.getResults());
        pageDataDto.setTotal(pageDto.getTotalPage());

        this.printWriteObject(response, pageDataDto);
    }

    @RequestMapping(value = "viewOrderJsonData")
    public String viewOrderJsonData(HttpServletRequest request, String orderCode) {

        request.setAttribute("orderDetailInfoJsonData",
                JsonUtil.toCompatibleJSON(orderService.getOrderDetailInfo(new BigInteger(orderCode)), "yyyy-MM-dd HH:mm:ss"));

        return "order/shopOrderInfo/viewOrderInfo";
    }

}