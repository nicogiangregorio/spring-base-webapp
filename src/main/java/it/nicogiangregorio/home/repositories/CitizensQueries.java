package it.nicogiangregorio.home.repositories;

public class CitizensQueries {
	public static final String GET_CITIZEN_LOCATIONS = "select * from citizens cz join cities ct on cz.city = ct.id_cod";
}
