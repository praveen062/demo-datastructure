package com.demo.example.datastructures.sorting.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.example.support.serialization.FromJsonHelper;

@Service
public class ShellSortServiceImpl extends BaseArrayDataService implements SortingService {

	private static String sortingType = "SHELL_SORT";

	@Autowired
	public ShellSortServiceImpl(final FromJsonHelper fromJsonHelper) {
		this.fromApiJsonHelper = fromJsonHelper;
	}

	@Override
	public String getSortingType() {
		return sortingType;
	}

	@Override
	public List<String> sort(String jsonBody) {
		ArrayList<String> sortedArray = new ArrayList<String>();
		getArrayDataFromJsonBody(jsonBody, sortedArray);
		sortTheData(sortedArray);
		return sortedArray;
	}

	private void sortTheData(ArrayList<String> arrayData) {
		int size = arrayData.size();
		int h = 1;
		while(h < size/2){
			h= 2*h +1;
		}
		while(h >= 1){
			for(int i=h;i<size;i++){
				for(int j = i;j >=h; j-=h){
					if(arrayData.get(j).compareTo(arrayData.get(j-h)) < 0){
						exchange(arrayData,j,j-h);
					}
				}
			}
			System.out.println("h = "+h);
			h= h/2;
		}
	}

}
