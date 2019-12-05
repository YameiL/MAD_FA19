package com.example.petadoption;

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

public class FindActivity extends AppCompatActivity {
    private String adoptionPlace;
    private String adoptionPlaceURL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadWebSite(view);
            }
        });
        Intent intent = getIntent();
        adoptionPlace = intent.getStringExtra("adoptionPlaceName");
        adoptionPlaceURL = intent.getStringExtra("adoptionPlaceURL");

        Log.i("place received", adoptionPlace);
        Log.i("url received", adoptionPlaceURL);

        //update text view
        TextView messageView = findViewById(R.id.adoptionPlaceTextView);
        messageView.setText("You should check out " + adoptionPlace);
    }

    private void loadWebSite(View view){
        Intent intent = new Intent((Intent.ACTION_VIEW));
        intent.setData(Uri.parse(adoptionPlaceURL));
        startActivity(intent);
    }

}
