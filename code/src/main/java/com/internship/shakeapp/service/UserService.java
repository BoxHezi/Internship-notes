package com.internship.shakeapp.service;

import com.internship.shakeapp.dao.UserDAO;
import com.internship.shakeapp.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserService {

    @Select("SELECT * FROM user")
    List<User> getAll();

    User getUserById(Long id);

    void registerUser(UserDAO user);

}
