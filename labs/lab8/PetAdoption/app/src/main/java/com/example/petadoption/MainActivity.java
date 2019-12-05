package com.example.petadoption;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Spinner typeSpinner;
    private  AdoptionPlace myAdoptionPlace = new AdoptionPlace();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get spinner
        typeSpinner = findViewById(R.id.spinner);

        //get button
        button = findViewById(R.id.button);

        //create Listener
        View.OnClickListener onclick = new View.OnClickListener(){
            public void onClick(View view){
                findPet(view);
            }
        };
        //add listener to button
        button.setOnClickListener(onclick);
    }

    private void findPet(View view){
        //get spinner item array position
        Integer type=typeSpinner.getSelectedItemPosition();
        //set the adoption place
        myAdoptionPlace.setAdoptionPlace(type);
        //get suggested adoption website and place
        String suggestedAdoptionPlace = myAdoptionPlace.getAdoptionPlace();
        String suggestedAdoptionPlaceURL = myAdoptionPlace.getAdoptionPlaceURL();

        Log.i("Place suggested", suggestedAdoptionPlace);
        Log.i("url suggested", suggestedAdoptionPlaceURL);

        // to create intent
        Intent intent = new Intent(this, FindActivity.class);
        //passing data
        intent.putExtra("adoptionPlaceName",suggestedAdoptionPlace);
        intent.putExtra("adoptionPlaceURL",suggestedAdoptionPlaceURL);
        //starting the intent
        startActivity(intent);


    }
}
