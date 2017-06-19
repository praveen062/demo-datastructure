package com.praveen.praveen.datastructures.trees.api;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.praveen.praveen.support.service.ToApiJsonSerializer;

@Path("hello")
@Component
public class TreesApiResource {
	
	private final ToApiJsonSerializer<Employee> employeeData;
	
	@Autowired
	public TreesApiResource(final ToApiJsonSerializer<Employee> toApiJsonSerializer) {
		this.employeeData = toApiJsonSerializer;
		System.out.println("succesfull initialization");
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public String getData(@Context final UriInfo uriInfo) {
		try{
		Employee  employee = new Employee(Long.valueOf(1), "praveen", 1);
		System.out.println("the employee data is ============="+employeeData);
		return this.employeeData.serialize(employee);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "{}";
	}

}
