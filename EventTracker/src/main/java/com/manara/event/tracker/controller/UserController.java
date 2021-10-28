package com.manara.event.tracker.controller;

import com.manara.event.tracker.model.UserModel;
import com.manara.event.tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
