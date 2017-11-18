package com.sample.multiplechoicequiz;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private PitanjaActivity mQuestionLibrary = new PitanjaActivity();
    private TextView mScoreView;   // view for current total score
    private TextView mQuestionView;
    //current question to answer
    private Button mButtonChoice1; // multiple choice 1 for mQuestionView
    private Button mButtonChoice2; // multiple choice 2 for mQuestionView
    private Button mButtonChoice3; // multiple choice 3 for mQuestionView
    private Button mButtonChoice4; // multiple choice 4 for mQuestionView
    public static Activity glavna;
    private TextView mPostavi;
    private TextView mBrojac;
    private CountDownTimer mBrojim;
    private int zvijezda;
    private String mJezik;
    String Ime;
    private int mIzbor=0;// pocetno pitanje
    private Button mPomoc;
    private int naziv=0;
    private static final String KEY_INDEX = "index";
    private static final String KEY_INDEX2= "index2";
    private String mAnswer;  // correct answer for question in mQuestionView
    private int mScore = 0;  // current total score
    private int mGreske=5;
    private int mQuestionNumber = 0; // current question number
private RatingBar mRatingBar;
    private ProgressBar mProgres;
    private long BBrojac=20000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        glavna=this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        if (savedInstanceState != null) {
            mQuestionNumber = savedInstanceState.getInt(KEY_INDEX, 0);
            mQuestionNumber--;
            BBrojac=savedInstanceState.getLong(KEY_INDEX2, 20000);
            BBrojac=BBrojac-1000;


        }
        Intent nadjijezik=getIntent();
        mJezik=nadjijezik.getStringExtra("jezik");
mPomoc=(Button)findViewById(R.id.pomoc);
        if(mJezik.equals("eng")) {
            mIzbor=1;
            mPomoc.setText("Hint");

        }
        // setup screen for the first question with four alternative to
        mProgres=(ProgressBar)findViewById(R.id.progres);
        mProgres.setMax(mQuestionLibrary.getLength(mIzbor));
       // mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        mButtonChoice2 = (Button)findViewById(R.id.choice2);
        mButtonChoice3 = (Button)findViewById(R.id.choice3);
        mButtonChoice4 = (Button)findViewById(R.id.choice4);
        updateQuestion();
        Intent nadjiime=getIntent();
        Ime=nadjiime.getStringExtra("nick");
        mPostavi=(TextView)findViewById(R.id.sretno);
        mPostavi.setText(""+Ime);
        mRatingBar=(RatingBar)findViewById(R.id.zivoti);
        mRatingBar.setRating(5);

       mPomoc.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v){
                if(mButtonChoice1.getText()==mAnswer) mButtonChoice1.setBackgroundColor(Color.GREEN);
                    else if(mButtonChoice2.getText()==mAnswer) mButtonChoice2.setBackgroundColor(Color.GREEN);
                        else if(mButtonChoice3.getText()==mAnswer) mButtonChoice3.setBackgroundColor(Color.GREEN);
                            else if(mButtonChoice1.getText()==mAnswer) mButtonChoice4.setBackgroundColor(Color.GREEN);

            }
        });
        // show current total score for the user
       // updateScore(mScore);



    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt(KEY_INDEX, mQuestionNumber);
        savedInstanceState.putLong(KEY_INDEX2, BBrojac);

    }

    private void updateQuestion(){
        // check if we are not outside array bounds for questions
        if(mQuestionNumber > 0) naziv = 1000;
        CountDownTimer count=new CountDownTimer(naziv, 1000) {

            public void onTick(long millisUntilFinished) {


            }

            public void onFinish() {

                if(mQuestionNumber<mQuestionLibrary.getLength(mIzbor) ){
                    mProgres.setProgress(mQuestionNumber);
                    // set the text for new question, and new 4 alternative to answer on four buttons
                    mQuestionView.setText(mQuestionLibrary.getQuestion(mIzbor,mQuestionNumber));

                    mButtonChoice1.setText(mQuestionLibrary.getChoice(mIzbor,mQuestionNumber, 1));
                    mButtonChoice1.setBackgroundColor(Color.rgb(145,223,214));
                    mButtonChoice2.setText(mQuestionLibrary.getChoice(mIzbor,mQuestionNumber, 2));
                    mButtonChoice2.setBackgroundColor(Color.rgb(249,178,51));
                    mButtonChoice3.setText(mQuestionLibrary.getChoice(mIzbor,mQuestionNumber, 3));
                    mButtonChoice3.setBackgroundColor(Color.rgb(238,189,48));
                    mButtonChoice4.setText(mQuestionLibrary.getChoice(mIzbor,mQuestionNumber,4));
                    mButtonChoice4.setBackgroundColor(Color.rgb(255,93,153));
                    mAnswer = mQuestionLibrary.getCorrectAnswer(mIzbor,mQuestionNumber);
                    mQuestionNumber++;
                    mBrojac=(TextView)findViewById(R.id.brojac);
                    mBrojac.setText("20");
                    mBrojim=new CountDownTimer(BBrojac, 1000) {

                        public void onTick(long millisUntilFinished) {

                            mBrojac.setText(""+millisUntilFinished / 1000);
                            BBrojac=millisUntilFinished;
                        }

                        public void onFinish() {
                            BBrojac=20000;
                            mBrojac.setText("Isteklo je vrijeme!");
                            Toast.makeText(QuizActivity.this, "Isteklo je vrijeme za odgovor!Tacan odgovor je mAnswer", Toast.LENGTH_SHORT).show();
                            mRatingBar.setRating(mGreske);
                            if(mGreske==0)
                            {

                                Toast.makeText(QuizActivity.this, "Ops! Zao nam je,nemate vise zivota!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(QuizActivity.this, HighestScoreActivity.class);
                                intent.putExtra("score", mScore); // pass the current score to the second screen
                                intent.putExtra("nick",Ime);
                                intent.putExtra("jezik",mJezik);
                                startActivity(intent);
                            }
                            mGreske--;
                            mRatingBar.setRating(mGreske);
                            updateQuestion();

                        }
                    }.start();
                }
                else {
                    Toast.makeText(QuizActivity.this, "Cestitamo, kviz je uspjesno zavrsen!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(QuizActivity.this, HighestScoreActivity.class);
                    intent.putExtra("score", mScore); // pass the current score to the second screen
                    intent.putExtra("nick",Ime);
                    intent.putExtra("jezik",mJezik);
                    startActivity(intent);
                }

            }
        }.start();

    }

    // show current total score for the user
    /*private void updateScore(int point) {
        mScoreView.setText("" + mScore+"/"+mQuestionLibrary.getLength(mIzbor));
    }*/

    public void onClick(View view) {

        //all logic for all answers buttons in one method
       if(mBrojim!=null)
       {
           BBrojac=20000;
           mBrojim.cancel();
           mBrojim=null;
       }
        Button answer = (Button) view;
        // if the answer is correct, increase the score
        if (answer.getText() == mAnswer){
            answer.setBackgroundColor(Color.GREEN);

            mScore = mScore + 1;
            if(mJezik.equals("bos"))
             Toast.makeText(QuizActivity.this, "Bravo,idemo dalje!", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(QuizActivity.this, "Good job!", Toast.LENGTH_SHORT).show();

        }else {
            answer.setBackgroundColor(Color.RED);
            if(mGreske==0)
            {

                if(mJezik.equals("bos"))
                Toast.makeText(QuizActivity.this, "Ops! Zao nam je,nemate vise zivota!", Toast.LENGTH_SHORT).show();
                else  Toast.makeText(QuizActivity.this, "Wrong! No more lifes", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(QuizActivity.this, HighestScoreActivity.class);
                intent.putExtra("score", mScore); // pass the current score to the second screen
                intent.putExtra("nick",Ime);
                intent.putExtra("jezik",mJezik);
                startActivity(intent);
            }


            mGreske--;
            mRatingBar.setRating(mGreske);
            String poruka;
            if(mJezik.equals("bos")) poruka="Pogresno! Tacan odgovor je "+mAnswer;
            else poruka="WRONG! Correct answer is "+mAnswer;
            Toast.makeText(QuizActivity.this, poruka, Toast.LENGTH_SHORT).show();
        }
        // show current total score for the user
       // updateScore(mScore);
        // once user answer the question, we move on to the next one, if any
        updateQuestion();
    }

 }