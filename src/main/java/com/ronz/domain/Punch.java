package com.ronz.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 打卡信息
 * @Author: Ronz ronz_liu@163.com
 * @Date: Created in 10:54 2020/7/23
 */
public class Punch implements Serializable {

    private Integer id;
    private Integer no;
    private Date date;
    private String physical_state;
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPhysical_state() {
        return physical_state;
    }

    public void setPhysical_state(String physical_state) {
        this.physical_state = physical_state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
