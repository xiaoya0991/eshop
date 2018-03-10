package com.zhss.eshop.promotion.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zhss.eshop.promotion.constant.PromotionActivityStatus;
import com.zhss.eshop.promotion.constant.PromotionActivityType;
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
	 * 根据商品id查询促销活动
	 * @param goodsId 商品id
	 * @return 促销活动
	 */
	public List<PromotionActivityDTO> listByGoodsId(Long goodsId) {
		List<PromotionActivityDTO> promotionActivityDTOs = new ArrayList<PromotionActivityDTO>();
		
		try {
			SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			PromotionActivityDTO promotionActivityDTO1 = new PromotionActivityDTO();
			promotionActivityDTO1.setGmtCreate(dateFormatter.parse("2018-01-01 10:00:00"));  
			promotionActivityDTO1.setGmtModified(dateFormatter.parse("2018-01-01 10:00:00"));   
			promotionActivityDTO1.setId(1L);  
			promotionActivityDTO1.setRemark("测试促销活动1"); 
			promotionActivityDTO1.setEndTime(dateFormatter.parse("2018-01-10 10:00:00"));
			promotionActivityDTO1.setName("测试促销活动1");  
			promotionActivityDTO1.setRule("测试促销活动的规则"); 
			promotionActivityDTO1.setStartTime(dateFormatter.parse("2018-01-02 10:00:00"));
			promotionActivityDTO1.setStatus(PromotionActivityStatus.ENABLED);
			promotionActivityDTO1.setType(PromotionActivityType.REACH_DISCOUNT); 
			promotionActivityDTOs.add(promotionActivityDTO1);
			
			PromotionActivityDTO promotionActivityDTO2 = new PromotionActivityDTO();
			promotionActivityDTO2.setGmtCreate(dateFormatter.parse("2018-01-01 10:00:00"));  
			promotionActivityDTO2.setGmtModified(dateFormatter.parse("2018-01-01 10:00:00"));   
			promotionActivityDTO2.setId(1L);  
			promotionActivityDTO2.setRemark("测试促销活动2"); 
			promotionActivityDTO2.setEndTime(dateFormatter.parse("2018-01-10 10:00:00"));
			promotionActivityDTO2.setName("测试促销活动2");  
			promotionActivityDTO2.setRule("测试促销活动的规则"); 
			promotionActivityDTO2.setStartTime(dateFormatter.parse("2018-01-02 10:00:00"));
			promotionActivityDTO2.setStatus(PromotionActivityStatus.ENABLED);
			promotionActivityDTO1.setType(PromotionActivityType.MULTI_DISCOUNT); 
			promotionActivityDTOs.add(promotionActivityDTO2);
		} catch (Exception e) {
			logger.error("error", e); 
			return new ArrayList<PromotionActivityDTO>();
		}
		
		return promotionActivityDTOs;
	}
	
	/**
	 * 根据id查询促销活动
	 * @param id 促销活动id
	 * @return 促销活动
	 */
	public PromotionActivityDTO getById(Long id) {
		try {
			if(id.equals(1L)) {
				return createDiscountPromotionActivity(id);
			} else if(id.equals(2L)) {
				return createGiftPromotionActivity(id);
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.error("error", e); 
			return null;
		}
	}
	
	private PromotionActivityDTO createDiscountPromotionActivity(Long id) throws Exception {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		PromotionActivityDTO promotionActivity = new PromotionActivityDTO();
		promotionActivity.setId(id);  
		promotionActivity.setType(PromotionActivityType.REACH_DISCOUNT); 
		promotionActivity.setName("测试满减促销活动");  
		promotionActivity.setRule("[{'thresholdAmount': 200, 'reduceAmount': 20},{'thresholdAmount': 100, 'reduceAmount': 10}]"); 
		promotionActivity.setStartTime(dateFormatter.parse("2018-01-02 10:00:00"));
		promotionActivity.setEndTime(dateFormatter.parse("2018-01-10 10:00:00"));
		promotionActivity.setStatus(PromotionActivityStatus.ENABLED);
		promotionActivity.setRemark("测试满减促销活动"); 
		promotionActivity.setGmtCreate(dateFormatter.parse("2018-01-01 10:00:00"));  
		promotionActivity.setGmtModified(dateFormatter.parse("2018-01-01 10:00:00"));   
		
		return promotionActivity;
	}
	
	private PromotionActivityDTO createGiftPromotionActivity(Long id) throws Exception {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		PromotionActivityDTO promotionActivity = new PromotionActivityDTO();
		promotionActivity.setId(id);  
		promotionActivity.setType(PromotionActivityType.REACH_GIFT); 
		promotionActivity.setName("测试满赠促销活动");  
		promotionActivity.setRule("{'thresholdAmount': 200, 'giftGoodsSkuIds': [3]}");   
		promotionActivity.setStartTime(dateFormatter.parse("2018-01-02 10:00:00"));
		promotionActivity.setEndTime(dateFormatter.parse("2018-01-10 10:00:00"));
		promotionActivity.setStatus(PromotionActivityStatus.ENABLED);
		promotionActivity.setRemark("测试满赠促销活动"); 
		promotionActivity.setGmtCreate(dateFormatter.parse("2018-01-01 10:00:00"));  
		promotionActivity.setGmtModified(dateFormatter.parse("2018-01-01 10:00:00"));   
		
		return promotionActivity;
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
