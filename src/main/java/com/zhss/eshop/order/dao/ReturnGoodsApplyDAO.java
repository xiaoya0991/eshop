package com.zhss.eshop.order.dao;

import com.zhss.eshop.order.domain.ReturnGoodsApplyDO;

/**
 * 退货申请管理DAO接口
 * @author zhonghuashishan
 *
 */
public interface ReturnGoodsApplyDAO {

	/**
	 * 新增退货申请
	 * @param apply 退货申请
	 */
	void save(ReturnGoodsApplyDO apply) throws Exception;
	
	/**
	 * 根据id查询退货申请
	 * @param id 退货申请id
	 * @return 退货申请
	 */
	ReturnGoodsApplyDO getByOrderInfoId(Long orderInfoId) throws Exception;
	
	/**
	 * 更新退货申请
	 * @param apply 退货申请
	 */
	void update(ReturnGoodsApplyDO apply) throws Exception;
	
	/**
	 * 更新退货申请的状态
	 * @param orderInfoId 订单id
	 * @param returnGoodsApplyStatus 退货申请状态
	 * @throws Exception
	 */
	void updateStatus(Long orderInfoId, Integer returnGoodsApplyStatus) throws Exception;

}
