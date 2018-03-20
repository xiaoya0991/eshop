package com.zhss.eshop.purchase.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zhss.eshop.purchase.domain.SupplierDO;
import com.zhss.eshop.purchase.domain.SupplierQuery;

/**
 * 供应商管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface SupplierMapper {

	/**
	 * 新增供应商
	 * @param supplier 供应商
	 */
	@Insert("INSERT INTO purchase_supplier("
				+ "name,"
				+ "company_name,"
				+ "company_address,"
				+ "contactor,"
				+ "contactor_phone_number,"
				+ "settlement_period,"
				+ "bank_name,"
				+ "bank_account,"
				+ "bank_account_holder,"
				+ "invoice_title,"
				+ "taxpayer_id,"
				+ "business_scope,"
				+ "remark,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{name},"
				+ "#{companyName},"
				+ "#{companyAddress},"
				+ "#{contactor},"
				+ "#{contactorPhoneNumber},"
				+ "#{settlementPeriod},"
				+ "#{bankName},"
				+ "#{bankAccount},"
				+ "#{bankAccountHolder},"
				+ "#{invoiceTitle},"
				+ "#{taxpayerId},"
				+ "#{businessScope},"
				+ "#{remark},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")")  
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true) 
	void save(SupplierDO supplier);
	
	/**
	 * 分页查询供应商
	 * @param query 供应商查询条件
	 * @return 供应商
	 */
	@Select("<script>"
			
			+ "SELECT "
				+ "a.id,"
				+ "a.name,"
				+ "a.company_name,"
				+ "a.contactor,"
				+ "a.settlement_period,"
				+ "a.bank_name,"
				+ "a.gmt_create,"
				+ "g.gmt_modified "
			+ "FROM purchase_supplier a,"
			+ "("
				+ "SELECT id "
				+ "FROM purchase_supplier "
				+ "WHERE 1=1 "
				
				+ "<if test='name != null'>"
				+ "AND name like '${name}%' "
				+ "</if>"
				
				+ "<if test='setlementPeriod != null'>"
				+ "AND setlement_period=#{setlementPeriod} "
				+ "</if>"
				
				+ "LIMIT #{offset},#{size} " 
			+ ") b "
			+ "WHERE a.id=b.id"
			
			+ "</script>")  
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "name", property = "name"),
		@Result(column = "company_name", property = "companyName"),
		@Result(column = "contactor", property = "contactor"),
		@Result(column = "settlement_period", property = "settlementPeriod"),
		@Result(column = "bank_name", property = "bankName"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	List<SupplierDO> listByPage(SupplierQuery query);
	
	/**
	 * 根据id查询供应商
	 * @param id 供应商id 
	 * @return 供应商
	 */
	@Select("SELECT "
				+ "id,"
				+ "name,"
				+ "company_name,"
				+ "company_address,"
				+ "contactor,"
				+ "contactor_phone_number,"
				+ "settlement_period,"
				+ "bank_name,"
				+ "bank_account,"
				+ "bank_account_holder,"
				+ "invoice_title,"
				+ "taxpayer_id,"
				+ "business_scope,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM purchase_supplier "
			+ "WHERE id=#{id}") 
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "name", property = "name"),
		@Result(column = "company_name", property = "companyName"),
		@Result(column = "company_address", property = "companyAddress"),
		@Result(column = "contactor", property = "contactor"),
		@Result(column = "contactor_phone_number", property = "contactorPhoneNumber"),
		@Result(column = "settlement_period", property = "settlementPeriod"),
		@Result(column = "bank_name", property = "bankName"),
		@Result(column = "bank_account", property = "bankAccount"),
		@Result(column = "bank_account_holder", property = "bankAccountHolder"),
		@Result(column = "invoice_title", property = "invoiceTitle"),
		@Result(column = "taxpayer_id", property = "taxpayerId"),
		@Result(column = "business_scope", property = "businessScope"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	SupplierDO getById(@Param("id") Long id);
	
}
