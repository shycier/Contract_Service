package com.jzt56.jlp.contractservice.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 合同模板实体类
 * @author Shycier
 *
 */


@JsonAutoDetect(getterVisibility=Visibility.NONE,setterVisibility=Visibility.NONE)
public class ContractTemplate {
	
	/** 合同模板ID */
	@JsonProperty("ContractTemplate_Id")
	private String ContractTemplate_Id;
	
	/** 运营方ID */
	@JsonProperty("Operator_Id")
	private String Operator_Id;
	
	/** 合同模板类型 */
	@JsonProperty("ContractTemplate_Type")
	private String ContractTemplate_Type;
	
	/** 合同模板类别 */
	@JsonProperty("ContractTemplate_Category")
	private String ContractTemplate_Category;
	
	/** 合同模板编号 */
	@JsonProperty("ContractTemplate_No")
	private String ContractTemplate_No;
	
	/** 合同模板名称 */
	@JsonProperty("ContractTemplate_Name")
	private String ContractTemplate_Name;
	
	/** 合同模板状态 */
	@JsonProperty("ContractTemplate_State")
	private String ContractTemplate_State;
	
	/** 合同模板正文 */
	@JsonProperty("Contract_Content")
	private String Contract_Content;
	
	/** 创建时间 */
	@JsonProperty("Created_Time")
	private String Created_Time;
	
	/** 更新时间 */
	@JsonProperty("Updated_Time")
	private String Updated_Time;
	
	/** 创建者 */
	@JsonProperty("Creator")
	private String Creator;
	
	/** 数据网关策略 */
	@JsonProperty("changetype")
	private String changetype;

	public String getContractTemplate_Id() {
		return ContractTemplate_Id;
	}

	public void setContractTemplate_Id(String contractTemplate_Id) {
		ContractTemplate_Id = contractTemplate_Id;
	}

	public String getOperator_Id() {
		return Operator_Id;
	}

	public void setOperator_Id(String operator_Id) {
		Operator_Id = operator_Id;
	}

	public String getContractTemplate_Type() {
		return ContractTemplate_Type;
	}

	public void setContractTemplate_Type(String contractTemplate_Type) {
		ContractTemplate_Type = contractTemplate_Type;
	}

	public String getContractTemplate_Category() {
		return ContractTemplate_Category;
	}

	public void setContractTemplate_Category(String contractTemplate_Category) {
		ContractTemplate_Category = contractTemplate_Category;
	}

	public String getContractTemplate_No() {
		return ContractTemplate_No;
	}

	public void setContractTemplate_No(String contractTemplate_No) {
		ContractTemplate_No = contractTemplate_No;
	}

	public String getContractTemplate_Name() {
		return ContractTemplate_Name;
	}

	public void setContractTemplate_Name(String contractTemplate_Name) {
		ContractTemplate_Name = contractTemplate_Name;
	}

	public String getContractTemplate_State() {
		return ContractTemplate_State;
	}

	public void setContractTemplate_State(String contractTemplate_State) {
		ContractTemplate_State = contractTemplate_State;
	}

	public String getContract_Content() {
		return Contract_Content;
	}

	public void setContract_Content(String contract_Content) {
		Contract_Content = contract_Content;
	}

	public String getCreated_Time() {
		return Created_Time;
	}

	public void setCreated_Time(String created_Time) {
		Created_Time = created_Time;
	}

	public String getUpdated_Time() {
		return Updated_Time;
	}

	public void setUpdated_Time(String updated_Time) {
		Updated_Time = updated_Time;
	}

	public String getCreator() {
		return Creator;
	}

	public void setCreator(String creator) {
		Creator = creator;
	}

	public String getChangetype() {
		return changetype;
	}

	public void setChangetype(String changetype) {
		this.changetype = changetype;
	}
	
	
}
