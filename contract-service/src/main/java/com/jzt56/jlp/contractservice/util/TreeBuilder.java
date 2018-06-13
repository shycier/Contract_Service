package com.jzt56.jlp.contractservice.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
/**
 * TreeBuilder通过递归调用将数据库查出的List数据集转化为前端需要的Tree形式
 * 将需要构建成树型结构的数据封装到List<Map<String, Object>>中，每个node
 * 需要有id parentId 和其他可选字段，参数名自己定义，只需要将参数名对应传入方法，
 * listToTree方法会递归调用buildTreeNode方法来根据id和pid关系来构建树形结构
 * 另外提供了removedField参数来剔除掉非末端节点不显示的字段。
 * @author Shycier
 *
 */
public class TreeBuilder {
	
	/**
	 * TreeBuilder的主要方法用来构建Tree结构
	 * @param nodeList 			叶子节点列表
	 * @param id				表示叶子ID的字段名
	 * @param parentId			表示叶子父亲ID的字段名
	 * @param removedField		非末端节点需要剔除的字段
	 * @return
	 */
	public static List<Map<String,Object>> listToTree(List<Map<String, Object>> nodeList,String id,String parentId,String ...removedField){
		int initDepth = 0 ;
		List<Map<String,Object>> result = new ArrayList<>();
		//获取pid为0的顶级节点加入list
		for(Map<String,Object> node:nodeList) {
			String family = UUID.randomUUID().toString().replaceAll("-","");
			String pid = (String)node.get(parentId);
			if("0".equals(pid)) {
				node = buildTreeNode(node,nodeList,id,parentId,initDepth,family,removedField);
				node.put("pid", null);
				node.put("depth",initDepth);
				node.put("family", family);
				result.add(node);
			}
		}
		//遍历list对每个节点调用buildTreeNode方法，构建节点
		return result;
	}
	
	/**
	 * 递归调用 构建子节点
	 * @param treeNode 			叶子节点
	 * @param nodeList			叶子节点集合
	 * @param id				表示叶子ID的字段名
	 * @param parentId			表示叶子父亲ID的字段名
	 * @param removedField  	非末端节点需要剔除的字段
	 * @return
	 */
	private static Map<String,Object> buildTreeNode(Map<String,Object> treeNode,List<Map<String,Object>> nodeList,String id,String parentId,int depth,String family,String ...removedField){
		int CunrrentDepth = depth+1;
		treeNode.put("family", family);
		//定义初始层数
		treeNode.put("depth", CunrrentDepth);
		//节点ID
		String ID = (String)treeNode.get(id);
		//是否为末端节点
		boolean IsEnd = true;
		//当前节点的子节点列表
		List<Map<String,Object>> nodes = new ArrayList<>();
		for(Map<String,Object> node:nodeList) {
			String pid = (String)node.get(parentId);
			if(pid.equals(ID)) {
				IsEnd = false;
				nodes.add(node);
			}
		}
		//如果该节点为末端节点，添加节点信息
		if(IsEnd == true) {
			treeNode.put("endNode", "Y");
			return treeNode;
		}
		//如果该节点不为末端节点，遍历添加子节点集合，并递归调用构建节点方法
		else {
			existAndRemove(treeNode,removedField);
			//遍历子节点递归调用
			List<Object> childrenList = new ArrayList<>();
			for(Map<String,Object> childNode : nodes) {
				childNode = buildTreeNode(childNode,nodeList,id,parentId,CunrrentDepth,family,removedField);
				childrenList.add(childNode);
			}
			treeNode.put("children", childrenList);
		}
		return treeNode;
	}
	
	/**
	 * 对非末端节点移出不需要的字段
	 * @param treeNode 		当前节点
	 * @param removedFields 要移除的字段
 	 */
	private static void existAndRemove(Map<String,Object> treeNode,String ...removedFields) {
		for(String removedField : removedFields) {
			treeNode.remove(removedField);
		}
	}
	
}
