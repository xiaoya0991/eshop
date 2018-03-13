package com.zhss.eshop.membership.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.membership.dao.MemberLevelDetailDAO;
import com.zhss.eshop.membership.domain.MemberLevelDetailDO;
import com.zhss.eshop.membership.domain.MemberLevelDetailQuery;
import com.zhss.eshop.membership.mapper.MemberLevelDetailMapper;

/**
 * 会员等级变更明细管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class MemberLevelDetailDAOImpl implements MemberLevelDetailDAO {

	/**
	 * 会员等级明细管理mapper组件
	 */
	@Autowired
	private MemberLevelDetailMapper memberLevelDetailMapper;
	
	/**
	 * 分页查询会员等级变更明细 
	 * @param query 查询调价你
	 * @return 会员等级变更明细
	 */
	public List<MemberLevelDetailDO> listByPage(MemberLevelDetailQuery query) {
		return memberLevelDetailMapper.listByPage(query);
	}
	
}
