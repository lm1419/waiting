package com.lm.service.impl;

import com.lm.dao.UserDao;
import com.lm.dao.impl.UserDaoImpl;
import com.lm.entity.User;
import com.lm.service.UserService;


import java.sql.Timestamp;
import java.util.List;

/**
 * @author lm
 * @version V1.0
 * @Package com.lm.service.impl
 * @date 2019/11/4 16:37
 */
public class UserServiceImpl implements UserService {
    UserDao ud = new UserDaoImpl();

    @Override
    public User findUserByUsernameAndPassword(User user) {
        return new UserDaoImpl().findUserByUsernameAndPassword(user.getUserName(),user.getPassWord());
    }

    @Override
    public void register(User user) {
        Timestamp time = new Timestamp(System.currentTimeMillis());
        user.setLastLoginTime(time);
        user.setRegistrationDate(time);
        ud.Register(user);
    }

    @Override
    public User forget(User user) {
        List<User> users = ud.selectAll();
        for (User u : users) {
            if (u.getUserName().equals(user.getUserName())) {
                return u;
            }
        }
        return null;
    }

    @Override
    public User forgetAnswer(User user) {
        List<User> users = ud.selectAll();
        for (User u : users) {
            if (u.getUserName().equals(user.getUserName())) {
                if (u.getAnswer().equals(user.getAnswer())){
                    return u;
                }
            }
        }
        return null;
    }

    @Override
    public void delete(User user) {
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.delete(user);
    }

}
