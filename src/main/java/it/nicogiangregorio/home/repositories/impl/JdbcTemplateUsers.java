package it.nicogiangregorio.home.repositories.impl;

import it.nicogiangregorio.home.repositories.UserQueries;
import it.nicogiangregorio.home.repositories.UserRepository;
import it.nicogiangregorio.home.repositories.pojo.UserPojo;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Repository
public class JdbcTemplateUsers implements InitializingBean, UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	@Transactional(readOnly = true)
	public UserPojo getUserByEmail(String email) {
		UserPojo user = (UserPojo) jdbcTemplate.queryForObject(UserQueries.SQL_LOGIN, new RowMapper<UserPojo>(){

			@Override
			public UserPojo mapRow(ResultSet rs, int rowNum) throws SQLException {
				BigDecimal userId = rs.getBigDecimal("id_user");
				String userName = rs.getString("user_name");
				String name = rs.getString("name");
				String lastName = rs.getString("last_name");
				String email = rs.getString("email");
				String password= rs.getString("password");
				String[] roles = (String[]) rs.getArray("roles").getArray();
				
				return new UserPojo(userId, userName, name, lastName, email, null, Arrays.asList(roles), password, true);
			}
			
		}, email);
		
		return user;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(UserQueries.SQL_LOGIN, "the login query cannot be null");
	}

}
