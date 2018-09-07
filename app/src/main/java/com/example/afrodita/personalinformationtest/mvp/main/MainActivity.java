package com.example.afrodita.personalinformationtest.mvp.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.afrodita.personalinformationtest.PersonalInformationApplication;
import com.example.afrodita.personalinformationtest.R;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity  implements MainContract.View{

    @Inject
    MainPresenter presenter;

    TextView fullName;
    TextView date;
    TextView description;
    Button refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((PersonalInformationApplication) getApplication()).getComponent().inject(this);
        fullName = findViewById(R.id.tvFullName);
        date = findViewById(R.id.tvDate);
        description = findViewById(R.id.tvDescription);
        refresh = findViewById(R.id.btnRefresh);
        presenter.onAttach(this);
        presenter.loadInformation();
    }

    @Override
    public void onLoadedArticle(PersonModel personModel) {
         fullName.setText(personModel.getName());
         date.setText(personModel.getBirthday());
         description.setText(personModel.getDescription());
    }
}