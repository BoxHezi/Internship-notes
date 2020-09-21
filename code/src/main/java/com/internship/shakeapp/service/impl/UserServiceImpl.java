package com.internship.shakeapp.service.impl;

import com.internship.shakeapp.dao.UserDAO;
import com.internship.shakeapp.entity.User;
import com.internship.shakeapp.service.UserService;
import com.internship.shakeapp.utils.HashUtils;
import com.internship.shakeapp.utils.StringUtils;
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
    public String login(User user) {
        User tempUser = userDAO.getUserByUsername(user.getUsername());
        if (tempUser == null) {
            return StringUtils.USER_NOT_EXISTED;
        }

        String testPass = tempUser.getSalt() + user.getPassword();
        String testPassHash = HashUtils.hashPassword(testPass);

        if (tempUser.getPassword().equals(testPassHash)) {
            return StringUtils.LOGIN_SUCCESS;
        } else {
            return StringUtils.LOGIN_FAILED;
        }
    }

    /**
     * 用户注册服务
     * @param user 用户注册信息,来自于post request
     * @return 当用户注册成功, 返回true, 否则false
     */
    @Override
    public String register(User user) {
        if (checkExist(user.getUsername())) {
            return StringUtils.USER_EXISTED;
        }

        user.setId(generateId()); // 并设置数据库中的ID

        // 生成随机salt
        String salt = HashUtils.generateSalt();
        user.setSalt(salt);

        // 计算salt + password hash值
        String saltedPass = salt + user.getPassword();
        String passwordHash = HashUtils.hashPassword(saltedPass);
        user.setPassword(passwordHash);

        if (user.getType() == null) {
            user.setType(1);
        }

        try {
            userDAO.register(user);
            return StringUtils.REGISTER_SUCCESS;
        } catch (Exception e) {
            return StringUtils.REGISTER_FAILED;
        }
    }

    /**
     * 生成ID
     * @return 数据库中最大id + 1
     */
    private Long generateId() {
        List<User> users = userDAO.getAll(true);
        if (users.size() == 0) {
            return 1L;
        }
        User lastUser = users.get(0);
        return lastUser.getId() + 1;
    }

    /**
     * 检查数据库中是否存在同名username
     * @return 如果有同名的, 返回true, 否则返回false
     */
    private boolean checkExist(String username) {
        User user = userDAO.getUserByUsername(username);
        return user != null;
    }
}
