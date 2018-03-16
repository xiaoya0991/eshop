package com.zhss.eshop.promotion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zhss.eshop.promotion.domain.CouponDO;
import com.zhss.eshop.promotion.domain.CouponQuery;

/**
 * 优惠券管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface CouponMapper {

	/**
	 * 分页查询优惠券
	 * @param query 查询条件
	 * @return 优惠券
	 */
	@Select("<script>"
			
			+ "SELECT "
				+ "a.id,"
				+ "a.name,"
				+ "a.type,"
				+ "a.valid_start_time,"
				+ "a.valid_end_time,"
				+ "a.give_out_count,"
				+ "a.received_count,"
				+ "a.give_out_type,"
				+ "a.status,"
				+ "a.gmt_create,"
				+ "a.gmt_modified "
			+ "FROM promotion_coupon a,"
			+ "("
				+ "SELECT id "
				+ "FROM promotion_coupon "
				+ "WHERE 1=1 "
				
				+ "<if test='name != null'>"
				+ "AND name like '${name}%' "  
				+ "</if>"
				
				+ "<if test='type != null'>"
				+ "AND type=#{type} "  
				+ "</if>"
				
				+ "<if test='validStartTime != null'>"
				+ "AND valid_start_time >= #{validStartTime}  "  
				+ "</if>"
				
				+ "<if test='validEndTime != null'>"
				+ "AND valid_end_time &lt;= #{validEndTime} "   
				+ "</if>"
				
				+ "<if test='giveOutType != null'>"
				+ "AND give_out_type = #{giveOutType} "   
				+ "</if>"
				
				+ "<if test='status != null'>"
				+ "AND status = #{status} "   
				+ "</if>"
				
				+ "LIMIT #{offset},#{size} "
			+ ") b "
			+ "WHERE a.id=b.id"
			
			+ "</script>")  
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "name", property = "name"),
		@Result(column = "type", property = "type"),
		@Result(column = "valid_start_time", property = "validStartTime"),
		@Result(column = "valid_end_time", property = "validEndTime"),
		@Result(column = "give_out_count", property = "giveOutCount"),
		@Result(column = "received_count", property = "receivedCount"),
		@Result(column = "give_out_type", property = "giveOutType"),
		@Result(column = "status", property = "status"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified") 
	})
	List<CouponDO> listByPage(CouponQuery query);
	
	/**
	 * 查询所有优惠券
	 * @return 所有优惠券
	 */
	@Select("SELECT "
				+ "id,"
				+ "name,"
				+ "type,"
				+ "valid_start_time,"
				+ "valid_end_time,"
				+ "give_out_count,"
				+ "received_count,"
				+ "give_out_type,"
				+ "status,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM promotion_coupon ")  
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "name", property = "name"),
		@Result(column = "type", property = "type"),
		@Result(column = "valid_start_time", property = "validStartTime"),
		@Result(column = "valid_end_time", property = "validEndTime"),
		@Result(column = "give_out_count", property = "giveOutCount"),
		@Result(column = "received_count", property = "receivedCount"),
		@Result(column = "give_out_type", property = "giveOutType"),
		@Result(column = "status", property = "status"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified") 
	})
	List<CouponDO> listAll();
	
	/**
	 * 新增优惠券
	 * @param coupon 优惠券
	 */
	@Insert("INSERT INTO promotion_coupon("
				+ "name,"
				+ "type,"
				+ "rule,"
 				+ "valid_start_time,"
				+ "valid_end_time,"
				+ "give_out_count,"
				+ "received_count,"
				+ "give_out_type,"
				+ "status,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{name},"
				+ "#{type},"
				+ "#{rule}," 
				+ "#{validStartTime},"
				+ "#{validEndTime},"
				+ "#{giveOutCount},"
				+ "#{receivedCount},"
				+ "#{giveOutType},"
				+ "#{status},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")") 
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true) 
	void save(CouponDO coupon);
	
	/**
	 * 根据id查询优惠券
	 * @param id 优惠券id
	 * @return 优惠券
	 */
	@Select("SELECT "
				+ "id,"
				+ "name,"
				+ "type,"
				+ "rule," 
				+ "valid_start_time,"
				+ "valid_end_time,"
				+ "give_out_count,"
				+ "received_count,"
				+ "give_out_type,"
				+ "status,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM promotion_coupon "
			+ "WHERE id=#{id}")  
	@Results({ 
		@Result(column = "id", property = "id", id = true),
		@Result(column = "name", property = "name"),
		@Result(column = "type", property = "type"),
		@Result(column = "rule", property = "rule"), 
		@Result(column = "valid_start_time", property = "validStartTime"),
		@Result(column = "valid_end_time", property = "validEndTime"),
		@Result(column = "give_out_count", property = "giveOutCount"),
		@Result(column = "received_count", property = "receivedCount"),
		@Result(column = "give_out_type", property = "giveOutType"),
		@Result(column = "status", property = "status"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified") 
	})
	CouponDO getById(@Param("id") Long id);
	
	/**
	 * 更新优惠券
	 * @param coupon 优惠券
	 */
	@Update("UPDATE promotion_coupon SET "
				+ "name=#{name},"
				+ "type=#{type},"
				+ "rule=#{rule},"
				+ "valid_start_time=#{validStartTime},"
				+ "valid_end_time=#{validEndTime},"
				+ "give_out_count=#{giveOutCount},"
				+ "received_count=#{receivedCount},"
				+ "give_out_type=#{giveOutType},"
				+ "gmt_modified=#{gmtModified} "
			+ "WHERE id=#{id}")  
	void update(CouponDO coupon);
	
	/**
	 * 更新优惠券状态
	 * @param coupon 优惠券
	 */
	@Update("UPDATE promotion_coupon SET "
				+ "status=#{status}," 
				+ "gmt_modified=#{gmtModified} "
			+ "WHERE id=#{id}")  
	void updateStatus(CouponDO coupon);
	
	/**
	 * 删除优惠券
	 * @param id 优惠券id
	 */
	@Delete("DELETE FROM promotion_coupon WHERE id=#{id}")    
	void remove(@Param("id") Long id);
	
}
