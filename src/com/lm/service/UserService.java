package com.lm.service;

import com.lm.entity.User;

public interface UserService {
    User findUserByUsernameAndPassword(User user);
    void register(User user);
    User forget(User user);
    User forgetAnswer(User user);
    void delete(User user);
}
