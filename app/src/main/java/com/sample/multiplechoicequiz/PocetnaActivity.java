package com.sample.multiplechoicequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PocetnaActivity extends AppCompatActivity {


    private Button mStart;
    private Button mPokreni;
    private EditText mImee;
    private TextView mTekst;
    private String mNick;
    private String mJezik;
    private String mPoruka="Unesite ime!";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pocetna);
        Intent nadjijezik=getIntent();
        mJezik=nadjijezik.getStringExtra("jezik");

        mImee= (EditText)findViewById(R.id.ime);
        mPokreni=(Button)findViewById(R.id.pokreni);
        mTekst=(TextView)findViewById(R.id.tekst);
        if(mJezik.equals("eng"))
        {
            mTekst.setText("Enter your name: ");
            mPokreni.setText("START QUIZ");
            mPoruka="Please,enter your name!";


        }
        mPokreni.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v){
                // QuizActivity.glavna.finish();
if(mImee.getText().toString().equals("")){

    Toast.makeText(PocetnaActivity.this, mPoruka, Toast.LENGTH_SHORT).show();
} else {

    Intent pocetak = new Intent(PocetnaActivity.this, QuizActivity.class);
    pocetak.putExtra("nick", mImee.getText().toString());//treba keyword i vrijednost njena, da mozemo pozivati
    pocetak.putExtra("jezik",mJezik);
    setResult(RESULT_OK, pocetak);

    startActivity(pocetak);

}
            }
        });


    }
}
