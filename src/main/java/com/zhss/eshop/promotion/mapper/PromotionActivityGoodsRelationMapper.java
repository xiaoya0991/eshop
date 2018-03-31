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

import com.zhss.eshop.promotion.domain.PromotionActivityGoodsRelationDO;

/**
 * 促销活动与商品关联关系管理的mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface PromotionActivityGoodsRelationMapper {

	/**
	 * 根据促销活动id查询促销活动与商品的关联关系
	 * @param promotionActivityId 促销活动id
	 * @return 促销活动与商品的关联关系
	 */
	@Select("SELECT "
				+ "id,"
				+ "promotion_activity_id,"
				+ "goods_id,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM promotion_activity_goods_relation "
			+ "WHERE promotion_activity_id=#{promotionActivityId}") 
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "promotion_activity_id", property = "promotionActivityId"),
		@Result(column = "goods_id", property = "goodsId"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	List<PromotionActivityGoodsRelationDO> listByActivityId(
			@Param("promotionActivityId") Long promotionActivityId);
	
	/**
	 * 新增促销活动与商品的关联关系
	 * @param relation 促销活动与商品的关联关系
	 */
	@Insert("INSERT INTO promotion_activity_goods_relation("
				+ "promotion_activity_id,"
				+ "goods_id,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{promotionActivityId},"
				+ "#{goodsId},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")")  
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(PromotionActivityGoodsRelationDO relation);
	
	/**
	 * 删除促销活动对应的与商品的关联关系
	 * @param promotionActivityId 促销活动id
	 */
	@Delete("DELETE FROM promotion_activity_goods_relation "
			+ "WHERE promotion_activity_id=#{promotionActivityId}")
	void removeByActivityId(@Param("promotionActivityId") Long promotionActivityId);
	
}
