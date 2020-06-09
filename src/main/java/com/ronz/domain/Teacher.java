package com.ronz.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @program: punchsystem
 * @author: Ronz
 * @create: 2020-06-07 11:01
 **/
public class Teacher implements Serializable {

    private Integer jobNo;
    private String password;
    private String name;
    private String sex;
    private String email;
    private String status;
    private Integer days;
    private List<Role> roles;


    public Integer getJobNo() {
        return jobNo;
    }

    public void setJobNo(Integer jobNo) {
        this.jobNo = jobNo;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                ", jobNo=" + jobNo +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                ", days=" + days +
                ", roles=" + roles +
                '}';
    }
}
