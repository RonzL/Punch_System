package com.ronz.service.impl;

import com.ronz.dao.TeacherDao;
import com.ronz.domain.Teacher;
import com.ronz.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: punchsystem
 * @author: Ronz
 * @create: 2020-06-09 10:47
 **/

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao dao;

    /**
     * 1. 查询所有教师
     * */
    @Override
    public List<Teacher> findAllTeach() {
        return dao.findAllTeach();
    }

    /**
     * 2. 查询未打卡教师
     * */
    @Override
    public List<Teacher> findNoPunchTeach() {
        return dao.findNoPunchTeach();
    }
}
