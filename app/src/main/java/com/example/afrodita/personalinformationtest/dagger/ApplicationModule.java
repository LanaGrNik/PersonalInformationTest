package com.example.afrodita.personalinformationtest.dagger;

import android.content.Context;

import com.example.afrodita.personalinformationtest.api.PersonalApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class ApplicationModule {

    Context context;

    public ApplicationModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    public PersonalApi providePersonalApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://murzinma.ru/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(PersonalApi.class);
    }

}
