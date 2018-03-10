package com.zhss.eshop.auth.mapper;

import java.util.List;
import java.util.Map;

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
	 * 查询账号被授权的根菜单
	 * @param accountId 账号id
	 * @return
	 */
	@Select("<script>"
			
			+ "SELECT "
				+ "id,"
				+ "code,"
				+ "url,"
				+ "priority_comment,"
				+ "priority_type,"
				+ "parent_id,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM "
			+ "("
				+ "SELECT "
					+ "p.id,"
					+ "p.code,"
					+ "p.url,"
					+ "p.priority_comment,"
					+ "p.priority_type,"
					+ "p.parent_id,"
					+ "p.gmt_create,"
					+ "p.gmt_modified "
				+ "FROM auth_account_role_relationship acr "
				+ "JOIN auth_role_priority_relationship rpr ON acr.role_id=rpr.role_id "
				+ "JOIN auth_priority p ON rpr.priority_id=p.id "
				+ "WHERE acr.account_id=#{accountId} "
				
				+ "<if test='parentId == null'>"
				+ "AND p.parent_id IS NULL "
				+ "AND p.priority_type=1 "
				+ "</if>"  
				
				+ "<if test='parentId != null'>"
				+ "AND p.parent_id=#{parentId} "
				+ "</if>"  
				
				+ "UNION ALL " 
				
				+ "SELECT "
					+ "p.id,"
					+ "p.code,"
					+ "p.url,"
					+ "p.priority_comment,"
					+ "p.priority_type,"
					+ "p.parent_id,"
					+ "p.gmt_create,"
					+ "p.gmt_modified "
				+ "FROM auth_account_priority_relationship apr "
				+ "JOIN auth_priority p ON apr.priority_id=p.id "
				+ "WHERE apr.account_id=#{accountId} "
				
				+ "<if test='parentId == null'>"
				+ "AND p.parent_id IS NULL "
				+ "AND p.priority_type=1 "
				+ "</if>"  
				
				+ "<if test='parentId != null'>"
				+ "AND p.parent_id=#{parentId} "
				+ "</if>"  
			+ ") a "
				
			+ "</script>" 
	)
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
	List<PriorityDO> listAuthroziedByAccountId(Map<String, Object> parameters);  
	
	/**
	 * 根据权限编号判断账号是否对这个权限有授权记录
	 * @param accountId 账号id
	 * @param code 权限编号 
	 * @return 是否有授权记录
	 */
	@Select("SELECT SUM(cnt) " 
			+ "FROM "
			+ "("
				+ "SELECT count(*) cnt "
				+ "FROM auth_account_role_relationship arr "
				+ "JOIN auth_role_priority_relationship rpr ON arr.role_id=rpr.role_id "
				+ "JOIN auth_priority p ON rpr.priority_id=p.id "
				+ "WHERE arr.account_id=#{accountId} "
				+ "AND p.code=#{code} "
				
				+ "UNION ALL "
				
				+ "SELECT count(*) cnt "
				+ "FROM auth_account_priority_relationship apr "
				+ "JOIN auth_priority p ON apr.priority_id=p.id "
				+ "WHERE apr.account_id=#{accountId} "
				+ "AND p.code=#{code} "
			+ ") a "
	)  
	Long countAuthorizedByCode(@Param("accountId") Long accountId, 
			@Param("code") String code);
	
	/**
	 * 根据权限URL判断账号是否对这个权限有授权记录
	 * @param accountId 账号id
	 * @param code 权限编号 
	 * @return 是否有授权记录
	 */
	@Select("SELECT SUM(cnt) " 
			+ "FROM "
			+ "("
				+ "SELECT count(*) cnt "
				+ "FROM auth_account_role_relationship arr "
				+ "JOIN auth_role_priority_relationship rpr ON arr.role_id=rpr.role_id "
				+ "JOIN auth_priority p ON rpr.priority_id=p.id "
				+ "WHERE arr.account_id=#{accountId} "
				+ "AND p.url=#{url} "
				
				+ "UNION ALL "
				
				+ "SELECT count(*) cnt "
				+ "FROM auth_account_priority_relationship apr "
				+ "JOIN auth_priority p ON apr.priority_id=p.id "
				+ "WHERE apr.account_id=#{accountId} "
				+ "AND p.url=#{url} "
			+ ") a "
	)  
	Long countAuthorizedByUrl(@Param("accountId") Long accountId, 
			@Param("url") String url);
	
	/**
	 * 根据权限id查询账号id
	 * @param priorityId 权限id
	 * @return 
	 */
	@Select("SELECT account_id "
			+ "FROM ("
				+ "SELECT arr.account_id "
				+ "FROM auth_account_role_relationship arr "
				+ "JOIN auth_role_priority_relationship rpr ON arr.role_id=rpr.role_id "
				+ "WHERE rpr.priority_id=#{priorityId} "
				
				+ "UNION ALL "
				
				+ "SELECT apr.account_id "
				+ "FROM auth_account_priority_relationship apr "
				+ "WHERE apr.priority_id=#{priorityId} "
			+ ") a ")  
	List<Long> listAccountIdsByPriorityId(
			@Param("priorityId") Long priorityId);
	
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
				+ "#{url}, "
				+ "#{priorityComment}, "
				+ "#{priorityType}, "
				+ "#{parentId}, "
				+ "#{gmtCreate}, "
				+ "#{gmtModified}"
			+ ")") 
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
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
