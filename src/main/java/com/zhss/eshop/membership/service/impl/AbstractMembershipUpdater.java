package com.zhss.eshop.membership.service.impl;

import java.util.Map;

import com.zhss.eshop.membership.constant.UpdateMemberLevelResult;
import com.zhss.eshop.membership.constant.UpdateMemberPointResult;
import com.zhss.eshop.membership.dao.MemberLevelDetailDAO;
import com.zhss.eshop.membership.dao.MemberPointDetailDAO;
import com.zhss.eshop.membership.domain.MemberLevelDetailDO;
import com.zhss.eshop.membership.domain.MemberPointDetailDO;

/**
 * 会员信息更新组件的抽象基类
 * @author zhonghuashishan
 *
 */
public abstract class AbstractMembershipUpdater<T, K> implements MembershipUpdater<T, K> { 

	/**
	 * 会员等级明细管理DAO组件
	 */
	protected MemberLevelDetailDAO memberLevelDetailDAO;
	/**
	 * 会员积分明细管理DAO组件
	 */
	protected MemberPointDetailDAO memberPointDetailDAO;
	
	public AbstractMembershipUpdater(MemberLevelDetailDAO memberLevelDetailDAO,
			MemberPointDetailDAO memberPointDetailDAO) {
		this.memberLevelDetailDAO = memberLevelDetailDAO;
		this.memberPointDetailDAO = memberPointDetailDAO;
	}

	/**
	 * 执行会员信息更新的操作
	 * @param userAccountId 用户账号id 
	 * @param parameter 参数
	 * @return 返回值
	 * @throws Exception
	 */
	@Override
	public K execute(Long userAccountId, T parameter) throws Exception {
		Map<String, Object> updateMemberLevelResult = updateMemberLevel(userAccountId, parameter); 
		Map<String, Object> updateMemberPointResult = updateMemberPoint(userAccountId, parameter); 
		saveMemberLevelDetail(userAccountId, parameter, updateMemberLevelResult); 
		saveMemberPointDetail(userAccountId, parameter, updateMemberPointResult); 
		return finishExecute(userAccountId, parameter);
	}
	
	/**
	 * 撤销会员信息更新的操作
	 * @param userAccountId 用户账号id
	 * @param parameter 参数
	 * @return 返回值
	 * @throws Exception
	 */
	@Override
	public K undo(Long userAccountId, T parameter) throws Exception {
		Map<String, Object> undoMemberLevelResult = undoUpdatedMemberLevel(userAccountId, parameter); 
		Map<String, Object> undoMemberPointResult = undoUpdatedMemberPoint(userAccountId, parameter); 
		saveUndoMemberLevelDetail(userAccountId, parameter, undoMemberLevelResult); 
		saveUndoMemberPointDetail(userAccountId, parameter, undoMemberPointResult); 
		return finishUndo(userAccountId, parameter);
	}
	
	/**
	 * 更新会员等级
	 * @param userAccountId 用户账号id
	 * @param parameter 参数
	 * @return 返回值
	 * @throws Exception
	 */
	protected abstract Map<String, Object> updateMemberLevel(
			Long userAccountId, T parameter) throws Exception;
	
	/**
	 * 更新会员积分
	 * @param userAccountId 用户账号id
	 * @param parameter 参数
	 * @return 更新结果
	 * @throws Exception
	 */
	protected abstract Map<String, Object> updateMemberPoint(
			Long userAccountId, T parameter) throws Exception;
	
	/**
	 * 获取会员等级更新原因
	 * @param userAccountId
	 * @param parameter
	 * @param updateMemberLevelResult
	 * @return
	 * @throws Exception
	 */
	protected abstract String getMemberLevelUpdateReason(Long userAccountId,
			T parameter, Map<String, Object> updateMemberLevelResult) throws Exception;
	
	/**
	 * 新增一条会员等级更新明细
	 * @param userAccountId 用户账号id 
	 * @param parameter 参数
	 * @param updateMemberLevelResult 更新会员等级结果
	 * @throws Exception
	 */
	private void saveMemberLevelDetail(Long userAccountId, 
			T parameter, Map<String, Object> updateMemberLevelResult) throws Exception {
		MemberLevelDetailDO memberLevelDetail = createMemberLevelDetail(
				userAccountId, updateMemberLevelResult);
		memberLevelDetail.setUpdateReason(getMemberLevelUpdateReason(
				userAccountId, parameter, updateMemberLevelResult));
		memberLevelDetailDAO.save(memberLevelDetail); 
	}
	
	/**
	 * 创建会员等级更新明细
	 * @param userAccountId
	 * @param result
	 * @return
	 * @throws Exception
	 */
	private MemberLevelDetailDO createMemberLevelDetail(Long userAccountId,
			Map<String, Object> updateResult) throws Exception {
		MemberLevelDetailDO memberLevelDetail = new MemberLevelDetailDO();
		
		memberLevelDetail.setUserAccountId(userAccountId); 
		memberLevelDetail.setOldGrowthValue(Long.valueOf(String.valueOf(
				updateResult.get(UpdateMemberLevelResult.OLD_GROWTH_VALUE))));   
		memberLevelDetail.setUpdatedGrowthValue(Long.valueOf(String.valueOf(
				updateResult.get(UpdateMemberLevelResult.UPDATED_GROWTH_VALUE))));   
		memberLevelDetail.setNewGrowthValue(Long.valueOf(String.valueOf(
				updateResult.get(UpdateMemberLevelResult.NEW_GROWTH_VALUE))));   
		memberLevelDetail.setOldMemberLevel(Integer.valueOf(String.valueOf(
				updateResult.get(UpdateMemberLevelResult.OLD_MEMBER_LEVEL))));   
		memberLevelDetail.setNewMemberLevel(Integer.valueOf(String.valueOf(
				updateResult.get(UpdateMemberLevelResult.NEW_MEMBER_LEVEL))));
		
		return memberLevelDetail;
	}
	
	/**
	 * 获取会员积分更新原因
	 * @param userAccountId 用户账号id
	 * @param parameter 参数
	 * @param updateMemberPointResult 更新结果
	 * @return 更新原因
	 * @throws Exception
	 */
	protected abstract String getMemberPointUpdateReason(Long userAccountId,
			T parameter, Map<String, Object> updateMemberPointResult) throws Exception;
	
	/**
	 * 新增一条会员积分更新明细
	 * @param userAccountId 用户账号id
	 * @param parameter 参数
	 * @param updateMemberPointResult 更新会员积分结果
	 * @throws Exception
	 */
	private void saveMemberPointDetail(Long userAccountId,
			T parameter, Map<String, Object> updateMemberPointResult) throws Exception {
		MemberPointDetailDO memberPointDetail = createMemberPointDetail(
				userAccountId, updateMemberPointResult);
		memberPointDetail.setUpdateReason(getMemberPointUpdateReason(
				userAccountId, parameter, updateMemberPointResult));
		memberPointDetailDAO.save(memberPointDetail); 
	}
	
	/**
	 * 创建会员积分明细
	 * @return 会员积分明细
	 * @throws Exception
	 */
	private MemberPointDetailDO createMemberPointDetail(Long userAccountId,
			Map<String, Object> updateResult) throws Exception {
		MemberPointDetailDO memberPointDetail = new MemberPointDetailDO();
		
		memberPointDetail.setUserAccountId(userAccountId); 
		
		memberPointDetail.setOldMemberPoint(Long.valueOf(String.valueOf(
				updateResult.get(UpdateMemberPointResult.OLD_MEMBER_POINT))));   
		memberPointDetail.setUpdatedMemberPoint(Long.valueOf(String.valueOf(
				updateResult.get(UpdateMemberPointResult.UPDATED_MEMBER_POINT))));   
		memberPointDetail.setNewMemberPoint(Long.valueOf(String.valueOf(
				updateResult.get(UpdateMemberPointResult.NEW_MEMBER_POINT)))); 
		
		return memberPointDetail;
	}
	
	/**
	 * 完成执行本次会员信息更新操作
	 * @param userAccountId 用户账号id
	 * @param parameter 参数
	 * @return 返回值
	 * @throws Exception
	 */
	protected abstract K finishExecute(Long userAccountId, 
			T parameter) throws Exception;
	
	/**
	 * 撤销更新的会员等级
	 * @param userAccountId 用户账号id
	 * @param parameter 参数
	 * @return 撤销结果
	 * @throws Exception
	 */
	protected abstract Map<String, Object> undoUpdatedMemberLevel(Long userAccountId, 
			T parameter) throws Exception;
	
	/**
	 * 撤销更新的会员积分
	 * @param userAccountId 用户账号id
	 * @param parameter 参数
	 * @return 撤销结果
	 * @throws Exception
	 */
	protected abstract Map<String, Object> undoUpdatedMemberPoint(Long userAccountId,
			T parameter) throws Exception;
	
	/**
	 * 获取撤销会员等级更新原因
	 * @param userAccountId 用户账号id
	 * @param parameter 参数
	 * @param undoMemberLevelResult 撤销结果
	 * @return 更新原因
	 * @throws Exception
	 */
	protected abstract String getUndoMemberLevelUpdateReason(Long userAccountId,
			T parameter, Map<String, Object> undoMemberLevelResult) throws Exception;
	
	/**
	 * 获取撤销会员积分更新原因
	 * @param userAccountId 用户账号id
	 * @param parameter 参数
	 * @param undoMemberPointResult 撤销结果
	 * @return 更新原因
	 * @throws Exception
	 */
	protected abstract String getUndoMemberPointUpdateReason(Long userAccountId,
			T parameter, Map<String, Object> undoMemberPointResult) throws Exception;
	
	/**
	 * 新增一条会员等级撤销操作更新明细
	 * @param userAccountId 用户账号id 
	 * @param parameter 参数
	 * @param undoMemberLevelResult 撤销会员等级结果
	 * @throws Exception
	 */
	private void saveUndoMemberLevelDetail(Long userAccountId, 
			T parameter, Map<String, Object> undoMemberLevelResult) throws Exception {
		MemberLevelDetailDO memberLevelDetail = createMemberLevelDetail(
				userAccountId, undoMemberLevelResult);
		memberLevelDetail.setUpdateReason(getUndoMemberLevelUpdateReason(
				userAccountId, parameter, undoMemberLevelResult));
		memberLevelDetailDAO.save(memberLevelDetail); 
	}
	
	/**
	 * 新增一条会员积分撤销操作更新明细
	 * @param userAccountId 用户账号id
	 * @param parameter 参数
	 * @param undoMemberPointResult 撤销会员积分结果
	 * @throws Exception
	 */
	private void saveUndoMemberPointDetail(Long userAccountId,
			T parameter, Map<String, Object> undoMemberPointResult) throws Exception {
		MemberPointDetailDO memberPointDetail = createMemberPointDetail(
				userAccountId, undoMemberPointResult);
		memberPointDetail.setUpdateReason(getUndoMemberPointUpdateReason(
				userAccountId, parameter, undoMemberPointResult)); 
		memberPointDetailDAO.save(memberPointDetail); 
	}
	
	/**
	 * 完成撤销会员信息更新操作
	 * @param userAccountId 用户账号id
	 * @param parameter 参数
	 * @return 返回值
	 * @throws Exception
	 */
	protected abstract K finishUndo(Long userAccountId, 
			T parameter) throws Exception;
	
}
