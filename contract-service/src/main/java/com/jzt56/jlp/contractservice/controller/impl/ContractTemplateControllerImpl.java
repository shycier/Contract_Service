package com.jzt56.jlp.contractservice.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.jzt56.jlp.contractservice.controller.ContractTemplateController;
import com.jzt56.jlp.contractservice.property.UrlProperty;
import com.jzt56.jlp.contractservice.service.ContractTemplateService;
import com.jzt56.jlp.contractservice.template.DataGatewayTemplate;

@RestController
@RequestMapping("/ContractService")
public class ContractTemplateControllerImpl implements ContractTemplateController {
	
	@Autowired
	UrlProperty urlProperty;
	
	@Autowired
	DataGatewayTemplate dataGatewayTemplate;
	
	@Autowired
	ContractTemplateService contractTemplateService;

	@Override
	@RequestMapping(value="/ListContractTemplateByQuery",method=RequestMethod.POST)
	public String ListContractTemplateByQuery(String Operator_Id,String KeyWords,int startIndex,int pageSize) {
		String jsonParas = "{\"Operator_Id\":\""+Operator_Id+"\",\"KeyWords\":\""+KeyWords+"\",\"startIndex\":"+startIndex+",\"pageSize\":"+pageSize+"}";
		String serviceName = urlProperty.getLIST_CONTRACT_TEMPLATE();
		return dataGatewayTemplate.getForString(jsonParas, serviceName);
	}

	@Override
	@RequestMapping(value="/GetBlobById",method=RequestMethod.POST)
	public String getBlobById(String ContractTemplate_Id) {
		String jsonParas = "{\"ContractTemplate_Id\":\""+ContractTemplate_Id+"\"}";	
		String serviceName = urlProperty.getGET_BLOB();
		return dataGatewayTemplate.getForString(jsonParas, serviceName);
	}

	@Override
	@RequestMapping(value="/SaveContractTemplate",method=RequestMethod.POST)
	public String saveContractTemplate(String ContractTemplate) {
		return contractTemplateService.SaveContractTemplate(ContractTemplate);
	}

	@Override
	@RequestMapping(value="/DiscardContractTemplate",method=RequestMethod.POST)
	public String discardContractTemplate(String[] Discarded_Template_Ids) {
		return contractTemplateService.discardContractTemplate(Discarded_Template_Ids);
	}

	@Override
	@RequestMapping(value="/GetOptionsData",method=RequestMethod.POST)
	public String getOptionsData(String Field_Name) {
		String jsonParas = "{\"Field_Name\":\""+Field_Name+"\"}";
		String serviceName = urlProperty.getGET_OPRION_DATA();
		return dataGatewayTemplate.getForString(jsonParas, serviceName);
	}

	@Override
	@RequestMapping(value="/ListContractTemplateByAuthority",method=RequestMethod.POST)
	public String ListContractTemplateByAuthority(String Staff_Id, String KeyWords, int startIndex, int pageSize) {
		String Flow_Id = "900002";
		String jsonParas = "{\"Flow_Id\":\""+Flow_Id+"\",\"Staff_Id\":\""+Staff_Id+"\",\"KeyWords\":\""+KeyWords+"\",\"startIndex\":"+startIndex+",\"pageSize\":"+pageSize+"}";
		String serviceName = urlProperty.getCONTRACT_FLOW_CONTRACTTEMPALTE();
		return dataGatewayTemplate.getForString(jsonParas, serviceName);
	}
	
}
