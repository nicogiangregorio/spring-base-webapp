package it.nicogiangregorio.home.service;

import it.nicogiangregorio.home.domain.CitizenLocation;

import java.util.List;

public interface CitizensService {
	public List<CitizenLocation> getCitizenLocations(String idCitizen);
}
