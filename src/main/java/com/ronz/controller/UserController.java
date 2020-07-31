package com.ronz.controller;

import com.ronz.domain.Student;
import com.ronz.domain.Teacher;
import com.ronz.service.StudentService;
import com.ronz.service.TeacherService;
import com.ronz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 获取主页
 *
 * @program: punchsystem
 * @author: Ronz
 * @create: 2020-07-14 20:20
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserService userService;

    @RequestMapping("/getMain.do")
    public ModelAndView getMain(){
        Map role = userService.judgeRole();
        boolean flag = (boolean) role.get("flag");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("personal_info");
        // 获取学号 / 工号
        Integer no = Integer.parseInt((String) role.get("no"));
        // 判断是否为学生
        if (flag){
            // 如果为学生
            // 获取学生信息
            Student student = studentService.findByStudentNo(no);
            mv.addObject("info", student);
            mv.addObject("role", "stu");
            return mv;
        }
        // 如果不是学生
        // 获取老师信息
        Teacher teacher = teacherService.findOne(no);
        mv.addObject("info",teacher);
        mv.addObject("role", "teach");
        return mv;
    }

    @PostMapping("/updateInfo.do")
    public String updateInfo(@RequestParam("email") String email){
        // 获取当前用户的角色
        userService.updateInfo(email);
        return "redirect:getMain.do";
    }
}
