package com.example.afrodita.personalinformationtest.mvp.birthday;

import com.example.afrodita.personalinformationtest.mvp.personalInfo.PersonModel;

import java.util.ArrayList;

public interface BirthdayContract {
    interface View{
        void onDatesLoaded();
        void onError();
    }
    interface Presenter{

        void onAttach(View view);

        void loadDates();

    }
}
