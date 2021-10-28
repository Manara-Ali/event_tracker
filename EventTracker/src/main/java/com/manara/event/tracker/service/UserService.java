package com.manara.event.tracker.service;

import com.manara.event.tracker.model.UserModel;
import com.manara.event.tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    // Connect the service class to the repository
    @Autowired
    private UserRepository userRepository;

    // Create a method to add new users
    public UserModel signup(UserModel userModel) {
        return userRepository.save(userModel);
    }

    // Create a method to Retrieve all users from our database
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }
}
