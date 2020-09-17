package com.internship.shakeapp.controller;

import com.internship.shakeapp.entity.User;
import com.internship.shakeapp.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public List<User> getAllUser() {
        return userService.getAll();
    }

    @GetMapping(params = "id")
    public User getUserById(@RequestParam(name = "id") Long id) {
        return userService.getUserById(id);
    }

    @PostMapping(value = "register")
    @ResponseBody
    public String registerUser(@RequestBody User user) {
        System.out.println(user);
//        String requestBody = request.getParameter("json");
//        System.out.println(requestBody);
        return "register user";
    }

}
