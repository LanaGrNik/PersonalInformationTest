package com.example.afrodita.personalinformationtest.api;


import com.example.afrodita.personalinformationtest.mvp.main.PersonModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PersonalApi {

   @GET("api/people.php")
   Call<PersonModel> getMainInformation();
}
