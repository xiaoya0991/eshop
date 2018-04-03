package com.zhss.eshop.logistics.api;

/**
 * 查询物流进度请求的构建器
 * @author zhonghuashishan
 *
 */
public class QueryProgressRequestBuilder {
	
	public static QueryProgressRequestBuilder get() {
		return new QueryProgressRequestBuilder();
	}

	private QueryProgressRequest request = new QueryProgressRequest();
	
	/**
	 * 构建订单相关的数据
	 * @param order 订单
	 * @return 构建器
	 * @throws Exception
	 */
	public QueryProgressRequestBuilder buildOrderNo(
			String orderNo) throws Exception {
		request.setOrderNo(orderNo); 
		return this;
	}
	
	/**
	 * 构建物流单号
	 * @param logisticCode 物流单号
	 * @return 构建器
	 * @throws Exception
	 */
	public QueryProgressRequestBuilder buildLogisticCode(
			String logisticCode) throws Exception {
		request.setLogisticCode(logisticCode); 
		return this;
	}
	
	/**
	 * 创建查询物流进度的请求
	 * @return 请求
	 * @throws Exception
	 */
	public QueryProgressRequest create() throws Exception {
		return request;
	}
	
}
