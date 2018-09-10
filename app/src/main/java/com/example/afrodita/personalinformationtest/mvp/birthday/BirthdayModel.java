package com.example.afrodita.personalinformationtest.mvp.birthday;


import java.util.Date;

public class BirthdayModel {

    String time;
    String description;

    public String getTimeString() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTime(){
        return new Date(Long.valueOf(time)*1000);
    }
}
