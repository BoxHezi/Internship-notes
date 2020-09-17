package com.internship.shakeapp.service.impl;

import com.internship.shakeapp.dao.UserDAO;
import com.internship.shakeapp.entity.User;
import com.internship.shakeapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }


    @Override
    public void registerUser(UserDAO user) {

    }
}
