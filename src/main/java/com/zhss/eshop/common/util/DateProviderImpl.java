package com.zhss.eshop.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * 日期辅助组件
 * @author zhonghuashishan
 *
 */
@Component
public class DateProviderImpl implements DateProvider {
	
	/**
	 * 获取当前时间
	 * @return 当前时间
	 * @throws Exception
	 */
	public Date getCurrentTime() throws Exception {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormatter.parse(dateFormatter.format(new Date()));  
	}
	
	/**
	 * 将Date对象格式化成：yyyy-MM-dd HH:mm:ss
	 * @param date Date对象
	 * @return 格式化日期字符串
	 * @throws Exception
	 */
	public String formatDatetime(Date date) throws Exception {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormatter.format(date);
	}
	
	/**
	 * 将日期字符串转化为Date对象
	 * @param datetime 日期字符串
	 * @return date对象
	 * @throws Exception
	 */
	public Date parseDatetime(String datetime) throws Exception {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormatter.parse(datetime);
	}
	
}
