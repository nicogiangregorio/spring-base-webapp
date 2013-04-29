package it.nicogiangregorio.home.repositories;

import it.nicogiangregorio.home.domain.UserBean;

public interface UserRepository {
	
	public UserBean getUserByEmail(String email);
	
}
