package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
//import android.widget.LinearLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
//import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mOnCompletion = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //  Create a list of words
        final ArrayList<Word> words = new ArrayList<>();
        // add the english and corresponding miwok word in the list and the image.
        words.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));

        WordAdapter itemsAdapter = new WordAdapter(NumbersActivity.this, words, R.color.category_numbers);

        ListView listItemView = findViewById(R.id.root_list_view);

        listItemView.setAdapter(itemsAdapter);

        listItemView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the Word object at the current position
                Word currentWord = words.get(position);

                // release any stored memory resource to begin playing a song
                releaseMediaPlayer();

                // Create an instance of the MediaPlayer to initialize the current audio
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, currentWord.getAudioResourceID());

                // Start the song
                mMediaPlayer.start();

                // On audio Completion release the memory resource for other tasks to use
                mMediaPlayer.setOnCompletionListener(mOnCompletion);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

}
