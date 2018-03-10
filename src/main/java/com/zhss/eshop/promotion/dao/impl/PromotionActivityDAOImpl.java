package com.zhss.eshop.promotion.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.promotion.dao.PromotionActivityDAO;
import com.zhss.eshop.promotion.domain.PromotionActivityDO;
import com.zhss.eshop.promotion.domain.PromotionActivityQuery;
import com.zhss.eshop.promotion.mapper.PromotionActivityMapper;

/**
 * 促销活动管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class PromotionActivityDAOImpl implements PromotionActivityDAO {
	
	/**
	 * 促销活动管理mapper组件
	 */
	@Autowired
	private PromotionActivityMapper promotionActivityMapper;

	/**
	 * 分页查询促销活动
	 * @param query 查询条件
	 * @return 促销活动
	 */
	public List<PromotionActivityDO> listByPage(PromotionActivityQuery query) {
		return promotionActivityMapper.listByPage(query);
	}
	
	/**
	 * 根据id查询促销活动
	 * @param id 促销活动id
	 * @return 促销活动
	 */
	public PromotionActivityDO getById(Long id) {
		return promotionActivityMapper.getById(id);
	}
	
	/**
	 * 查询全部促销活动
	 * @return 促销活动
	 */
	public List<PromotionActivityDO> listAll() {
		return promotionActivityMapper.listAll();
	}
	
	/**
	 * 查询指定商品目前可以使用的启用状态的促销活动
	 * @param goodsId 商品id
	 * @return 促销活动
	 */
	public List<PromotionActivityDO> listEnabledByGoodsId(Long goodsId) {
		return promotionActivityMapper.listEnabledByGoodsId(goodsId);
	}
	
	/**
	 * 新增促销活动
	 * @param activity 促销活动
	 */
	public Long save(PromotionActivityDO activity) {
		promotionActivityMapper.save(activity);
		return activity.getId();
	}
	
	/**
	 * 更新促销活动
	 * @param activity 促销活动
	 */
	public void update(PromotionActivityDO activity) {
		promotionActivityMapper.update(activity); 
	}
	
	/**
	 * 更新促销活动的状态
	 * @param id 促销活动id
	 * @param status 促销活动的状态
	 */
	public void updateStatus(Long id, Integer status) {
		promotionActivityMapper.updateStatus(id, status); 
	}
	
	/**
	 * 删除促销活动
	 * @param id 促销活动id
	 */
	public void remove(Long id) {
		promotionActivityMapper.remove(id); 
	}
	
}
