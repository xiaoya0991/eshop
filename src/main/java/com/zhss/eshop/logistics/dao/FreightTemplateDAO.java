package com.zhss.eshop.logistics.dao;

import java.util.List;

import com.zhss.eshop.logistics.domain.FreightTemplateDO;
import com.zhss.eshop.logistics.domain.FreightTemplateQuery;

/**
 * 运费模板管理DAO接口
 * @author zhonghuashishan
 *
 */
public interface FreightTemplateDAO {

	/**
	 * 新增运费模板
	 * @param freightTemplate 运费模板
	 */
	void save(FreightTemplateDO freightTemplate) throws Exception;
	
	/**
	 * 分页查询运费模板
	 * @param query 运费模板查询条件
	 * @return 运费模板
	 */
	List<FreightTemplateDO> listByPage(FreightTemplateQuery query) throws Exception;
	
	/**
	 * 根据id查询运费模板
	 * @param query 运费模板查询条件
	 * @return 运费模板
	 */
	FreightTemplateDO getById(Long id) throws Exception;
	
	/**
	 * 更新运费模板
	 * @param freightTemplate 运费模板
	 */
	void update(FreightTemplateDO freightTemplate) throws Exception;
	
}
