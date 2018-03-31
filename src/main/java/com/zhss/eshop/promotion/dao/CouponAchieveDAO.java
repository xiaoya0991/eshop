package com.zhss.eshop.promotion.dao;

import java.util.List;

import com.zhss.eshop.promotion.domain.CouponAchieveDO;

/**
 * 优惠券领取记录管理DAO接口
 * @author zhonghuashishan
 *
 */
public interface CouponAchieveDAO {
	
	/**
	 * 根据优惠券id和用户账号id查询优惠券的领取记录
	 * @param couponId 优惠券id 
	 * @param userAccountId 用户账号id
	 * @return 优惠券领取记录
	 */
	CouponAchieveDO getByUserAccountId(Long couponId, Long userAccountId);
	
	/**
	 * 新增优惠券领取记录
	 * @param couponAchieve 优惠券领取记录
	 */
	void save(CouponAchieveDO couponAchieve);
	
	/**
	 * 查询用户还没有使用过的优惠券领取记录
	 * @param userAccountId 用户账号id
	 * @return 优惠券领取记录
	 */
	List<CouponAchieveDO> listUnsedByUserAccountId(Long userAccountId);
	
	/**
	 * 更新优惠券领取记录
	 * @param couponAchieve 优惠券领取记录
	 */
	void update(CouponAchieveDO couponAchieve);
	
}
