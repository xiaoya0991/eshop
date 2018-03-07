package com.zhss.eshop.commodity.dao;

import java.util.List;

import com.zhss.eshop.commodity.domain.BrandDO;
import com.zhss.eshop.commodity.domain.BrandQuery;

/**
 * 品牌管理DAO组件接口
 * @author zhonghuashishan
 *
 */
public interface BrandDAO {

	/**
	 * 分页查询品牌
	 * @param query 查询条件
	 * @return 品牌
	 */
	List<BrandDO> listByPage(BrandQuery query);
	
	/**
	 * 根据id查询品牌
	 * @param id 品牌id
	 * @return 品牌
	 */
	BrandDO getById(Long id);
	
	/**
	 * 新增品牌
	 * @param brand 品牌
	 */
	void save(BrandDO brand);
	
	/**
	 * 更新品牌
	 * @param brand
	 */
	void update(BrandDO brand);
	
	/**
	 * 删除品牌
	 * @param id 品牌id
	 */
	void remove(Long id);
	
	/**
	 * 更新品牌logo
	 * @param brand
	 */
	void updateLogoPath(BrandDO brand);
	
	/**
	 * 更新品牌授权认证书
	 * @param brand
	 */
	void updateAuthVoucherPath(BrandDO brand);
	
}
