package com.zhss.eshop.comment.service.impl;

import java.text.DecimalFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhss.eshop.comment.constant.CommentType;
import com.zhss.eshop.comment.constant.ShowPictures;
import com.zhss.eshop.comment.dao.CommentAggregateDAO;
import com.zhss.eshop.comment.domain.CommentAggregateDO;
import com.zhss.eshop.comment.domain.CommentInfoDTO;
import com.zhss.eshop.comment.service.CommentAggregateService;
import com.zhss.eshop.common.util.DateProvider;

/**
 * 评论统计信息管理模块的service组件
 * @author zhonghuashishan
 *
 */
@Service
public class CommentAggregateServiceImpl implements CommentAggregateService {
	
	private static final Logger logger = LoggerFactory.getLogger(CommentAggregateServiceImpl.class);

	/**
	 * 评论统计信息管理模块的DAO组件
	 */
	@Autowired
	private CommentAggregateDAO commentAggregateDAO;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 更新评论统计信息
	 * @param commentInfoDTO 评论信息
	 * @return 处理结果
	 */
	public CommentAggregateDO refreshCommentAggregate(CommentInfoDTO commentInfoDTO) {
		CommentAggregateDO commentAggregateDO = null;
		try {
			commentAggregateDO = commentAggregateDAO.getCommentAggregateByGoodsId(
					commentInfoDTO.getGoodsId());
			if(commentAggregateDO == null) {
				commentAggregateDO = saveCommentAggregate(commentInfoDTO);
			} else {
				updateCommentAggregate(commentInfoDTO, commentAggregateDO);
			}
		} catch (Exception e) {
			logger.error("error", e); 
			return null;
		}
		return commentAggregateDO;
	}
	
	/**
	 * 新增评论统计信息
	 * @param commentInfoDTO
	 */
	private CommentAggregateDO saveCommentAggregate(
			CommentInfoDTO commentInfoDTO) throws Exception {
		CommentAggregateDO commentAggregateDO = new CommentAggregateDO();
		
		commentAggregateDO.setGoodsId(commentInfoDTO.getGoodsId()); 
		commentAggregateDO.setTotalCommentCount(1L); 
		commentAggregateDO.setGoodCommentCount(0L); 
		commentAggregateDO.setMediumCommentCount(0L); 
		commentAggregateDO.setBadCommentCount(0L); 
		
		if(commentInfoDTO.getCommentType().equals(CommentType.GOOD_COMMENT)) {
			commentAggregateDO.setGoodCommentCount(1L); 
		} else if(commentInfoDTO.getCommentType().equals(CommentType.MEDIUM_COMMENT)) {
			commentAggregateDO.setMediumCommentCount(1L); 
		} else if(commentInfoDTO.getCommentType().equals(CommentType.BAD_COMMENT)) {
			commentAggregateDO.setBadCommentCount(1L); 
		}
		 
		Double goodCommentRate = Double.valueOf(new DecimalFormat("#.00").format(
				(double)commentAggregateDO.getGoodCommentCount() / (double)commentAggregateDO.getTotalCommentCount())); 
		commentAggregateDO.setGoodCommentRate(goodCommentRate); 
		
		if(ShowPictures.YES.equals(commentInfoDTO.getShowPictures())) {
			commentAggregateDO.setShowPicturesCommentCount(1L); 
		}
		
		commentAggregateDO.setGmtCreate(dateProvider.getCurrentTime());  
		commentAggregateDO.setGmtModified(dateProvider.getCurrentTime()); 
		
		commentAggregateDAO.saveCommentAggregate(commentAggregateDO);
		
		return commentAggregateDO;
	}
	
	/**
	 * 更新评论统计信息
	 * @param commentInfoDTO
	 * @param commentAggregateDO
	 */
	private void updateCommentAggregate(CommentInfoDTO commentInfoDTO, 
			CommentAggregateDO commentAggregateDO) throws Exception {
		commentAggregateDO.setTotalCommentCount(commentAggregateDO.getTotalCommentCount() + 1L); 
		
		if(commentInfoDTO.getCommentType().equals(CommentType.GOOD_COMMENT)) {
			commentAggregateDO.setGoodCommentCount(commentAggregateDO.getGoodCommentCount() + 1L); 
		} else if(commentInfoDTO.getCommentType().equals(CommentType.MEDIUM_COMMENT)) {
			commentAggregateDO.setMediumCommentCount(commentAggregateDO.getMediumCommentCount() + 1L); 
		} else if(commentInfoDTO.getCommentType().equals(CommentType.BAD_COMMENT)) {
			commentAggregateDO.setBadCommentCount(commentAggregateDO.getBadCommentCount() + 1L); 
		}
		 
		Double goodCommentRate = Double.valueOf(new DecimalFormat("#.00").format(
				(double)commentAggregateDO.getGoodCommentCount() / (double)commentAggregateDO.getTotalCommentCount())); 
		commentAggregateDO.setGoodCommentRate(goodCommentRate); 
		
		if(ShowPictures.YES.equals(commentInfoDTO.getShowPictures())) {
			commentAggregateDO.setShowPicturesCommentCount(
					commentAggregateDO.getShowPicturesCommentCount() + 1L); 
		}
		
		commentAggregateDO.setGmtModified(dateProvider.getCurrentTime()); 
		
		commentAggregateDAO.updateCommentAggregate(commentAggregateDO);
	}

}
