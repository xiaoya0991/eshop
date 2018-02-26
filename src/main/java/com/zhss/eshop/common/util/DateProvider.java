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
	
}
