package com.zhss.eshop.logistics.api;

import java.util.List;

/**
 * 创建电子面单的请求
 * @author zhonghuashishan
 *
 */
public class CreateEOrderRequest {

	/**
	 * 订单编号
	 */
	private String orderNo;
	/**
	 * 运费
	 */
	private Double freight;
	/**
	 * 收件人信息
	 */
	private Receiver receiver;
	/**
	 * 商品信息
	 */
	private List<Goods> goodsList;
	/**
	 * 商品总毛重
	 */
	private Double totalGrossWeight;
	/**
	 * 商品购买总件数
	 */
	private Long totalPurchaseQuantity;
	/**
	 * 商品总体积
	 */
	private Double totalVolume;
	
	/**
	 * 收件人信息
	 * @author zhonghuashishan
	 *
	 */
	public static class Receiver {
		
		/**
		 * 收件人姓名
		 */
		private String consignee;
		/**
		 * 收件人电话号码
		 */
		private String consigneeCellPhoneNumber;
		/**
		 * 收货地址
		 */
		private String deliveryAddress;
		
		public String getConsignee() {
			return consignee;
		}
		public void setConsignee(String consignee) {
			this.consignee = consignee;
		}
		public String getConsigneeCellPhoneNumber() {
			return consigneeCellPhoneNumber;
		}
		public void setConsigneeCellPhoneNumber(String consigneeCellPhoneNumber) {
			this.consigneeCellPhoneNumber = consigneeCellPhoneNumber;
		}
		public String getDeliveryAddress() {
			return deliveryAddress;
		}
		public void setDeliveryAddress(String deliveryAddress) {
			this.deliveryAddress = deliveryAddress;
		}
		
	}
	
	/**
	 * 商品信息
	 * @author zhonghuashishan
	 *
	 */
	public static class Goods {
		
		/**
		 * 商品名称
		 */
		private String goodsName;
		/**
		 * 购买数量
		 */
		private Long purchaseQuantity;
		/**
		 * 商品毛重
		 */
		private Double grossWeight;
		
		public String getGoodsName() {
			return goodsName;
		}
		public void setGoodsName(String goodsName) {
			this.goodsName = goodsName;
		}
		public Long getPurchaseQuantity() {
			return purchaseQuantity;
		}
		public void setPurchaseQuantity(Long purchaseQuantity) {
			this.purchaseQuantity = purchaseQuantity;
		}
		public Double getGrossWeight() {
			return grossWeight;
		}
		public void setGrossWeight(Double grossWeight) {
			this.grossWeight = grossWeight;
		}
		
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Double getFreight() {
		return freight;
	}

	public void setFreight(Double freight) {
		this.freight = freight;
	}

	public Receiver getReceiver() {
		return receiver;
	}

	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}

	public List<Goods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}

	public Double getTotalGrossWeight() {
		return totalGrossWeight;
	}

	public void setTotalGrossWeight(Double totalGrossWeight) {
		this.totalGrossWeight = totalGrossWeight;
	}

	public Long getTotalPurchaseQuantity() {
		return totalPurchaseQuantity;
	}

	public void setTotalPurchaseQuantity(Long totalPurchaseQuantity) {
		this.totalPurchaseQuantity = totalPurchaseQuantity;
	}

	public Double getTotalVolume() {
		return totalVolume;
	}

	public void setTotalVolume(Double totalVolume) {
		this.totalVolume = totalVolume;
	}
	
}
