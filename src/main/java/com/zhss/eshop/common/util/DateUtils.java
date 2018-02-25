package com.zhss.eshop.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间日期工具类
 * @author zhonghuashishan
 *
 */
public class DateUtils {
	
	/**
	 * 以线程安全的方式获取DateFormat
	 * @return
	 */
	public static Date getCurrentTime() throws Exception {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormatter.parse(dateFormatter.format(new Date()));  
	}
	
}
