package com.demo.example.datastructures.sorting.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.demo.example.datastructures.sorting.service.SortingFactoryServiceImpl;
import com.demo.example.support.service.ToApiJsonSerializer;

@Path("sort")
@Component
public class SortingApiResource {

	public SortingFactoryServiceImpl sortingFactoryServiceImpl;
	private final ToApiJsonSerializer<?> jsonSerializer;
	
	public SortingApiResource(final ToApiJsonSerializer<?> apiJsonSerializer,final SortingFactoryServiceImpl sortingFactoryServiceImpl ){
		this.sortingFactoryServiceImpl = sortingFactoryServiceImpl;
		this.jsonSerializer = apiJsonSerializer;
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_JSON })
	public String postdata(@RequestBody String data,@QueryParam("sortType") String sortType){
		List<String> sortedData = sortingFactoryServiceImpl.sort(sortType, data);
		return jsonSerializer.serialize(sortedData);
	}
	
}
