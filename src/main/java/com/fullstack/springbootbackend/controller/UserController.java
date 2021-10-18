package com.fullstack.springbootbackend.controller;

import com.fullstack.springbootbackend.entity.User;
import com.fullstack.springbootbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        if (user != null && user.getEmail() != null && user.getName() != null && user.getPassword() != null) {
            userRepository.save(user);
            return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Invalid user payload", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByName(@PathVariable String username) {
        if (username.isEmpty()) {
            return new ResponseEntity("User not found", HttpStatus.BAD_REQUEST);
        }
        username = username.trim();
        return new ResponseEntity<>(userRepository.findByName(username), HttpStatus.OK);
    }
}
