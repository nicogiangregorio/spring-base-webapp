package it.nicogiangregorio.home.service.impl;

import it.nicogiangregorio.home.model.CitizenLocation;
import it.nicogiangregorio.home.repositories.CitizensRepository;
import it.nicogiangregorio.home.service.CitizensService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitizensServiceImpl implements CitizensService{
	
	@Autowired
	CitizensRepository citizensRepo;
	
	@Override
	public List<CitizenLocation> getCitizenLocations(String idCitizen) {
		return citizensRepo.getCitizenLocations(idCitizen);
	}
}
