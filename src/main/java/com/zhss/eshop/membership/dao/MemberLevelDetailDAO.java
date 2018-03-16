package com.zhss.eshop.membership.dao;

import java.util.List;

import com.zhss.eshop.membership.domain.MemberLevelDetailDO;
import com.zhss.eshop.membership.domain.MemberLevelDetailQuery;

/**
 * 会员等级变更明细管理DAO接口
 * @author zhonghuashishan
 *
 */
public interface MemberLevelDetailDAO {

	/**
	 * 分页查询会员等级变更明细 
	 * @param query 查询调价你
	 * @return 会员等级变更明细
	 */
	List<MemberLevelDetailDO> listByPage(MemberLevelDetailQuery query) throws Exception;
	
	/**
	 * 新增会员等级明细
	 * @param memberLevelDetail 会员等级明细
	 */
	void save(MemberLevelDetailDO memberLevelDetail) throws Exception;
	
}
