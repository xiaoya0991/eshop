package com.zhss.eshop.commodity.dao;

import java.util.List;

import com.zhss.eshop.commodity.domain.GoodsDO;
import com.zhss.eshop.commodity.domain.GoodsQuery;

/**
 * 商品管理DAO组件接口
 * @author zhonghuashishan
 *
 */
public interface GoodsDAO {

	/**
	 * 根据类目id查询商品数量
	 * @param categoryId 类目id
	 * @return 商品数量
	 */
	Long countByCategoryId(Long categoryId) throws Exception;
	
	/**
	 * 根据品牌id查询商品数量
	 * @param categoryId 类目id
	 * @return 商品数量
	 */
	Long countByBrandId(Long brandId);
	
	/**
	 * 分页查询商品
	 * @param query 查询条件
	 * @return 商品
	 */
	List<GoodsDO> listByPage(GoodsQuery query);
	
	/**
	 * 根据id查询商品
	 * @param id 商品id
	 * @return 商品
	 */
	GoodsDO getById(Long id);
	
	/**
	 * 新增商品
	 * @param goods 商品
	 */
	Long save(GoodsDO goods);
	
	/**
	 * 更新商品
	 * @param goods 商品
	 */
	void update(GoodsDO goods);
	
	/**
	 * 更新商品状态
	 * @param goods
	 */
	void updateStatus(GoodsDO goods);
	
	/**
	 * 删除商品
	 * @param id 商品id
	 */
	void remove(Long id);
	
}
