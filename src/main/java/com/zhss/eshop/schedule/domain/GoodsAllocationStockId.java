package com.zhss.eshop.schedule.domain;

/**
 * 货位库存id
 * @author zhonghuashishan
 *
 */
public class GoodsAllocationStockId {
	
	/**
	 * 货位id
	 */
	private Long goodsAllocationId;
	/**
	 * 商品sku id
	 */
	private Long goodsSkuId;
	
	public GoodsAllocationStockId() {
		
	}
	
	public GoodsAllocationStockId(Long goodsAllocationId, Long goodsSkuId) {
		this.goodsAllocationId = goodsAllocationId;
		this.goodsSkuId = goodsSkuId;
	}
	
	public Long getGoodsAllocationId() {
		return goodsAllocationId;
	}
	public void setGoodsAllocationId(Long goodsAllocationId) {
		this.goodsAllocationId = goodsAllocationId;
	}
	public Long getGoodsSkuId() {
		return goodsSkuId;
	}
	public void setGoodsSkuId(Long goodsSkuId) {
		this.goodsSkuId = goodsSkuId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goodsAllocationId == null) ? 0 : goodsAllocationId.hashCode());
		result = prime * result + ((goodsSkuId == null) ? 0 : goodsSkuId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GoodsAllocationStockId other = (GoodsAllocationStockId) obj;
		if (goodsAllocationId == null) {
			if (other.goodsAllocationId != null)
				return false;
		} else if (!goodsAllocationId.equals(other.goodsAllocationId))
			return false;
		if (goodsSkuId == null) {
			if (other.goodsSkuId != null)
				return false;
		} else if (!goodsSkuId.equals(other.goodsSkuId))
			return false;
		return true;
	}
	
}
