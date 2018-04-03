package com.zhss.eshop.commodity.controller;

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

import com.zhss.eshop.commodity.domain.GoodsDetailDTO;
import com.zhss.eshop.commodity.domain.GoodsDetailVO;
import com.zhss.eshop.commodity.service.GoodsDetailService;

/**
 * 商品详情管理controller组件
 * @author zhonghuashishan
 *
 */
@RestController
@RequestMapping("/commodity/goods/detail")  
public class GoodsDetailController {
	
	private static final Logger logger = LoggerFactory.getLogger(GoodsDetailController.class);

	/**
	 * 商品详情管理service组件
	 */
	@Autowired
	private GoodsDetailService goodsDetailService;
	
	/**
	 * 根据商品id查询商品详情
	 * @param goodsId 商品id
	 * @return 商品详情
	 */
	@GetMapping("/{goodsId}")   
	public GoodsDetailVO getByGoodsId(@PathVariable("goodsId") Long goodsId) throws Exception {
		try {
			return goodsDetailService.getByGoodsId(goodsId).clone(GoodsDetailVO.class);
		} catch (Exception e) {
			logger.error("error", e); 
			return new GoodsDetailVO();
		}
	}

	/**
	 * 新增商品详情
	 * @param goodsDetail 商品详情
	 * @return 商品详情id
	 * @throws Exception
	 */
	@PostMapping("/") 
	public Long save(@RequestBody GoodsDetailVO goodsDetail) throws Exception {
		try {
			return goodsDetailService.save(goodsDetail.clone(GoodsDetailDTO.class));  
		} catch (Exception e) {
			logger.error("error", e); 
			return null;
		}
	}
	
	/**
	 * 更新商品详情
	 * @param goodsDetail 商品详情
	 * @throws Exception 
	 */
	@PutMapping("/{id}")  
	public Boolean update(@RequestBody GoodsDetailVO goodsDetail) throws Exception {
		try {
			goodsDetailService.update(goodsDetail.clone(GoodsDetailDTO.class));   
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
}
