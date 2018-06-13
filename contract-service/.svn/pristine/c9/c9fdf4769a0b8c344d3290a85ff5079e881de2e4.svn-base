package com.jzt56.jlp.contractservice.template;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.jzt56.jlp.contractservice.entity.RequestEntity;
import com.jzt56.jlp.contractservice.entity.ResponseEntity;
import com.jzt56.jlp.contractservice.util.JsonUtils;

/**
 * DataGatewayTemplate是数据网关调用的通用模板类，
 * 封装了restTemplate，根据数据网关的请求传参规则
 * 简化了数据网关服务调用。
 * @author Shycier
 */
@Component
public class DataGatewayTemplate {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private String baseUrl;
	
	public final String CHANGETYPE_UPDATE = "updated";
	
	public final String CHANGETYPE_INSERT = "inserted";
	
	public final String CHANGETYPE_DELETE = "deleted";
		
	/**
	 * 初始化方法
	 * @return
	 */
	public DataGatewayTemplate initDataGatewayTemplate() {
		this.baseUrl = "http://10.3.87.48:8895/Jlp.Data.InterfaceService/api/inCall";
		return this;
	}
	
	/**
	 * 创建一个GET请求方式的请求体
	 * @param jsonParas
	 * @param serviceName
	 * @return
	 */
	protected RequestEntity getRequestEntityForGet(String jsonParas,String serviceName) {
		RequestEntity requst = GetRequestEntity(jsonParas,serviceName);
		requst.setRequestType("get");
		return requst;
	}
	
	/**
	 * 创建一个POST请求方式的请求体
	 * @param jsonParas
	 * @param serviceName
	 * @return
	 */
	protected RequestEntity getRequestEntityForPost(String jsonParas,String serviceName) {
		RequestEntity requst = GetRequestEntity(jsonParas,serviceName);
		requst.setRequestType("post");
		return requst;
	}
	
	/**
	 * 创建一个没有设置请求方式的请求体
	 * @param jsonParas
	 * @param serviceName
	 * @return
	 */
	protected RequestEntity GetRequestEntity(String jsonParas,String serviceName) {
		RequestEntity requst = new RequestEntity();
		requst.setJsonParas(jsonParas);
		requst.setServiceName(serviceName);
		return requst;
	}
	
	/**
	 * 根据serviceName构建url
	 * @param serviceName
	 * @return
	 */
	protected String buildUrl(String serviceName) {
		return baseUrl+"/"+serviceName+"/";
	}
	
	/**
	 * GET请求获取ResponseEntity类型的响应
	 * @param jsonParas
	 * @param serviceName
	 * @return ResponseEntity
	 */
	public ResponseEntity get(String jsonParas,String serviceName) {
		RequestEntity requestEntity = getRequestEntityForGet(jsonParas,serviceName);
		String url = buildUrl(serviceName);
		return restTemplate.postForObject(url,requestEntity,ResponseEntity.class);
	}
	
	public ResponseEntity get(Object object,String serviceName) {
		String jsonParas = JsonUtils.objectToJson(object);
		return get(jsonParas,serviceName);
	}
	
	/**
	 * POST请求获取ResponseEntity类型的响应
	 * @param jsonParas
	 * @param serviceName
	 * @return ResponseEntity
	 */
	public ResponseEntity post(String jsonParas,String serviceName) {
		RequestEntity requestEntity = getRequestEntityForPost(jsonParas,serviceName);
		String URL = buildUrl(serviceName);
		return restTemplate.postForObject(URL,requestEntity,ResponseEntity.class);
	}
	
	public ResponseEntity post(Object object,String serviceName) {
		String jsonParas = "["+JsonUtils.objectToJson(object)+"]";
		return post(jsonParas,serviceName);
	}
	
	/**
	 * GET请求获取字符串类型的响应
	 * @param jsonParas
	 * @param serviceName
	 * @return String
	 */
	public String getForString(String jsonParas,String serviceName) {
		RequestEntity requestEntity = getRequestEntityForGet(jsonParas,serviceName);
		String url = buildUrl(serviceName);
		ResponseEntity responseEntity = restTemplate.postForObject(url,requestEntity,ResponseEntity.class);
		return JsonUtils.objectToJson(responseEntity);

	}
	
	public String getForString(Object object,String serviceName) {
		String jsonParas = JsonUtils.objectToJson(object);
		return getForString(jsonParas,serviceName);
	}
	
	/**
	 * POST请求获取字符串类型的响应
	 * @param jsonParas
	 * @param serviceName
	 * @return String
	 */
	public String postForString(String jsonParas,String serviceName) {
		RequestEntity requestEntity = getRequestEntityForPost(jsonParas,serviceName);
		String url = buildUrl(serviceName);
		ResponseEntity responseEntity = restTemplate.postForObject(url,requestEntity,ResponseEntity.class);
		return JsonUtils.objectToJson(responseEntity);
	}
	
	public String postForString(Object object,String serviceName) {
		String jsonParas = "["+JsonUtils.objectToJson(object)+"]";
		return postForString(jsonParas,serviceName);
	}
	
	protected ResponseEntity basePost(String serviceName,String[] ids,String PK,Map<String,Object> updateFiled,String changetype) {
		ArrayList<Object> paramList = new ArrayList<>();
		for(String id : ids) {
			HashMap<String, Object> recordMap = new HashMap<String,Object>();
				recordMap.put(PK, id);		
			if(null!=updateFiled) {
				recordMap.putAll(updateFiled);
			}
			recordMap.put("changetype", changetype);
			paramList.add(recordMap);
		}
		return post(paramList,serviceName);	
	} 
	
	public ResponseEntity update(String serviceName,String[] ids,String PK,Map<String,Object> updateFiled) {
		return basePost(serviceName,ids,PK,updateFiled,this.CHANGETYPE_UPDATE);
	}
	
	public ResponseEntity insert(String serviceName,String[] ids,String PK,Map<String,Object> updateFiled) {
		return basePost(serviceName,ids,PK,updateFiled,this.CHANGETYPE_UPDATE);
	}
	
	public ResponseEntity delete(String serviceName,String[] ids,String PK) {
		return basePost(serviceName,ids,PK,null,this.CHANGETYPE_UPDATE);
	}
	
}
