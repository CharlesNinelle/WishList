package com.example.wishlist.controller;

import com.example.wishlist.model.User;
import com.example.wishlist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        logger.info("Received request to register user with email: {}", user.getEmail());
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User user) {
        logger.info("Received request to login user with email: {}", user.getEmail());
        return userService.loginUser(user.getEmail());
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        logger.info("Received request to get user with ID: {}", id);
        return userService.getUserById(id);
    }

    @PutMapping("/{id}/address")
    public void updateAddress(@PathVariable Long id, @RequestBody String address) {
        logger.info("Received request to update address for user with ID: {}", id);
        userService.updateAddress(id, address);
    }
}
