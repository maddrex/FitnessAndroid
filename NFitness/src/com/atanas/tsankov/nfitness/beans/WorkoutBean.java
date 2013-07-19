package com.atanas.tsankov.nfitness.beans;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class WorkoutBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName("name")
	private String name;

	@SerializedName("exercises")
	private List<ExerciseBean> exercises;

	public WorkoutBean(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ExerciseBean> getExercises() {
		return exercises;
	}

	public void setExercises(List<ExerciseBean> exercises) {
		this.exercises = exercises;
	}
}
