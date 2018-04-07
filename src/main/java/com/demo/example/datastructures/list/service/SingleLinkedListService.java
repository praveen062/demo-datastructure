package com.demo.example.datastructures.list.service;

import java.util.List;

import com.demo.example.datastructures.list.data.SingleLinkedList;

public interface SingleLinkedListService {
	SingleLinkedList insertFront(int data, SingleLinkedList head);
	SingleLinkedList insertAtPosition(int data,int position, SingleLinkedList head);
	SingleLinkedList insertAtMiddle(int data, SingleLinkedList head);
	SingleLinkedList insertAtEnd(int data, SingleLinkedList head);
	SingleLinkedList deleteFirst(SingleLinkedList head);
	SingleLinkedList deleteLast(SingleLinkedList head);
	SingleLinkedList deleteAtPosition(int position, SingleLinkedList head);
	SingleLinkedList reverseLinkedList(SingleLinkedList head);
	void displayLinkedList(SingleLinkedList head, List<Integer> list);
	void displayInReverseOrder(SingleLinkedList head, List<Integer> list);
}
