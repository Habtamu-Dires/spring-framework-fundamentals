package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringFrameworkE8SpringBoot101Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringFrameworkE8SpringBoot101Application.class, args);
	}
}

/**
 * Dependencies -> add specific .jar file in our class path.
 * based on the dependencies in the application class path based on these dependencies
 * -> the Auto-configuration will provides default configuration.
 *
 * @SpringBootApplicaiotn -> provide
   - @ComponentScan - for only the main package (here -> com.example)
   - @EnableAutoConfiguration - enable auto-configuration that provides some default configuration
     that you can customize if needed.
 */
