package com.yaic.app.order.utils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Map.Entry;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.yaic.app.epolicy.dto.domain.EpolicyDynamicItemDto;
import com.yaic.app.epolicy.dto.domain.EpolicyDynamicListDto;
import com.yaic.servicelayer.util.CollectionUtil;

/**
 * 复写Converter接口,封装实体类中的map转xml格式(仅限电子保单模板封装使用)
 * <p>User: glizhen
 * <p>Date: 2018年7月6日
 * <p>Version: 1.0
 * @param obj
 * @return
 */
public class EpolicyDynamicConverter implements Converter  {
	 
	@Override
	@SuppressWarnings("rawtypes")
	public boolean canConvert(Class arg0) {
		return arg0.equals(EpolicyDynamicItemDto.class) || arg0.equals(EpolicyDynamicListDto.class);
	}
 

	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
		try {
			if (source != null) {
				if (source.getClass().equals(EpolicyDynamicItemDto.class)) {
					EpolicyDynamicItemDto dynamicItemDto = (EpolicyDynamicItemDto) source;
					Field[] fields = dynamicItemDto.getClass().getDeclaredFields();
					if (fields != null && fields.length > 0) {
						for (Field field : fields) {
							field.setAccessible(true);
							String filedName = field.getName();
							if ("class java.lang.String".equals(field.getGenericType().toString())) {
								String value = (String) field.get(dynamicItemDto);
								if (value != null) {
									writer.startNode(filedName.toUpperCase());
									writer.setValue(value);
									writer.endNode();
								}
							}
						}
					}
					Map<String, String> dynamicItemMap = dynamicItemDto.getDynamicItemMap();
					if (CollectionUtil.isNotEmpty(dynamicItemMap)) {
						for (Entry<String, String> entry : dynamicItemMap.entrySet()) {
							String nodeName = entry.getKey();
							String nodeValue = entry.getValue();
							writer.startNode(nodeName);
							writer.setValue(nodeValue);
							writer.endNode();
						}
					}
				} else if (source.getClass().equals(EpolicyDynamicListDto.class)) {
					EpolicyDynamicListDto dynamicListDto = (EpolicyDynamicListDto) source;
					Field[] fields = dynamicListDto.getClass().getDeclaredFields();
					if (fields != null && fields.length > 0) {
						for (Field field : fields) {
							field.setAccessible(true);
							String filedName = field.getName();
							if ("class java.lang.String".equals(field.getGenericType().toString())) {
								String value = (String) field.get(dynamicListDto);
								if (value != null) {
									writer.startNode(filedName.toUpperCase());
									writer.setValue(value);
									writer.endNode();
								}
							}
						}
					}
					Map<String, String> dynamicListMap = dynamicListDto.getDynamicListMap();
					if (CollectionUtil.isNotEmpty(dynamicListMap)) {
						for (Entry<String, String> entry : dynamicListMap.entrySet()) {
							String nodeName = entry.getKey();
							String nodeValue = entry.getValue();
							writer.startNode(nodeName);
							writer.setValue(nodeValue);
							writer.endNode();
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		return null;
	}
}
