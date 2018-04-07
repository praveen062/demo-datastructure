package com.demo.example.datastructures.list.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.example.datastructures.list.data.SingleLinkedList;

@Service
public class SingleLinkedListServiceImple implements SingleLinkedListService {

	@Override
	public SingleLinkedList insertFront(int data, SingleLinkedList head) {
		SingleLinkedList temp = createNewNode(data);
		if(head == null){
			head = temp;
			head.incrementLength();
		}else{
			temp.next = head;
			head = temp;
			head.incrementLength();
		}
		return head;
	}

	@Override
	public SingleLinkedList insertAtPosition(int data, int position, SingleLinkedList head) {

		if(position == 0){
			head = insertFront(data, head);
		}else{
			SingleLinkedList prev = traverseLinkedList(position, head);
			SingleLinkedList temp = createNewNode(data);
			temp.next = prev.next;
			prev.next = temp;
			head.incrementLength();
		}
		return head;
	}

	@Override
	public SingleLinkedList insertAtMiddle(int data, SingleLinkedList head) {
		if(head == null){
			head = insertFront(data, head);
		}else{
			int length = head.length;
			int mid = length/2;
			insertAtPosition(data, mid, head);
		}
		return head;
	}

	@Override
	public SingleLinkedList insertAtEnd(int data, SingleLinkedList head) {
		if(head == null){
			head = insertFront(data, head);
		}else{
			SingleLinkedList temp = head;
			do{
				temp = temp.next;
			}while(temp.next != null);
			temp.next = createNewNode(data);
			temp.incrementLength();
		}
		return null;
	}

	@Override
	public SingleLinkedList deleteFirst(SingleLinkedList head) {
		if(head == null){
			return head;
		}else{
			SingleLinkedList temp = head;
			head = head.next;
			temp.next = null;
		}
		return head;
	}

	@Override
	public SingleLinkedList deleteLast(SingleLinkedList head) {
		SingleLinkedList prev = head;
		if(prev != null){
			if(prev.next == null){
				head = null;
			}else{
				SingleLinkedList nextNode = prev.next;
				while(nextNode.next != null){
					prev = nextNode;
					nextNode = nextNode.next;
				}
				prev.next = null;
			}
		}
		return head;
	}

	@Override
	public SingleLinkedList deleteAtPosition(int position, SingleLinkedList head) {
		if(position == 0){
			head = deleteFirst(head);
		}else if(head != null && position == head.length){
			head = deleteLast(head);
		}else{
			SingleLinkedList prev = head;
			for(int i=0;i<position-1;i++){
				prev = prev.next;
			}
			// now we are at the position n-1 
			SingleLinkedList nodeAtPosition= prev.next;
			prev.next = nodeAtPosition.next;
			nodeAtPosition.next = null;
		}
		return head;
	}

	@Override
	public void displayLinkedList(SingleLinkedList head, List<Integer> list) {
		if(head == null){
			return;
		}else{
			list.add(head.getData());
			displayLinkedList(head.next, list);
		}
	}

	@Override
	public void displayInReverseOrder(SingleLinkedList head, List<Integer> list) {
		if(head == null){
			return;
		}else{
			displayLinkedList(head.next, list);
			list.add(head.getData());
		}
	}
	
	
	private SingleLinkedList createNewNode(int data){
		SingleLinkedList temp = new SingleLinkedList(data);
		return temp;
	}
	
	private SingleLinkedList traverseLinkedList(int position,SingleLinkedList head){
		SingleLinkedList prev = head;
		
		for(int i=0;i<position-1;i++){
			prev = prev.next;
		}
	
		return prev;
	}
	
	@Override
	public SingleLinkedList reverseLinkedList(SingleLinkedList head) {
		SingleLinkedList temp = null;
		SingleLinkedList nextNode = null;
		while(head != null){
			nextNode = head.next;
			head.next = temp;
			temp = head;
			head = nextNode;
		}
		return temp;
	}
}
