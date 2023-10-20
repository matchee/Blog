package com.guojun.service.impl;

import com.guojun.dao.UserDao;
import com.guojun.domain.User;
import com.guojun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User selectByUser(User user) {
        return userDao.selectByUser(user);
    }



    @Override
    public User selectByUserName(String userName) {
        return userDao.selectByUserName(userName);
    }

    @Override
    public boolean add(User user) {
        User user_msg = userDao.selectByUserName(user.getEmail());
        //查询到用户名相同，这flag为false
        boolean flag = (user_msg == null);
        if(flag){
            userDao.add(user);
            flag = true;
        }
        return flag;
    }
}
