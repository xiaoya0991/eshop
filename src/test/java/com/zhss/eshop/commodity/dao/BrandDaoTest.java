package com.zhss.eshop.commodity.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.commodity.domain.BrandDO;
import com.zhss.eshop.commodity.domain.BrandQuery;
import com.zhss.eshop.common.constant.CollectionSize;
import com.zhss.eshop.common.util.DateProvider;

/**
 * 评论信息管理模块的DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional(rollbackFor = Exception.class) 
@Rollback(true)
public class BrandDaoTest {

	/**
	 * 评论信息管理模块的DAO组件
	 */
	@Autowired
	private BrandDAO brandDAO;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 测试新增评论信息
	 * @throws Exception
	 */
	@Test
	public void testSaveBrand() throws Exception {
		BrandDO brandDO = createBrandDO();
		assertNotNull(brandDO.getId());
		assertThat(brandDO.getId(), greaterThan(0L));  
	} 
	
	/**
	 * 测试分页查询评论信息
	 * @throws Exception
	 */
	@Test
	public void testListByPage() throws Exception {
		Integer count = 20;
		
		// 构造20条评论数据
		Map<Long, BrandDO> brandMap = new HashMap<Long, BrandDO>(CollectionSize.DEFAULT); 
		for(int i = 0; i < count; i++) {
			BrandDO brand = createBrandDO();
			brandMap.put(brand.getId(), brand);
		}
		
		// 执行分页查询
		Integer offset = 15;
		Integer size = 5;
		
		BrandQuery query = new BrandQuery();
		query.setOffset(offset); 
		query.setSize(size); 
		query.setChineseName("测试");
		query.setEnglishName("test");
		query.setAliasName("测试");   
		
		List<BrandDO> resultBrands = brandDAO.listByPage(query);
		
		// 执行断言
		assertEquals((int)size, resultBrands.size());   
		
		for(BrandDO resultBrand : resultBrands) {
			assertEquals(brandMap.get(resultBrand.getId()), resultBrand);  
		}
	}
	
	/**
	 * 测试根据id查询评论信息
	 * @throws Exception
	 */
	@Test
	public void testGetById() throws Exception {
		BrandDO brand = createBrandDO();
		BrandDO resultBrand = brandDAO.getById(brand.getId());
		assertEquals(brand, resultBrand); 
	}
	
	/**
	 * 测试更新评论
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {
		BrandDO brand = createBrandDO();

		brand.setChineseName("修改后的品牌名称");   
		brand.setGmtModified(dateProvider.getCurrentTime()); 
		brandDAO.update(brand);
		
		BrandDO resultBrand = brandDAO.getById(brand.getId());
		
		assertEquals(brand, resultBrand); 
	}
	
	/**
	 * 测试删除评论
	 * @throws Exception
	 */
	@Test
	public void testRemove() throws Exception {
		BrandDO brand = createBrandDO();
		brandDAO.remove(brand.getId());
		BrandDO resultBrand = brandDAO.getById(brand.getId());
		assertNull(resultBrand); 
	}
	
	/**
	 * 创建一个评论信息DO对象
	 * @return 评论信息DO对象
	 * @throws Exception
	 */
	private BrandDO createBrandDO() throws Exception {
		BrandDO brand = new BrandDO();
		
		brand.setChineseName("测试品牌");
		brand.setEnglishName("test brand");
		brand.setAliasName("测试品牌");  
		brand.setLogoPath("test path");  
		brand.setIntroduction("测试品牌"); 
		brand.setAuthVoucherPath("test path"); 
		brand.setLocation("测试地址"); 
		brand.setRemark("测试品牌"); 
		brand.setGmtCreate(dateProvider.getCurrentTime()); 
		brand.setGmtModified(dateProvider.getCurrentTime()); 
		
		brandDAO.save(brand);
		
		return brand;
	}
	
}
