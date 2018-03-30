package com.zhss.eshop.schedule.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhss.eshop.common.constant.CollectionSize;
import com.zhss.eshop.common.util.ObjectUtils;
import com.zhss.eshop.order.domain.OrderItemDTO;
import com.zhss.eshop.schedule.dao.ScheduleGoodsAllocationStockDetailDAO;
import com.zhss.eshop.schedule.dao.ScheduleOrderPickingItemDAO;
import com.zhss.eshop.schedule.dao.ScheduleOrderSendOutDetailDAO;
import com.zhss.eshop.schedule.domain.SaleDeliveryScheduleResult;
import com.zhss.eshop.schedule.domain.ScheduleGoodsAllocationStockDetailDO;
import com.zhss.eshop.schedule.domain.ScheduleOrderPickingItemDO;
import com.zhss.eshop.schedule.domain.ScheduleOrderPickingItemDTO;
import com.zhss.eshop.schedule.domain.ScheduleOrderSendOutDetailDO;
import com.zhss.eshop.schedule.domain.ScheduleOrderSendOutDetailDTO;
import com.zhss.eshop.schedule.service.SaleDeliveryScheduler;

/**
 * 销售出库调度器
 * @author zhonghuashishan
 *
 */
@Component
public class SaleDeliverySchedulerImpl implements SaleDeliveryScheduler {

	/**
	 * 调度中心的库存明细管理的DAO组件
	 */
	@Autowired
	private ScheduleGoodsAllocationStockDetailDAO stockDetailDAO;
	/**
	 * 拣货条目管理DAO组件
	 */
	@Autowired
	private ScheduleOrderPickingItemDAO pickingItemDAO;
	/**
	 * 发货明细管理DAO组件
	 */
	@Autowired
	private ScheduleOrderSendOutDetailDAO sendOutDetailDAO;
	
	/**
	 * 调度销售出库
	 * @param orderItem 订单条目
	 * @return 调度结果
	 * @throws Exception
	 */
	@Override
	public SaleDeliveryScheduleResult schedule(OrderItemDTO orderItem) throws Exception {
		// 构造好需要创建的销售出库单条目
		SaleDeliveryScheduleResult scheduleResult = new SaleDeliveryScheduleResult();
		scheduleResult.setOrderItem(orderItem); 
		
		/**
		 * 
		 * 1，商品A，A-01，2018-01-01 10:00:00，40，40
		 * 2，商品A，A-01，2018-01-01 11:00:00，60，60
		 * 3，商品A，A-02，2018-01-01 12:00:00，150，150
		 * 
		 */
		
		List<ScheduleGoodsAllocationStockDetailDO> stockDetails = 
				stockDetailDAO.listByGoodsSkuId(orderItem.getGoodsSkuId());
		
		/**
		 * 
		 * 商品A，要购买120件
		 * 
		 */
		
		Long purchaseQuantity = orderItem.getPurchaseQuantity();
		
		// 剩余要发货的数量，刚开始也是120 -> 80 -> 20
		Long remainingSendOutQuantity = purchaseQuantity;
		
		/**
		 * 
		 * 拣货条目
		 * 
		 * A-01，40 -> 40 + 60 = 100
		 * A-02, 20
		 * 
		 */
		
		Map<Long, ScheduleOrderPickingItemDTO> pickingItems = 
				new HashMap<Long, ScheduleOrderPickingItemDTO>(CollectionSize.DEFAULT);
		
		/**
		 * 
		 * 发货明细
		 * 
		 * 1，40
		 * 2，60
		 * 3，20
		 * 
		 */
		List<ScheduleOrderSendOutDetailDTO> sendOutDetails = 
				new ArrayList<ScheduleOrderSendOutDetailDTO>();
		
		for(ScheduleGoodsAllocationStockDetailDO stockDetail : stockDetails) {
			// 如果库存明细的当前库存数量就可以满足发货
			if(stockDetail.getCurrentStockQuantity() >= remainingSendOutQuantity) {
				updatePickingItem(stockDetail, orderItem.getGoodsSkuId(), 
						remainingSendOutQuantity, pickingItems); 
				updateSendOutDetail(sendOutDetails, createSendOutDetail(
						stockDetail.getId(), remainingSendOutQuantity)); 
				break;
			}
			
			// 处理拣货条目，将当前库存明细的库存全部发掉
			updatePickingItem(stockDetail, orderItem.getGoodsSkuId(), 
					stockDetail.getCurrentStockQuantity(), pickingItems);  
			
			// 处理发货明细，将当前库存明细的库存全部发掉
			updateSendOutDetail(sendOutDetails, createSendOutDetail(
					stockDetail.getId(), stockDetail.getCurrentStockQuantity())); 
			
			// 剩余发货数量进行扣减
			remainingSendOutQuantity = remainingSendOutQuantity 
					- stockDetail.getCurrentStockQuantity();
		}
		
		// 将调度好的拣货条目和发货明细，都给放到销售出库单条目中去
		scheduleResult.setPickingItems(new ArrayList<ScheduleOrderPickingItemDTO>(pickingItems.values()));
		scheduleResult.setSendOutDetails(sendOutDetails);   
		
		return scheduleResult;
	}
	
	/**
	 * 更新发货明细
	 * @param sendOutDetails
	 */
	private void updateSendOutDetail(
			List<ScheduleOrderSendOutDetailDTO> sendOutDetails,
			ScheduleOrderSendOutDetailDTO sendOutDetail) {
		sendOutDetails.add(sendOutDetail);
	}
	
	/**
	 * 更新拣货条目
	 * @param pickingItemMap 拣货条目map
	 * @param stockDetail 库存明细
	 */
	private void updatePickingItem(
			ScheduleGoodsAllocationStockDetailDO stockDetail,  
			Long goodsSkuId,
			Long pickingCount,
			Map<Long, ScheduleOrderPickingItemDTO> pickingItems) throws Exception {
		ScheduleOrderPickingItemDTO pickingItem = pickingItems.get(
				stockDetail.getGoodsAllocationId());
		if(pickingItem == null) {
			pickingItem = createPickingItem(goodsSkuId, stockDetail.getGoodsAllocationId(), 0L);
			pickingItems.put(stockDetail.getGoodsAllocationId(), pickingItem);  
		}
		pickingItem.setPickingCount(pickingItem.getPickingCount() + pickingCount);  
	}
	
	/**
	 * 创建拣货条目
	 * @param goodsAllocationId 货位id
	 * @param pickingCount 拣货数量
	 * @return 拣货条目
	 */
	private ScheduleOrderPickingItemDTO createPickingItem(Long goodsSkuId, 
			Long goodsAllocationId, Long pickingCount) throws Exception {
		ScheduleOrderPickingItemDTO pickingItem = new ScheduleOrderPickingItemDTO();
		pickingItem.setGoodsAllocationId(goodsAllocationId); 
		pickingItem.setGoodsSkuId(goodsSkuId); 
		pickingItem.setPickingCount(pickingCount);  
		return pickingItem;
	}
	
	/**
	 * 创建发货明细
	 * @param goodsAllocationStockDetailId 库存明细id
	 * @param sendOutCount 发货数量
	 * @return 发货明细
	 */
	private ScheduleOrderSendOutDetailDTO createSendOutDetail(
			Long goodsAllocationStockDetailId, Long sendOutCount) throws Exception {
		ScheduleOrderSendOutDetailDTO sendOutDetail = new ScheduleOrderSendOutDetailDTO();
		sendOutDetail.setGoodsAllocationStockDetailId(goodsAllocationStockDetailId);
		sendOutDetail.setSendOutCount(sendOutCount);
		return sendOutDetail;
	}
	
	/**
	 * 获取订单条目的调度结果
	 * @param order 订单
	 * @return 调度结果
	 * @throws Exception
	 */
	@Override
	public SaleDeliveryScheduleResult getScheduleResult(OrderItemDTO orderItem) throws Exception {
		List<ScheduleOrderPickingItemDO> pickingItems = pickingItemDAO
				.listByOrderItemId(orderItem.getOrderInfoId(), orderItem.getId());
		List<ScheduleOrderSendOutDetailDO> sendOutDetails = sendOutDetailDAO
				.listByOrderItemId(orderItem.getOrderInfoId(), orderItem.getId());
		
		SaleDeliveryScheduleResult scheduleResult = new SaleDeliveryScheduleResult();
		scheduleResult.setOrderItem(orderItem); 
		scheduleResult.setPickingItems(ObjectUtils.convertList(
				pickingItems, ScheduleOrderPickingItemDTO.class));   
		scheduleResult.setSendOutDetails(ObjectUtils.convertList(
				sendOutDetails, ScheduleOrderSendOutDetailDTO.class)); 
		
		return scheduleResult;
	}
	
}
