package com.zhss.eshop.logistics.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.common.util.ObjectUtils;
import com.zhss.eshop.logistics.dao.FreightTemplateDAO;
import com.zhss.eshop.logistics.domain.FreightTemplateDO;
import com.zhss.eshop.logistics.domain.FreightTemplateDTO;
import com.zhss.eshop.logistics.domain.FreightTemplateQuery;
import com.zhss.eshop.logistics.service.FreightTemplateService;

/**
 * 运费模板管理service组件
 * @author zhonghuashishan
 *
 */
@Service
@Transactional
public class FreightTemplateServiceImpl implements FreightTemplateService {

	/**
	 * 运费模板管理DAO组件
	 */
	@Autowired
	private FreightTemplateDAO freightTemplateDAO;
	
	/**
	 * 新增运费模板
	 * @param freightTemplate 运费模板
	 */
	public void save(FreightTemplateDTO freightTemplate) throws Exception {
		freightTemplateDAO.save(freightTemplate.clone(FreightTemplateDO.class));   
	}
	
	/**
	 * 分页查询运费模板
	 * @param query 运费模板查询条件
	 * @return 运费模板
	 */
	public List<FreightTemplateDTO> listByPage(FreightTemplateQuery query) throws Exception {
		return ObjectUtils.convertList(
				freightTemplateDAO.listByPage(query), 
				FreightTemplateDTO.class);
	}
	
	/**
	 * 根据id查询运费模板
	 * @param query 运费模板查询条件
	 * @return 运费模板
	 */
	public FreightTemplateDTO getById(Long id) throws Exception {
		return freightTemplateDAO.getById(id).clone(FreightTemplateDTO.class);
	}
	
	/**
	 * 更新运费模板
	 * @param freightTemplate 运费模板
	 */ 
	public void update(FreightTemplateDTO freightTemplate) throws Exception {
		freightTemplateDAO.update(freightTemplate.clone(FreightTemplateDO.class)); 
	}
	
}
