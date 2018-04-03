package com.zhss.eshop.wms.controller;

import java.util.ArrayList;
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
import com.zhss.eshop.wms.domain.GoodsAllocationDTO;
import com.zhss.eshop.wms.domain.GoodsAllocationQuery;
import com.zhss.eshop.wms.domain.GoodsAllocationVO;
import com.zhss.eshop.wms.service.GoodsAllocationService;

/**
 * 货位管理controller组件
 * @author zhonghuashishan
 *
 */
@RestController
@RequestMapping("/wms/goods/allocation")  
public class GoodsAllocationController {
	
	private static final Logger logger = LoggerFactory.getLogger(GoodsAllocationController.class);

	/**
	 * 货位管理service组件
	 */
	@Autowired
	private GoodsAllocationService goodsAllocationService;
	
	/**
	 * 分页查询货位
	 * @param query 查询条件
	 * @return 货位
	 */
	@GetMapping("/") 
	public List<GoodsAllocationVO> listByPage(GoodsAllocationQuery query) {
		try {
			return ObjectUtils.convertList(
					goodsAllocationService.listByPage(query), 
					GoodsAllocationVO.class); 
		} catch (Exception e) {
			logger.error("error", e);
			return new ArrayList<GoodsAllocationVO>();
		}
	}
	
	/**
	 * 新增货位
	 * @param goodsAllocation 货位
	 */
	@PostMapping("/") 
	public Boolean save(@RequestBody GoodsAllocationVO goodsAllocation) {
		try {
			goodsAllocationService.save(goodsAllocation.clone(GoodsAllocationDTO.class));   
			return true;
		} catch (Exception e) {
			logger.error("error", e);
			return false;
		}
	}
	
	/**
	 * 根据id查询货位
	 * @param id 货位id
	 * @return 货位
	 */
	@GetMapping("/{id}")
	public GoodsAllocationVO getById(@PathVariable("id") Long id) {
		try {
			return goodsAllocationService.getById(id).clone(GoodsAllocationVO.class);
		} catch (Exception e) {
			logger.error("error", e); 
			return null;
		}
	}
	
	/**
	 * 更新货位
	 * @param goodsAllocation 货位
	 */
	@PutMapping("/{id}")  
	public Boolean update(@RequestBody GoodsAllocationVO goodsAllocation) {
		try {
			goodsAllocationService.update(goodsAllocation.clone(GoodsAllocationDTO.class));  
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
}
