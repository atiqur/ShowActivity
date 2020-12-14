package com.example.showactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ShowText extends AppCompatActivity {
    private TextView showText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_text);

        Bundle extra = getIntent().getExtras();

        showText = findViewById(R.id.textView);

        if (extra != null) {
            showText.setText(extra.getString("inputText"));
            Log.d("NAME", "onCreate: " + extra.getString("name"));
            Log.d("AGE", "onCreate: " + extra.getInt("age"));
        }
    }
}