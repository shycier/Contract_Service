package com.jzt56.jlp.contractservice.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonAutoDetect(getterVisibility=Visibility.NONE,setterVisibility=Visibility.NONE)
public class ResponseEntity {
	
	@JsonProperty("Flag")
	private boolean Flag;
	
	@JsonProperty("MsgInfo")
	private List<Map<String, Object>> MsgInfo;
	
	@JsonProperty("ErrInfo")
	private String ErrInfo;
	
	public ResponseEntity() {
		
	}
	
	public ResponseEntity(boolean Flag,List<Map<String, Object>> MsgInfo,String ErrInfo) {
		this.Flag = Flag;
		this.MsgInfo = MsgInfo;
		this.ErrInfo = ErrInfo;
	}


	public boolean isFlag() {
		return Flag;
	}

	public void setFlag(boolean flag) {
		Flag = flag;
	}

	public List<Map<String, Object>> getMsgInfo() {
		return MsgInfo;
	}

	public void setMsgInfo(List<Map<String, Object>> msgInfo) {
		MsgInfo = msgInfo;
	}

	public String getErrInfo() {
		return ErrInfo;
	}

	public void setErrInfo(String errInfo) {
		ErrInfo = errInfo;
	}
	
	public static ResponseEntity error(String ErrInfo) {
		return  new ResponseEntity(false,new ArrayList<>(),ErrInfo);
	}
	
	public static ResponseEntity ok(List<Map<String,Object>> MsgInfo) {
		return new ResponseEntity(true,MsgInfo,"");
	}
	
}
