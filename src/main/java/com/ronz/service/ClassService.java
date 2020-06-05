package com.ronz.service;

import com.ronz.domain.Class;
import com.ronz.domain.Student;
import java.util.List;

public interface ClassService {


    /**
     * 1. 查询所有班级（包含各个班级的学生）
     * */
    List<Class> findAll();

    /**
     * 2. 查找当前班级的所有学生
     * */
    List<Student> findAllStu(Integer classNo);

}
