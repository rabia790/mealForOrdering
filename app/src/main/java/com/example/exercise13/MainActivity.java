package com.example.exercise13;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener  {

    Spinner spinner;
    EditText price, finalPrice;
    double priceSelected, quantity,  finalPInterest, tip;
    RadioGroup radioGroup;
    ImageView foodImage;
    CheckBox confirmButton;
    Button order;
    RadioButton radioButton1, radioButton2, radioButton3;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.meals);
        spinner.setOnItemSelectedListener(this);
        price = findViewById(R.id.prices);
        finalPrice = findViewById(R.id.finalPrice);
        foodImage = findViewById(R.id.foodImage);
        confirmButton = findViewById(R.id.confirm_button);
        order = findViewById(R.id.order);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(this);

        final SeekBar seekBar = findViewById(R.id.seekBar);
        final TextView textView = findViewById(R.id.seekText);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOrderSuccess();
            }
        });

       confirmButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              openLogoutDialog();
          }
       });



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

    private void onOrderSuccess() {
        if (spinner.getSelectedItem().toString().isEmpty()){
            Toast.makeText(this, "Spinner is Empty!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (price.getText().toString().isEmpty()){
            Toast.makeText(this, "Please enter price!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!(radioGroup.getCheckedRadioButtonId() != -1)){
            Toast.makeText(this, "Please select radioButton!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!confirmButton.isChecked()){
            Toast.makeText(this, "Please confirm your order!", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            Toast.makeText(this, "We've Received your order", Toast.LENGTH_SHORT).show();
            return;
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        //String itemSelected = parent.getItemAtPosition(i).toString();
        if (spinner.getSelectedItem().toString().equals("Banana")) {
            priceSelected = 8.90;
            finalPInterest = (quantity * priceSelected) + tip + (0.13 * priceSelected);
            finalPrice.setText(String.valueOf( finalPInterest));
            price.setText("8.90");
            foodImage.setImageResource(R.drawable.banana);

        } else if (spinner.getSelectedItem().toString().equals("Burger")) {
            priceSelected = 9.87;
            finalPInterest = (quantity * priceSelected) + tip + (0.13 * priceSelected);
            finalPrice.setText(String.valueOf( finalPInterest));
            price.setText("9.87");
            foodImage.setImageResource(R.drawable.burger);

        }else if (spinner.getSelectedItem().toString().equals("Pizza")) {
            priceSelected = 4.87;
            finalPInterest = (quantity * priceSelected) + tip + (0.13 * priceSelected);
            finalPrice.setText(String.valueOf( finalPInterest));
            price.setText("4.87");
            foodImage.setImageResource(R.drawable.pizza);
        }
        else if (spinner.getSelectedItem().toString().equals("Apple")) {
            priceSelected = 5;
            finalPInterest = (quantity * priceSelected) + tip + (0.13 * priceSelected);
            finalPrice.setText(String.valueOf( finalPInterest));
            price.setText("5");
            foodImage.setImageResource(R.drawable.apple);
        }
        else if (spinner.getSelectedItem().toString().equals("Orange")) {
            priceSelected = 9.07;
            finalPInterest = (quantity * priceSelected) + tip + (0.13 * priceSelected);
            finalPrice.setText(String.valueOf( finalPInterest));
            price.setText("9.07");
            foodImage.setImageResource(R.drawable.orange);
        }
        else if (spinner.getSelectedItem().toString().equals("IceCream")) {
            priceSelected = 2.87;
            finalPInterest = (quantity * priceSelected) + tip + (0.13 * priceSelected);
            finalPrice.setText(String.valueOf( finalPInterest));
            price.setText("2.87");
            foodImage.setImageResource(R.drawable.icecream);
        }
        else if (spinner.getSelectedItem().toString().equals("shake")) {
            priceSelected = 1.87;
            finalPInterest = (quantity * priceSelected) + tip + (0.13 * priceSelected);
            finalPrice.setText(String.valueOf( finalPInterest));
            price.setText("1.87");
            foodImage.setImageResource(R.drawable.shake);
        }
        else if (spinner.getSelectedItem().toString().equals("Maggi")) {
            priceSelected = 9.27;
            finalPInterest = (quantity * priceSelected) + tip + (0.13 * priceSelected);
            finalPrice.setText(String.valueOf( finalPInterest));
            price.setText("9.27");
            foodImage.setImageResource(R.drawable.maggi);
        }
        else if (spinner.getSelectedItem().toString().equals("Pasta")) {
            priceSelected = 4.87;
            finalPInterest = (quantity * priceSelected) + tip + (0.13 * priceSelected);
            finalPrice.setText(String.valueOf( finalPInterest));
            price.setText("4.87");
            foodImage.setImageResource(R.drawable.pasta);

        }

        else if (spinner.getSelectedItem().toString().equals("Noodles")) {
            priceSelected = 1.87;
            finalPInterest = (quantity * priceSelected) + tip + (0.13 * priceSelected);
            finalPrice.setText(String.valueOf( finalPInterest));
            price.setText("1.87");
            foodImage.setImageResource(R.drawable.noodles);
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
    void openLogoutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(this);
        View view = layoutInflaterAndroid.inflate(R.layout.alert_dialog, null);
        builder.setView(view);
        builder.setCancelable(true);
        final AlertDialog alertDialog = builder.create();
        alertDialog.setCanceledOnTouchOutside(true);
        Window window = alertDialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        WindowManager.LayoutParams lp = alertDialog.getWindow().getAttributes();
        alertDialog.getWindow().setGravity(Gravity.CENTER);
        alertDialog.getWindow().setAttributes(lp);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        AppCompatTextView yes = view.findViewById(R.id.btnYes);
        AppCompatTextView no = view.findViewById(R.id.btnNo);
        yes.setOnClickListener(view1 -> {
            alertDialog.dismiss();


        });
        no.setOnClickListener(view1 -> {
            alertDialog.dismiss();
        });
        alertDialog.show();
    }
}