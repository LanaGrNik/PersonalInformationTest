package com.example.afrodita.personalinformationtest;

import android.app.Application;

import com.example.afrodita.personalinformationtest.dagger.ApplicationComponent;
import com.example.afrodita.personalinformationtest.dagger.ApplicationModule;
import com.example.afrodita.personalinformationtest.dagger.DaggerApplicationComponent;

public class PersonalInformationApplication extends Application {

    ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
