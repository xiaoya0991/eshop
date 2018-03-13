package com.zhss.eshop.membership.service;

import java.util.List;

import com.zhss.eshop.membership.domain.MemberLevelDetailDTO;
import com.zhss.eshop.membership.domain.MemberLevelDetailQuery;

/**
 * 会员等级明细管理service接口
 * @author zhonghuashishan
 *
 */
public interface MemberLevelDetailService {

	/**
	 * 分页查询会员等级变更明细 
	 * @param query 查询调价你
	 * @return 会员等级变更明细
	 */
	List<MemberLevelDetailDTO> listByPage(MemberLevelDetailQuery query) throws Exception;
	
}
