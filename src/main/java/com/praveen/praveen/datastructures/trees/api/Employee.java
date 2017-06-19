package com.praveen.praveen.datastructures.trees.api;


public class Employee {
	private Long id;
	private String name;
	private int gender;
	
	public Employee(final Long id, final String name, final int gender) {
		this.id = id;
		this.name = name;
		this.gender = gender;
	}
	
	public void setGender(int gender) {
		this.gender = gender;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
    public void setName(String name) {
		this.name = name;
	}
}
