package com.example.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper;
    private EditText editTextName, editTextSurname, editTextMarks, editTextId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DatabaseHelper(this);
        editTextName = findViewById(R.id.editTextName);
        editTextSurname = findViewById(R.id.editTextSurname);
        editTextMarks = findViewById(R.id.editTextMarks);
        editTextId = findViewById(R.id.editTextId);

        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonShow = findViewById(R.id.buttonShow);
        Button buttonUpdate = findViewById(R.id.buttonUpdate);
        Button buttonDelete = findViewById(R.id.buttonDelete);

        buttonAdd.setOnClickListener(view -> {
            String name = editTextName.getText().toString();
            String surname = editTextSurname.getText().toString();
            String marks = editTextMarks.getText().toString();

            if (name.isEmpty() || surname.isEmpty() || marks.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                long result = addData(name, surname, Integer.parseInt(marks));
                if (result == -1) {
                    Toast.makeText(MainActivity.this, "Error adding data", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Data added successfully", Toast.LENGTH_SHORT).show();
                    clearFields();
                }
            }
        });

        buttonShow.setOnClickListener(view -> {
            Cursor cursor = dbHelper.getAllData();
            if (cursor.getCount() == 0) {
                showMessage("Error", "No data found");
            } else {
                StringBuilder buffer = new StringBuilder();
                while (cursor.moveToNext()) {
                    buffer.append("ID: ").append(cursor.getInt(0)).append("\n");
                    buffer.append("Name: ").append(cursor.getString(1)).append("\n");
                    buffer.append("Surname: ").append(cursor.getString(2)).append("\n");
                    buffer.append("Marks: ").append(cursor.getInt(3)).append("\n\n");
                }
                showMessage("Data", buffer.toString());
            }
        });


        buttonUpdate.setOnClickListener(view -> {
            String name = editTextName.getText().toString();
            String surname = editTextSurname.getText().toString();
            String marks = editTextMarks.getText().toString();
            String id = editTextId.getText().toString();

            if (id.isEmpty() || name.isEmpty() || surname.isEmpty() || marks.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                boolean result = dbHelper.updateData(Integer.parseInt(id), name, surname, Integer.parseInt(marks));
                if (result) {
                    Toast.makeText(MainActivity.this, "Data updated successfully", Toast.LENGTH_SHORT).show();
                    clearFields();
                } else {
                    Toast.makeText(MainActivity.this, "Error updating data", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonDelete.setOnClickListener(view -> {
            String id = editTextId.getText().toString();
            if (id.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please enter ID", Toast.LENGTH_SHORT).show();
            } else {
                int rowsDeleted = dbHelper.deleteData(Integer.parseInt(id));
                if (rowsDeleted > 0) {
                    Toast.makeText(MainActivity.this, "Data deleted successfully", Toast.LENGTH_SHORT).show();
                    clearFields();
                } else {
                    Toast.makeText(MainActivity.this, "Error deleting data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private long addData(String name, String surname, int marks) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("surname", surname);
        values.put("marks", marks);
        try {
            return db.insertOrThrow("my_table", null, values);
        } catch (Exception e) {
            Log.e("AddData", "Error adding data: " + e.getMessage());
            return -1;
        }
    }


    private void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", (dialogInterface, i) -> dialogInterface.dismiss())
                .create()
                .show();
    }


    private void clearFields() {
        editTextName.setText("");
        editTextSurname.setText("");
        editTextMarks.setText("");
        editTextId.setText("");
    }
}
