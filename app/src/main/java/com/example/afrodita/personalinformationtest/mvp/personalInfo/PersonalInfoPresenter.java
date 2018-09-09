package com.example.afrodita.personalinformationtest.mvp.personalInfo;


import com.example.afrodita.personalinformationtest.api.MainApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.inject.Inject;

public class PersonalInfoPresenter implements PersonalInfoContract.Presenter {

    PersonalInfoContract.View view;
    MainApi mainApi;

    @Inject
    PersonalInfoPresenter(MainApi mainApi){
        this.mainApi = mainApi;

    }

    @Override
    public void onAttach(PersonalInfoContract.View view) {
        this.view = view;
    }

    @Override
    public void loadInformation() {

        Call<PersonModel> getMainInformation = mainApi.getMainInformation();
        getMainInformation.enqueue(new Callback<PersonModel>() {
            @Override
            public void onResponse(Call<PersonModel> call, Response<PersonModel> response) {
                PersonModel personModel = response.body();
                if (personModel == null){
                    view.onError();
                    return;
                }
                view.onDatesLoaded(personModel);
            }

            @Override
            public void onFailure(Call<PersonModel> call, Throwable t) {
                t.printStackTrace();
                view.onError();
            }
        });
    }
}
