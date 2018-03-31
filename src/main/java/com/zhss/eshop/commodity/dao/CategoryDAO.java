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
	 * @throws Exception
	 */
 	List<CategoryDO> listRoots() throws Exception;
	
	/**
	 * 查询子类目
	 * @param id 父类目id
	 * @return 子类目集合
	 * @throws Exception
	 */
	List<CategoryDO> listChildren(Long id) throws Exception;
	
	/**
	 * 新增类目
	 * @param category 类目
	 * @return 类目id
	 * @throws Exception
	 */
	Long save(CategoryDO category) throws Exception;
	
	/**
	 * 根据id查询类目
	 * @param id 类目id
	 * @return 类目
	 * @throws Exception
	 */
	CategoryDO getById(Long id) throws Exception;
	
	/**
	 * 更新类目
	 * @param category 类目
	 * @throws Exception
	 */
	void update(CategoryDO category) throws Exception;
	
	/**
	 * 删除类目
	 * @param id 类目id
	 * @throws Exception
	 */
	void remove(Long id) throws Exception;
	
}
