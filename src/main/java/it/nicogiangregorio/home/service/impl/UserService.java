package it.nicogiangregorio.home.service.impl;

import it.nicogiangregorio.home.domain.UserBean;

public interface UserService {
	
	public UserBean login(String email, String password);
}
