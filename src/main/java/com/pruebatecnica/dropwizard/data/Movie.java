package com.pruebatecnica.dropwizard.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {
	
	private int id;
	private String name;
	private int age;
	private String genere;
	
	public Movie() {
		//Neceseario por el Jackson.
	}
	
	public Movie(int id, String name, int age, String genere) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.genere = genere;
	}
	
	@JsonProperty
	public int getId() {
		return id;
	}
	
	@JsonProperty
	public String getName() {
		return name;
	}

	@JsonProperty
	public int getAge() {
		return age;
	}

	@JsonProperty
	public String getGenere() {
		return genere;
	}	

}
