package it.nicogiangregorio.home.service;

import it.nicogiangregorio.home.model.CitizenLocation;

import java.util.List;

public interface CitizensService {
	public List<CitizenLocation> getCitizenLocations(String idCitizen);
}
