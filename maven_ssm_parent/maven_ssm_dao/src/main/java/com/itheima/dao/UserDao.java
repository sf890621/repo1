package com.itheima.dao;

import com.itheima.domain.User;
import com.itheima.domain.Userlogin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao {

    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findAll();

    /**
     * 根据用户名和密码查询登录用户信息
     * @param username
     * @param password
     * @return
     */
    public Userlogin findByUsernameAndPassword(@Param("username") String username, @Param("password")String password);
}
