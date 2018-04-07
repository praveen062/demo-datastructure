package com.demo.example.datastructures.binary.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BInaryOperationServiceImpl implements BinaryOperationService{

	@Override
	public List<String> getBinarySequenceWithoutStack(int n) {
		System.out.println("we are here");
		List<String> sequenceMap = new LinkedList<>();
		Integer a[] = new Integer[n];
		generateBinarySequences(n,a,sequenceMap);
		for(String s:sequenceMap){
			System.out.println(s);
		}
		return sequenceMap;
	}
	
	private void generateBinarySequences(int n,Integer[] a,List<String> sequenceMap){
		if(n < 1){
			String s = "";
			for(int i=a.length-1;i >=0;i--){
				s=s+a[i];
			}
			sequenceMap.add(s);
			return;
		}else{
			a[n-1] = 0;
			generateBinarySequences(n-1,a,sequenceMap);
			a[n-1] = 1;
			generateBinarySequences(n-1,a,sequenceMap);
		}
	}

}
