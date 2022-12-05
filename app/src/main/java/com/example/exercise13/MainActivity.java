package com.example.exercise13;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener  {

    Spinner spinner;
    EditText price, finalPrice;
    double priceSelected, quantity,  finalPInterest, tip;
    RadioGroup radioGroup;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.meals);
        spinner.setOnItemSelectedListener(this);
        price = findViewById(R.id.prices);
        finalPrice = findViewById(R.id.finalPrice);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(this);

        final SeekBar seekBar = findViewById(R.id.seekBar);
        final TextView textView = findViewById(R.id.seekText);






        Spinner spinner = (Spinner) findViewById(R.id.meals);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.foods, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        seekBar.setMax(10);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser)
                    textView.setText(String.valueOf(progress));
                    quantity = Double.parseDouble(String.valueOf(progress));
                finalPInterest = (quantity * priceSelected) + tip + (0.13 * priceSelected);
                finalPrice.setText(String.valueOf( finalPInterest));


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        //String itemSelected = parent.getItemAtPosition(i).toString();
        if (spinner.getSelectedItem().toString().equals("Banana")) {
            priceSelected = 8.90;
            finalPInterest = (quantity * priceSelected) + tip + (0.13 * priceSelected);
            finalPrice.setText(String.valueOf( finalPInterest));
            price.setText("8.90");
        } else if (spinner.getSelectedItem().toString().equals("Burger")) {
            priceSelected = 9.87;
            finalPInterest = (quantity * priceSelected) + tip + (0.13 * priceSelected);
            finalPrice.setText(String.valueOf( finalPInterest));
            price.setText("9.87");
        }else if (spinner.getSelectedItem().toString().equals("Pizza")) {
            priceSelected = 4.87;
            finalPInterest = (quantity * priceSelected) + tip + (0.13 * priceSelected);
            finalPrice.setText(String.valueOf( finalPInterest));
            price.setText("4.87");
        }
        else if (spinner.getSelectedItem().toString().equals("Apple")) {
            priceSelected = 5;
            finalPInterest = (quantity * priceSelected) + tip + (0.13 * priceSelected);
            finalPrice.setText(String.valueOf( finalPInterest));
            price.setText("5");
        }
        else if (spinner.getSelectedItem().toString().equals("Orange")) {
            priceSelected = 9.07;
            finalPInterest = (quantity * priceSelected) + tip + (0.13 * priceSelected);
            finalPrice.setText(String.valueOf( finalPInterest));
            price.setText("9.07");
        }
        else if (spinner.getSelectedItem().toString().equals("IceCream")) {
            priceSelected = 2.87;
            finalPInterest = (quantity * priceSelected) + tip + (0.13 * priceSelected);
            finalPrice.setText(String.valueOf( finalPInterest));
            price.setText("2.87");
        }
        else if (spinner.getSelectedItem().toString().equals("shake")) {
            priceSelected = 1.87;
            finalPInterest = (quantity * priceSelected) + tip + (0.13 * priceSelected);
            finalPrice.setText(String.valueOf( finalPInterest));
            price.setText("1.87");
        }
        else if (spinner.getSelectedItem().toString().equals("Maggi")) {
            priceSelected = 9.27;
            finalPInterest = (quantity * priceSelected) + tip + (0.13 * priceSelected);
            finalPrice.setText(String.valueOf( finalPInterest));
            price.setText("9.27");
        }
        else if (spinner.getSelectedItem().toString().equals("Pasta")) {
            priceSelected = 4.87;
            finalPInterest = (quantity * priceSelected) + tip + (0.13 * priceSelected);
            finalPrice.setText(String.valueOf( finalPInterest));
            price.setText("4.87");
        }
        else if (spinner.getSelectedItem().toString().equals("Noodles")) {
            priceSelected = 1.87;
            finalPInterest = (quantity * priceSelected) + tip + (0.13 * priceSelected);
            finalPrice.setText(String.valueOf( finalPInterest));
            price.setText("1.87");
        }

        //price.setText(itemSelected);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.radioButton1:
                //orientation.setOrientation(LinearLayout.HORIZONTAL);
                tip = 0.1 * priceSelected;
                finalPInterest = (quantity * priceSelected) + tip + (0.13 * priceSelected);
                finalPrice.setText(String.valueOf( finalPInterest));
                break;

            case R.id.radioButton2:
                //orientation.setOrientation(LinearLayout.VERTICAL);
                tip = 0.2 * priceSelected;
                finalPInterest = (quantity * priceSelected) + tip + (0.13 * priceSelected);
                finalPrice.setText(String.valueOf( finalPInterest));
                break;

            case R.id.radioButton3:
                //gravity.setGravity(Gravity.LEFT);
                tip = 0.3 * priceSelected;
                finalPInterest = (quantity * priceSelected) + tip + (0.13 * priceSelected);
                finalPrice.setText(String.valueOf( finalPInterest));
                break;


        }
    }
}