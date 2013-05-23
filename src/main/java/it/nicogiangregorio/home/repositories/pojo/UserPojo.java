package it.nicogiangregorio.home.repositories.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class UserPojo {
	private final BigDecimal userId;
	private final String userName;
	private final String name;
	private final String lastName;
	private final String email;
	private final Date activationDate;
	private final List<String> roles;
	private String password;
	private boolean active;
	
	public UserPojo(BigDecimal userId, String userName, String name,
			String lastName, String email, Date activationDate,
			List<String> roles, String password, boolean active) {
		this.userId = userId;
		this.userName = userName;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.activationDate = activationDate;
		this.roles = roles;
		this.password = password;
		this.active = active;
	}

	public BigDecimal getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public Date getActivationDate() {
		return activationDate;
	}

	public List<String> getRoles() {
		return roles;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
