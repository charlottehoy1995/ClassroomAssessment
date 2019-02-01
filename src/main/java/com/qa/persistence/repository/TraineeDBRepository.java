package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Trainee;
import com.qa.persistence.util.JSONUtil;


@Transactional(SUPPORTS)
public class TraineeDBRepository implements TraineeRepository {

	@PersistenceContext(unitName = "primary")		//Configures entity manager
	private EntityManager em;
	
	@Inject
	private JSONUtil json;

	public String getAllTrainees() {
		Query allTrainees = em.createQuery("SELECT a FROM Trainee a");
		return json.getJSONForObject(allTrainees.getResultList());		
	}	

	@Transactional(REQUIRED)
	public String createTrainee(String trainee) {
		Trainee newTrainee = json.getObjectForJSON(trainee, Trainee.class);
		em.persist(newTrainee);
		return "{\"message\": \"trainee sucessfully created\"}";
	}


	@Transactional(REQUIRED)
	public String deleteTrainee(Long id) {
		Trainee delTrainee = findTrainee(id);
		if (delTrainee != null) {
			em.remove(delTrainee);
		}
		return "{\"message\": \"trainee sucessfully deleted\"}";
	}
	
	@Transactional(REQUIRED)
	public String updatetrainee(Long id, String trainee) {
		Trainee updatetrainee = findTrainee(id);
		deleteTrainee(id);
		createTrainee(trainee);
		return "{\"message\": \"trainee sucessfully updated\"}";
	}
	
	
	public Trainee findTrainee(Long id) {
		return em.find(Trainee.class, id);
	}
	

	
}
