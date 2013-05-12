package it.nicogiangregorio.home.dwr;

import it.nicogiangregorio.home.domain.CitizenLocation;
import it.nicogiangregorio.home.service.CitizensService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class CitizenDwrService {
	
	@Autowired
	CitizensService citizenService;
	public CitizenLocationDwr[] getCitizenLocations(){
		
		List<CitizenLocation> locations = citizenService.getCitizenLocations("1");
		List<CitizenLocationDwr> locationsDwrList = new ArrayList<>();
		
		for (CitizenLocation citizenLocation : locations) {
			CitizenLocationDwr locationDwr = new CitizenLocationDwr(citizenLocation);
			locationsDwrList.add(locationDwr);
		}
		
		return locationsDwrList.toArray(new CitizenLocationDwr[locationsDwrList.size()]);
	}
}
