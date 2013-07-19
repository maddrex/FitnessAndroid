package com.atanas.tsankov.nfitness.beans;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Exercise implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName("name")
	private String name;

	@SerializedName("rest")
	private int rest;

	@SerializedName("kilograms")
	private int kilograms;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRest() {
		return rest;
	}

	public void setRest(int rest) {
		this.rest = rest;
	}

	public int getKilograms() {
		return kilograms;
	}

	public void setKilograms(int kilograms) {
		this.kilograms = kilograms;
	}

}
