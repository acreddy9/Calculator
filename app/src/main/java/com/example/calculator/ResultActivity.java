package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        String resultStr = intent.getStringExtra("result");
        if (resultStr.equals("INVALID_FORMAT")) {
            resultTextView = (TextView) findViewById(R.id.resultTitle);
            resultTextView.setText("Please enter 2 numbers next time");
        } else {
            resultTextView = (TextView) findViewById(R.id.resultTextView);
            resultTextView.setText(resultStr);
        }
    }



}