package com.zhss.eshop.commodity.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 商品图片管理service接口
 * @author zhonghuashishan
 *
 */
public interface GoodsPictureService {

	/**
	 * 批量新增商品图片
	 * @param goodsId 商品id
	 * @param pictures 商品图片
	 * @throws Exception
	 */
	void batchSave(Long goodsId, MultipartFile[] pictures) throws Exception;
	
}
