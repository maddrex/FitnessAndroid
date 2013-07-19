package com.atanas.tsankov.nfitness.beans;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Programme implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName("workouts")
	private List<Workout> workouts;

	public List<Workout> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(List<Workout> workouts) {
		this.workouts = workouts;
	}
}
