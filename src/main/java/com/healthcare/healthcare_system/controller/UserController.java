package com.healthcare.healthcare_system.controller;
import com.healthcare.healthcare_system.repository.UserRepository;
import com.healthcare.healthcare_system.service.UserService;
import com.healthcare.healthcare_system.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Register User
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {

        return userService.registerUser(user);
    }

    // Get all users
    @GetMapping
    public List<User> getAllUsers(){

        return userService.getAllUsers();
    }

    // Delete user
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);
        return "User deleted successfully";
    }
}
