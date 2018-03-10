package com.zhss.eshop.commodity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.zhss.eshop.commodity.dao.GoodsPictureDAO;
import com.zhss.eshop.commodity.domain.GoodsPictureDO;
import com.zhss.eshop.commodity.service.GoodsPictureService;
import com.zhss.eshop.common.constant.PathType;
import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.common.util.FileUtils;

/**
 * 商品图片管理service组件
 * @author zhonghuashishan
 *
 */
@Service
@Transactional
public class GoodsPictureServiceImpl implements GoodsPictureService {

	/**
	 * 商品图片管理DAO组件
	 */
	@Autowired
	private GoodsPictureDAO goodsPictureDAO;
	/**
	 * 图片上传路径的类型
	 */
	@Value("${commodity.goods.image.upload.picture.path.type}") 
	private String uploadDirPathType;
	/**
	 * 图片上传路径
	 */
	@Value("${commodity.goods.image.upload.picture.path}")  
	private String uploadDirPath;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 批量新增商品图片
	 * @param goodsId 商品id
	 * @param pictures 商品图片
	 * @throws Exception
	 */
	public void batchSave(Long goodsId, 
			MultipartFile[] pictures) throws Exception {
		for(MultipartFile picture : pictures) {
			String picturePath = uploadPicture(picture);
			saveGoodsPicture(goodsId, picturePath); 
		}
	}
	
	/**
	 * 新增商品图片
	 * @param goodsId 商品id 
	 * @param picturePath 图片存储路径
	 * @throws Exception
	 */
	private void saveGoodsPicture(Long goodsId, 
			String picturePath) throws Exception {
		GoodsPictureDO picture = new GoodsPictureDO();
		picture.setGoodsId(goodsId); 
		picture.setPicturePath(picturePath); 
		picture.setGmtCreate(dateProvider.getCurrentTime()); 
		picture.setGmtModified(dateProvider.getCurrentTime()); 
		
		goodsPictureDAO.save(picture); 
	}
	
	/**
	 * 上传图片
	 * @param picture 图片
	 * @return 图片的存储路径
	 * @throws Exception
	 */
	private String uploadPicture(MultipartFile picture) throws Exception {
		String realUploadDirPath = getRealUploadDirPath();
		return FileUtils.uploadFile(picture, realUploadDirPath);
	}
	
	/**
	 * 获取最终的图片上传路径
	 * @return
	 * @throws Exception
	 */
	private String getRealUploadDirPath() throws Exception {
		String realUploadDirPath = uploadDirPath;
		if(PathType.RELATIVE.equals(uploadDirPathType)) {
			realUploadDirPath += FileUtils.getPathByRelative(uploadDirPath);
		}
		return realUploadDirPath;
	}
	
}
