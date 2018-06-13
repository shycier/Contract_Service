package com.jzt56.jlp.contractservice.entity;

import java.util.Map;
import com.jzt56.jlp.contractservice.util.JsonUtils;

/**
 * jzt56数据网关调用的通用请求参数体
 * @author Shycier
 * @param <E>
 *
 */

public class RequestEntity{
	
	private String jsonParas;
	
	private String requestType;
	
	private String serviceName;
	
	/**
	 * 重载构造方法
	 */
	public RequestEntity() {
	}
	
	public RequestEntity(Object jsonParasObj,String requestType,String serviceName) {
		this("",requestType,serviceName);
		String jsonParas = "["+JsonUtils.objectToJson(jsonParasObj)+"]";
		this.setJsonParas(jsonParas);
	}
	
	public RequestEntity(Map<String,String> jsonParasMap,String requestType,String serviceName) {
		this("",requestType,serviceName);
		String jsonParas = "["+JsonUtils.MapToJson(jsonParasMap)+"]";
		this.setJsonParas(jsonParas);
	}
	
	public RequestEntity(String jsonParas,String requestType,String serviceName) {
		this.jsonParas = jsonParas;
		this.requestType = requestType;
		this.serviceName = serviceName.replace("/","");
	}
	
	public RequestEntity(Map<String,String> jsonParasMap,String requestType,String serviceName,boolean IsArray) {
		this("",requestType,serviceName);
		String jsonParas = "";
		if(IsArray) {
			jsonParas = "["+JsonUtils.MapToJson(jsonParasMap)+"]";			
		}else {
			jsonParas = JsonUtils.MapToJson(jsonParasMap);
		}
		this.setJsonParas(jsonParas);
	}

	public String getJsonParas() {
		return jsonParas;
	}

	public void setJsonParas(String jsonParas) {
		this.jsonParas = jsonParas;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	
	
}
