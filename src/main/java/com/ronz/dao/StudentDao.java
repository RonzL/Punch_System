package com.ronz.dao;

import com.ronz.domain.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;

/**
 * @program: punchsystem
 * @author: Ronz
 * @create: 2020-06-03 20:42
 **/

@Repository
public interface StudentDao {

    /**
     * 1. 根据学号查询个人信息
     * */
    @Select("select * from student where studentNo = #{no}")
    Student findByStudentNo(int no);

    /**
     * 2. 查询出所有学生的信息
     * */
    @Select("select * from student")
    List<Student> findAll();

    /**
     * 3. 增加学生
     * */
    @Insert("insert into student(id,studentNo,password,name,sex,email,classNo,status,days) " +
            "values (#{id},#{studentNo},#{password},#{name},#{sex},#{email},#{classNo},#{status},#{days})")
    void addStudent(Student student);

}
