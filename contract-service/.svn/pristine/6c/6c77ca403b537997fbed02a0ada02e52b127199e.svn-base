package com.jzt56.jlp.contractservice.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jzt56.jlp.contractservice.entity.ResponseEntity;
import com.jzt56.jlp.contractservice.property.UrlProperty;
import com.jzt56.jlp.contractservice.service.ContractTemplateService;
import com.jzt56.jlp.contractservice.template.DataGatewayTemplate;
import com.jzt56.jlp.contractservice.util.DateUtil;
import com.jzt56.jlp.contractservice.util.JsonUtils;

/**
 * 合同模板服务实现
 * @author Shycier
 *
 */
@Service
public class ContrcatTemplateServiceImpl implements ContractTemplateService{
	
	/** 注入数据网关访问模板*/
	@Autowired
	DataGatewayTemplate dataGatewayTemplate;
	
	/** 注入配置文件参数 */
	@Autowired
	UrlProperty urlProperty;
	
	@SuppressWarnings("unchecked")
	@Override
	public String SaveContractTemplate(String ContractTemplate) {
		//json字符串转换成java对象
		Map<String,String> contractTemplate = (Map<String,String>)JsonUtils.jsonToPojo(ContractTemplate, Map.class);
		//获取ID
		String uuid = contractTemplate.get("ContractTemplate_Id");
		//判断合同模板正文是否为空
		String contract_Content = contractTemplate.get("Contract_Content");
		if(null==contract_Content||"".equals(contract_Content)) {
			return JsonUtils.objectToJson(ResponseEntity.error("合同模板：正文不能为空"));
		}
		//判断新增或更新并执行插入和更新操作
		if("inserted".equals(contractTemplate.get("changetype"))) {
			uuid = UUID.randomUUID().toString().replaceAll("-","");
			contractTemplate.put("ContractTemplate_Id",uuid);
			contractTemplate.put("Created_Time",DateUtil.format(new Date()));
			contractTemplate.put("Updated_Time",DateUtil.format(new Date()));
			contractTemplate.put("ContractTemplate_State","0");
		}else if("updated".equals(contractTemplate.get("changetype"))&&contractTemplate.get("ContractTemplate_Id")!=null) {
			contractTemplate.put("Updated_Time",DateUtil.format(new Date()));
		}else {
			return JsonUtils.objectToJson(ResponseEntity.error("合同模板：无法判断新增还是更新"));
		}
		String serviceName = urlProperty.getCONTRACT_TEMPLATE_SERVICE();
		ResponseEntity result = dataGatewayTemplate.post(contractTemplate, serviceName);
		//处理合同编号重复问题
		String errInfo = result.getErrInfo();
		if(errInfo.endsWith("for key 'UK_ContractTemplate_No'")) {
			errInfo = "合同模板编号不能重复";
			result.setErrInfo(errInfo);
		}
		//回传UUID
		Map<String, Object> resultMap = new HashMap<String,Object>();
		resultMap.put("Contract_Template_Id", uuid);
		ArrayList<Map<String, Object>> resultList = new ArrayList<Map<String,Object>>();
		resultList.add(resultMap);
		result.setMsgInfo(resultList);
		return JsonUtils.objectToJson(result);
	}

	@Override
	public String discardContractTemplate(String[] ids) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		for(String id : ids) {
			HashMap<String, String> map = new HashMap<String,String>();
			map.put("ContractTemplate_Id", id);
			map.put("ContractTemplate_State","ZF");
			map.put("Updated_Time",DateUtil.format(new Date()));
			map.put("changetype","updated");
			String mapToJson = JsonUtils.MapToJson(map);
			builder.append(mapToJson+",");
		}	
		String jsonParas = builder.deleteCharAt(builder.length()-1).append("]").toString();
		String serviceName = urlProperty.getCONTRACT_TEMPLATE_SERVICE();
		return dataGatewayTemplate.postForString(jsonParas, serviceName);
	}
	
}
