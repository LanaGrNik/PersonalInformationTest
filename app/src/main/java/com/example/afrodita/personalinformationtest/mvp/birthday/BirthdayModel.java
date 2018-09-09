package com.example.afrodita.personalinformationtest.mvp.birthday;

import java.sql.Time;
import java.text.DateFormat;
import java.util.Date;

public class BirthdayModel {

    String time;
    String description;

    public String getTime() {
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
}
