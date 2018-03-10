package com.zhss.eshop.commodity.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zhss.eshop.commodity.service.GoodsDetailPictureService;

/**
 * 商品详情图片管理controller组件
 * @author zhonghuashishan
 *
 */
@RestController
@RequestMapping("/commodity/detail/picture")  
public class GoodsDetailPictureController {
	
	private static final Logger logger = LoggerFactory.getLogger(
			GoodsDetailPictureController.class);

	/**
	 * 商品详情图片管理service组件
	 */
	@Autowired
	private GoodsDetailPictureService goodsDetailPictureService;
	
	/**
	 * 批量上传图片
	 * @param goodsDetailId 商品详情id 
	 * @param pictures 商品详情图片  
	 * @return 商品详情图片id
	 * @throws Exception
	 */
	@PostMapping("/") 
	public List<Long> batchUploadPicture(Long goodsDetailId, 
			MultipartFile[] pictures) throws Exception {
		try {
			return goodsDetailPictureService.batchUploadPicture(
					goodsDetailId, pictures);
		} catch (Exception e) {  
			logger.error("error", e); 
			return new ArrayList<Long>();
		}
	}
	
}
