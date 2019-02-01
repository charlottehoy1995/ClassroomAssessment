package com.qa.persistence.repository;

public interface TraineeRepository {
	
	String getAllTrainees();
	String createTrainee(String trainee);
	String deleteTrainee(Long id);
	String updatetrainee(Long id, String trainee);
	//String findAccount(Long id);
	

}
