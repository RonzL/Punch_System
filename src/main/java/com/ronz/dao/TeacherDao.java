package com.ronz.dao;

import com.ronz.domain.Teacher;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: punchsystem
 * @author: Ronz
 * @create: 2020-06-07 11:03
 **/
@Repository
public interface TeacherDao {

    /**
     * 1. 查询所有教师
     * */
    @Select("select * from headmaster")
    @Results(id = "findAllTeacher", value = {
            @Result(id = true, column = "jobNo", property = "jobNo"),
            @Result(column = "password", property = "password"),
            @Result(column = "name", property = "name"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "email", property = "email"),
            @Result(column = "status", property = "status"),
            @Result(column = "days", property = "days"),
            @Result(column = "jobNo", property = "roles", many = @Many(select = "com.ronz.dao.RoleDao.findRoles"))
    })
    List<Teacher> findAllTeach();

    /**
     * 2. 查询未打卡教师
     * */
    @Select("select * from headmaster where status = 'N'")
    List<Teacher> findNoPunchTeach();

}
