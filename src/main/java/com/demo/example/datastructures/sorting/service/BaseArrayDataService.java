package com.demo.example.datastructures.sorting.service;

import java.util.ArrayList;

import com.demo.example.support.serialization.FromJsonHelper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public abstract class BaseArrayDataService {
	
	protected FromJsonHelper fromApiJsonHelper;
	protected JsonElement jsonElement;

	protected void exchange(ArrayList<String> arrayData,int i, int min){
		String temp = arrayData.get(i);
		String temp2 = arrayData.get(min);
		arrayData.set(i, temp2);
		arrayData.set(min,temp);
	}

	protected JsonArray getArrayData(final String jsonBody){
		jsonElement = fromApiJsonHelper.parse(jsonBody);
		JsonArray jsondata = fromApiJsonHelper.extractJsonArrayNamed("items", jsonElement);
		return jsondata;
	}
	
	protected void getArrayDataFromJsonBody(final String jsonBody,ArrayList<String> arrayData){
		JsonArray jsonArray = getArrayData(jsonBody);
		for(JsonElement element: jsonArray){
			String value = fromApiJsonHelper.extractStringNamed("value", element);
			if(value != null){
				arrayData.add(value);
			}
		}
	}
	
}
