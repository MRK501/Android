package com.example.question27;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText nameEditText;
    RadioGroup genderRadioGroup;
    RadioButton maleRadioButton, femaleRadioButton;
    CheckBox sportsCheckBox, musicCheckBox, readingCheckBox;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        nameEditText = findViewById(R.id.nameEditText);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        maleRadioButton = findViewById(R.id.maleRadioButton);
        femaleRadioButton = findViewById(R.id.femaleRadioButton);
        sportsCheckBox = findViewById(R.id.sportsCheckBox);
        musicCheckBox = findViewById(R.id.musicCheckBox);
        readingCheckBox = findViewById(R.id.readingCheckBox);
        submitBtn = findViewById(R.id.submitBtn);

        // Submit button click listener
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
    }

    private void submitForm() {
        // Get user input
        String name = nameEditText.getText().toString();
        String gender = "";
        if (maleRadioButton.isChecked()) {
            gender = "Male";
        } else if (femaleRadioButton.isChecked()) {
            gender = "Female";
        }

        StringBuilder hobbies = new StringBuilder();
        if (sportsCheckBox.isChecked()) {
            hobbies.append("Sports, ");
        }
        if (musicCheckBox.isChecked()) {
            hobbies.append("Music, ");
        }
        if (readingCheckBox.isChecked()) {
            hobbies.append("Reading");
        }

        // Display user input
        String message = "Name: " + name + "\n"
                + "Gender: " + gender + "\n"
                + "Hobbies: " + hobbies.toString();
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
