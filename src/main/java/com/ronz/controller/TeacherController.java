package com.ronz.controller;

import com.ronz.domain.Teacher;
import com.ronz.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: punchsystem
 * @author: Ronz
 * @create: 2020-06-09 11:23
 **/

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService service;

    /**
     * 1. 查询所有的教师信息
     * */
    @RequestMapping("/findAll.do")
    public ModelAndView findAllTeach(){
        List<Teacher> teacherList = service.findAllTeach();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("teacher_list");
        mv.addObject("teacherList", teacherList);
        return mv;
    }

    /**
     * 2. 查询出未打卡的教师
     * */
    @RequestMapping("/findNoPunch.do")
    public ModelAndView findNoPunch(){
        List<Teacher> noPunchTeach = service.findNoPunchTeach();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("nopunch_teacher_list");
        mv.addObject("noPunchTeach", noPunchTeach);
        return mv;
    }

}
