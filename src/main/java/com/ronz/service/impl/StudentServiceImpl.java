package com.ronz.service.impl;

import com.ronz.dao.StudentDao;
import com.ronz.domain.Student;
import com.ronz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: punchsystem
 * @author: Ronz
 * @create: 2020-06-03 22:19
 **/
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    /**
     * 1. 根据学号查询学生信息
     * */
    @Override
    public Student findByStudentNo(int no) {
        return studentDao.findByStudentNo(no);
    }

    /**
     * 2. 查询所有学生
     * */
    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    /**
     * 3. 添加学生到数据库
     * */
    @Override
    public void addStudent(Student student) {

    }

    /**
     * 4. 查询出今日未打卡的学生
     * */
    @Override
    public List<Student> findNoPunch() {
        return studentDao.findNoPunch();
    }

    /**
     * 5. 查询出今日身体异常的学生
     * */
    @Override
    public List<Student> findIllStudent() {
        return null;
    }

}
