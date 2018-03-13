package com.zhss.eshop.membership.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.membership.dao.DeliveryAddressDAO;
import com.zhss.eshop.membership.domain.DeliveryAddressDO;
import com.zhss.eshop.membership.mapper.DeliveryAddressMapper;

/**
 * 收货地址管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class DeliveryAddressDAOImpl implements DeliveryAddressDAO {

	/**
	 * 收货地址管理mapper组件
	 */
	@Autowired
	private DeliveryAddressMapper deliveryAddressMapper;
	
	/**
	 * 查询用户账号的所有收货地址
	 * @param userAccountId 用户账号id
	 * @return 所有收货地址
	 */
	public List<DeliveryAddressDO> listAllByUserAccountId(Long userAccountId) {
		return deliveryAddressMapper.listAllByUserAccountId(userAccountId);
	}
	
	/**
	 * 新增收货地址
	 * @param deliveryAddress 收货地址
	 */
	public void save(DeliveryAddressDO deliveryAddress) {
		deliveryAddressMapper.save(deliveryAddress); 
	}
	
	/**
	 * 更新收货地址
	 * @param deliveryAddress 收货地址
	 */
	public void update(DeliveryAddressDO deliveryAddress) {
		deliveryAddressMapper.update(deliveryAddress);
	}
	
	/**
	 * 删除收货地址
	 * @param id 收货地址id
	 */
	public void remove(Long id) {
		deliveryAddressMapper.remove(id);  
	}
	
}
