package com.qa.persistence.business;

import javax.inject.Inject;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.repository.ClassroomRepository;
import com.qa.persistence.util.JSONUtil;

public class ClassroomBusinessImp implements ClassroomBusiness {

	@Inject
	private ClassroomRepository repo;
	@Inject
	private JSONUtil json = new JSONUtil();

	public String getAllClassrooms() {
		return repo.getAllClassrooms();
	}

	public String createClassroom(String classroom) {
		Classroom newClass = json.getObjectForJSON(classroom, Classroom.class);
		if (newClass.getTrainerFName() == "Bob") {
			return "{\"message\": \"Trainer is not in this classroom.\"}";
		}
		if (newClass.getTrainerLName() == "Ali") {
			return "{\"message\": \"Trainer is not in this classroom.\"}";
		}
		if (newClass.getTrainerLName() == "Horwell") {
			return "{\"message\": \"Trainer is not in this classroom.\"}";
		}
		return repo.createClassroom(classroom);
	}

	public String deleteClassroom(Long id) {
		return repo.deleteClassroom(id);
	}

	public String updateClassroom(Long id, String classroom) {
		return repo.updateClassroom(id, classroom);
	}



	

}