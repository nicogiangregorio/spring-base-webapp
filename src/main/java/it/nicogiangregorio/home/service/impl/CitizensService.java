package it.nicogiangregorio.home.service.impl;

import it.nicogiangregorio.home.domain.CitizenLocation;

import java.util.List;

public interface CitizensService {
	public List<CitizenLocation> getCitizenLocations(String idCitizen);
}
