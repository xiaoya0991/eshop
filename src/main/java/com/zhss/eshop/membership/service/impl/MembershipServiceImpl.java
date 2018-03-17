package com.zhss.eshop.membership.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhss.eshop.common.util.DateProvider;
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
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
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
	public Boolean informPayOrderEvent(Long userAccountId, Double totalOrderAmount) {
		return true;
	}
	
	/**
	 * 通知会员中心，“完成退货”事件发生了
	 * @param userAccountId 用户账号id
	 * @param totalOrderAmount 订单总金额
	 * @return 处理结果
	 */
	public Boolean informFinishReturnGoodsEvent(Long userAccountId, Double totalOrderAmount) {
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
	
	/**
	 * 查询所有的用户账户
	 * @return
	 */
	public List<UserAccountDTO> listAllUserAccounts() {
		List<UserAccountDTO> userAccounts = new ArrayList<UserAccountDTO>(); 
		
		try {
			UserAccountDTO userAccount = new UserAccountDTO();
			userAccount.setUsername("zhangsan"); 
			userAccount.setPassword("12345678");  
			userAccount.setEmail("zhangsan@sian.com");  
			userAccount.setCellPhoneNumber("18967543209");  
			userAccount.setGmtCreate(dateProvider.getCurrentTime()); 
			userAccount.setGmtModified(dateProvider.getCurrentTime()); 

			userAccounts.add(userAccount);
		} catch (Exception e) {
			logger.error("error", e); 
		}
		
		return userAccounts;
	}

}
