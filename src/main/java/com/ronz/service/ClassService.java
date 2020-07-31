package com.ronz.service;

import com.ronz.domain.Class;
import com.ronz.domain.Page;
import com.ronz.domain.Student;
import java.util.List;

public interface ClassService {


    /**
     * 1. 分页查询所有班级（包含各个班级的学生）
     * */
    Page<Class> findAll(int currentPage, int pageSize);

    /**
     * 2. 查找指定班级所有信息
     * */
    Class findOneClass(Integer classNo);

}
