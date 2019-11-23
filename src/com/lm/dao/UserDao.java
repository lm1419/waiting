package com.lm.dao;
import com.lm.entity.User;

import java.util.List;

/**
 * @author lm
 * @version V1.0
 * @Package com.lm.dao
 * @date 2019/11/4 16:15
 */
public interface UserDao {
    /**
     * @param
     * @return User
     */
    User findUserByUsernameAndPassword(String username,String passWord);
    List<User> selectAll();
    User selectByUserId(User user);
    User selectByUserName(User user);
    void Register(User user);
    void forget(User user);
    void delete(User user);
}
