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

    @Override
    public Student findByStudentNo(int no) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public void addStudent(Student student) {

    }

    @Override
    public List<Student> findNoPunch() {
        return null;
    }

    @Override
    public List<Student> findIllStudent() {
        return null;
    }
}
