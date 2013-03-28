package it.nicogiangregorio.home.domain;

import org.postgresql.geometric.PGpoint;

public class CitizenLocation {
	private String idCitizen;
	private String name;
	private String surname;
	private int age;
	private String dscCity;
	private String dscRegione;
	private PGpoint coordinates;
	
	
	public CitizenLocation(String idCitizen, String name, String surname,
			int age, String dscCity, String dscRegione, PGpoint coordinates) {
		this.idCitizen = idCitizen;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.dscCity = dscCity;
		this.dscRegione = dscRegione;
		this.coordinates = coordinates;
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
	public int getAge() {
		return age;
	}
	public String getDscCity() {
		return dscCity;
	}
	public String getDscRegione() {
		return dscRegione;
	}
	
	public PGpoint getCoordinates() {
		return coordinates;
	}
	@Override
	public String toString() {
		return "CitizenLocation [idCitizen=" + idCitizen + ", name=" + name
				+ ", surname=" + surname + ", age=" + age + ", dscCity="
				+ dscCity + ", dscRegione=" + dscRegione + "]";
	}
}
