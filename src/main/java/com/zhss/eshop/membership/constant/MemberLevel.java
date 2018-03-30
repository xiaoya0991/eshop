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
	/**
	 * 青铜会员成长值
	 */
	public static final Integer BRONZE_THRESHOLD = 100;
	/**
	 * 白银会员成长值
	 */
	public static final Integer SLIVER_THRESHOLD = 500;
	/**
	 * 黄金会员成长值
	 */
	public static final Integer GOLD_THRESHOLD = 1000;
	
	private MemberLevel() {
		
	}
	
	/**
	 * 根据成长值获取会员等级
	 * @param growthValue 成长值
	 * @return 会员等级
	 * @throws Exception
	 */
	public static Integer get(Long growthValue) throws Exception {
		if(growthValue <= BRONZE_THRESHOLD) {
			return MemberLevel.BRONZE;
		} else if(growthValue > BRONZE_THRESHOLD && growthValue <= SLIVER_THRESHOLD) {
			return MemberLevel.SILVER;
		} else if(growthValue > SLIVER_THRESHOLD && growthValue <= GOLD_THRESHOLD) {
			return MemberLevel.GOLD;
		} else if(growthValue > GOLD_THRESHOLD) {
			return MemberLevel.DIAMOND;
		}
		return MemberLevel.BRONZE;
	}
	
}
