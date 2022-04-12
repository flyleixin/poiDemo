package com.leixin.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


public class Product {
    Integer sid;
    String name;
    Integer   studentId;
    String profession;
    String phone;
    String college;
    String direction;
 //   List<Double> status = new ArrayList<Double>();


    @Override
    public String toString() {
        return "Product{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", studentId=" + studentId +
                ", profession='" + profession + '\'' +
                ", phone='" + phone + '\'' +
                ", college='" + college + '\'' +
                ", direction='" + direction + '\'' +
                '}';
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Product(Integer sid, String name, Integer studentId, String profession, String phone, String college, String direction) {
        this.sid = sid;
        this.name = name;
        this.studentId = studentId;
        this.profession = profession;
        this.phone = phone;
        this.college = college;
        this.direction = direction;
    }
}
