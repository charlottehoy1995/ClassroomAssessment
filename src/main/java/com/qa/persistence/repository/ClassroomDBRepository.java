package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.util.JSONUtil;


@Transactional(SUPPORTS)
public class ClassroomDBRepository implements ClassroomRepository {

	@PersistenceContext(unitName = "primary")		//Configures entity manager
	private EntityManager em;
	
	@Inject
	private JSONUtil json;

	public String getAllClassrooms() {
		Query allAccounts = em.createQuery("Select a FROM Account a");
		return json.getJSONForObject(allAccounts.getResultList());		
	}	

	@Transactional(REQUIRED)
	public String createClassroom(String classroom) {
		Classroom newClass = json.getObjectForJSON(classroom, Classroom.class);
		em.persist(newClass);
		return "{\"message\": \"account sucessfully created\"}";
	}


	@Transactional(REQUIRED)
	public String deleteClassroom(Long id) {
		Classroom delAccount = findClassroom(id);
		if (delAccount != null) {
			em.remove(delAccount);
		}
		return "{\"message\": \"account sucessfully deleted\"}";
	}
	
	@Transactional(REQUIRED)
	public String updateClassroom(Long id, String classroom) {
		Classroom updateClass = findClassroom(id);
		deleteClassroom(id);
		createClassroom(classroom);
		return "{\"message\": \"account sucessfully updated\"}";
	}
	
	
	public Classroom findClassroom(Long id) {
		return em.find(Classroom.class, id);
	}

	
}
