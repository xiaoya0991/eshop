package com.zhss.eshop.wms.service;

import java.util.List;

import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.wms.domain.GoodsAllcationStockDetailDTO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderDTO;
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderDTO;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderDTO;

/**
 * WMS中心接口
 * @author zhonghuashishan
 *
 */
public interface WmsService {

	/**
	 * 创建采购入库单
	 * @param purchaseInputOrderDTO 采购入库单DTO
	 * @return 处理结果
	 */
	Boolean createPurchaseInputOrder(PurchaseInputOrderDTO purchaseInputOrderDTO);
	
	/**
	 * 创建销售出库单
	 * @param saleDeliveryOrderDTO 销售出库单DTO
	 * @return 处理结果
	 */
	Boolean createSaleDeliveryOrder(SaleDeliveryOrderDTO saleDeliveryOrderDTO);
	
	/**
	 * 创建退货入库单
	 * @param returnGoodsInputOrder 退货入库单DTO
	 * @return 处理结果
	 */
	Boolean createReturnGoodsInputOrder(ReturnGoodsInputOrderDTO returnGoodsInputOrder);
	
	/**
	 * 通知WMS中心，“提交订单”事件发生了
	 * @param orderDTO 订单DTO
	 * @return 处理结果
	 */
	Boolean informSubmitOrderEvent(OrderInfoDTO orderDTO);
	
	/**
	 * 通知WMS中心，“支付订单”事件发生了
	 * @param orderDTO 订单DTO
	 * @return 处理结果
	 */
	Boolean informPayOrderEvent(OrderInfoDTO orderDTO);
	
	/**
	 * 通知WMS中心，“取消订单”事件发生了
	 * @param orderDTO 订单DTO
	 * @return 处理结果
	 */
	Boolean informCancelOrderEvent(OrderInfoDTO orderDTO);
	
	/**
	 * 根据商品sku id查询货位库存明细
	 * @param goodsSkuId 商品sku id
	 * @return 货位库存明细
	 */
	List<GoodsAllcationStockDetailDTO> listStockDetailsByGoodsSkuId(Long goodsSkuId);
	
}
