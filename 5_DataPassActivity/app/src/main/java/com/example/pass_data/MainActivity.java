package com.example.pass_data;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLanguageButtonClick(View view) {
        String language = "";

        if (view.getId() == R.id.buttonJava) {
            language = "Java";
        } else if (view.getId() == R.id.buttonCpp) {
            language = "C++";
        } else if (view.getId() == R.id.buttonPython) {
            language = "Python";
        } else if (view.getId() == R.id.buttonJavaScript) {
            language = "JavaScript";
        }


        Intent intent = new Intent(this, LanguageActivity.class);
        intent.putExtra("LANGUAGE", language);
        startActivity(intent);
    }
}
