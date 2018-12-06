package io.pivotal.pal.tracker;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
public class PalTrackerApplication {

	private String driverClassName = "com.mysql.jdbc.Driver";
	private String url=System.getenv("SPRING_DATASOURCE_URL");
	private String dbUsername = "tracker";
	private String dbPassword = "";

	public static void main(String[] args) {
		SpringApplication.run(PalTrackerApplication.class, args);
	}

	@Bean
	JdbcTimeEntryRepository jdbcTimeEntryRepository() {
		return new JdbcTimeEntryRepository(getDataSource());
	}

	@Bean
	public ObjectMapper jsonObjectMapper() {
		return Jackson2ObjectMapperBuilder.json().serializationInclusion(JsonInclude.Include.NON_NULL) // Don’t include
																										// null values
				.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS) // ISODate
				.modules(new JavaTimeModule()).build();
	}

	private DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(dbUsername);
		dataSource.setPassword(dbPassword);
		return dataSource;
	}
}