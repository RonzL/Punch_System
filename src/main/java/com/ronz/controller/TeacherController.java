package com.ronz.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ronz.domain.Page;
import com.ronz.domain.Teacher;
import com.ronz.service.TeacherService;
import com.ronz.utils.MailUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
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
    @RolesAllowed({"ADMIN"})
    @RequestMapping("/findAll.do")
    public ModelAndView findAllTeach(Integer currentPage, Integer pageSize){
        if (currentPage == null){
            currentPage = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        Page<Teacher> page = service.findAll(currentPage, pageSize);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("teacher_list");
        mv.addObject("pageInfo", page);
        return mv;
    }

    /**
     * 2. 查询出未打卡的教师
     * */
    @RolesAllowed({"ADMIN"})
    @RequestMapping("/findNoPunch.do")
    public ModelAndView findNoPunch(Integer currentPage, Integer pageSize){
        if (currentPage == null){
            currentPage = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        Page<Teacher> pageInfo = service.findNoPunchByPage(currentPage, pageSize);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("nopunch_teacher_list");
        mv.addObject("pageInfo", pageInfo);
        return mv;
    }

    /**
     * 3. 根据工号查询教师个人信息
     * */
    @RolesAllowed({"ADMIN"})
    @RequestMapping("/findOne.do")
    public ModelAndView findByJobNo(@RequestParam("flag") int flag ,@RequestParam("no") int no){
        Teacher info = service.findOne(no);
        ModelAndView mv = new ModelAndView();
        mv.addObject("info", info);
        mv.setViewName("teacher_details");
        if (flag == 1){
            // 全部教师 -- 查看详情
            mv.addObject("flag", "1");
        } else if (flag == 2){
            // 未打卡教师 -- 查看详情
            mv.addObject("flag", "2");
        }
        return mv;
    }

    /**
     * 4. 给指定工号教师添加权限
     * */
    @RolesAllowed({"ADMIN"})
    @RequestMapping(value = "/addRoles.do", method = RequestMethod.POST)
    @ResponseBody
    public String addRoles(@RequestParam(name = "no") int no ,@RequestParam(name = "sel_roles") int[] roles){
        return String.valueOf(service.addRoles(no, roles));
    }

    /**
     * 5. 给指定教师发送提醒邮件
     * */
    @RolesAllowed({"ADMIN"})
    @RequestMapping(value = "/sendEmail.do")
    @ResponseBody
    public String sendEmail(@RequestParam(name = "email") String email, @RequestParam(name = "message") String message) throws UnsupportedEncodingException {
        MailUtils.sendMail(email,message,"每日健康信息上报提醒");
        System.out.println("发送成功");
        return "success ";
    }

    /**
     * 保存老师个人信息
     * @return
     */
    @PostMapping("/saveInfo.do")
    public String saveInfo(Teacher teacher, @RequestParam("flag") String flag){
        service.saveInfo(teacher);
        return "redirect:findOne.do?flag=" + flag + "&no=" + teacher.getNo();
    }
}
