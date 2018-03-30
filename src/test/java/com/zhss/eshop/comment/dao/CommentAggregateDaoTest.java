package com.zhss.eshop.comment.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.hamcrest.Matchers.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.comment.domain.CommentAggregateDO;
import com.zhss.eshop.common.util.DateProvider;

/**
 * 评论统计管理模块的DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional(rollbackFor = Exception.class) 
@Rollback(true)
public class CommentAggregateDaoTest {

	/**
	 * 评论统计管理模块的DAO组件
	 */
	@Autowired
	private CommentAggregateDAO commentAggregateDAO;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 测试新增评论统计信息
	 * @throws Exception
	 */
	@Test
	public void testSaveCommentAggregate() throws Exception {
		Long goodsId = 1L;
		CommentAggregateDO commentAggregateDO = createCommentAggregateDO(goodsId); 
		assertNotNull(commentAggregateDO.getId()); 
		assertThat(commentAggregateDO.getId(), greaterThan(0L));  
	}
	
	/**
	 * 测试根据商品id查询评论统计信息
	 * @throws Exception
	 */
	@Test
	public void testGetCommentAggregateByGoodsId() throws Exception {
		Long goodsId = 1L;
		CommentAggregateDO commentAggregateDO = createCommentAggregateDO(goodsId); 
		CommentAggregateDO resultCommentAggregateDO = commentAggregateDAO
				.getCommentAggregateByGoodsId(goodsId);
		assertEquals(commentAggregateDO, resultCommentAggregateDO);  
	}
	
	/**
	 * 测试更新评论统计信息
	 * @throws Exception
	 */
	@Test
	public void testUpdateCommentAggregate() throws Exception {
		Long goodsId = 1L;
		CommentAggregateDO commentAggregateDO = createCommentAggregateDO(goodsId); 
		
		commentAggregateDO.setGoodCommentCount(5L);  
		commentAggregateDAO.updateCommentAggregate(commentAggregateDO);
		
		CommentAggregateDO resultCommentAggregateDO = commentAggregateDAO
				.getCommentAggregateByGoodsId(goodsId);
		
		assertEquals(commentAggregateDO, resultCommentAggregateDO);  
	}
	
	/**
	 * 创建评论统计DO对象
	 * @return 评论统计DO对象
	 * @throws Exception
	 */
	private CommentAggregateDO createCommentAggregateDO(Long goodsId) throws Exception {
		CommentAggregateDO commentAggregateDO = new CommentAggregateDO();
		commentAggregateDO.setBadCommentCount(1L);
		commentAggregateDO.setGmtCreate(dateProvider.getCurrentTime()); 
		commentAggregateDO.setGmtModified(dateProvider.getCurrentTime());  
		commentAggregateDO.setGoodCommentCount(1L); 
		commentAggregateDO.setGoodCommentRate(1.0); 
		commentAggregateDO.setGoodsId(goodsId); 
		commentAggregateDO.setMediumCommentCount(1L); 
		commentAggregateDO.setShowPicturesCommentCount(1L); 
		commentAggregateDO.setTotalCommentCount(5L); 
		
		commentAggregateDAO.saveCommentAggregate(commentAggregateDO);
		
		return commentAggregateDO;
	}
	
}
