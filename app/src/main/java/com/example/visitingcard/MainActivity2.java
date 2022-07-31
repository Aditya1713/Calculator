package com.example.visitingcard;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

    EditText txtValue;
    String operatorValue;
    Boolean isNewOperation = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtValue = (EditText) findViewById(R.id.main_txt_calculator);
        txtValue.setShowSoftInputOnFocus(false);
        txtValue.setSingleLine(false);
    }

    public void numberClick(View view) {
        if (isNewOperation) {
            isNewOperation = false;
            txtValue.setText("");
        }

        String value = txtValue.getText().toString();

        switch (view.getId()) {
            case R.id.button0:
                value += "0";
                break;

            case R.id.button1:
                value += "1";
                break;

            case R.id.button2:
                value += "2";
                break;

            case R.id.button3:
                value += "3";
                break;

            case R.id.button4:
                value += "4";
                break;

            case R.id.button5:
                value += "5";
                break;

            case R.id.button6:
                value += "6";
                break;

            case R.id.button7:
                value += "7";
                break;

            case R.id.button8:
                value += "8";
                break;

            case R.id.button9:
                value += "9";
                break;

        }
        txtValue.setText(value);

    }

    public void operatorClick(View view) {
        String value = txtValue.getText().toString();
        switch(view.getId()){
            case R.id.button_plus:
                operatorValue="+";
                value += "+";
                break;

            case R.id.button_minus:
                operatorValue="-";
                value += "-";
                break;

            case R.id.button_divide:
                operatorValue="/";
                value += "/";
                break;

            case R.id.button_multiply:
                operatorValue="*";
                value += "*";
                break;
        }
        txtValue.setText(value);
    }

    public void clearButton(View view){
        txtValue.setText("");
    }

    public void equalsClick(View view){

        String value=txtValue.getText().toString();
        double calculatedValue = 0.0;
        String[] separated;
        switch(operatorValue){
            case "+":
                separated=value.split("\\+");
                calculatedValue=Double.parseDouble(separated[0])+Double.parseDouble(separated[1]);
                break;

            case "-":
                separated=value.split("-");
                calculatedValue=Double.parseDouble(separated[0])-Double.parseDouble(separated[1]);
                break;

            case "*":
                separated=value.split("\\*");
                calculatedValue=Double.parseDouble(separated[0])*Double.parseDouble(separated[1]);
                break;

            case "/":
                separated=value.split("/");
                calculatedValue=Double.parseDouble(separated[0])/Double.parseDouble(separated[1]);
                break;
        }
        String finalValue=String.format("%.2f",calculatedValue);
        txtValue.setText(value +"\n"+finalValue);

        isNewOperation=true;
    }
}