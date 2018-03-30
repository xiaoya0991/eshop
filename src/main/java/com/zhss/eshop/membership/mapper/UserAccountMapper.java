package com.zhss.eshop.membership.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zhss.eshop.membership.domain.UserAccountDO;

/**
 * 用户账号管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface UserAccountMapper {

	/**
	 * 新增用户账号
	 * @param userAccount 用户账号
	 */
	@Insert("INSERT INTO membership_user_account("
				+ "username,"
				+ "password,"
				+ "email,"
				+ "cell_phone_number,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{username},"
				+ "#{password},"
				+ "#{email},"
				+ "#{cellPhoneNumber},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")") 
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)  
	void save(UserAccountDO userAccount);
	
	/**
	 * 为登录来统计是否有对应的账号在
	 * @param userAccount 用户账号
	 * @return
	 */
	@Select("<script>"
			
			+ "SELECT "
				+ "id,"
				+ "username,"
				+ "password,"
				+ "email,"
				+ "cell_phone_number,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM membership_user_account "
			+ "WHERE 1=1 "
			
			+ "<if test='username != null'>"
			+ "AND username=#{username} "
			+ "</if>"
			
			+ "<if test='email != null'>"
			+ "AND email=#{email} "
			+ "</if>"
			
			+ "<if test='cellPhoneNumber != null'>"
			+ "AND cell_phone_number=#{cellPhoneNumber} " 
			+ "</if>"
			
			+ "AND password=#{password} "  
			
			+ "</script>")  
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "username", property = "username"),
		@Result(column = "password", property = "password"),
		@Result(column = "email", property = "email"),
		@Result(column = "cell_phone_number", property = "cellPhoneNumber"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	UserAccountDO getForLogin(UserAccountDO userAccount);
	
	/**
	 * 根据id查询用户账号 
	 * @param id 用户账号id
	 * @return 用户账号
	 */
	@Select("SELECT "
				+ "id,"
				+ "username,"
				+ "email,"
				+ "cell_phone_number,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM membership_user_account "
			+ "WHERE id=#{id} ")    
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "username", property = "username"),
		@Result(column = "email", property = "email"),
		@Result(column = "cell_phone_number", property = "cellPhoneNumber"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	UserAccountDO getById(@Param("id") Long id);
	
	/**
	 * 查询所有用户账号
	 * @return 用户账号
	 */
	@Select("SELECT "
				+ "id,"
				+ "username,"
				+ "email,"
				+ "cell_phone_number,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM membership_user_account")    
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "username", property = "username"),
		@Result(column = "email", property = "email"),
		@Result(column = "cell_phone_number", property = "cellPhoneNumber"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	}) 
	List<UserAccountDO> listAll();
	
	/**
	 * 更新密码
	 * @param userAccount 用户账号
	 */
	@Update("UPDATE membership_user_account SET "
				+ "password=#{password},"
				+ "gmt_modified=#{gmtModified} "
			+ "WHERE id=#{id}") 
	void updatePassword(UserAccountDO userAccount);
	
}
