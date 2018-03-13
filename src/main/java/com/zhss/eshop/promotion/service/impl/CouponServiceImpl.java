package com.zhss.eshop.promotion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.common.util.ObjectUtils;
import com.zhss.eshop.promotion.dao.CouponDAO;
import com.zhss.eshop.promotion.domain.CouponDO;
import com.zhss.eshop.promotion.domain.CouponDTO;
import com.zhss.eshop.promotion.domain.CouponQuery;
import com.zhss.eshop.promotion.service.CouponService;

/**
 * 优惠券管理service组件
 * @author zhonghuashishan
 *
 */
@Service
@Transactional
public class CouponServiceImpl implements CouponService {
	
	/**
	 * 优惠券管理DAO组件
	 */
	@Autowired
	private CouponDAO couponDAO;

	/**
	 * 分页查询优惠券
	 * @param query 查询条件
	 * @return 优惠券
	 */
	public List<CouponDTO> listByPage(CouponQuery query) throws Exception {
		return ObjectUtils.convertList(couponDAO.listByPage(query), CouponDTO.class);
	}
	
	/**
	 * 新增优惠券
	 * @param coupon 优惠券
	 */
	public void save(CouponDTO coupon) throws Exception {
		couponDAO.save(coupon.clone(CouponDO.class));  
	}
	
	/**
	 * 根据id查询优惠券
	 * @param id 优惠券id
	 * @return 优惠券
	 */
	public CouponDTO getById(Long id) throws Exception {
		return couponDAO.getById(id).clone(CouponDTO.class);
	}
	
	/**
	 * 更新优惠券
	 * @param coupon 优惠券
	 */
	public Boolean update(CouponDTO coupon) throws Exception {
		if(coupon.getReceivedCount() > 0L) {
			return false;
		}
		couponDAO.update(coupon.clone(CouponDO.class));   
		return true;
	}
	
	/**
	 * 删除优惠券
	 * @param id 优惠券id
	 */
	public Boolean remove(Long id) throws Exception {
		CouponDO coupon = couponDAO.getById(id);
		if(coupon.getReceivedCount() > 0L) {
			return false;
		}
		couponDAO.remove(id); 
		return true;
	}
	
}
