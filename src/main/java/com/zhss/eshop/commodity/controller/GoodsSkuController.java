package com.zhss.eshop.commodity.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhss.eshop.commodity.domain.GoodsSkuDTO;
import com.zhss.eshop.commodity.domain.GoodsSkuVO;
import com.zhss.eshop.commodity.service.GoodsSkuService;
import com.zhss.eshop.common.util.CloneDirection;
import com.zhss.eshop.common.util.ObjectUtils;

/**
 * 商品sku管理controller组件
 * @author zhonghuashishan
 *
 */
@RestController
@RequestMapping("/commodity/goods/sku")  
public class GoodsSkuController {

	private static final Logger logger = LoggerFactory.getLogger(GoodsSkuController.class);
	
	/**
	 * 商品sku管理service组件
	 */
	@Autowired
	private GoodsSkuService goodsSkuService;
	
	@PostMapping("/") 
	public Boolean batchSave(@RequestBody List<GoodsSkuVO> goodsSkus) {
		try {
			goodsSkuService.batchSave(ObjectUtils.convertList(
					goodsSkus, GoodsSkuDTO.class, CloneDirection.FORWARD));
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
}
