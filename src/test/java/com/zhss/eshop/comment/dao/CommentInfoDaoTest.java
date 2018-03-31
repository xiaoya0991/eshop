package com.zhss.eshop.comment.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.comment.constant.CommentInfoScore;
import com.zhss.eshop.comment.constant.CommentStatus;
import com.zhss.eshop.comment.constant.CommentType;
import com.zhss.eshop.comment.constant.DefaultComment;
import com.zhss.eshop.comment.constant.ShowPictures;
import com.zhss.eshop.comment.domain.CommentInfoDO;
import com.zhss.eshop.comment.domain.CommentInfoQuery;
import com.zhss.eshop.common.constant.CollectionSize;
import com.zhss.eshop.common.util.DateProvider;

/**
 * 评论信息管理模块的DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional(rollbackFor = Exception.class) 
@Rollback(true)
public class CommentInfoDaoTest {

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
	 * 测试新增评论信息
	 * @throws Exception
	 */
	@Test
	public void testSaveCommentInfo() throws Exception {
		CommentInfoDO commentInfoDO = createCommentInfoDO();
		assertNotNull(commentInfoDO.getId());
		assertThat(commentInfoDO.getId(), greaterThan(0L));  
	} 
	
	/**
	 * 测试分页查询评论信息
	 * @throws Exception
	 */
	@Test
	public void testListByPage() throws Exception {
		// 构造20条评论数据
		Integer count = 20;
		
		Map<Long, CommentInfoDO> commentMap = new HashMap<Long, CommentInfoDO>(CollectionSize.DEFAULT);
		
		for(int i = 0; i < count; i++) {
			CommentInfoDO comment = createCommentInfoDO();
			commentMap.put(comment.getId(), comment);
		}
		
		// 执行分页查询
		Integer offset = 15;
		Integer size = 5;
		
		CommentInfoQuery query = new CommentInfoQuery();
		query.setCommentStatus(CommentStatus.APPROVING); 
		query.setCommentType(null); 
		query.setDefaultComment(DefaultComment.NO); 
		query.setStartTime("2018-01-01 00:00:00");   
		query.setEndTime("2018-05-01 00:00:00");   
		query.setOffset(offset); 
		query.setSize(size);  
		query.setShowPictures(ShowPictures.YES); 
		query.setTotalScore(CommentInfoScore.FIVE);  
		
		List<CommentInfoDO> resultComments = commentInfoDAO.listByPage(query);
		
		// 执行断言
		assertEquals((int)size, resultComments.size());   
		
		for(CommentInfoDO resultComment : resultComments) {
			assertEquals(commentMap.get(resultComment.getId()), resultComment);  
		}
	}
	
	/**
	 * 测试根据id查询评论信息
	 * @throws Exception
	 */
	@Test
	public void testGetById() throws Exception {
		CommentInfoDO comment = createCommentInfoDO();
		CommentInfoDO resultComment = commentInfoDAO.getById(comment.getId());
		assertEquals(comment, resultComment); 
	}
	
	/**
	 * 测试更新评论
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {
		CommentInfoDO comment = createCommentInfoDO();
		
		comment.setCommentStatus(CommentStatus.APPROVED);  
		comment.setGmtModified(dateProvider.getCurrentTime()); 
		commentInfoDAO.update(comment);
		
		CommentInfoDO resultComment = commentInfoDAO.getById(comment.getId());
		
		assertEquals(comment, resultComment); 
	}
	
	/**
	 * 测试删除评论
	 * @throws Exception
	 */
	@Test
	public void testRemove() throws Exception {
		CommentInfoDO comment = createCommentInfoDO();
		commentInfoDAO.remove(comment.getId());
		CommentInfoDO resultComment = commentInfoDAO.getById(comment.getId());
		assertNull(resultComment); 
	}
	
	/**
	 * 创建一个评论信息DO对象
	 * @return 评论信息DO对象
	 * @throws Exception
	 */
	private CommentInfoDO createCommentInfoDO() throws Exception {
		CommentInfoDO commentInfoDO = new CommentInfoDO();
		
		commentInfoDO.setCommentContent("测试评论");
		commentInfoDO.setCommentStatus(CommentStatus.APPROVING);
		commentInfoDO.setCommentType(CommentType.GOOD_COMMENT);
		commentInfoDO.setCustomerServiceScore(CommentInfoScore.FIVE);
		commentInfoDO.setDefaultComment(DefaultComment.NO);
		commentInfoDO.setGmtCreate(dateProvider.getCurrentTime()); 
		commentInfoDO.setGmtModified(dateProvider.getCurrentTime()); 
		commentInfoDO.setGoodsId(1L); 
		commentInfoDO.setGoodsScore(CommentInfoScore.FIVE); 
		commentInfoDO.setGoodsSkuId(1L); 
		commentInfoDO.setGoodsSkuSaleProperties("测试销售属性"); 
		commentInfoDO.setLogisticsScore(CommentInfoScore.FIVE); 
		commentInfoDO.setOrderInfoId(1L); 
		commentInfoDO.setOrderItemId(1L); 
		commentInfoDO.setShowPictures(ShowPictures.YES);
		commentInfoDO.setTotalScore(CommentInfoScore.FIVE); 
		commentInfoDO.setUserAccountId(1L); 
		commentInfoDO.setUsername("test"); 
		
		commentInfoDAO.saveCommentInfo(commentInfoDO);
		
		return commentInfoDO;
	}
	
}
