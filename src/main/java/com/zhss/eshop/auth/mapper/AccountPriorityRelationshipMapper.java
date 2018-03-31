package com.zhss.eshop.auth.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zhss.eshop.auth.domain.AccountPriorityRelationshipDO;

/**
 * 账号和权限关系管理模块的mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface AccountPriorityRelationshipMapper {
	
	/**
	 * 根据权限id查询记录数
	 * @param priorityId 权限id
	 * @return 记录数
	 */
	@Select("SELECT count(*) "
			+ "FROM auth_account_priority_relationship "
			+ "WHERE priority_id=#{priorityId}")
	Long countByPriorityId(@Param("priorityId") Long priorityId);
	
	/**
	 * 根据账号id查询账号和权限的关联关系
	 * @param accountId 账号id
	 * @return 账号和权限的关联关系
	 */
	@Select("SELECT "
				+ "id,"
				+ "account_id,"
				+ "priority_id,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM auth_account_priority_relationship "
			+ "WHERE account_id=#{accountId}")  
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "account_id", property = "accountId"),
		@Result(column = "priority_id", property = "priorityId"), 
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	List<AccountPriorityRelationshipDO> listByAccountId(
			@Param("accountId") Long accountId);
	
	/**
	 * 新增账号和权限的关联关系
	 * @param accountPriorityRelationshipDO
	 */
	@Insert("INSERT INTO auth_account_priority_relationship("
				+ "account_id,"
				+ "priority_id,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{accountId},"
				+ "#{priorityId},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")") 
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(AccountPriorityRelationshipDO accountPriorityRelationshipDO);
	
	/**
	 * 根据账号id删除账号和权限的关联关系
	 * @param accountId 账号id
	 */
	@Delete("DELETE FROM auth_account_priority_relationship WHERE account_id=#{accountId}")  
	void removeByAccountId(@Param("accountId") Long accountId);
	
}
