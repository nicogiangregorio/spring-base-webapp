package it.nicogiangregorio.home.repositories.impl;

import it.nicogiangregorio.home.domain.CitizenLocation;
import it.nicogiangregorio.home.repositories.CitizensQueries;
import it.nicogiangregorio.home.repositories.CitizensRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.postgresql.geometric.PGpoint;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Repository
public class JdbcTemplateCitizensRepository implements CitizensRepository, InitializingBean{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(CitizensQueries.GET_CITIZEN_LOCATIONS, "the getCitizenLocations query cannot be null");
	}

	@Override
	@Transactional(readOnly = true)
	public List<CitizenLocation> getCitizenLocations(String idCitizen) {
		return jdbcTemplate.query(CitizensQueries.GET_CITIZEN_LOCATIONS, 
				new RowMapper<CitizenLocation>(){

					@Override
					public CitizenLocation mapRow(ResultSet rs, int rowNum) throws SQLException {
						String idCitizen = rs.getString("id");
						String name = rs.getString("name");
						String surname = rs.getString("surname");
						int age = rs.getInt("age");
						String dscCity = rs.getString("dsc_city");
						String dscRegione = rs.getString("regione");
						PGpoint coordinates = (PGpoint) rs.getObject("COORDINATES");
						return new CitizenLocation(idCitizen, name, surname, age, dscCity, dscRegione, coordinates);
					}
		});
	}
}
