package com.demo.example.datastructures.list.data;

public class SingleLinkedList {
	public SingleLinkedList next;
	private int data;
	public int length;
	
	public SingleLinkedList(int data){
		this.data = data;
		this.next = null;
	}
	
	public void incrementLength(){
		length+=1;
	}
	
	public void decrementLength(){
		if(length > 0 ){
			length-=1;
		}
	}
	
	public int getData(){
		return this.data;
	}
}
