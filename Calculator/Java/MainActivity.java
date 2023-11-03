package com.example.calculator;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char PERCENT = '%';

    private char currentSymbol;

    private double firstValue = Double.NaN;
    private double secondValue;
    private TextView inputDisplay, outputDisplay;
    private DecimalFormat decimalFormat;
    private MaterialButton button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;

    private MaterialButton buttonDot,buttonAdd,buttonSub,buttonMultiply,buttonDivide,buttonPercent,buttonClear,buttonEqual,buttonOpen,buttonClose;



    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        decimalFormat = new DecimalFormat("#.##########");

        inputDisplay = findViewById(R.id.solution);
        outputDisplay = findViewById(R.id.result);

        button0 = findViewById(R.id.button_0);
        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);
        button3 = findViewById(R.id.button_3);
        button4 = findViewById(R.id.button_4);
        button5 = findViewById(R.id.button_5);
        button6 = findViewById(R.id.button_6);
        button7 = findViewById(R.id.button_7);
        button8 = findViewById(R.id.button_8);
        button9 = findViewById(R.id.button_9);

        buttonAdd = findViewById(R.id.button_add);
        buttonSub = findViewById(R.id.button_subtract);
        buttonDivide = findViewById(R.id.button_divide);
        buttonDot = findViewById(R.id.button_dot);
        buttonMultiply = findViewById(R.id.button_multiply);
        buttonClear = findViewById(R.id.button_c);
        buttonOpen = findViewById(R.id.button_open);
        buttonClose = findViewById(R.id.button_close);
        buttonEqual = findViewById(R.id.button_equal);
        buttonPercent = findViewById(R.id.button_percent);

        button0.setOnClickListener(view -> inputDisplay.setText(inputDisplay.getText() + "0"));

        button1.setOnClickListener(view -> inputDisplay.setText(inputDisplay.getText() + "1"));

        button2.setOnClickListener(view -> inputDisplay.setText(inputDisplay.getText() + "2"));

        button3.setOnClickListener(view -> inputDisplay.setText(inputDisplay.getText() + "3"));

        button4.setOnClickListener(view -> inputDisplay.setText(inputDisplay.getText() + "4"));

        button5.setOnClickListener(view -> inputDisplay.setText(inputDisplay.getText() + "5"));

        button6.setOnClickListener(view -> inputDisplay.setText(inputDisplay.getText() + "6"));

        button7.setOnClickListener(view -> inputDisplay.setText(inputDisplay.getText() + "7"));

        button8.setOnClickListener(view -> inputDisplay.setText(inputDisplay.getText() + "8"));

        button9.setOnClickListener(view -> inputDisplay.setText(inputDisplay.getText() + "9"));

        buttonAdd.setOnClickListener(view -> {
            allCalculations();
            currentSymbol = ADDITION;
            outputDisplay.setText(decimalFormat.format(firstValue) + "+");
            inputDisplay.setText(null);
        });

        buttonSub.setOnClickListener(view -> {
            allCalculations();
            currentSymbol = SUBTRACTION;
            outputDisplay.setText(decimalFormat.format(firstValue) + "-");
            inputDisplay.setText(null);
        });

        buttonMultiply.setOnClickListener(view -> {
            allCalculations();
            currentSymbol = MULTIPLICATION;
            outputDisplay.setText(decimalFormat.format(firstValue) + "x");
            inputDisplay.setText(null);
        });

        buttonDivide.setOnClickListener(view -> {
            allCalculations();
            currentSymbol = DIVISION;
            outputDisplay.setText(decimalFormat.format(firstValue) + "/");
            inputDisplay.setText(null);
        });

        buttonPercent.setOnClickListener(view -> {
            allCalculations();
            currentSymbol = PERCENT;
            outputDisplay.setText(decimalFormat.format(firstValue) + "%");
            inputDisplay.setText(null);
        });

        buttonDot.setOnClickListener(view -> inputDisplay.setText(inputDisplay.getText() + "."));

        buttonClear.setOnClickListener(view -> {
            if (inputDisplay.getText().length() > 0) {
                CharSequence currentText = inputDisplay.getText();
                inputDisplay.setText(currentText.subSequence(0, currentText.length() - 1));
            } else {
                firstValue = Double.NaN;
                secondValue = Double.NaN;
                inputDisplay.setText("");
                outputDisplay.setText("");
            }
        });



        buttonEqual.setOnClickListener(view -> {
            allCalculations();
            outputDisplay.setText(decimalFormat.format(firstValue));
            firstValue = Double.NaN;
            currentSymbol = '0';
        });
    }

    private void allCalculations(){
        if (!Double.isNaN(firstValue)) {
            secondValue = Double.parseDouble(inputDisplay.getText().toString());
            inputDisplay.setText(null);

            if (currentSymbol == ADDITION)
                firstValue = this.firstValue + secondValue;
            else if (currentSymbol == SUBTRACTION)
                firstValue = this.firstValue - secondValue;
            else if (currentSymbol == MULTIPLICATION)
                firstValue = this.firstValue * secondValue;
            else if (currentSymbol == DIVISION)
                firstValue = this.firstValue / secondValue;
            else if (currentSymbol == PERCENT)
                firstValue = this.firstValue % secondValue;
        } else {
            try {
                firstValue = Double.parseDouble(inputDisplay.getText().toString());
            } catch (Exception e) {

            }
        }
    }
}
