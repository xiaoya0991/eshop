package com.zhss.eshop.commodity.domain;

/**
 * 品牌查询条件
 * @author zhonghuashishan
 *
 */
public class BrandQuery {

	/**
	 * 分页查询起始位置
	 */
	private Integer offset;
	/**
	 * 每页查询的记录数
	 */
	private Integer size;
	/**
	 * 品牌中文名
	 */
	private String chineseName;
	/**
	 * 品牌英文名
	 */
	private String englishName;
	/**
	 * 品牌别名
	 */
	private String aliasName;
	
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public String getChineseName() {
		return chineseName;
	}
	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}
	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	public String getAliasName() {
		return aliasName;
	}
	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}
	
}
