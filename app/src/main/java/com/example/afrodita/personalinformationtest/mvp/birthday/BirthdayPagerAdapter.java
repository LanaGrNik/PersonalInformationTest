package com.example.afrodita.personalinformationtest.mvp.birthday;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.example.afrodita.personalinformationtest.R;
import com.example.afrodita.personalinformationtest.mvp.bithdaylist.BirthdayListFragment;

public class BirthdayPagerAdapter extends FragmentPagerAdapter {

    Context context;

    public BirthdayPagerAdapter(Context context, FragmentManager fm){
        super(fm);
        this.context = context;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: return getString(R.string.past);
            default: return getString(R.string.future);
        }
    }

    private CharSequence getString(int str) {
        return context.getString(str);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new BirthdayListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
