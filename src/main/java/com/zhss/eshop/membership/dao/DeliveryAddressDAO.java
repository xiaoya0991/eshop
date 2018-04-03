package com.zhss.eshop.membership.dao;

import java.util.List;

import com.zhss.eshop.membership.domain.DeliveryAddressDO;

/**
 * 收货地址管理DAO接口
 * @author zhonghuashishan
 *
 */
public interface DeliveryAddressDAO {

	/**
	 * 查询用户账号的所有收货地址
	 * @param userAccountId 用户账号id
	 * @return 所有收货地址
	 */
	List<DeliveryAddressDO> listAllByUserAccountId(Long userAccountId);
	
	/**
	 * 新增收货地址
	 * @param deliveryAddress 收货地址
	 */
	void save(DeliveryAddressDO deliveryAddress);
	
	/**
	 * 更新收货地址
	 * @param deliveryAddress 收货地址
	 */
	void update(DeliveryAddressDO deliveryAddress); 
	
	/**
	 * 删除收货地址
	 * @param id 收货地址id
	 */
	void remove(Long id);
	
}
