package com.qa.persistance.business;

public interface ClassroomBusiness {
	
	String getAllClassrooms();
	String createClassroom(String classroom);
	String deleteClassrom(Long id);
	String updateClassroom(Long id, String classroom);


}

