package com.ronz.service.impl;

import com.ronz.dao.ClassDao;
import com.ronz.dao.StudentDao;
import com.ronz.domain.Class;
import com.ronz.domain.Page;
import com.ronz.domain.Student;
import com.ronz.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: punchsystem
 * @author: Ronz
 * @create: 2020-06-05 17:05
 **/

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassDao classDao;

    /**
     * 1. 查询所有班级（包含学生）
     * */
    @Override
    public Page<Class> findAll(int currentPage, int pageSize) {
        List<Class> classList =  classDao.findAll((currentPage - 1) * pageSize, pageSize);
        int count = classDao.findCount();
        Page<Class> classPage = new Page<>();
        classPage.setCurrentPage(currentPage);
        classPage.setList(classList);
        classPage.setPageSize(pageSize);
        classPage.setTotalCount(count);
        classPage.setTotalPage(count/pageSize + (count%pageSize==0?0:1));
        return classPage;
    }

    /**
     * 2. 查询指定班级中的所有信息
     * */
    @Override
    public Class findOneClass(Integer classNo) {
        return classDao.findOneClass(classNo);
    }

}
