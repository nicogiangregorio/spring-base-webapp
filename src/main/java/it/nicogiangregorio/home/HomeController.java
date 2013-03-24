package it.nicogiangregorio.home;

import it.nicogiangregorio.home.domain.CitizenLocation;
import it.nicogiangregorio.home.service.impl.CitizensService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@Autowired
	CitizensService citizenService;
	
	@RequestMapping(value = "/")
    public String home() {
		
		List<CitizenLocation> locations = citizenService.getCitizenLocations("1");
		
        System.out.println("HomeController: Passing through...");
        System.out.println("number of locations: " + locations.size());
        return "WEB-INF/views/home.jsp";
    }
	
	@RequestMapping("/simple")
	public @ResponseBody String simple() {
		List<CitizenLocation> locations = citizenService.getCitizenLocations("1");
		
        System.out.println("HomeController: Passing through...");
        System.out.println("number of locations: " + locations.size());
		return "Hello world!";
	}
}
