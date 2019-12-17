package com.example.finalburrito;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class BurritoActivity extends AppCompatActivity {


    private String burritoShop;
    private String burritoShopURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burrito);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadWebSite(view);
            }
        });
        // here is receiving data

        Intent intent = getIntent();
        burritoShop = intent.getStringExtra("burritoShop");
        burritoShopURL = intent.getStringExtra("burritoShopURL");
        Log.i("shop received", burritoShop);
        Log.i("url received", burritoShopURL);



        //update text view (id. coffeeShopTextView
        TextView messageView = findViewById(R.id.burritoShopTextV);
        messageView.setText("You should check out " + burritoShop);
    }

    // do something with the FAB

    //implement a method to load a web page
    private void loadWebSite(View view){
        Intent intent = new Intent((Intent.ACTION_VIEW));
        intent.setData(Uri.parse(burritoShopURL));
        //Uri.parse() parses the string passed to it and creates a Uri objectt.
        //A Uri object is an immutable reference to a resource or data
        startActivity(intent);
    }

}
