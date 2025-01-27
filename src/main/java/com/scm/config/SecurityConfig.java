package com.scm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.scm.services.impl.SecurityCustomUserDetailsService;

@Configuration
public class SecurityConfig { 

    @Autowired
    private SecurityCustomUserDetailsService securityCustomUserDetailsService;

    // create user and login using java code with in-memory service

    // @Bean
    // public UserDetailsService userDetailsService() {

    //     UserDetails user1 = User
    //     .withDefaultPasswordEncoder()
    //             .username("Munwar")
    //             .password("Munwar123")
    //             .roles("ADMIN","USER")
    //             .build();

    //     UserDetails user2 = User
    //     .withDefaultPasswordEncoder()
    //             .username("user")
    //             .password("user123")
    //             //.roles("ADMIN","USER")
    //             .build();


    //     var inMemoryUserDetailsManager = new InMemoryUserDetailsManager(user1,user2);
    //     return inMemoryUserDetailsManager;

    // }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(securityCustomUserDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());    
        
        return daoAuthenticationProvider; 
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
 
}
