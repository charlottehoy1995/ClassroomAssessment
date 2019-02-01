package com.qa.persistence.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Classroom {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id

	private Long classId;
	private String trainerFName;
	private String trainerLName;
	@OneToMany(mappedBy="classId", fetch = FetchType.EAGER)
	private List<Trainee> trainees;

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
