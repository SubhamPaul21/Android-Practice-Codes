package com.example.obhijaan;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int CALL_PERMISSION_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Contact> contacts = new ArrayList<>();

        contacts.add(new Contact("Subham Paul", "8910414590", "Pradhan Nagar", R.drawable.boy));
        contacts.add(new Contact("Dolly Solanki", "7063435569", "Nalhati", R.drawable.boy));
        contacts.add(new Contact("Sumit Kumar Bera", "1234567890", "Shillong Area", R.drawable.boy));
        contacts.add(new Contact("Jayashish Choudhury", "0987654321", "Guahati Hills", R.drawable.boy));
        contacts.add(new Contact("Bikram Aditya Das", "1238524579", "Kolkata Area", R.drawable.boy));
        contacts.add(new Contact("Debmalya Acharjee", "0983497512", "Malda'r Don", R.drawable.boy));

        ContactAdapter itemsAdapter = new ContactAdapter(MainActivity.this, contacts);

        ListView listItemView = findViewById(R.id.root_list_view);
        listItemView.setAdapter(itemsAdapter);

        listItemView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact currentContact = contacts.get(position);

                //  Create the intent and set the data for the intent as the phone Number
                Intent intent = new Intent(Intent.ACTION_CALL);

                intent.setData(Uri.parse("tel:+91" + currentContact.getNumber()));

                checkPermission(Manifest.permission.CALL_PHONE, CALL_PERMISSION_CODE);

                startActivity(intent);
            }});
    }

    // Function to check and request permission.
    public void checkPermission(String permission, int requestCode) {
        if (ContextCompat.checkSelfPermission(MainActivity.this, permission) == PackageManager.PERMISSION_DENIED) {
            // requesting permission
            ActivityCompat.requestPermissions(MainActivity.this, new String[] {permission}, requestCode);
            Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
