package com.zhss.eshop.commodity.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.commodity.dao.GoodsPictureDAO;
import com.zhss.eshop.commodity.domain.GoodsPictureDO;

/**
 * 商品图片管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class GoodsPictureDAOImpl implements GoodsPictureDAO {

	/**
	 * 商品图片管理mapper组件
	 */
	@Autowired
	private GoodsPictureDAO goodsPictureMapper;
	
	/**
	 * 新增商品图片
	 * @param picture 图片
	 */
	public void save(GoodsPictureDO picture) {
		goodsPictureMapper.save(picture); 
	}

}
