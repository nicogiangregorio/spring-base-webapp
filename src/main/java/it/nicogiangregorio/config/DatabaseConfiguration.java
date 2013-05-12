package it.nicogiangregorio.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class DatabaseConfiguration {
	@Value("${dataSource.driverClassName}")
    private String driverName;
 
    @Value("${dataSource.url}")
    private String url;
 
    @Value("${dataSource.user}")
    private String user;
 
    @Value("${dataSource.password}")
    private String password;
    
    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource simpleDriverDataSource = new SimpleDriverDataSource();
        simpleDriverDataSource.setPassword(this.password);
        simpleDriverDataSource.setUrl(this.url);
        simpleDriverDataSource.setUsername(this.user);
        simpleDriverDataSource.setDriverClass(org.postgresql.Driver.class);
        return simpleDriverDataSource;
    }

}
