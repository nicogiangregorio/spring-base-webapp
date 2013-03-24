package it.nicogiangregorio.home.repositories;

import it.nicogiangregorio.home.domain.CitizenLocation;

import java.util.List;



public interface CitizensRepository {
	public List<CitizenLocation> getCitizenLocations(String idCitizen);
}
