package com.zhss.eshop.promotion.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zhss.eshop.promotion.constant.PromotionActivityStatus;
import com.zhss.eshop.promotion.domain.PromotionActivityDTO;
import com.zhss.eshop.promotion.service.PromotionFacadeService;

/**
 * 促销中心对外接口service组件
 * @author zhonghuashishan
 *
 */
@Service
public class PromotionFacadeServiceImpl implements PromotionFacadeService {
	
	private static final Logger logger = LoggerFactory.getLogger(PromotionFacadeServiceImpl.class);
	
	/**
	 * 根据商品id查询促销活动
	 * @param goodsId 商品id
	 * @return 促销活动
	 */
	public List<PromotionActivityDTO> listPromotionActivitiesByGoodsId(Long goodsId) {
		List<PromotionActivityDTO> promotionActivityDTOs = new ArrayList<PromotionActivityDTO>();
		
		try {
			SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			PromotionActivityDTO promotionActivityDTO1 = new PromotionActivityDTO();
			promotionActivityDTO1.setGmtCreate(dateFormatter.parse("2018-01-01 10:00:00"));  
			promotionActivityDTO1.setGmtModified(dateFormatter.parse("2018-01-01 10:00:00"));   
			promotionActivityDTO1.setId(1L);  
			promotionActivityDTO1.setPromotionActivityComment("测试促销活动1"); 
			promotionActivityDTO1.setPromotionActivityEndTime(dateFormatter.parse("2018-01-10 10:00:00"));
			promotionActivityDTO1.setPromotionActivityName("测试促销活动1");  
			promotionActivityDTO1.setPromotionActivityRule("测试促销活动的规则"); 
			promotionActivityDTO1.setPromotionActivityStartTime(dateFormatter.parse("2018-01-02 10:00:00"));
			promotionActivityDTO1.setPromotionActivityStatus(PromotionActivityStatus.ENABLED);
			promotionActivityDTOs.add(promotionActivityDTO1);
			
			PromotionActivityDTO promotionActivityDTO2 = new PromotionActivityDTO();
			promotionActivityDTO2.setGmtCreate(dateFormatter.parse("2018-01-01 10:00:00"));  
			promotionActivityDTO2.setGmtModified(dateFormatter.parse("2018-01-01 10:00:00"));   
			promotionActivityDTO2.setId(1L);  
			promotionActivityDTO2.setPromotionActivityComment("测试促销活动2"); 
			promotionActivityDTO2.setPromotionActivityEndTime(dateFormatter.parse("2018-01-10 10:00:00"));
			promotionActivityDTO2.setPromotionActivityName("测试促销活动2");  
			promotionActivityDTO2.setPromotionActivityRule("测试促销活动的规则"); 
			promotionActivityDTO2.setPromotionActivityStartTime(dateFormatter.parse("2018-01-02 10:00:00"));
			promotionActivityDTO2.setPromotionActivityStatus(PromotionActivityStatus.ENABLED);
			promotionActivityDTOs.add(promotionActivityDTO2);
		} catch (Exception e) {
			logger.error("error", e); 
			return new ArrayList<PromotionActivityDTO>();
		}
		
		return promotionActivityDTOs;
	}

}
