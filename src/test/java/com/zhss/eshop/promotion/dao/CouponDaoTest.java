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

import com.zhss.eshop.common.constant.CollectionSize;
import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.promotion.constant.CouponGiveOutType;
import com.zhss.eshop.promotion.constant.CouponStatus;
import com.zhss.eshop.promotion.constant.CouponType;
import com.zhss.eshop.promotion.domain.CouponDO;
import com.zhss.eshop.promotion.domain.CouponQuery;

/**
 * 优惠券管理DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional(rollbackFor = Exception.class) 
@Rollback(true)
public class CouponDaoTest {

	/**
	 * 优惠券管理DAO组件
	 */
	@Autowired
	private CouponDAO couponDAO;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 测试分页查询优惠券
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_coupon.sql"})    
	public void testListByPage() throws Exception {
		Integer count = 30;
		Boolean includedRule = false;
		Map<Long, CouponDO> expectedCouponMap = createCouponMap(count, includedRule);
		
		Integer expectedSize = 10;
		CouponQuery query = createCouponQuery(expectedSize);
		List<CouponDO> actualCoupons = couponDAO.listByPage(query);
		
		compareCoupons(expectedSize, expectedCouponMap, actualCoupons); 
	}
	
	/**
	 * 测试根据id查询优惠券
	 * @throws Exception
	 */
	@Test
	public void testGetById() throws Exception {
		CouponDO expectedCoupon = createCoupon();
		CouponDO actualCoupon = couponDAO.getById(expectedCoupon.getId());
		assertEquals(expectedCoupon, actualCoupon); 
	}
	
	/**
	 * 测试查询全部优惠券
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_coupon.sql"})    
	public void testListAll() throws Exception {
		Integer count = 10;
		Boolean includedRule = false;
		Map<Long, CouponDO> expectedCouponMap = createCouponMap(count, includedRule);
		
		List<CouponDO> actualCoupons = couponDAO.listAll();
		
		compareCoupons(count, expectedCouponMap, actualCoupons); 
	}
	
	/**
	 * 测试新增优惠券
	 * @throws Exception
	 */
	@Test
	public void testSave() throws Exception {
		CouponDO coupon = createCoupon(); 
		assertNotNull(coupon.getId()); 
		assertThat(coupon.getId(), greaterThan(0L));  
	}
	
	/**
	 * 测试更新优惠券
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {
		CouponDO expectedCoupon = createCoupon(); 
		
		expectedCoupon.setName("修改后的" + expectedCoupon.getName());  
		couponDAO.update(expectedCoupon); 
		
		CouponDO actualCoupon = couponDAO.getById(expectedCoupon.getId());
		
		assertEquals(expectedCoupon, actualCoupon);  
	}
	
	/**
	 * 测试删除优惠券
	 * @throws Exception
	 */
	@Test
	public void testRemove() throws Exception {
		CouponDO expectedCoupon = createCoupon(); 
		couponDAO.remove(expectedCoupon.getId()); 
		CouponDO actualCoupon = couponDAO.getById(expectedCoupon.getId());
		assertNull(actualCoupon);  
	}
	
	/**
	 * 创建优惠券查询条件
	 * @return 优惠券查询条件
	 * @throws Exception
	 */
	private CouponQuery createCouponQuery(
			Integer expectedSize) throws Exception {
		CouponQuery query = new CouponQuery();
		query.setOffset(0);
		query.setSize(expectedSize);  
		query.setName("测试");  
		return query;
	}
	
	/**
	 * 比较优惠券集合
	 * @param expectedSize 期望的促销集合大小
	 * @param expectedCouponMap 期望的优惠券集合
	 * @param actualCoupons 实际的优惠券集合
	 * @throws Exception
	 */
	private void compareCoupons(
			Integer expectedSize, 
			Map<Long, CouponDO> expectedCouponMap,
			List<CouponDO> actualCoupons) throws Exception {
		assertEquals((int)expectedSize, actualCoupons.size()); 
		for(CouponDO actualCoupon : actualCoupons) {
			CouponDO expectedCoupon = expectedCouponMap.get(actualCoupon.getId());
			assertEquals(expectedCoupon, actualCoupon);  
		}
	}
	
	/**
	 * 创建优惠券map
	 * @param count 优惠券数量
	 * @return
	 * @throws Exception
	 */
	private Map<Long, CouponDO> createCouponMap(
			Integer count, Boolean includedRule) throws Exception {
		Map<Long, CouponDO> couponMap = 
				new HashMap<Long, CouponDO>(CollectionSize.DEFAULT);
		
		List<CouponDO> coupons = createCoupons(
				count, includedRule);  
		for(CouponDO coupon : coupons) {
			couponMap.put(coupon.getId(), coupon);
		}
		
		return couponMap;
	}
	
	/**
	 * 创建一个优惠券集合
	 * @return
	 * @throws Exception
	 */
	private List<CouponDO> createCoupons(
			Integer count, Boolean includedRule) throws Exception {
		List<CouponDO> coupons = new ArrayList<CouponDO>();
		for(int i = 0; i < count; i++) {
			CouponDO coupon = createCoupon();
			if(!includedRule) {
				coupon.setRule(null); 
			}
			coupons.add(coupon);    
		}
		return coupons;
	}
	
	/**
	 * 创建优惠券
	 * @return 优惠券
	 * @throws Exception
	 */
	private CouponDO createCoupon() throws Exception {
		CouponDO coupon = new CouponDO();
		
		coupon.setName("测试优惠券");  
		coupon.setType(CouponType.REACH_DISCOUNT_COUPON);  
		coupon.setRule("测试规则"); 
		coupon.setValidStartTime(dateProvider.parseDatetime("2018-01-01 10:00:00"));   
		coupon.setValidEndTime(dateProvider.parseDatetime("2018-01-10 10:00:00"));   
		coupon.setGiveOutCount(1000L); 
		coupon.setReceivedCount(0L); 
		coupon.setGiveOutType(CouponGiveOutType.ACHIEVABLE_AND_GIVE_OUT);  
		coupon.setStatus(CouponStatus.GIVING_OUT); 
		coupon.setGmtCreate(dateProvider.getCurrentTime()); 
		coupon.setGmtModified(dateProvider.getCurrentTime()); 
		
		couponDAO.save(coupon);
		
		return coupon;
	}
	
}
