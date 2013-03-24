package it.nicogiangregorio.home.domain;

public class CitizenLocation {
	private String idCitizen;
	private String name;
	private String surname;
	private int age;
	private String dscCity;
	private String dscRegione;
	
	
	public CitizenLocation(String idCitizen, String name, String surname,
			int age, String dscCity, String dscRegione) {
		super();
		this.idCitizen = idCitizen;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.dscCity = dscCity;
		this.dscRegione = dscRegione;
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
	@Override
	public String toString() {
		return "CitizenLocation [idCitizen=" + idCitizen + ", name=" + name
				+ ", surname=" + surname + ", age=" + age + ", dscCity="
				+ dscCity + ", dscRegione=" + dscRegione + "]";
	}
}
