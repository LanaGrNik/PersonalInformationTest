package com.example.afrodita.personalinformationtest.mvp.personalInfo;

public interface PersonalInfoContract {
    interface View{
        void onDatesLoaded(PersonModel personModel);
        void onError();
    }
    interface Presenter{

        void onAttach(View view);

        void loadInformation();

    }
}
