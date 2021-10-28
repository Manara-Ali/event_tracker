package com.manara.event.tracker.service;

import com.manara.event.tracker.model.UserModel;
import com.manara.event.tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    // Create a method to retrieve a single user based on their id
    public UserModel getOne(int id) {
        return userRepository.findById(id).get();
    }

    // Create a method to update users
    public UserModel updateUser(UserModel userModel, int id) {
        // Get the user we wish to update
        UserModel user = getOne(id);

        // Update each fields
        user.setFirstname(userModel.getFirstname());
        user.setLastname(userModel.getLastname());
        user.setUsername(userModel.getUsername());
        user.setPassword(userModel.getPassword());

        // Return the Response entity
        return userRepository.save(user);
    }

    // Create a method to delete a single user
    public HttpStatus deleteOne(int id) {
        userRepository.deleteById(id);
        return HttpStatus.OK;
    }
}
