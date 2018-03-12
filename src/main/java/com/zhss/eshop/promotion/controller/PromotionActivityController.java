package com.zhss.eshop.promotion.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhss.eshop.common.util.CloneDirection;
import com.zhss.eshop.common.util.ObjectUtils;
import com.zhss.eshop.promotion.domain.PromotionActivityDTO;
import com.zhss.eshop.promotion.domain.PromotionActivityQuery;
import com.zhss.eshop.promotion.domain.PromotionActivityVO;
import com.zhss.eshop.promotion.service.PromotionActivityService;

/**
 * 促销活动管理contorller组件
 * @author zhonghuashishan
 *
 */
@RestController
@RequestMapping("/promotion/activity") 
public class PromotionActivityController {
	
	private static final Logger logger = LoggerFactory.getLogger(
			PromotionActivityController.class);

	/**
	 * 促销活动管理service组件
	 */
	@Autowired
	private PromotionActivityService promotionActivityService;
	
	/**
	 * 分页查询促销活动
	 * @param query 查询条件
	 * @return 促销活动
	 */
	@GetMapping("/")  
	public List<PromotionActivityVO> listByPage(
			PromotionActivityQuery query) throws Exception {
		try {
			return ObjectUtils.convertList(promotionActivityService.listByPage(query), 
					PromotionActivityVO.class);
		} catch (Exception e) {
			logger.error("error", e); 
			return new ArrayList<PromotionActivityVO>();
		}
	}
	
	/**
	 * 根据id查询促销活动
	 * @param id 促销活动id
	 * @return 促销活动
	 */
	@GetMapping("/{id}") 
	public PromotionActivityVO getById(@PathVariable("id") Long id) throws Exception {
		try {
			return promotionActivityService.getById(id).clone(
					PromotionActivityVO.class, CloneDirection.OPPOSITE);
		} catch (Exception e) {
			logger.error("error", e); 
			return new PromotionActivityVO();
		} 
	}
	
	/**
	 * 新增促销活动
	 * @param activity 促销活动
	 */
	@PostMapping("/") 
	public Boolean save(@RequestBody PromotionActivityVO activity) throws Exception {
		try {
			promotionActivityService.save(activity.clone(PromotionActivityDTO.class, 
					CloneDirection.FORWARD));  
			return true;
		} catch (Exception e) {
			logger.error("error", e);
			return false;
		}
	}
	
	/**
	 * 更新促销活动
	 * @param activity 促销活动
	 */
	@PutMapping("/") 
	public Boolean update(PromotionActivityVO activity) throws Exception {
		try {
			promotionActivityService.update(activity.clone(PromotionActivityDTO.class, 
					CloneDirection.FORWARD));
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 删除促销活动
	 * @param id 促销活动id
	 */
	@DeleteMapping("/{id}")
	public Boolean remove(@PathVariable("id") Long id) throws Exception {
		try {
			promotionActivityService.remove(id); 
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
}
