package it.nicogiangregorio.home.repositories.impl;

import it.nicogiangregorio.home.model.UserRole;
import it.nicogiangregorio.home.repositories.UserQueries;
import it.nicogiangregorio.home.repositories.UserRepository;
import it.nicogiangregorio.home.repositories.pojo.UserPojo;

import java.math.BigDecimal;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Repository
public class JdbcUsersRepositoryImpl implements InitializingBean, UserRepository {
	Logger logger = LoggerFactory.getLogger(JdbcUsersRepositoryImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	@Transactional(readOnly = true)
	public UserPojo login(String userId) {
		UserPojo user = null;
		
		try {
			user = (UserPojo) jdbcTemplate.queryForObject(UserQueries.SQL_LOGIN, new RowMapper<UserPojo>(){
				
				@Override
				public UserPojo mapRow(ResultSet rs, int rowNum) throws SQLException {
					String userName = rs.getString("user_name");
					String name = rs.getString("name");
					String lastName = rs.getString("last_name");
					String email = rs.getString("email");
					String password= rs.getString("password");
					String[] rolesArray = (String[]) rs.getArray("roles").getArray();
					UserRole roles [] = new UserRole[rolesArray.length];
					
					for (int ii = 0; ii < rolesArray.length; ii++) {
						roles[ii] = UserRole.valueOf(rolesArray[ii].toUpperCase());
					}
					
					return new UserPojo(userName, name, lastName, email, null, Arrays.asList(roles), password, true);
				}
				
			}, userId);
			
		} catch (DataAccessException e) {
			logger.error(e.getMessage());
			logger.error("No user found: " + userId);
		}
		
		return user;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<UserPojo> getAllUsers() throws SQLException {
		
		List<Map<String, Object>> userRows = jdbcTemplate.queryForList(UserQueries.SQL_GET_ALL_USERS);
		List<UserPojo> users = new ArrayList<>();
		
		for(Map<String, Object> user : userRows){
			String userName = (String) user.get("user_name");
			String name = (String) user.get("name");
			String lastName = (String) user.get("last_name");
			String email = (String) user.get("email");
			Date activationDate= (Date) user.get("activation_date");
			
			String[] rolesArray = (String[]) ((Array) user.get("roles")).getArray();
			UserRole roles [] = new UserRole[rolesArray.length];
			
			for (int ii = 0; ii < rolesArray.length; ii++) {
				roles[ii] = UserRole.valueOf(rolesArray[ii].toUpperCase());
			}			
			
			users.add(new UserPojo(userName, name, lastName, email, activationDate, Arrays.asList(roles), null, true));
		}
			
		return users;
	}
	
	@Override
	@Transactional(readOnly = true)
	public UserPojo findUser(String userId) {
		UserPojo user = null; 
		try{
			user = (UserPojo) jdbcTemplate.queryForObject(UserQueries.SQL_FIND_USER, new RowMapper<UserPojo>(){

				@Override
				public UserPojo mapRow(ResultSet rs, int rowNum) throws SQLException {
					String userName = rs.getString("user_name");
					String name = rs.getString("name");
					String lastName = rs.getString("last_name");
					String email = rs.getString("email");
					String[] rolesArray = (String[]) rs.getArray("roles").getArray();
					UserRole roles [] = new UserRole[rolesArray.length];
					
					for (int ii = 0; ii < rolesArray.length; ii++) {
						roles[ii] = UserRole.valueOf(rolesArray[ii].toUpperCase());
					}
					
					return new UserPojo(userName, name, lastName, email, null, Arrays.asList(roles), null, true);
				}
				
			}, userId, userId);
			
		} catch (DataAccessException e) {
			logger.error(e.getMessage());
			logger.error("No user found: " + userId);
		}
		
		return user;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<String> checkUserName(String userId) {
		List<String> userName = (List<String>) jdbcTemplate.query(UserQueries.SQL_CHECK_USER_NAME, new RowMapper<String>(){

			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString("user_name");
				
			}
			
		}, userId);
		
		return userName;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Map<String, BigDecimal> getRoles() {
		List<Map<String, Object>> roleRows = jdbcTemplate.queryForList(UserQueries.SQL_GET_ALL_ROLES);
		
		Map<String, BigDecimal> roles = new HashMap<>();
		
		for(Map<String, Object> role : roleRows){
			BigDecimal idRole = (BigDecimal) role.get("id_role");
			String roleDescription = (String) role.get("role_desc");
			roles.put( roleDescription, idRole);
		}
			
		return roles;
	}
	
	@Override
	@Transactional
	public void addUser(UserPojo user) {
		
		jdbcTemplate.update(UserQueries.SQL_INSERT_NEW_USER, new Object[]{
				user.getUserName(), user.getName(), user.getLastName(), user.getEmail(), user.getPassword()
		});
		
		for (UserRole role : user.getRoles()) {
			jdbcTemplate.update(UserQueries.SQL_INSERT_NEW_USER_ROLE_RELATIONSHIP, role.getValue(), user.getUserName());
		}
	}
	
	@Override
	@Transactional
	public void deleteUser(UserPojo user) {
		
		jdbcTemplate.update(UserQueries.SQL_DELETE_USER, new Object[]{user.getUserName()});
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(UserQueries.SQL_LOGIN, "the login query cannot be null");
		Assert.notNull(UserQueries.SQL_GET_ALL_USERS, "the GET_ALL_USERS query cannot be null");
		Assert.notNull(UserQueries.SQL_FIND_USER, "the FIND_USER query cannot be null");
		Assert.notNull(UserQueries.SQL_INSERT_NEW_USER, "the INSERT_NEW_USER query cannot be null");
		Assert.notNull(UserQueries.SQL_CHECK_USER_NAME, "the CHECK_USER query cannot be null");
		Assert.notNull(UserQueries.SQL_GET_ALL_ROLES, "the GET_ALL_ROLES query cannot be null");
		Assert.notNull(UserQueries.SQL_INSERT_NEW_USER_ROLE_RELATIONSHIP, "the INSERT_NEW_USER_ROLE_REL query cannot be null");
		Assert.notNull(UserQueries.SQL_DELETE_USER, "the DELETE_USER query cannot be null");
	}
}
