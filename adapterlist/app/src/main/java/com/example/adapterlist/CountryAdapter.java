package com.example.adapterlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class CountryAdapter extends ArrayAdapter<Country> {

    private Context context;
    private ArrayList<Country> countryList;

    public CountryAdapter(Context context, ArrayList<Country> countryList) {
        super(context, 0, countryList);
        this.context = context;
        this.countryList = countryList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(R.layout.list_item_country, parent, false);
        }

        Country currentCountry = countryList.get(position);

        ImageView flagImageView = listItemView.findViewById(R.id.imageViewFlag);
        flagImageView.setImageResource(currentCountry.getFlagResource());

        TextView countryTextView = listItemView.findViewById(R.id.textViewCountryName);
        countryTextView.setText(currentCountry.getName());

        return listItemView;
    }
}
