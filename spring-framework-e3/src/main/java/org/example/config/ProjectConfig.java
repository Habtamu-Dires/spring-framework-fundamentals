package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"org.example.repositories"})
public class ProjectConfig {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost/sf_demo");
        dataSource.setUsername("root");
        dataSource.setPassword("password");

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}

/**
 * DataSource - is an interface provided by java's JDBC API.
 *      - it represent a connection to a database.
 *DriverManagerDataSource - is simple implementation of the DataSource
 *   - is provided by spring  (spring-jdbc module)
 *   - the information provided to this bean used by datasource to establish connection with the database
 *JdbcTemplate - is a class provided by spring (spring-jdbc module) that simplifies JDBC operations.
 *  -it provide various methods for executing SQL queries, updates and other operations
 *   without a need to manually open and close database connections, handle exceptions and
 *   manage transactions.
 */
