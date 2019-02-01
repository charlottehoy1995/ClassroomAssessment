package com.qa.persistence.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
//import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.persistence.business.ClassroomBusiness;



@Path("/classroom")

public class ClassroomEndPoint {
	
	@Inject
	private ClassroomBusiness business;

	@Path("/getAllClassrooms")
	@GET
	@Produces({ "application/json" })
	public String getAllClassrooms() {
		return business.getAllClassrooms();
	}

	@Path("/createClassroom")
	@POST
	@Produces({ "application/json" })
	public String createClassroom(String classroom) {
		return business.createClassroom(classroom);
	}

	@Path("/deleteClassroom/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteClassroom(@PathParam("id") Long id) {
		return business.deleteClassroom(id);
	}

//	public void setBusiness(ClassroomBusiness service) {
//		this.business = business;
//	}

}
