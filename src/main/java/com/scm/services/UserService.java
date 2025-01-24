package com.scm.services;

import java.util.List;
import java.util.Optional;

import com.scm.entities.User;

public interface UserService {

    Optional<User> saveUser(User user);
    Optional<User> getUserById(String userId);
    Optional<User> updateUser(User user);
    void deleteUser(String userId);
    boolean isUserExists(String userId);
    boolean isUserExistsByEmail(String email);
    Optional<List<User>> getAllUsers();
}
