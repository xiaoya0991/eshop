package com.zhss.eshop.logistics.api;

/**
 * 物流接口代理：代理了远程的第三方厂商的所有api接口
 * @author zhonghuashishan
 *
 */
public interface LogisticApi {

	/**
	 * 创建电子面单
	 * @param request 请求
	 * @return 响应
	 * @throws Exception
	 */
	CreateEorderResponse createEOrder(CreateEorderRequest request) throws Exception;
	
	/**
	 * 查询物流进度
	 * @param request 请求
	 * @return 响应
	 * @throws Exception
	 */
	QueryProgressResponse queryProgress(QueryProgressRequest request) throws Exception;
	
}
