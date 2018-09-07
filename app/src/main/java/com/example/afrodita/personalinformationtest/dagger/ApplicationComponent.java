package com.example.afrodita.personalinformationtest.dagger;

import com.example.afrodita.personalinformationtest.mvp.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)

public interface ApplicationComponent {

    void inject(MainActivity mainActivity);

}
