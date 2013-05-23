package it.nicogiangregorio.home.repositories;

import it.nicogiangregorio.home.repositories.pojo.UserPojo;

public interface UserRepository {
	
	public UserPojo getUserByEmail(String email);
	
}
