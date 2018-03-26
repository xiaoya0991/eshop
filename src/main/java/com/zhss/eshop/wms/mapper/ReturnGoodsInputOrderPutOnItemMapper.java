package com.zhss.eshop.wms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderPutOnItemDO;

/**
 * 退货入库单上架条目管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface ReturnGoodsInputOrderPutOnItemMapper {

	/**
	 * 根据退货入库单条目id查询退货入库单上架条目
	 * @param returnGoodsInputOrderItemId 退货入库单id
	 * @return 退货入库单上架条目
	 */
	@Select("SELECT "
				+ "id,"
				+ "return_goods_input_order_item_id,"
				+ "goods_allocation_id,"
				+ "goods_sku_id,"
				+ "put_on_shelves_count,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM wms_return_goods_input_order_put_on_item "
			+ "WHERE return_goods_input_order_item_id=#{returnGoodsInputOrderItemId}")  
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "return_goods_input_order_item_id", property = "returnGoodsInputOrderItemId"),
		@Result(column = "goods_allocation_id", property = "goodsAllocationId"),
		@Result(column = "goods_sku_id", property = "goodsSkuId"),
		@Result(column = "put_on_shelves_count", property = "putOnShelvesCount"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified") 
	})
	List<ReturnGoodsInputOrderPutOnItemDO> listByReturnGoodsInputOrderItemId(
			@Param("returnGoodsInputOrderItemId") Long returnGoodsInputOrderItemId);
	
}
