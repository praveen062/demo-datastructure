package com.demo.example.datastructures.trees.api;



import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.demo.example.datastructures.trees.data.TreeNode;
import com.demo.example.datastructures.trees.domain.Employee;
import com.demo.example.datastructures.trees.domain.ReadStudentData;
import com.demo.example.datastructures.trees.service.TreeOperationService;
import com.demo.example.support.service.ToApiJsonSerializer;

@Path("trees")
@Component
public class TreesApiResource {
	
	private final ToApiJsonSerializer<?> employeeData;
	private final ReadStudentData data;
	private final TreeOperationService treeOperationService;
	
	@Autowired
	public TreesApiResource(final ToApiJsonSerializer<?> toApiJsonSerializer,
			final ReadStudentData data,TreeOperationService treeOperationService) {
		this.employeeData = toApiJsonSerializer;
		this.data = data;
		this.treeOperationService = treeOperationService;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Employee getData(@Context final UriInfo uriInfo) {
		
		return null;
	}

	
	@SuppressWarnings("unchecked")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_JSON })
	public String postData(@RequestBody String data,@Context HttpServletRequest request){
		System.out.println("call");
		TreeNode<String> treeNode = (TreeNode<String>) request.getSession().getAttribute("TreeNode");
		treeNode = treeOperationService.insertNodeData(treeNode, data);
		request.getSession().setAttribute("TreeNode", treeNode);
		System.out.println("call"+treeNode.data);
		return data;
	}
	
	@SuppressWarnings("unchecked")
	@POST
	@Path("avlinsert")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_JSON })
	public String insertAvlTree(@RequestBody String data,@Context HttpServletRequest request){
		System.out.println("call");
		TreeNode<String> treeNode = (TreeNode<String>) request.getSession().getAttribute("TreeNode");
		treeNode = treeOperationService.insertNodeDataIntoAvlTree(treeNode, data);
		request.getSession().setAttribute("TreeNode", treeNode);
		System.out.println("call"+treeNode.data);
		return data;
	}
	
	
	@SuppressWarnings("unchecked")
	@Path("session")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public String getDataone(@Context HttpServletRequest request){
		System.out.println("call here");
		TreeNode<String> treeNode = (TreeNode<String>) request.getSession().getAttribute("TreeNode");
		return treeNode.data;
	}
	
	@SuppressWarnings("unchecked")
	@Path("inorder")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public String inorderTraversal(@Context HttpServletRequest request){
		System.out.println("call here");
		TreeNode<String> treeNode = (TreeNode<String>) request.getSession().getAttribute("TreeNode");
		List<String> nodeItems = new LinkedList<String>() ;
		treeOperationService.inOrderTraversal(treeNode, nodeItems);
		return employeeData.serialize(nodeItems);
	}
	
	@SuppressWarnings("unchecked")
	@Path("preorder")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public String preorderTraversal(@Context HttpServletRequest request){
		System.out.println("call here");
		TreeNode<String> treeNode = (TreeNode<String>) request.getSession().getAttribute("TreeNode");
		List<String> nodeItems = new LinkedList<String>() ;
		treeOperationService.preOrderTraversal(treeNode, nodeItems);
		return employeeData.serialize(nodeItems);
	}
	
	@SuppressWarnings("unchecked")
	@Path("levelOrder")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public String levelOrderTraversal(@Context HttpServletRequest request){
		System.out.println("call here");
		TreeNode<String> treeNode = (TreeNode<String>) request.getSession().getAttribute("TreeNode");
		List<String> nodeItems = new LinkedList<String>() ;
		treeOperationService.levelOrderTraversal(treeNode, nodeItems);
		return employeeData.serialize(nodeItems);
	}
	
	@Path("left")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public String leftNodes(@Context HttpServletRequest request){
		System.out.println("call here");
		TreeNode<String> treeNode = (TreeNode<String>) request.getSession().getAttribute("TreeNode");
		List<String> nodeItems = new LinkedList<String>() ;
		treeOperationService.printLeftSubTree(treeNode, nodeItems);
		return employeeData.serialize(nodeItems);
	}
	
	@Path("right")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public String rightNodes(@Context HttpServletRequest request){
		System.out.println("call here");
		TreeNode<String> treeNode = (TreeNode<String>) request.getSession().getAttribute("TreeNode");
		List<String> nodeItems = new LinkedList<String>() ;
		treeOperationService.printRightSubTree(treeNode, nodeItems);
		return employeeData.serialize(nodeItems);
	}
	
	@Path("leaf")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public String leafNodes(@Context HttpServletRequest request){
		System.out.println("call here");
		TreeNode<String> treeNode = (TreeNode<String>) request.getSession().getAttribute("TreeNode");
		List<String> nodeItems = new LinkedList<String>() ;
		treeOperationService.printLeafNodeOfTheTree(treeNode, nodeItems);
		return employeeData.serialize(nodeItems);
	}
	
	@Path("edges")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public String edgeNodes(@Context HttpServletRequest request){
		System.out.println("call here");
		TreeNode<String> treeNode = (TreeNode<String>) request.getSession().getAttribute("TreeNode");
		List<String> nodeItems = new LinkedList<String>() ;
		treeOperationService.printEdgesOfTheTree(treeNode, nodeItems);
		return employeeData.serialize(nodeItems);
	}
	
	@SuppressWarnings("unchecked")
	@Path("height")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public String height(@Context HttpServletRequest request){
		System.out.println("call here");
		TreeNode<String> treeNode = (TreeNode<String>) request.getSession().getAttribute("TreeNode");
		int height = treeOperationService.heightOfATree(treeNode);
		return employeeData.serialize(height);
	}
	
	@SuppressWarnings("unchecked")
	@Path("size")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public String size(@Context HttpServletRequest request){
		System.out.println("call here");
		TreeNode<String> treeNode = (TreeNode<String>) request.getSession().getAttribute("TreeNode");
		int height = treeOperationService.numberOfNodesInaTree(treeNode);
		return employeeData.serialize(height);
	}
	
}
