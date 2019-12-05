package com.example.obhijaan;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class ContactAdapter extends ArrayAdapter<Contact> {


    public ContactAdapter(Activity context, ArrayList<Contact> contacts) {
        super(context, 0, contacts);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.contact_list_item, parent, false);
        }

        final Contact currentWord = getItem(position);
        assert currentWord != null;

//        //Set the background color of each item
//        LinearLayout relativeTextView = listItemView.findViewById(R.id.relative_details_view);
//        int color = ContextCompat.getColor(getContext(), mColorResourceId);
//        relativeTextView.setBackgroundColor(color);

        // Set the name of the helper
        TextView contactName = listItemView.findViewById(R.id.name_text_view_placeholder);
        contactName.setText(currentWord.getName());

        // Set the contact number of the helper
        TextView contactNumber = listItemView.findViewById(R.id.contact_text_view_placeholder);
        contactNumber.setText(currentWord.getNumber());

        //  Set the address of the helper
        TextView contactAddress = listItemView.findViewById(R.id.address_text_view_placeholder);
        contactAddress.setText(currentWord.getAddress());

        // Set image of the helper
        ImageView contactImage = listItemView.findViewById(R.id.linear_image_view);

        if(currentWord.hasImage()) {
            contactImage.setImageResource(currentWord.getImageResourceId());
            contactImage.setVisibility(View.VISIBLE);
        } else {
            contactImage.setVisibility(View.GONE);
        }

        return listItemView;
    }
}