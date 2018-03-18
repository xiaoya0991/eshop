package com.zhss.eshop.membership.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhss.eshop.common.util.ObjectUtils;
import com.zhss.eshop.membership.dao.UserAccountDAO;
import com.zhss.eshop.membership.domain.UserAccountDTO;
import com.zhss.eshop.membership.service.MembershipService;

/**
 * 会员中心对外接口service组件
 * @author zhonghuashishan
 *
 */
@Service
public class MembershipServiceImpl implements MembershipService {
	
	private static final Logger logger = LoggerFactory.getLogger(
			MembershipServiceImpl.class);
	
	/**
	 * 用户账号DAO组件
	 */
	@Autowired
	private UserAccountDAO userAccountDAO;
	/**
	 * 每天第一次登录会员信息更新组件
	 */
	@Autowired
	private FirstLoginMembershipUpdater firstLoginMembershipUpdater;
	/**
	 * 支付订单会员信息更新组件
	 */
	@Autowired
	private PayOrderMembershipUpdater payOrderMembershipUpdater;
	/**
	 * 发表评论会员信息更新组件
	 */
	@Autowired
	private PublishCommentMembershipUpdater publishCommentMembershipUpdater;
	
	/**
	 * 通知会员中心，“用户今日第一次登录”事件发生了
	 * @param userAccountId 用户账号ID
	 * @return 处理结果
	 */
	public Boolean informFirstLoginDailyEvent(Long userAccountId) {
		try {
			firstLoginMembershipUpdater.execute(userAccountId, null);
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 通知会员中心，“支付订单”事件发生了
	 * @param userAccountId 用户账号id
	 * @param totalOrderAmount 订单总金额
	 * @return 处理结果
	 */
	public Boolean informPayOrderEvent(Long userAccountId, Double totalOrderAmount) {
		try {
			payOrderMembershipUpdater.execute(userAccountId, totalOrderAmount);
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 通知会员中心，“完成退货”事件发生了
	 * @param userAccountId 用户账号id
	 * @param totalOrderAmount 订单总金额
	 * @return 处理结果
	 */
	public Boolean informFinishReturnGoodsEvent(Long userAccountId, Double totalOrderAmount) {
		try {
			payOrderMembershipUpdater.undo(userAccountId, totalOrderAmount);
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 通知会员中心，“发表评论”事件发生了
	 * @param userAccountId 用户账号id
	 * @param showPictures 是否晒图
	 * @return 处理结果
	 */
	public Boolean informPublishCommentEvent(Long userAccountId, Boolean showPictures) {
		try {
			publishCommentMembershipUpdater.execute(userAccountId, showPictures);
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 通知会员中心，“删除评论”事件发生了
	 * @param userAccountId 用户账号id
	 * @param showPictures 是否晒图
	 * @return 处理结果
	 */
	public Boolean informRemoveCommentEvent(Long userAccountId, Boolean showPictures) {
		try {
			publishCommentMembershipUpdater.undo(userAccountId, showPictures);
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 查询所有的用户账户
	 * @return
	 */
	public List<UserAccountDTO> listAllUserAccounts() {
		try {
			return ObjectUtils.convertList(userAccountDAO.listAll(), UserAccountDTO.class);
		} catch (Exception e) { 
			logger.error("error", e); 
			return new ArrayList<UserAccountDTO>(); 
		}
	}

}
