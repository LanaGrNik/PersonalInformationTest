package com.example.afrodita.personalinformationtest.mvp.main;

public interface MainContract {
    interface View{
        void onLoadedArticle(PersonModel personModel);
    }
    interface Presenter{

        void onAttach(View view);

        void loadInformation();

    }
}
