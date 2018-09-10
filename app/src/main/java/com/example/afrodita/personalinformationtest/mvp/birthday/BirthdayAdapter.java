package com.example.afrodita.personalinformationtest.mvp.birthday;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.afrodita.personalinformationtest.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class BirthdayAdapter extends BaseAdapter {

    Context context;
    LayoutInflater lInflater;
    List<BirthdayModel> list = new ArrayList<>();
    long diffSeconds;
    long diffMinutes;
    long diffHours;
    long diffDays;
    long timeUp;
    long diff;


    public BirthdayAdapter(Context context, List<BirthdayModel> list) {
        this.context = context;
        this.list.addAll(list);
        lInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public BirthdayModel getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        BirthdayModel birthdayModel = getItem(i);
        view = lInflater.inflate(R.layout.list_birthday, parent, false);
        timeUp = birthdayModel.getTime().getTime();
        /*Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

            }
        };*/
        TextView time = view.findViewById(R.id.time);
        onTimeConverter(diffSeconds,diffMinutes,diffHours,diffDays);
        time.setText(diffDays + ":" + diffHours + ":" + diffMinutes + ":" + diffSeconds);
      //  timer.schedule(timerTask, 0,1000);
        TextView description = view.findViewById(R.id.description);
        description.setText(birthdayModel.description);

        return view;
    }

    public void onTimeConverter(long seconds,long minutes,long hours,long days){
        if (System.currentTimeMillis()> timeUp) {
           diff = System.currentTimeMillis() - timeUp;}
        else
        { diff = timeUp - System.currentTimeMillis(); }

        diffSeconds = diff / 1000 % 60;
        diffMinutes = diff / (60 * 1000) % 60;
        diffHours = diff / (60 * 60 * 1000) % 24;
        diffDays = diff / (24 * 60 * 60 * 1000);
        diffDays = onReturnDiffDays(diffDays);
    }

    public long onReturnDiffDays(long diffDays) {
        if (diffDays > 99) {
            diffDays = onReturnDiffDays(diffDays / 10);
        }
        return diffDays;
    }
}
