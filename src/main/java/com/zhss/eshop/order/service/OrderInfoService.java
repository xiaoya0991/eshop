package com.zhss.eshop.order.service;

import java.util.List;

import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.order.domain.OrderInfoQuery;
import com.zhss.eshop.promotion.domain.CouponDTO;

/**
 * 订单管理service组件
 * @author zhonghuashishan
 *
 */
public interface OrderInfoService {

	/**
	 * 计算订单价格
	 * @param order 订单
	 */
	OrderInfoDTO calculateOrderPrice(OrderInfoDTO order);
	
	/**
	 * 计算优惠券抵扣的金额
	 * @param order 
	 * @param coupon
	 * @return
	 */
	OrderInfoDTO calculateCouponDiscountPrice(
			OrderInfoDTO order, CouponDTO coupon);
	
	/**
	 * 新增一个订单
	 * @param order
	 */
	OrderInfoDTO save(OrderInfoDTO order) throws Exception;
	
	/**
	 * 分页查询订单
	 * @param query 查询条件 
	 * @return 订单
	 * @throws Exception
	 */
	List<OrderInfoDTO> listByPage(OrderInfoQuery query) throws Exception;
	
	/**
	 * 根据id查询订单
	 * @param id 订单id
	 * @return 订单
	 * @throws Exception
	 */
	OrderInfoDTO getById(Long id) throws Exception;
	
	/**
	 * 取消订单
	 * @param id 订单id
	 * @return 处理结果
	 * @throws Exception
	 */
	Boolean cancel(Long id) throws Exception;
	
}
