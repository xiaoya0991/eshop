package com.zhss.eshop.comment.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zhss.eshop.comment.constant.CommentApproved;
import com.zhss.eshop.comment.constant.CommentStatus;
import com.zhss.eshop.comment.constant.ShowPictures;
import com.zhss.eshop.comment.domain.CommentAggregateDTO;
import com.zhss.eshop.comment.domain.CommentAggregateVO;
import com.zhss.eshop.comment.domain.CommentInfoDTO;
import com.zhss.eshop.comment.domain.CommentInfoQuery;
import com.zhss.eshop.comment.domain.CommentInfoVO;
import com.zhss.eshop.comment.domain.CommentPictureDTO;
import com.zhss.eshop.comment.domain.CommentPictureVO;
import com.zhss.eshop.comment.domain.CommentShowVO;
import com.zhss.eshop.comment.service.CommentAggregateService;
import com.zhss.eshop.comment.service.CommentInfoService;
import com.zhss.eshop.comment.service.CommentPictureService;
import com.zhss.eshop.common.util.ObjectUtils;
import com.zhss.eshop.membership.service.MembershipFacadeService;
import com.zhss.eshop.order.service.OrderFacadeService;

/**
 * 评论管理模块的Controller组件
 * @author zhonghuashishan
 *
 */
@RestController
@RequestMapping("/comment") 
public class CommentController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

	/**
	 * 评论信息管理模块的service组件
	 */
	@Autowired
	private CommentInfoService commentInfoService;
	/**
	 * 评论晒图管理模块的service组件
	 */
	@Autowired
	private CommentPictureService commentPictureService;
	/**
	 * 评论统计信息管理模块的service组件
	 */
	@Autowired
	private CommentAggregateService commentAggregateService;
	/**
	 * 订单中心的service组件
	 */
	@Autowired
	private OrderFacadeService orderFacadeService;
	/**
	 * 会员中心的service组件
	 */
	@Autowired
	private MembershipFacadeService membershipFacadeService;
	
	/**
	 * 手动发表评论
	 * @param commentInfoVO 评论信息VO对象
	 * @return 处理结果
	 */
	@PostMapping("/") 
	public Boolean publishComment(HttpServletRequest request, 
			CommentInfoVO commentInfoVO, MultipartFile[] files) {
		try {
			// 为评论设置是否晒图
			Integer showPictures = ShowPictures.NO;
			
			if(files != null && files.length > 0) {
				for(MultipartFile file : files) {
					if(file != null) {
						showPictures = ShowPictures.YES;
						break;
					}
				}
			}
			
			commentInfoVO.setShowPictures(showPictures); 
			
			// 保存评论信息
			CommentInfoDTO commentInfoDTO = commentInfoVO.clone(CommentInfoDTO.class);
			commentInfoService.saveManualPublishedCommentInfo(commentInfoDTO);
			
			// 上传评论晒图图片
			String appBasePath = request.getSession().getServletContext().getRealPath("/");
			commentPictureService.saveCommentPictures(appBasePath, commentInfoDTO.getId(), files);
			
			// 更新评论统计信息
			commentAggregateService.refreshCommentAggregate(commentInfoDTO);
			
			// 通知订单中心订单已经发表了评论
			orderFacadeService.informPublishCommentEvent(commentInfoDTO.getOrderInfoId());
			
			// 通知会员中心用户已经发表了评论
			membershipFacadeService.informPublishCommentEvent(
					commentInfoDTO.getUserAccountId(), ShowPictures.YES.equals(showPictures)); 
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
		return true;
	}
	
	/**
	 * 分页查询评论信息
	 * @param query 查询条件
	 * @return 评论信息
	 */
	@GetMapping("/") 
	public List<CommentInfoVO> listByPage(CommentInfoQuery query) {
		try {
			List<CommentInfoDTO> comments = commentInfoService.listByPage(query);
			List<CommentInfoVO> resultComments = ObjectUtils.convertList(
					comments, CommentInfoVO.class);
			return resultComments;
		} catch (Exception e) {
			logger.error("error", e); 
			return new ArrayList<CommentInfoVO>();
		}
	}
	
	/**
	 * 根据id查询评论信息
	 * @param id 评论信息id
	 * @return 评论信息
	 */
	@GetMapping("/{id}")  
	public CommentInfoVO getById(@PathVariable("id") Long id) {
		try {
			CommentInfoDTO comment = commentInfoService.getById(id);
			CommentInfoVO resultComment = comment.clone(CommentInfoVO.class);
			
			List<CommentPictureDTO> pictures = commentPictureService.listByCommentId(id);
			List<CommentPictureVO> resultPictures = ObjectUtils.convertList(
					pictures, CommentPictureVO.class);
			
			resultComment.setPictures(resultPictures); 
			
			return resultComment;
		} catch (Exception e) {
			logger.error("error", e);
			return null;
		}
	}
	
	/**
	 * 显示图片
	 * @param jobIconUrl
	 * @param request
	 * @param httpResponse
	 */
    @GetMapping("/picture/{id}")   
    public void viewPicture(@PathVariable("id") Long id, 
    		HttpServletRequest request, HttpServletResponse response) { 
    	FileInputStream fis = null;
    	
        try {
        	CommentPictureDTO picture = commentPictureService.getById(id);
        	
            File file = new File(picture.getCommentPicturePath());
            fis = new FileInputStream(file);
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
        	
            response.setContentType("image/jpg");
            OutputStream out = response.getOutputStream();
            out.write(bytes);  
            out.flush();
        } catch (Exception e) {
        	logger.error("error", e); 
        } finally {
        	if(fis != null ) {
        		try {
					fis.close();
				} catch (IOException e) {
					logger.error("error", e); 
				}
        	}
        }
    }
    
    /**
     * 审核评论
     * @param comment 评论信息 
     */
    @PutMapping("/approve/{id}")  
    public Boolean update(@PathVariable("id") Long id, Integer approved) {
    	try {
    		CommentInfoDTO comment = new CommentInfoDTO();
    		comment.setId(id);
    		comment.setCommentStatus(CommentApproved.YES.equals(approved) ? 
    				CommentStatus.APPROVED : CommentStatus.APPROVE_REJECTED); 
			Boolean result = commentInfoService.update(comment);
			return result;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
    }
    
    /**
     * 删除评论
     * @param id 评论id
     * @return 处理结果
     */
    @DeleteMapping("/{id}") 
    public Boolean remove(@PathVariable("id") Long id) {
    	try {
			return commentInfoService.remove(id);
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
    }
    
    /**
     * 在前台展示评论信息
     * @param goodsId 商品id
     * @return 评论信息
     */
    @GetMapping("/show/{goodsId}")  
    public CommentShowVO show(@PathVariable("goodsId") Long goodsId, 
    		CommentInfoQuery query) { 
    	try {
    		// 构造评论展示VO对象
    		CommentShowVO commentShow = new CommentShowVO();
    		commentShow.setGoodsId(goodsId); 
    		
    		// 查询评论统计信息
    		CommentAggregateDTO aggregate = commentAggregateService
    				.getCommentAggregateByGoodsId(goodsId);
    		commentShow.setAggregate(aggregate.clone(CommentAggregateVO.class));  
    		
    		// 查询评论列表
    		query.setCommentStatus(CommentStatus.APPROVED); 
    		
    		List<CommentInfoVO> targetComments = new ArrayList<CommentInfoVO>();
    		
    		List<CommentInfoDTO> comments = commentInfoService.listByPage(query);
    		for(CommentInfoDTO comment : comments) {
    			CommentInfoVO targetComment = comment.clone(CommentInfoVO.class);
    			targetComment.setUsername(getEncryptedUsername(targetComment.getUsername()));  
    			
    			List<CommentPictureDTO> pictures = commentPictureService
    					.listByCommentId(comment.getId());
    			targetComment.setPictures(ObjectUtils.convertList(
    					pictures, CommentPictureVO.class));  
    			
    			targetComments.add(targetComment);
    		}
    		
    		commentShow.setComments(targetComments); 
    		
    		// 返回评论展示VO对象
    		return commentShow;
		} catch (Exception e) {
			logger.error("error", e); 
			return new CommentShowVO();
		}
    }
    
    /**
     * 获取加密后的用户名
     * @param username
     * @return
     */
    private String getEncryptedUsername(String username) {
    	StringBuilder builder = new StringBuilder(""); 
    	
    	builder.append(username.substring(0, 1)); 
    	for(int i = 1; i < username.length() - 1; i++) {
    		builder.append("*"); 
    	}
    	builder.append(username.substring(username.length() - 1));  
    	
    	return builder.toString();
    }
	
}
