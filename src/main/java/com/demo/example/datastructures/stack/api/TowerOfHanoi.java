package com.demo.example.datastructures.stack.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.springframework.stereotype.Component;

@Path("stack")
@Component
public class TowerOfHanoi {
	
	
	@POST
	public String towerOfHanoi(@Context final UriInfo uriInfo){
		
		return "success here "+uriInfo.getAbsolutePath().getPath();
	}
	
	
	@GET
	public String getTower(@QueryParam(value = "n") String n,@Context HttpServletRequest request ){
		request.getSession().setAttribute("Number", n);
		return "success ";
	}
	
	@Path("/number")
	@GET
	public String getTheNumber(@Context HttpServletRequest request){
		
		return "number is "+request.getSession().getAttribute("Number")+" session is "+request.getSession().getId();
	}
}
