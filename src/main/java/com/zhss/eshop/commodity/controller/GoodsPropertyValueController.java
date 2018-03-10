package com.zhss.eshop.commodity.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhss.eshop.commodity.domain.GoodsPropertyValueDTO;
import com.zhss.eshop.commodity.domain.GoodsPropertyValueVO;
import com.zhss.eshop.commodity.service.GoodsPropertyValueService;
import com.zhss.eshop.common.util.ObjectUtils;

/**
 * 商品属性值管理controller组件
 * @author zhonghuashishan
 *
 */
@RestController
@RequestMapping("/commodity/goods/propertyValue") 
public class GoodsPropertyValueController {
	
	private static final Logger logger = LoggerFactory.getLogger(GoodsPropertyValueController.class);

	/**
	 * 商品属性值管理service组件
	 */
	@Autowired
	private GoodsPropertyValueService propertyValueService;
	
	/**
	 * 新增商品属性值
	 * @param goodsPropertyValue 商品属性值
	 */
	@PostMapping("/")  
	public Boolean batchSave(@RequestBody List<GoodsPropertyValueVO> propertyValues) throws Exception {
		try {
			propertyValueService.batchSave(ObjectUtils.convertList(propertyValues, 
					GoodsPropertyValueDTO.class));
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
}
