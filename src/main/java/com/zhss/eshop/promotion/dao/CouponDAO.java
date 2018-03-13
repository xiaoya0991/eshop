package com.zhss.eshop.promotion.dao;

import java.util.List;

import com.zhss.eshop.promotion.domain.CouponDO;
import com.zhss.eshop.promotion.domain.CouponQuery;

/**
 * 优惠券管理DAO接口
 * @author zhonghuashishan
 *
 */
public interface CouponDAO {

	/**
	 * 分页查询优惠券
	 * @param query 查询条件
	 * @return 优惠券
	 */
	List<CouponDO> listByPage(CouponQuery query);
	
	/**
	 * 新增优惠券
	 * @param coupon 优惠券
	 */
	void save(CouponDO coupon);
	
	/**
	 * 根据id查询优惠券
	 * @param id 优惠券id
	 * @return 优惠券
	 */
	CouponDO getById(Long id);
	
	/**
	 * 更新优惠券
	 * @param coupon 优惠券
	 */
	void update(CouponDO coupon);
	
	/**
	 * 删除优惠券
	 * @param id 优惠券id
	 */
	void remove(Long id);
	
}
