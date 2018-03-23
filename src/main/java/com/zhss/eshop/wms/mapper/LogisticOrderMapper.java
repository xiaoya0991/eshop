package com.zhss.eshop.wms.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import com.zhss.eshop.wms.domain.LogisticOrderDO;

/**
 * 物流单管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface LogisticOrderMapper {

	/**
	 * 新增物流单
	 * @param logisticOrder 物流单
	 */
	@Insert("INSERT INTO wms_logistic_order("
				+ "sale_delivery_order_id,"
				+ "logistic_code,"
				+ "content,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{saleDeliveryOrderId},"
				+ "#{logisticCode},"
				+ "#{content},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")")
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true) 
	void save(LogisticOrderDO logisticOrder);
	
}
