package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<>();

        words.add(new Word(R.raw.phrase_where_are_you_going,"Where are you going?", "minto wuksus"));
        words.add(new Word(R.raw.phrase_what_is_your_name,"What is your name?", "tinne oyaase'ne"));
        words.add(new Word(R.raw.phrase_my_name_is,"My name is...", "oyaaset..."));
        words.add(new Word(R.raw.phrase_how_are_you_feeling,"How are you feeling?", "michekses?"));
        words.add(new Word(R.raw.phrase_im_feeling_good,"I'm feeling good.", "kuchi achit"));
        words.add(new Word(R.raw.phrase_are_you_coming,"Are you coming?", "eenes'aa?"));
        words.add(new Word(R.raw.phrase_yes_im_coming,"Yes, I'm coming", "hee' eenem"));
        words.add(new Word(R.raw.phrase_lets_go,"Let's go", "yoowutis"));
        words.add(new Word(R.raw.phrase_come_here,"Come here", "anni'nem"));

        WordAdapter itemsAdapter = new WordAdapter(PhrasesActivity.this, words, R.color.category_phrases);

        ListView listItemView = findViewById(R.id.root_list_view);
        listItemView.setAdapter(itemsAdapter);
    }
}
