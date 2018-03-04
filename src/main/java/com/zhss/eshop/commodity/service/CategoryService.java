package com.zhss.eshop.commodity.service;

import java.util.List;

import com.zhss.eshop.commodity.domain.CategoryDTO;

/**
 * 类目管理service组件接口
 * @author zhonghuashishan
 *
 */
public interface CategoryService {

	/**
	 * 查询根类目
	 * @return 根类目集合
	 */
 	List<CategoryDTO> listRoots();
	
	/**
	 * 查询子类目
	 * @param id 父类目id
	 * @return 子类目集合
	 */
	List<CategoryDTO> listChildren(Long id);
	
	/**
	 * 新增类目
	 * @param category 类目
	 * @return 处理结果
	 */
	Boolean save(CategoryDTO category);
	
	/**
	 * 根据id查询类目
	 * @param id 类目id
	 * @return 类目
	 */
	CategoryDTO getById(Long id);
	
}
