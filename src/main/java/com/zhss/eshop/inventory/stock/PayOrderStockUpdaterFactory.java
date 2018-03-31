package com.zhss.eshop.inventory.stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhss.eshop.inventory.dao.GoodsStockDAO;
import com.zhss.eshop.common.constant.CollectionSize;
import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.inventory.domain.GoodsStockDO;
import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.order.domain.OrderItemDTO;

/**
 * 支付订单库存更新组件工厂
 * @author zhonghuashishan
 *
 */
@Component
public class PayOrderStockUpdaterFactory<T> 
		extends AbstractStockUpdaterFactory<T> {

	/**
	 * 构造函数
	 * @param goodsStockDAO 商品库存管理模块DAO组件
	 * @param dateProvider 日期辅助组件
	 */
	@Autowired
	public PayOrderStockUpdaterFactory(
			GoodsStockDAO goodsStockDAO, 
			DateProvider dateProvider) {  
		super(goodsStockDAO, dateProvider);
	}
	
	/**
	 * 获取要更新库存的商品sku id的集合
	 */
	@Override
	protected List<Long> getGoodsSkuIds(T parameter) throws Exception {
		OrderInfoDTO orderInfoDTO = (OrderInfoDTO) parameter;
		
		List<Long> goodsSkuIds = new ArrayList<Long>();
		
		List<OrderItemDTO> orderItemDTOs = orderInfoDTO.getOrderItems();
		for(OrderItemDTO orderItemDTO : orderItemDTOs) {
			goodsSkuIds.add(orderItemDTO.getGoodsSkuId());
		}
		
		return goodsSkuIds;
	}

	/**
	 * 创建商品库存更新组件
	 * @param goodsStockDOs 商品库存DO对象集合
	 * @param parameter 订单DTO对象
	 * @return 商品库存更新组件
	 */
	@Override
	protected StockUpdater create(List<GoodsStockDO> goodsStockDOs, 
			T parameter) throws Exception {
		OrderInfoDTO orderInfoDTO = (OrderInfoDTO) parameter;
		
		Map<Long, OrderItemDTO> orderItemDTOMap = new HashMap<Long, OrderItemDTO>(CollectionSize.DEFAULT);
		for(OrderItemDTO orderItemDTO : orderInfoDTO.getOrderItems()) {
			orderItemDTOMap.put(orderItemDTO.getGoodsSkuId(), orderItemDTO);
		}
		
		return new PayOrderStockUpdater(goodsStockDOs, goodsStockDAO, 
				dateProvider, orderItemDTOMap);
	} 

}
