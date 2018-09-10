package com.example.afrodita.personalinformationtest.mvp.counter;

import com.example.afrodita.personalinformationtest.mvp.personalInfo.PersonModel;
import com.example.afrodita.personalinformationtest.mvp.personalInfo.PersonalInfoContract;

public interface CounterContract {

    interface View{
        void onLoadedCount(CountResponse count);
        void onError();
    }
    interface Presenter{

        void onAttach(View view);
        void onLoadCount(int delta, ActionEnum action);
    }
}
