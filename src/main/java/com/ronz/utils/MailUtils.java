package com.ronz.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.util.Properties;

/**
 * 邮件发送工具类
 */
public final class MailUtils {
    private static final String USER = "邮箱账号";   // 邮箱账号
    private static final String PASSWORD = "授权码"; // 密码或者授权码

    /**
     * @param to 收件人邮箱
     * @param text 邮件内容
     * @param title 邮件标题
     */
    /* 发送邮件函数*/
    public static boolean sendMail(String to, String text, String title){
        try {
            final Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.host", "smtp.qq.com");

            // 设置用户
            props.put("mail.user", USER);
            // 设置密码
            props.put("mail.password", PASSWORD);

            // 获取认证
            Authenticator authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    String userName = props.getProperty("mail.user");
                    String password = props.getProperty("mail.password");
                    return new PasswordAuthentication(userName, password);
                }
            };
            Session mailSession = Session.getInstance(props, authenticator);
            MimeMessage message = new MimeMessage(mailSession);
            String username = props.getProperty("mail.user");
            InternetAddress form = new InternetAddress(username);
            message.setFrom(form);
            InternetAddress toAddress = new InternetAddress(MimeUtility.encodeText(to,MimeUtility.mimeCharset("gb2312"), null));
            message.setRecipient(Message.RecipientType.TO, toAddress);
            message.setSubject(MimeUtility.encodeText(title,MimeUtility.mimeCharset("gb2312"), null));
            message.setContent(text, "text/html;charset=UTF-8");
            Transport.send(message);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 测试邮件
     * */
    public static void main(String[] args) throws Exception {
        MailUtils.sendMail("1158402635@qq.com","测试邮件，无需回复","测试邮件");
    }
}
