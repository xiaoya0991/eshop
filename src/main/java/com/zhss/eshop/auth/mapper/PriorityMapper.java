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

import com.zhss.eshop.auth.domain.PriorityDO;

/**
 * 权限管理模块的mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface PriorityMapper {

	/**
	 * 查询根权限
	 * @return 根权限集合
	 */
	@Select("SELECT "
				+ "id,"
				+ "code,"
				+ "url,"
				+ "priority_comment,"
				+ "priority_type,"
				+ "parent_id,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM auth_priority "
			+ "WHERE parent_id IS NULL")
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "code", property = "code"),
		@Result(column = "url", property = "url"),
		@Result(column = "priority_comment", property = "priorityComment"),
		@Result(column = "priority_type", property = "priorityType"),
		@Result(column = "parent_id", property = "parentId"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	List<PriorityDO> listRootPriorities();
	
	/**
	 * 根据父权限id查询子权限
	 * @param parentId 父权限id
	 * @return 子权限
	 */
	@Select("SELECT "
				+ "id,"
				+ "code,"
				+ "url,"
				+ "priority_comment,"
				+ "priority_type,"
				+ "parent_id,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM auth_priority "
			+ "WHERE parent_id = #{parentId}") 
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "code", property = "code"),
		@Result(column = "url", property = "url"),
		@Result(column = "priority_comment", property = "priorityComment"),
		@Result(column = "priority_type", property = "priorityType"),
		@Result(column = "parent_id", property = "parentId"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	List<PriorityDO> listChildPriorities(@Param("parentId") Long parentId);
	
	/**
	 * 根据id查询权限
	 * @param id 权限id
	 * @return 权限
	 */
	@Select("SELECT "
				+ "id,"
				+ "code,"
				+ "url,"
				+ "priority_comment,"
				+ "priority_type,"
				+ "parent_id,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM auth_priority "
			+ "WHERE id = #{id}") 
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "code", property = "code"),
		@Result(column = "url", property = "url"),
		@Result(column = "priority_comment", property = "priorityComment"),
		@Result(column = "priority_type", property = "priorityType"),
		@Result(column = "parent_id", property = "parentId"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	PriorityDO getPriorityById(@Param("id") Long id);
	
	/**
	 * 新增权限
	 * @param priorityDO 权限DO对象
	 */
	@Insert("INSERT INTO auth_priority("
				+ "code, "
				+ "url, "
				+ "priority_comment, "
				+ "priority_type, "
				+ "parent_id, "
				+ "gmt_create, "
				+ "gmt_modified"
			+ ") "
			+ "VALUES("
				+ "#{code}, "
				+ "#{url), "
				+ "#{priorityComment}, "
				+ "#{priorityType}, "
				+ "#{parentId}, "
				+ "#{gmtCreate}, "
				+ "#{gmtModified}"
			+ ")") 
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void savePriority(PriorityDO priorityDO); 
	
	/**
	 * 更新权限
	 * @param priorityDO 权限DO对象
	 */
	@Update("UPDATE auth_priority SET "
				+ "code=#{code}, "
				+ "url=#{url}, "
				+ "priority_comment=#{priorityComment}, "
				+ "priority_type=#{priorityType}, "
				+ "parent_id=#{parentId}, "
				+ "gmt_create=#{gmtCreate}, "
				+ "gmt_modified=#{gmtModified} "
			+ "WHERE id=#{id}") 
	void updatePriority(PriorityDO priorityDO);
	
	/**
	 * 删除权限
	 * @param id 权限id
	 */
	@Delete("DELETE FROM auth_priority WHERE id=#{id}") 
	void removePriority(@Param("id") Long id);
	
}
