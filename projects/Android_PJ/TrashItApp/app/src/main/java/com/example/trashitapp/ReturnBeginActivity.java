package com.example.trashitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class ReturnBeginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return_begin);
    }

    public void startQuiz(View view){
        //Spinner spinner = findViewById(R.id.quizCate);
        //int quizCategory = spinner.getSelectedItemPosition();

        // Start Quiz
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        //intent.putExtra("QUIZ_CATEGORY", quizCategory);
        startActivity(intent);


    }
}
