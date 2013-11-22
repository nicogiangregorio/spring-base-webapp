package it.nicogiangregorio.home.model;


public enum UserRole {
	//TODO to be initialized from database
	BASIC(2), ADMIN(1);
	
	private final int roleValue;
	
	UserRole(int value) {
		roleValue = value;
	}
	
	public int getValue() {
		return roleValue;
	}
}
