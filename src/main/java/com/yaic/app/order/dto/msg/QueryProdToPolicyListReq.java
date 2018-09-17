package com.yaic.app.order.dto.msg;

import java.util.Date;

/**
 * 查询产品保单列表信息
 * <p>User: lpengfei
 * <p>Date: 2017年12月16日
 * <p>Version: 1.0
 */
public class QueryProdToPolicyListReq {
	
	/** 开始位置 **/
	private Integer startIndex;
	
	/** 每页数量 **/
	private Integer pageSize;
	
	/** 销售方案代码 **/
	private String agrtCode;
	
	/** 产品代码 */
	private String projectCode;
	
	/** 查询订单时间  */
	private Date orderDate;
	
	public Integer getStartIndex() {
	    return startIndex;
	}
	
	public void setStartIndex(Integer startIndex) {
	    this.startIndex = startIndex;
	}
	
	public Integer getPageSize() {
	    return pageSize;
	}
	
	public void setPageSize(Integer pageSize) {
	    this.pageSize = pageSize;
	}
	
	/** 销售方案代码 **/
	public String getAgrtCode() {
		return agrtCode;
	}
	
	/** 销售方案代码 **/
	public void setAgrtCode(String agrtCode) {
		this.agrtCode = agrtCode;
	}
	
	/** 产品代码 */
	public String getProjectCode() {
		return projectCode;
	}
	
	/** 产品代码 */
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	
	/** 查询订单时间  */
	public Date getOrderDate() {
		return orderDate;
	}
	
	/** 查询订单时间  */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

}
