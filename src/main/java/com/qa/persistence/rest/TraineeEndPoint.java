package com.qa.persistence.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
//import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.persistence.business.TraineeBusiness;


@Path("/trainee")
public class TraineeEndPoint {
	
	@Inject
	private TraineeBusiness business;

	@Path("/getAllTrainees")
	@GET
	@Produces({ "application/json" })
	public String getAllTrainees() {
		return business.getAllTrainees();
	}

	@Path("/createTrainee")
	@POST
	@Produces({ "application/json" })
	public String createTrainee(String trainee) {
		return business.createTrainee(trainee);
	}

	@Path("/deleteTrainee/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteTrainee(@PathParam("id") Long id) {
		return business.deleteTrainee(id);
	}

//	public void setBusiness(ClassroomBusiness service) {
//		this.business = business;
//	}

}
