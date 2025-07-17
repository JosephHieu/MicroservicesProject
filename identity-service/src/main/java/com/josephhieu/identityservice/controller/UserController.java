package com.josephhieu.identityservice.controller;

import com.josephhieu.identityservice.dto.request.UserCreationRequest;
import com.josephhieu.identityservice.dto.request.UserUpdateRequest;
import com.josephhieu.identityservice.entity.User;
import com.josephhieu.identityservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    private User createUser(@RequestBody @Valid UserCreationRequest request) {
        return userService.createUser(request);
    }

    @GetMapping
    private List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    private User getUser(@PathVariable("userId") String userId) {
        return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    private User updateUser(@PathVariable String userId,
                            @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    private String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "User has been deleted";
    }
}
