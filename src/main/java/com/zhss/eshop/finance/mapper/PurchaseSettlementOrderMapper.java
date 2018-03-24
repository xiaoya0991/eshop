package com.zhss.eshop.finance.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zhss.eshop.finance.domain.PurchaseSettlementOrderDO;
import com.zhss.eshop.finance.domain.PurchaseSettlementOrderQuery;

/**
 * 采购结算单管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface PurchaseSettlementOrderMapper {

	/**
	 * 新增采购结算单
	 * @param purchaseSettlementOrder 采购结算单
	 */
	@Insert("INSERT INTO finance_purchase_settlement_order("
				+ "purchase_input_order_id," 
				+ "purchase_order_id,"
				+ "supplier_id,"
				+ "expect_arrival_time,"
				+ "purchase_contactor,"
				+ "purchase_contactor_phone_number,"
				+ "purchase_contactor_email,"
				+ "purchase_order_remark,"
				+ "purchaser,"
				+ "status,"
				+ "total_setlement_amount,"  
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{purchaseInputOrderId},"  
				+ "#{purchaseOrderId},"  
				+ "#{supplierId},"
				+ "#{expectArrivalTime},"
				+ "#{purchaseContactor},"
				+ "#{purchaseContactorPhoneNumber},"
				+ "#{purchaseContactorEmail},"
				+ "#{purchaseOrderRemark},"
				+ "#{purchaser},"
				+ "#{status},"
				+ "#{totalSettlementAmount},"  
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")")  
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(PurchaseSettlementOrderDO purchaseSettlementOrder);
	
	/**
	 * 分页查询采购结算单
	 * @param query 查询条件
	 * @return 采购结算单
	 */
	@Select("<script>"
			
			+ "SELECT "
				+ "a.id,"
				+ "a.purchase_input_order_id,"  
				+ "a.purchase_order_id,"
				+ "a.supplier_id,"
				+ "a.expect_arrival_time,"
				+ "a.actual_arrival_time,"
				+ "a.purchase_contactor,"
				+ "a.purchase_contactor_phone_number,"
				+ "a.purchase_contactor_email,"
				+ "a.purchase_order_remark,"
				+ "a.purchaser,"
				+ "a.status,"
				+ "a.total_settlement_amount," 
				+ "a.gmt_create,"
				+ "a.gmt_modified "
			+ "FROM finance_purchase_settlement_order a,"
			+ "("
				+ "SELECT id "
				+ "FROM finance_purchase_settlement_order "
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
		@Result(column = "purchase_input_order_id", property = "purchaseInputOrderId"), 
		@Result(column = "purchase_order_id", property = "purchaseOrderId"), 
		@Result(column = "supplier_id", property = "supplierId"),
		@Result(column = "expect_arrival_time", property = "expectArrivalTime"),
		@Result(column = "actual_arrival_time", property = "actualArrivalTime"),
		@Result(column = "purchase_contactor", property = "purchaseContactor"),
		@Result(column = "purchase_contactor_phone_number", property = "purchaseContactorPhoneNumber"),
		@Result(column = "purchase_contactor_email", property = "purchaseContactorEmail"),
		@Result(column = "purchase_order_remark", property = "purchaseOrderRemark"),
		@Result(column = "purchaser", property = "purchaser"),
		@Result(column = "status", property = "status"),
		@Result(column = "total_settlement_amount", property = "totalSettlementAmount"), 
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified") 
	})
	List<PurchaseSettlementOrderDO> listByPage(PurchaseSettlementOrderQuery query);
	
	/**
	 * 根据id查询采购结算单
	 * @param id 采购结算单id
	 * @return 采购结算单
	 */
	@Select("SELECT "
				+ "id,"
				+ "purchase_input_order_id,"  
				+ "purchase_order_id,"
				+ "supplier_id,"
				+ "expect_arrival_time,"
				+ "actual_arrival_time,"
				+ "purchase_contactor,"
				+ "purchase_contactor_phone_number,"
				+ "purchase_contactor_email,"
				+ "purchase_order_remark,"
				+ "purchaser,"
				+ "status,"
				+ "total_settlement_amount," 
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM finance_purchase_settlement_order "
			+ "WHERE id=#{id}") 
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "purchase_input_order_id", property = "purchaseInputOrderId"), 
		@Result(column = "purchase_order_id", property = "purchaseOrderId"), 
		@Result(column = "supplier_id", property = "supplierId"),
		@Result(column = "expect_arrival_time", property = "expectArrivalTime"),
		@Result(column = "actual_arrival_time", property = "actualArrivalTime"),
		@Result(column = "purchase_contactor", property = "purchaseContactor"),
		@Result(column = "purchase_contactor_phone_number", property = "purchaseContactorPhoneNumber"),
		@Result(column = "purchase_contactor_email", property = "purchaseContactorEmail"),
		@Result(column = "purchase_order_remark", property = "purchaseOrderRemark"),
		@Result(column = "purchaser", property = "purchaser"),
		@Result(column = "status", property = "status"),
		@Result(column = "total_settlement_amount", property = "totalSettlementAmount"), 
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified") 
	})
	PurchaseSettlementOrderDO getById(@Param("id") Long id); 
	
	/**
	 * 查询指定供应商在指定时间范围内的已完成的采购结算单
	 * @param supplierId 供应商id
	 * @param startTime 起始时间
	 * @param endTime 结束时间
	 * @return 采购结算单
	 */
	@Select("SELECT "
				+ "id,"
				+ "purchase_input_order_id,"  
				+ "purchase_order_id,"
				+ "supplier_id,"
				+ "expect_arrival_time,"
				+ "actual_arrival_time,"
				+ "purchase_contactor,"
				+ "purchase_contactor_phone_number,"
				+ "purchase_contactor_email,"
				+ "purchase_order_remark,"
				+ "purchaser,"
				+ "status,"
				+ "total_settlement_amount," 
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM finance_purchase_settlement_order "
			+ "WHERE supplier_id=#{supplierId} "
			+ "AND gmt_create >= #{startTime} "
			+ "AND gmt_modified <= #{endTime} "
			+ "AND status=3")  
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "purchase_input_order_id", property = "purchaseInputOrderId"), 
		@Result(column = "purchase_order_id", property = "purchaseOrderId"), 
		@Result(column = "supplier_id", property = "supplierId"),
		@Result(column = "expect_arrival_time", property = "expectArrivalTime"),
		@Result(column = "actual_arrival_time", property = "actualArrivalTime"),
		@Result(column = "purchase_contactor", property = "purchaseContactor"),
		@Result(column = "purchase_contactor_phone_number", property = "purchaseContactorPhoneNumber"),
		@Result(column = "purchase_contactor_email", property = "purchaseContactorEmail"),
		@Result(column = "purchase_order_remark", property = "purchaseOrderRemark"),
		@Result(column = "purchaser", property = "purchaser"),
		@Result(column = "status", property = "status"),
		@Result(column = "total_settlement_amount", property = "totalSettlementAmount"), 
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified") 
	})
	List<PurchaseSettlementOrderDO> listFinishedBySettlementPeriod( 
			@Param("supplierId") Long supplierId,
			@Param("startTime") Date startTime,
			@Param("endTime") Date endTime); 
	
	/**
	 * 更新采购结算单
	 * @param purchaseSettlementOrder 采购结算单
	 */
	@Update("UPDATE finance_purchase_settlement_order SET "
				+ "total_settlement_amount=#{totalSettlementAmount},"  
				+ "gmt_modified=#{gmtModified} "
			+ "WHERE id=#{id}")
	void update(PurchaseSettlementOrderDO purchaseSettlementOrder);
	
	/**
	 * 更新采购结算单状态
	 * @param purchaseSettlementOrder 采购结算单
	 */
	@Update("UPDATE finance_purchase_settlement_order SET "
				+ "status=#{status},"
				+ "gmt_modified=#{gmtModified} "
			+ "WHERE id=#{id}") 
	void updateStatus(PurchaseSettlementOrderDO purchaseSettlementOrder);
	
}
