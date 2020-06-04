package com.ronz.test;

import com.ronz.dao.StudentDao;
import com.ronz.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @program: punchsystem
 * @author: Ronz
 * @create: 2020-06-03 20:55
 **/

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class StudentDaoTest {

    @Autowired
    private StudentDao dao;

    /**
     * 1. 测试查找所有学生
     * */
    @Test
    public void testFindAll(){
        List<Student> studentList = dao.findAll();
        System.out.println(studentList);
    }

}
