package com.example.rotateimage;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image_view);

        // Set click listener for rotate button
        findViewById(R.id.rotate_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotateImage();
            }
        });
    }

    // Method to rotate the image by 90 degrees
    private void rotateImage() {
        float currentRotation = imageView.getRotation();
        currentRotation += 90;
        imageView.setRotation(currentRotation);
        Toast.makeText(this, "Image rotated", Toast.LENGTH_SHORT).show();
    }
}