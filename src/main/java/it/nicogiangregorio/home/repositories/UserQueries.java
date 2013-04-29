package it.nicogiangregorio.home.repositories;

public class UserQueries {
	public static final String SQL_LOGIN = "select usr.id_user, usr.user_name, usr.name, usr.last_name, usr.email, usr.password, array_agg(role.role_desc) roles from users_tmp usr join usr_role_rel rel on usr.id_user = rel.id_user	join user_roles_tmp role on role.id_role = rel.id_role where usr.user_name=? and usr.deletion_date is null group by usr.id_user";
}
