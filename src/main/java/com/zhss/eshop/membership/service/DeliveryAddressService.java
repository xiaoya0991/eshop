package com.zhss.eshop.membership.service;

import java.util.List;

import com.zhss.eshop.membership.domain.DeliveryAddressDTO;

/**
 * 收货地址管理service接口
 * @author zhonghuashishan
 *
 */
public interface DeliveryAddressService {

	/**
	 * 查询用户账号的所有收货地址
	 * @param userAccountId 用户账号id
	 * @return 所有收货地址
	 * @throws Exception
	 */
	List<DeliveryAddressDTO> listAllByUserAccountId(Long userAccountId) throws Exception;
	
	/**
	 * 新增收货地址
	 * @param deliveryAddress 收货地址
	 * @throws Exception
	 */
	void save(DeliveryAddressDTO deliveryAddress) throws Exception;
	
	/**
	 * 更新收货地址
	 * @param deliveryAddress 收货地址
	 * @throws Exception
	 */
	void update(DeliveryAddressDTO deliveryAddress) throws Exception; 
	
	/**
	 * 删除收货地址
	 * @param id 收货地址id
	 * @throws Exception
	 */
	void remove(Long id) throws Exception;
	
}
