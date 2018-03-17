package com.zhss.eshop.customer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zhss.eshop.customer.domain.ReturnGoodsWorksheetDO;
import com.zhss.eshop.customer.domain.ReturnGoodsWorksheetQuery;

/**
 * 退货工单管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface ReturnGoodsWorksheetMapper {

	/**
	 * 新增退货工单
	 * @param worksheet 退货工单
	 */
	@Insert("INSERT INTO customer_return_goods_worksheet("
				+ "order_id,"
				+ "order_no,"
				+ "status,"
				+ "return_goods_reason,"
				+ "return_goods_remark,"
				+ "return_goods_logistics_code,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{orderId},"
				+ "#{orderNo},"
				+ "#{status},"
				+ "#{returnGoodsReason},"
				+ "#{returnGoodsRemark},"
				+ "#{returnGoodsLogisticsCode},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")") 
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true) 
	void save(ReturnGoodsWorksheetDO worksheet);
	
	/**
	 * 分页查询退货工单
	 * @param query 查询条件
	 * @return 退货工单
	 */
	@Select("<script>"
			
			+ "SELECT "
				+ "a.id,"
				+ "a.order_id,"
				+ "a.order_no,"
				+ "a.status,"
				+ "a.return_goods_reason,"
				+ "a.return_goods_logistics_code,"
				+ "a.gmt_create,"
				+ "a.gmt_modifieid "
			+ "FROM customer_return_goods_worksheet a,"
			+ "("
				+ "SELECT id "
				+ "FROM customer_return_goods_worksheet "
				+ "WHERE 1=1 "
				
				+ "<if test='orderNo != null'>"
				+ "AND order_no like '${orderNo}%' " 
				+ "</if>"
				
				+ "<if test='status != null'>"
				+ "AND status=#{status} " 
				+ "</if>"
				
				+ "<if test='returnGoodsReason != null'>"
				+ "AND return_goods_reason=#{returnGoodsReason} " 
				+ "</if>"
				
				+ "<if test='returnGoodsLogisticsCode != null'>"
				+ "AND return_goods_logistics_code like '${returnGoodsLogisticsCode}%' "  
				+ "</if>"
				
				+ "LIMIT #{offset},#{size} "
			+ ") b "
			+ "WHERE a.id=b.id"
			
			+ "</script>")
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "order_id", property = "orderId"),
		@Result(column = "order_no", property = "orderNo"),
		@Result(column = "status", property = "status"),
		@Result(column = "return_goods_reason", property = "returnGoodsReason"),
		@Result(column = "return_goods_logistics_code", property = "returnGoodsLogisticsCode"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	List<ReturnGoodsWorksheetDO> listByPage(ReturnGoodsWorksheetQuery query);
	
	/**
	 * 根据id查询退货工单
	 * @param id 退货工单id
	 * @return 退货工单
	 */
	@Select("SELECT "
				+ "id,"
				+ "order_id,"
				+ "order_no,"
				+ "status,"
				+ "return_goods_reason,"
				+ "return_goods_remark,"
 				+ "return_goods_logistics_code,"
				+ "gmt_create,"
				+ "gmt_modifieid "
			+ "FROM customer_return_goods_worksheet "
			+ "WHERE id=#{id}")  
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "order_id", property = "orderId"),
		@Result(column = "order_no", property = "orderNo"),
		@Result(column = "status", property = "status"),
		@Result(column = "return_goods_reason", property = "returnGoodsReason"),
		@Result(column = "return_goods_remark", property = "returnGoodsRemark"),
		@Result(column = "return_goods_logistics_code", property = "returnGoodsLogisticsCode"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	ReturnGoodsWorksheetDO getById(@Param("id") Long id);
	
}
