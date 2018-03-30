package com.zhss.eshop.Inventory.service.impl;

import org.springframework.stereotype.Service;

import com.zhss.eshop.Inventory.service.InventoryService;
import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderDTO;
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderDTO;

/**
 * 库存中心对外接口service组件
 * @author zhonghuashishan
 *
 */
@Service
public class InventoryServiceImpl implements InventoryService {
	
	/**
	 * 通知库存中心，“采购入库完成”事件发生了
	 * @param purchaseInputOrderDTO 采购入库单DTO
	 * @return 处理结果
	 */
	@Override
	public Boolean informPurchaseInputFinished(
			PurchaseInputOrderDTO purchaseInputOrderDTO) {
		return true;
	}
	
	/**
	 * 通知库存中心，“提交订单”事件发生了
	 * @param orderDTO 订单DTO
	 * @return 处理结果
	 */
	@Override
	public Boolean informSubmitOrderEvent(OrderInfoDTO orderDTO) {
		return true;
	}
	
	/**
	 * 通知库存中心，“支付订单”事件发生了
	 * @param orderDTO 订单DTO
	 * @return 处理结果
	 */
	@Override
	public Boolean informPayOrderEvent(OrderInfoDTO orderDTO) {
		return true;
	}
	
	/**
	 * 通知库存中心，“取消订单”事件发生了
	 * @param orderDTO 订单DTO
	 * @return 处理结果
	 */
	@Override
	public Boolean informCancelOrderEvent(OrderInfoDTO orderDTO) {
		return true;
	}
	
	/**
	 * 通知库存中心，“完成退货入库”事件发生了
	 * @param returnGoodsInputOrderDTO 退货入库单DTO
	 * @return 处理结果
	 */
	@Override
	public Boolean informReturnGoodsInputFinished(
			ReturnGoodsInputOrderDTO returnGoodsInputOrderDTO) {
		return true;
	}
	
	/**
	 * 查询商品sku的库存
	 * @param goodsSkuId 商品sku id
	 * @return 商品sku的库存
	 */
	@Override
	public Long getSaleStockQuantity(Long goodsSkuId) {
		return 1159L;
	}
	
	/**
	 * 设置销售库存
	 * @param goodsSkuId 商品sku id
	 * @param saleStockQuantity 销售库存
	 * @return 处理结果
	 */
	@Override
	public Boolean setSaleStockQuantity(Long goodsSkuId, Long saleStockQuantity) {
		return true;
	}

}
