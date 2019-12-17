package com.example.finalburrito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import javax.xml.transform.Templates;

public class MainActivity extends AppCompatActivity {
    private ToggleButton toggle;
    private RadioGroup type;
    private TextView burritoSelection;
    private Spinner street;
    private EditText name;
    private CheckBox salsaCheckBox;
    private CheckBox sourCreamCheckBox;
    private CheckBox CheeseCheckBox;
    private CheckBox GuacaCheckBox;
    private ImageView burritoPic;
    private Button button;

    private BurritoShop myBurritoShop = new BurritoShop();

    // ImageView ghost = findViewById(R.id.imageView);
//        ghost.setImageResource(R.drawable.cursorb);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.suggestionButton);
        street = findViewById(R.id.spinner);
        //create even listener
        View.OnClickListener onclick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findBurrito(v);
            }
        };
        //add listener to button
        button.setOnClickListener(onclick);


//get the views
        name = findViewById(R.id.editText);
        burritoSelection = findViewById(R.id.burritoTextView);
        toggle = findViewById(R.id.toggleButton);
        type = findViewById(R.id.radioGroup);

        salsaCheckBox = findViewById(R.id.checkBox1);
        sourCreamCheckBox = findViewById(R.id.checkBox2);
        CheeseCheckBox = findViewById(R.id.checkBox3);
        GuacaCheckBox = findViewById(R.id.checkBox4);

        burritoPic = findViewById(R.id.imageView);
    }


    public void buildBurrito(View view) {
        boolean MOrV = toggle.isChecked();
        String nameValue = name.getText().toString();
        String MVType = "";
        String BTType = "";

        String streetPlace = String.valueOf(street.getSelectedItem());


        //check boxes
        //check boxes
        Boolean salsa = salsaCheckBox.isChecked();
        Boolean sourCream = sourCreamCheckBox.isChecked();
        Boolean Cheese = CheeseCheckBox.isChecked();
        Boolean Guaca = GuacaCheckBox.isChecked();


        int type_id = type.getCheckedRadioButtonId();

        if (type_id == -1) {
            //for toast
            Context context = getApplicationContext();
            CharSequence text = "Please select burrito or taco";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            //toggle button below
            if (MOrV) {//MEAT
                MVType = "meat";
                if (type_id == R.id.radioButton1) {
                    BTType = "burrito";
                    burritoPic.setImageResource(R.drawable.burrito);
                } else {
                    BTType = "taco";
                    burritoPic.setImageResource(R.drawable.taco);
                }


            } else {//Veggie
                MVType = "Veggie";
                if (type_id == R.id.radioButton1) {
                    BTType = "burrito";
                    burritoPic.setImageResource(R.drawable.burrito);
                } else {
                    BTType = "taco";
                    burritoPic.setImageResource(R.drawable.taco);
                }

            }

        }

//

        burritoSelection.setText(nameValue + " wants " + MVType + BTType);
    }

    private void findBurrito(View view) {
        //get spinnerr item array position
        Integer shopLocate = street.getSelectedItemPosition();
        //set the coffee shop
        myBurritoShop.setBurritoShop(shopLocate);
        String suggestedBurritoShop = myBurritoShop.getBurritoShop();
        String suggestedBuurritoShopURL = myBurritoShop.getburritoeShopURL();

        Log.i("shop suggested", suggestedBurritoShop);
        Log.i("url suggested", suggestedBuurritoShopURL);


        //Integer shopLocate = street.getSelectedItemPosition();
        // update findCoffee(0, create this new intent
        Intent intent = new Intent(this,BurritoActivity.class);
        //pass data
        intent.putExtra("burritoShop", suggestedBurritoShop);
        intent.putExtra("burritoShopURL", suggestedBuurritoShopURL);
        //start the intent
        startActivity(intent);
    }

}
