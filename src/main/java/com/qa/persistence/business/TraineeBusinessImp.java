package com.qa.persistence.business;

import javax.inject.Inject;

import com.qa.persistence.domain.Trainee;
import com.qa.persistence.repository.TraineeRepository;
import com.qa.persistence.util.JSONUtil;


public class TraineeBusinessImp implements TraineeBusiness {

	@Inject
	private TraineeRepository repo;
	@Inject
	private JSONUtil json = new JSONUtil();

	public String getAllTrainees() {
		return repo.getAllTrainees();
	}

	public String createTrainee(String trainee) {
		Trainee newTrainee = json.getObjectForJSON(trainee, Trainee.class);
		if (newTrainee.getFirstName() == "Josh") {
			return "{\"message\": \"Trainee does not belong to this class.\"}";
		}
		if (newTrainee.getFirstName() == "Clare") {
			return "{\"message\": \"Trainee does not belong to this class.\"}";
		}
		if (newTrainee.getLastName() == "Jones") {
			return "{\"message\": \"Trainee does not belong to this class.\"}";
		}
		return repo.createTrainee(trainee);
	}

	public String deleteTrainee(Long id) {
		return repo.deleteTrainee(id);
	}

	public String updatetrainee(Long id, String trainee) {
		return repo.updatetrainee(id, trainee);
	}



	

}