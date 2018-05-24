package com.demo.example.datastructures.sorting.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.example.support.serialization.FromJsonHelper;

@Service
public class InsertionSortServiceImpl extends BaseArrayDataService implements SortingService {

	private static String sortingType = "INSERTION_SORT";

	@Autowired
	public InsertionSortServiceImpl(final FromJsonHelper fromJsonHelper) {
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
		for (int i = 1; i < size; i++) {
			for (int j = i; j > 0; j--) {
				if (arrayData.get(j).compareTo(arrayData.get(j - 1)) < 0) {
					exchange(arrayData, j, j - 1);
				}
			}
		}
	}

}
