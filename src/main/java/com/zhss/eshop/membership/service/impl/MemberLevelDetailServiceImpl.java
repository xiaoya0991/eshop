package com.zhss.eshop.membership.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.common.util.ObjectUtils;
import com.zhss.eshop.membership.dao.MemberLevelDetailDAO;
import com.zhss.eshop.membership.domain.MemberLevelDetailDTO;
import com.zhss.eshop.membership.domain.MemberLevelDetailQuery;
import com.zhss.eshop.membership.service.MemberLevelDetailService;

/**
 * 会员等级明细管理service组件
 * @author zhonghuashishan
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MemberLevelDetailServiceImpl implements MemberLevelDetailService {

	/**
	 * 会员等级明细管理DAO组件
	 */
	@Autowired
	private MemberLevelDetailDAO memberLevelDetailDAO;
	
	/**
	 * 分页查询会员等级变更明细 
	 * @param query 查询调价你
	 * @return 会员等级变更明细
	 */
	@Override
	public List<MemberLevelDetailDTO> listByPage(
			MemberLevelDetailQuery query) throws Exception {
		return ObjectUtils.convertList(memberLevelDetailDAO.listByPage(query), 
				MemberLevelDetailDTO.class); 
	}
	
}
