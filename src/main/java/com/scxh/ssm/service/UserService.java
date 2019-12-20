package com.scxh.ssm.service;

import com.scxh.ssm.pojo.User;

/**
 * @Author: 乔童
 * @Description: 用户业务层接口
 * @Date: 2019/12/1 20:04
 * @Version: 1.0
 */
public interface UserService {
    /**
     * 登录
     */
    User login(User user);
    /**
     * 注册
     */
    Integer regist(User user);
    /**
     * 按用户名查询用户是否存在
     */
    User findUserByUname(String uname);
    /**
     * 激活用户
     */
    Integer activation(String uname, String validate);
}
