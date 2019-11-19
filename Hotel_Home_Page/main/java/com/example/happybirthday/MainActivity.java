package com.example.happybirthday;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create the MediaPlayer class
        final MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.baby_elephant);

        //Obtain the status text view using id
        final TextView statusTextView = findViewById(R.id.status_text_view);

        // Obtain the play button view using id
        Button playButton = findViewById(R.id.play_button);

        // Set the functionality to play the music
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                statusTextView.setText(Arrays.toString(mediaPlayer.getTrackInfo()));
            }
        });

        //Obtain the pause button view using id
        Button pauseButton = findViewById(R.id.pause_button);

        //Set the functionality to pause the music
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
                statusTextView.setText(R.string.status_pause);
            }
        });

        //Obtain the reset button view using id
        Button resetButton = findViewById(R.id.reset_button);

        //Set the functionality to reset the music
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.reset();
                Toast.makeText(v.getContext(), "Reset audio successful", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
