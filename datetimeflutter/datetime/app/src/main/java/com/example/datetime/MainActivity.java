package com.example.datetime;

import android.os.Bundle;
import android.os.Handler;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView textViewDateTime;
    private Handler handler = new Handler();
    private Runnable updateTimeRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewDateTime = findViewById(R.id.textViewDateTime);

        // Create a Runnable to update time and date
        updateTimeRunnable = new Runnable() {
            @Override
            public void run() {
                updateDateTime();
                handler.postDelayed(this, 1000); // Update every second
            }
        };

        // Start updating time and date
        handler.post(updateTimeRunnable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Stop updating time and date when the activity is destroyed
        handler.removeCallbacks(updateTimeRunnable);
    }

    private void updateDateTime() {
        // Get current date and time
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String currentDateTime = sdf.format(new Date());

        // Update TextView with current date and time
        textViewDateTime.setText(currentDateTime);
    }
}
