package com.example.afrodita.personalinformationtest.mvp.birthday;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.example.afrodita.personalinformationtest.MainApplication;
import com.example.afrodita.personalinformationtest.R;
import javax.inject.Inject;

public class BirthdayActivity extends AppCompatActivity implements BirthdayContract.View {

    @Inject
    BirthdayPresenter presenter;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);
        ((MainApplication) getApplication()).getComponent().inject(this);
        mSwipeRefreshLayout = findViewById(R.id.swipe_container);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.loadDates();
            }
        });
        presenter.onAttach(this);
        presenter.loadDates();
    }

    @Override
    public void onDatesLoaded() {
        ViewPager viewPager = findViewById(R.id.view_pager);
        PagerAdapter pagerAdapter = new BirthdayPagerAdapter(this,getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onError() {
        mSwipeRefreshLayout.setRefreshing(false);
        Toast.makeText(this,R.string.loading_error,Toast.LENGTH_SHORT).show();
    }
}
