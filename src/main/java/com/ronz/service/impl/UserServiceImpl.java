package com.ronz.service.impl;

import com.ronz.domain.Role;
import com.ronz.domain.Student;
import com.ronz.domain.Teacher;
import com.ronz.service.StudentService;
import com.ronz.service.TeacherService;
import com.ronz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @program: punchsystem
 * @author: Ronz
 * @create: 2020-07-12 19:45
 **/

@Service("userDetailsService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String no) throws UsernameNotFoundException {
        System.out.println("测试进来了没有");
        System.out.println(no);
        Student student = studentService.findByStudentNo(Integer.parseInt(no));
        if (student == null) {
            Teacher teacher = teacherService.findOne(Integer.parseInt(no));
            System.out.println(teacher.getPassword());
            return new User(teacher.getNo()+" "+teacher.getName(), bCryptPasswordEncoder.encode(teacher.getPassword()), true,true,true,true,getAuthorities(teacher.getRoles()));
        }
        ArrayList<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ROLE_STUDENT"));
        return new User(student.getNo()+" "+student.getName(), bCryptPasswordEncoder.encode(student.getPassword()), true,true,true,true,list);
    }

    /**
     * 获取用户的角色名称
     * */
    private Collection<? extends GrantedAuthority> getAuthorities(List<Role> roles) {
        List<GrantedAuthority> list = new ArrayList<>();
        for (Role role : roles)
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        return list;
    }

    /**
     *  判断当前是学生还是老师
     * */
    public Map judgeRole(){
        Map map = new HashMap();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Collection<? extends GrantedAuthority> authorities = ((UserDetails) principal).getAuthorities();
        // 获取第一个权限
        GrantedAuthority grantedAuthority = (GrantedAuthority) authorities.toArray()[0];
        String username = ((UserDetails) principal).getUsername();
        // 获取学/工 号信息
        String[] split = username.split(" ");
        map.put("no", split[0]);
        // 判断是不是学生
        if (authorities.size() == 1 && "ROLE_STUDENT".equals(grantedAuthority.getAuthority())){
            map.put("flag", true);
        } else{
            map.put("flag", false);
        }
        return map;
    }


    /**
     * 更新主页个人信息
     * @param email
     */
    @Override
    public void updateInfo(String email) {
        Map role = judgeRole();
        boolean flag = (boolean) role.get("flag");
        int no = Integer.parseInt(String.valueOf(role.get("no")));
        if (flag){
            // 如果是学生
            studentService.updateInfo(no, email);
        }else{
            // 如果是老师
            teacherService.updateInfo(no, email);
        }
    }

    /**
     * 每日 0 点重置所有人打卡状态为'N'
     */
    @Override
    public void resetStatus() {
        // 重置全部师生的打卡状态
        teacherService.updateAllStatus();
        studentService.updateAllStatus();
    }

    /**
     * 每日 10 点发送邮件提醒未打卡的师生
     */
    @Override
    public void sendEmail(){
        studentService.sendEmail();
        teacherService.sendEmail();
    }

}
