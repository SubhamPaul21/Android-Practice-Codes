package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class WordsAdapter extends ArrayAdapter<Words> {

    public WordsAdapter(@NonNull Context context,@NonNull ArrayList<Words> words) {
        super(context, 0, words);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_list_view,parent,false);
        }

        final Words currentWord = getItem(position);

        // Set magnitude Text
        TextView magnitudeText = listItemView.findViewById(R.id.magnitude_text_view);

        assert currentWord != null;
        magnitudeText.setText(currentWord.getMagnitude());

        // Set location Text
        TextView locationText = listItemView.findViewById(R.id.location_text_view);

        locationText.setText(currentWord.getLocation());

        // Set date text
        TextView dateText = listItemView.findViewById(R.id.date_text_view);

        dateText.setText(currentWord.getDate());

        return listItemView;
    }
}
