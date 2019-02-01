package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;
import com.qa.persistance.domain.Classroom;
import com.qa.persistance.util.JSONUtil;

public class ClassroomMapRepository implements ClassroomRepository {

	private Map<Long, Classroom> classroom = new HashMap<>();

	private JSONUtil json = new JSONUtil();

	public String getAllClassrooms() {

		return json.getJSONForObject(classroom);
	}

	public String createClassroom(String classroom) {

		Classroom newClass = json.getObjectForJSON(classroom, Classroom.class);
		Long id = (long) newClass.getAccountNumber();
		classroom.put(id, newClass);
		return "Created new account with first name: " + newClass.getTrainerFName() + ", Last name: "
				+ newClass.getTrainerLName() + ", Account Number: " + newClass.getAccountNumber();
	}

	public String deleteClassroom(Long id) {

		classroom.remove(id);
		return "Removed account by the id: " + id;
	}

	public String updateClassroom(Long id, String classroom) { //////////////////////////////////// Need to complete
		return null;
	}

	public String findClassroom(Long id) {
		return json.getJSONForObject(classroom.get(id));
	}

	public int getCountByFirstNames(String firstName) {
		int count = 0;
		for (Map.Entry<Long, Classroom> AccEntry : classroom.entrySet()) {
			if (AccEntry.getValue().getTrainerFName().equals(firstName)) {
				count++;
			}

		}
		return count;
	}

}
