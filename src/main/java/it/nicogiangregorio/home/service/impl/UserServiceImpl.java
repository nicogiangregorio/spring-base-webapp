package it.nicogiangregorio.home.service.impl;

import it.nicogiangregorio.home.repositories.UserRepository;
import it.nicogiangregorio.home.repositories.pojo.UserPojo;
import it.nicogiangregorio.home.service.UserService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository repo;
	
	@Override
	public List<UserPojo> getAllUsers() throws SQLException {
		return repo.getAllUsers();
	}

	@Override
	public UserPojo findUser(String userId) {
		return repo.findUser(userId);
	}

	@Override
	public void addUser(UserPojo user) {
		repo.addUser(user);
	}

	@Override
	public List<String> checkUserName(String userId) {
		return repo.checkUserName(userId);
	}

	@Override
	public Map<String, BigDecimal> getRoles() {
		return repo.getRoles();
	}

	@Override
	public void deleteUser(UserPojo user) {
		repo.deleteUser(user);
	}
}
