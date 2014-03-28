package com.joviansoft.util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JovianJsonUtil {

	/**
	 * Convert bean to JSON string
	 * 
	 */
	public static String convertBean2Json(Object object) throws JsonConvertException{
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(object);
			
		} catch (JsonGenerationException e2) {
			throw new JsonConvertException("转换成json异常 ");
		} catch (JsonMappingException e2) {
			throw new JsonConvertException("转换成json异常 ");
		} catch (IOException e2) {
			e2.printStackTrace();
			throw new JsonConvertException("转换成json异常 ");
		}
	}
	
	
	/**
	 * convert json to bean
	 * @param <T>
	 */
	public static Object convertJson2Bean(String json, Class type) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.readValue(json, type);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
