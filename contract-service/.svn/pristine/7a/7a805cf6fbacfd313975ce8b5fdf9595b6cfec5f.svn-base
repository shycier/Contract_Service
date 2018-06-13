package com.jzt56.jlp.contractservice.util;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.jzt56.jlp.contractservice.entity.ResponseEntity;
import com.jzt56.jlp.contractservice.property.UrlProperty;
import com.jzt56.jlp.contractservice.template.DataGatewayTemplate;

@Component
public class SeqNoUtil {
	
	@Autowired
	DataGatewayTemplate dataGatewayTemplate;
	
	@Autowired
	UrlProperty urlProperty;
	
	public synchronized String getSeqNo(String Seq_Name) throws Exception {
		String Seq_No = "";
		String jsonParas = "{\"Seq_Name\":\""+Seq_Name+"\"}";
		String serviceName = urlProperty.getSys_Seqno_Rule();
		ResponseEntity responseEntity = dataGatewayTemplate.get(jsonParas, serviceName);
		if(!responseEntity.isFlag()) {
			throw new Exception("获取序列失败：服务[Sys_Seqno_Rule]:"+responseEntity.getErrInfo()); 
		}
		List<Map<String,Object>> seqList = responseEntity.getMsgInfo();
		if(seqList.size()!=1) {
			throw new Exception("获取序列失败：服务[Sys_Seqno_Rule]:"+Seq_Name+"未查询到序列规则信息，请检查"); 
		}else {
			String Sys_Date = DateUtil.format(new Date(),"yyyyMMdd");
			Map<String, Object> seq = seqList.get(0);
			String Seq_Type = seq.get("Seq_Type").toString();
			String Seq_Sign = (String)seq.get("Seq_Sign");
			int Seq_Length = (int)seq.get("Seq_Length");
			String Last_Date = (String)seq.get("Last_Date");
			int Current_Value = (int)seq.get("Current_Value");
			if(Seq_Type.equals("1")) {
				Current_Value++;
			}else if(Seq_Type.equals("2")) {
				if(Sys_Date.equals(Last_Date)) {
					Current_Value++;
				}else{
					Last_Date = Sys_Date;
					Current_Value = 1;
				}
			}
		    if (null==Seq_Sign||"".equals(Seq_Sign)){
		    	if (Seq_Type.equals("2") && Seq_Length >= 8){
                   	 Seq_No = Seq_Sign + Sys_Date + padLeft("0",Seq_Length-8,String.valueOf(Current_Value));
                    }
                else{
                   	 Seq_No = Seq_Sign + Sys_Date + padLeft("0",Seq_Length,String.valueOf(Current_Value));
                    }
                }
            else if (Seq_Type.equals("2") && Seq_Length >= (8 + Seq_Sign.length())){
               	 Seq_No = Seq_Sign + Sys_Date + padLeft("0",Seq_Length - 8 - Seq_Sign.length(),String.valueOf(Current_Value));
                }
            else{
               	 Seq_No = Seq_Sign + padLeft("0",Seq_Length - Seq_Sign.length(),String.valueOf(Current_Value));
                }
            if (null!=Seq_No&&!"".equals(Seq_No))
                {	
               	 String updateJsonParas = "[{\"Seq_Name\":\""+Seq_Name+"\",\"Last_Date\":\""+Last_Date+"\",\"Current_Value\":\""+Current_Value+"\",\"changetype\":\"updated\"}]";
               	 String updateServiceName = urlProperty.getSys_Seqno_Rule();
               	 ResponseEntity result = dataGatewayTemplate.post(updateJsonParas, updateServiceName);
                 if (!result.isFlag()){
                        return "";
                    }
                }
		}
		return Seq_No;

	}
	
	public String padLeft(String padString, int num ,String source) {
		int length = source.length();
		int prefixNum = num - length;
		String result = "";
		for(int i = 0;i < prefixNum; i++) {
			result += padString;
		}
		return result+source;
	}
	
}
