package com.demo.example.datastructures.sorting.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.example.support.serialization.FromJsonHelper;

@Service
public class SelectionSortServiceImpl extends BaseArrayDataService implements SortingService{
	
	private static String sortingType = "SELECTION_SORT";
	
	@Autowired
	public SelectionSortServiceImpl(final FromJsonHelper fromJsonHelper){
		this.fromApiJsonHelper = fromJsonHelper;
	}
	
	@Override
	public List<String> sort(String jsonBody) {
		ArrayList<String> sortedArray = new ArrayList<String>();
		getArrayDataFromJsonBody(jsonBody, sortedArray);
		if(sortedArray.size() > 0){
			sortTheArrayItems(sortedArray);
		}
		return sortedArray;
	}
	
	private void sortTheArrayItems(ArrayList<String> arrayData){
		int size = arrayData.size();
		for(int i=0;i<size;i++){
			int min = i;
			for(int j=(i+1);j< size;j++){
				if(arrayData.get(j).compareTo(arrayData.get(min)) < 0){
					min = j;
				}
			}
			if(min != i){
				exchange(arrayData,i,min);
			}
		}
	}
	
	@Override
	public String getSortingType() {
		return sortingType;
	}

}
