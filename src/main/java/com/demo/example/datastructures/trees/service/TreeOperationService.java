package com.demo.example.datastructures.trees.service;

import java.util.List;

import com.demo.example.datastructures.trees.data.TreeNode;

public interface TreeOperationService {
	public  TreeNode<String> insertNodeData(TreeNode<String> root,String json);
	public TreeNode<String> insertNode(TreeNode<String> root,String item);
	public  void inOrderTraversal(TreeNode<String> item,List<String> items);
	public void preOrderTraversal(TreeNode<String> item,List<String> items);
	public void postOrderTraversal(TreeNode<String> item,List<String> items);
	public void levelOrderTraversal(TreeNode<String> item,List<String> items);
	public int heightOfATree(TreeNode<String> root);
	public int numberOfNodesInaTree(TreeNode<String> root);
	public void printLeftSubTree(TreeNode<String> root,List<String> items);
	public void printRightSubTree(TreeNode<String> root,List<String> items);
	public void printEdgesOfTheTree(TreeNode<String> root,List<String> items);
	public void printLeafNodeOfTheTree(TreeNode<String> root,List<String> items);
	public TreeNode<String> insertDataInAvalTree(TreeNode<String> root,String data);
	public void getAvlTreeData(TreeNode<String> root,List<String> data);
	public TreeNode<String> insertNodeDataIntoAvlTree(TreeNode<String> root, String json);
}
