package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.domain.Userlogin;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 登录功能
     * @param username
     * @param password
     * @return
     */
    @Override
    public Userlogin login(String username, String password) {
        Userlogin userlogin = userDao.findByUsernameAndPassword(username,password);
        return userlogin;
    }

    /**
     * 查询所有用户功能
     * @return
     */
    @Override
    public List<User> findAll() {
        List<User> list = userDao.findAll();
        return list;
    }
}
