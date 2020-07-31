package com.ronz.controller;

import com.ronz.domain.Punch;
import com.ronz.domain.Student;
import com.ronz.domain.Teacher;
import com.ronz.service.StudentService;
import com.ronz.service.TeacherService;
import com.ronz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @program: punchsystem
 * @author: Ronz
 * @create: 2020-07-04 10:27
 **/

@Controller
@RequestMapping("/punch")
public class PunchController {

    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    UserService userService;


    /**
     * 获取打卡信息
     * @return
     */
    @RequestMapping(value = "/getPunch.do")
    @ResponseBody
    public ModelAndView getPunch(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("punch");
        // 判断当前角色
        Map map = userService.judgeRole();
        boolean flag = (boolean) map.get("flag");
        // 学生为 true ，老师为  false
        if (flag){
            Student student = studentService.findByStudentNo(Integer.parseInt((String) map.get("no")));
            mv.addObject("info",student);
        }else{
            Teacher teacher = teacherService.findOne(Integer.parseInt((String) map.get("no")));
            mv.addObject("info",teacher);
        }
        return mv;
    }

    /**
     * 2. 上传打卡信息
     * */
    @PostMapping(value = "/uploadInfo.do")
    public String uploadInfo(Punch punch){
        // 判断当前角色
        Map map = userService.judgeRole();
        boolean flag = (boolean) map.get("flag");
        punch.setId(null);
        // 学生为 true ，老师为  false
        if (flag){
            studentService.uploadInfo(punch);
        } else{
            teacherService.uploadInfo(punch);
        }
        return "redirect:getPunch.do";
    }
}
