package com.zhss.eshop.commodity.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.zhss.eshop.commodity.domain.GoodsDetailPictureDTO;

/**
 * 商品详情图片管理service接口
 * @author zhonghuashishan
 *
 */
public interface GoodsDetailPictureService {
	
	/**
	 * 根据id查询商品图片
	 * @param id 商品图片id
	 * @return 商品图片
	 */
	GoodsDetailPictureDTO getById(Long id) throws Exception;

	/**
	 * 批量上传图片
	 * @param goodsDetailId 商品详情id 
	 * @param pictures 商品详情图片  
	 * @return 商品详情图片id
	 * @throws Exception
	 */
	List<Long> batchUploadPicture(Long goodsDetailId, 
			MultipartFile[] pictures) throws Exception;
	
	/**
	 * 根据商品id删除图片
	 * @param goodsId 商品id
	 */
	void batchRemoveByGoodsDetailId(Long goodsDetailId) throws Exception;
	
}
