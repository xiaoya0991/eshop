package com.zhss.eshop.logistics.constant;

/**
 * 运费模板类型
 * @author zhonghuashishan
 *
 */
public class FreightTemplateType {

	/**
	 * 固定运费
	 */
	public static final Integer FIXED = 1;
	/**
	 * 满X元包邮
	 */
	public static final Integer REACH_FREE = 2;
	/**
	 * 自定义规则
	 */
	public static final Integer CUSTOM_RULE = 3;
	
	private FreightTemplateType() {
		
	}
	
}
