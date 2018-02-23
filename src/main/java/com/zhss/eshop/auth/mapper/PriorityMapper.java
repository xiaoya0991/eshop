package com.zhss.eshop.auth.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

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
	
}
