package com.zhss.eshop.commodity.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.zhss.eshop.commodity.domain.BrandDO;
import com.zhss.eshop.commodity.domain.BrandDTO;
import com.zhss.eshop.commodity.domain.BrandQuery;

/**
 * 品牌管理service组件接口
 * @author zhonghuashishan
 *
 */
public interface BrandService {
	
	/**
	 * 分页查询品牌
	 * @param query 查询条件
	 * @return 品牌
	 */
	List<BrandDTO> listByPage(BrandQuery query) throws Exception;
	
	/**
	 * 根据id查询品牌
	 * @param id 品牌id
	 * @return 品牌
	 */
	BrandDTO getById(Long id) throws Exception;

	/**
	 * 新增品牌
	 * @param brand 品牌
	 * @param logoFile logo图片
	 * @param authVoucherFile 品牌授权认证图片
	 */
	void save(BrandDTO brand, MultipartFile logoFile, 
			MultipartFile authVoucherFile) throws Exception;
	
	/**
	 * 编辑品牌
	 * @param brand 品牌
	 */
	void update(BrandDTO brand) throws Exception;
	
	/**
	 * 更新品牌的logo图片
	 * @param id
	 * @param logoFile
	 * @throws Exception
	 */
	void updateLogoPicture(Long id, MultipartFile logoFile) throws Exception;
	
	/**
	 * 更新品牌的授权书图片
	 * @param id
	 * @param authVoucherFile
	 * @throws Exception
	 */
	void updateAuthVoucherPicture(Long id, MultipartFile authVoucherFile) throws Exception;
	
	/**
	 * 删除品牌
	 * @param id 品牌id
	 */
	void remove(Long id) throws Exception;
	
}
