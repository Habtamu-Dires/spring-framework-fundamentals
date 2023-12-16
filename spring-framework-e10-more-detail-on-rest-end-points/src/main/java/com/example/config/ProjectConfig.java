package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
//import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class ProjectConfig {

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){ // inject the default datasource
        return new JdbcTemplate(dataSource);
    }
}

/**
 * while using vanilla we used to create our datasource and inject it into jdbcTemplate.
 * but here in spring boot will create default datasource using Hikari implementation.
 * because creating datasource is a boiler-plate code.
 */
