package com.demo.example.datastructures.trees.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.demo.example.support.domain.AbstractPersistableCustom;

@Entity
@Table(name = "shop")
public class Student extends AbstractPersistableCustom<Long>{
	@Column(name = "name")
	private String name;
	
	@Column(name= "numberOfEmployees")
	private int numberOfEmployee;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberOfEmployee() {
		return numberOfEmployee;
	}
	public void setNumberOfEmployee(int numberOfEmployee) {
		this.numberOfEmployee = numberOfEmployee;
	}
	
}
