package com.zhss.eshop.wms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zhss.eshop.wms.domain.PurchaseInputOrderDO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderQuery;

/**
 * 采购入库单管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface PurchaseInputOrderMapper {

	/**
	 * 新增采购入库单
	 * @param purchaseInputOrder 采购入库单
	 */
	@Insert("INSERT INTO wms_purchase_input_order("
				+ "supplier_id,"
				+ "expect_arrival_time,"
				+ "purchase_contactor,"
				+ "purchase_contactor_phone_number,"
				+ "purchase_contactor_email,"
				+ "purchase_order_remark,"
				+ "purchaser,"
				+ "status,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{supplierId},"
				+ "#{expectArrivalTime},"
				+ "#{purchaseContactor},"
				+ "#{purchaseContactorPhoneNumber},"
				+ "#{purchaseContactorEmail},"
				+ "#{purchaseOrderRemark},"
				+ "#{purchaser},"
				+ "#{status},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")")  
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(PurchaseInputOrderDO purchaseInputOrder);
	
	/**
	 * 分页查询采购入库单
	 * @param query 查询条件
	 * @return 采购入库单
	 */
	@Select("<script>"
			
			+ "SELECT "
				+ "a.id,"
				+ "a.supplier_id,"
				+ "a.expect_arrival_time,"
				+ "a.actual_arrival_time,"
				+ "a.purchase_contactor,"
				+ "a.purchase_contactor_phone_number,"
				+ "a.purchase_contactor_email,"
				+ "a.purchase_order_remark,"
				+ "a.purchaser,"
				+ "a.status,"
				+ "a.gmt_create,"
				+ "a.gmt_modified "
			+ "FROM wms_purchase_input_order a,"
			+ "("
				+ "SELECT id "
				+ "FROM wms_purchase_input_order "
				+ "WHERE 1=1 "
				
				+ "<if test='supplierId != null'>"
				+ "AND supplier_id=#{supplierId} "
				+ "</if>"
				
				+ "<if test='status != null'>"
				+ "AND status=#{status} "
				+ "</if>"
 				
				+ "LIMIT #{offset},#{size} "
			+ ") b "
			+ "WHERE a.id=b.id"
			
			+ "</script>")
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "supplier_id", property = "supplierId"),
		@Result(column = "expect_arrival_time", property = "expectArrivalTime"),
		@Result(column = "actual_arrival_time", property = "actualArrivalTime"),
		@Result(column = "purchase_contactor", property = "purchaseContactor"),
		@Result(column = "purchase_contactor_phone_number", property = "purchaseContactorPhoneNumber"),
		@Result(column = "purchase_contactor_email", property = "purchaseContactorEmail"),
		@Result(column = "purcahse_order_remark", property = "purchaseOrderRemark"),
		@Result(column = "purchaser", property = "purchaser"),
		@Result(column = "status", property = "status"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified") 
	})
	List<PurchaseInputOrderDO> listByPage(PurchaseInputOrderQuery query);
	
	/**
	 * 根据id查询采购入库单
	 * @param id 采购入库单id
	 * @return 采购入库单
	 */
	@Select("SELECT "
				+ "id,"
				+ "supplier_id,"
				+ "expect_arrival_time,"
				+ "actual_arrival_time,"
				+ "purchase_contactor,"
				+ "purchase_contactor_phone_number,"
				+ "purchase_contactor_email,"
				+ "purchase_order_remark,"
				+ "purchaser,"
				+ "status,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM wms_purchase_input_order "
			+ "WHERE id=#{id}") 
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "supplier_id", property = "supplierId"),
		@Result(column = "expect_arrival_time", property = "expectArrivalTime"),
		@Result(column = "actual_arrival_time", property = "actualArrivalTime"),
		@Result(column = "purchase_contactor", property = "purchaseContactor"),
		@Result(column = "purchase_contactor_phone_number", property = "purchaseContactorPhoneNumber"),
		@Result(column = "purchase_contactor_email", property = "purchaseContactorEmail"),
		@Result(column = "purcahse_order_remark", property = "purchaseOrderRemark"),
		@Result(column = "purchaser", property = "purchaser"),
		@Result(column = "status", property = "status"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified") 
	})
	PurchaseInputOrderDO getById(@Param("id") Long id); 
	
	/**
	 * 更新采购入库单
	 * @param purchaseInputOrder 采购入库单
	 */
	@Update("UPDATE wms_purchase_input_order SET "
				+ "actual_arrival_time=#{actualArrivalTime},"
				+ "gmt_modified=#{gmtModified} "
			+ "WHERE id=#{id}")
	void update(PurchaseInputOrderDO purchaseInputOrder);
	
	/**
	 * 更新采购入库单状态
	 * @param purchaseInputOrder 采购入库单
	 */
	@Update("UPDATE wms_purchase_input_order SET "
				+ "status=#{status},"
				+ "gmt_modified=#{gmtModified} "
			+ "WHERE id=#{id}") 
	void updateStatus(PurchaseInputOrderDO purchaseInputOrder);
	
}
