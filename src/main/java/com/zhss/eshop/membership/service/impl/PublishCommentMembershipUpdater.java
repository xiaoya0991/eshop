package com.zhss.eshop.membership.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhss.eshop.common.constant.CollectionSize;
import com.zhss.eshop.membership.constant.MemberLevel;
import com.zhss.eshop.membership.constant.UpdateMemberLevelResult;
import com.zhss.eshop.membership.constant.UpdateMemberPointResult;
import com.zhss.eshop.membership.dao.MemberLevelDAO;
import com.zhss.eshop.membership.dao.MemberLevelDetailDAO;
import com.zhss.eshop.membership.dao.MemberPointDAO;
import com.zhss.eshop.membership.dao.MemberPointDetailDAO;
import com.zhss.eshop.membership.domain.MemberLevelDO;
import com.zhss.eshop.membership.domain.MemberPointDO;

/**
 * 发表评论的会员信息更新组件
 * @author zhonghuashishan
 *
 */
@Component
public class PublishCommentMembershipUpdater extends AbstractMembershipUpdater<Object, Boolean> {

	/**
	 * 发表评论成长值
	 */
	private static final Long PUBLISH_COMMENT_GROWTH_VALUE_UPDATE = 10L;
	/**
	 * 晒单的成长值
	 */
	private static final Long SHOW_PICTURES_GROWTH_VALUE_UPDATE = 10L;
	/**
	 * 发表评论会员积分
	 */
	private static final Long PUBLISH_COMMENT_MEMBER_POINT_UPDATE = 10L;
	/**
	 * 晒单的会员积分
	 */
	private static final Long SHOW_PICTURES_MEMBER_POINT_UPDATE = 10L;
	
	/**
	 * 会员等级管理DAO组件
	 */
	@Autowired
	private MemberLevelDAO memberLevelDAO;
	/**
	 * 会员积分管理DAO组件
	 */
	@Autowired
	private MemberPointDAO memberPointDAO;
	
	@Autowired
	public PublishCommentMembershipUpdater(
			MemberLevelDetailDAO memberLevelDetailDAO,
			MemberPointDetailDAO memberPointDetailDAO) {
		super(memberLevelDetailDAO, memberPointDetailDAO);
	}
	
	/**
	 * 更新会员等级
	 */
	@Override
	protected Map<String, Object> updateMemberLevel(Long userAccountId, 
			Object parameter) throws Exception {
		Boolean showPictures = (Boolean) parameter;
		
		Map<String, Object> result = new HashMap<String, Object>(CollectionSize.DEFAULT);
		
		MemberLevelDO memberLevel = memberLevelDAO.getByUserAccountId(userAccountId);
		
		result.put(UpdateMemberLevelResult.OLD_GROWTH_VALUE, memberLevel.getGrowthValue());
		result.put(UpdateMemberLevelResult.OLD_MEMBER_LEVEL, memberLevel.getLevel());
		
		memberLevel.setGrowthValue(memberLevel.getGrowthValue() + PUBLISH_COMMENT_GROWTH_VALUE_UPDATE 
				+ (showPictures ? SHOW_PICTURES_GROWTH_VALUE_UPDATE : 0));
		memberLevel.setLevel(MemberLevel.get(memberLevel.getGrowthValue()));  
		memberLevelDAO.update(memberLevel); 
		
		result.put(UpdateMemberLevelResult.UPDATED_GROWTH_VALUE, PUBLISH_COMMENT_GROWTH_VALUE_UPDATE 
				+ (showPictures ? SHOW_PICTURES_GROWTH_VALUE_UPDATE : 0));
		result.put(UpdateMemberLevelResult.NEW_GROWTH_VALUE, memberLevel.getGrowthValue());
		result.put(UpdateMemberLevelResult.NEW_MEMBER_LEVEL, memberLevel.getLevel());
		
		return result;
	}
	
	/**
	 * 更新会员积分
	 */
	@Override
	protected Map<String, Object> updateMemberPoint(Long userAccountId, 
			Object parameter) throws Exception {
		Boolean showPictures = (Boolean) parameter;
		
		Map<String, Object> result = new HashMap<String, Object>(CollectionSize.DEFAULT);
		
		MemberPointDO memberPoint = memberPointDAO.getByUserAccountId(userAccountId);
		
		result.put(UpdateMemberPointResult.OLD_MEMBER_POINT, memberPoint.getPoint());
		
		memberPoint.setPoint(memberPoint.getPoint() + PUBLISH_COMMENT_MEMBER_POINT_UPDATE 
				+ (showPictures ? SHOW_PICTURES_MEMBER_POINT_UPDATE : 0)); 
		memberPointDAO.update(memberPoint); 
		
		result.put(UpdateMemberPointResult.UPDATED_MEMBER_POINT, PUBLISH_COMMENT_MEMBER_POINT_UPDATE 
				+ (showPictures ? SHOW_PICTURES_MEMBER_POINT_UPDATE : 0));
		result.put(UpdateMemberPointResult.NEW_MEMBER_POINT, memberPoint.getPoint());
		
		return result;
	}
	
	/**
	 * 获取会员等级更新原因
	 */
	@Override
	protected String getMemberLevelUpdateReason(Long userAccountId, Object parameter,
			Map<String, Object> updateMemberLevelResult) throws Exception {
		return "发表了一条评论" + ((Boolean)parameter ? "，同时晒了单" : ""); 
	}
	
	/**
	 * 获取会员积分更新原因
	 */
	@Override
	protected String getMemberPointUpdateReason(Long userAccountId, Object parameter,
			Map<String, Object> updateMemberPointResult) throws Exception {
		return "发表了一条评论" + ((Boolean)parameter ? "，同时晒了单" : ""); 
	}
	
	/**
	 * 完成更新会员信息
	 */
	@Override
	protected Boolean finishExecute(Long userAccountId, Object parameter) throws Exception {
		return true;
	}
	
	/**
	 * 撤销更新会员等级
	 */
	@Override
	protected Map<String, Object> undoUpdatedMemberLevel(Long userAccountId, 
			Object parameter) throws Exception {
		Boolean showPictures = (Boolean) parameter;
		
		Map<String, Object> result = new HashMap<String, Object>(CollectionSize.DEFAULT);
		
		MemberLevelDO memberLevel = memberLevelDAO.getByUserAccountId(userAccountId);
		
		result.put(UpdateMemberLevelResult.OLD_GROWTH_VALUE, memberLevel.getGrowthValue());
		result.put(UpdateMemberLevelResult.OLD_MEMBER_LEVEL, memberLevel.getLevel());
		
		memberLevel.setGrowthValue(memberLevel.getGrowthValue() - PUBLISH_COMMENT_GROWTH_VALUE_UPDATE 
				- (showPictures ? SHOW_PICTURES_GROWTH_VALUE_UPDATE : 0));
		memberLevel.setLevel(MemberLevel.get(memberLevel.getGrowthValue()));  
		memberLevelDAO.update(memberLevel); 
		
		result.put(UpdateMemberLevelResult.UPDATED_GROWTH_VALUE, -(PUBLISH_COMMENT_GROWTH_VALUE_UPDATE 
				+ (showPictures ? SHOW_PICTURES_GROWTH_VALUE_UPDATE : 0))); 
		result.put(UpdateMemberLevelResult.NEW_GROWTH_VALUE, memberLevel.getGrowthValue());
		result.put(UpdateMemberLevelResult.NEW_MEMBER_LEVEL, memberLevel.getLevel());
		
		return result;
	}
	
	/**
	 * 撤销更新会员积分
	 */
	@Override
	protected Map<String, Object> undoUpdatedMemberPoint(Long userAccountId, 
			Object parameter) throws Exception {
		Boolean showPictures = (Boolean) parameter;
		
		Map<String, Object> result = new HashMap<String, Object>(CollectionSize.DEFAULT);
		
		MemberPointDO memberPoint = memberPointDAO.getByUserAccountId(userAccountId);
		
		result.put(UpdateMemberPointResult.OLD_MEMBER_POINT, memberPoint.getPoint());
		
		memberPoint.setPoint(memberPoint.getPoint() - PUBLISH_COMMENT_MEMBER_POINT_UPDATE 
				- (showPictures ? SHOW_PICTURES_MEMBER_POINT_UPDATE : 0)); 
		memberPointDAO.update(memberPoint); 
		
		result.put(UpdateMemberPointResult.UPDATED_MEMBER_POINT, -(PUBLISH_COMMENT_MEMBER_POINT_UPDATE 
				+ (showPictures ? SHOW_PICTURES_MEMBER_POINT_UPDATE : 0)));
		result.put(UpdateMemberPointResult.NEW_MEMBER_POINT, memberPoint.getPoint());
		
		return result;
	}
	
	/**
	 * 获取撤销会员等级的原因
	 */
	@Override
	protected String getUndoMemberLevelUpdateReason(Long userAccountId, Object parameter,
			Map<String, Object> undoMemberLevelResult) throws Exception {
		return "发表的一条评论被删除了" + ((Boolean)parameter ? "，同时这个评论是晒单的" : ""); 
	}
	
	/**
	 * 获取撤销会员积分的原因
	 */
	@Override
	protected String getUndoMemberPointUpdateReason(Long userAccountId, Object parameter,
			Map<String, Object> undoMemberPointResult) throws Exception {
		return "发表的一条评论被删除了" + ((Boolean)parameter ? "，同时这个评论是晒单的" : ""); 
	}
	
	/**
	 * 完成撤销操作
	 */
	@Override
	protected Boolean finishUndo(Long userAccountId, Object parameter) throws Exception {
		return true;
	}

}
