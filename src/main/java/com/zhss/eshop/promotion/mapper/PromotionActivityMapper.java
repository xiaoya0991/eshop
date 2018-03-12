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

import com.zhss.eshop.promotion.domain.PromotionActivityDO;
import com.zhss.eshop.promotion.domain.PromotionActivityQuery;

/**
 * 促销活动管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface PromotionActivityMapper {

	/**
	 * 分页查询促销活动
	 * @param query 查询条件
	 * @return 促销活动
	 */
	@Select("<script>"
			
			+ "SELECT "
				+ "a.id,"
				+ "a.name,"
				+ "a.start_time,"
				+ "a.end_time,"
				+ "a.remark,"
				+ "a.status,"
				+ "a.type,"
				+ "a.gmt_create,"
				+ "a.gmt_modified "
			+ "FROM promotion_activity a, "
			+ "("
				+ "SELECT id "
				+ "FROM promotion_activity "
				+ "WHERE 1=1 "
				
				+ "<if test='name != null'>"
				+ "AND name like '${name}%' "
				+ "</if>"
				
				+ "<if test='startTime != null'>"
				+ "AND start_time >= #{startTime} " 
				+ "</if>"
				
				+ "<if test='endTime != null'>"
				+ "AND end_time &lt;= #{endTime} "  
				+ "</if>"
				
				+ "<if test='status != null'>"
				+ "AND status = #{status} "  
				+ "</if>"
				
				+ "<if test='type != null'>"
				+ "AND type = #{type} "  
				+ "</if>"
				
				+ "LIMIT #{offset},#{size} "
			+ ") b "
			+ "WHERE a.id=b.id"
			
			+ "</script>")  
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "name", property = "name"),
		@Result(column = "start_time", property = "startTime"),
		@Result(column = "end_time", property = "endTime"),
		@Result(column = "remark", property = "remark"),
		@Result(column = "status", property = "status"),
		@Result(column = "type", property = "type"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	List<PromotionActivityDO> listByPage(PromotionActivityQuery query);
	
	/**
	 * 根据id查询促销活动
	 * @param id 促销活动id
	 * @return 促销活动
	 */
	@Select("SELECT "
				+ "id,"
				+ "name,"
				+ "start_time,"
				+ "end_time,"
				+ "remark,"
				+ "status,"
				+ "type,"
				+ "rule," 
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM promotion_activity "
			+ "WHERE id=#{id}")  
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "name", property = "name"),
		@Result(column = "start_time", property = "startTime"),
		@Result(column = "end_time", property = "endTime"),
		@Result(column = "remark", property = "remark"),
		@Result(column = "status", property = "status"),
		@Result(column = "type", property = "type"),
		@Result(column = "rule", property = "rule"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	PromotionActivityDO getById(@Param("id") Long id);
	
	/**
	 * 查询全部促销活动
	 * @return 促销活动
	 */
	@Select("SELECT "
				+ "id,"
				+ "name,"
				+ "start_time,"
				+ "end_time,"
				+ "remark,"
				+ "status,"
				+ "type,"
				+ "rule," 
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM promotion_activity")  
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "name", property = "name"),
		@Result(column = "start_time", property = "startTime"),
		@Result(column = "end_time", property = "endTime"),
		@Result(column = "remark", property = "remark"),
		@Result(column = "status", property = "status"),
		@Result(column = "type", property = "type"),
		@Result(column = "rule", property = "rule"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	List<PromotionActivityDO> listAll(); 
	
	/**
	 * 查询指定商品目前可以使用的启用状态的促销活动
	 * @param goodsId 商品id
	 * @return 促销活动
	 */
	@Select("SELECT "
				+ "pa.id,"
				+ "pa.name,"
				+ "pa.type "
			+ "FROM promotion_activity pa "
			+ "JOIN promotion_activity_goods_relation pagr ON pa.id=pagr.promotion_activity_id "
			+ "WHERE (pagr.goods_id=#{goodsId} OR pagr.goods_id=-999) "
			+ "AND pa.status=1 ")
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "name", property = "name"),
		@Result(column = "type", property = "type")
	})
	List<PromotionActivityDO> listEnabledByGoodsId(
			@Param("goodsId") Long goodsId);
	
	/**
	 * 新增促销活动
	 * @param activity 促销活动
	 */
	@Insert("INSERT INTO promotion_activity("
				+ "name,"
				+ "start_time,"
				+ "end_time,"
				+ "remark,"
				+ "status,"
				+ "type,"
				+ "rule,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{name},"
				+ "#{startTime},"
				+ "#{endTime},"
				+ "#{remark},"
				+ "#{status},"
				+ "#{type},"
				+ "#{rule},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")") 
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(PromotionActivityDO activity);
	
	/**
	 * 更新促销活动
	 * @param activity 促销活动
	 */
	@Update("UPDATE promotion_activity SET "
				+ "name=#{name},"
				+ "start_time=#{startTime},"
				+ "end_time=#{endTime},"
				+ "remark=#{remark},"
				+ "type=#{type},"
				+ "rule=#{rule},"
				+ "gmt_modified=#{gmtModified} "
			+ "WHERE id=#{id}")  
	void update(PromotionActivityDO activity);
	
	/**
	 * 更新促销活动的状态
	 * @param id 促销活动id
	 * @param status 促销活动的状态
	 */
	@Update("UPDATE promotion_activity SET "
			+ "status=#{status},"
			+ "gmt_modified=#{gmtModified} "
		+ "WHERE id=#{id}")  
	void updateStatus(PromotionActivityDO activity); 
	
	/**
	 * 删除促销活动
	 * @param id 促销活动id
	 */
	@Delete("DELETE FROM promotion_activity WHERE id=#{id}") 
	void remove(@Param("id") Long id);
	
}
