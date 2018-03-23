package com.zhss.eshop.wms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zhss.eshop.wms.domain.SaleDeliveryOrderDO;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderQuery;

/**
 * 销售出库单管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface SaleDeliveryOrderMapper {

	/**
	 * 新增销售出库单
	 * @param saleDeliveryOrder
	 */
	@Insert("INSERT INTO wms_sale_delivery_order("
				+ "order_id,"
				+ "order_no," 
				+ "user_account_id,"
				+ "consignee,"
				+ "delivery_address,"
				+ "consignee_cell_phone_number,"
				+ "freight,"
				+ "pay_type,"
				+ "total_amount,"
				+ "discount_amount,"
				+ "coupon_amount,"
				+ "payable_amount,"
				+ "invoice_title,"
				+ "taxpayer_id,"
				+ "order_comment,"
				+ "status,"
				+ "delivery_time,"  
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{orderId},"
				+ "#{orderNo}," 
				+ "#{userAccountId},"
				+ "#{consignee},"
				+ "#{deliveryAddress},"
				+ "#{consigneeCellPhoneNumber},"
				+ "#{freight},"
				+ "#{payType},"
				+ "#{totalAmount},"
				+ "#{discountAmount},"
				+ "#{couponAmount},"
				+ "#{payableAmount},"
				+ "#{invoiceTitle},"
				+ "#{taxpayerId},"
				+ "#{orderComment},"
				+ "#{status},"
				+ "#{deliveryTime},"  
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")") 
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(SaleDeliveryOrderDO saleDeliveryOrder);
	
	/**
	 * 分页查询销售出库单
	 * @param query 查询条件
	 * @return 销售出库单
	 */
	@Select("<script>" 
			
			+ "SELECT "
				+ "a.id,"
				+ "a.gmt_create,"
				+ "a.order_no,"
				+ "a.consignee,"
				+ "a.total_amount,"
				+ "a.discount_amount,"
				+ "a.coupon_amount,"
				+ "a.freight,"
				+ "a.payable_amount,"
				+ "a.pay_type,"
				+ "a.status,"
				+ "a.user_account_id "
			+ "FROM wms_sale_delivery_order a,"
			+ "("
				+ "SELECT id "
				+ "FROM wms_sale_delivery_order "
				+ "WHERE 1=1 "
				
				+ "<if test='status != null'>"
				+ "AND status=#{status} "
				+ "</if>"
				
				+ "LIMIT #{offset},#{size} "  
			+ ") b "
			+ "WHERE a.id=b.id"
			
			+ "</script>"
	)
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "order_no", property = "orderNo"),
		@Result(column = "consignee", property = "consignee"),
		@Result(column = "total_amount", property = "totalAmount"),
		@Result(column = "discount_amount", property = "discountAmount"),
		@Result(column = "coupon_amount", property = "couponAmount"),
		@Result(column = "freight", property = "freight"),
		@Result(column = "payable_amount", property = "payableAmount"),
		@Result(column = "pay_type", property = "payType"),
		@Result(column = "status", property = "status"),
		@Result(column = "user_account_id", property = "userAccountId"),
	})
	List<SaleDeliveryOrderDO> listByPage(SaleDeliveryOrderQuery query);
	
}
