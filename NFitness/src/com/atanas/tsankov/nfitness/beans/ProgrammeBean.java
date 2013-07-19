package com.atanas.tsankov.nfitness.beans;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ProgrammeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName("workouts")
	private List<WorkoutBean> workouts;

	public List<WorkoutBean> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(List<WorkoutBean> workouts) {
		this.workouts = workouts;
	}
}
