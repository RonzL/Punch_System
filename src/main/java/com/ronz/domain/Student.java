package com.ronz.domain;

import java.io.Serializable;

/**
 * @program: punchsystem
 * @author: Ronz
 * @create: 2020-06-03 20:43
 **/
public class Student implements Serializable {

    private Integer id;
    private Integer studentNo;
    private String password;
    private String name;
    private String sex;
    private String email;
    private Integer classNo;
    private String status;
    private Integer days;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(Integer studentNo) {
        this.studentNo = studentNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getClassNo() {
        return classNo;
    }

    public void setClassNo(Integer classNo) {
        this.classNo = classNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentNo=" + studentNo +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", classNo=" + classNo +
                ", status='" + status + '\'' +
                ", days=" + days +
                '}';
    }
}
