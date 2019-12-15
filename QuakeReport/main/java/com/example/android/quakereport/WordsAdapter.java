package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class WordsAdapter extends ArrayAdapter<Earthquake> {

    private SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a", Locale.ENGLISH);
    private SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy", Locale.ENGLISH);

    public WordsAdapter(@NonNull Context context,@NonNull ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_list_view, parent,false);
        }

        final Earthquake currentWord = getItem(position);

        assert currentWord != null;
        Date dateObject = new Date(currentWord.getTime());

        // Set magnitude Text
        TextView magnitudeText = listItemView.findViewById(R.id.magnitude_text_view);

        magnitudeText.setText(String.valueOf(currentWord.getMagnitude()));

        //  Set the background color for each magnitude text
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeText.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentWord.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        // Set location Text
        TextView locationText = listItemView.findViewById(R.id.location_text_view);

        locationText.setText(currentWord.getLocation());

        //  Set offset Text
        TextView offsetText = listItemView.findViewById(R.id.offset_text_view);

        offsetText.setText(currentWord.getOffset());

        // Set date text
        TextView dateText = listItemView.findViewById(R.id.date_text_view);
        String date = dateFormatter.format(dateObject);

        dateText.setText(date);

        // Set time text
        TextView timeText = listItemView.findViewById(R.id.time_text_view);
        String time = timeFormatter.format(dateObject);

        timeText.setText(time);

        return listItemView;
    }

    private int getMagnitudeColor(double magnitude) {

        int intMagnitude = (int) magnitude;
        int magnitudeResourceId;
        switch (intMagnitude) {
            case 0:
            case 1:
                magnitudeResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeResourceId);
    }
}
