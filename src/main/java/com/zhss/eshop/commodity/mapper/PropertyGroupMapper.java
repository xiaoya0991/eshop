package com.zhss.eshop.commodity.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.zhss.eshop.commodity.domain.PropertyGroupDO;

/**
 * 属性分组管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface PropertyGroupMapper {

	/**
	 * 新增属性分组
	 * @param group 属性分组
	 */
	@Insert("INSERT INTO commodity_property_group("
				+ "name,"
				+ "category_id,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{name},"
				+ "#{categoryId},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")") 
	void save(PropertyGroupDO group);
	
}
