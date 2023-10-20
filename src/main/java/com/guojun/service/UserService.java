package com.guojun.service;

import com.guojun.domain.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserService {


    public User selectByUser(User user);

    public User selectByUserName(String userName);

    public boolean add(User user);
}
