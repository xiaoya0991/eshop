package com.zhss.eshop.membership.dao;

import java.util.List;

import com.zhss.eshop.membership.domain.MemberPointDetailDO;
import com.zhss.eshop.membership.domain.MemberPointDetailQuery;

/**
 * 会员积分变更明细管理DAO接口
 * @author zhonghuashishan
 *
 */
public interface MemberPointDetailDAO {

	/**
	 * 分页查询会员积分变更明细 
	 * @param query 查询调价你
	 * @return 会员积分变更明细
	 */
	List<MemberPointDetailDO> listByPage(MemberPointDetailQuery query) throws Exception;
	
	/**
	 * 新增会员积分明细
	 * @param memberPointDetail 会员积分明细
	 */
	void save(MemberPointDetailDO memberPointDetail) throws Exception;
	
}
