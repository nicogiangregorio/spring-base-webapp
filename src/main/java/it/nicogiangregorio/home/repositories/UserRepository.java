package it.nicogiangregorio.home.repositories;

import it.nicogiangregorio.home.repositories.pojo.UserPojo;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UserRepository {
	
	/**
	 * Retrieve user row from database, in order to login
	 * 
	 * @param email : user email
	 * @return
	 */
	public UserPojo getUserByEmail(String email);

	/**
	 * Get list of all users
	 * 
	 * @return : list of users
	 * @throws SQLException 
	 */
	public List<UserPojo> getAllUsers() throws SQLException;
	
	/**
	 * Find user in database from username or user's email
	 * 
	 * @param userId : user identifier
	 * @return : user pojo
	 */
	public UserPojo findUser(String userId);

	/**
	 * Add a new user
	 * 
	 * @param user : user pojo
	 */
	public void addUser(UserPojo user);
	
	/**
	 * Check if chosen username is already assigned
	 * 
	 * @param userId : user name
	 * @return
	 */
	public List<String> checkUserName(String userId);

	/**
	 * Retrieves a map of ID_ROLE - ROLE_DESCRIPTION from DB
	 * 
	 * @return
	 */
	public Map<BigDecimal, String> getRoles();
	
}
