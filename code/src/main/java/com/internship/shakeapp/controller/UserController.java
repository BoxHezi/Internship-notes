package com.internship.shakeapp.controller;

import com.internship.shakeapp.entity.User;
import com.internship.shakeapp.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUser() {
        return userService.getAll();
    }

    @GetMapping(params = "id")
    public User getUserById(@RequestParam(name = "id") Long id) {
        return userService.getUserById(id);
    }

    @PostMapping(value = "login")
    public String login(@RequestBody User user) {
        return userService.login(user);
    }

    @PostMapping(value = "register")
    public String register(@RequestBody User user) {
        return userService.register(user);
    }

}
