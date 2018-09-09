package com.example.afrodita.personalinformationtest.mvp.bithdaylist;


import com.example.afrodita.personalinformationtest.mvp.birthday.BirthdayModel;

import java.util.List;

public interface BirthdayListContract {

    interface View{
        void dates(List<BirthdayModel> datesList);
        void onError();
    }
    interface Presenter{

        void onAttach(View view);

        void loadDates(int position);

    }
}
