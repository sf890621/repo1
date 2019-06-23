package com.itheima.service;

import com.itheima.domain.User;
import com.itheima.domain.Userlogin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    /**
     * 登录功能
     * @param username
     * @param password
     * @return
     */
    public Userlogin login(@Param("username") String username, @Param("password") String password);

    /**
     * 查询所有用户功能
     * @return
     */
    public List<User> findAll();
}
