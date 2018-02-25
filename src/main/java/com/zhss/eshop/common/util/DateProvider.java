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
public class DateProvider {
	
	/**
	 * 获取当前时间
	 * @return 当前时间
	 * @throws Exception
	 */
	public Date getCurrentTime() throws Exception {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormatter.parse(dateFormatter.format(new Date()));  
	}
	
}
