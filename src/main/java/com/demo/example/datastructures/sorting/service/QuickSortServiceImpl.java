package com.demo.example.datastructures.sorting.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.example.support.serialization.FromJsonHelper;

@Service
public class QuickSortServiceImpl extends BaseArrayDataService implements SortingService {

	private static String sortingType = "QUICK_SORT";

	@Autowired
	public QuickSortServiceImpl(final FromJsonHelper fromJsonHelper) {
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
		quickSort(arrayData, 0, arrayData.size()-1);
	}
	
	private void quickSort(ArrayList<String> datas,int low, int high){
		if(low>=high){
			return;
		}else{
			int pivotItemLocation = partition(datas,low,high);
			quickSort(datas, low, pivotItemLocation-1);
			quickSort(datas, pivotItemLocation+1, high);
		}
	}
	
	private int partition(ArrayList<String> datas, int low,int high){
		String pivot = datas.get(low);
		int left = low;
		int right = high;
		while(left < right){
			while(datas.get(left).compareTo(pivot) <= 0){
				++left;
			}
			while(datas.get(right).compareTo(pivot) > 0){
				--right;
			}
			if(left < right){
				exchange(datas,left,right);
			}
		}
		exchange(datas,low,right);
		return right;
	}
}
