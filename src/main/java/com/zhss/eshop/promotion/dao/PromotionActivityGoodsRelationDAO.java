package com.zhss.eshop.promotion.dao;

import java.util.List;

import com.zhss.eshop.promotion.domain.PromotionActivityGoodsRelationDO;

/**
 * 促销活动与商品关联关系管理的DAO组件接口
 * @author zhonghuashishan
 *
 */
public interface PromotionActivityGoodsRelationDAO {

	/**
	 * 根据促销活动id查询促销活动与商品的关联关系
	 * @param promotionActivityId 促销活动id
	 * @return 促销活动与商品的关联关系
	 */
	List<PromotionActivityGoodsRelationDO> listByActivityId(
			Long promotionActivityId);
	
	/**
	 * 新增促销活动与商品的关联关系
	 * @param relation 促销活动与商品的关联关系
	 */
	void save(PromotionActivityGoodsRelationDO relation);
	
	/**
	 * 删除促销活动对应的与商品的关联关系
	 * @param promotionActivityId 促销活动id
	 */
	void removeByActivityId(Long promotionActivityId);
	
}
