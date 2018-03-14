package com.zhss.eshop.promotion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zhss.eshop.promotion.domain.CouponAchieveDO;

/**
 * 优惠券领取记录管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface CouponAchieveMapper {

	/**
	 * 根据优惠券id和用户账号id查询优惠券的领取记录
	 * @param couponId 优惠券id 
	 * @param userAccountId 用户账号id
	 * @return 优惠券领取记录
	 */
	@Select("SELECT "
				+ "id,"
				+ "coupon_id,"
				+ "user_account_id,"
				+ "is_used," 
				+ "used_time,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM promotion_coupon_achieve "
			+ "WHERE coupon_id=#{couponId} "
			+ "AND user_account_id=#{userAccountId}")    
	@Results({ 
		@Result(column = "id", property = "id", id = true),
		@Result(column = "coupon_id", property = "couponId"),
		@Result(column = "user_account_id", property = "userAccountId"),
		@Result(column = "is_used", property = "used"), 
		@Result(column = "used_time", property = "usedTime"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified") 
	})
	CouponAchieveDO getByUserAccountId(
			@Param("couponId") Long couponId,
			@Param("userAccountId") Long userAccountId);
	
	/**
	 * 新增优惠券领取记录
	 * @param couponAchieve 优惠券领取记录
	 */
	@Insert("INSERT INTO promotion_coupon_achieve("
				+ "coupon_id,"
				+ "user_account_id,"
				+ "is_used,"
				+ "used_time,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{couponId},"
				+ "#{userAccountId},"
				+ "#{used},"
				+ "#{usedTime},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")")    
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)  
	void save(CouponAchieveDO couponAchieve);
	
	/**
	 * 查询用户还没有使用过的优惠券领取记录
	 * @param userAccountId 用户账号id
	 * @return 优惠券领取记录
	 */
	@Select("SELECT "
				+ "id,"
				+ "coupon_id,"
				+ "user_account_id,"
				+ "is_used," 
				+ "used_time,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM promotion_coupon_achieve "
			+ "AND user_account_id = #{userAccountId} "
			+ "AND is_used = 0 "
			+ "AND used_time IS NULL")    
	@Results({ 
		@Result(column = "id", property = "id", id = true),
		@Result(column = "coupon_id", property = "couponId"),
		@Result(column = "user_account_id", property = "userAccountId"),
		@Result(column = "is_used", property = "used"), 
		@Result(column = "used_time", property = "usedTime"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified") 
	})
	List<CouponAchieveDO> listUnsedByUserAccountId(
			@Param("userAccountId") Long userAccountId);
	
	/**
	 * 更新优惠券领取记录
	 * @param couponAchieve 优惠券领取记录
	 */
	@Update("UPDATE promotion_coupon_achieve SET "
				+ "is_used=#{used},"
				+ "used_time=#{usedTime},"
				+ "gmt_modified=#{gmtModified} "
			+ "WHERE coupon_id=#{couponId} "
			+ "AND user_account_id=#{userAccountId}")   
	void update(CouponAchieveDO couponAchieve);
	
}
