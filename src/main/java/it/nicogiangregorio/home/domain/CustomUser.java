package it.nicogiangregorio.home.domain;

import it.nicogiangregorio.home.repositories.pojo.UserPojo;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {

	private static final long serialVersionUID = 4956149462187910928L;
	private Date activationDate;
	private String email;
	private String name;
	private String lastName;
	private BigDecimal userId;

	public CustomUser(UserPojo userBean, Collection<GrantedAuthority> authorities) {
		super(userBean.getUserName(), 
				userBean.getPassword(), 
				userBean.isActive(), 
				userBean.isActive(), 
				userBean.isActive(),
				userBean.isActive(),
				authorities);
		
		this.activationDate =  userBean.getActivationDate();
		this.email = userBean.getEmail();
		this.name = userBean.getName();
		this.lastName = userBean.getLastName();
		this.userId = userBean.getUserId();
	}

	public Date getActivationDate() {
		return activationDate;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public BigDecimal getUserId() {
		return userId;
	}

	@Override
	public String toString() {
		return "CustomUser [activationDate=" + activationDate + ", email="
				+ email + ", name=" + name + ", lastName=" + lastName
				+ ", userId=" + userId + "]";
	}
}
