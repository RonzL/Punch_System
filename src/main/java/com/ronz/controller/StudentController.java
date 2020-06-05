package com.ronz.controller;

import com.ronz.domain.Student;
import com.ronz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: punchsystem
 * @author: Ronz
 * @create: 2020-06-03 22:21
 **/

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 1. 查找所有
     * */
    @RequestMapping("/findAll.do")
    public ModelAndView findAllStudents(){
        List<Student> students = studentService.findAll();
        ModelAndView mv = new ModelAndView();
        // 设置要跳转的界面
        mv.setViewName("student_list");
        // 将查到的结果存储到域中
        mv.addObject("studentList", students);
        return mv;
    }

    /**
     * 2. 查询今日未打卡
     * */
    @RequestMapping("findNoPunch.do")
    public ModelAndView findNoPunch(){
        List<Student> noPunchList = studentService.findNoPunch();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("nopunch_list");
        modelAndView.addObject("noPunchList", noPunchList);
        return modelAndView;
    }
}
