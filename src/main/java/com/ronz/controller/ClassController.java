package com.ronz.controller;

import com.ronz.domain.Class;
import com.ronz.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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




}
