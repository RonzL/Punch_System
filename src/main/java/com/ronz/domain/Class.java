package com.ronz.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @program: punchsystem
 * @author: Ronz
 * @create: 2020-06-05 16:42
 **/
public class Class implements Serializable {

    private Integer id;
    private Integer classNo;
    private Integer headMasterNo;
    private List<Student> students;
    private List<Student> noPunchStu;

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

    public Integer getHeadMasterNo() {
        return headMasterNo;
    }

    public void setHeadMasterNo(Integer headMasterNo) {
        this.headMasterNo = headMasterNo;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getNoPunchStu() {
        return noPunchStu;
    }

    public void setNoPunchStu(List<Student> noPunchStu) {
        this.noPunchStu = noPunchStu;
    }
}
