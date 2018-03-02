package com.zhss.eshop.Inventory.async;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.zhss.eshop.Inventory.dao.StockUpdateMessageDAO;
import com.zhss.eshop.Inventory.domain.StockUpdateMessageDO;
import com.zhss.eshop.common.util.DateProvider;

/**
 * 离线存储管理组件
 * @author zhonghuashishan
 *
 */
@Component
public class OfflineStorageManagerImpl implements OfflineStorageManager {
	
	/**
	 * 库存更新消息管理模块DAO组件
	 */
	@Autowired
	private StockUpdateMessageDAO stockUpdateMessageDAO;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 是否触发离线存储的标识
	 */
	private Boolean offline = false;
	
	/**
	 * 离线存储库存更新消息
	 * @param message 库存更新消息
	 * @throws Exception
	 */
	public void store(StockUpdateMessage message) throws Exception {
		StockUpdateMessageDO stockUpdateMessageDO = createStockUpdateMessageDO(message);
		stockUpdateMessageDAO.save(stockUpdateMessageDO);
	}
	
	/**
	 * 创建库存更新消息DO对象
	 * @param message 库存更新消息
	 * @return 库存更新消息DO对象
	 * @throws Exception
	 */
	private StockUpdateMessageDO createStockUpdateMessageDO(
			StockUpdateMessage message) throws Exception {
		StockUpdateMessageDO stockUpdateMessageDO = new StockUpdateMessageDO();
		stockUpdateMessageDO.setMessageId(message.getId());
		stockUpdateMessageDO.setOperation(message.getOperation());
		stockUpdateMessageDO.setParameter(JSONObject.toJSONString(message.getParameter())); 
		stockUpdateMessageDO.setParamterClazz(message.getParameter().getClass().getName());  
		stockUpdateMessageDO.setGmtCreate(dateProvider.getCurrentTime()); 
		stockUpdateMessageDO.setGmtModified(dateProvider.getCurrentTime()); 
		return stockUpdateMessageDO;
	}

	/**
	 * 获取离线存储标识
	 * @return 离线存储标识
	 */
	public Boolean getOffline() {
		return offline;
	}
	
	/**
	 * 设置离线存储标识
	 * @param offline 离线存储标识
	 */
	public void setOffline(Boolean offline) {
		this.offline = offline;
	}
	
	/**
	 * 判断是否还有下一批库存更新消息
	 * @return 是否还有下一批库存更新消息
	 */
	public Boolean hasNext() {
		return stockUpdateMessageDAO.count().equals(0L) ? false : true;
	}
	
	/**
	 * 获取下一批库存更新消息
	 * @return 下一批库存更新消息
	 */
	public List<StockUpdateMessage> getNextBatch() throws Exception {
		List<StockUpdateMessage> StockUpdateMessages = new ArrayList<StockUpdateMessage>();
		
		List<StockUpdateMessageDO> stockUpdateMessageDOs = 
				stockUpdateMessageDAO.listByBatch();
		for(StockUpdateMessageDO stockUpdateMessageDO : stockUpdateMessageDOs) {
			StockUpdateMessage stockUpdateMessage = new StockUpdateMessage();
			stockUpdateMessage.setId(stockUpdateMessageDO.getMessageId()); 
			stockUpdateMessage.setOperation(stockUpdateMessageDO.getOperation()); 
			stockUpdateMessage.setParameter(JSONObject.parseObject(stockUpdateMessageDO.getParameter(), 
					Class.forName(stockUpdateMessageDO.getParamterClazz())));  
			StockUpdateMessages.add(stockUpdateMessage);
		}
		
		return StockUpdateMessages;
	}
	
	/**
	 * 批量删除库存更新消息
	 * @param stockUpdateMessages 库存更新消息
	 * @throws Exception
	 */
	public void removeByBatch(List<StockUpdateMessage> stockUpdateMessages) throws Exception {
		StringBuilder builder = new StringBuilder("");
		for(int i = 0; i < stockUpdateMessages.size(); i++) {
			builder.append(stockUpdateMessages.get(i).getId());
			if(i < stockUpdateMessages.size() - 1) {
				builder.append(","); 
			}
		}
		stockUpdateMessageDAO.removeByBatch(builder.toString());
	}
	
}
