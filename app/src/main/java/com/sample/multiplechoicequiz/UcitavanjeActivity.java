package com.sample.multiplechoicequiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class UcitavanjeActivity extends AppCompatActivity {



    private TextView mBrojac;
    private CountDownTimer mBrojim;
    private int postotak=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent jeLiKraj=getIntent();
        boolean kraj=jeLiKraj.getBooleanExtra("Exit me",false);
        if(kraj)
        // if( getIntent().getBooleanExtra("Exit me", false))
        {
            finish();
            return; // add this to prevent from doing unnecessary stuffs
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ucitavanje);
        mBrojac=(TextView)findViewById(R.id.postotak);
        mBrojim=new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {

                mBrojac.setText(""+postotak+"%");
                postotak=postotak+10;

            }

            public void onFinish() {
                mBrojac.setText("Dobrodošli!/Welcome!");

                    Intent intent = new Intent(UcitavanjeActivity.this, HomeActivity.class);

                    startActivity(intent);



            }
        }.start();



    }
}
