package com.jzt56.jlp.contractservice.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EndNodeSelector {
	
	public static List<Map<String,Object>> ListEndNodes(Map<String,Object> treeNode){
		ArrayList<Map<String,Object>> endLists = new ArrayList<>();
		isEndNode(endLists,treeNode);
		return endLists;
	}
	
	@SuppressWarnings("unchecked")
	public static void  isEndNode(ArrayList<Map<String,Object>> endLists,Map<String,Object> treeNode) {
		if(null != treeNode.get("endNode")&&"Y".equals(treeNode.get("endNode"))) {
			treeNode.put("Product_Name", treeNode.get("node_name"));
			endLists.add(treeNode);
		} else {
			List<Map<String,Object>> children = (List<Map<String,Object>>)treeNode.get("children");
			for(Map<String,Object> child : children) {
				isEndNode(endLists,child);
			}
		}
	}	
}
