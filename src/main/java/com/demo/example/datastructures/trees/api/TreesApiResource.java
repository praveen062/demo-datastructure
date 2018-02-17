package com.demo.example.datastructures.trees.api;



import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.demo.example.datastructures.trees.domain.ReadStudentData;
import com.demo.example.support.service.ToApiJsonSerializer;

@Path("hello")
@Component
public class TreesApiResource {
	
	private final ToApiJsonSerializer<Employee> employeeData;
	private final ReadStudentData data;
	
	@Autowired
	public TreesApiResource(final ToApiJsonSerializer<Employee> toApiJsonSerializer,
			final ReadStudentData data) {
		this.employeeData = toApiJsonSerializer;
		this.data = data;
		System.out.println("succesfull initialization");
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Employee getData(@Context final UriInfo uriInfo) {
		try{
		Employee  employee = new Employee(null, "praveen", 1);
		System.out.println("the employee data is ============="+employeeData);
		this.data.saveStudent();
		
		
		return employee;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_JSON })
	public Employee postData(@RequestBody Employee data){
		System.out.println("the data is data" +data);
		return data;
	}
}
