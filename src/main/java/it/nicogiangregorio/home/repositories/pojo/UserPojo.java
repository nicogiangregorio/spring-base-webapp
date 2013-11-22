package it.nicogiangregorio.home.repositories.pojo;

import it.nicogiangregorio.home.model.UserRole;

import java.util.Date;
import java.util.List;

public class UserPojo {
	private final String userName;
	private final String name;
	private final String lastName;
	private final String email;
	private final Date activationDate;
	private final List<UserRole> roles;
	private String password;
	private boolean active;
	
	public UserPojo(String userName, String name,
			String lastName, String email, Date activationDate,
			List<UserRole> roles, String password, boolean active) {
		this.userName = userName;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.activationDate = activationDate;
		this.roles = roles;
		this.password = password;
		this.active = active;
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

	public List<UserRole> getRoles() {
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

	@Override
	public String toString() {
		return "UserPojo [userName=" + userName + ", name=" + name
				+ ", lastName=" + lastName + ", email=" + email
				+ ", activationDate=" + activationDate + ", roles=" + roles
				+ ", password=" + password + ", active=" + active + "]";
	}
}
