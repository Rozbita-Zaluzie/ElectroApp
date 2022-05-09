package com.example.electro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    // U - napětí , I - proud, R - odpor
    public String mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    // změna režimu počítání
    public void changeTo(View view) {
        TextView label1 = findViewById(R.id.label1);
        TextView label2 = findViewById(R.id.label2);
        TextView labelResult = findViewById(R.id.labelResult);
        TextView number1 = findViewById(R.id.number1);
        TextView number2 = findViewById(R.id.number2);
        TextView numberResult = findViewById(R.id.result);
        Spinner unit1 = findViewById(R.id.unit1);
        Spinner unit2 = findViewById(R.id.unit2);
        TextView unitResult = findViewById(R.id.resultUnit);

        ArrayAdapter<CharSequence> adapterI = ArrayAdapter.createFromResource(this,
                R.array.ampers, android.R.layout.simple_spinner_item);
        adapterI.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adapterU = ArrayAdapter.createFromResource(this,
                R.array.volts, android.R.layout.simple_spinner_item);
        adapterU.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adapterR = ArrayAdapter.createFromResource(this,
                R.array.ohms, android.R.layout.simple_spinner_item);
        adapterR.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        switch (view.getId()) {
            case R.id.toU:

                // changing spinners
                unit1.setAdapter(adapterI);
                unit2.setAdapter(adapterR);
                unit1.setSelection(2);
                unit2.setSelection(4);
                unitResult.setText("");

                // changing labels
                label1.setText("I (proud)");
                label2.setText("R (odpor)");
                labelResult.setText("U (napětí)");

                // remove numbers
                number1.setText("");
                number2.setText("");
                numberResult.setText("");

                // set mode
                mode = "U";
                break;
            case R.id.toI:

                // changing spinners
                unit1.setAdapter(adapterU);
                unit2.setAdapter(adapterR);
                unit1.setSelection(4);
                unit2.setSelection(4);
                unitResult.setText("");

                // changing labels
                label1.setText("U (napětí)");
                label2.setText("R (odpor)");
                labelResult.setText("I (proud)");

                // remove numbers
                number1.setText("");
                number2.setText("");
                numberResult.setText("");

                // set mode
                mode = "I";
                break;
            case R.id.toR:

                // changing spinners
                unit1.setAdapter(adapterU);
                unit2.setAdapter(adapterI);
                unit1.setSelection(4);
                unit2.setSelection(2);
                unitResult.setText("");

                // changing labels
                label1.setText("U (napětí)");
                label2.setText("I (proud)");
                labelResult.setText("R (odpor)");

                // remove numbers
                number1.setText("");
                number2.setText("");
                numberResult.setText("");

                // set mode
                mode = "R";
                break;
        }


    }

    public void calc(View view) {
        OhmRules ohmr = new OhmRules();

        TextView number1 = findViewById(R.id.number1);
        TextView number2 = findViewById(R.id.number2);
        TextView numberResult = findViewById(R.id.result);

        Spinner unit1 = findViewById(R.id.unit1);
        Spinner unit2 = findViewById(R.id.unit2);
        TextView unitResult = findViewById(R.id.resultUnit);

        double num1 = Double.parseDouble(number1.getText().toString());
        double num2 = Double.parseDouble(number2.getText().toString());

        double result = 0.01;
        try {
            result = ohmr.Calc(mode, num1, unit1.getSelectedItem().toString(), num2, unit2.getSelectedItem().toString());
        } catch (Exception e) {
            System.out.println(e);
        }

        numberResult.setText("" + result);


    }





}