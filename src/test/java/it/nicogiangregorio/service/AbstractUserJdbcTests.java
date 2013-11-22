package it.nicogiangregorio.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import it.nicogiangregorio.home.model.UserRole;
import it.nicogiangregorio.home.repositories.UserRepository;
import it.nicogiangregorio.home.repositories.pojo.UserPojo;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for Service Layer
 * 
 * @author Nico Giangregorio
 *
 */

@ContextConfiguration(locations = {"/root-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class AbstractUserJdbcTests {
	@Autowired
	UserRepository userRepository;
	
	@Test
	@Transactional
	public void getAllUsers(){
		List<UserPojo> users = null;
		
		try {
			 users = this.userRepository.getAllUsers();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertNotNull(users);
		assertTrue(users.size() > 0);
		// Pass if at least 2 users are registered
		assertTrue(users.size() > 1);
	}
	
	@Test
	@Transactional
	public void addUser(){
		List<UserRole> roles = new ArrayList<UserRole>();
		roles.add(UserRole.BASIC);
		
		UserPojo user = new UserPojo("test", "test", "test", "test@test.com", null, roles, "123", true);
		this.userRepository.addUser(user);
	}
	
	@Test
	@Transactional
	public void findUser(){
		UserPojo user  = this.userRepository.findUser("admin");
		
		assertNotNull(user);
		assertEquals(user.getUserName(), "admin");

		user  = this.userRepository.findUser("guest@guest.com");
		assertNotNull(user);
		assertEquals(user.getEmail(), "guest@guest.com");
	}
	
	@Test
	@Transactional
	public void checkUserName(){

		List<String> userName  = this.userRepository.checkUserName("test2");
		assertNotNull(userName);
		assertTrue(userName.size() == 0);
		
		userName  = this.userRepository.checkUserName("guest");
		assertNotNull(userName);
		assertTrue(userName.size() > 0);
	}
	
	@Test
	@Transactional
	public void getRoles(){

		Map<String, BigDecimal> roles  = this.userRepository.getRoles();
		assertNotNull(roles);
		assertTrue(roles.size() > 0);
		assertEquals(roles.get("admin"), new BigDecimal(1));
		assertEquals(roles.get("basic"), new BigDecimal(2));
	}
	
	@Test
	@Transactional
	public void deleteUser(){
		UserPojo user  = this.userRepository.findUser("admin");
		
		assertNotNull(user);
		assertEquals(user.getUserName(), "admin");
		this.userRepository.deleteUser(user);
		// TODO verify deletion
		// Spring jdbc does not commit modification by default
//		user  = this.userRepository.findUser("admin");
//		assertNull(user);
	}
}
