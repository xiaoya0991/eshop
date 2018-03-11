package com.zhss.eshop.commodity.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zhss.eshop.commodity.domain.GoodsDetailPictureDTO;
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
	
	/**
	 * 根据id查询商品图片
	 * @param id 商品图片id
	 * @return 商品图片
	 */
	@GetMapping("/show/{id}")
	public void getById(@PathVariable("id") Long id, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		FileInputStream fis = null;
    	
        try {
        	GoodsDetailPictureDTO picture = goodsDetailPictureService.getById(id);
        	
            File file = new File(picture.getPicturePath());
            fis = new FileInputStream(file);
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
        	
            response.setContentType("image/jpg");
            OutputStream out = response.getOutputStream();
            out.write(bytes);  
            out.flush();
        } catch (Exception e) {
        	logger.error("error", e); 
        } finally {
        	if(fis != null ) {
        		try {
					fis.close();
				} catch (IOException e) {
					logger.error("error", e); 
				}
        	}
        }
	}
	
	/**
	 * 根据商品id删除图片
	 * @param goodsId 商品id
	 */
	@DeleteMapping("/{goodsDetailId}")  
	public Boolean batchRemoveByGoodsId(
			@PathVariable("goodsDetailId") Long goodsDetailId) throws Exception {
		try {
			goodsDetailPictureService.batchRemoveByGoodsDetailId(goodsDetailId);
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
}
