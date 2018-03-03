package com.zhss.eshop.auth.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zhss.eshop.auth.domain.RolePriorityRelationshipDO;

/**
 * 角色和权限关系管理模块的mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface RolePriorityRelationshipMapper {
	
	/**
	 * 新增角色和权限的关联关系
	 * @param accountPriorityRelationshipDO
	 */
	@Insert("INSERT INTO auth_role_priority_relationship("
				+ "role_id,"
				+ "priority_id,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{roleId},"
				+ "#{priorityId},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")") 
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(RolePriorityRelationshipDO rolePriorityRelationshipDO);

	/**
	 * 根据权限id查询记录数
	 * @param priorityId 权限id
	 * @return 记录数
	 */
	@Select("SELECT count(*) "
			+ "FROM auth_role_priority_relationship "
			+ "WHERE priority_id=#{priorityId}")
	Long countByPriorityId(@Param("priorityId") Long priorityId);
	
	/**
	 * 根据角色id查询角色和权限的关系
	 * @param roleId 角色id
	 * @return 角色权限关系DO对象集合
	 */
	@Select("SELECT "
				+ "id,"
				+ "priority_id,"
				+ "role_id,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM auth_role_priority_relationship "
			+ "WHERE role_id=#{roleId}")  
	List<RolePriorityRelationshipDO> listByRoleId(
			@Param("roleId") Long roleId);
	
	/**
	 * 根据角色id删除角色权限关联关系
	 * @param roleId 角色id
	 */
	@Delete("DELTEE FROM auth_role_priority_relationship WHERE role_id=#{roleId}")  
	void removeByRoleId(@Param("roleId") Long roleId);
	
}
