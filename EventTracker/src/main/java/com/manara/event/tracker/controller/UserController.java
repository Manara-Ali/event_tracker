package com.manara.event.tracker.controller;

import com.manara.event.tracker.model.UserModel;
import com.manara.event.tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    // Inject the service class into the controller class
    @Autowired
    private UserService userService;

    // Create a controller to add user into our database
    @PostMapping("/sign-up")
    public UserModel createUser(@RequestBody UserModel userModel) {
        return userService.signup(userModel);
    }

    // Create a controller to be able to retrieve all users from database
    @GetMapping("/")
    public List<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    // Create a method to retrieve a single user
    @GetMapping("/user/{id}")
    public UserModel getUser(@PathVariable int id) {
        return userService.getOne(id);
    }
}
