package com.example.showactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button nextScreenButton;
    private EditText inputTextBox;
    private final int REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nextScreenButton = findViewById(R.id.button_next_screen);
        inputTextBox = findViewById(R.id.editTextTextPersonName);

        nextScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = inputTextBox.getText().toString().trim();

                if (!inputText.isEmpty()) {
                    Intent intent = new Intent(MainActivity.this, ShowText.class);
                    intent.putExtra("inputText", inputText);
                    intent.putExtra("name", "Bond");
                    intent.putExtra("age", 35);
                    startActivityForResult(intent, REQUEST_CODE);
                } else {
                    Toast.makeText(MainActivity.this, "Enter text", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            assert data != null;
            String message = data.getStringExtra("message_back");

            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    }
}