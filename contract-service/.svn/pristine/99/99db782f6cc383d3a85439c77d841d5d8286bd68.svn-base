package com.jzt56.jlp.contractservice.service;

import org.springframework.stereotype.Service;

/**
 * 合同模板服务接口，由于对资源的增删改操作无法通过简单的调用
 * 数据网关实现，故增加此接口服务，对业务逻辑封装。
 * @author shycier
 *
 */
@Service
public interface ContractTemplateService {
	
	/** 保存合同模板   */
	public String SaveContractTemplate(String ContractTemplate);
	
	/** 作废合同模板   */
	public String discardContractTemplate(String[] ids);
	
}
