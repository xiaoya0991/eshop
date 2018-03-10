package com.zhss.eshop.commodity.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 商品详情图片
 * @author zhonghuashishan
 *
 */
public class GoodsDetailPictureDTO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 商品详情id
	 */
	private Long goodsDetailId;
	/**
	 * 图片路径
	 */
	private String picturePath;
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
	public Long getGoodsDetailId() {
		return goodsDetailId;
	}
	public void setGoodsDetailId(Long goodsDetailId) {
		this.goodsDetailId = goodsDetailId;
	}
	public String getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
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
	
}
