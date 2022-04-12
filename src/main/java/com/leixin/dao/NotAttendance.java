package com.leixin.dao;

public class NotAttendance {
    String nickName;
    Double duration;
    Double status;

    public NotAttendance(String nickName, Double duration, Double status) {
        this.nickName = nickName;
        this.duration = duration;
        this.status = status;
    }

    @Override
    public String toString() {
        return "NotAttendance{" +
                "nickName='" + nickName + '\'' +
                ", duration='" + duration + '\'' +
                ", status=" + status +
                '}';
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Double getStatus() {
        return status;
    }

    public void setStatus(Double status) {
        this.status = status;
    }
}
