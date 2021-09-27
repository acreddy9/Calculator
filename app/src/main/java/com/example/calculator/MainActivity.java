package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void compute(View view) {
        EditText firstNumTextField = (EditText) findViewById(R.id.firstNumTextField);
        EditText secondNumTextField = (EditText) findViewById(R.id.secondNumTextField);

        Double firstNum = 0.0;
        Double secondNum = 0.0;
        try {
            firstNum = Double.parseDouble(firstNumTextField.getText().toString());
            secondNum = Double.parseDouble(secondNumTextField.getText().toString());
        } catch (Exception e) {
            goToResultActivity("INVALID_FORMAT");
        }

        double result = 0;
        switch (view.getId()) {
            case (R.id.addButton):
                result = firstNum + secondNum;
                break;
            case (R.id.subtractButton):
                result = firstNum - secondNum;
                break;
            case (R.id.multiplyButton):
                result = firstNum * secondNum;
                break;
            case (R.id.divideButton):
                result = firstNum / secondNum;
                break;
        }

        String resultStr = String.valueOf(result);
        goToResultActivity(resultStr);
    }

    public void goToResultActivity(String s) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("result", s);
        startActivity(intent);
    }
}