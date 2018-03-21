package com.zhss.eshop.logistics.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.logistics.dao.FreightTemplateDAO;
import com.zhss.eshop.logistics.domain.FreightTemplateDO;
import com.zhss.eshop.logistics.domain.FreightTemplateQuery;
import com.zhss.eshop.logistics.mapper.FreightTemplateMapper;

/**
 * 运费模板管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class FreightTemplateDAOImpl implements FreightTemplateDAO {
	
	/**
	 * 运费模板管理mapper组件
	 */
	@Autowired
	private FreightTemplateMapper freightTemplateMapper;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 新增运费模板
	 * @param freightTemplate 运费模板
	 */
	public void save(FreightTemplateDO freightTemplate) throws Exception {
		freightTemplate.setGmtCreate(dateProvider.getCurrentTime()); 
		freightTemplate.setGmtModified(dateProvider.getCurrentTime()); 
		freightTemplateMapper.save(freightTemplate); 
	}
	
	/**
	 * 分页查询运费模板
	 * @param query 运费模板查询条件
	 * @return 运费模板
	 */
	public List<FreightTemplateDO> listByPage(FreightTemplateQuery query) throws Exception {
		return freightTemplateMapper.listByPage(query);
	}
	
	/**
	 * 根据id查询运费模板
	 * @param query 运费模板查询条件
	 * @return 运费模板
	 */
	public FreightTemplateDO getById(Long id) throws Exception {
		return freightTemplateMapper.getById(id);
	}
	
	/**
	 * 更新运费模板
	 * @param freightTemplate 运费模板
	 */
	public void update(FreightTemplateDO freightTemplate) throws Exception {
		freightTemplateMapper.update(freightTemplate); 
	}
	
}
