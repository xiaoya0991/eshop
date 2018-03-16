package com.zhss.eshop.membership.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zhss.eshop.membership.domain.MemberPointDO;

/**
 * 会员积分管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface MemberPointMapper {

	/**
	 * 根据用户账号id查询会员积分
	 * @param userAccountId 用户账号id
	 * @return 会员积分
	 */
	@Select("SELECT "
				+ "id,"
				+ "user_account_id,"
				+ "point,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM membership_member_point "
			+ "WHERE user_account_id=#{userAccountId}")  
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "user_account_id", property = "userAccountId"),
		@Result(column = "point", property = "point"), 
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified") 
	})
	MemberPointDO getByUserAccountId(@Param("userAccountId") Long userAccountId);
	
	/**
	 * 新增会员积分
	 * @param memberPoint 会员积分
	 */
	@Insert("INSERT INTO membership_member_point("
				+ "user_account_id,"
				+ "point,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{userAccountId},"
				+ "#{point},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")") 
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true) 
	void save(MemberPointDO memberPoint);
	
	/**
	 * 更新会员积分
	 * @param memberPoint 会员积分
	 */
	@Update("UPDATE membership_member_point SET "
				+ "point=#{point},"
				+ "gmt_modified=#{gmtModified} "
			+ "WHERE id=#[id}") 
	void update(MemberPointDO memberPoint);
	
}
