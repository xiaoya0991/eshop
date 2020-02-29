package com.zhss.eshop.order.service;

import com.zhss.eshop.order.domain.bo.CancelBO;
import com.zhss.eshop.order.domain.bo.CreateBO;
import com.zhss.eshop.order.domain.bo.UpdateReturnGoodsLogisticCodeBO;
import java.util.List;

import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.order.domain.OrderInfoQuery;
import com.zhss.eshop.order.domain.ReturnGoodsApplyDTO;
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
	 * @return 订单
	 * @throws Exception
	 */
	OrderInfoDTO calculateOrderPrice(OrderInfoDTO order) throws Exception;
	
	/**
	 * 计算优惠券抵扣的金额
	 * @param order 订单
	 * @param coupon 优惠券
	 * @return 抵扣金额
	 * @throws Exception
	 */
	OrderInfoDTO calculateCouponDiscountPrice(
			OrderInfoDTO order, CouponDTO coupon) throws Exception;
	
	/**
	 * 新增一个订单
	 * @param orderInfoDTO 订单
	 * @return 订单
	 * @throws Exception
	 */
	CreateBO create(OrderInfoDTO orderInfoDTO);
	
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
	CancelBO cancel(Long id);
	
	/**
	 * 支付订单
	 * @param id 订单id
	 * @return 支付二维码
	 * @throws Exception
	 */
	String pay(Long id) throws Exception;
	
	/**
	 * 手动确认收货
	 * @param id 订单id
	 * @return 处理结果
	 * @throws Exception
	 */
	Boolean manualConfirmReceipt(Long id) throws Exception;
	
	/**
	 * 申请退货
	 * @param apply 退货申请
	 * @return 处理结果
	 * @throws Exception
	 */
	Boolean applyReturnGoods(ReturnGoodsApplyDTO apply) throws Exception;
	
	/**
	 * 根据订单id查询退货申请 
	 * @param orderInfoId 订单id
	 * @return 退货申请
	 * @throws Exception
	 */
	ReturnGoodsApplyDTO getByOrderInfoId(Long orderInfoId) throws Exception;
	
	/**
	 * 更新退货物流单号
	 * @param orderInfoId 订单id
	 * @param returnGoodsLogisticCode 退货物流单号
	 * @throws Exception
	 */
	UpdateReturnGoodsLogisticCodeBO updateReturnGoodsLogisticCode(Long orderInfoId,
			String returnGoodsLogisticCode);
	
	/**
	 * 更新订单
	 * @param order 订单
	 * @throws Exception 
	 */
	void update(OrderInfoDTO order) throws Exception;
	
	/**
	 * 查询确认收货时间超过了7天而且还没有发表评论的订单
	 * @return 订单
	 * @throws Exception
	 */
	List<OrderInfoDTO> listNotPublishedCommentOrders() throws Exception; 
	
}
