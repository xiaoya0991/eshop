package com.zhss.eshop.comment.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhss.eshop.comment.constant.CommentType;
import com.zhss.eshop.comment.constant.ShowPictures;
import com.zhss.eshop.comment.dao.CommentAggregateDAO;
import com.zhss.eshop.comment.domain.CommentAggregateDO;
import com.zhss.eshop.comment.domain.CommentAggregateDTO;
import com.zhss.eshop.comment.domain.CommentInfoDTO;
import com.zhss.eshop.common.util.DateProvider;

/**
 * 评论统计信息管理模块service组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
public class CommentAggregateServiceTest {

	/**
	 * 评论统计信息管理模块service组件
	 */
	@Autowired
	private CommentAggregateService commentAggregateService;
	/**
	 * 评论统计信息管理模块dao组件
	 */
	@MockBean
	private CommentAggregateDAO commentAggregateDAO;
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
	 * 测试新增评论统计信息
	 * @throws Exception
	 */
	@Test
	public void testSaveCommentAggregate() throws Exception {
		Long goodsId = 1L;
		when(commentAggregateDAO.getCommentAggregateByGoodsId(goodsId)).thenReturn(null);
		
		CommentInfoDTO commentInfoDTO = createCommentInfoDTO(goodsId);
		CommentAggregateDTO resultCommentAggregateDO = commentAggregateService
				.refreshCommentAggregate(commentInfoDTO);
		
		assertEquals(goodsId, resultCommentAggregateDO.getGoodsId()); 
		assertEquals(Long.valueOf(1L), resultCommentAggregateDO.getTotalCommentCount()); 
		assertEquals(Long.valueOf(1L), resultCommentAggregateDO.getGoodCommentCount()); 
		assertEquals(Double.valueOf(1.00), resultCommentAggregateDO.getGoodCommentRate()); 
		assertEquals(Long.valueOf(1L), resultCommentAggregateDO.getShowPicturesCommentCount()); 
		assertEquals(dateProvider.getCurrentTime(), resultCommentAggregateDO.getGmtCreate()); 
		assertEquals(dateProvider.getCurrentTime(), resultCommentAggregateDO.getGmtModified()); 
	}
	
	/**
	 * 测试更新统计评论信息
	 * @throws Exception
	 */
	@Test
	public void testUpdateCommentAggregate() throws Exception {
		Long goodsId = 1L;
		CommentAggregateDO initialCommentAggregateDO = createCommentAggregateDO(goodsId);
		CommentAggregateDO commentAggregateDO = createCommentAggregateDO(goodsId);
		when(commentAggregateDAO.getCommentAggregateByGoodsId(goodsId)).thenReturn(commentAggregateDO);
		
		CommentInfoDTO commentInfoDTO = createCommentInfoDTO(goodsId);
		CommentAggregateDTO resultCommentAggregateDO = commentAggregateService
				.refreshCommentAggregate(commentInfoDTO);
		
		Double expectedGoodCommentRate = Double.valueOf(new DecimalFormat("#.00").format(
				Long.valueOf(initialCommentAggregateDO.getGoodCommentCount() + 1L) / Long.valueOf(initialCommentAggregateDO.getTotalCommentCount() + 1L))); 
		Double actualGoodCommentRate = Double.valueOf(new DecimalFormat("#.00").format(
				resultCommentAggregateDO.getGoodCommentCount() / resultCommentAggregateDO.getTotalCommentCount())); 
		
		assertEquals(Long.valueOf(initialCommentAggregateDO.getTotalCommentCount() + 1L), 
				resultCommentAggregateDO.getTotalCommentCount()); 
		assertEquals(Long.valueOf(initialCommentAggregateDO.getGoodCommentCount() + 1L), 
				resultCommentAggregateDO.getGoodCommentCount());
		assertEquals(expectedGoodCommentRate, actualGoodCommentRate);
		assertEquals(Long.valueOf(initialCommentAggregateDO.getShowPicturesCommentCount() + 1L), 
				resultCommentAggregateDO.getShowPicturesCommentCount());
	}
	
	/**
	 * 创建评论信息DTO对象
	 * @return 评论信息DTO对象
	 * @throws Exception
	 */
	private CommentInfoDTO createCommentInfoDTO(Long goodsId) throws Exception {
		CommentInfoDTO commentInfoDTO = new CommentInfoDTO();
		commentInfoDTO.setGoodsId(goodsId);
		commentInfoDTO.setCommentType(CommentType.GOOD_COMMENT);
		commentInfoDTO.setShowPictures(ShowPictures.YES); 
		return commentInfoDTO;
	}
	
	/**
	 * 创建评论统计信息DO对象
	 * @return
	 * @throws Exception
	 */
	private CommentAggregateDO createCommentAggregateDO(Long goodsId) throws Exception {
		CommentAggregateDO commentAggregateDO = new CommentAggregateDO();
		commentAggregateDO.setBadCommentCount(5L); 
		commentAggregateDO.setGmtCreate(dateProvider.getCurrentTime()); 
		commentAggregateDO.setGmtModified(dateProvider.getCurrentTime()); 
		commentAggregateDO.setGoodCommentCount(950L); 
		commentAggregateDO.setGoodCommentRate(0.95); 
		commentAggregateDO.setGoodsId(goodsId);
		commentAggregateDO.setId(1L); 
		commentAggregateDO.setMediumCommentCount(45L); 
		commentAggregateDO.setShowPicturesCommentCount(680L); 
		commentAggregateDO.setTotalCommentCount(1000L); 
		return commentAggregateDO;
	}
	
}
