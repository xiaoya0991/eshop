package com.zhss.eshop.common.json;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * 日期json反序列化
 * @author zhonghuashishan
 *
 */
public class DateJsonDeserializer extends JsonDeserializer<Date> {
	
	@Override
    public Date deserialize(JsonParser jsonParser,DeserializationContext deserializationContext)  
            throws IOException,JsonProcessingException {  
    	try {
    		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        	return formatter.parse(jsonParser.getText());    
		} catch (Exception e) {
			throw new RuntimeException(); 
		} 
    }  
    
}  