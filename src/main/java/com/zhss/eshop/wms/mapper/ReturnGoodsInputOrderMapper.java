package com.zhss.eshop.wms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderDO;
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderQuery;

/**
 * 退货入库单管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface ReturnGoodsInputOrderMapper {

	/**
	 * 新增退货入库单
	 * @param returnGoodsInputOrder 退货入库单
	 */
	@Insert("INSERT INTO wms_return_goods_input_order("
				+ "user_account_id,"
				+ "order_id,"
				+ "order_no,"
				+ "status,"
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
				+ "return_goods_reason,"
				+ "return_goods_remark,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{userAccountId},"
				+ "#{orderId},"
				+ "#{orderNo},"
				+ "#{status},"
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
				+ "#{returnGoodsReason},"
				+ "#{returnGoodsRemark},"  
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")") 
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(ReturnGoodsInputOrderDO returnGoodsInputOrder);
	
	/**
	 * 分页查询退货入库单
	 * @param query 查询条件
	 * @return 退货入库单
	 */
	@Select("SELECT "
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
			+ "FROM wms_return_goods_input_order a,"
			+ "("
				+ "SELECT id "
				+ "FROM wms_return_goods_input_order "
				+ "LIMIT #{offset},#{size} "  
			+ ") b "
			+ "WHERE a.id=b.id"
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
		@Result(column = "user_account_id", property = "userAccountId")
	})
	List<ReturnGoodsInputOrderDO> listByPage(ReturnGoodsInputOrderQuery query);
	
	/**
	 * 根据id查询退后入库单
	 * @param id 退货入库单id
	 * @return 退后入库单
	 */
	@Select("SELECT "
				+ "id,"
				+ "user_account_id,"
				+ "order_id,"
				+ "order_no,"
				+ "status,"
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
			+ "FROM order_info "
			+ "WHERE id=#{id}"
	)
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "user_account_id", property = "userAccountId"),
		@Result(column = "order_id", property = "orderId"),
		@Result(column = "order_no", property = "orderNo"),
		@Result(column = "status", property = "status"),
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
	ReturnGoodsInputOrderDO getById(@Param("id") Long id);

}
