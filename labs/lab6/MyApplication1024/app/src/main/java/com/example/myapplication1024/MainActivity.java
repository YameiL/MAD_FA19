package com.example.myapplication1024;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText name; // name editText  for future multiple time uses
    private String nameValue; // nameValue (string) for future multiple time uses
    private  TextView seasonText;// textView for future multiple time uses
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.editText);
        nameValue = name.getText().toString();
        seasonText = findViewById(R.id.message);
    }

    public void showSpring(View view) {
        //private
        //edit text
        //EditText name = findViewById(R.id.editText);
        //String nameValue = name.getText().toString();
        //text view
       // TextView seasonText = findViewById(R.id.message);
        seasonText.setText(nameValue + " loves Spring!");
        ImageView spring = findViewById(R.id.imageView);
        spring.setImageResource(R.drawable.sakura);

    }

    public void showSummer(View view) {
        //edit text
        //EditText name = findViewById(R.id.editText);
        //String nameValue = name.getText().toString();
        //text view
        //TextView seasonText = findViewById(R.id.message);

        seasonText.setText(nameValue + " loves Summer!");
        ImageView summer = findViewById(R.id.imageView);
        summer.setImageResource(R.drawable.sunumbrella);
    }

    public void showFall(View view) {
        //edit text
       // EditText name = findViewById(R.id.editText);
        //String nameValue = name.getText().toString();
        //text view
        //TextView seasonText = findViewById(R.id.message);

        seasonText.setText(nameValue + " loves Fall!");
        ImageView fall = findViewById(R.id.imageView);
        fall.setImageResource(R.drawable.leaves);
    }

    public void showWinter(View view) {
        //edit text
        //EditText name = findViewById(R.id.editText);
       // String nameValue = name.getText().toString();
        //text view
       // TextView seasonText = findViewById(R.id.message);

        seasonText.setText(nameValue + " loves Winter!");
        //to show winter image
        ImageView winter = findViewById(R.id.imageView);
        winter.setImageResource(R.drawable.snowflake);

    }
}
