package com.zhss.eshop.comment.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zhss.eshop.comment.constant.CommentPictureUploadDirType;
import com.zhss.eshop.comment.dao.CommentPictureDAO;
import com.zhss.eshop.comment.domain.CommentPictureDO;
import com.zhss.eshop.comment.domain.CommentPictureDTO;
import com.zhss.eshop.comment.service.CommentPictureService;
import com.zhss.eshop.common.util.ObjectUtils;

/**
 * 评论晒图管理模块的service组件
 * @author zhonghuashishan
 *
 */
@Service
public class CommentPictureServiceImpl implements CommentPictureService {
	
	private static final Logger logger = LoggerFactory.getLogger(CommentPictureServiceImpl.class);

	/**
	 * 评论晒图管理模块的DAO组件
	 */
	@Autowired
	private CommentPictureDAO commentPictureDAO;
	
	/**
	 * 评论晒图的上传目录的类型：relative是相对路径，absolute是绝对路径
	 */
	@Value("${comment.picture.upload.dir.type}")
	private String uploadDirType;
	
	/**
	 * 评论晒图的上传目录
	 */
	@Value("${comment.picture.upload.dir}")
	private String uploadDirPath;
	
	/**
	 * 保存评论晒图
	 * @param appBasePath 当前应用的根路径
	 * @param commentInfoId 评论信息id
	 * @param files 评论晒图
	 * @return 处理结果
	 */
	public Boolean saveCommentPictures(String appBasePath, 
			Long commentInfoId, MultipartFile[] files) {
		// 处理上传目录
		if(CommentPictureUploadDirType.RELATIVE.equals(uploadDirType)) {  
			uploadDirPath = appBasePath + uploadDirPath;
		}
		
		// 将图片上传到指定的目录中去
		try {	
			// 如果上传目录不存在，则自动创建该目录
			File uploadDir = new File(uploadDirPath);
			if(!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			
			for(MultipartFile file : files) {
				if(file == null) {
					continue;
				}
				
				// 如果目标文件路径已经存在，则删除目标文件
				String targetFilePath = uploadDirPath + file.getOriginalFilename();
				File targetFile = new File(targetFilePath);
				if(targetFile.exists()) {
					targetFile.delete();
				}
				
				// 将上传上来的文件保存到指定的文件中去
				file.transferTo(targetFile);
				
				// 将评论晒图信息保存到数据库中去
				CommentPictureDO commentPictureDO = new CommentPictureDO();
				commentPictureDO.setCommentInfoId(commentInfoId);
				commentPictureDO.setCommentPicturePath(targetFilePath);
				commentPictureDO.setGmtCreate(new Date());  
				commentPictureDO.setGmtModified(new Date());  
				
				commentPictureDAO.saveCommentPicture(commentPictureDO);
			}
		} catch(Exception e) {
			logger.error("error", e); 
			return false;
		}
		
		return true;
	}
	
	/**
	 * 根据评论信息id查询图片
	 * @param commentId 评论信息id
	 * @return 评论图片
	 */
	public List<CommentPictureDTO> listByCommentId(Long commentId) {
		try {
			List<CommentPictureDO> pictures = commentPictureDAO.listByCommentId(commentId);
			List<CommentPictureDTO> resultPictures = ObjectUtils.convertList(
					pictures, CommentPictureDTO.class);
			return resultPictures;
		} catch (Exception e) {
			logger.error("error", e); 
			return null;
		}
	}
	
	/**
	 * 根据id查询图片
	 * @param id 评论图片id
	 * @return 评论图片
	 */
	public CommentPictureDTO getById(Long id) {
		try {
			CommentPictureDO picture = commentPictureDAO.getById(id);
			CommentPictureDTO resultPicture = picture.clone(CommentPictureDTO.class);
			return resultPicture;
		} catch (Exception e) {
			logger.error("error", e);
			return null;
		}
	}
	
}
