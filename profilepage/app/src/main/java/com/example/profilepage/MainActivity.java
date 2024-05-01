package com.example.profilepage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView profileImage;
    private TextView username;
    private TextView bio;
    private Button editProfileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        profileImage = findViewById(R.id.profile_image);
        username = findViewById(R.id.username);
        bio = findViewById(R.id.bio);
        editProfileButton = findViewById(R.id.edit_profile_button);

        // Load user data
        loadUserData();

        // Set up button click listener
        editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open edit profile activity
                Intent intent = new Intent(MainActivity.this, edit_profile_activity.class);
                startActivity(intent);
            }
        });
    }

    private void loadUserData() {
        // Fetch user data from somewhere (e.g., database)
        // For now, let's use hardcoded data
        String dummyUsername = "John Doe";
        String dummyBio = "I'm a software developer.";

        // Set user data to views
        username.setText(dummyUsername);
        bio.setText(dummyBio);
    }
}
