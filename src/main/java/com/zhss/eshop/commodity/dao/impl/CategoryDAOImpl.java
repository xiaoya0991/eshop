package com.zhss.eshop.commodity.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.commodity.dao.CategoryDAO;
import com.zhss.eshop.commodity.domain.CategoryDO;
import com.zhss.eshop.commodity.mapper.CategoryMapper;

/**
 * 类目管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class CategoryDAOImpl implements CategoryDAO {

	/**
	 * 类目管理mapper组件
	 */
	@Autowired
	private CategoryMapper categoryMapper;
	
	/**
	 * 查询根类目
	 * @return 根类目集合
	 */
 	public List<CategoryDO> listRoots() throws Exception {
		return categoryMapper.listRoots();
 	}
	/**
	 * 查询子类目
	 * @param id 父类目id
	 * @return 子类目集合
	 */
	public List<CategoryDO> listChildren(Long id) throws Exception {
		return categoryMapper.listChildren(id);
	}
	
	/**
	 * 新增类目
	 * @param category 类目
	 */
	public Long save(CategoryDO category) throws Exception {
		categoryMapper.save(category);
		return category.getId();
	}
	
	/**
	 * 根据id查询类目
	 * @param id 类目id
	 * @return 类目
	 */
	public CategoryDO getById(Long id) throws Exception {
		return categoryMapper.getById(id);
	}
	
	/**
	 * 更新类目
	 * @param category 类目
	 */
	public void update(CategoryDO category) throws Exception {
		categoryMapper.update(category); 
	}
	
	/**
	 * 删除类目
	 * @param id 类目id
	 */
	public void remove(Long id) throws Exception {
		categoryMapper.remove(id);
	}
	
}
