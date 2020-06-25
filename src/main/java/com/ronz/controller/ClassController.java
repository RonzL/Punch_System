package com.ronz.controller;

import com.ronz.domain.Class;
import com.ronz.domain.Student;
import com.ronz.service.ClassService;
import com.ronz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: punchsystem
 * @author: Ronz
 * @create: 2020-06-05 17:10
 **/
@Controller
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private ClassService classService;

    @Autowired
    private StudentService studentService;

    /**
     * 1. 查询所有班级
     * */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        List<Class> classList = classService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("class_list");
        mv.addObject("classList", classList);
        return mv;
    }

    /**
     * 2. 查找指定班级中的所有信息
     * */
    @RequestMapping("/findOneClassStu.do")
    public ModelAndView findOneClassStu(@RequestParam int classNo){
        Class oneClass = classService.findOneClass(classNo);
        ModelAndView mv = new ModelAndView();
        mv.addObject("oneClass", oneClass );
        mv.setViewName("class_details");
        return mv;
    }

    /**
     * 3. 查询出指定班级未打卡学生
     * */
    @RequestMapping("/findNoPunchInClass.do")
    public ModelAndView findNoPunchInClass(@RequestParam int classNo){
        List<Student> noPunchInClass = studentService.findNoPunchInClass(classNo);
        ModelAndView mv = new ModelAndView();
        mv.addObject("noPunch", noPunchInClass);
        mv.setViewName("class_nopunch_list");
        return mv;
    }
}
