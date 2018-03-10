package com.zhss.eshop.promotion.dao;

import java.util.List;

import com.zhss.eshop.promotion.domain.PromotionActivityDO;
import com.zhss.eshop.promotion.domain.PromotionActivityQuery;

/**
 * 促销活动管理DAO组件接口
 * @author zhonghuashishan
 *
 */
public interface PromotionActivityDAO {

	/**
	 * 分页查询促销活动
	 * @param query 查询条件
	 * @return 促销活动
	 */
	List<PromotionActivityDO> listByPage(PromotionActivityQuery query);
	
	/**
	 * 根据id查询促销活动
	 * @param id 促销活动id
	 * @return 促销活动
	 */
	PromotionActivityDO getById(Long id);
	
	/**
	 * 查询全部促销活动
	 * @return 促销活动
	 */
	List<PromotionActivityDO> listAll(); 
	
	/**
	 * 查询指定商品目前可以使用的启用状态的促销活动
	 * @param goodsId 商品id
	 * @return 促销活动
	 */
	List<PromotionActivityDO> listEnabledByGoodsId(Long goodsId);
	
	/**
	 * 新增促销活动
	 * @param activity 促销活动
	 */
	Long save(PromotionActivityDO activity);
	
	/**
	 * 更新促销活动
	 * @param activity 促销活动
	 */
	void update(PromotionActivityDO activity);
	
	/**
	 * 更新促销活动的状态
	 * @param id 促销活动id
	 * @param status 促销活动的状态
	 */
	void updateStatus(Long id, Integer status);
	
	/**
	 * 删除促销活动
	 * @param id 促销活动id
	 */
	void remove(Long id);
	
}
