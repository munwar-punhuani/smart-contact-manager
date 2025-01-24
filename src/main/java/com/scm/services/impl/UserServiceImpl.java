package com.scm.services.impl;

import java.rmi.server.UID;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.entities.User;
import com.scm.helpers.ResourceNotFoundException;
import com.scm.repositories.UserRepo;
import com.scm.services.UserService;

@Service
public class UserServiceImpl implements UserService{
 
    @Autowired
    private UserRepo userRepo;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private User orElse;
 
    @Override
    public Optional<User> saveUser(User user) {
        // user id: have to generate
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        // password encode
       return Optional.ofNullable( userRepo.save(user));
    }

    @Override
    public Optional<User> getUserById(String userId) {
       return userRepo.findById(userId);
    }

    @Override
    public Optional<User> updateUser(User user) {
        User user1 = userRepo.findById(user.getUserId()).orElseThrow(()-> new ResourceNotFoundException("User Not Found"));
        // update user1 from user
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setAbout(user.getAbout());
        user1.setPhoneNumber(user.getPhoneNumber());
        user1.setProfilePic(user.getProfilePic());
        user1.setEnabled(user.isEnabled());
        user1.setEmailVerified(user.isEmailVerified());
        user1.setPhoneVerified(user.isPhoneVerified());
        user1.setProvider(user.getProvider());
        user1.setProviderUserId(user.getProviderUserId());

        return Optional.ofNullable(userRepo.save(user1));
    }

    @Override
    public boolean isUserExists(String userId) {
        User user = userRepo.findById(userId).orElse(null);
        return user !=null ?true : false;
    }

    @Override
    public boolean isUserExistsByEmail(String email) {
       User user = userRepo.findByEmail(email).orElse(null);
        return user != null ? true : false;
    }

    @Override
    public Optional<List<User>> getAllUsers() {
        return Optional.ofNullable(userRepo.findAll());
    }

    @Override
    public void deleteUser(String userId) {
        User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User Not Found"));
        userRepo.delete(user);
    }

}
