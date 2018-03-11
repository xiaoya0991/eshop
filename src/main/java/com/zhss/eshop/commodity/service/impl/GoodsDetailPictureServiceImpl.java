package com.zhss.eshop.commodity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.zhss.eshop.commodity.dao.GoodsDetailPictureDAO;
import com.zhss.eshop.commodity.domain.GoodsDetailPictureDO;
import com.zhss.eshop.commodity.domain.GoodsDetailPictureDTO;
import com.zhss.eshop.commodity.service.GoodsDetailPictureService;
import com.zhss.eshop.common.constant.PathType;
import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.common.util.FileUtils;

/**
 * 商品详情图片管理service组件
 * @author zhonghuashishan
 *
 */
@Service
@Transactional
public class GoodsDetailPictureServiceImpl implements GoodsDetailPictureService {

	/**
	 * 商品详情图片管理DAO组件
	 */
	@Autowired
	private GoodsDetailPictureDAO goodsDetailPictureDAO;
	/**
	 * 图片上传路径的类型
	 */
	@Value("${commodity.goods.image.upload.detail.picture.path.type}") 
	private String uploadDirPathType;
	/**
	 * 图片上传路径
	 */
	@Value("${commodity.goods.image.upload.detail.picture.path}")  
	private String uploadDirPath;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 根据id查询商品图片
	 * @param id 商品图片id
	 * @return 商品图片
	 */
	public GoodsDetailPictureDTO getById(Long id) throws Exception {
		return goodsDetailPictureDAO.getById(id).clone(GoodsDetailPictureDTO.class);
	}
	
	/**
	 * 批量上传图片
	 * @param goodsDetailId 商品详情id 
	 * @param pictures 商品详情图片  
	 * @return 商品详情图片id
	 * @throws Exception
	 */
	public List<Long> batchUploadPicture(Long goodsDetailId, 
			MultipartFile[] pictures) throws Exception {
		List<Long> ids = new ArrayList<Long>();
		for(MultipartFile picture : pictures) {
			String picturePath = uploadPicture(picture);
			ids.add(saveGoodsDetailPicture(goodsDetailId, picturePath));
		}
		return ids;
	}
	
	/**
	 * 新增商品图片
	 * @param goodsId 商品id 
	 * @param picturePath 图片存储路径
	 * @throws Exception
	 */
	private Long saveGoodsDetailPicture(Long goodsDetailId, 
			String picturePath) throws Exception {
		GoodsDetailPictureDO picture = new GoodsDetailPictureDO();
		picture.setGoodsDetailId(goodsDetailId); 
		picture.setPicturePath(picturePath); 
		picture.setGmtCreate(dateProvider.getCurrentTime()); 
		picture.setGmtModified(dateProvider.getCurrentTime()); 
		
		return goodsDetailPictureDAO.save(picture); 
	}
	
	/**
	 * 根据商品id删除图片
	 * @param goodsId 商品id
	 */
	public void batchRemoveByGoodsDetailId(Long goodsDetailId) throws Exception {
		List<GoodsDetailPictureDO> pictures = goodsDetailPictureDAO
				.listByGoodsDetailId(goodsDetailId);
		for(GoodsDetailPictureDO picture : pictures) {
			FileUtils.deleteFile(picture.getPicturePath());
		}
		goodsDetailPictureDAO.removeByGoodsDetailId(goodsDetailId);  
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
