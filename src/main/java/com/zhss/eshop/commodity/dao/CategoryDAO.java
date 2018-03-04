package com.zhss.eshop.commodity.dao;

import java.util.List;

import com.zhss.eshop.commodity.domain.CategoryDO;

/**
 * 类目管理DAO组件接口
 * @author zhonghuashishan
 *
 */
public interface CategoryDAO {

	/**
	 * 查询根类目
	 * @return 根类目集合
	 */
 	List<CategoryDO> listRoots();
	
	/**
	 * 查询子类目
	 * @param id 父类目id
	 * @return 子类目集合
	 */
	List<CategoryDO> listChildren(Long id);
	
	/**
	 * 新增类目
	 * @param category 类目
	 */
	Long save(CategoryDO category);
	
	/**
	 * 根据id查询类目
	 * @param id 类目id
	 * @return 类目
	 */
	CategoryDO getById(Long id);
	
}
