package com.zhss.eshop.commodity.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhss.eshop.commodity.domain.GoodsDTO;
import com.zhss.eshop.commodity.domain.GoodsQuery;
import com.zhss.eshop.commodity.domain.GoodsVO;
import com.zhss.eshop.commodity.service.GoodsService;
import com.zhss.eshop.common.util.ObjectUtils;

/**
 * 商品管理controller组件
 * @author zhonghuashishan
 *
 */
@RestController
@RequestMapping("/commodity/goods")  
public class GoodsController {

	private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
	
	/**
	 * 商品管理service组件
	 */
	@Autowired
	private GoodsService goodsService;
	
	/**
	 * 分页查询商品
	 * @param query 查询条件
	 * @return 商品
	 */
	@GetMapping("/") 
	public List<GoodsVO> listByPage(GoodsQuery query) {
		try {
			return ObjectUtils.convertList(goodsService.listByPage(query), GoodsVO.class);
		} catch (Exception e) {
			logger.error("error", e); 
			return new ArrayList<GoodsVO>();
		}
	}
	
	/**
	 * 根据id查询商品
	 * @param id 商品id
	 * @return 商品
	 */
	@GetMapping("/{id}")
	public GoodsVO getById(@PathVariable("id") Long id) {
		try {
			return goodsService.getById(id).clone(GoodsVO.class);
		} catch (Exception e) {
			logger.error("error", e); 
			return new GoodsVO();
		}
	}
	
	/**
	 * 新增商品
	 * @param goods 商品
	 */
	@PostMapping("/")  
	public Long save(@RequestBody GoodsVO goods) throws Exception {
		try {
			return goodsService.save(goods.clone(GoodsDTO.class));  
		} catch (Exception e) {
			logger.error("error", e); 
			return null;
		}
	}
	
	/**
	 * 更新商品
	 * @param goods 商品
	 */
	@PutMapping("/")  
	public Boolean update(@RequestBody GoodsVO goods) throws Exception {
		try {
			return goodsService.update(goods.clone(GoodsDTO.class));  
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 审核商品
	 * @param goods 商品
	 * @return 处理结果
	 * @throws Exception
	 */
	@PutMapping("/approve/{goodsId}")
	public Boolean approve(@PathVariable("goodsId") Long goodsId, Integer approveResult) {
		try {
			return goodsService.approve(goodsId, approveResult);
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 商品上架
	 * @param goods 商品
	 * @return 处理结果
	 * @throws Exception
	 */
	@PutMapping("/putOnShelves/{goodsId}") 
	public Boolean putOnShelves(@PathVariable("goodsId") Long goodsId) {
		try {
			return goodsService.putOnShelves(goodsId);
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 商品下架
	 * @param goods 商品
	 * @return 处理结果
	 * @throws Exception
	 */
	@PutMapping("/pullOffShelves/{goodsId}") 
	public Boolean pullOffShelves(@PathVariable("goodsId") Long goodsId) {
		try {
			return goodsService.pullOffShelves(goodsId);
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 商品上架
	 * @param goods 商品
	 * @return 处理结果
	 * @throws Exception
	 */
	@DeleteMapping("/{goodsId}")  
	public Boolean remove(@PathVariable("goodsId") Long goodsId) {
		try {
			return goodsService.remove(goodsId);
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
}
