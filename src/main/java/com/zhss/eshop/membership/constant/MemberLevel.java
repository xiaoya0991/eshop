package com.zhss.eshop.membership.constant;

/**
 * 会员等级
 * @author zhonghuashishan
 *
 */
public class MemberLevel {

	/**
	 * 青铜会员
	 */
	public static final Integer BRONZE = 1;
	/**
	 * 白银会员
	 */
	public static final Integer SILVER = 2;
	/**
	 * 黄金会员
	 */
	public static final Integer GOLD = 3;
	/**
	 * 钻石会员
	 */
	public static final Integer DIAMOND = 1;
	
	private MemberLevel() {
		
	}
	
	/**
	 * 根据成长值获取会员等级
	 * @param growthValue 成长值
	 * @return 会员等级
	 * @throws Exception
	 */
	public static Integer get(Long growthValue) throws Exception {
		if(growthValue <= 100) {
			return MemberLevel.BRONZE;
		} else if(growthValue > 100 && growthValue <= 500) {
			return MemberLevel.SILVER;
		} else if(growthValue > 500 && growthValue <= 1000) {
			return MemberLevel.GOLD;
		} else if(growthValue > 1000) {
			return MemberLevel.DIAMOND;
		}
		return MemberLevel.BRONZE;
	}
	
}
