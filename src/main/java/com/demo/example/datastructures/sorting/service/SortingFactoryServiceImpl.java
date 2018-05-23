package com.demo.example.datastructures.sorting.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SortingFactoryServiceImpl {

	private Map<String, SortingService> sortingServices = new HashMap<String, SortingService>();

	@Autowired
	public SortingFactoryServiceImpl(Set<SortingService> sortingServices) {
		for (SortingService sortingService : sortingServices) {
			this.sortingServices.put(sortingService.getSortingType(), sortingService);
		}
	}

	public List<String> sort(String sortingType, String jsonBody) {
		List<String> sortedData = null;
		SortingService sortingService;
		switch (sortingType) {
		case "selection_sort":
			sortingService = sortingServices.get("SELECTION_SORT");
			sortedData = sortingService.sort(jsonBody);
			break;
		case "insertion_sort": sortingService = sortingServices.get("INSERTION_SORT");
		sortedData = sortingService.sort(jsonBody); 

		default:
			break;
		}
		return sortedData;
	}

}
