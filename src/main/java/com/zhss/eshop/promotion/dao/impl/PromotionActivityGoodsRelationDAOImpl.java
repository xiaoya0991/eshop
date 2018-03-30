package com.zhss.eshop.promotion.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.promotion.dao.PromotionActivityGoodsRelationDAO;
import com.zhss.eshop.promotion.domain.PromotionActivityGoodsRelationDO;
import com.zhss.eshop.promotion.mapper.PromotionActivityGoodsRelationMapper;

/**
 * 促销活动与商品关联关系管理的DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class PromotionActivityGoodsRelationDAOImpl implements PromotionActivityGoodsRelationDAO {

	/**
	 * 促销活动与商品关联关系管理的mapper组件
	 */
	@Autowired
	private PromotionActivityGoodsRelationMapper relationMapper;
	
	/**
	 * 根据促销活动id查询促销活动与商品的关联关系
	 * @param promotionActivityId 促销活动id
	 * @return 促销活动与商品的关联关系
	 */
	@Override
	public List<PromotionActivityGoodsRelationDO> listByActivityId(
			Long promotionActivityId) {
		return relationMapper.listByActivityId(promotionActivityId);
	}
	
	/**
	 * 新增促销活动与商品的关联关系
	 * @param relation 促销活动与商品的关联关系
	 */
	@Override
	public void save(PromotionActivityGoodsRelationDO relation) {
		relationMapper.save(relation); 
	}
	
	/**
	 * 删除促销活动对应的与商品的关联关系
	 * @param promotionActivityId 促销活动id
	 */
	@Override
	public void removeByActivityId(Long promotionActivityId) {
		relationMapper.removeByActivityId(promotionActivityId); 
	}
	
}
