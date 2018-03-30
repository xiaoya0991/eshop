package com.zhss.eshop.common.json;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * 日期json序列化
 * @author zhonghuashishan
 *
 */
public class DateJsonSerializer extends JsonSerializer<Date> {
	
	@Override
    public void serialize(Date date, JsonGenerator jsonGenerator, 
    		SerializerProvider serializerProvider) throws IOException,JsonProcessingException {  
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        jsonGenerator.writeString(formatter.format(date));    
    }    
    
} 