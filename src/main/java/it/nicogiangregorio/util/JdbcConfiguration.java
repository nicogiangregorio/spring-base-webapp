package it.nicogiangregorio.util;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class JdbcConfiguration extends DatabaseConfiguration {
	@Bean
	public JdbcTemplate jdbcTemplate() {
		DataSource ds = dataSource(); // this comes from the parent class
		return new JdbcTemplate(ds);
	}
}
