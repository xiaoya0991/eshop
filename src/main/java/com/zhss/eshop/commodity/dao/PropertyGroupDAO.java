package com.zhss.eshop.commodity.dao;

import com.zhss.eshop.commodity.domain.PropertyGroupDO;

/**
 * 属性分组管理DAO组件接口
 * @author zhonghuashishan
 *
 */
public interface PropertyGroupDAO {

	/**
	 * 新增属性分组
	 * @param group 属性分组
	 */
	Long save(PropertyGroupDO group);
	
}
