package com.zhss.eshop.commodity.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/**
 * 商品详情图片管理service接口
 * @author zhonghuashishan
 *
 */
public interface GoodsDetailPictureService {

	/**
	 * 批量上传图片
	 * @param goodsDetailId 商品详情id 
	 * @param pictures 商品详情图片  
	 * @return 商品详情图片id
	 * @throws Exception
	 */
	List<Long> batchUploadPicture(Long goodsDetailId, 
			MultipartFile[] pictures) throws Exception;
	
}
