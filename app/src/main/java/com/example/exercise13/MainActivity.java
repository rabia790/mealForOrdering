package com.example.exercise13;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    EditText price;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.meals);
        spinner.setOnItemSelectedListener(this);
        price = findViewById(R.id.prices);

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
            price.setText("8.90");
        } else if (spinner.getSelectedItem().toString().equals("Burger")) {
            price.setText("9.87");
        }else if (spinner.getSelectedItem().toString().equals("Pizza")) {
            price.setText("4.87");
        }
        else if (spinner.getSelectedItem().toString().equals("Apple")) {
            price.setText("5");
        }
        else if (spinner.getSelectedItem().toString().equals("Orange")) {
            price.setText("9.07");
        }
        else if (spinner.getSelectedItem().toString().equals("IceCream")) {
            price.setText("2.87");
        }
        else if (spinner.getSelectedItem().toString().equals("shake")) {
            price.setText("1.87");
        }
        else if (spinner.getSelectedItem().toString().equals("Maggi")) {
            price.setText("9.27");
        }
        else if (spinner.getSelectedItem().toString().equals("Pasta")) {
            price.setText("4.87");
        }
        else if (spinner.getSelectedItem().toString().equals("Noodles")) {
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
}