package com.jzt56.jlp.contractservice.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jzt56.jlp.contractservice.entity.ResponseEntity;
import com.jzt56.jlp.contractservice.property.UrlProperty;
import com.jzt56.jlp.contractservice.service.PackageService;
import com.jzt56.jlp.contractservice.template.DataGatewayTemplate;
import com.jzt56.jlp.contractservice.util.DateUtil;
import com.jzt56.jlp.contractservice.util.JsonUtils;
import com.jzt56.jlp.contractservice.util.TreeBuilder;

@Service
public class PackageServiceImpl implements PackageService {
	
	@Autowired
	DataGatewayTemplate dataGatewayTemplate;
	
	@Autowired
	UrlProperty urlProperty;
	
	
	/**
	 * 保存套餐明细，如果是新增则生成套餐ID，如果是修改则重用套餐ID，
	 * 套餐
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ResponseEntity SavePackage(String Package, String Products) {
		Map PackageMap = JsonUtils.jsonToPojo(Package, Map.class);
		String changetype = (String)PackageMap.get("changetype");
		List<Map<String, Object>> removedProductsList = null;
		//判断产品是否为空
		List<Map> ProductsList = JsonUtils.jsonToList(Products, Map.class);
		if(ProductsList.size()==0||ProductsList==null) {
			return ResponseEntity.error("请选择套餐产品!");
		}
		//设置保存新增和编辑公共的数据
		//补充package的数据,如果新增生成Pakcage_Id，如果更新使用前端的Package_Id
		if("inserted".equals(changetype)) {
			PackageMap.put("Package_Id", UUID.randomUUID().toString().replaceAll("-",""));
		}
		//如果是更新则沿用之前的ID
		PackageMap.put("Package_State", "1");
		PackageMap.put("Is_BasisPackage", "N");
		PackageMap.put("Created_Time", DateUtil.format(new Date()));
		PackageMap.put("Updated_Time", DateUtil.format(new Date()));
		//如果package的changetype为更新则先删除原有数据，通过packageId查询数据列表，每条添加deleted，并放入ProductsList
		if("updated".equals(changetype)) { 
			String productsServiceName = urlProperty.getCONTRACT_LIST_PRODUCT_BY_PACKAGE_ID();
			String jsonParas = "{\"Package_Id\":\""+(String) PackageMap.get("Package_Id")+"\"}";
			removedProductsList = dataGatewayTemplate.get(jsonParas, productsServiceName).getMsgInfo();
			for(Map<String, Object> removedProducts : removedProductsList) {
				removedProducts.put("changetype", "deleted");
			}
		}
		for(Map Product : ProductsList) {
			Product.put("Rec_Id", UUID.randomUUID().toString().replaceAll("-",""));
			Product.putAll(PackageMap);
			Product.replace("changetype", "inserted");
		}
		ArrayList<Map> requestList = new ArrayList<>();
		if(removedProductsList!=null) {
			requestList.addAll(removedProductsList);
		}
		requestList.addAll(ProductsList);
		String serviceName = urlProperty.getCONTRACT_PACKAGE_SERVICE();
		ResponseEntity result = dataGatewayTemplate.post("["+JsonUtils.ListToJson(requestList)+"]",serviceName);
		//异常处理
		String errInfo = result.getErrInfo();
		if(errInfo.endsWith("for column 'Agreement_Price' at row 1")) {
			result.setErrInfo("协议价不能为空！");
		}
		if(errInfo.endsWith("for key 'UK_Package_No'")) {
			result.setErrInfo("同一运营方下套餐编号不能重复！");
		}
		return result;
	}


	@Override
	public ResponseEntity GetPackageTree(String Operator_Id, String Contract_Id, String KeyWords) {
		try {
		String jsonParas = "{\"Operator_Id\":\""+Operator_Id+"\",\"KeyWords\":\""+KeyWords+"\"}";
		String ListProductServiceName = urlProperty.getContract_List_Package_For_Tree();
		ResponseEntity ListProductByContractId = null;
		ResponseEntity ListProduct = dataGatewayTemplate.get(jsonParas, ListProductServiceName);
		if(!ListProduct.isFlag()) {return ListProduct;}
		List<Map<String, Object>> ProductList = ListProduct.getMsgInfo();
		if(""!=Contract_Id&&"%"!=Contract_Id) {
			String ListProductByContractIdJsonParas = "{\"Contract_Id\":\""+Contract_Id+"\"}";
			String ListProductByContractIdServiceName = urlProperty.getLIST_PRODUCT_BY_CONTRACT_ID();
			ListProductByContractId = dataGatewayTemplate.get(ListProductByContractIdJsonParas, ListProductByContractIdServiceName);
			if(!ListProductByContractId.isFlag()) {return ListProductByContractId;}
			List<Map<String, Object>> ContractProductList = ListProductByContractId.getMsgInfo();
			for(Map<String, Object> ContractProduct : ContractProductList) {
				String ContractProductID = (String)ContractProduct.get("id");
				for(Map<String, Object> Product : ProductList) {
					String ProductID = (String)Product.get("id");
					if(ProductID.equals(ContractProductID)) {
						Product.put("Selected", "Y");
					}
				}
			}
			
		}
		
		List<Map<String, Object>> listToTree = TreeBuilder.listToTree(ProductList,"id","parent_id","Charging_Rule","Price_Guide");
		return new ResponseEntity(true,listToTree,"");
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.error(e.getMessage());
		}
	}
	
	

}
