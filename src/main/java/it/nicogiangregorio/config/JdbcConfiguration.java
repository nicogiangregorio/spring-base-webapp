package it.nicogiangregorio.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

@Configuration
public class JdbcConfiguration extends DatabaseConfiguration {
	@Bean
	public JdbcTemplate jdbcTemplate() {
		DataSource ds = dataSource(); // this comes from the parent class
		return new JdbcTemplate(ds);
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
	    DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
	    dataSourceTransactionManager.setDataSource(this.dataSource());
	    return dataSourceTransactionManager;
	}
	 
	@Bean
	public TransactionTemplate transactionTemplate() {
	    TransactionTemplate tt = new TransactionTemplate();
	    tt.setTransactionManager( this.transactionManager() );
	    return tt;
	}

}
