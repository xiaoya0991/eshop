package com.zhss.eshop.commodity.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 商品详情
 * @author zhonghuashishan
 *
 */
public class GoodsDetailDTO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 商品id
	 */
	private Long goodsId;
	/**
	 * 商品详情的内容
	 */
	private String detailContent;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 修改时间
	 */
	private Date gmtModified;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public String getDetailContent() {
		return detailContent;
	}
	public void setDetailContent(String detailContent) {
		this.detailContent = detailContent;
	}
	public Date getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public Date getGmtModified() {
		return gmtModified;
	}
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	
	@Override
	public String toString() {
		return "GoodsDetailDTO [id=" + id + ", goodsId=" + goodsId + ", detailContent=" + detailContent + ", gmtCreate="
				+ gmtCreate + ", gmtModified=" + gmtModified + "]";
	}
	
}
