package com.demo.example.datastructures.binary.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.example.datastructures.binary.service.BinaryOperationService;
import com.demo.example.support.service.ToApiJsonSerializer;

@Path("binary")
@Component
public class BinaryApiResource {
	
	BinaryOperationService binaryOperationService;
	@SuppressWarnings("rawtypes")
	ToApiJsonSerializer toApiJsonSerializer;
	@Autowired
	public BinaryApiResource(final BinaryOperationService binaryOperationService,ToApiJsonSerializer toApiJsonSerializer) {
		this.binaryOperationService = binaryOperationService;
		this.toApiJsonSerializer = toApiJsonSerializer;
	}
	
	@GET
	@Path("sequence")
	@Consumes({ MediaType.APPLICATION_JSON }) 
	@Produces({ MediaType.APPLICATION_JSON }) 
	public String getBinarySequence(@QueryParam(value="n") String n){
		List<String> data =  binaryOperationService.getBinarySequenceWithoutStack(Integer.parseInt(n));
		return toApiJsonSerializer.serialize(data);
	}
}
