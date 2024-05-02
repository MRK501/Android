package com.example.pass_data;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class LanguageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        // Retrieve the language from intent extras
        String language = getIntent().getStringExtra("LANGUAGE");

        // Display the language in TextView
        TextView languageTextView = findViewById(R.id.languageTextView);
        languageTextView.setText(language);

        // Set the language logo based on the selected language
        ImageView languageLogoImageView = findViewById(R.id.languageLogoImageView);
        int logoResourceId = 0;

        switch (language) {
            case "Java":
                logoResourceId = R.drawable.java_logo;
                break;
            case "C++":
                logoResourceId = R.drawable.cpp_logo;
                break;
            case "Python":
                logoResourceId = R.drawable.python_logo;
                break;
            case "JavaScript":
                logoResourceId = R.drawable.javascript_logo;
                break;
        }

        if (logoResourceId != 0) {
            languageLogoImageView.setImageResource(logoResourceId);
        }
    }
}
