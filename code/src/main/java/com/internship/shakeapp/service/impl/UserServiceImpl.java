package com.internship.shakeapp.service.impl;

import com.internship.shakeapp.dao.UserDAO;
import com.internship.shakeapp.entity.User;
import com.internship.shakeapp.service.UserService;
import com.internship.shakeapp.utils.HashUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl  implements UserService {

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAll() {
        return userDAO.getAll(false);
    }

    @Override
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }

    /**
     * 用户登录服务
     * @param user 用户登录信息,来自于post request
     * @return 当用户登录成功,返 回true, 否则false
     */
    @Override
    public boolean login(User user) {
        User tempUser = userDAO.getUserByUsername(user.getUsername());
        if (tempUser == null) {
            return false;
        }

        String testPass = tempUser.getSalt() + user.getPassword();
        String testPassHash = HashUtils.hashPassword(testPass);

        return tempUser.getPassword().equals(testPassHash);
    }

    /**
     * 用户注册服务
     * @param user 用户注册信息,来自于post request
     * @return 当用户注册成功, 返回true, 否则false
     */
    @Override
    public boolean register(User user) {
        user.setId(generateId()); // 生成并设置数据库中的ID

        // 生成随机salt
        String salt = HashUtils.generateSalt();
        user.setSalt(salt);

        // 计算salt + password hash值
        String saltedPass = salt + user.getPassword();
        String passwordHash = HashUtils.hashPassword(saltedPass);
        user.setPassword(passwordHash);

        try {
            userDAO.register(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 生成ID
     * @return 数据库中最大id + 1
     */
    private int generateId() {
        List<User> users = userDAO.getAll(true);
        User lastUser = users.get(0);
        return lastUser.getId() + 1;
    }
}
