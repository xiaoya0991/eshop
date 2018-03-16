package com.zhss.eshop.commodity.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhss.eshop.commodity.domain.GoodsSkuQuery;
import com.zhss.eshop.commodity.domain.GoodsSkuVO;
import com.zhss.eshop.commodity.service.GoodsSkuService;
import com.zhss.eshop.common.util.ObjectUtils;

/**
 * 商品中心接口
 * @author zhonghuashishan
 *
 */
@RestController
@RequestMapping("/commodity")  
public class CommodityController {

	private static final Logger logger = LoggerFactory.getLogger(CommodityController.class);

	/**
	 * 商品sku管理service组件
	 */
	@Autowired
	private GoodsSkuService goodsSkuService;
	
	@GetMapping("/goods/sku")  
	public List<GoodsSkuVO> listGoodsSkusByPage(GoodsSkuQuery query) {
		try {
			return ObjectUtils.convertList(goodsSkuService.listByPage(query), 
					GoodsSkuVO.class);
		} catch (Exception e) {
			logger.error("error", e); 
			return new ArrayList<GoodsSkuVO>();
		}
	}
	
}
