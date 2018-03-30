package com.zhss.eshop.commodity.service.impl;

import java.util.ArrayList;
import java.util.List;

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
@Transactional(rollbackFor = Exception.class)
public class PropertyServiceImpl implements PropertyService {
	
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
	@Override
	public List<PropertyDTO> listPropertiesByPage(PropertyQuery propertyQuery) throws Exception {
		List<PropertyDO> propertyDOs = propertyDAO.listPropertiesByPage(propertyQuery);
		List<PropertyDTO> propertyDTOs = new ArrayList<PropertyDTO>(propertyDOs.size());
		
		for(PropertyDO propertyDO : propertyDOs) {
			propertyDTOs.add(propertyDO.clone(PropertyDTO.class)); 
		}
		
		return propertyDTOs;
	}
	
	/**
	 * 新增商品属性
	 * @param propertyDO 商品属性DO对象
	 */
	@Override
	public void saveProperty(PropertyDTO propertyDTO) throws Exception {
		propertyDTO.setGmtCreate(dateProvider.getCurrentTime()); 
		propertyDTO.setGmtModified(dateProvider.getCurrentTime());  
		PropertyDO propertyDO = propertyDTO.clone(PropertyDO.class);
		propertyDAO.saveProperty(propertyDO);
	}
	
	/**
	 * 根据id查询商品属性 
	 * @param id 商品属性id
	 * @return 商品属性
	 */
	@Override
	public PropertyDTO getPropertyById(Long id) throws Exception {
		PropertyDO propertyDO = propertyDAO.getPropertyById(id);
		return propertyDO.clone(PropertyDTO.class);
	}
	
	/**
	 * 更新商品属性
	 * @param propertyDO 商品属性DO对象
	 */
	@Override
	public void updateProperty(PropertyDTO propertyDTO) throws Exception {
		propertyDTO.setGmtModified(dateProvider.getCurrentTime()); 
		PropertyDO propertyDO = propertyDTO.clone(PropertyDO.class);
		propertyDAO.updateProperty(propertyDO);
	}
	
	/**
	 * 查询类目id对应的所有属性
	 * @param categoryId
	 * @return
	 */
	@Override
	public Properties getPropertiesByCategoryId(Long categoryId) throws Exception {
		CategoryOperation<Properties> operation = context.getBean(
				QueryPropertyCategoryOperation.class);
		Category category = new Category(categoryId);
		return category.execute(operation);
	}
	
}
