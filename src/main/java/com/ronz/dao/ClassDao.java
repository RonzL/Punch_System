package com.ronz.dao;

import com.ronz.domain.Class;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: punchsystem
 *
 * 查询班级信息接口
 *
 * @author: Ronz
 * @create: 2020-06-05 16:48
 **/

@Repository
public interface ClassDao {

    /**
     * 1. 查询所有班级（包含各个班级的学生）
     * */
    @Select("select * from class order by classNo")
    @ResultMap(value = "findOne")
    List<Class> findAll();


    /**
     * 2. 查找指定班级的详细信息
     * */
    @Select("select * from class where classNo = #{classNo}")
    @Results(id = "findOne", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "classNo", property = "classNo"),
            @Result(column = "headMasterNo", property = "headMaster", one = @One(select = "com.ronz.dao.TeacherDao.findOne")),
            @Result(column = "classNo", property = "allStudents", many = @Many(select = "com.ronz.dao.StudentDao.findAllStu")),
            @Result(column = "classNo", property = "noPunchStudents", many = @Many(select = "com.ronz.dao.StudentDao.findNoPunchInClass"))
    })
    Class findOneClass(Integer classNo);
}
