package com.example.afrodita.personalinformationtest.dagger;

import com.example.afrodita.personalinformationtest.mvp.birthday.BirthdayActivity;
import com.example.afrodita.personalinformationtest.mvp.bithdaylist.BirthdayListFragment;
import com.example.afrodita.personalinformationtest.mvp.personalInfo.PersonalInfoActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)

public interface ApplicationComponent {

    void inject(PersonalInfoActivity personalInfoActivity);
    void inject(BirthdayActivity birthdayActivity);
    void inject(BirthdayListFragment birthdayListFragment);

}
