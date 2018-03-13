package com.zhss.eshop.Inventory.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.Inventory.dao.StockUpdateMessageDAO;
import com.zhss.eshop.Inventory.mapper.StockUpdateMessageMapper;
import com.zhss.eshop.Inventory.domain.StockUpdateMessageDO;

/**
 * 库存更新消息管理模块DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class StockUpdateMessageDAOImpl implements StockUpdateMessageDAO {

	private static final Logger logger = LoggerFactory.getLogger(StockUpdateMessageDAOImpl.class);
	
	/**
	 * 库存更新消息管理模块mapper组件
	 */
	@Autowired
	private StockUpdateMessageMapper stockUpdateMessageMapper;
	
	/**
	 * 新增库存更新消息
	 * @param stockUpdateMessageDO 库存更新消息DO对象
	 */
	public Boolean save(StockUpdateMessageDO stockUpdateMessageDO) {
		try {
			stockUpdateMessageMapper.save(stockUpdateMessageDO);
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
		return true;
	}
	
	/**
	 * 批量查询库存更新消息：每次50条
	 * @return 库存更新消息DO对象集合
	 */
	public List<StockUpdateMessageDO> listByBatch() {
		try {
			return stockUpdateMessageMapper.listByBatch();
		} catch (Exception e) {
			logger.error("error", e); 
		}
		return null;
	}
	
	/**
	 * 批量删除库存更新消息
	 * @param ids 库存更新消息id集合字符串
	 */
	public Boolean removeByBatch(String ids) {
		try {
			stockUpdateMessageMapper.removeByBatch(ids);
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
		return true;
	}
	
	/**
	 * 查询库存更新消息记录数
	 * @return 库存更新消息记录数
	 */
	public Long count() {
		try {
			return stockUpdateMessageMapper.count();
		} catch (Exception e) {
			logger.error("error", e); 
		}
		return 0L;
	}
	
}
