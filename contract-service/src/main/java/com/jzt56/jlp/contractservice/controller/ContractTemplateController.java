package com.jzt56.jlp.contractservice.controller;


/**
 * 合同模板控制器，提供合同模板相关服务
 * @author shycier
 *
 */
public interface ContractTemplateController {
	
	/** 获取合同模板列表 */
	public String ListContractTemplateByQuery(String Operator_Id,String KeyWords,int startIndex,int pageSize);
	/** 获取合同模板正文 */
	public String getBlobById(String ContractTemplate_Id);
	/** 保存合同模板 */
	public String saveContractTemplate(String ContractTemplate);
	/** 作废合同模板 */
	public String discardContractTemplate(String[] Discarded_Template_Ids);
	/** 获取下拉选数据 */
	public String getOptionsData(String Field_Name);
	/** 根据权限获取审核中合同模板列表 */
	public String ListContractTemplateByAuthority(String Staff_Id,String KeyWords,int startIndex,int pageSize);
}
