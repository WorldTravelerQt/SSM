package com.scxh.ssm.controller;

import com.scxh.ssm.pojo.User;
import com.scxh.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @Author: 乔童
 * @Description: 用户控制器
 * @Date: 2019/12/1 19:32
 * @Version: 1.0
 */
@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    @Qualifier(value = "userService")
    private UserService userService;
    /**
     * 登录
     */
    @RequestMapping("/login")
    public ModelAndView login(User user, HttpServletRequest request)
    {
        /**
         * 登录流程：
         * 1.调用service进行查询，获取user对象
         * 2.判断user对象是否不为null，并且是否已激活
         * 3.如果已经激活，跳转到main页面
         * 4.如果未激活，保存错误信息转发到消息页面
         */
        System.err.println("用户请求登录->"+user);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("msg");
        User loginUser = userService.login(user);
        if(loginUser!=null&&loginUser.isStatus())
        {
            HttpSession session = request.getSession();
            session.setAttribute("loginUser",loginUser);
            mav.setViewName("redirect:/books/all");
        }else if(loginUser==null)
        {
            mav.addObject("error","用户名或密码错误！");
        }else
        {
            mav.addObject("error","用户尚未激活！");
        }
        return mav;
    }
    /**
     * 注册
     */
    @RequestMapping("/toRegistPager")
    public String toRegistPager()
    {
        return "regist";
    }
    @RequestMapping("/regist")
    public String regist(User user, Model model)
    {
        /**
         * 注册流程：
         * 1.校验用户是否已被注册(只校验用户名，懒得校验邮箱了。。)
         * 2.如果用户已被注册保存错误信息跳转到消息页面
         * 3.如果用户名未被注册，生成一个验证码，将user数据保存到数据库中
         */
        System.err.println("用户请求注册->"+user);
        User loginUser = userService.findUserByUname(user.getUname());
        if(loginUser!=null)
        {
            model.addAttribute("error","用户名已被注册！");
        }else
        {
            user.setValidate(UUID.randomUUID().toString().replace("-",""));
            userService.regist(user);
            model.addAttribute("msg","用户注册成功！请到邮箱中激活");
        }
        return "msg";
    }
    /**
     * 用户激活
     */
    @RequestMapping("/activate/{uname}/{validate}")
    public ModelAndView activation(@PathVariable String uname,@PathVariable String validate)
    {
        /**
         * 激活流程：
         * 1.根据uid、验证码查询该用户
         * 2.如果查询到了该用户，修改激活状态，保存激活成功消息跳转到消息页面
         * 3.如果未查询到，说明验证码错了，保存错误信息跳转到消息页面
         */
        System.err.println("用户ID->uid\n"+"激活码->"+validate);
        ModelAndView mav=new ModelAndView();
        mav.setViewName("msg");
        Integer flag = userService.activation(uname, validate);
        if(flag==0)
        {
            mav.addObject("error","激活失败，激活码错误");
        }else
        {
            //懒得单独写一个success页面，直接用字符串吧
            String temp="<a href='http://localhost:8080/SSMDemo_war_exploded/'>登录<a/>";
            mav.addObject("msg","激活成功，点击"+temp);
        }
        return mav;
    }
}
