package com.example.afrodita.personalinformationtest.mvp.main;

public interface MainContract {
    interface View{
        void onLoadedArticle(PersonModel personModel);
        void onError();
    }
    interface Presenter{

        void onAttach(View view);

        void loadInformation();

    }
}
