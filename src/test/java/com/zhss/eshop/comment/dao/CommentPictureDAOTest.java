package com.zhss.eshop.comment.dao;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.comment.domain.CommentPictureDO;
import com.zhss.eshop.common.util.DateProvider;

/**
 * 评论图片管理模块的DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional 
@Rollback(true)
public class CommentPictureDAOTest {
	
	/**
	 * 评论图片管理模块的DAO组件
	 */
	@Autowired
	private CommentPictureDAO commentPictureDAO;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 测试新增评论晒图
	 * @throws Exception
	 */
	@Test
	public void testSaveCommentPicture() throws Exception {
		CommentPictureDO commentPictureDO = createCommentPictureDO();
		Long commentPictureId = commentPictureDAO.saveCommentPicture(commentPictureDO);
		assertNotNull(commentPictureId); 
		assertThat(commentPictureId, greaterThan(0L)); 
	}
	
	/**
	 * 创建评论图片DO对象
	 * @return 评论图片DO对象
	 * @throws Exceptionn
	 */
	private CommentPictureDO createCommentPictureDO() throws Exception {
		CommentPictureDO commentPictureDO = new CommentPictureDO();
		commentPictureDO.setCommentInfoId(1L); 
		commentPictureDO.setCommentPicturePath("/test"); 
		commentPictureDO.setGmtCreate(dateProvider.getCurrentTime()); 
		commentPictureDO.setGmtModified(dateProvider.getCurrentTime()); 
		return commentPictureDO;
	}

}
