package it.nicogiangregorio.home.domain;

import java.io.Serializable;

public class CityDto implements Serializable {
	
	private String idCity;
	private String codCity;
	private String descCity;
	private String regione;
	private String area;
	
	public CityDto(String idCity, String codCity, String descCity,
			String regione, String area) {
		this.idCity = idCity;
		this.codCity = codCity;
		this.descCity = descCity;
		this.regione = regione;
		this.area = area;
	}

	public String getIdCity() {
		return idCity;
	}

	public String getCodCity() {
		return codCity;
	}

	public String getDescCity() {
		return descCity;
	}

	public String getRegione() {
		return regione;
	}

	public String getArea() {
		return area;
	}
}
