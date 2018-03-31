package com.zhss.eshop.wms.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.wms.dao.PurchaseInputOrderPutOnItemDAO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderPutOnItemDO;
import com.zhss.eshop.wms.mapper.PurchaseInputOrderPutOnItemMapper;

/**
 * 采购入库单上架条目管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class PurchaseInputOrderPutOnItemDAOImpl implements PurchaseInputOrderPutOnItemDAO {

	/**
	 * 采购入库单上架条目管理mapper组件
	 */
	@Autowired
	private PurchaseInputOrderPutOnItemMapper putOnItemMapper;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 新增采购入库单上架条目
	 * @param putOnItem 上架条目
	 */
	@Override
 	public void batchSave(List<PurchaseInputOrderPutOnItemDO> putOnItems) throws Exception {
 		for(PurchaseInputOrderPutOnItemDO putOnItem : putOnItems) {
 			putOnItem.setGmtCreate(dateProvider.getCurrentTime()); 
 			putOnItem.setGmtModified(dateProvider.getCurrentTime());  
 			putOnItemMapper.save(putOnItem); 
 		}
 	}
	
	/**
	 * 根据采购入库单条目id查询采购入库单上架条目
	 * @param purchaseInputOrderItemId 采购入库单id
	 * @return 采购入库单上架条目
	 */
	@Override
	public List<PurchaseInputOrderPutOnItemDO> listByPurchaseInputOrderItemId(
			Long purchaseInputOrderItemId) throws Exception {
		return putOnItemMapper.listByPurchaseInputOrderItemId(purchaseInputOrderItemId);
	}
	
}
