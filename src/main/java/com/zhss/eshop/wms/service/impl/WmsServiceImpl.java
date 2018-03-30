package com.zhss.eshop.wms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.schedule.domain.SaleDeliveryScheduleResult;
import com.zhss.eshop.wms.domain.GoodsAllocationStockDetailDTO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderDTO;
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderDTO;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderDTO;
import com.zhss.eshop.wms.service.WmsService;

/**
 * wms中心对外接口service组件
 * @author zhonghuashishan
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WmsServiceImpl implements WmsService {
	
	private static final Logger logger = LoggerFactory.getLogger(WmsServiceImpl.class);
	
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 创建采购入库单
	 * @param purchaseInputOrderDTO 采购入库单DTO
	 * @return 处理结果
	 */
	@Override
	public Boolean createPurchaseInputOrder(PurchaseInputOrderDTO purchaseInputOrderDTO) {
		return true;
	}
	
	/**
	 * 创建销售出库单
	 * @param saleDeliveryOrderDTO 销售出库单DTO
	 * @return 处理结果
	 */
	@Override
	public Boolean createSaleDeliveryOrder(SaleDeliveryOrderDTO saleDeliveryOrder) {
		return true;
	}
	
	/**
	 * 创建退货入库单
	 * @param returnGoodsInputOrder 退货入库单DTO
	 * @return 处理结果
	 */
	@Override
	public Boolean createReturnGoodsInputOrder(ReturnGoodsInputOrderDTO returnGoodsInputOrder) {
		return true;
	}
	
	/**
	 * 通知WMS中心，“提交订单”事件发生了
	 * @param orderDTO 订单DTO
	 * @return 处理结果
	 */
	@Override
	public Boolean informSubmitOrderEvent(SaleDeliveryScheduleResult scheduleResult) {
		return true;
	}
	
	/**
	 * 通知WMS中心，“支付订单”事件发生了
	 * @param orderDTO 订单DTO
	 * @return 处理结果
	 */
	@Override
	public Boolean informPayOrderEvent(SaleDeliveryScheduleResult scheduleResult) {
		return true;
	}
	
	/**
	 * 通知WMS中心，“取消订单”事件发生了
	 * @param orderDTO 订单DTO
	 * @return 处理结果
	 */
	@Override
	public Boolean informCancelOrderEvent(SaleDeliveryScheduleResult scheduleResult) {
		return true;
	}
	
	/**
	 * 根据商品sku id查询货位库存明细
	 * @param goodsSkuId 商品sku id
	 * @return 货位库存明细
	 */
	@Override
	public List<GoodsAllocationStockDetailDTO> listStockDetailsByGoodsSkuId(Long goodsSkuId) {
		List<GoodsAllocationStockDetailDTO> stockDetails = 
				new ArrayList<GoodsAllocationStockDetailDTO>();
		
		try {
			GoodsAllocationStockDetailDTO stockDetail1 = new GoodsAllocationStockDetailDTO();
			stockDetail1.setId(1L); 
			stockDetail1.setGoodsSkuId(goodsSkuId); 
			stockDetail1.setGoodsAllocationId(1L); 
			stockDetail1.setPutOnTime(dateProvider.parseDatetime("2018-01-01 10:00:00"));  
			stockDetail1.setPutOnQuantity(40L);
			stockDetail1.setCurrentStockQuantity(40L); 
			stockDetail1.setGmtCreate(dateProvider.getCurrentTime()); 
			stockDetail1.setGmtModified(dateProvider.getCurrentTime()); 
			stockDetails.add(stockDetail1);
			
			GoodsAllocationStockDetailDTO stockDetail2 = new GoodsAllocationStockDetailDTO();
			stockDetail2.setId(2L); 
			stockDetail2.setGoodsSkuId(goodsSkuId); 
			stockDetail2.setGoodsAllocationId(1L); 
			stockDetail2.setPutOnTime(dateProvider.parseDatetime("2018-01-01 11:00:00"));  
			stockDetail2.setPutOnQuantity(60L);
			stockDetail2.setCurrentStockQuantity(60L); 
			stockDetail2.setGmtCreate(dateProvider.getCurrentTime()); 
			stockDetail2.setGmtModified(dateProvider.getCurrentTime()); 
			stockDetails.add(stockDetail2);
			
			GoodsAllocationStockDetailDTO stockDetail3 = new GoodsAllocationStockDetailDTO();
			stockDetail3.setId(3L); 
			stockDetail3.setGoodsSkuId(goodsSkuId); 
			stockDetail3.setGoodsAllocationId(2L); 
			stockDetail3.setPutOnTime(dateProvider.parseDatetime("2018-01-01 12:00:00"));  
			stockDetail3.setPutOnQuantity(150L);
			stockDetail3.setCurrentStockQuantity(150L); 
			stockDetail3.setGmtCreate(dateProvider.getCurrentTime()); 
			stockDetail3.setGmtModified(dateProvider.getCurrentTime()); 
			stockDetails.add(stockDetail3);
		} catch (Exception e) {
			logger.error("error", e); 
		}
		
		return stockDetails;
	}
	
	/**
	 * 获取订单对应的物流单号 
	 * @param orderId 订单id
	 * @return 物流单号
	 */
	@Override
	public String getLogisticCode(Long orderId) {
		return null;
	}
	
	/**
	 * 通知wms中心，“创建采购结算单”事件发生了
	 * @param purchaseInputOrderId 采购入库单id
	 * @return 处理结果
	 */
	@Override
	public Boolean informCreatePurchaseSettlementOrderEvent(Long purchaseInputOrderId) {
		return true;
	}
	
	/**
	 * 通知wms中心，“完成采购结算单”事件发生了
	 * @param purchaseInputOrderId 采购入库单id
	 * @return 处理结果
	 */
	@Override
	public Boolean informFinishedPurchaseSettlementOrderEvent(Long purchaseInputOrderId) {
		return true;
	}

}
