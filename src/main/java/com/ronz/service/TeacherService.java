package com.ronz.service;

import com.ronz.domain.Page;
import com.ronz.domain.Punch;
import com.ronz.domain.Teacher;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherService {

    /**
     * 1. 查询所有教师
     * */
    Page<Teacher> findAll(int currentPage, int size);

    /**
     * 2. 分页查询未打卡教师
     * */
    Page<Teacher> findNoPunchByPage(int currentPage, int size);

    /**
     * 查询所有未打卡教师
     * @return
     */
    List<Teacher> findAllNoPunch();

    /**
     * 3. 根据工号查询教师
     * */
    Teacher findOne(Integer jobNo);

    /**
     * 4. 给指定工号的教师添加权限
     * */
    boolean addRoles(int jobNo, int[] roles);

    /**
     * 5. 上传教师打卡信息
     * */
    void uploadInfo(Punch punch);

    /**
     * 6. 重置所有教师打卡状态
     */
    void updateAllStatus();

    /**
     * 发送邮件提醒所有老师打卡
     */
    void sendEmail();

    /**
     * 更新主页个人信息
     * @param no
     * @param email
     */
    void updateInfo(int no, String email);

    /**
     * 保存老师个人信息
     * @param teacher
     */
    void saveInfo(Teacher teacher);
}
