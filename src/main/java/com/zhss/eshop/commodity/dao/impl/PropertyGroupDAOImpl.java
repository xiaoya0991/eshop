package com.zhss.eshop.commodity.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(PropertyGroupDAOImpl.class);
	
	/**
	 * 属性分组管理mapper组件
	 */
	@Autowired
	private PropertyGroupMapper propertyGroupMapper;
	
	/**
	 * 新增属性分组
	 * @param group 属性分组
	 */
	public Long save(PropertyGroupDO group) {
		try {
			propertyGroupMapper.save(group);
			return group.getId();
		} catch (Exception e) {
			logger.error("error", e); 
			return null;
		}
	}

}
