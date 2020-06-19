package com.ronz.service;

import com.ronz.dao.StudentDao;
import com.ronz.domain.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: punchsystem
 * @author: Ronz
 * @create: 2020-06-03 21:06
 **/
public interface StudentService {


    /**
     * 1. 根据学号查询个人信息
     * */
    Student findByStudentNo(int no);

    /**
     * 2. 查询出所有学生的信息
     * */
    List<Student> findAll();

    /**
     * 3. 增加学生
     * */
    void addStudent(Student student);

    /**
     * 4. 查询出今天未打卡的学生
     * */
    List<Student> findNoPunch();

    /**
     * 5. 查询出今天打卡身体异常的学生
     * */
    List<Student> findIllStudent();

    /**
     * 7. 查询出有效打卡未满 30 天的学生（有效打卡指的是：过去30天内身体无异常，且连续打卡）
     * */


    /**
     * 8. 查询出身体有异常的学生
     * */

}
