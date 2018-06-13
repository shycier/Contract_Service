package com.jzt56.jlp.contractservice.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.jzt56.jlp.contractservice.controller.PackageController;
import com.jzt56.jlp.contractservice.entity.ResponseEntity;
import com.jzt56.jlp.contractservice.service.PackageService;
import com.jzt56.jlp.contractservice.util.JsonUtils;

@RestController
@RequestMapping("/ContractService")
public class PackageControllerImpl implements PackageController{
	
	@Autowired
	PackageService packageServiceImpl;

	@Override
	@RequestMapping(value="/SavePackage",method=RequestMethod.POST)
	public String SavePackage(String Package, String Products) {
		ResponseEntity result = packageServiceImpl.SavePackage(Package, Products);
		return JsonUtils.objectToJson(result);
	}

	@Override
	@RequestMapping(value="/GetPackageTree",method=RequestMethod.POST)
	public String GetPackageTree(String Operator_Id, String Contract_Id, String KeyWords) {
		ResponseEntity result = packageServiceImpl.GetPackageTree(Operator_Id, Contract_Id, KeyWords);
		return JsonUtils.objectToJson(result);
	}
	
}
