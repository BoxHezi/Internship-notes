package com.internship.shakeapp.service;

import com.internship.shakeapp.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User getUserById(Long id);

    User getUserByUsername(String username);

    boolean login(User user);

    boolean register(User user);

}
