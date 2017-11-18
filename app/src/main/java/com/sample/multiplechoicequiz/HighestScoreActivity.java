package com.sample.multiplechoicequiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class HighestScoreActivity extends AppCompatActivity {

    private Button mEButton;
    private Button mAButton;
    private Button mNButton;
    private RatingBar mSkor;
    private PitanjaActivity mQuestionLibrary = new PitanjaActivity();
    private int mMax;
    private float mKoraci;
    private String mJezik;
    private int mIzbor=0;
    private String Ime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highest_score);
        Intent nadjijezik=getIntent();
        mJezik=nadjijezik.getStringExtra("jezik");
        if(mJezik.equals("eng")){
            mIzbor=1;
        }
        mMax=mQuestionLibrary.getLength(mIzbor);
        mKoraci=5/mMax;
        Intent nadjiime=getIntent();
        Ime=nadjiime.getStringExtra("nick");



        TextView txtScore = (TextView) findViewById(R.id.textScore);
        TextView txtHighScore = (TextView) findViewById(R.id.textHighScore);
        // receive the score from last activity by Intent
        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);
        // display current score

        if(mJezik.equals("eng")) {
            txtScore.setText("Your score: " + score);
        } else
        {
            txtScore.setText("Vase ime je\n MUSTAFA  ");
        }
        mSkor=(RatingBar)findViewById(R.id.zvjezdice);
        mSkor.setStepSize(mKoraci);
        mSkor.setRating(score);

        // use Shared preferences to save the best score
        SharedPreferences mypref = getPreferences(MODE_PRIVATE);
        int highscore = mypref.getInt("highscore",0);
        if(highscore>= score)
            txtHighScore.setText("High score: "+highscore);
        else
        {
            if(mJezik.equals("eng")){
                txtHighScore.setText("New highscore: " + score);
            } else
            {
                txtHighScore.setText("Novi highscore: " + score);
            }
            SharedPreferences.Editor editor = mypref.edit();
            editor.putInt("highscore", score);
            editor.commit();
        }

        mEButton = (Button)findViewById(R.id.ebutton);
        mAButton = (Button)findViewById(R.id.button);
        mNButton = (Button)findViewById(R.id.newbutton);
        if(mJezik.equals("eng")) {
            mEButton.setText("EXIT");
            mAButton.setText("TRY AGAIN");
            mNButton.setText("NEW PLAYER!");


        }
        mEButton.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v){
                Intent kraj = new Intent(HighestScoreActivity.this, UcitavanjeActivity.class);
                kraj.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                kraj.putExtra("Exit me", true);
                startActivity(kraj);
                finish();
                return;

            }
        });

        mAButton.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v){
                Intent intent = new Intent(HighestScoreActivity.this, QuizActivity.class);
                intent.putExtra("nick",Ime);
                intent.putExtra("jezik",mJezik);
                startActivity(intent);

            }
        });


        mNButton.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v){
                Intent intent = new Intent(HighestScoreActivity.this, HomeActivity.class);
                intent.putExtra("nick",Ime);
                intent.putExtra("jezik",mJezik);
                startActivity(intent);

            }
        });
    }


   /* public void onClick(View view) {
        Intent intent = new Intent(HighestScoreActivity.this, QuizActivity.class);
        startActivity(intent);
    }*/
}

