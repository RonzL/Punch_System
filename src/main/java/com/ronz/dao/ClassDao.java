package com.ronz.dao;

import com.ronz.domain.Class;
import com.ronz.domain.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: punchsystem
 * @author: Ronz
 * @create: 2020-06-05 16:48
 **/

@Repository
public interface ClassDao {

    /**
     * 1. 查询所有班级（包含各个班级的学生）
     * */
    @Select("select * from class order by classNo")
    @Results(id = "findAll", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "classNo", property = "classNo"),
            @Result(column = "headerMasterNo", property = "headerMasterNo"),
            @Result(property = "students", column = "classNo", many = @Many(select = "com.ronz.dao.ClassDao.findAllStu"))
    })
    List<Class> findAll();

    /**
     * 2. 查找当前班级的所有学生
     * */
    @Select("select * from student where classNo = #{classNo}")
    List<Student> findAllStu(Integer classNo);

}
