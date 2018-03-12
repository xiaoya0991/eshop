package com.zhss.eshop.commodity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.commodity.dao.PropertyDAO;
import com.zhss.eshop.commodity.domain.PropertyDO;
import com.zhss.eshop.commodity.domain.PropertyDTO;
import com.zhss.eshop.commodity.domain.PropertyQuery;
import com.zhss.eshop.commodity.service.PropertyService;
import com.zhss.eshop.common.bean.SpringApplicationContext;
import com.zhss.eshop.common.util.DateProvider;

/**
 * 商品属性管理模块的service组件
 * @author zhonghuashishan
 *
 */
@Service
@Transactional
public class PropertyServiceImpl implements PropertyService {
	
	private static final Logger logger = LoggerFactory.getLogger(PropertyServiceImpl.class);
	
	/**
	 * 商品属性管理模块的DAO组件
	 */
	@Autowired
	private PropertyDAO propertyDAO;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	/**
	 * spring容器
	 */
	@Autowired
	private SpringApplicationContext context;

	/**
	 * 分页查询商品属性
	 * @param propertyQuery 查询条件
	 * @return 商品属性
	 */
	public List<PropertyDTO> listPropertiesByPage(PropertyQuery propertyQuery) {
		try {
			List<PropertyDO> propertyDOs = propertyDAO.listPropertiesByPage(propertyQuery);
			List<PropertyDTO> propertyDTOs = new ArrayList<PropertyDTO>(propertyDOs.size());
			
			for(PropertyDO propertyDO : propertyDOs) {
				propertyDTOs.add(propertyDO.clone(PropertyDTO.class)); 
			}
			
			return propertyDTOs;
		} catch (Exception e) {
			logger.error("error", e);
 		}
		return new ArrayList<PropertyDTO>();
	}
	
	/**
	 * 新增商品属性
	 * @param propertyDO 商品属性DO对象
	 */
	public Boolean saveProperty(PropertyDTO propertyDTO) {
		try {
			propertyDTO.setGmtCreate(dateProvider.getCurrentTime()); 
			propertyDTO.setGmtModified(dateProvider.getCurrentTime());  
			PropertyDO propertyDO = propertyDTO.clone(PropertyDO.class);
			propertyDAO.saveProperty(propertyDO);
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
		return true;
	}
	
	/**
	 * 根据id查询商品属性 
	 * @param id 商品属性id
	 * @return 商品属性
	 */
	public PropertyDTO getPropertyById(Long id) {
		try {
			PropertyDO propertyDO = propertyDAO.getPropertyById(id);
			return propertyDO.clone(PropertyDTO.class);
		} catch (Exception e) {
			logger.error("error", e); 
		}
		return new PropertyDTO();
	}
	
	/**
	 * 更新商品属性
	 * @param propertyDO 商品属性DO对象
	 */
	public Boolean updateProperty(PropertyDTO propertyDTO) {
		try {
			propertyDTO.setGmtModified(dateProvider.getCurrentTime()); 
			PropertyDO propertyDO = propertyDTO.clone(PropertyDO.class);
			propertyDAO.updateProperty(propertyDO);
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
		return true;
	}
	
	/**
	 * 查询类目id对应的所有属性
	 * @param categoryId
	 * @return
	 */
	public Properties getPropertiesByCategoryId(Long categoryId) throws Exception {
		CategoryOperation<Properties> operation = context.getBean(
				QueryPropertyCategoryOperation.class);
		Category category = new Category(categoryId);
		return category.execute(operation);
	}
	
}
