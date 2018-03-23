package com.zhss.eshop.order.service;

import com.zhss.eshop.order.domain.ReturnGoodsApplyDTO;

/**
 * 退货申请管理service接口
 * @author zhonghuashishan
 *
 */
public interface ReturnGoodsApplyService {

	/**
	 * 根据订单id查询退货申请 
	 * @param orderInfoId 订单id
	 * @return 退货申请
	 * @throws Exception
	 */
	ReturnGoodsApplyDTO getByOrderInfoId(Long orderInfoId) throws Exception;
	
}
