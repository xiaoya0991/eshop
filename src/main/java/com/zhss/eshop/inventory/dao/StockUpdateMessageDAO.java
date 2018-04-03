package com.zhss.eshop.inventory.dao;

import java.util.List;

import com.zhss.eshop.inventory.domain.StockUpdateMessageDO;

/**
 * 库存更新消息管理模块DAO组件接口
 * @author zhonghuashishan
 *
 */
public interface StockUpdateMessageDAO {

	/**
	 * 新增库存更新消息
	 * @param stockUpdateMessageDO 库存更新消息DO对象
	 * @throws Exception
	 */
	void save(StockUpdateMessageDO stockUpdateMessageDO) throws Exception;
	
	/**
	 * 批量查询库存更新消息：每次50条
	 * @return 库存更新消息DO对象集合
	 * @throws Exception
	 */
	List<StockUpdateMessageDO> listByBatch() throws Exception; 
	
	/**
	 * 批量删除库存更新消息
	 * @param ids 库存更新消息id集合字符串
	 * @throws Exception
	 */
	void removeByBatch(String ids) throws Exception;
	
	/**
	 * 查询库存更新消息记录数
	 * @return 库存更新消息记录数
	 * @throws Exception
	 */
	Long count() throws Exception;
	
}
