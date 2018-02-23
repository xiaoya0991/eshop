package com.zhss.eshop.logistics.service;

<<<<<<< HEAD
import com.zhss.eshop.commodity.dto.GoodsSkuDTO;
=======
import com.zhss.eshop.commodity.domain.GoodsSkuDTO;
>>>>>>> 23c8f5ae9e7c85e3cf2a8b2ec05b63b4a0e8d096

/**
 * 物流中心对外提供的接口
 * @author zhonghuashishan
 *
 */
public interface LogisticsFacadeService {

	/**
	 * 计算商品sku的运费
	 * @param goodsSkuDTO 商品sku DTO
	 * @return 商品sku的运费
	 */
	Double calculateFreight(GoodsSkuDTO goodsSkuDTO);
	
}
