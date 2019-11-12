package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.view.View;
import android.widget.ToggleButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Spinner;
import android.widget.RadioGroup;
import android.widget.CheckBox;




import android.os.Bundle;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private ToggleButton toggle;
    private Spinner houseType;
    private RadioGroup cost;
    private TextView houseSelection;
    private CheckBox singleCheckBox;
    private CheckBox oneCheckBox;
    private CheckBox twoCheckBox;
    private CheckBox threeCheckBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // view once the app is loaded
        toggle = findViewById(R.id.toggleButton);
        houseType = findViewById(R.id.spinner);
        cost = findViewById(R.id.radioGroup);

        houseSelection = findViewById(R.id.houseTextView);
        singleCheckBox = findViewById(R.id.checkBox);
        oneCheckBox = findViewById(R.id.checkBox2);
        twoCheckBox = findViewById(R.id.checkBox3);
        threeCheckBox = findViewById(R.id.checkBox4);

    }

    public void findPlace(View view) {

        //for toggle button
        boolean schoolYear = toggle.isChecked();

        //
        String perfectHouseMatch = null;
        //for the spinner
        String houseTypeT = String.valueOf(houseType.getSelectedItemId());
        //radio group
        int cost_id = cost.getCheckedRadioButtonId();//getCheckedRadioButtonID() returns the id of the radio button picked
        //-1 is returned if no buttoon is selectted


        //check boxes
        Boolean singleBedroom = singleCheckBox.isChecked();
        Boolean twoBedroom = oneCheckBox.isChecked();
        Boolean threeBedroom = twoCheckBox.isChecked();
        Boolean fourbedrooml = threeCheckBox.isChecked();

        //houseSelection.setText(perfectHouseMatch + " is the perfect place to live for you!");
//
        
        if (cost_id == -1) {
            //toast
            Context context = getApplicationContext();
            CharSequence text = " Please select your cost level";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            
        } else {
            //houseSelection.setText(perfectHouseMatch + " is the perfect place to live for you!");
            if (schoolYear) {//not freshman
                if (cost_id == R.id.radioButton3) {
                    //houseSelection.setText(perfectHouseMatch + " is the perfect place to live for you!");
                    switch (houseTypeT) {
                        case "Dorms":
                            perfectHouseMatch = "Bear Creek Apartment";
                            break;
                        case "OffCampusApartments":
                            perfectHouseMatch = "U club";
                            break;
                        case "OffCampusHouses":
                            perfectHouseMatch = "Table Messa nabourhood";
                            break;
                        default:
                            perfectHouseMatch = "Bear Creek Apartment";
                           // houseSelection.setText(perfectHouseMatch + " is the perfect place to live for you!");
                    }
                } else if (cost_id == R.id.radioButton) {
                    if (singleBedroom) {

                        perfectHouseMatch = "29th street";
                    } else if (twoBedroom){
                        perfectHouseMatch = "950 apartment";
                    }else{
                        perfectHouseMatch = "29th, 950, 970 etc.";
                    }
                }
            }else {//freshman
                    perfectHouseMatch = "Dorm";
                }
            houseSelection.setText(perfectHouseMatch + " is the perfect place to live for you!");  
            }
        }
    }


