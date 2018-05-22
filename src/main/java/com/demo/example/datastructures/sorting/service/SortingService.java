package com.demo.example.datastructures.sorting.service;

import java.util.List;

public interface SortingService {
	String getSortingType();
	List<String> sort(String jsonBody);
}
