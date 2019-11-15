package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.lang.invoke.WrongMethodTypeException;
import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("red", "wetetti"));
        words.add(new Word("green", "chokokki"));
        words.add(new Word("brown", "takaakki"));
        words.add(new Word("gray", "topoppi"));
        words.add(new Word("black", "kululli"));
        words.add(new Word("white", "kelelli"));
        words.add(new Word("dusty yellow", "topiise"));
        words.add(new Word("mustard yellow", "chiwiite"));

        WordAdapter itemsAdapter = new WordAdapter(ColorsActivity.this, words);

        ListView listItemView = findViewById(R.id.root_list_view);
        listItemView.setAdapter(itemsAdapter);
    }
}
