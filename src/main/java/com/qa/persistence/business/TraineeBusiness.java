package com.qa.persistence.business;

public interface TraineeBusiness {
	
	String getAllTrainees();
	String createTrainee(String trainee);
	String deleteTrainee(Long id);
	String updatetrainee(Long id, String trainee);
	//String findAccount(Long id);

}
