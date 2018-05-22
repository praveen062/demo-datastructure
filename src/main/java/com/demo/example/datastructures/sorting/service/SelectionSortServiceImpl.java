package com.demo.example.datastructures.sorting.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.example.support.serialization.FromJsonHelper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

@Service
public class SelectionSortServiceImpl implements SortingService{
	
	private static String sortingType = "SELECTION_SORT";
	private FromJsonHelper fromApiJsonHelper;
	private JsonElement jsonElement;
	
	@Autowired
	public SelectionSortServiceImpl(final FromJsonHelper fromJsonHelper){
		this.fromApiJsonHelper = fromJsonHelper;
	}
	
	@Override
	public List<String> sort(String jsonBody) {
		ArrayList<String> sortedArray = new ArrayList<String>();
		JsonArray jsonArray = getArrayData(jsonBody);
		for(JsonElement element: jsonArray){
			String value = fromApiJsonHelper.extractStringNamed("value", element);
			if(value != null){
				sortedArray.add(value);
			}
		}
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
	
	private void exchange(ArrayList<String> arrayData,int i, int min){
		String temp = arrayData.get(i);
		String temp2 = arrayData.get(min);
		arrayData.set(i, temp2);
		arrayData.set(min,temp);
	}

	private JsonArray getArrayData(final String jsonBody){
		jsonElement = fromApiJsonHelper.parse(jsonBody);
		JsonArray jsondata = fromApiJsonHelper.extractJsonArrayNamed("items", jsonElement);
		return jsondata;
	}
	@Override
	public String getSortingType() {
		return sortingType;
	}

}
