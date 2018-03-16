package com.zhss.eshop.commodity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.Inventory.service.InventoryService;
import com.zhss.eshop.commodity.dao.CategoryPropertyRelationshipDAO;
import com.zhss.eshop.commodity.dao.GoodsDAO;
import com.zhss.eshop.commodity.dao.GoodsSkuDAO;
import com.zhss.eshop.commodity.dao.GoodsSkuSalePropertyValueDAO;
import com.zhss.eshop.commodity.dao.PropertyDAO;
import com.zhss.eshop.commodity.domain.CategoryPropertyRelationshipDO;
import com.zhss.eshop.commodity.domain.GoodsDO;
import com.zhss.eshop.commodity.domain.GoodsSkuDO;
import com.zhss.eshop.commodity.domain.GoodsSkuDTO;
import com.zhss.eshop.commodity.domain.GoodsSkuQuery;
import com.zhss.eshop.commodity.domain.GoodsSkuSalePropertyValueDO;
import com.zhss.eshop.commodity.domain.GoodsSkuSalePropertyValueDTO;
import com.zhss.eshop.commodity.domain.PropertyDO;
import com.zhss.eshop.commodity.service.GoodsSkuService;
import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.common.util.ObjectUtils;

/**
 * 商品sku管理service组件
 * @author zhonghuashishan
 *
 */
@Service
@Transactional
public class GoodsSkuServiceImpl implements GoodsSkuService {

	/**
	 * 商品sku管理DAO组件
	 */
	@Autowired
	private GoodsSkuDAO goodsSkuDAO;
	/**
	 * 属性管理DAO组件
	 */
	@Autowired
	private PropertyDAO propertyDAO;
	/**
	 * 类目与属性关系管理DAO组件
	 */
	@Autowired
	private CategoryPropertyRelationshipDAO categoryPropertyRelationDAO;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	/**
	 * 商品sku销售属性值管理DAO组件
	 */
	@Autowired
	private GoodsSkuSalePropertyValueDAO propertyValueDAO;
	/**
	 * 库存中心接口
	 */
	@Autowired
	private InventoryService inventoryService;
	/**
	 * 商品管理DAO组件
	 */
	@Autowired
	private GoodsDAO goodsDAO;
	
	/**
	 * 根据商品id查询商品sku
	 * @param goodsId 商品id 
	 * @return 商品sku
	 * @throws Exception
	 */
	public List<GoodsSkuDTO> listByGoodsId(Long goodsId) throws Exception {
		List<GoodsSkuDTO> goodsSkus = ObjectUtils.convertList(
				goodsSkuDAO.listByGoodsId(goodsId), GoodsSkuDTO.class); 
		
		for(GoodsSkuDTO goodsSku : goodsSkus) {
			Long saleStockQuantity = inventoryService.getSaleStockQuantity(goodsSku.getId());
			List<GoodsSkuSalePropertyValueDTO> propertyValues = ObjectUtils.convertList(
					propertyValueDAO.listByGoodsSkuId(goodsSku.getId()), 
					GoodsSkuSalePropertyValueDTO.class); 
			
			goodsSku.setSaleStockQuantity(saleStockQuantity); 
			goodsSku.setPropertyValues(propertyValues); 
		}
		
		return goodsSkus;
	}
	
	/**
	 * 批量新增商品sku
	 * @param goodsSku 商品sku
	 * @throws Exception
	 */
	public void batchSave(List<GoodsSkuDTO> goodsSkus) throws Exception {
		for(GoodsSkuDTO goodsSku : goodsSkus) {
			Long goodsSkuId = saveGoodsSku(goodsSku);
			batchSavePropertyValues(goodsSkuId, goodsSku.getPropertyValues());  
			inventoryService.setSaleStockQuantity(goodsSkuId, goodsSku.getSaleStockQuantity());
		}
	}
	
	/**
	 * 根据商品id删除sku
	 * @param goodsId 商品id
	 */
	public void removeByGoodsId(Long goodsId) throws Exception {
		List<GoodsSkuDO> goodsSkus = goodsSkuDAO.listByGoodsId(goodsId);
		for(GoodsSkuDO goodsSku : goodsSkus) {
			propertyValueDAO.removeByGoodsSkuId(goodsSku.getId()); 
		}
		goodsSkuDAO.removeByGoodsId(goodsId); 
	}
	
	/**
	 * 批量新增商品sku的销售属性值
	 * @param propertyValues
	 * @throws Exception
	 */
	private void batchSavePropertyValues(Long goodsSkuId, 
			List<GoodsSkuSalePropertyValueDTO> propertyValues) 
			throws Exception {
		for(GoodsSkuSalePropertyValueDTO propertyValue : propertyValues) {
			propertyValue.setGoodsSkuId(goodsSkuId); 
			propertyValue.setGmtCreate(dateProvider.getCurrentTime()); 
			propertyValue.setGmtModified(dateProvider.getCurrentTime()); 
			propertyValueDAO.save(propertyValue.clone(GoodsSkuSalePropertyValueDO.class));  
		}
	}
	
	/**
	 * 新增商品sku
	 * @param goodsSku 商品sku
	 * @throws Exception
	 */
	private Long saveGoodsSku(GoodsSkuDTO goodsSku) throws Exception {
		goodsSku.setSaleProperties(getSaleProperties(goodsSku.getPropertyValues()));  
		goodsSku.setGmtCreate(dateProvider.getCurrentTime()); 
		goodsSku.setGmtModified(dateProvider.getCurrentTime()); 
		return goodsSkuDAO.save(goodsSku.clone(GoodsSkuDO.class)); 
	}
	
	/**
	 * 获取销售属性
	 * @param propertyValues 销售属性值
	 * @return
	 * @throws Exception
	 */
	private String getSaleProperties(List<GoodsSkuSalePropertyValueDTO> propertyValues) 
			throws Exception {
		StringBuilder builder = new StringBuilder("");
		
		for(int i = 0; i < propertyValues.size(); i++) {
			CategoryPropertyRelationshipDO relation = categoryPropertyRelationDAO
					.getById(propertyValues.get(i).getRelationId());
			PropertyDO property = propertyDAO.getPropertyById(relation.getPropertyId());
			
			builder.append(property.getPropertyName() + ":" + 
					propertyValues.get(i).getPropertyValue());
			
			if(i < propertyValues.size() - 1) {
				builder.append(";"); 
			}
		}
		
		return builder.toString();
	}
	
	/**
	 * 根据id查询商品sku
	 * @param id 商品sku id
	 * @return 商品sku
	 */
	public GoodsSkuDTO getById(Long id) throws Exception {
		GoodsSkuDTO goodsSku = goodsSkuDAO.getById(id).clone(GoodsSkuDTO.class);
		setGoodsRelatedFields(goodsSku); 
		return goodsSku;
	}
	
	/**
	 * 分页查询商品sku
	 * @param query 查询条件
	 * @return 商品sku
	 */
	public List<GoodsSkuDTO> listByPage(GoodsSkuQuery query) throws Exception {
		List<GoodsSkuDTO> goodsSkus = ObjectUtils.convertList(
				goodsSkuDAO.listByPage(query), GoodsSkuDTO.class);
		for(GoodsSkuDTO goodsSku : goodsSkus) {
			setGoodsRelatedFields(goodsSku); 
		}
		return goodsSkus;
	}
	
	private void setGoodsRelatedFields(GoodsSkuDTO goodsSku) throws Exception {
		GoodsDO goods = goodsDAO.getById(goodsSku.getGoodsId());
		
		goodsSku.setGoodsName(goods.getName()); 
		goodsSku.setGrossWeight(goods.getGrossWeight()); 
		goodsSku.setGoodsLength(goods.getLength()); 
		goodsSku.setGoodsWidth(goods.getWidth());
		goodsSku.setGoodsHeight(goods.getHeight()); 
		goodsSku.setGoodsSkuCode(goodsSku.getSkuCode()); 
		goodsSku.setSaleStockQuantity(inventoryService
				.getSaleStockQuantity(goodsSku.getId()));  
	}
	
}
