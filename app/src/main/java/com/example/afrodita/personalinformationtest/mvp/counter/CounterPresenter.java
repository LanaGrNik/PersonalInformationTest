package com.example.afrodita.personalinformationtest.mvp.counter;

import com.example.afrodita.personalinformationtest.api.MainApi;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CounterPresenter implements CounterContract.Presenter {

    CounterContract.View view;
    MainApi mainApi;

    @Inject
    public CounterPresenter(MainApi mainApi) {
        this.mainApi = mainApi;
    }

    @Override
    public void onAttach(CounterContract.View view) {
        this.view = view;
    }

    public void onLoadCount(int delta, ActionEnum action) {
        Call<CountResponse> counter = mainApi.counter(delta, action.getAction());
        counter.enqueue(new Callback<CountResponse>() {
            @Override
            public void onResponse(Call<CountResponse> call, Response<CountResponse> response) {
                CountResponse count = response.body();
                if (count == null) {
                    view.onError();
                    return;
                }
                view.onLoadedCount(count);
            }

            @Override
            public void onFailure(Call<CountResponse> call, Throwable t) {
                t.printStackTrace();
                view.onError();
            }
        });
    }
}



