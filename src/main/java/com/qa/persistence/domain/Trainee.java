package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trainee {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long traineeId;
	private String firstName;
	private String lastName;

	public Trainee() {
	}

	public Trainee(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;

	}

	public Long getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(Long traineeId) {
		this.traineeId = traineeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
