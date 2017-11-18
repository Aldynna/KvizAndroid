package com.sample.multiplechoicequiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MeniActivity extends AppCompatActivity {

    private ImageButton mZaigraj;
    private ImageButton mInstrukcije;
    private ImageButton mONama;
    private String mJezik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_prva);
        Intent nadjijezik=getIntent();
        mJezik=nadjijezik.getStringExtra("jezik");

        mZaigraj=(ImageButton)findViewById(R.id.imageButton);
        mInstrukcije=(ImageButton)findViewById(R.id.imageButton5);
        mONama=(ImageButton)findViewById(R.id.imageButton6);
        if(mJezik.equals("eng")) {


            mONama.setImageResource(R.drawable.aboutusbutton);
            mInstrukcije.setImageResource(R.drawable.howtoplaybutton);

        }
        mZaigraj.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                // QuizActivity.glavna.finish();
                Intent start = new Intent(MeniActivity.this, PocetnaActivity.class);
               start.putExtra("jezik",mJezik);
                startActivity(start);
            }
        });

        mInstrukcije.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                Intent instrukcije = new Intent(MeniActivity.this, InstrukcijeActivity.class);
                startActivity(instrukcije);
            }
        });

        mONama.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                Intent onama = new Intent(MeniActivity.this, ONamaActivity.class);
                onama.putExtra("jezik",mJezik);
                startActivity(onama);

            }
        });
    }
}
