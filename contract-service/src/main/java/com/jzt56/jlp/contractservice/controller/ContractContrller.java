package com.jzt56.jlp.contractservice.controller;

/**
 * 合同服务控制器，提供合同相关服务
 * @author shycier
 *
 */
public interface ContractContrller {
	
	/** 获取合同列表  */
	public String ListContractByQuery(String Operator_Id,String KeyWords,int startIndex,int pageSize);
	/** 通过ID获取合同详情  */
	public String GetContractById(String Contract_Id);
	/** 保存合同  */
	public String SaveContract(String Contract,String Products);
	/** 获取合同签订方列表  */
	public String ListContractSignedParty(String Operator_Id,String KeyWords);
	/** 获取物流中心列表  */
	public String ListLdcByOperatorId(String Operator_Id,String KeyWords);
	/** 获取合同模板列表 */
	public String ListSimpleContractTemplate(String Operator_Id,String KeyWords);
	/** 获取成本价  */
	public String GetPriceCost(String Product_Id);
	/** 根据ID获取产品列表 */
	public String ListProductByContractId(String Contract_Id);
	/** 获取运营方信息 */
	public String ListOperator(String Operator_Ids,String KeyWords);
	/** 获取全部产品树 */
	public String GetProductTreeByQuery(String Operator_Id,String Contract_Id, String KeyWords);
	/** 根据权限获取审核中合同列表 */
	public String ListContractByAuthority(String Staff_Id,String KeyWords,int startIndex,int pageSize);
	/** 获取末端节点列表 */
	public String ListEndNode(String treeNode);
	/** 获取打印数据 */
	public String GetPrintData(String Contract_Id);
}
