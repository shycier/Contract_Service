package com.jzt56.jlp.contractservice.util;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static String objectToJson(Object data) {
    	try {
			String string = MAPPER.writeValueAsString(data);
			return string;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }
    
    public static <T>List<T> jsonToList(String jsonData, Class<T> beanType) {
    	JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
    	try {
    		List<T> list = MAPPER.readValue(jsonData, javaType);
    		return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return null;
    }
    
   public static <T> String ListToJson(List<T> objectList) {
	   StringBuilder json = new StringBuilder();
	   for(T object : objectList) {
		   try {
			   String string = MAPPER.writeValueAsString(object);
			   json.append(string);
			   json.append(",");
		   } catch (JsonProcessingException e) {
			   e.printStackTrace();
		   }
	   }
	   json.deleteCharAt(json.length()-1);
	   return json.toString();
    }
   
   public static String MapToJson(Map<String,String> paramsMap) {
	   try {
		  return MAPPER.writeValueAsString(paramsMap);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		   return null;
  	}
   
   public static String MapToJson(Map<String,Object> paramsMap,boolean IsObject) {
	   try {
		  return MAPPER.writeValueAsString(paramsMap);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		   return null;
  	}
   
}
