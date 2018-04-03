package com.zhss.eshop.wms.controller;

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

import com.zhss.eshop.common.util.CloneDirection;
import com.zhss.eshop.common.util.ObjectUtils;
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderDTO;
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderQuery;
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderVO;
import com.zhss.eshop.wms.service.ReturnGoodsInputOrderService;

/**
 * 退货入库单管理controller组件
 * @author zhonghuashishan
 *
 */
@RestController
@RequestMapping("/wms/returnGoodsInputOrder") 
public class ReturnGoodsInputOrderController {

	private static final Logger logger = LoggerFactory.getLogger(ReturnGoodsInputOrderController.class);
	
	/**
	 * 退货入库单管理service组件
	 */
	@Autowired
	private ReturnGoodsInputOrderService returnGoodsInputOrderService;
	
	/**
	 * 分页查询退货入库单
	 * @param query 查询条件
	 * @return 退货入库单
	 */
	@GetMapping("/")  
	public List<ReturnGoodsInputOrderVO> listByPage(ReturnGoodsInputOrderQuery query) {
		try {
			return ObjectUtils.convertList(
					returnGoodsInputOrderService.listByPage(query), 
					ReturnGoodsInputOrderVO.class);
		} catch (Exception e) {
			logger.error("error", e); 
			return null;
		}
	}
	
	/**
	 * 根据id查询退货入库单
	 * @param id 退货入库单id
	 * @return 退货入库单
	 * @throws Exception
	 */
	@GetMapping("/{id}") 
	public ReturnGoodsInputOrderVO getById(@PathVariable("id") Long id) {
		try {
			return returnGoodsInputOrderService.getById(id)
					.clone(ReturnGoodsInputOrderVO.class, CloneDirection.OPPOSITE);
		} catch (Exception e) {
			logger.error("error", e); 
			return null;
		}
	}
	
	/**
	 * 更新退货入库单
	 * @param returnGoodsInputOrder 退货入库单
	 * @throws Exception 
	 */
	@PutMapping("/{id}")  
	public Boolean update(@RequestBody ReturnGoodsInputOrderVO returnGoodsInputOrder) {
		try {
			returnGoodsInputOrderService.update(returnGoodsInputOrder.clone(
					ReturnGoodsInputOrderDTO.class, CloneDirection.FORWARD)); 
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 批量新增退货入库单上架条目
	 * @param putOnItems 上架条目
	 * @throws Exception
	 */
	@PostMapping("/putOnItem/{id}")    
	public Boolean batchSavePutOnItems(@RequestBody ReturnGoodsInputOrderVO returnGoodsInputOrder) {
		try {
			returnGoodsInputOrderService.batchSavePutOnItems(returnGoodsInputOrder.clone(
					ReturnGoodsInputOrderDTO.class, CloneDirection.FORWARD)); 
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 退货入库单提交审核
	 * @param id 退货入库单id
	 * @throws Exception
	 */
	@PutMapping("/submitApprove/{id}")  
	public Boolean submitApprove(@PathVariable("id") Long id) {
		try {
			returnGoodsInputOrderService.submitApprove(id); 
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 审核退货入库单
	 * @param id 退货入库单id
	 * @throws Exception
	 */
	@PutMapping("/approve/{id}")  
	public Boolean approve(@PathVariable("id") Long id, Integer approveResult) {
		try {
			returnGoodsInputOrderService.approve(id, approveResult);
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
}
