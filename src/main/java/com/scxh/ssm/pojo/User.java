package com.scxh.ssm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 乔童
 * @Description: 用户实体类
 * @Date: 2019/12/1 19:33
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
     * 主键
     */
    private Integer uid;
    /**
     * 用户名
     */
    private String uname;
    /**
     * 密码
     */
    private String password;
    /**
     * 验证码
     */
    private String validate;
    /**
     * 激活状态
     */
    private boolean status;
    /**
     * 邮箱
     */
    private String email;
}
