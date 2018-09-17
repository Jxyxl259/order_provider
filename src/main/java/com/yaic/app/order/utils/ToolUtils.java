/**
 * Created on Mar 13, 2009 8:15:37 PM by Administrator
 */
package com.yaic.app.order.utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;

/**
 * <li>Title: ToolsUtils.java</li>
 * <li>Project: account</li>
 * <li>Package: com.sinosoft.account.util</li>
 * <li>Description: </li>
 * <li>Copyright: Copyright (c) 2008</li>
 * <li>Company: sinosoft </li>
 * <li>Created on Mar 13, 2009 8:15:37 PM</li>
 * 
 * @author lisitao
 * @version 1.0
 */

public class ToolUtils {
    /**
     * json转XML
     * <p>User: glizhen
     * <p>Date: 2018年6月25日
     * <p>Version: 1.0
     * @param obj
     * @return
     */
	public static String toXML(Object obj) {
    	XStream xstream = new XStream();
    	xstream.processAnnotations(obj.getClass());
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + xstream.toXML(obj);
    }
	/**
	 * json转XML
	 * <p>User: glizhen
	 * <p>Date: 2018年6月25日
	 * <p>Version: 1.0
	 * @param obj
	 * @return
	 */
	public static String toXML(Object obj, Converter converter) {
		XStream xstream = new XStream();
		xstream.registerConverter(converter);
		xstream.processAnnotations(obj.getClass());
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + xstream.toXML(obj);
	}
	
	/**
	 * 验证是否包含指定字符串
	 * 
	 * @param str
	 *            传过来的值
	 * @param item
	 *            限制输入内容，多个数据的时候请用","分隔开
	 * @return 相等返回true
	 */
	public static boolean contains(final String str, final String item) {
		final String[] itemList = item.split(",");
		for (final String items : itemList) {
			if (items.equals(str)) {
				return true;
			}
		}
		return false;
	}
}