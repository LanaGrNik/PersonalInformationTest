package com.example.afrodita.personalinformationtest.mvp.personalInfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.afrodita.personalinformationtest.MainApplication;
import com.example.afrodita.personalinformationtest.R;
import javax.inject.Inject;

public class PersonalInfoActivity extends AppCompatActivity  implements PersonalInfoContract.View{

    @Inject
    PersonalInfoPresenter presenter;

    TextView fullName;
    TextView date;
    TextView description;
    Button refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        ((MainApplication) getApplication()).getComponent().inject(this);
        fullName = findViewById(R.id.tvFullName);
        date = findViewById(R.id.tvDate);
        description = findViewById(R.id.tvDescription);
        refresh = findViewById(R.id.btnRefresh);
        presenter.onAttach(this);
        presenter.loadInformation();
        initClickListener();
    }

    @Override
    public void onDatesLoaded(PersonModel personModel) {
        fullName.setText(personModel.getName());
        date.setText(personModel.getBirthday());
        description.setText(personModel.getDescription());
    }

    @Override
    public void onError() {
        Toast.makeText(this,R.string.loading_error,Toast.LENGTH_SHORT).show();
    }

    public void initClickListener(){
      refresh.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              presenter.loadInformation();
          }
      });
    }
}
