package com.ronz.controller;

import com.ronz.domain.Page;
import com.ronz.domain.Student;
import com.ronz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * @program: punchsystem
 * @author: Ronz
 * @create: 2020-06-03 22:21
 **/

@Controller
@RequestMapping(value = "/student")
@RolesAllowed({"ADMIN","USER"})
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 1. 分页查找所有记录
     * */
    @RequestMapping("/findAll.do")
    public ModelAndView findAllStudents(Integer currentPage, Integer pageSize){
        if (currentPage == null){
            currentPage = 1;
        }
        if (pageSize == null){
            pageSize = 10;
        }
        Page<Student> page = studentService.findAll(currentPage, pageSize);
        ModelAndView mv = new ModelAndView();
        // 设置要跳转的界面
        mv.setViewName("student_list");
        // 将查到的结果存储到域中
        mv.addObject("pageInfo", page);
        return mv;
    }

    /**
     * 2. 查询今日未打卡
     * */
    @RequestMapping("findNoPunch.do")
    public ModelAndView findNoPunch(Integer currentPage, Integer pageSize){
        if (currentPage == null){
            currentPage = 1;
        }
        if (pageSize == null){
            pageSize = 10;
        }
        Page<Student> page = studentService.findNoPunch(currentPage, pageSize);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("nopunch_student_list");
        modelAndView.addObject("pageInfo", page);
        return modelAndView;
    }

    /**
     * 3. 根据学号查询学生信息
     * */
    @RequestMapping("/findByStuNo.do")
    public ModelAndView findByStuNo(@RequestParam int flag, @RequestParam(name = "stuNo") int stuNo){
        Student student = studentService.findByStudentNo(stuNo);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("student_details");
        mv.addObject("info", student);
        mv.addObject("flag", flag);
        return mv;
    }

    /**
     * 4. 保存个人信息
     * */
    @RequestMapping("/saveInfo.do")
    public String saveInfo(Student student, @RequestParam("flag") String flag){
        studentService.saveInfo(student);
        // 重定向到查询个人信息页面
        return "redirect:findByStuNo.do?flag=" + flag +"&stuNo=" + student.getNo();
    }

    /**
     * 5. 修改密码
     * */
    @PostMapping("/modifyPwd.do")
    public ModelAndView modifyPwd(@RequestParam(name = "password") String password, @RequestParam(name = "no") Integer no){
        boolean flag = studentService.modifyPwd(password, no);
        Student student = studentService.findByStudentNo(no);
        ModelAndView mv = new ModelAndView();
        mv.addObject("flag", String.valueOf(flag));
        mv.addObject("student", student);
        mv.setViewName("student_pwd_edit");
        return mv;
    }
}
