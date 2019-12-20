package com.scxh.ssm.dao;

import com.scxh.ssm.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: 乔童
 * @Description: 用户映射器
 * @Date: 2019/12/1 19:33
 * @Version: 1.0
 */
public interface UserMapper {
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
    Integer activation(@Param("uname") String uname, @Param("validate") String validate);
}
