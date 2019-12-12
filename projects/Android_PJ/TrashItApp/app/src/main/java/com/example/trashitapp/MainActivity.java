package com.example.trashitapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView countLabel;
    private TextView scoreLabel;
    private TextView questionLabel;

    private Button answerButton1, answerButton2,answerButton3,answerButton4;

    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int questionNumCount = 1;

    static final private int QUIZ_COUNT = 6;

    ArrayList<ArrayList<String>> quizeArray = new ArrayList<>();

    //to receive question cate
    //int quizCategory = getIntent().getIntExtra("QUIZ_CATEGORY",0);

//    prrivate void setQuestionInfo(Integer qNum){
//       switch(qNum)
//    }
//    private void setQuestionInfo(Integer qNum){
//        switch (qNum){
//            case 0: //popular
//                coffeeShop="Starbucks";
//                coffeeShopURL="https://www.starbucks.com";
//                break;
//            case 1: //cycling
//                coffeeShop="Amante";
//                coffeeShopURL="http://www.amantecoffee.com";
//                break;
//            case 2: //hipster
//                coffeeShop="Ozo";
//                coffeeShopURL="https://ozocoffee.com";
//                break;
//            case 3: //tea
//                coffeeShop="Pekoe";
//                coffeeShopURL="http://www.pekoesiphouse.com";
//                break;
//            case 4: //hippie
//                coffeeShop="Trident";
//                coffeeShopURL="http://www.tridentcafe.com";
//                break;
//            default:
//                coffeeShop="none";
//                coffeeShopURL="https://www.google.com/search?q=boulder+coffee+shops&ie=utf-8&oe=utf-8";
//        }
//    }


    String quizeData[][] = {
            //type of trash, correct answer, choice 1, choice 2, choice 3
            {"Plastic water bottle", "RECYCLE", "LANDFILL", "COMPOST", "HAZARDOUS WASTE"},
            {"Apple", "COMPOST", "RECYCLE", "HAZARDOUS WASTE", "LANDFILL"},
            {"Batteries", "HAZARDOUS", "RECYCLE", "LANDFILL", "COMPOST"},
            {"UMC STARBUCKS HOT CUP", "COMPOST", "RECYCLE", "LANDFILL", "HAZARDOUS WASTE"},
            {"MEAT", "COMPOST", "RECYCLE", "HAZARDOUS WASTE", "LANDFILL"},
            {"COMPUTER", "HAZARDOUS", "RECYCLE", "COMPOST", "LANDFILL"},

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countLabel = findViewById(R.id.countLabel);
        questionLabel = findViewById(R.id.questionLabel);
        scoreLabel = findViewById(R.id.scoreLabel);
        answerButton1 = findViewById(R.id.answerButton1);
        answerButton2 = findViewById(R.id.answerButton2);
        answerButton3 = findViewById(R.id.answerButton3);
        answerButton4 = findViewById(R.id.answerButton4);

        //resultLabel.setText(String.format(Locale.US,"%s%s",score," / 6"));

        //to receive question cate
        int quizCategory = getIntent().getIntExtra("QUIZ_CATEGORY",0);

        Log.v("CATEGORY", quizCategory + "");

        // to create quizeArray from the previous quiz data
        //using a for loop to makesure the quiz not go over my quiz data set
        // if int i less than the length of my data set it could add one go to next question
        for (int i = 0; i < quizeData.length; i++){
            //Array
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizeData[i][0]);// question: Trash
            tmpArray.add(quizeData[i][1]);// the correct answer
            tmpArray.add(quizeData[i][2]);// choice 1


            tmpArray.add(quizeData[i][3]);// choice 2
            tmpArray.add(quizeData[i][4]);// choice 3

            //add the tmpArray to the quizArray
            quizeArray.add(tmpArray);

        }

        showNextQ();

    }
    //create the function of showing quize question

    public void  showNextQ(){
        //First need to upload the quiz number which is the quize counter

        //countLabel.setText("Q " + questionNumCount);
        // resultLabel.setText(String.format(Locale.US,"%s%s",score," / 6"));

        countLabel.setText(String.format(Locale.US,"%s%s", "Question", questionNumCount));
        //in order to make the quize question to pop up in random order
        //function for generate random number from 1 to quizeArray size - 1
        Random random = new Random();
        int randomNumber = random.nextInt(quizeArray.size());

        //pick one quizeQuestion set in the ArrayLiist
        ArrayList<String> quize = quizeArray.get(randomNumber);

        //set question which is the question Label and match the int (0) and right answer which match the int 1
        questionLabel.setText(quize.get(0));
        rightAnswer = quize.get(1);


        //to remove quize from quazie Array.



        //remove the Q and shuffle choice
        quize.remove(0);
        Collections.shuffle(quize);

        //set the button text
        answerButton1.setText(quize.get(0));
        answerButton2.setText(quize.get(1));
        answerButton3.setText(quize.get(2));
        answerButton4.setText(quize.get(3));



        //to remove quize from quazie Array.
        quizeArray.remove(randomNumber);



    }
    // to check answer & show Alert
    public void checkAnswer(View view){
        Button answerButton = findViewById(view.getId());
        String buttonText =  answerButton.getText().toString();

        //set the valuable alertTitle
        String alertTitle;
        if (buttonText.equals(rightAnswer)){//this case player chose the correct answer
            alertTitle = "Correct!";
            rightAnswerCount++;


        }else{//player chose the wrong answer
            alertTitle = "Wrong!";

        }

        scoreLabel.setText(String.format(Locale.US,"%s%s","your score is : ", rightAnswerCount));
        //alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Answer :"+ rightAnswer);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (questionNumCount == QUIZ_COUNT){
                    //show quiz result
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    intent.putExtra("CORRECT_ANSWER_COUNT", rightAnswerCount);
                    startActivity(intent);
                    //resultLabel.setText(String.format(Locale.US,"%s%s",score," / 6"));

                }else{
                    questionNumCount++;
                    showNextQ();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();




    }
}
