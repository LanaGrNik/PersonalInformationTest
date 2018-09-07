package com.example.afrodita.personalinformationtest.mvp.main;


import com.example.afrodita.personalinformationtest.api.PersonalApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.inject.Inject;

public class MainPresenter implements MainContract.Presenter {

    MainContract.View view;
    PersonalApi personalApi;

    @Inject
    MainPresenter(PersonalApi personalApi){
        this.personalApi = personalApi;

    }

    @Override
    public void onAttach(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void loadInformation() {

        Call<PersonModel> getMainInformation = personalApi.getMainInformation();
        getMainInformation.enqueue(new Callback<PersonModel>() {
            @Override
            public void onResponse(Call<PersonModel> call, Response<PersonModel> response) {
                PersonModel personModel = response.body();
                if (personModel == null){
                    view.onError();
                    return;
                }
                view.onLoadedArticle(personModel);
            }

            @Override
            public void onFailure(Call<PersonModel> call, Throwable t) {
                t.printStackTrace();
                view.onError();
            }
        });
    }
}
