package com.sample.multiplechoicequiz;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class InstrukcijeActivity extends AppCompatActivity {

    ViewPager mViewPager;
    SwipeActivity mAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_swipe);

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mAdaptor = new SwipeActivity(this);
        mViewPager.setAdapter(mAdaptor);
    }
}
