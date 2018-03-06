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
import org.apache.ibatis.annotations.Update;

import com.zhss.eshop.auth.domain.AccountDO;
import com.zhss.eshop.auth.domain.AccountQuery;

/**
 * 账号管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface AccountMapper {

	/**
	 * 分页查询账号
	 * @param query 账号查询条件
	 * @return 账号
	 */
	@Select("<script>" 
			
			+ "SELECT "
				+ "a.id,"
				+ "a.username,"
				+ "a.name,"
				+ "a.remark,"
				+ "a.gmt_create,"
				+ "a.gmt_modified "
			+ "FROM auth_account a,"
			+ "("
				+ "SELECT id "
				+ "FROM auth_account "
				+ "WHERE 1=1 "
				
				+ "<if test='username != null'>"
				+ "AND username like '${username}%' "
				+ "</if>"
				
				+ "<if test='name != null'>"
				+ "AND name like '${name}%' " 
				+ "</if>"
				
				+ "LIMIT #{offset},#{size} " 
			+ ") b "
			+ "WHERE a.id=b.id"
			
			+ "</script>" 
	) 
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "username", property = "username"),
		@Result(column = "name", property = "name"),
		@Result(column = "remark", property = "remark"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified") 
	})
	List<AccountDO> listByPage(AccountQuery query);
	
	/**
	 * 根据id查询账号
	 * @param id 账号id 
	 * @return 账号
	 */
	@Select("SELECT "
				+ "id,"
				+ "username,"
				+ "name,"
				+ "remark,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM auth_account "
			+ "WHERE id=#{id}")  
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "username", property = "username"),
		@Result(column = "name", property = "name"),
		@Result(column = "remark", property = "remark"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified") 
	})
	AccountDO getById(@Param("id") Long id);
	
	/**
	 * 新增账号
	 * @param account 账号
	 */
	@Insert("INSERT INTO auth_account("
				+ "username,"
				+ "password,"
				+ "name,"
				+ "remark,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{username},"
				+ "#{password},"
				+ "#{name},"
				+ "#{remark},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")")   
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(AccountDO account);
	
	/**
	 * 更新账号
	 * @param account 账号
	 */
	@Update("UPDATE auth_account SET "
				+ "remark=#{remark},"
				+ "gmt_modified=#{gmtModified} "
			+ "WHERE id=#{id}") 
	void update(AccountDO account);
	
	/**
	 * 更新密码
	 * @param account 账号
	 */
	@Update("UPDATE auth_account SET "
				+ "password=#{password},"  
				+ "gmt_modified=#{gmtModified} "
			+ "WHERE id=#{id}") 
	void updatePassword(AccountDO account);
	
	/**
	 * 删除账号
	 * @param account 账号
	 */
	@Delete("DELETE FROM auth_account WHERE id=#{id}")  
	void remove(@Param("id") Long id);
	
}
