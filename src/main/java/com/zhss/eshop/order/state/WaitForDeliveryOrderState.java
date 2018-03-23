package com.zhss.eshop.order.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.order.constant.OrderStatus;
import com.zhss.eshop.order.dao.OrderInfoDAO;
import com.zhss.eshop.order.domain.OrderInfoDO;
import com.zhss.eshop.order.domain.OrderInfoDTO;

/**
 * 待发货状态
 * @author zhonghuashishan
 *
 */
@Component
public class WaitForDeliveryOrderState implements OrderState {

	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	/**
	 * 订单管理DAO组件
	 */
	@Autowired
	private OrderInfoDAO orderInfoDAO;
	
	/**
	 * 订单流转到当前这个状态
	 * @param order 订单
	 */
	public void doTransition(OrderInfoDTO order) throws Exception {
		order.setOrderStatus(OrderStatus.WAIT_FOR_DELIVERY); 
		order.setGmtModified(dateProvider.getCurrentTime()); 
		orderInfoDAO.updateStatus(order.clone(OrderInfoDO.class)); 
	}
	
	/**
	 * 判断当前状态下能否执行取消订单操作
	 * @param order 订单
	 * @return 能否执行取消订单操作
	 */
	public Boolean canCancel(OrderInfoDTO order) throws Exception {
		// 就是我们用状态模式的好处，我告诉各位同学，对于类似订单这样状态季度复杂的场景来说，非常合适的
		// 我们可以将复杂的状态流转和状态判断等逻辑，都用非常清晰的语义和结构封装起来
		// 非常利于未来进行状态逻辑修改的维护
		// 举个例子，比如说，我们现在是说待发货的状态，是不允许取消订单的
		// 但是如果以后，我们又要允许待发货的状态，可以取消订单，那么是不是直接在这个state里面修改一下这里的
		// 返回值就可以了
		// 如果我们需要根据订单的具体情况来判断能否允许取消，那么我们这里是不是接收了order这个对象啊
		return false;
	}
	
	/**
	 * 判断订单能否执行支付操作
	 * @param order 订单
	 * @return 能否执行支付操作
	 * @throws Exception
	 */
	public Boolean canPay(OrderInfoDTO order) throws Exception {
		return false;
	}
	
	/**
	 * 判断能否执行手动确认收货的操作
	 * @param order 订单
	 * @return 能否执行手动确认收货的操作
	 * @throws Exception
	 */
	public Boolean canConfirmReceipt(OrderInfoDTO order) throws Exception {
		return false;
	}
	
	/**
	 * 判断能否申请退货
	 * @param order 订单
	 * @return 能否申请退货
	 * @throws Exception
	 */
	public Boolean canApplyReturnGoods(OrderInfoDTO order) throws Exception {
		return false;
	}
	
}
