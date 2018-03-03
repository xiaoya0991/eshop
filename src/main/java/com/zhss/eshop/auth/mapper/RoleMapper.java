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

import com.zhss.eshop.auth.domain.RoleDO;
import com.zhss.eshop.auth.domain.RoleQuery;

/**
 * 角色管理模块mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface RoleMapper {

	/**
	 * 分页查询角色
	 * @param query 查询条件
	 * @return 角色DO对象集合
	 */
	@Select("<script>"
			
			+ "SELECT "
				+ "a.id,"
				+ "a.code,"
				+ "a.name,"
				+ "a.remark,"
				+ "a.gmt_create,"
				+ "a.gmt_modified "
			+ "FROM auth_role a,"
			+ "("
				+ "SELECT id "
				+ "FROM auth_role "
				+ "WHERE 1=1 "
				
				+ "<if test='code != null'>"
				+ "AND code like '${code}%' "
				+ "</if>"
				
				+ "<if test='name != null'>"
				+ "AND name like '${name}%' "
				+ "</if>"
				
				+ "LIMIT #{offset},#{size}"  
			+ ") b "
			+ "WHERE a.id=b.id " 
			+ "</script>" 
	)  
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "code", property = "code"),
		@Result(column = "name", property = "name"),
		@Result(column = "remark", property = "remark"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified") 
	})
	List<RoleDO> listByPage(RoleQuery query);
	
	/**
	 * 根据id查询角色DO对象
	 * @param id 角色 id 
	 * @return 角色DO对象
	 */
	@Select("SELECT "
				+ "id,"
				+ "code,"
				+ "name,"
				+ "remark,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM auth_role "
			+ "WHERE id=#{id}")  
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "code", property = "code"),
		@Result(column = "name", property = "name"),
		@Result(column = "remark", property = "remark"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified") 
	})
	RoleDO getById(@Param("id") Long id);
	
	/**
	 * 新增角色
	 * @param role 角色DO对象
	 */
	@Insert("INSERT INTO auth_role("
				+ "code,"
				+ "name,"
				+ "remark,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{code},"
				+ "#{name},"
				+ "#{remark},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")")  
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)  
	void save(RoleDO role); 
	
	/**
	 * 更新角色
	 * @param role 角色DO对象
	 */
	@Update("UPDATE auth_role SET "
				+ "code=#{code},"
				+ "name=#{name},"
				+ "remark=#{remark},"
				+ "gmt_modified=#{gmtModified} "
			+ "WHERE id=#{id}")
	void update(RoleDO role);
	
	/**
	 * 删除角色
	 * @param id 角色id
	 */
	@Delete("DELETE FROM auth_role WHERE id=#{id}")  
	void remove(@Param("id") Long id);
	
}
