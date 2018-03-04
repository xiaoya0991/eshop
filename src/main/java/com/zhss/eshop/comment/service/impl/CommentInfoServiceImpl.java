package com.zhss.eshop.comment.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhss.eshop.comment.constant.CommentContent;
import com.zhss.eshop.comment.constant.CommentInfoScore;
import com.zhss.eshop.comment.constant.CommentStatus;
import com.zhss.eshop.comment.constant.CommentType;
import com.zhss.eshop.comment.constant.DefaultComment;
import com.zhss.eshop.comment.constant.ShowPictures;
import com.zhss.eshop.comment.dao.CommentInfoDAO;
import com.zhss.eshop.comment.domain.CommentInfoDO;
import com.zhss.eshop.comment.domain.CommentInfoDTO;
import com.zhss.eshop.comment.domain.CommentInfoQuery;
import com.zhss.eshop.comment.service.CommentInfoService;
import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.common.util.ObjectUtils;
import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.order.domain.OrderItemDTO;

/**
 * 评论信息管理模块的service组件
 * @author zhonghuashishan
 *
 */
@Service
public class CommentInfoServiceImpl implements CommentInfoService {
	
	private static final Logger logger = LoggerFactory.getLogger(CommentInfoServiceImpl.class);

	/**
	 * 评论信息管理模块的DAO组件
	 */
	@Autowired
	private CommentInfoDAO commentInfoDAO;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 新增手动发表的评论信息
	 * @param commentInfoDTO 评论信息DTO对象
	 */
	public Boolean saveManualPublishedCommentInfo(CommentInfoDTO commentInfoDTO) {
		try {
			// 计算评论的总分数
			Integer totalScore = Math.round((commentInfoDTO.getGoodsScore() 
					+ commentInfoDTO.getCustomerServiceScore() 
					+ commentInfoDTO.getLogisticsScore()) / 3); 
			commentInfoDTO.setTotalScore(totalScore); 
			
			// 设置是否为默认评论
			commentInfoDTO.setDefaultComment(DefaultComment.NO);
			
			// 设置评论的状态
			commentInfoDTO.setCommentStatus(CommentStatus.APPROVING);
			
			// 设置评论的类型
			Integer commentType = 0;
			if(totalScore >= 4) {
				commentType = CommentType.GOOD_COMMENT;
			} else if(totalScore == 3) {
				commentType = CommentType.MEDIUM_COMMENT;
			} else if(totalScore > 0 && totalScore <= 2) {
				commentType = CommentType.BAD_COMMENT;
			}
			
			commentInfoDTO.setCommentType(commentType);
			
			// 设置创建时间和修改时间
			commentInfoDTO.setGmtCreate(dateProvider.getCurrentTime());  
			commentInfoDTO.setGmtModified(dateProvider.getCurrentTime());   
			
			// 将评论信息保存到数据库中去
			CommentInfoDO commentInfoDO = commentInfoDTO.clone(CommentInfoDO.class);
			commentInfoDAO.saveCommentInfo(commentInfoDO);
			
			// 设置评论信息的id
			commentInfoDTO.setId(commentInfoDO.getId());  
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
		return true;
	}
	
	/**
	 * 新增自动发表的评论信息
	 * @param orderInfoDTO 订单信息DTO对象
	 * @param orderItemDTO 订单条目DTO对象
	 * @return 处理结果
	 */
	public CommentInfoDTO saveAutoPublishedCommentInfo(
			OrderInfoDTO orderInfoDTO, OrderItemDTO orderItemDTO) {
		CommentInfoDTO commentInfoDTO = null;
		try {
			commentInfoDTO = createAutoPublishedCommentInfoDTO(orderInfoDTO, orderItemDTO);
			CommentInfoDO commentInfoDO = commentInfoDTO.clone(CommentInfoDO.class);
			commentInfoDAO.saveCommentInfo(commentInfoDO);
			commentInfoDTO.setId(commentInfoDO.getId());  
		} catch (Exception e) {
			logger.error("error", e); 
			return null;
		}
		return commentInfoDTO;
	}
	
	/**
	 * 创建评论信息DTO对象
	 * @param orderInfoDTO 订单信息DTO对象
	 * @param orderItemDTO 订单条目DTO对象
	 * @return 评论信息DTO对象
	 */
	private CommentInfoDTO createAutoPublishedCommentInfoDTO(
			OrderInfoDTO orderInfoDTO, OrderItemDTO orderItemDTO) throws Exception {
		CommentInfoDTO commentInfoDTO = new CommentInfoDTO();
		
		commentInfoDTO.setUserAccountId(orderInfoDTO.getUserAccountId()); 
		commentInfoDTO.setUsername(orderInfoDTO.getUsername()); 
		commentInfoDTO.setOrderInfoId(orderInfoDTO.getId()); 
		commentInfoDTO.setOrderItemId(orderItemDTO.getId()); 
		commentInfoDTO.setGoodsId(orderItemDTO.getGoodsId()); 
		commentInfoDTO.setGoodsSkuId(orderItemDTO.getGoodsSkuId()); 
		commentInfoDTO.setGoodsSkuSaleProperties(orderItemDTO.getSaleProperties()); 
		commentInfoDTO.setTotalScore(CommentInfoScore.FIVE); 
		commentInfoDTO.setGoodsScore(CommentInfoScore.FIVE);
		commentInfoDTO.setCustomerServiceScore(CommentInfoScore.FIVE); 
		commentInfoDTO.setLogisticsScore(CommentInfoScore.FIVE); 
		commentInfoDTO.setCommentContent(CommentContent.DEFAULT);
		commentInfoDTO.setShowPictures(ShowPictures.NO);
		commentInfoDTO.setDefaultComment(DefaultComment.YES);
		commentInfoDTO.setCommentStatus(CommentStatus.APPROVED);
		commentInfoDTO.setCommentType(CommentType.GOOD_COMMENT);
		commentInfoDTO.setGmtCreate(dateProvider.getCurrentTime());  
		commentInfoDTO.setGmtModified(dateProvider.getCurrentTime()); 
		
		return commentInfoDTO;
	}
	
	/**
	 * 分页查询评论信息
	 * @param query 评论查询条件
	 * @return 评论信息
	 */
	public List<CommentInfoDTO> listByPage(CommentInfoQuery query) {
		try {
			List<CommentInfoDO> comments = commentInfoDAO.listByPage(query);
			List<CommentInfoDTO> resultComments = ObjectUtils.convertList(
					comments, CommentInfoDTO.class);
			return resultComments;
		} catch (Exception e) {
			logger.error("error", e);
			return null;
		}
	}
	
	/**
	 * 根据id查询评论信息
	 * @param id 评论信息id
	 * @return 评论信息
	 */
	public CommentInfoDTO getById(Long id) {
		try {
			CommentInfoDO comment = commentInfoDAO.getById(id);
			CommentInfoDTO resultComment = comment.clone(CommentInfoDTO.class);
			return resultComment;
		} catch (Exception e) {
			logger.error("error", e); 
			return null;
		}
	}
	
	/**
	 * 更新评论
	 * @param comment 评论信息
	 */
	public Boolean update(CommentInfoDTO comment) {
		try {
			comment.setGmtModified(dateProvider.getCurrentTime()); 
			CommentInfoDO targetComment = comment.clone(CommentInfoDO.class);
			Boolean result = commentInfoDAO.update(targetComment);
			return result;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 删除评论
	 * @param id 删除评论
	 * @return 处理结果
	 */
	public Boolean remove(Long id) {
		try {
			return commentInfoDAO.remove(id);
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}

}
