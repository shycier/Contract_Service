package com.jzt56.jlp.contractservice.service;

import com.jzt56.jlp.contractservice.entity.ResponseEntity;

/**
 * 合同服务
 * @author shycier
 *
 */
public interface ContractService {
	
	/** 生产产品树 */
	public ResponseEntity BuildProductTree(ResponseEntity responseEntityStr);
	
	/** 保存合同 */
	public String SaveContract(String jsonContract,String jsonContractProduct);
	
	/** 获取全部产品树 */
	public String getProductTree(String Operator_Id,String Contract_Id,String KeyWords);
	
	/** 获取末端节点列表 */
	public String listEndNode(String treeNode);
	
	/** 生成合同编号 
	 * @throws Exception */
	public String GenerateContractNO(String Operator_Id,String ContractTemplate_Id) throws Exception;
	
	/** 获取打印模板 */
	public String getPrintData(String Contract_Id);
	
}
