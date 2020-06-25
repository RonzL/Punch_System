package com.ronz.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @program: punchsystem
 * @author: Ronz
 * @create: 2020-06-05 16:42
 **/
public class Class implements Serializable {

    private Integer id;                 // id
    private Integer classNo;            // 班级编号
    private Teacher headMaster;         // 辅导员
    private List<Student> allStudents;  // 所有学生
    private List<Student> noPunchStudents;  // 所有未打卡学生

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClassNo() {
        return classNo;
    }

    public void setClassNo(Integer classNo) {
        this.classNo = classNo;
    }

    public Teacher getHeadMaster() {
        return headMaster;
    }

    public void setHeadMaster(Teacher headMaster) {
        this.headMaster = headMaster;
    }

    public List<Student> getAllStudents() {
        return allStudents;
    }

    public void setAllStudents(List<Student> allStudents) {
        this.allStudents = allStudents;
    }

    public List<Student> getNoPunchStudents() {
        return noPunchStudents;
    }

    public void setNoPunchStudents(List<Student> noPunchStudents) {
        this.noPunchStudents = noPunchStudents;
    }
}
