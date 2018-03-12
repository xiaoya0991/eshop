package com.zhss.eshop.promotion.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
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

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.promotion.constant.PromotionActivityStatus;
import com.zhss.eshop.promotion.constant.PromotionActivityType;
import com.zhss.eshop.promotion.domain.PromotionActivityDO;
import com.zhss.eshop.promotion.domain.PromotionActivityGoodsRelationDO;
import com.zhss.eshop.promotion.domain.PromotionActivityQuery;

/**
 * 促销活动管理DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional 
@Rollback(true)
public class PromotionActivityDAOTest {

	/**
	 * 促销活动管理DAO组件
	 */
	@Autowired
	private PromotionActivityDAO promotionActivityDAO;
	/**
	 * 促销活动与商品关联关系管理DAO组件
	 */
	@Autowired
	private PromotionActivityGoodsRelationDAO relationDAO;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 测试分页查询促销活动
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_promotion_activity.sql"})    
	public void testListByPage() throws Exception {
		Integer count = 30;
		Boolean includedRule = false;
		Map<Long, PromotionActivityDO> expectedActivityMap = 
				createPromotionActivityMap(count, includedRule);
		
		Integer expectedSize = 10;
		PromotionActivityQuery query = createPromotionActivityQuery(expectedSize);
		List<PromotionActivityDO> actualActivities = 
				promotionActivityDAO.listByPage(query);
		
		compareActivities(expectedSize, expectedActivityMap, actualActivities); 
	}
	
	/**
	 * 测试根据id查询促销活动
	 * @throws Exception
	 */
	@Test
	public void testGetById() throws Exception {
		PromotionActivityDO expectedActivity = createPromotionActivity();
		PromotionActivityDO actualActivity = promotionActivityDAO.getById(expectedActivity.getId());
		assertEquals(expectedActivity, actualActivity); 
	}
	
	/**
	 * 测试查询全部促销活动
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_promotion_activity.sql"})    
	public void testListAll() throws Exception {
		Integer count = 10;
		Boolean includedRule = true;
		Map<Long, PromotionActivityDO> expectedActivityMap = 
				createPromotionActivityMap(count, includedRule);
		
		List<PromotionActivityDO> actualActivities = promotionActivityDAO.listAll();
		
		compareActivities(count, expectedActivityMap, actualActivities); 
	}
	
	/**
	 * 测试查询指定商品目前可以使用的启用状态的促销活动
	 * @throws Exception
	 */
	@Test
	@Sql({
		"clean_promotion_activity.sql",
		"clean_promotion_activity_goods_relation.sql"
	}) 
	public void testListEnabledByGoodsId() throws Exception {
		Integer activityCount = 2;
		Boolean includedRule = false;
		Map<Long, PromotionActivityDO> expectedActivityMap = 
				createPromotionActivityMap(activityCount, includedRule);
	
		Long[] goodsIds = new Long[]{1L, -999L};
		createPromotionActivityGoodsRelations(expectedActivityMap, goodsIds); 
		
		Long goodsId = 1L;
		List<PromotionActivityDO> actualActivities = 
				promotionActivityDAO.listEnabledByGoodsId(goodsId);
	
		assertEquals((int)activityCount, actualActivities.size());  
		
		for(PromotionActivityDO actualActivity : actualActivities) {
			PromotionActivityDO expectedActivity  = expectedActivityMap.get(actualActivity.getId());
			assertEquals(expectedActivity.getId(), actualActivity.getId()); 
			assertEquals(expectedActivity.getName(), actualActivity.getName());
			assertEquals(expectedActivity.getType(), actualActivity.getType());  
		}
	}
	
	/**
	 * 测试新增促销活动
	 * @throws Exception
	 */
	@Test
	public void testSave() throws Exception {
		PromotionActivityDO activity = createPromotionActivity(); 
		assertNotNull(activity.getId()); 
		assertThat(activity.getId(), greaterThan(0L));  
	}
	
	/**
	 * 测试更新促销活动
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {
		PromotionActivityDO expectedActivity = createPromotionActivity(); 
		
		expectedActivity.setName("修改后的" + expectedActivity.getName());  
		promotionActivityDAO.update(expectedActivity); 
		
		PromotionActivityDO actualActivity = promotionActivityDAO
				.getById(expectedActivity.getId());
		
		assertEquals(expectedActivity, actualActivity);  
	}
	
	/**
	 * 测试更新促销活动的状态
	 * @throws Exception
	 */
	@Test
	public void testUpdateStatus() throws Exception {
		PromotionActivityDO expectedActivity = createPromotionActivity(); 
		
		expectedActivity.setStatus(PromotionActivityStatus.DISABLED);  
		promotionActivityDAO.updateStatus(expectedActivity);   
		
		PromotionActivityDO actualActivity = promotionActivityDAO
				.getById(expectedActivity.getId());
		
		assertEquals(expectedActivity, actualActivity);  
	}
	
	/**
	 * 测试删除促销活动
	 * @throws Exception
	 */
	@Test
	public void testRemove() throws Exception {
		PromotionActivityDO expectedActivity = createPromotionActivity(); 
		promotionActivityDAO.remove(expectedActivity.getId()); 
		PromotionActivityDO actualActivity = promotionActivityDAO
				.getById(expectedActivity.getId());
		assertNull(actualActivity);  
	}
	
	/**
	 * 创建促销活动与商品的关联关系
	 * @param promotionActivityId 促销活动id
	 * @param goodsId 商品id
	 * @throws Exception
	 */
	private void createPromotionActivityGoodsRelations(
			Map<Long, PromotionActivityDO> activityMap, Long[] goodsIds) throws Exception {
		List<PromotionActivityDO> activities = new ArrayList<PromotionActivityDO>(
				activityMap.values());
		
		for(int i = 0; i < activities.size(); i++) {
			PromotionActivityGoodsRelationDO relation = new PromotionActivityGoodsRelationDO();
			relation.setPromotionActivityId(activities.get(i).getId());  
			relation.setGoodsId(goodsIds[i]);  
			relation.setGmtCreate(dateProvider.getCurrentTime()); 
			relation.setGmtModified(dateProvider.getCurrentTime()); 
			relationDAO.save(relation); 
		}
	}
	
	/**
	 * 创建促销活动查询条件
	 * @return 促销活动查询条件
	 * @throws Exception
	 */
	private PromotionActivityQuery createPromotionActivityQuery(
			Integer expectedSize) throws Exception {
		PromotionActivityQuery query = new PromotionActivityQuery();
		query.setOffset(10);
		query.setSize(expectedSize);  
		query.setName("测试");  
		query.setStatus(PromotionActivityStatus.ENABLED); 
		query.setType(PromotionActivityType.REACH_DISCOUNT);  
		query.setStartTime("2018-01-01 00:00:00"); 
		query.setEndTime("2018-01-10 23:59:59");  
		return query;
	}
	
	/**
	 * 比较促销活动集合
	 * @param expectedSize 期望的促销集合大小
	 * @param expectedActivityMap 期望的促销活动集合
	 * @param actualActivities 实际的促销活动集合
	 * @throws Exception
	 */
	private void compareActivities(Integer expectedSize, 
			Map<Long, PromotionActivityDO> expectedActivityMap,
			List<PromotionActivityDO> actualActivities) throws Exception {
		assertEquals((int)expectedSize, actualActivities.size()); 
		
		for(PromotionActivityDO actualActivity : actualActivities) {
			PromotionActivityDO expectedActivity = expectedActivityMap
					.get(actualActivity.getId());
			assertEquals(expectedActivity, actualActivity);  
		}
	}
	
	/**
	 * 创建促销活动map
	 * @param count 促销活动数量
	 * @return
	 * @throws Exception
	 */
	private Map<Long, PromotionActivityDO> createPromotionActivityMap(
			Integer count, Boolean includedRule) throws Exception {
		Map<Long, PromotionActivityDO> activityMap = 
				new HashMap<Long, PromotionActivityDO>();
		
		List<PromotionActivityDO> activities = createPromotionActivities(
				count, includedRule);  
		for(PromotionActivityDO activity : activities) {
			activityMap.put(activity.getId(), activity);
		}
		
		return activityMap;
	}
	
	/**
	 * 创建一个促销活动集合
	 * @return
	 * @throws Exception
	 */
	private List<PromotionActivityDO> createPromotionActivities(
			Integer count, Boolean includedRule) throws Exception {
		List<PromotionActivityDO> activities = new ArrayList<PromotionActivityDO>();
		for(int i = 0; i < count; i++) {
			PromotionActivityDO activity = createPromotionActivity();
			if(!includedRule) {
				activity.setRule(null); 
			}
			activities.add(activity);    
		}
		return activities;
	}
	
	/**
	 * 创建促销活动
	 * @return 促销活动
	 * @throws Exception
	 */
	private PromotionActivityDO createPromotionActivity() throws Exception {
		PromotionActivityDO activity = new PromotionActivityDO();
		activity.setName("测试促销活动");  
		activity.setStartTime(dateProvider.parseDatetime("2018-01-01 10:00:00"));   
		activity.setEndTime(dateProvider.parseDatetime("2018-01-10 10:00:00"));   
		activity.setRemark("测试促销活动");  
		activity.setStatus(PromotionActivityStatus.ENABLED);
		activity.setRule("test");  
		activity.setType(PromotionActivityType.REACH_DISCOUNT); 
		activity.setGmtCreate(dateProvider.getCurrentTime()); 
		activity.setGmtModified(dateProvider.getCurrentTime()); 
		
		promotionActivityDAO.save(activity);
		
		return activity;
	}
	
}
