package com.zhss.eshop.membership.domain;

/**
 * 用户详细信息显示的VO类
 * @author zhonghuashishan
 *
 */
public class UserDetailShowVO {

	/**
	 * 用户账号
	 */
	private UserAccountVO userAccount;
	/**
	 * 用户详细信息
	 */
	private UserDetailVO userDetail;
	
	public UserAccountVO getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(UserAccountVO userAccount) {
		this.userAccount = userAccount;
	}
	public UserDetailVO getUserDetail() {
		return userDetail;
	}
	public void setUserDetail(UserDetailVO userDetail) {
		this.userDetail = userDetail;
	}
	
	@Override
	public String toString() {
		return "UserDetailShowVO [userAccount=" + userAccount + ", userDetail=" + userDetail + "]";
	}
	
}
