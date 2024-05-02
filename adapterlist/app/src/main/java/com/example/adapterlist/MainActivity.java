package com.example.adapterlist;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Country> countryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        countryList = new ArrayList<>();
        countryList.add(new Country("USA", R.drawable.flag_india));
        countryList.add(new Country("UK", R.drawable.flag_uk));
        countryList.add(new Country("France", R.drawable.flag_france));
        countryList.add(new Country("Germany", R.drawable.flag_australia));


        CountryAdapter adapter = new CountryAdapter(this, countryList);
        listView.setAdapter(adapter);
    }
}
