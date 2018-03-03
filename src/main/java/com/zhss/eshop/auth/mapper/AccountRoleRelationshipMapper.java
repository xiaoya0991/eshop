package com.zhss.eshop.auth.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
	
}
