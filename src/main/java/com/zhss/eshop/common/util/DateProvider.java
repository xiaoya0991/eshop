package com.zhss.eshop.common.util;

import java.util.Date;

/**
 * 日期辅助组件接口
 * @author zhonghuashishan
 *
 */
public interface DateProvider {

	/**
	 * 获取当前时间
	 * @return 当前时间
	 * @throws Exception
	 */
	Date getCurrentTime() throws Exception;
	
	/**
	 * 将Date对象格式化成：yyyy-MM-dd HH:mm:ss
	 * @param date Date对象
	 * @return 格式化日期字符串
	 * @throws Exception
	 */
	String formatDatetime(Date date) throws Exception;
	
}
