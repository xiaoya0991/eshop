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

import com.zhss.eshop.auth.domain.AccountRoleRelationshipDO;

/**
 * 账号角色关系管理模块mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface AccountRoleRelationshipMapper {

	/**
	 * 根据角色id来查询记录数
	 * @param roleId 角色id
	 * @return 记录数
	 */
	@Select("SELECT count(*) "
			+ "FROM auth_account_role_relationship "
			+ "WHERE role_id=#{roleId}")    
	Long countByRoleId(@Param("roleId") Long roleId);
	
	/**
	 * 根据账号id查询账号和角色关联关系
	 * @param accountId 账号id
	 * @return 账号和角色关联关系
	 */
	@Select("SELECT "
				+ "id,"
				+ "account_id,"
				+ "role_id,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM auth_account_role_relationship "
			+ "WHERE account_id=#{accountId}")  
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "account_id", property = "accountId"),
		@Result(column = "role_id", property = "roleId"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	List<AccountRoleRelationshipDO> listByAccountId(
			@Param("accountId") Long accountId);
	
	/**
	 * 根据角色id查询账号id集合
	 * @param roleId 角色id
	 * @return 账号id集合
	 */
	@Select("SELECT account_id "
			+ "FROM auth_account_role_relationship "
			+ "WHERE role_id=#{roleId}")    
	List<Long> listAccountIdsByRoleId(@Param("roleId") Long roleId);
	
	/**
	 * 新增账号和角色的关联关系
	 * @param relation 账号和角色的关联关系
	 */
	@Insert("INSERT INTO auth_account_role_relationship("
				+ "account_id,"
				+ "role_id,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{accountId},"
				+ "#{roleId},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")") 
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true) 
	void save(AccountRoleRelationshipDO relation);
	
	/**
	 * 根据账号id删除账号和角色的关联关系
	 * @param accountId 账号id
	 */
	@Delete("DELETE FROM auth_account_role_relationship WHERE account_id=#{accountId}")  
	void removeByAccountId(@Param("accountId") Long accountId);
	
}
