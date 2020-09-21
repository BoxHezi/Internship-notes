package com.internship.shakeapp.service;

import com.internship.shakeapp.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User getUserById(Long id);

    User getUserByUsername(String username);

    String login(User user);

    String register(User user);

}
