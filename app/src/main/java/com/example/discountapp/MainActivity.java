package com.example.discountapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText bill_total;
private SeekBar seekBar;
private TextView button10, button15, button20, seekBarValue, discount10, discount15, discount20, total10, total15, total20, customValue, discountCustom, totalCustom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bill_total=(EditText)findViewById(R.id.billTotal);
        button10=(TextView) findViewById(R.id.button_10);
        button15=(TextView) findViewById(R.id.button_15);
        button20=(TextView) findViewById(R.id.button_20);
        seekBar=(SeekBar)findViewById(R.id.seekBar);
        seekBarValue=(TextView)findViewById(R.id.seekBarValue);
        discount10=(TextView)findViewById(R.id.discount_10);
        discount15=(TextView)findViewById(R.id.discount_15);
        discount20=(TextView)findViewById(R.id.discount_20);
        total10=(TextView)findViewById(R.id.total_10);
        total15=(TextView)findViewById(R.id.total_15);
        total20=(TextView)findViewById(R.id.total_20);
        customValue=(TextView)findViewById(R.id.seekBarValue);
        discountCustom=(TextView)findViewById(R.id.discount_custom);
        totalCustom=(TextView)findViewById(R.id.total_custom);


        bill_total.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                Double bill = Double.parseDouble(bill_total.getText().toString());
                Double totalBill=bill*0.90;
                discount10.setText("- "+String.format("%.2f",bill*0.10));
                total10.setText(String.format("%.2f",totalBill));
                Double totalBill15=bill*0.85;
                discount15.setText("- "+String.format("%.2f",bill*0.15));
                total15.setText(String.format("%.2f",totalBill15));
                Double totalBill20=bill*0.80;
                discount20.setText("- "+String.format("%.2f",bill*0.20));
                total20.setText(String.format("%.2f",totalBill20));

            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressValue;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(!bill_total.getText().toString().matches("")) {
                    progressValue = progress;
                    customValue.setText(+progress + "%");
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Please enter bill total",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if(!bill_total.getText().toString().matches("")) {
                    customValue.setText(+progressValue + "%");
                    int value =progressValue;
                    Double bill = Double.parseDouble(bill_total.getText().toString());
                    Double totalBill = bill*(100-value)/100;
                    Double discount = bill*value/100;
                    discountCustom.setText(" - "+String.format("%.2f",discount));
                    totalCustom.setText(String.format("%.2f", totalBill));
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Please enter bill total",Toast.LENGTH_SHORT).show();
                }
            }

        });

    }

}