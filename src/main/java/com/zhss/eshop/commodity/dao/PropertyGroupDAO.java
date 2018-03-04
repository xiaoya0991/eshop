package com.zhss.eshop.commodity.dao;

import java.util.List;

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
	
	/**
	 * 根据类目id查询属性分组
	 * @param categoryId 类目id
	 * @return 属性分组
	 */
	List<PropertyGroupDO> listByCategoryId(Long categoryId);
	
}
