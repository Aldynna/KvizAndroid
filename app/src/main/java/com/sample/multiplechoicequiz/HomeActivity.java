package com.sample.multiplechoicequiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class HomeActivity extends AppCompatActivity {

    private ImageButton mBos;
    private ImageButton mEng;
    private String jezik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        mBos=(ImageButton)findViewById(R.id.bosb);
        mEng=(ImageButton)findViewById(R.id.engb);
        mBos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent PrvaB=new Intent(HomeActivity.this, PrvaActivity.class);
                // PrvaB.putExtra("jezik","bos");
                //startActivity(PrvaB);
                jezik="bos";
                Start(jezik);
            }
        });
        mEng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent PrvaB=new Intent(HomeActivity.this, PrvaActivity.class);
                // PrvaB.putExtra("jezik","eng");
                // startActivity(PrvaB);
                jezik="eng";
                Start(jezik);

            }
        });



    }
    private void Start(String jez)
    {
        Intent Prva=new Intent(HomeActivity.this, MeniActivity.class);
        Prva.putExtra("jezik",jez);
        startActivity(Prva);
    }
}
