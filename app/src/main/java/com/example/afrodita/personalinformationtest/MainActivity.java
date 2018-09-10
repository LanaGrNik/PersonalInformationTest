package com.example.afrodita.personalinformationtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

import com.example.afrodita.personalinformationtest.mvp.birthday.BirthdayActivity;
import com.example.afrodita.personalinformationtest.mvp.counter.CountActivity;
import com.example.afrodita.personalinformationtest.mvp.personalInfo.PersonalInfoActivity;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button task1 = findViewById(R.id.task1);
        Button task2 = findViewById(R.id.task2);
        Button task3 = findViewById(R.id.task3);

        task1.setOnClickListener(this);
        task2.setOnClickListener(this);
        task3.setOnClickListener(this);


    }
    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.task1:
                Intent intent1 = new Intent(this, PersonalInfoActivity.class);
                startActivity(intent1);
                break;
            case R.id.task2:
                Intent intent2 = new Intent(this, BirthdayActivity.class);
                startActivity(intent2);
                break;
            case R.id.task3:
                Intent intent3 = new Intent(this, CountActivity.class);
                startActivity(intent3);
                break;
        }
    }

}
