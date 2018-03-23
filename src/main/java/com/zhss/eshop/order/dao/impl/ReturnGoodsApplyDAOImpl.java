package com.zhss.eshop.order.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.order.constant.ReturnGoodsApplyStatus;
import com.zhss.eshop.order.dao.ReturnGoodsApplyDAO;
import com.zhss.eshop.order.domain.ReturnGoodsApplyDO;
import com.zhss.eshop.order.mapper.ReturnGoodsApplyMapper;

/**
 * 退货申请管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class ReturnGoodsApplyDAOImpl implements ReturnGoodsApplyDAO {

	/**
	 * 退货申请管理mapper组件
	 */
	@Autowired
	private ReturnGoodsApplyMapper returnGoodsApplyMapper;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 新增退货申请
	 * @param apply 退货申请
	 */
	public void save(ReturnGoodsApplyDO apply) throws Exception {
		apply.setReturnGoodsApplyStatus(ReturnGoodsApplyStatus.WAIT_FOR_APPROVE); 
		apply.setGmtCreate(dateProvider.getCurrentTime()); 
		apply.setGmtModified(dateProvider.getCurrentTime()); 
		returnGoodsApplyMapper.save(apply); 
	}
	
	/**
	 * 根据id查询退货申请
	 * @param id 退货申请id
	 * @return 退货申请
	 */
	public ReturnGoodsApplyDO getByOrderInfoId(Long orderInfoId) throws Exception {
		return returnGoodsApplyMapper.getByOrderInfoId(orderInfoId);
	}
	
	/**
	 * 更新退货申请的状态
	 * @param apply 退货申请
	 */
	public void updateStatus(ReturnGoodsApplyDO apply) throws Exception {
		apply.setGmtModified(dateProvider.getCurrentTime()); 
		returnGoodsApplyMapper.updateStatus(apply); 
	}
	
	/**
	 * 更新退货申请的状态
	 * @param orderInfoId 订单id
	 * @param status 退货申请状态
	 * @throws Exception
	 */
	public void updateStatus(Long orderInfoId, Integer status) throws Exception {
		ReturnGoodsApplyDO apply = getByOrderInfoId(orderInfoId);
		apply.setReturnGoodsApplyStatus(status);  
		returnGoodsApplyMapper.updateStatus(apply); 
	}
	
}
