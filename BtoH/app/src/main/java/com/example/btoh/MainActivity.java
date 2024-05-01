package com.example.btoh;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText inputText;
    Button convertButton;
    TextView outputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.input_text);
        convertButton = findViewById(R.id.btn_convert);
        outputText = findViewById(R.id.output_text);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputText.getText().toString().trim();
                if (!TextUtils.isEmpty(input)) {
                    if (isBinary(input)) {
                        String hex = convertBinaryToHex(input);
                        outputText.setText("Hexadecimal: " + hex);
                    } else if (isHex(input)) {
                        String binary = convertHexToBinary(input);
                        outputText.setText("Binary: " + binary);
                    } else {
                        outputText.setText("Invalid input. Enter a valid binary or hexadecimal number.");
                    }
                } else {
                    outputText.setText("Please enter a binary or hexadecimal number.");
                }
            }
        });
    }

    private boolean isBinary(String input) {
        return input.matches("[01]+");
    }

    private boolean isHex(String input) {
        return input.matches("[0-9A-Fa-f]+");
    }

    private String convertBinaryToHex(String binary) {
        return Long.toHexString(Long.parseLong(binary, 2)).toUpperCase();
    }

    private String convertHexToBinary(String hex) {
        return Long.toBinaryString(Long.parseLong(hex, 16));
    }
}
