package com.dtechnoshop.dtechnoshopbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

@Configuration
@ComponentScan(basePackages="{com.dtechnoshop.dtechnoshopbackend}")
public class HibernateConfig {
	
	// Database properties
	private static final String DATABASE_URL = "jdbc:mysql://localhost/dtechnoshop";
	private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DATABASE_DIALECT = "org.hibernate.dialect.MySQL5Dialect";
	private static final String DATABASE_USER = "root";
	private static final String DATABASE_PASS = "081321118618";
	
	
	// Datasource bean
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(DATABASE_URL);
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUsername(DATABASE_USER);
		dataSource.setPassword(DATABASE_PASS);
		
		return dataSource;
	}
	
	
	// Hibernate Properties
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		
		return properties;
	}
	
	
	// Create SessionFactory bean
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.dtechnoshop.dtechnoshopbackend.dto");
		
		return builder.buildSessionFactory();
	}
}
