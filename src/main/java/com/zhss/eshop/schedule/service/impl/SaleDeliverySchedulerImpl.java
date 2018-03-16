package com.zhss.eshop.schedule.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.order.domain.OrderItemDTO;
import com.zhss.eshop.wms.domain.GoodsAllocationStockDetailDTO;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderItemDTO;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderPickingItemDTO;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderSendOutDetailDTO;
import com.zhss.eshop.wms.service.WmsService;

/**
 * 销售出库调度器
 * @author zhonghuashishan
 *
 */
@Component
public class SaleDeliverySchedulerImpl implements SaleDeliveryScheduler {

	/**
	 * wms中心接口
	 */
	@Autowired
	private WmsService wmsService;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 对订单条目进行发货调度
	 * @param orderItem 订单条目
	 * @return 销售出库单条目
	 */
	public SaleDeliveryOrderItemDTO schedule(OrderItemDTO orderItem) throws Exception {
		// 构造好需要创建的销售出库单条目
		SaleDeliveryOrderItemDTO saleDeliveryOrderItem = new SaleDeliveryOrderItemDTO();
		saleDeliveryOrderItem.setGoodsSkuId(orderItem.getGoodsSkuId()); 
		
		/**
		 * 
		 * 1，商品A，A-01，2018-01-01 10:00:00，40，40
		 * 2，商品A，A-01，2018-01-01 11:00:00，60，60
		 * 3，商品A，A-02，2018-01-01 12:00:00，150，150
		 * 
		 */
		
		List<GoodsAllocationStockDetailDTO> stockDetails = 
				wmsService.listStockDetailsByGoodsSkuId(orderItem.getGoodsSkuId());
		
		/**
		 * 
		 * 商品A，要购买120件
		 * 
		 */
		
		Long purchaseQuantity = orderItem.getPurchaseQuantity();
		
		// 剩余要发货的数量，刚开始也是120 -> 80 -> 20
		Long restSendOutQuantity = purchaseQuantity;
		
		/**
		 * 
		 * 拣货条目
		 * 
		 * A-01，40 -> 40 + 60 = 100
		 * A-02, 20
		 * 
		 */
		
		Map<Long, SaleDeliveryOrderPickingItemDTO> pickingItemMap = 
				new HashMap<Long, SaleDeliveryOrderPickingItemDTO>();
		
		/**
		 * 
		 * 发货明细
		 * 
		 * 1，40
		 * 2，60
		 * 3，20
		 * 
		 */
		List<SaleDeliveryOrderSendOutDetailDTO> sendOutDetails = 
				new ArrayList<SaleDeliveryOrderSendOutDetailDTO>();
		
		for(GoodsAllocationStockDetailDTO stockDetail : stockDetails) {
			// 如果当前库存明细的剩余库存数量就可以满足发货
			if(stockDetail.getCurrentStockQuantity() >= restSendOutQuantity) {
				updatePickingItem(orderItem.getGoodsSkuId(), 
						pickingItemMap, stockDetail, restSendOutQuantity); 
				updateSendOutDetail(sendOutDetails, createSendOutDetail(
						stockDetail.getId(), restSendOutQuantity));
				break;
			}
			
			// 处理拣货条目，将当前库存明细的库存全部发掉
			updatePickingItem(orderItem.getGoodsSkuId(), 
					pickingItemMap, stockDetail, stockDetail.getCurrentStockQuantity());  
			
			// 处理发货明细，将当前库存明细的库存全部发掉
			updateSendOutDetail(sendOutDetails, createSendOutDetail(
					stockDetail.getId(), stockDetail.getCurrentStockQuantity())); 
			
			// 剩余发货数量进行扣减
			restSendOutQuantity = restSendOutQuantity - stockDetail.getCurrentStockQuantity();
		}
		
		// 将调度好的拣货条目和发货明细，都给放到销售出库单条目中去
		saleDeliveryOrderItem.setPickingItems(new ArrayList<SaleDeliveryOrderPickingItemDTO>(
				pickingItemMap.values()));
		saleDeliveryOrderItem.setSendOutItems(sendOutDetails); 
		
		return saleDeliveryOrderItem;
	}
	
	/**
	 * 更新发货明细
	 * @param sendOutDetails
	 */
	private void updateSendOutDetail(List<SaleDeliveryOrderSendOutDetailDTO> sendOutDetails,
			SaleDeliveryOrderSendOutDetailDTO sendOutDetail) {
		sendOutDetails.add(sendOutDetail);
	}
	
	/**
	 * 更新拣货条目
	 * @param pickingItemMap 拣货条目map
	 * @param stockDetail 库存明细
	 */
	private void updatePickingItem(Long goodsSkuId, 
			Map<Long, SaleDeliveryOrderPickingItemDTO> pickingItemMap, 
			GoodsAllocationStockDetailDTO stockDetail, Long pickingCount) throws Exception {
		SaleDeliveryOrderPickingItemDTO pickingItem = pickingItemMap.get(
				stockDetail.getGoodsAllocationId());
		
		if(pickingItem == null) {
			pickingItem = createPickingItem(goodsSkuId, stockDetail.getGoodsAllocationId(), 0L);
			pickingItemMap.put(stockDetail.getGoodsAllocationId(), pickingItem);  
		}
		
		pickingItem.setPickingCount(pickingItem.getPickingCount() + pickingCount);  
	}
	
	/**
	 * 创建拣货条目
	 * @param goodsAllocationId 货位id
	 * @param pickingCount 拣货数量
	 * @return 拣货条目
	 */
	private SaleDeliveryOrderPickingItemDTO createPickingItem(
			Long goodsSkuId, Long goodsAllocationId, Long pickingCount) throws Exception {
		SaleDeliveryOrderPickingItemDTO pickingItem = new SaleDeliveryOrderPickingItemDTO();
		pickingItem.setGoodsAllocationId(goodsAllocationId); 
		pickingItem.setGoodsSkuId(goodsSkuId); 
		pickingItem.setPickingCount(pickingCount);  
		pickingItem.setGmtCreate(dateProvider.getCurrentTime());
		pickingItem.setGmtModified(dateProvider.getCurrentTime()); 
		return pickingItem;
	}
	
	/**
	 * 创建发货明细
	 * @param goodsAllocationStockDetailId 库存明细id
	 * @param sendOutCount 发货数量
	 * @return 发货明细
	 */
	private SaleDeliveryOrderSendOutDetailDTO createSendOutDetail(
			Long goodsAllocationStockDetailId, Long sendOutCount) throws Exception {
		SaleDeliveryOrderSendOutDetailDTO sendOutDetail = new SaleDeliveryOrderSendOutDetailDTO();
		sendOutDetail.setGoodsAllocationStockDetailId(goodsAllocationStockDetailId);
		sendOutDetail.setSendOutCount(sendOutCount);
		sendOutDetail.setGmtCreate(dateProvider.getCurrentTime());
		sendOutDetail.setGmtModified(dateProvider.getCurrentTime()); 
		return sendOutDetail;
	}
	
}
