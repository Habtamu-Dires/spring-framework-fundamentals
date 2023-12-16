package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringFrameworkE10MoreDetailOnRestEndPointsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFrameworkE10MoreDetailOnRestEndPointsApplication.class, args);
	}
}

/** why the app will fail if we don't give it what it want? e.g datasource url?
 * e.g : if you add a dependency to spring-jdbc  -> spring boot expect to create it needs to create a datasource for that,
  and it created one datasource bean and want some configuration data for that datasource like url of database...
 Two things to solve this problem:
 1. create our own datasource bean in a configuration class so that it added to the context.
   that way spring will use our own datasource instead of the automatic created one.
 2. Give the needed information to the spring boot created datasource via application config file.

 * Spring Boot checks what the application have in the class paths (created by the dependencies) and
  depending on what is in the class path, it expects to do some default configuration, that we can customize it.
 */