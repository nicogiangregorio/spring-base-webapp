package it.nicogiangregorio.home.repositories;

public class UserQueries {
	
	public static final String SQL_LOGIN = "select usr.user_name, usr.name, usr.last_name, usr.email, usr.password, array_agg(role.role_desc) roles from users usr join usr_role_rel rel on usr.user_name = rel.user_name	join user_roles role on role.id_role = rel.id_role where usr.user_name=? and usr.deletion_date is null group by usr.user_name, usr.name, usr.last_name, usr.email, usr.password";
	public static final String SQL_GET_ALL_USERS = "select usr.user_name, usr.name, usr.last_name, usr.email, usr.password, array_agg(role.role_desc) roles from users usr join usr_role_rel rel on usr.user_name = rel.user_name	join user_roles role on role.id_role = rel.id_role where usr.deletion_date is null group by usr.user_name, usr.name, usr.last_name, usr.email, usr.password";
	public static final String SQL_GET_ALL_ROLES = "select id_role, role_desc from user_roles";
	public static final String SQL_DELETE_USER = "update users set deletion_date = LOCALTIMESTAMP where user_name = ?";
	public static final String SQL_CHECK_USER_NAME = "select user_name from users where user_name = ?";
	public static final String SQL_INSERT_NEW_USER = "INSERT INTO users(user_name, name, last_name, email, activation_date, password)    VALUES (?, ?, ?, ?, LOCALTIMESTAMP, ?)";
	public static final String SQL_INSERT_NEW_USER_ROLE_RELATIONSHIP = "INSERT INTO usr_role_rel(id_role, user_name) VALUES (?, ?)";
	public static final String SQL_FIND_USER = "select usr.user_name, usr.name, usr.last_name, usr.email, usr.password, array_agg(role.role_desc) roles from users usr join usr_role_rel rel on usr.user_name = rel.user_name	join user_roles role on role.id_role = rel.id_role where usr.user_name= ?	or usr.email= ?	and usr.deletion_date is null group by usr.user_name, usr.name, usr.last_name, usr.email, usr.password";
}
