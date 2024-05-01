package com.example.table;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TableLayout tableLayout = findViewById(R.id.tableLayout);

        // Add rows dynamically
        addRow(tableLayout, "Language", "Creator", "URL");
        addRow(tableLayout, "Java", "James Gosling", "https://www.java.com");
        addRow(tableLayout, "Python", "Guido van Rossum", "https://www.python.org");
        addRow(tableLayout, "JavaScript", "Brendan Eich", "https://www.javascript.com");
        addRow(tableLayout, "C++", "Bjarne Stroustrup", "https://www.cplusplus.com");
    }

    private void addRow(TableLayout tableLayout, String col1, String col2, String col3) {
        TableRow row = new TableRow(this);

        // Create LayoutParams for the TableRow
        TableLayout.LayoutParams layoutParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT);
        row.setLayoutParams(layoutParams);

        // Create TextViews for each column
        TextView textView1 = new TextView(this);
        textView1.setText(col1);
        textView1.setPadding(8, 8, 8, 8);

        TextView textView2 = new TextView(this);
        textView2.setText(col2);
        textView2.setPadding(8, 8, 8, 8);

        TextView textView3 = new TextView(this);
        textView3.setText(col3);
        textView3.setPadding(8, 8, 8, 8);

        // Add TextViews to TableRow
        row.addView(textView1);
        row.addView(textView2);
        row.addView(textView3);

        // Add TableRow to TableLayout
        tableLayout.addView(row);
    }
}
