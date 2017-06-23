package com.praveen.praveen.datastructures.trees.api;

import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.map.annotate.JsonView;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonSerialize(include=Inclusion.NON_NULL)
@JsonDeserialize
public class Employee implements Serializable{

	@JsonView
	private Long id;
	@JsonView
	private String name;
	@JsonView
	private int gender;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
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
