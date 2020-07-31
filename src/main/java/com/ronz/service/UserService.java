package com.ronz.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: punchsystem
 * @author: Ronz
 * @create: 2020-07-12 19:43
 **/
public interface UserService extends UserDetailsService {

    /**
     * 判断当前用户角色
     * */
    Map judgeRole();

    /**
     * 每日 0 点重置所有人打卡状态为 'N'
     */
    void resetStatus();

    /**
     * 每日 10 点提醒未打卡的师生
     * */
    void sendEmail();

    /**
     * 更新个人信息
     * @param email
     */
    void updateInfo(String email);
}
