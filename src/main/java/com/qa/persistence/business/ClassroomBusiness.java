package com.qa.persistence.business;

public interface ClassroomBusiness {
	
	String getAllClassrooms();
	String createClassroom(String classroom);
	String deleteClassroom(Long id);
	String updateClassroom(Long id, String classroom);


}

