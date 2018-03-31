package com.zhss.eshop.logistics.api;

import java.util.Date;
import java.util.List;

/**
 * 查询物流进度的响应
 * @author zhonghuashishan
 *
 */
public class QueryProgressResponse {
	
	public static final Integer SUCCESS = 1;
	public static final Integer FAILURE = 0;
	
	/**
	 * 响应状态
	 */
	private Integer status;
	/**
	 * 追踪活动
	 */
	private List<TraceEvent> traceEvents;

	/**
	 * 物流追踪活动
	 * @author zhonghuashishan
	 *
	 */
	public static class TraceEvent {
		
		/**
		 * 活动发生的时间
		 */
		private Date time;
		/**
		 * 活动的描述
		 */
		private String description;
		
		public TraceEvent(Date time, String description) {
			this.time = time;
			this.description = description;
		}
		
		public Date getTime() {
			return time;
		}
		public void setTime(Date time) {
			this.time = time;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<TraceEvent> getTraceEvents() {
		return traceEvents;
	}

	public void setTraceEvents(List<TraceEvent> traceEvents) {
		this.traceEvents = traceEvents;
	}
	
}
