package com.zhss.eshop.purchase.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zhss.eshop.purchase.domain.PurchaseOrderDO;
import com.zhss.eshop.purchase.domain.PurchaseOrderQuery;

/**
 * 采购单管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface PurchaseOrderMapper {

	/**
	 * 新增采购单
	 * @param purchaseOrder 采购单
	 */
	@Insert("INSERT INTO purchase_order("
				+ "supplier_id,"
				+ "expect_arrival_time,"
				+ "contactor,"
				+ "contactor_phone_number,"
				+ "contactor_email,"
				+ "remark,"
				+ "purchaser,"
				+ "status,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{supplierId},"
				+ "#{expectArrivalTime},"
				+ "#{contactor},"
				+ "#{contactorPhoneNumber},"
				+ "#{contactorEmail},"
				+ "#{remark},"
				+ "#{purchaser},"
				+ "#{status},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")")  
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(PurchaseOrderDO purchaseOrder);
	
	/**
	 * 分页查询采购单
	 * @param query 查询条件
	 * @return 采购单
	 */
	@Select("<script>"
			
			+ "SELECT "
				+ "a.id,"
				+ "a.supplier_id,"
				+ "a.expect_arrival_time,"
				+ "a.contactor,"
				+ "a.contactor_phone_number,"
				+ "a.contactor_email,"
				+ "a.remark,"
				+ "a.purchaser,"
				+ "a.status,"
				+ "a.gmt_create,"
				+ "a.gmt_modified "
			+ "FROM purchase_order a,"
			+ "("
				+ "SELECT id "
				+ "FROM purchase_order "
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
		@Result(column = "contactor", property = "contactor"),
		@Result(column = "contactor_phone_number", property = "contactorPhoneNumber"),
		@Result(column = "contactor_email", property = "contactorEmail"),
		@Result(column = "remark", property = "remark"),
		@Result(column = "purchaser", property = "purchaser"),
		@Result(column = "status", property = "status"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified") 
	})
	List<PurchaseOrderDO> listByPage(PurchaseOrderQuery query);
	
	/**
	 * 根据id查询采购单
	 * @param id 采购单id
	 * @return 采购单
	 */
	@Select("SELECT "
				+ "id,"
				+ "supplier_id,"
				+ "expect_arrival_time,"
				+ "contactor,"
				+ "contactor_phone_number,"
				+ "contactor_email,"
				+ "remark,"
				+ "purchaser,"
				+ "status,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM purchase_order "
			+ "WHERE id=#{id}") 
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "supplier_id", property = "supplierId"),
		@Result(column = "expect_arrival_time", property = "expectArrivalTime"),
		@Result(column = "contactor", property = "contactor"),
		@Result(column = "contactor_phone_number", property = "contactorPhoneNumber"),
		@Result(column = "contactor_email", property = "contactorEmail"),
		@Result(column = "remark", property = "remark"),
		@Result(column = "purchaser", property = "purchaser"),
		@Result(column = "status", property = "status"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified") 
	})
	PurchaseOrderDO getById(@Param("id") Long id); 
	
}
