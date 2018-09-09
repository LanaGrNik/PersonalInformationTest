package com.example.afrodita.personalinformationtest.mvp.birthday;


import com.example.afrodita.personalinformationtest.api.MainApi;
import com.example.afrodita.personalinformationtest.mvp.personalInfo.PersonalInfoContract;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BirthdayPresenter implements BirthdayContract.Presenter {


    BirthdayRepository birthdayRepository;
    BirthdayContract.View view;
    MainApi mainApi;

    @Inject
    BirthdayPresenter(MainApi mainApi, BirthdayRepository birthdayRepository){
        this.mainApi = mainApi;
        this.birthdayRepository = birthdayRepository;

    }

    @Override
    public void onAttach(BirthdayContract.View view) {
        this.view = view;
    }

    @Override
    public void loadDates() {
    final Call<DatesArrayModel> dates = mainApi.dates() ;

        dates.enqueue(new Callback<DatesArrayModel>() {
            @Override
            public void onResponse(Call<DatesArrayModel> call, Response<DatesArrayModel> response) {
                DatesArrayModel datesArrayModel = response.body();
                if (datesArrayModel == null){
                    view.onError();
                    return;
                }
                birthdayRepository.setDates(datesArrayModel);
                view.onDatesLoaded();

            }

            @Override
            public void onFailure(Call<DatesArrayModel> call, Throwable t) {
                t.printStackTrace();
                view.onError();
            }
        });
    }
}
