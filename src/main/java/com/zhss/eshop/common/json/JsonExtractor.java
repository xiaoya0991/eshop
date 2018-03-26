package com.zhss.eshop.common.json;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

/**
 * json字段值提取器
 * @author zhonghuashishan
 *
 */
@Component
public class JsonExtractor {

	/**
	 * 获取表达式对应的值
	 * @param targetJson 目标的json对象
	 * @param jsonExtractSyntax 表达式
	 * @return 值
	 * @throws Exception
	 */
	public String getString(JSONObject targetJson, String jsonExtractSyntax) throws Exception {
		return String.valueOf(get(targetJson, jsonExtractSyntax));  
	}
	
	/**
	 * 获取表达式对应的值
	 * @param targetJson 目标的json对象
	 * @param jsonExtractSyntax 表达式
	 * @return 值
	 * @throws Exception
	 */
	public Double getDouble(JSONObject targetJson, String jsonExtractSyntax) throws Exception {
		return Double.valueOf(String.valueOf(get(targetJson, jsonExtractSyntax)));
	}
	
	/**
	 * 获取表达式对应的值
	 * @param targetJson 目标的json对象
	 * @param jsonExtractSyntax 表达式
	 * @return 值
	 * @throws Exception
	 */
	public Integer getInteger(JSONObject targetJson, String jsonExtractSyntax) throws Exception {
		return Integer.valueOf(String.valueOf(get(targetJson, jsonExtractSyntax)));
	}
	
	/**
	 * 获取表达式对应的值
	 * @param targetJson 目标的json对象
	 * @param jsonExtractSyntax 表达式
	 * @return 值
	 * @throws Exception
	 */
	public Long getLong(JSONObject targetJson, String jsonExtractSyntax) throws Exception {
		return Long.valueOf(String.valueOf(get(targetJson, jsonExtractSyntax)));
	}
	
	/**
	 * 获取表达式对应的值
	 * @param targetJson 目标的json对象
	 * @param jsonExtractSyntax 表达式
	 * @return 值
	 * @throws Exception
	 */
	public Object get(JSONObject targetJson, String jsonExtractSyntax) throws Exception {
		JsonExpression jsonExpressionTree = JsonExtractSyntaxParser.parse(jsonExtractSyntax);
		return jsonExpressionTree.interpret(new JsonExpressionContext(targetJson));
	}
	
}
