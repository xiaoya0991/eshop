package com.zhss.eshop.commodity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.zhss.eshop.commodity.dao.BrandDAO;
import com.zhss.eshop.commodity.domain.BrandDO;
import com.zhss.eshop.commodity.domain.BrandDTO;
import com.zhss.eshop.commodity.domain.BrandQuery;
import com.zhss.eshop.commodity.service.BrandService;
import com.zhss.eshop.common.constant.PathType;
import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.common.util.FileUtils;
import com.zhss.eshop.common.util.ObjectUtils;

/**
 * 品牌管理service组件
 * @author zhonghuashishan
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BrandServiceImpl implements BrandService {
	
	/**
	 * 品牌管理DAO组件
	 */
	@Autowired
	private BrandDAO brandDAO;
	/**
	 * logo图片的路径类型
	 */
	@Value("${commodity.brand.image.upload.logo.path.type}") 
	private String logoPathType;
	/**
	 * logo图片的上传路径
	 */
	@Value("${commodity.brand.image.upload.logo.path}")
	private String logoPath;
	/**
	 * 品牌授权认证图片的路径类型
	 */
	@Value("${commodity.brand.image.upload.authVoucher.path.type}") 
	private String authVoucherPathType;
	/**
	 * 品牌授权认证图片的上传路径
	 */
	@Value("${commodity.brand.image.upload.authVoucher.path}")
	private String authVoucherPath; 
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 分页查询品牌
	 * @param query 查询条件
	 * @return 品牌
	 */
	@Override
	public List<BrandDTO> listByPage(BrandQuery query) throws Exception {
		return ObjectUtils.convertList(brandDAO.listByPage(query), BrandDTO.class); 
	}
	
	/**
	 * 根据id查询品牌
	 * @param id 品牌id
	 * @return 品牌
	 */
	@Override
	public BrandDTO getById(Long id) throws Exception {
		return brandDAO.getById(id).clone(BrandDTO.class);
	}

	/**
	 * 新增品牌
	 * @param brand 品牌
	 * @param logoFile logo图片
	 * @param authVoucherFile 品牌授权认证图片
	 */
	@Override
	public void save(BrandDTO brand, MultipartFile logoFile, 
			MultipartFile authVoucherFile) throws Exception {
		String logoPath = uploadLogoFile(logoFile);
		String authVoucherPath = uploadAuthVoucherFile(authVoucherFile);
		
		brand.setLogoPath(logoPath);
		brand.setAuthVoucherPath(authVoucherPath); 
		brand.setGmtCreate(dateProvider.getCurrentTime()); 
		brand.setGmtModified(dateProvider.getCurrentTime()); 
		
		brandDAO.save(brand.clone(BrandDO.class));  
	}
	
	/**
	 * 上传logo图片
	 * @param logoFile
	 * @throws Exception
	 */
	private String uploadLogoFile(MultipartFile logoFile) throws Exception {
		if(logoFile == null) {
			return null;
		}
		
		String uploadDirPath = null;
		if(PathType.RELATIVE.equals(logoPathType)) {
			uploadDirPath = FileUtils.getPathByRelative(logoPath);
		} else {
			uploadDirPath = logoPath;
		}
		
		String uploadFilePath = FileUtils.uploadFile(logoFile, uploadDirPath); 
		
		return uploadFilePath;
	}
	
	/**
	 * 上传品牌授权认证图片
	 * @param logoFile
	 * @throws Exception
	 */
	private String uploadAuthVoucherFile(MultipartFile authVoucherFile) throws Exception {
		if(authVoucherFile == null) {
			return null;
		}
		
		String uploadDirPath = null;
		if(PathType.RELATIVE.equals(authVoucherPathType)) {
			uploadDirPath = FileUtils.getPathByRelative(authVoucherPath);
		} else {
			uploadDirPath = authVoucherPath;
		}
		
		String uploadFilePath = FileUtils.uploadFile(authVoucherFile, uploadDirPath); 
		
		return uploadFilePath;
	}
	
	/**
	 * 编辑品牌
	 * @param brand 品牌
	 */
	@Override
	public void update(BrandDTO brand) throws Exception {
		brand.setGmtModified(dateProvider.getCurrentTime()); 
		brandDAO.update(brand.clone(BrandDO.class)); 
	}
	
	/**
	 * 更新品牌的logo图片
	 * @param id
	 * @param logoFile
	 * @throws Exception
	 */
	@Override
	public void updateLogoPicture(Long id, MultipartFile logoFile) throws Exception {
		BrandDO brand = brandDAO.getById(id);
		
		FileUtils.deleteFile(brand.getLogoPath());
		String logoPath = uploadLogoFile(logoFile);
		
		brand.setGmtModified(dateProvider.getCurrentTime()); 
		brand.setLogoPath(logoPath);
		brandDAO.updateLogoPath(brand); 
	}
	
	/**
	 * 更新品牌的授权书图片
	 * @param id
	 * @param authVoucherFile
	 * @throws Exception
	 */
	@Override
	public void updateAuthVoucherPicture(Long id, MultipartFile authVoucherFile) throws Exception {
		BrandDO brand = brandDAO.getById(id);
		
		FileUtils.deleteFile(brand.getAuthVoucherPath());  
		String authVoucherPath = uploadAuthVoucherFile(authVoucherFile);
		
		brand.setGmtModified(dateProvider.getCurrentTime()); 
		brand.setAuthVoucherPath(authVoucherPath); 
		brandDAO.updateAuthVoucherPath(brand); 
	}
	
	/**
	 * 删除品牌
	 * @param id 品牌id
	 */
	@Override
	public void remove(Long id) throws Exception {
		BrandDO brand = brandDAO.getById(id);
		FileUtils.deleteFile(brand.getLogoPath());
		FileUtils.deleteFile(brand.getAuthVoucherPath());
		brandDAO.remove(id);  
	}
	
}
