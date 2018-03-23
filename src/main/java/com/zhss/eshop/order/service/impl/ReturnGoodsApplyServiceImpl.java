package com.zhss.eshop.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.order.dao.ReturnGoodsApplyDAO;
import com.zhss.eshop.order.domain.ReturnGoodsApplyDTO;
import com.zhss.eshop.order.service.ReturnGoodsApplyService;

/**
 * 退货申请管理service组件
 * @author zhonghuashishan
 *
 */
@Service
@Transactional
public class ReturnGoodsApplyServiceImpl implements ReturnGoodsApplyService {

	/**
	 * 退货申请管理DAO组件
	 */
	@Autowired
	private ReturnGoodsApplyDAO returnGoodsApplyDAO;
	
	/**
	 * 根据订单id查询退货申请 
	 * @param orderInfoId 订单id
	 * @return 退货申请
	 * @throws Exception
	 */
	public ReturnGoodsApplyDTO getByOrderInfoId(Long orderInfoId) throws Exception {
		return returnGoodsApplyDAO.getByOrderInfoId(orderInfoId).clone(ReturnGoodsApplyDTO.class);
	}
	
}
