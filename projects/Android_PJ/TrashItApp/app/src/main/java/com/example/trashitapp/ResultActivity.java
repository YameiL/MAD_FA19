package com.example.trashitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        TextView resultLabel = findViewById(R.id.resultLabel);
        TextView totalScoreLabel = findViewById(R.id.totalScoreLabel);


        int score = getIntent().getIntExtra("CORRECT_ANSWER_COUNT", 0);
        //resultLabel.setText(score + " / 6");
        resultLabel.setText(String.format(Locale.US,"%s%s",score," / 6"));
        //for the totall score that showing at the end
        SharedPreferences sharedPreferences = getSharedPreferences("QUIZ_DATA", Context.MODE_PRIVATE);
        int totalScore = sharedPreferences.getInt("TOTAL_SCORE",0);

        totalScore += score;

        //set the text for totalScoreLabel
        //totalScoreLabel.setText("Total Score: " + totalScore);
        //totalScoreLabel.setText(getString(R.string.totalscore, totalScore,"one more time?"));
        //String totalScoreNum = String.format("%02d",totalScore);
        //String totalScoreIs = String.format("%02d",getString(R.string.totalscore));

//valueToConvert.setText(String.format(Locale.US, "%s%s", currentValue, "3"));
        totalScoreLabel.setText(String.format(Locale.US,"%s%s","Total Score is : ", totalScore));


        // Update total score.
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("TOTAL_SCORE", totalScore);
        editor.apply();



    }



    public  void  returnBegin (View view){
        startActivity(new Intent(getApplicationContext(), ReturnBeginActivity.class)); //cal from the rrerturnbegin activity java file
    }





}



