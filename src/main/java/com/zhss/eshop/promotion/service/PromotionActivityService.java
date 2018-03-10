package com.zhss.eshop.promotion.service;

import java.util.List;

import com.zhss.eshop.promotion.domain.PromotionActivityDTO;
import com.zhss.eshop.promotion.domain.PromotionActivityQuery;

/**
 * 促销活动管理service组件接口
 * @author zhonghuashishan
 *
 */
public interface PromotionActivityService {

	/**
	 * 分页查询促销活动
	 * @param query 查询条件
	 * @return 促销活动
	 */
	List<PromotionActivityDTO> listByPage(PromotionActivityQuery query) throws Exception;
	
	/**
	 * 根据id查询促销活动
	 * @param id 促销活动id
	 * @return 促销活动
	 */
	PromotionActivityDTO getById(Long id) throws Exception;
	
	/**
	 * 新增促销活动
	 * @param activity 促销活动
	 */
	void save(PromotionActivityDTO activity) throws Exception;
	
	/**
	 * 更新促销活动
	 * @param activity 促销活动
	 */
	void update(PromotionActivityDTO activity) throws Exception;
	
	/**
	 * 删除促销活动
	 * @param id 促销活动id
	 */
	void remove(Long id) throws Exception;
	
}
