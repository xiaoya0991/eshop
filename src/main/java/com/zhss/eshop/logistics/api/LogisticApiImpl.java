package com.zhss.eshop.logistics.api;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhss.eshop.common.util.DateProvider;

/**
 * 物流api接口
 * @author zhonghuashishan
 *
 */
@Component
public class LogisticApiImpl implements LogisticApi {
	
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;

	/**
	 * 创建电子面单
	 * @param request 请求
	 * @return 响应
	 * @throws Exception
	 */
	@Override
	public CreateEorderResponse createEOrder(CreateEorderRequest request) throws Exception {
		// 将request转换成物流商api指定的json请求的格式
		// 发送请求到物理商api接口
		// 获取到物流商api接口返回的结果，从结果中提取出来对应的信息
		// 将响应结果封装成CreateEOrderResponse即可
		
		CreateEorderResponse response = new CreateEorderResponse();
		response.setStatus(CreateEorderResponse.SUCCESS); 
		response.setLogisticCode(UUID.randomUUID().toString().replace("-", ""));  
		response.setLogisticOrderContent("测试物流单内容");  
		
		return response;
	}
	
	/**
	 * 查询物流进度
	 * @param request 请求
	 * @return 响应
	 * @throws Exception
	 */
	@Override
	public QueryProgressResponse queryProgress(QueryProgressRequest request) throws Exception {
		// 整体情况同上
		
		QueryProgressResponse response = new QueryProgressResponse();
		response.setStatus(QueryProgressResponse.SUCCESS); 
		
		List<QueryProgressResponse.TraceEvent> traceEvents = 
				new ArrayList<QueryProgressResponse.TraceEvent>();
		
		traceEvents.add(new QueryProgressResponse.TraceEvent(
				dateProvider.parseDatetime("2018-06-25 08:05:37"),
				"正在派件..(派件人:张三,电话:13688617034)[上海 市]"));  
		
		traceEvents.add(new QueryProgressResponse.TraceEvent(
				dateProvider.parseDatetime("2018-06-25 04:01:28"),
				"快件在 上海集散中心 ,准备送往下一站 上海 [上海市]"));  
		
		traceEvents.add(new QueryProgressResponse.TraceEvent(
				dateProvider.parseDatetime("2018-06-25 04:01:28"),
				"快件在 上海集散中心 ,准备送往下一站 上海 [上海市]"));  
		
		traceEvents.add(new QueryProgressResponse.TraceEvent(
				dateProvider.parseDatetime("2018-06-25 01:41:06"),
				"快件在 上海集散中心 [上海市]")); 
		
		traceEvents.add(new QueryProgressResponse.TraceEvent(
				dateProvider.parseDatetime("2018-06-24 20:18:58"),
				"已收件[上海市]")); 
		
		traceEvents.add(new QueryProgressResponse.TraceEvent(
				dateProvider.parseDatetime("2018-06-25 10:23:03"),
				"派件已签收[上海市]")); 
		
		traceEvents.add(new QueryProgressResponse.TraceEvent(
				dateProvider.parseDatetime("2018-06-25 10:23:03"),
				"签收人是：王五，已签收[上海市]"));
		
		response.setTraceEvents(traceEvents); 
		
		return response;
	}
	
}
