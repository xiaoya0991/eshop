package com.zhss.eshop.commodity.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.commodity.dao.PropertyGroupRelationshipDAO;
import com.zhss.eshop.commodity.domain.PropertyGroupRelationshipDO;
import com.zhss.eshop.commodity.mapper.PropertyGroupRelationshipMapper;

/**
 * 属性分组与属性关系管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class PropertyGroupRelationshipDAOImpl 
		implements PropertyGroupRelationshipDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(
			PropertyGroupRelationshipDAOImpl.class);
	
	private PropertyGroupRelationshipMapper propertyGroupRelationMapper;
	
	/**
	 * 新增属性分组与属性关系
	 * @param relation 属性分组与属性关系
	 */
	public Boolean save(PropertyGroupRelationshipDO relation) {
		try {
			propertyGroupRelationMapper.save(relation); 
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}

}
