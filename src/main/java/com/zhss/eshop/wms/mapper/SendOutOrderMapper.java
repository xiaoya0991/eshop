package com.zhss.eshop.wms.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zhss.eshop.wms.domain.SendOutOrderDO;

/**
 * 发货单管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface SendOutOrderMapper {

	/**
	 * 新增发货单
	 * @param sendOutOrder 发货单
	 */
	@Insert("INSERT INTO wms_send_out_order("
				+ "sale_delivery_order_id," 
				+ "user_account_id,"
				+ "username,"
				+ "order_id," 
				+ "order_no,"
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
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{saleDeliveryOrderId},"  
				+ "#{userAccountId},"
				+ "#{username},"
				+ "#{orderId},"
 				+ "#{orderNo},"
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
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")") 
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(SendOutOrderDO sendOutOrder);
	
	/**
	 * 根据销售出库单id查询发货单
	 * @param saleDeliveryOrderId 销售出库单id
	 * @return 发货单
	 */
	@Select("SELECT "
				+ "id,"
				+ "sale_delivery_order_id," 
				+ "user_account_id,"
				+ "username,"
				+ "order_id," 
				+ "order_no,"
				+ "consignee,"
				+ "delivery_address,"
				+ "consignee_cell_phone_number,"
				+ "total_amount,"
				+ "discount_amount,"
				+ "coupon_amount,"
				+ "freight,"
				+ "payable_amount,"
				+ "pay_type,"
				+ "invoice_title,"
				+ "taxpayer_id,"
				+ "order_comment,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM wms_send_out_order "
			+ "WHERE sale_delivery_order_id=#{saleDeliveryOrderId}"
	)
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "sale_delivery_order_id", property = "saleDeliveryOrderId"), 
		@Result(column = "user_account_id", property = "userAccountId"),
		@Result(column = "username", property = "username"),
		@Result(column = "order_id", property = "orderId"),
		@Result(column = "order_no", property = "orderNo"),
		@Result(column = "consignee", property = "consignee"),
		@Result(column = "total_amount", property = "totalAmount"),
		@Result(column = "discount_amount", property = "discountAmount"),
		@Result(column = "coupon_amount", property = "couponAmount"),
		@Result(column = "freight", property = "freight"),
		@Result(column = "payable_amount", property = "payableAmount"),
		@Result(column = "pay_type", property = "payType"),
		@Result(column = "order_status", property = "orderStatus"),
		@Result(column = "delivery_address", property = "deliveryAddress"),
		@Result(column = "consignee_cell_phone_number", property = "consigneeCellPhoneNumber"),
		@Result(column = "invoice_title", property = "invoiceTitle"),
		@Result(column = "taxpayer_id", property = "taxpayerId"),
		@Result(column = "order_comment", property = "orderComment"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified") 
 	})
	SendOutOrderDO getBySaleDeliveryOrderId(
			@Param("saleDeliveryOrderId") Long saleDeliveryOrderId);
	
}
