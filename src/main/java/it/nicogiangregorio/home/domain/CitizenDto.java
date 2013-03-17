package it.nicogiangregorio.home.domain;

import java.io.Serializable;

public class CitizenDto implements Serializable {
	private String idCitizen;
	private String name;
	private String surname;
	private String city;
	private int age;
	
	public CitizenDto(String idCitizen, String name, String surname, String city,
			int age) {
		super();
		this.idCitizen = idCitizen;
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.age = age;
	}
	public String getIdCitizen() {
		return idCitizen;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getCity() {
		return city;
	}
	public int getAge() {
		return age;
	}
}
