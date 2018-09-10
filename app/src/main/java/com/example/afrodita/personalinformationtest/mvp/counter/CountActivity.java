package com.example.afrodita.personalinformationtest.mvp.counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.example.afrodita.personalinformationtest.MainApplication;
import com.example.afrodita.personalinformationtest.R;
import java.util.Timer;
import java.util.TimerTask;
import javax.inject.Inject;

public class CountActivity extends AppCompatActivity implements CounterContract.View, OnClickListener {

    @Inject
    CounterPresenter presenter;
    TextView counter;
    Button increment;
    Button decrement;
    int delta;
    ActionEnum action = ActionEnum.INCREMENT;
    public TimerTask timerTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);
        ((MainApplication) getApplication()).getComponent().inject(this);

        counter = findViewById(R.id.tvCounter);
        increment = findViewById(R.id.btnIncrement);
        decrement = findViewById(R.id.btnDecrement);
        presenter.onAttach(this);
        increment.setOnClickListener(this);
        decrement.setOnClickListener(this);
        Timer timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                delta = Math.abs(delta);
                presenter.onLoadCount(delta,action);
                delta = 0;
            }

        };
        timer.schedule(timerTask, 0,1000);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnIncrement:
                delta++;
                action = ActionEnum.INCREMENT;
                break;
            case R.id.btnDecrement:
                delta--;
                action = ActionEnum.DECREMENT;
                break;
        }
    }

    public void onLoadedCount(CountResponse count) {

        counter.setText(String.valueOf(count.getValue()));


    }

    @Override
    public void onError() {
        Toast.makeText(this,R.string.loading_error,Toast.LENGTH_SHORT).show();
    }


}
