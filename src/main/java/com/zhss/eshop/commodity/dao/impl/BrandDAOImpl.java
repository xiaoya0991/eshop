package com.zhss.eshop.commodity.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.commodity.dao.BrandDAO;
import com.zhss.eshop.commodity.domain.BrandDO;
import com.zhss.eshop.commodity.domain.BrandQuery;
import com.zhss.eshop.commodity.mapper.BrandMapper;

/**
 * 品牌管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class BrandDAOImpl implements BrandDAO {
	
	/**
	 * 品牌管理mapper组件
	 */
	@Autowired
	private BrandMapper brandMapper;

	/**
	 * 分页查询品牌
	 * @param query 查询条件
	 * @return 品牌
	 */
	public List<BrandDO> listByPage(BrandQuery query) {
		return brandMapper.listByPage(query);
	}
	
	/**
	 * 根据id查询品牌
	 * @param id 品牌id
	 * @return 品牌
	 */
	public BrandDO getById(Long id) {
		return brandMapper.getById(id);
	}
	
	/**
	 * 新增品牌
	 * @param brand 品牌
	 */
	public void save(BrandDO brand) {
		brandMapper.save(brand); 
	}
	
	/**
	 * 更新品牌
	 * @param brand
	 */
	public void update(BrandDO brand) {
		brandMapper.update(brand); 
	}
	
	/**
	 * 删除品牌
	 * @param id 品牌id
	 */
	public void remove(Long id) {
		brandMapper.remove(id); 
	}
	
	/**
	 * 更新品牌logo
	 * @param brand
	 */
	public void updateLogoPath(BrandDO brand) {
		brandMapper.updateLogoPath(brand); 
	}
	
	/**
	 * 更新品牌授权认证书
	 * @param brand
	 */
	public void updateAuthVoucherPath(BrandDO brand) {
		brandMapper.updateAuthVoucherPath(brand); 
	}
	
}
