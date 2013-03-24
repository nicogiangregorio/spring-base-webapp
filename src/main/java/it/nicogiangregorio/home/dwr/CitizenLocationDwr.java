package it.nicogiangregorio.home.dwr;

import it.nicogiangregorio.home.domain.CitizenLocation;

import java.io.Serializable;

public class CitizenLocationDwr implements Serializable{

	private static final long serialVersionUID = 2907377802597332830L;
	private String idCitizen;
	private String name;
	private String surname;
	private int age;
	private String dscCity;
	private String dscRegione;

	public CitizenLocationDwr() {}
	
	public CitizenLocationDwr(CitizenLocation citizenLocation) {
		this.idCitizen = citizenLocation.getIdCitizen();
		this.name = citizenLocation.getName();
		this.surname = citizenLocation.getSurname();
		this.age = citizenLocation.getAge();
		this.dscCity = citizenLocation.getDscCity();
		this.dscRegione = citizenLocation.getDscRegione();
	}

	public String getIdCitizen() {
		return idCitizen;
	}

	public void setIdCitizen(String idCitizen) {
		this.idCitizen = idCitizen;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDscCity() {
		return dscCity;
	}

	public void setDscCity(String dscCity) {
		this.dscCity = dscCity;
	}

	public String getDscRegione() {
		return dscRegione;
	}

	public void setDscRegione(String dscRegione) {
		this.dscRegione = dscRegione;
	}

	@Override
	public String toString() {
		return "CitizenLocationDwr [idCitizen=" + idCitizen + ", name=" + name
				+ ", surname=" + surname + ", age=" + age + ", dscCity="
				+ dscCity + ", dscRegione=" + dscRegione + "]";
	}
}
