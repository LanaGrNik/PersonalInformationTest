package com.example.afrodita.personalinformationtest.mvp.birthday;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class BirthdayRepository {

    DatesArrayModel dates;

    @Inject
    public BirthdayRepository() {
    }

    public List<BirthdayModel> getPastList(){
        return dates.getPast();
        }

    public List<BirthdayModel> getFutureList(){
        return dates.getFuture();
    }

    public void setDates(DatesArrayModel dates) {
        this.dates = dates;
    }
}
