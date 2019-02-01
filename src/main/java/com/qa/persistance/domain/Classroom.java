package com.qa.persistance.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Classroom {
	 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long classId;
	private String trainerFName;
	private String trainerLName;


	public Classroom() {
	}
	
	public Classroom(String trainerFName, String trainerLName) {
		this.trainerFName = trainerFName;
		this.trainerLName = trainerLName;
		
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public String getTrainerFName() {
		return trainerFName;
	}

	public void setTrainerFName(String trainerFName) {
		this.trainerFName = trainerFName;
	}

	public String getTrainerLName() {
		return trainerLName;
	}

	public void setTrainerLName(String trainerLName) {
		this.trainerLName = trainerLName;
	}
	
	
	
}


	
	

