package com.zhss.eshop.comment.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhss.eshop.comment.constant.CommentContent;
import com.zhss.eshop.comment.constant.CommentInfoScore;
import com.zhss.eshop.comment.constant.CommentStatus;
import com.zhss.eshop.comment.constant.CommentType;
import com.zhss.eshop.comment.constant.DefaultComment;
import com.zhss.eshop.comment.constant.ShowPictures;
import com.zhss.eshop.comment.dao.CommentInfoDAO;
import com.zhss.eshop.comment.domain.CommentInfoDO;
import com.zhss.eshop.comment.domain.CommentInfoDTO;
import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.order.domain.OrderItemDTO;

/**
 * 评论信息管理模块service组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
public class CommentInfoServiceTest {

	/**
	 * 评论信息管理模块service组件
	 */
	@Autowired
	private CommentInfoService commentInfoService;
	/**
	 * 评论信息管理模块DAO组件
	 */
	@MockBean
	private CommentInfoDAO commentInfoDAO;
	/**
	 * 日期辅助组件
	 */
	@MockBean
	private DateProvider dateProvider;
	
	/**
	 * 初始化
	 * @throws Exception
	 */
	@Before
	public void setup() throws Exception {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentTime = dateFormatter.parse(dateFormatter.format(new Date()));  
		when(dateProvider.getCurrentTime()).thenReturn(currentTime);
	}
	
	/**
	 * 测试新增手动发表的评论信息
	 * @throws Exception
	 */
	@Test
	public void testSaveManualPublishedCommentInfo() throws Exception {
		Long commentInfoId = 1L;
		CommentInfoDTO partialCommentInfoDTO = createPartialCommentInfoDTO();
		CommentInfoDTO commentInfoDTO = createFullCommentInfoDTO(partialCommentInfoDTO);
		CommentInfoDO commentInfoDO = convertCommentInfoDTO2DO(commentInfoDTO);
		
		when(commentInfoDAO.saveCommentInfo(commentInfoDO)).thenReturn(commentInfoId);
		
		Boolean result = commentInfoService.saveManualPublishedCommentInfo(partialCommentInfoDTO);
		
		verify(commentInfoDAO, times(1)).saveCommentInfo(commentInfoDO);
		assertTrue(result);
	}
	
	/**
	 * 测试新增自动发表的评论信息
	 * @throws Exception
	 */
	@Test
	public void testSaveAutoPublishedCommentInfo() throws Exception {
		OrderInfoDTO orderInfoDTO = createOrderInfoDTO();
		OrderItemDTO orderItemDTO = createOrderItemDTO();
		CommentInfoDTO commentInfoDTO = createAutoPublishedCommentInfoDTO(
				orderInfoDTO, orderItemDTO);
		CommentInfoDO commentInfoDO = convertCommentInfoDTO2DO(commentInfoDTO);
		
		when(commentInfoDAO.saveCommentInfo(commentInfoDO)).thenReturn(1L);
		
		CommentInfoDTO resultCommentInfoDTO = commentInfoService.saveAutoPublishedCommentInfo(
				orderInfoDTO, orderItemDTO);
		
		verify(commentInfoDAO, times(1)).saveCommentInfo(commentInfoDO);
		assertEquals(commentInfoDTO, resultCommentInfoDTO); 
	}
	
	/**
	 * 创建一个含有部分数据的评论信息DTO对象
	 * @return 评论信息DTO对象
	 */
	private CommentInfoDTO createPartialCommentInfoDTO() {
		CommentInfoDTO commentInfoDTO = new CommentInfoDTO();
		
		commentInfoDTO.setCommentContent("测试评论"); 
		commentInfoDTO.setCustomerServiceScore(CommentInfoScore.FOUR);
		commentInfoDTO.setGoodsScore(CommentInfoScore.FIVE); 
		commentInfoDTO.setLogisticsScore(CommentInfoScore.THREE); 
		commentInfoDTO.setGoodsId(1L); 
		commentInfoDTO.setGoodsSkuId(1L); 
		commentInfoDTO.setGoodsSkuSaleProperties("测试销售属性");  
		commentInfoDTO.setOrderInfoId(1L); 
		commentInfoDTO.setOrderItemId(1L); 
		commentInfoDTO.setShowPictures(ShowPictures.YES); 
		commentInfoDTO.setUserAccountId(1L); 
		commentInfoDTO.setUsername("test"); 
		
		return commentInfoDTO;
	}
	
	/**
	 * 创建一个完整的评论信息DTO对象
	 * @param partialCommentInfoDTO 评论信息DTO对象
	 * @return 评论信息DTO对象
	 */
	private CommentInfoDTO createFullCommentInfoDTO(
			CommentInfoDTO partialCommentInfoDTO) throws Exception {
		CommentInfoDTO commentInfoDTO = new CommentInfoDTO();
		
		commentInfoDTO.setCommentContent(partialCommentInfoDTO.getCommentContent()); 
		commentInfoDTO.setCustomerServiceScore(partialCommentInfoDTO.getCustomerServiceScore());
		commentInfoDTO.setGoodsScore(partialCommentInfoDTO.getGoodsScore()); 
		commentInfoDTO.setLogisticsScore(partialCommentInfoDTO.getLogisticsScore());  
		commentInfoDTO.setGoodsId(partialCommentInfoDTO.getGoodsId()); 
		commentInfoDTO.setGoodsSkuId(partialCommentInfoDTO.getGoodsSkuId()); 
		commentInfoDTO.setGoodsSkuSaleProperties(partialCommentInfoDTO.getGoodsSkuSaleProperties());  
		commentInfoDTO.setOrderInfoId(partialCommentInfoDTO.getOrderInfoId()); 
		commentInfoDTO.setOrderItemId(partialCommentInfoDTO.getOrderItemId()); 
		commentInfoDTO.setShowPictures(partialCommentInfoDTO.getShowPictures()); 
		commentInfoDTO.setUserAccountId(partialCommentInfoDTO.getUserAccountId()); 
		commentInfoDTO.setUsername(partialCommentInfoDTO.getUsername()); 
		
		commentInfoDTO.setTotalScore(CommentInfoScore.FOUR); 
		commentInfoDTO.setDefaultComment(DefaultComment.NO); 
		commentInfoDTO.setCommentStatus(CommentStatus.APPROVING);
		commentInfoDTO.setCommentType(CommentType.GOOD_COMMENT); 
		commentInfoDTO.setGmtCreate(dateProvider.getCurrentTime()); 
		commentInfoDTO.setGmtModified(dateProvider.getCurrentTime());  
		
		return commentInfoDTO;
	}
	
	/**
	 * 将评论信息DTO对象转换为DO对象
	 * @param commentInfoDTO 评论信息DTO对象
	 * @return 评论信息DO对象
	 */
	private CommentInfoDO convertCommentInfoDTO2DO(CommentInfoDTO commentInfoDTO) {
		CommentInfoDO commentInfoDO = new CommentInfoDO();
		
		commentInfoDO.setCommentContent(commentInfoDTO.getCommentContent()); 
		commentInfoDO.setCustomerServiceScore(commentInfoDTO.getCustomerServiceScore());
		commentInfoDO.setGoodsScore(commentInfoDTO.getGoodsScore()); 
		commentInfoDO.setLogisticsScore(commentInfoDTO.getLogisticsScore());  
		commentInfoDO.setGoodsId(commentInfoDTO.getGoodsId()); 
		commentInfoDO.setGoodsSkuId(commentInfoDTO.getGoodsSkuId()); 
		commentInfoDO.setGoodsSkuSaleProperties(commentInfoDTO.getGoodsSkuSaleProperties());  
		commentInfoDO.setOrderInfoId(commentInfoDTO.getOrderInfoId()); 
		commentInfoDO.setOrderItemId(commentInfoDTO.getOrderItemId()); 
		commentInfoDO.setShowPictures(commentInfoDTO.getShowPictures()); 
		commentInfoDO.setUserAccountId(commentInfoDTO.getUserAccountId()); 
		commentInfoDO.setUsername(commentInfoDTO.getUsername()); 
		
		commentInfoDO.setTotalScore(commentInfoDTO.getTotalScore()); 
		commentInfoDO.setDefaultComment(commentInfoDTO.getDefaultComment()); 
		commentInfoDO.setCommentStatus(commentInfoDTO.getCommentStatus());
		commentInfoDO.setCommentType(commentInfoDTO.getCommentType()); 
		commentInfoDO.setGmtCreate(commentInfoDTO.getGmtCreate()); 
		commentInfoDO.setGmtModified(commentInfoDTO.getGmtModified());
		
		return commentInfoDO;
	}
	
	/**
	 * 创建一个订单信息DTO对象
	 * @return 订单信息DTO对象
	 * @throws Exception
	 */
	private OrderInfoDTO createOrderInfoDTO() throws Exception {
		OrderInfoDTO orderInfoDTO = new OrderInfoDTO();
		orderInfoDTO.setId(1L); 
		orderInfoDTO.setUserAccountId(1L); 
		orderInfoDTO.setUsername("test");
		return orderInfoDTO;
	}
	
	/**
	 * 创建一个订单条目DTO对象
	 * @return 订单条目DTO对象
	 * @throws Exception
	 */
	private OrderItemDTO createOrderItemDTO() throws Exception {
		OrderItemDTO orderItemDTO = new OrderItemDTO();
		orderItemDTO.setId(1L); 
		orderItemDTO.setGoodsId(1L); 
		orderItemDTO.setGoodsSkuId(1L); 
		orderItemDTO.setSaleProperties("测试销售属性");  
		return orderItemDTO;
	}
	
	/**
	 * 创建一个自动发表的评论DTO
	 * @param orderInfoDTO
	 * @param orderItemDTO
	 * @return
	 * @throws Exception
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
	
}
