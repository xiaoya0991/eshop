package com.zhss.eshop.common.util;

/**
 * 基础POJO类
 * @author zhonghuashishan
 *
 */
public class AbstractObject {

	protected <T> T clone(Class<T> clazz) throws Exception {
		T target = clazz.newInstance();
		BeanCopierUtils.copyProperties(this, target);  
		return target;
	}
	
}
