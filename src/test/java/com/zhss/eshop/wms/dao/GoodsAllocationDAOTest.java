package com.zhss.eshop.wms.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import static org.hamcrest.Matchers.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.wms.domain.GoodsAllocationDO;
import com.zhss.eshop.wms.domain.GoodsAllocationQuery;

/**
 * 货位管理DAO组件的单元测试
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional 
@Rollback(true)
public class GoodsAllocationDAOTest {

	/**
	 * 货位管理DAO组件
	 */
	@Autowired
	private GoodsAllocationDAO goodsAllocationDAO;
	
	/**
	 * 测试新增货位
	 * @throws Exception
	 */
	@Test
	public void testSave() throws Exception {
		GoodsAllocationDO goodsAllocation = createGoodsAllocation();
		assertNotNull(goodsAllocation.getId()); 
		assertThat(goodsAllocation.getId(), greaterThan(0L));  
	}
	
	/**
	 * 测试分页查询货位
	 */
	@Test
	@Sql({"clean_goods_allocation.sql"})   
	public void testListByPage() throws Exception {
		int count = 30;
		Map<Long, GoodsAllocationDO> expectedGoodsAllocations = 
				createGoodsAllocations(count);
		
		Integer offset = 20;
		Integer size = 10;
		
		GoodsAllocationQuery query = new GoodsAllocationQuery();
		query.setOffset(offset); 
		query.setSize(size);  
		query.setCode("测试");  
		
		List<GoodsAllocationDO> actualGoodsAllocations = goodsAllocationDAO.listByPage(query);
		
		compareGoodsAllocations(size, expectedGoodsAllocations, actualGoodsAllocations);  
	}
	
	/**
	 * 测试根据id查询货位
	 * @throws Exception
	 */
	@Test
	public void testGetById() throws Exception {
		GoodsAllocationDO expectedGoodsAllocation = createGoodsAllocation();
		GoodsAllocationDO actualGoodsAllocation = goodsAllocationDAO.getById(
				expectedGoodsAllocation.getId());
		assertEquals(expectedGoodsAllocation, actualGoodsAllocation); 
	}
	
	/**
	 * 测试更新货位
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {
		GoodsAllocationDO goodsAllocation = createGoodsAllocation();
		
		goodsAllocation.setRemark("修改后的测试货位备注");  
		goodsAllocationDAO.update(goodsAllocation); 
		
		GoodsAllocationDO resultGoodsAllocation = goodsAllocationDAO.getById(
				goodsAllocation.getId());
		
		assertEquals(goodsAllocation, resultGoodsAllocation); 
	}
	
	/**
	 * 比较两个货位集合
	 * @param goodsAllocationMap
	 * @param goodsAllocations
	 * @throws Exception
	 */
	private void compareGoodsAllocations(
			Integer expectedSize,
			Map<Long, GoodsAllocationDO> expectedGoodsAllocations, 
			List<GoodsAllocationDO> actualGoodsAllocations) throws Exception {
		for(GoodsAllocationDO actualGoodsAllocation : actualGoodsAllocations) {
			GoodsAllocationDO expectedGoodsAllocation = expectedGoodsAllocations.get(
					actualGoodsAllocation.getId());
			assertEquals(expectedGoodsAllocation, actualGoodsAllocation);  
		}
	}
	
	/**
	 * 创建货位集合
	 * @param count
	 * @return
	 * @throws Exception
	 */ 
	private Map<Long, GoodsAllocationDO> createGoodsAllocations(int count) throws Exception {
		Map<Long, GoodsAllocationDO> goodsAllocationMap = new HashMap<Long, GoodsAllocationDO>();
	
		GoodsAllocationDO goodsAllocation = null;
		for(int i = 0; i < count; i++) {
			goodsAllocation = createGoodsAllocation();
			goodsAllocationMap.put(goodsAllocation.getId(), goodsAllocation);
		}
		
		return goodsAllocationMap;
	}
		
	/**
	 * 创建货位
	 * @return 货位
	 * @throws Exception
	 */
	private GoodsAllocationDO createGoodsAllocation() throws Exception {
		GoodsAllocationDO goodsAllocation = new GoodsAllocationDO();
		goodsAllocation.setCode("测试编号"); 
		goodsAllocation.setRemark("测试货位");   
		
		goodsAllocationDAO.save(goodsAllocation);
		
		return goodsAllocation;
	}
	
}
