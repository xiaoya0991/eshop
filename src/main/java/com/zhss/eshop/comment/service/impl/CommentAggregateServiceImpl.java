package com.zhss.eshop.comment.service.impl;

import java.text.DecimalFormat;
import java.util.Date;

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
	 * 更新评论统计信息
	 * @param commentInfoDTO 评论信息
	 * @return 处理结果
	 */
	public Boolean updateCommentAggregate(CommentInfoDTO commentInfoDTO) {
		try {
			CommentAggregateDO commentAggregateDO = commentAggregateDAO
					.getCommentAggregateByGoodsId(commentInfoDTO.getGoodsId());
			
			// 如果商品id还没有对应的评论统计信息，则新增一条评论统计信息
			if(commentAggregateDO == null) {
				commentAggregateDO = new CommentAggregateDO();
				
				commentAggregateDO.setGoodsId(commentInfoDTO.getGoodsId()); 
				commentAggregateDO.setTotalCommentCount(1L); 
				
				if(commentInfoDTO.getCommentType().equals(CommentType.GOOD_COMMENT)) {
					commentAggregateDO.setGoodCommentCount(1L); 
				} else if(commentInfoDTO.getCommentType().equals(CommentType.MEDIUM_COMMENT)) {
					commentAggregateDO.setMediumCommentCount(1L); 
				} else if(commentInfoDTO.getCommentType().equals(CommentType.BAD_COMMENT)) {
					commentAggregateDO.setBadCommentCount(1L); 
				}
				
				Double goodCommentRate = Double.valueOf(new DecimalFormat("#.00").format(
						commentAggregateDO.getGoodCommentCount() / commentAggregateDO.getTotalCommentCount())); 
				commentAggregateDO.setGoodCommentRate(goodCommentRate); 
				
				if(ShowPictures.YES.equals(commentInfoDTO.getShowPictures())) {
					commentAggregateDO.setShowPicturesCommentCount(1L); 
				}
				
				commentAggregateDO.setGmtCreate(new Date());  
				commentAggregateDO.setGmtModified(new Date()); 
				
				commentAggregateDAO.saveCommentAggregate(commentAggregateDO);
			} 
			
			// 如果商品id已经有对应的评论统计信息了，则在原先基础之上更新即可
			else {
				commentAggregateDO.setTotalCommentCount(commentAggregateDO.getTotalCommentCount() + 1L); 
				
				if(commentInfoDTO.getCommentType().equals(CommentType.GOOD_COMMENT)) {
					commentAggregateDO.setGoodCommentCount(commentAggregateDO.getGoodCommentCount() + 1L); 
				} else if(commentInfoDTO.getCommentType().equals(CommentType.MEDIUM_COMMENT)) {
					commentAggregateDO.setMediumCommentCount(commentAggregateDO.getMediumCommentCount() + 1L); 
				} else if(commentInfoDTO.getCommentType().equals(CommentType.BAD_COMMENT)) {
					commentAggregateDO.setBadCommentCount(commentAggregateDO.getBadCommentCount() + 1L); 
				}
				
				Double goodCommentRate = Double.valueOf(new DecimalFormat("#.00").format(
						commentAggregateDO.getGoodCommentCount() / commentAggregateDO.getTotalCommentCount())); 
				commentAggregateDO.setGoodCommentRate(goodCommentRate); 
				
				if(ShowPictures.YES.equals(commentInfoDTO.getShowPictures())) {
					commentAggregateDO.setShowPicturesCommentCount(
							commentAggregateDO.getShowPicturesCommentCount() + 1L); 
				}
				
				commentAggregateDO.setGmtModified(new Date()); 
				
				commentAggregateDAO.updateCommentAggregate(commentAggregateDO);
			}
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
		
		return true;
	}

}
