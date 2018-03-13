package com.zhss.eshop.promotion.service;

import java.util.List;

import com.zhss.eshop.promotion.domain.CouponDTO;
import com.zhss.eshop.promotion.domain.CouponQuery;

/**
 * 优惠券管理service接口
 * @author zhonghuashishan
 *
 */
public interface CouponService {

	/**
	 * 分页查询优惠券
	 * @param query 查询条件
	 * @return 优惠券
	 */
	List<CouponDTO> listByPage(CouponQuery query) throws Exception;
	
	/**
	 * 新增优惠券
	 * @param coupon 优惠券
	 */
	void save(CouponDTO coupon) throws Exception;
	
	/**
	 * 根据id查询优惠券
	 * @param id 优惠券id
	 * @return 优惠券
	 */
	CouponDTO getById(Long id) throws Exception;
	
	/**
	 * 更新优惠券
	 * @param coupon 优惠券
	 */
	void update(CouponDTO coupon) throws Exception;
	
	/**
	 * 删除优惠券
	 * @param id 优惠券id
	 */
	void remove(Long id) throws Exception;
	
}
