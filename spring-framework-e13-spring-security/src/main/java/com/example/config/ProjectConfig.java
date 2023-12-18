package com.example.config;

import jakarta.servlet.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        //let's use an already provided implementation of UserDetailManger, i.e InMemoryUserDetailsManager
        //InMemoryUserDetailsManger implements UserDetailManger interface, Which extends UserDetailService.
        //so let provide spring security with the user using InMemoryUserDetailsManger, off curse the user are kept in memory
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        UserDetails user1 = User.withUsername("Bill")
                .password("12345")
                .roles("ADMIN")
                .authorities("write")
                .build();

        UserDetails user2 = User.withUsername("John")
                .password("12345")
                .roles("MANAGER")
                .authorities("read")
                .build();

        manager.createUser(user1);
        manager.createUser(user2);

        return manager;
    }

}

 /** Basic Contracts in Spring Security:
    * UserDetails - is an interface that defines the user and understood by the spring security.
        - username, password, authorities.

    * UserDetailsService - the contract that used to retrieve the user
      - has one abstract method which loadUserByUserName() -> this is the object that used to
        load a user from somewhere such as database, file or in-memory of the application.

    * UserDetailManager -> adding more functionalities to UserDetailService
            - that manges user - creates , updates and deletes user.
            - this inherits UserDetailService

    * PasswordEncoder - has two behaviour one to encrypt and the second is to match
      - spring security is designed to never expect a password in a plain text.
     - the application will crash if one do not use a password encoder.

  */
