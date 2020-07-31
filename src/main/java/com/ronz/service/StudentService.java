package com.ronz.service;

import com.ronz.dao.StudentDao;
import com.ronz.domain.Page;
import com.ronz.domain.Punch;
import com.ronz.domain.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: punchsystem
 * @author: Ronz
 * @create: 2020-06-03 21:06
 **/
public interface StudentService{


    /**
     * 1. 根据学号查询个人信息
     * */
    Student findByStudentNo(int no);

    /**
     * 2. 查询出所有学生的信息
     * */
    Page<Student> findAll(int currentPage, int pageSize);

    /**
     * 3. 增加学生
     * */
    void addStudent(Student student);

    /**
     * 4. 分页查询出今天未打卡的学生
     * */
    Page<Student> findNoPunch(int currentPage, int pageSize);

    /**
     * 查询出今天所有未打卡的学生
     * @return
     */
    List<Student> findAllNoPunch();

    /**
     * 5. 查询出今天打卡身体异常的学生
     * */
    List<Student> findIllStudent();

    /**
     * 6. 查询出指定班级未打卡学生
     * */
    List<Student> findNoPunchInClass(int classNo);

    /**
     * 7. 保存个人信息
     * */
    boolean saveInfo(Student student);

    /**
     * 更新主页个人信息
     * */
    void updateInfo(int no, String email);

    /**
     * 8. 修改密码
     * */
    boolean modifyPwd(String password, Integer no);

    /**
     * 9. 上传打卡信息
     * */
    void uploadInfo(Punch punch);

    /**
     * 重置所有学生的打卡状态为 'N'
     */
    void updateAllStatus();

    /**
     * 向所有的学生发送提醒邮件
     */
    void sendEmail();
}
