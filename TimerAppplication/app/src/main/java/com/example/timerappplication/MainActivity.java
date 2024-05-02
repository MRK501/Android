package com.example.timerappplication;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView timerTextView;
    private Button startButton, stopButton, resetButton;
    private Handler handler;
    private boolean isTimerRunning = false;
    private int seconds = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerTextView = findViewById(R.id.timerTextView);
        startButton = findViewById(R.id.startButton);
        stopButton = findViewById(R.id.stopButton);
        resetButton = findViewById(R.id.resetButton);

        handler = new Handler();

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopTimer();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });
    }

    private void startTimer() {
        if (!isTimerRunning) {
            isTimerRunning = true;
            handler.postDelayed(timerRunnable, 1000);
        }
    }

    private void stopTimer() {
        isTimerRunning = false;
        handler.removeCallbacks(timerRunnable);
    }

    private void resetTimer() {
        isTimerRunning = false;
        handler.removeCallbacks(timerRunnable);
        seconds = 0;
        updateTimerText();
    }

    private Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {
            seconds++;
            updateTimerText();
            handler.postDelayed(this, 1000);
        }
    };

    private void updateTimerText() {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;

        String timeString = String.format("%02d:%02d:%02d", hours, minutes, secs);
        timerTextView.setText(timeString);
    }
}
