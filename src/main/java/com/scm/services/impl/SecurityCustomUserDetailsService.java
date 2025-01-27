package com.scm.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.scm.entities.User;
import com.scm.repositories.UserRepo;

@Service
public class SecurityCustomUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRepo userRepo;
     Optional<User> byEmail;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return  userRepo.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("User not found with email : "+username));
       
    }

}
