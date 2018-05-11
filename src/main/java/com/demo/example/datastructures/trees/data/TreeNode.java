package com.demo.example.datastructures.trees.data;

public class TreeNode<T> {
	public TreeNode<T> leftLink;
	public T data;
	public TreeNode<T> rightLink;
	public TreeNode(T data) {
		this.leftLink = null;
		this.data = data;
		this.rightLink = null;
	}
	
	
}
