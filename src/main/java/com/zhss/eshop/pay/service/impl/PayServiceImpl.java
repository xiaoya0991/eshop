package com.zhss.eshop.pay.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.pay.service.PayService;
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderDTO;

/**
 * 支付中心接口
 * @author zhonghuashishan
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PayServiceImpl implements PayService {

	/**
	 * 获取支付二维码
	 * @param order 订单
	 * @return 支付二维码
	 */
	@Override
	public String getQrCode(OrderInfoDTO order) {
		return null;
	}
	
	/**
	 * 进行退款
	 * @param returnGoodsInputOrder 退货入库单
	 * @return 退款结果
	 */
	@Override
	public Boolean refund(ReturnGoodsInputOrderDTO returnGoodsInputOrder) {
		return true;
	}
	
}
