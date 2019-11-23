package com.example.android.miwok;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;


public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorId) { // Custom class Adapter constructor taking context and object list as input acc to our requirement
        super(context,0, words); // Since ArrayAdapter class object is initialized with parameters (context/Activity, resource/ XML file, list of objects), so we initialize super as such.
        this.mColorResourceId = colorId;
    }

    /**
     *
     * @param position  The AdapterView position that is requesting the view.
     * @param convertView   The recycled view to populate.
     * @param parent    The parent ViewGroup that is used for inflation.
     * @return listItemView which is the view layout of the current position of the item.
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Check if the existing view is being reused otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_word_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        final Word currentWord = getItem(position);

        //Find the Linear Layout Text Views using the id
        LinearLayout linearTextView = listItemView.findViewById(R.id.linear_text_view);

        //Find the color that the resource Id maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        //Set the background color to the specified color
        linearTextView.setBackgroundColor(color);

        //Find the TextView in the list_word_item.xml layout using the id
        TextView miwokTextView = listItemView.findViewById(R.id.miwok_text_view);

        //Get the word from the getter method and set the text to the current TextView
        assert currentWord != null;
        miwokTextView.setText(currentWord.getMiwokTranslation());

        //Find the TextView in the list_word_item.xml layout using the id
        TextView englishTextView = listItemView.findViewById(R.id.english_text_view);

        //Get the word from the getter method and set the text to the current TextView
        englishTextView.setText(currentWord.getEnglishTranslation());

        //Find the ImageView in the list_word_item.xml layout using the id
        ImageView imageView = listItemView.findViewById(R.id.image_view);

        if (currentWord.hasImage()) {
            //Set the image to the current layout
            imageView.setImageResource(currentWord.getImageResourceID());
            //make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            //Hide the ImageView
            imageView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}






































