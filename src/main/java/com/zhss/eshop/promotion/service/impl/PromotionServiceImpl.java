package com.zhss.eshop.promotion.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhss.eshop.common.util.ObjectUtils;
import com.zhss.eshop.promotion.dao.PromotionActivityDAO;
import com.zhss.eshop.promotion.domain.CouponDTO;
import com.zhss.eshop.promotion.domain.PromotionActivityDTO;
import com.zhss.eshop.promotion.service.PromotionService;

/**
 * 促销中心service组件
 * @author zhonghuashishan
 *
 */
@Service
public class PromotionServiceImpl implements PromotionService {
	
	private static final Logger logger = LoggerFactory.getLogger(PromotionServiceImpl.class);
	
	/**
	 * 促销活动管理DAO组件
	 */
	@Autowired
	private PromotionActivityDAO promotionActivityDAO;
	
	/**
	 * 根据商品id查询促销活动
	 * @param goodsId 商品id
	 * @return 促销活动
	 */
	public List<PromotionActivityDTO> listByGoodsId(Long goodsId) {
		try {
			return ObjectUtils.convertList(promotionActivityDAO.listEnabledByGoodsId(goodsId), 
					PromotionActivityDTO.class);
		} catch (Exception e) {
			logger.error("error", e); 
			return new ArrayList<PromotionActivityDTO>();
		}
	}
	
	/**
	 * 根据id查询促销活动
	 * @param id 促销活动id
	 * @return 促销活动
	 */
	public PromotionActivityDTO getById(Long id) {
		try {
			return promotionActivityDAO.getById(id).clone(PromotionActivityDTO.class); 
		} catch(Exception e) {
			logger.error("Error", e); 
			return null;
		}
	}
	
	/**
	 * 查询用户当前可以使用的有效优惠券
	 * @param userAccountId 用户账号id
	 * @return 有效优惠券
	 */
	public List<CouponDTO> listValidByUserAccountId(Long userAccountId) {
		return null;
	}

}
