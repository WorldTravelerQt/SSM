package com.scxh.ssm.service.impl;

import com.scxh.ssm.dao.UserMapper;
import com.scxh.ssm.pojo.User;
import com.scxh.ssm.service.UserService;
import com.scxh.ssm.utils.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * @Author: 乔童
 * @Description:
 * @Date: 2019/12/1 20:06
 * @Version: 1.0
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private EmailUtils emailUtils;

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public Integer regist(User user) {
        try {
            System.err.println(user);
            emailUtils.sendEmail(user.getEmail(),user.getUname(),user.getValidate());
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
        return userMapper.regist(user);
    }

    @Override
    public User findUserByUname(String uname) {
        return userMapper.findUserByUname(uname);
    }

    @Override
    public Integer activation(String uname, String validate) {
        return userMapper.activation(uname,validate);
    }
}
