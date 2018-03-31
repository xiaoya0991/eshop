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

import com.zhss.eshop.commodity.domain.GoodsPictureDTO;
import com.zhss.eshop.commodity.service.GoodsPictureService;

/**
 * 商品图片管理controller组件
 * @author zhonghuashishan
 *
 */
@RestController
@RequestMapping("/commodity/goods/picture")  
public class GoodsPictureController {

	private static final Logger logger = LoggerFactory.getLogger(
			GoodsPictureController.class);
	
	/**
	 * 商品图片管理service组件
	 */
	@Autowired
	private GoodsPictureService goodsPictureService;

	/**
	 * 批量上传图片
	 * @param goodsId 商品id
	 * @param pictures 商品图片
	 * @return 处理结果
	 * @throws Exception
	 */
	@PostMapping("/{goodsId}")  
	public Boolean batchSave(@PathVariable("goodsId") Long goodsId, 
			MultipartFile[] pictures) throws Exception {
		try {
			goodsPictureService.batchSave(goodsId, pictures); 
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 根据商品id查询商品图片id
	 * @param goodsId 商品id
	 * @return 商品图片id
	 */
	@GetMapping("/{goodsId}")  
	public List<Long> listIdsByGoodsId(@PathVariable("goodsId") Long goodsId) 
			throws Exception {
		try {
			return goodsPictureService.listIdsByGoodsId(goodsId);
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
        	GoodsPictureDTO picture = goodsPictureService.getById(id);
        	
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
	@DeleteMapping("/{goodsId}")  
	public Boolean batchRemoveByGoodsId(
			@PathVariable("goodsId") Long goodsId) throws Exception {
		try {
			goodsPictureService.batchRemoveByGoodsId(goodsId);
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
}
