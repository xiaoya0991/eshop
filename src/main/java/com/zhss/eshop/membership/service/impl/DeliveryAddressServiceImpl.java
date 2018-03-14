package com.zhss.eshop.membership.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.common.util.ObjectUtils;
import com.zhss.eshop.membership.dao.DeliveryAddressDAO;
import com.zhss.eshop.membership.domain.DeliveryAddressDO;
import com.zhss.eshop.membership.domain.DeliveryAddressDTO;
import com.zhss.eshop.membership.service.DeliveryAddressService;

/**
 * 收货地址管理service组件
 * @author zhonghuashishan
 *
 */
@Service
@Transactional
public class DeliveryAddressServiceImpl implements DeliveryAddressService {

	/**
	 * 收货地址管理DAO组件
	 */
	@Autowired
	private DeliveryAddressDAO deliveryAddressDAO;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 查询用户账号的所有收货地址
	 * @param userAccountId 用户账号id
	 * @return 所有收货地址
	 */
	public List<DeliveryAddressDTO> listAllByUserAccountId(
			Long userAccountId) throws Exception {
		return ObjectUtils.convertList(deliveryAddressDAO.listAllByUserAccountId(userAccountId), 
				DeliveryAddressDTO.class); 
	}
	
	/**
	 * 新增收货地址
	 * @param deliveryAddress 收货地址
	 */
	public void save(DeliveryAddressDTO deliveryAddress) throws Exception {
		deliveryAddress.setGmtCreate(dateProvider.getCurrentTime()); 
		deliveryAddress.setGmtModified(dateProvider.getCurrentTime()); 
		deliveryAddressDAO.save(deliveryAddress.clone(DeliveryAddressDO.class));   
	}
	
	/**
	 * 更新收货地址
	 * @param deliveryAddress 收货地址
	 */
	public void update(DeliveryAddressDTO deliveryAddress) throws Exception {
		deliveryAddress.setGmtModified(dateProvider.getCurrentTime()); 
		deliveryAddressDAO.update(deliveryAddress.clone(DeliveryAddressDO.class));   
	}
	
	/**
	 * 删除收货地址
	 * @param id 收货地址id
	 */
	public void remove(Long id) throws Exception {
		deliveryAddressDAO.remove(id);
	}
	
}
