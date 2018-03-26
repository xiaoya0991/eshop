package com.zhss.eshop.pay.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zhss.eshop.pay.domain.PayTransactionDO;

/**
 * 支付交易流水管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface PayTransactionMapper {

	/**
	 * 新增支付交易流水
	 * @param payTransaction 支付交易流水
	 */
	@Insert("INSERT INTO pay_transaction("
				+ "order_info_id,"
				+ "order_no,"
				+ "payable_amount,"
				+ "user_account_id,"
				+ "transaction_channel,"
				+ "status,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{orderInfoId},"
				+ "#{orderNo},"
				+ "#{payableAmount},"
				+ "#{userAccountId},"
				+ "#{transactionChannel},"
				+ "#{status},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")") 
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(PayTransactionDO payTransaction);
	
	/**
	 * 根据条件查询支付交易流水
	 * @param parameters 查询参数
	 * @return 支付交易流水
	 */
	@Select("<script>"
			
			+ "SELECT "
				+ "id,"
				+ "order_info_id,"
				+ "order_no,"
				+ "payable_amount,"
				+ "user_account_id,"
				+ "user_pay_account,"
				+ "transaction_channel,"
				+ "transaction_number,"
				+ "finish_pay_time,"
				+ "response_code,"
				+ "status,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM pay_transaction "
			+ "WHERE 1=1 "
			
			+ "<if test='transaction_channel != null'>"
			+ "AND transaction_channel=#{transactionChannel} "
			+ "</if>"
			
			+ "<if test='status != null'>"
			+ "AND status=#{status} "
			+ "</if>"
						
			+ "<if test='orderNo != null'>"
			+ "AND order_no=#{orderNo} "
			+ "</if>"
			
			+ "</script>")
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "order_info_id", property = "orderInfoId"),
		@Result(column = "order_no", property = "orderNo"),
		@Result(column = "payable_amount", property = "payableAmount"),
		@Result(column = "user_account_id", property = "userAccountId"),
		@Result(column = "user_pay_account", property = "userPayAccount"),
		@Result(column = "transaction_channel", property = "transactionChannel"),
		@Result(column = "transaction_number", property = "transactionNumber"),
		@Result(column = "finish_pay_time", property = "finishPayTime"),
		@Result(column = "response_code", property = "responseCode"),
		@Result(column = "status", property = "status"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	List<PayTransactionDO> listByCondition(Map<String, Object> parameters); 
	
	/**
	 * 更新支付交易流水
	 * @param payTransaction 支付交易流水
	 */
	@Update("UPDATE pay_transaction SET "
				+ "user_pay_account=#{userPayAccount},"
				+ "transaction_number=#{transactionNumber},"
				+ "finish_pay_time=#{finishPayTime},"
				+ "response_code=#{responseCode},"
				+ "status=#{status}," 
				+ "gmt_modified=#{gmtModified} "
			+ "WHERE id=#{id}")
	void update(PayTransactionDO payTransaction);
	
}
