package com.scxh.ssm.utils;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Properties;

/**
 * @Author: 乔童
 * @Description: 邮箱工具类
 * @Date: 2019/12/1 22:04
 * @Version: 1.0
 */
public class EmailUtils {
    /**
     * 邮件服务器会话对象
     */
    private Properties props=new Properties();

    public void sendEmail(String toEmail, String uname, String validate) throws MessagingException, IOException {
        //1.读取用于连接服务器的配置文件
        props.load(this.getClass().getClassLoader().getResourceAsStream("email.properties"));
        //2.根据配置信息创建会话
        Session session=Session.getInstance(props);
        String fromEmail=props.getProperty("fromEmail");
        String fromPass=props.getProperty("fromPass");
        String content=MessageFormat.format(props.getProperty("content"), uname,validate);
        //3.创建邮件对象
        MimeMessage message=createMimeMessage(session,fromEmail,toEmail,content);
        //4.根据会话开启传输连接
        Transport transport=session.getTransport();
        //5.使用发送人邮箱账户密码登录邮箱服务器
        transport.connect(fromEmail,fromPass);
        //6.发送邮件
        transport.sendMessage(message,message.getAllRecipients());
        //7.关闭连接
        transport.close();
    }

    /**
     * 创建邮件对象
     * @param session 邮件会话
     * @param fromEmail 发件人邮箱
     * @param toEmail 收件人邮箱
     */
    private MimeMessage createMimeMessage(Session session, String fromEmail, String toEmail,String content) throws UnsupportedEncodingException, MessagingException {
        //1.创建邮件对象
        MimeMessage message=new MimeMessage(session);
        //2.设置发件人邮箱
        message.setFrom(new InternetAddress(fromEmail,"乔"));
        //3.设置收件人邮箱
        message.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(toEmail,"User","UTF-8"));
        //4.设置抄送人
        message.setRecipient(MimeMessage.RecipientType.BCC,new InternetAddress(fromEmail));
        //5.设置主题
        message.setSubject("来自我的项目的激活邮件","UTF-8");
        //6.设置内容
        message.setContent(content,"text/html;charset=UTF-8");
        //7.设置发送时间
        message.setSentDate(new Date());
        //8.保存邮件
        message.saveChanges();
        return message;
    }
}
