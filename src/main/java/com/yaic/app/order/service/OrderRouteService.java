package com.yaic.app.order.service;

import java.lang.reflect.Method;

import org.apache.commons.lang.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.yaic.app.Constants;
import com.yaic.app.order.dto.msg.common.RequestMessage;
import com.yaic.app.order.dto.msg.common.ResponseMessage;
import com.yaic.app.order.enums.InterfaceEnumerable;
import com.yaic.app.order.enums.OrderServiceInterfaceEnum;
import com.yaic.app.order.enums.PayServiceInterfaceEnum;
import com.yaic.app.pay.service.PayService;
import com.yaic.fa.exceptions.MessageException;
import com.yaic.servicelayer.util.StringUtil;

/**
 * 订单管理服务接口路由
 * <p>
 * User: lujicong
 * <p>
 * Date: 2015-12-22
 * <p>
 * Version: 1.0
 */
@Service("orderRouteService")
public class OrderRouteService {
	private static final Logger logger = LoggerFactory.getLogger(OrderRouteService.class);

	@Autowired
	private OrderService orderService;
	@Autowired
	private PayService payService;

	public String orderRoute(String requestMessage) {
		ResponseMessage responseMessage = new ResponseMessage(); // 返回消息体
		if (StringUtil.isEmpty(requestMessage)) {
			responseMessage.setCode("9999");
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + "9999");
			responseMessage.setState("0");
			responseMessage.setMessage("请求参数为空！");
			return JSON.toJSONString(responseMessage);
		}

		final RequestMessage requestMessageObj = JSON.parseObject(requestMessage, RequestMessage.class);

		// 获取接口标识
		final String interfaceCode = requestMessageObj.getInterfaceCode();
		final InterfaceEnumerable interfaceEnum = getInterfaceEnum(interfaceCode);
		if (interfaceEnum == null) {
			responseMessage.setCode("9999");
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + "9999");
			responseMessage.setState("0");
			responseMessage.setMessage("未找到标识为：" + interfaceCode + "的接口定义");
			logger.error("未找到标识为：{}的接口定义", interfaceCode);
			return JSON.toJSONString(responseMessage);
		}

		final String methodName = interfaceEnum.methodName();
		final StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		try
		{
			if (interfaceEnum instanceof OrderServiceInterfaceEnum)
			{
				final Method method = orderService.getClass().getMethod(methodName, RequestMessage.class);
				responseMessage = (ResponseMessage) method.invoke(orderService, requestMessageObj);
			}
			else
			{
				final Method method = payService.getClass().getMethod(methodName, RequestMessage.class);
				responseMessage = (ResponseMessage) method.invoke(payService, requestMessageObj);
			}
		}
		catch (final Exception e)
		{
			final Throwable throwable = e.getCause();
			if (throwable instanceof MessageException)
			{
				String statusCode = ((MessageException) throwable).getErrorCode();
				if(StringUtil.isEmpty(statusCode)) {
					statusCode = Constants.STATUSCODE_PREFIX + "9999";
				}
				logger.error("MessageException, 调用接口为{}, 方法名为{}", interfaceCode, methodName, e);
				responseMessage.setCode("9999");
				responseMessage.setStatusCode(statusCode);
				responseMessage.setState("0");
				responseMessage.setMessage(throwable.getMessage());
			}
			else
			{
				logger.error("系统异常, 调用接口为{}, 方法名为{}", interfaceCode, methodName, e);
				responseMessage.setCode("9998");
				responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + "9998");
				responseMessage.setState("0");
				responseMessage.setMessage("系统异常");
			}
		}

		stopWatch.stop();
		logger.info("接口完成调用, 耗时：{}ms", stopWatch.getTime());

		return JSON.toJSONString(responseMessage);
	}

	private InterfaceEnumerable getInterfaceEnum(final String interfaceCode) {
		InterfaceEnumerable interfaceEnum = OrderServiceInterfaceEnum.fromCode(interfaceCode);
		if (interfaceEnum != null) {
			return interfaceEnum;
		}

		interfaceEnum = PayServiceInterfaceEnum.fromCode(interfaceCode);
		if (interfaceEnum != null) {
			return interfaceEnum;
		}

		return null;
	}
}
