package com.ronz.service;

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
    List<Teacher> findAllTeach();

    /**
     * 2. 查询未打卡教师
     * */
    List<Teacher> findNoPunchTeach();

    /**
     * 3. 根据工号查询教师
     * */
    @Select("select * from headmaster where jobNo = #{jobNo}")
    Teacher findOne(Integer jobNo);

}
