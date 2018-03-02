package com.zhss.eshop.membership.service.impl;

import org.springframework.stereotype.Service;

import com.zhss.eshop.membership.service.MembershipFacadeService;

/**
 * 会员中心对外接口service组件
 * @author zhonghuashishan
 *
 */
@Service
public class MembershipFacadeServiceImpl implements MembershipFacadeService {
	
	/**
	 * 通知会员中心，“用户今日第一次登录”事件发生了
	 * @param userAccountId 用户账号ID
	 * @return 处理结果
	 */
	public Boolean informFirstLoginDailyEvent(Long userAccountId) {
		return true;
	}
	
	/**
	 * 通知会员中心，“支付订单”事件发生了
	 * @param userAccountId 用户账号id
	 * @param totalOrderAmount 订单总金额
	 * @return 处理结果
	 */
	public Boolean informPayOrderEvent(Long userAccountId, Long totalOrderAmount) {
		return true;
	}
	
	/**
	 * 通知会员中心，“完成退货”事件发生了
	 * @param userAccountId 用户账号id
	 * @param totalOrderAmount 订单总金额
	 * @return 处理结果
	 */
	public Boolean informFinishReturnGoodsEvent(Long userAccountId, Long totalOrderAmount) {
		return true;
	}
	
	/**
	 * 通知会员中心，“发表评论”事件发生了
	 * @param userAccountId 用户账号id
	 * @param showPictures 是否晒图
	 * @return 处理结果
	 */
	public Boolean informPublishCommentEvent(Long userAccountId, Boolean showPictures) {
		return true;
	}
	
	/**
	 * 通知会员中心，“删除评论”事件发生了
	 * @param userAccountId 用户账号id
	 * @param showPictures 是否晒图
	 * @return 处理结果
	 */
	public Boolean informRemoveCommentEvent(Long userAccountId, Boolean showPictures) {
		return true;
	}

}
