package com.zhss.eshop.membership.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zhss.eshop.membership.domain.MemberLevelDetailDO;
import com.zhss.eshop.membership.domain.MemberLevelDetailQuery;

/**
 * 会员等级明细管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface MemberLevelDetailMapper {

	/**
	 * 分页查询会员等级变更明细 
	 * @param query 查询调价你
	 * @return 会员等级变更明细
	 */
	@Select("SELECT "
				+ "a.id,"
				+ "a.user_account_id,"
				+ "a.old_growth_value,"
				+ "a.updated_growth_value,"
				+ "a.new_growth_value,"
				+ "a.old_member_level,"
				+ "a.new_member_level,"
				+ "a.update_reason,"
				+ "a.gmt_create,"
				+ "a.gmt_modified "
			+ "FROM membership_member_level_detail a,"
			+ "("
				+ "SELECT id "
				+ "FROM membership_member_level_detail "
				+ "WHERE user_account_id=#{userAccountId} "
				+ "LIMIT #{offset},#{size} "
			+ ") b "
			+ "WHERE a.id=b.id") 
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "user_account_id", property = "userAccountId"),
		@Result(column = "old_growth_value", property = "oldGrowthValue"),
		@Result(column = "updated_growth_value", property = "updatedGrowthValue"),
		@Result(column = "new_growth_value", property = "newGrowthValue"),
		@Result(column = "old_member_level", property = "oldMemberLevel"),
		@Result(column = "update_reason", property = "updateReason"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	List<MemberLevelDetailDO> listByPage(MemberLevelDetailQuery query);
	
}
