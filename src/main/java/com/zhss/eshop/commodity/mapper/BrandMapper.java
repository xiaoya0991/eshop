package com.zhss.eshop.commodity.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zhss.eshop.commodity.domain.BrandDO;
import com.zhss.eshop.commodity.domain.BrandQuery;

/**
 * 品牌管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface BrandMapper {

	/**
	 * 分页查询品牌
	 * @param query 查询条件
	 * @return 品牌
	 */
	@Select("<script> "
			
			+ "SELECT "
				+ "a.id,"
				+ "a.chinese_name,"
				+ "a.english_name,"
				+ "a.alias_name,"
				+ "a.logo_path,"
				+ "a.introduction,"
				+ "a.auth_voucher_path,"
				+ "a.location,"
				+ "a.remark,"
				+ "a.gmt_create,"
				+ "a.gmt_modified "
			+ "FROM commodity_brand a,"
			+ "("
				+ "SELECT id "
				+ "FROM commodity_brand "
				+ "WHERE 1=1 "
				
				+ "<if test='chineseName != null'>"
				+ "AND chinese_name like '${chineseName}%'" 
 				+ "</if>"
				
				+ "<if test='englishName != null'>"
				+ "AND english_name like '${englishName}%'" 
 				+ "</if>"
				
				+ "<if test='aliasName != null'>"
				+ "AND alias_name like '${aliasName}%'"  
 				+ "</if>"
				
 				+ "LIMIT #{offset},#{limit} " 
			+ ") b "
			+ "WHERE a.id=b.id "
			
			+ "</script>") 
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "chinese_name", property = "chineseName"),
		@Result(column = "english_name", property = "englishName"),
		@Result(column = "alias_name", property = "aliasName"),
		@Result(column = "logo_path", property = "logoPath"),
		@Result(column = "introduction", property = "introduction"),
		@Result(column = "auth_voucher_path", property = "authVoucherPath"),
		@Result(column = "location", property = "location"),
		@Result(column = "remark", property = "remark"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified") 
	})
	List<BrandDO> listByPage(BrandQuery query);
	
	/**
	 * 根据id查询品牌
	 * @param id 品牌id
	 * @return 品牌
	 */
	@Select("SELECT "
				+ "id,"
				+ "chinese_name,"
				+ "english_name,"
				+ "alias_name,"
				+ "logo_path,"
				+ "introduction,"
				+ "auth_voucher_path,"
				+ "location,"
				+ "remark,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM commodity_brand "
			+ "WHERE id=#{id}") 
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "chinese_name", property = "chineseName"),
		@Result(column = "english_name", property = "englishName"),
		@Result(column = "alias_name", property = "aliasName"),
		@Result(column = "logo_path", property = "logoPath"),
		@Result(column = "introduction", property = "introduction"),
		@Result(column = "auth_voucher_path", property = "authVoucherPath"),
		@Result(column = "location", property = "location"),
		@Result(column = "remark", property = "remark"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified") 
	})
	BrandDO getById(@Param("id") Long id);
	
	/**
	 * 新增品牌
	 * @param brand 品牌
	 */
	@Insert("INSERT INTO commodity_brand("
				+ "chinese_name,"
				+ "english_name,"
				+ "alias_name,"
				+ "logo_path,"
				+ "introduction,"
				+ "auth_voucher_path,"
				+ "location,"
				+ "remark,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{chineseName},"
				+ "#{englishName},"
				+ "#{aliasName},"
				+ "#{logoPath},"
				+ "#{introduction},"
				+ "#{authVoucherPath},"
				+ "#{location},"
				+ "#{remark},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")")  
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(BrandDO brand);
	
	/**
	 * 更新品牌
	 * @param brand
	 */
	@Update("UPDATE commodity_brand SET "
				+ "chinese_name=#{chineseName},"
				+ "english_name=#{englishName},"
				+ "alias_name=#{aliasName},"
				+ "logo_path=#{logoPath},"
				+ "introduction=#{introduction},"
				+ "auth_voucher_path=#{authVoucherPath},"
				+ "location=#{location},"
				+ "remark=#{remark},"
				+ "gmt_create=#{gmtCreate},"
				+ "gmt_modified=#{gmtModified} "
			+ "WHERE id=#{id}")  
	void update(BrandDO brand);
	
	/**
	 * 删除品牌
	 * @param id 品牌id
	 */
	@Delete("DELETEE FROM commodity_brand WHERE id=#{id}")  
	void remove(@Param("id") Long id);
	
}
