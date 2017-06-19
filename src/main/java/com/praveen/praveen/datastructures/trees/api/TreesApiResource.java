package com.praveen.praveen.datastructures.trees.api;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.praveen.praveen.support.service.ToApiJsonSerializer;

@Component
@Path("hello")
public class TreesApiResource {
	final private ToApiJsonSerializer<Employee> employeeData;
	
	@Autowired
	public TreesApiResource(final ToApiJsonSerializer<Employee> toApiJsonSerializer) {
		this.employeeData = toApiJsonSerializer;
		System.out.println("succesfull initialization");
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public String getData() {
		Employee  employee = new Employee(Long.valueOf(1), "praveen", 1);
		return this.employeeData.serialize(employee);
	}

}
