package com.internship.shakeapp.dao;

import com.internship.shakeapp.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDAO {

    List<User> getAll(Boolean descOrder);

    User getUserById(Long id);

    User getUserByUsername(String username);

    void register(User user);

}