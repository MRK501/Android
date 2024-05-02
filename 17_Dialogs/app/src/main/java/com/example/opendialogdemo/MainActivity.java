package com.example.opendialogdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button showDialogButton = findViewById(R.id.button_show_dialog);
        showDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new AlertDialog.Builder object
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                // Set the title and message for the dialog
                builder.setTitle("Dialog Title")
                        .setMessage("This is a sample dialog.");

                // Set the positive button with a listener
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Show a toast message when the OK button is clicked
                        Toast.makeText(MainActivity.this, "OK button clicked!", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Cancel", null); // No action needed for Cancel button

                // Create and show the dialog
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}
