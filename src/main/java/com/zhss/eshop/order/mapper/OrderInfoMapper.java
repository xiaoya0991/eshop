package com.zhss.eshop.order.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import com.zhss.eshop.order.domain.OrderInfoDO;

/**
 * 订单管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface OrderInfoMapper {

	/**
	 * 新增订单
	 * @param order
	 */
	@Insert("INSERT INTO order_info("
				+ "user_account_id,"
				+ "username,"
				+ "order_no,"
				+ "order_status,"
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
				+ "is_published_comment,"
				+ "confirm_receipt_time,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{userAccountId},"
				+ "#{username},"
				+ "#{orderNo},"
				+ "#{orderStatus},"
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
				+ "#{publishedComment},"
				+ "#{confirmReceiptTime},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")") 
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(OrderInfoDO order);
	
}
