package com.leixin.dao;

public class Attendance {
    String nickName;
    String startTime;
    String endTime;
    String counts;
    String duration;
    String identity;

    public Attendance(String nickName, String startTime, String endTime, String counts, String duration, String identity) {

        this.nickName = nickName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.counts = counts;
        this.duration = duration;
        this.identity = identity;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCounts() {
        return counts;
    }

    public void setCounts(String counts) {
        this.counts = counts;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "nickName='" + nickName + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", counts='" + counts + '\'' +
                ", duration='" + duration + '\'' +
                ", identity='" + identity + '\'' +
                '}';
    }
}
