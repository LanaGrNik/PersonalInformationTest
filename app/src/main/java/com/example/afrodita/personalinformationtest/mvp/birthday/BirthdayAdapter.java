package com.example.afrodita.personalinformationtest.mvp.birthday;

import android.content.Context;
import android.os.IInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.afrodita.personalinformationtest.R;

import java.util.ArrayList;
import java.util.List;

public class BirthdayAdapter extends BaseAdapter {

    Context context;
    LayoutInflater lInflater;
    List<BirthdayModel> list= new ArrayList<>();


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
        TextView time = view.findViewById(R.id.time);
        time.setText(birthdayModel.time);
        TextView description = view.findViewById(R.id.description);
        description.setText(birthdayModel.description);

        return view;
    }
}
