package com.zhss.eshop.commodity.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.commodity.dao.CategoryPropertyRelationshipDAO;
import com.zhss.eshop.commodity.domain.CategoryPropertyRelationshipDO;
import com.zhss.eshop.commodity.mapper.CategoryPropertyRelationshipMapper;

/**
 * 类目属性管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class CategoryPropertyRelationshipDAOImpl 
		implements CategoryPropertyRelationshipDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(
			CategoryPropertyRelationshipDAOImpl.class);
	
	private CategoryPropertyRelationshipMapper categoryPropertyRelationMapper;
	
	/**
	 * 新增类目属性关系
	 * @param relation 类目属性关系
	 */
	public Boolean save(CategoryPropertyRelationshipDO relation) {
		try {
			categoryPropertyRelationMapper.save(relation); 
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}

}
