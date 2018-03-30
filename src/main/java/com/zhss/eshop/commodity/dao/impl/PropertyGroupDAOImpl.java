package com.zhss.eshop.commodity.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.commodity.dao.PropertyGroupDAO;
import com.zhss.eshop.commodity.domain.PropertyGroupDO;
import com.zhss.eshop.commodity.mapper.PropertyGroupMapper;

/**
 * 属性分组管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class PropertyGroupDAOImpl implements PropertyGroupDAO {
	
	/**
	 * 属性分组管理mapper组件
	 */
	@Autowired
	private PropertyGroupMapper propertyGroupMapper;
	
	/**
	 * 新增属性分组
	 * @param group 属性分组
	 */
	@Override
	public Long save(PropertyGroupDO group) throws Exception {
		propertyGroupMapper.save(group);
		return group.getId();
	}
	
	/**
	 * 根据类目id查询属性分组
	 * @param categoryId 类目id
	 * @return 属性分组
	 */
	@Override
	public List<PropertyGroupDO> listByCategoryId(Long categoryId) throws Exception {
		return propertyGroupMapper.listByCategoryId(categoryId);
	}
	
	/**
	 * 根据类目id删除属性分组
	 * @param categoryId 类目id
	 */
	@Override
	public void removeByCategoryId(Long categoryId) throws Exception {
		propertyGroupMapper.removeByCategoryId(categoryId);
	}

}
