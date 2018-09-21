package com.yaic.app.order.controller;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yaic.app.order.service.OrderRouteService;
import com.yaic.servicelayer.charset.StandardCharset;
import com.yaic.servicelayer.util.HttpHelper;
import com.yaic.servicelayer.util.IOUtil;
import com.yaic.servicelayer.util.StringUtil;

/**
 * 订单管理服务
 * @Author: lujicong
 * @Date: 2015-12-22
 * @Version: 1.0
 */
@Controller
public class OrderInfController {

    private static final Logger LOG = LoggerFactory.getLogger(OrderInfController.class);

    public static final String POST_KEY = "jsondata";

    @Autowired
    private OrderRouteService orderRouteService;

    @RequestMapping(value = "/order-service.do", method = RequestMethod.POST)
    protected void handleRequestInternal(HttpServletRequest request, HttpServletResponse response, @RequestBody String requestData) throws Exception {
		LOG.info("-------------服务调用开始---------------");

		final String ip = request.getRemoteHost();
		final String url = request.getRequestURI();

		final HttpSession session = request.getSession();
		final String id = (session != null) ? session.getId().toUpperCase() : StringUtil.EMPTY;

		LOG.info("[CommServer:{}] Begin - IP: {}; URI: {}", id, ip, url);

		String token = request.getParameter("token");
		LOG.info("token -->" + token);

		final StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		final String orderJSON = requestData;
		LOG.info("接口处理开始, 接到原始接口信息：{}", orderJSON);

		String responseMessage = "服务响应结果";//orderRouteService.orderRoute(requestData);
		LOG.info("接口处理结束, 响应信息={}", responseMessage);

		// 进行编码处理
		responseMessage = URLEncoder.encode(responseMessage, StandardCharset.UTF_8.name());
		final byte[] byteMessages = responseMessage.getBytes(StandardCharset.UTF_8);

		OutputStream output = null;
		try
		{
			output = response.getOutputStream();
			response.setContentType("text/html; charset=UTF-8");
			response.setContentLength(byteMessages.length);
			output.write(byteMessages);
			output.flush();
		}
		catch (final Exception e)
		{
			LOG.error("Output error: " + e.getMessage(), e);
		}
		finally
		{
			IOUtil.closeQuietly(output);
		}

		stopWatch.stop();
		LOG.info("服务总响应时间 ：[CommServer:{}] End   - Seconds: {}", id, stopWatch.getTime() / 1000.0D);
		LOG.info("-------------服务调用结束---------------");
	}
	
	private String getDecodedOrderJson(final HttpServletRequest request) {
		final String orderJSON = getOrderJson(request);
		if (StringUtil.isEmpty(orderJSON)) {
			LOG.warn("Order json is empty");
			return null;
		}

		try {
			return URLDecoder.decode(orderJSON, StandardCharset.UTF_8.name()); // 进行转码
		} catch (final UnsupportedEncodingException e) {
			LOG.error("转码操作异常, url为{}", request.getRequestURL(), e);
		}

		return null;
	}

	private String getOrderJson(final HttpServletRequest request) {
		final String orderJSON = (String) request.getAttribute(POST_KEY);
		if (orderJSON != null) {
			return orderJSON;
		}
		return HttpHelper.getBodyString(request);
	}
}
