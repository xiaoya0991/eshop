package com.zhss.eshop.logistics.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhss.eshop.common.util.ObjectUtils;
import com.zhss.eshop.logistics.domain.FreightTemplateDTO;
import com.zhss.eshop.logistics.domain.FreightTemplateQuery;
import com.zhss.eshop.logistics.domain.FreightTemplateVO;
import com.zhss.eshop.logistics.service.FreightTemplateService;

/**
 * 运费模板管理controller组件
 * @author zhonghuashishan
 *
 */
@RestController
@RequestMapping("/logistics/freightTemplate")  
public class FreightTemplateController {

	private static final Logger logger = LoggerFactory.getLogger(
			FreightTemplateController.class);
	
	/**
	 * 运费模板管理service组件
	 */
	@Autowired
	private FreightTemplateService freightTemplateService;
	
	/**
	 * 新增运费模板
	 * @param freightTemplate 运费模板
	 */
	@PostMapping("/")  
	public Boolean save(@RequestBody FreightTemplateVO freightTemplate) {
		try {
			freightTemplateService.save(freightTemplate.clone(FreightTemplateDTO.class));  
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 分页查询运费模板
	 * @param query 运费模板查询条件
	 * @return 运费模板
	 */
	@GetMapping("/")  
	public List<FreightTemplateVO> listByPage(FreightTemplateQuery query) {
		try {
			return ObjectUtils.convertList(
					freightTemplateService.listByPage(query), 
					FreightTemplateVO.class);
		} catch (Exception e) {
			logger.error("error", e); 
			return null;
		}
	}
	
	/**
	 * 根据id查询运费模板
	 * @param query 运费模板查询条件
	 * @return 运费模板
	 */
	@GetMapping("/{id}") 
	public FreightTemplateVO getById(@PathVariable("id") Long id) {
		try {
			return freightTemplateService.getById(id).clone(FreightTemplateVO.class);
		} catch (Exception e) {
			logger.error("error", e);
			return null;
		}
	}
	
	/**
	 * 更新运费模板
	 * @param freightTemplate 运费模板
	 */
	@PutMapping("/{id}")  
	public Boolean update(@RequestBody FreightTemplateVO freightTemplate) {
		try {
			freightTemplateService.update(freightTemplate.clone(FreightTemplateDTO.class));  
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
}
