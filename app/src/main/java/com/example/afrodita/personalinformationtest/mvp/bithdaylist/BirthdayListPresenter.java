package com.example.afrodita.personalinformationtest.mvp.bithdaylist;

import com.example.afrodita.personalinformationtest.mvp.birthday.BirthdayModel;
import com.example.afrodita.personalinformationtest.mvp.birthday.BirthdayRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class BirthdayListPresenter implements BirthdayListContract.Presenter {

    BirthdayListContract.View view;
    BirthdayRepository birthdayRepository;

    @Inject
    public BirthdayListPresenter(BirthdayRepository birthdayRepository) {
        this.birthdayRepository = birthdayRepository;
    }

    @Override
    public void onAttach(BirthdayListContract.View view) {
        this.view = view;

    }

    @Override
    public void loadDates(int position) {
        List<BirthdayModel> dateList = new ArrayList<BirthdayModel>();
        if (position == 0) {
            dateList.addAll(birthdayRepository.getPastList());
        } else {
            dateList.addAll(birthdayRepository.getFutureList());
        }
        view.dates(dateList);


    }
}