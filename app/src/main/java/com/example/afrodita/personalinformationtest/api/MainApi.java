package com.example.afrodita.personalinformationtest.api;


import com.example.afrodita.personalinformationtest.mvp.birthday.BirthdayModel;
import com.example.afrodita.personalinformationtest.mvp.birthday.DatesArrayModel;
import com.example.afrodita.personalinformationtest.mvp.personalInfo.PersonModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MainApi {

   @GET("api/people.php")
   Call<PersonModel> getMainInformation();

   @GET("api/dates.php")
   Call<DatesArrayModel> dates();


}
