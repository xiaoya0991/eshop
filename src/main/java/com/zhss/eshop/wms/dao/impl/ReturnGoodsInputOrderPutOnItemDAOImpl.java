package com.zhss.eshop.wms.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.wms.dao.ReturnGoodsInputOrderPutOnItemDAO;
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderPutOnItemDO;
import com.zhss.eshop.wms.mapper.ReturnGoodsInputOrderPutOnItemMapper;

/**
 * 退货入库单上架条目管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class ReturnGoodsInputOrderPutOnItemDAOImpl implements ReturnGoodsInputOrderPutOnItemDAO {

	/**
	 * 上架条目管理mapper组件
	 */
	@Autowired
	private ReturnGoodsInputOrderPutOnItemMapper putOnItemMapper;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 根据退货入库单条目id查询上架条目
	 * @param returnGoodsInputOrderItemId 退货入库单条目id
	 * @return 上架条目
	 */
	public List<ReturnGoodsInputOrderPutOnItemDO> listByReturnGoodsInputOrderItemId(
			Long returnGoodsInputOrderItemId) throws Exception {
		return putOnItemMapper.listByReturnGoodsInputOrderItemId(returnGoodsInputOrderItemId);
	}
	
	/**
	 * 新增退货入库单上架条目
	 * @param putOnItem 上架条目
	 */
 	public void save(ReturnGoodsInputOrderPutOnItemDO putOnItem) throws Exception {
 		putOnItem.setGmtCreate(dateProvider.getCurrentTime());
 		putOnItem.setGmtModified(dateProvider.getCurrentTime()); 
 		putOnItemMapper.save(putOnItem); 
 	}
	
}
