package com.leixin.dao;

import java.util.ArrayList;
import java.util.List;

public class Overall {
    Integer sid;
    String name;
    Integer studentId;
    String profession;
    String phone;
    String college;
    String direction;
    ArrayList<Double> everyStatus = new ArrayList<>();

    public Overall(Integer sid, String name, Integer studentId, String profession, String phone, String college, String direction, ArrayList<Double> everyStatus) {
        this.sid = sid;
        this.name = name;
        this.studentId = studentId;
        this.profession = profession;
        this.phone = phone;
        this.college = college;
        this.direction = direction;
        this.everyStatus = everyStatus;
    }


    @Override
    public String toString() {
        return "Overall{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", studentId=" + studentId +
                ", profession='" + profession + '\'' +
                ", phone='" + phone + '\'' +
                ", college='" + college + '\'' +
                ", direction='" + direction + '\'' +
                ", everyStatus=" + everyStatus +
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

    public ArrayList<Double> getEveryStatus() {
        return everyStatus;
    }

    public void setEveryStatus(ArrayList<Double> everyStatus) {
        this.everyStatus = everyStatus;
    }
}
