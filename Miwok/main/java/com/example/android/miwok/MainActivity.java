/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);
    }

    /**
     * This method opens up the Number Activity in the app
     * @param view
     */
    public void openNumberActivity(View view) {
        Intent numberActivityIntent = new Intent(this, NumbersActivity.class);
        startActivity(numberActivityIntent);
    }

    /**
     * This method opens up the Family Activity in the app
     * @param view
     */
    public void openFamilyActivity(View view) {
        Intent familyActivityIntent = new Intent(this, FamilyActivity.class);
        startActivity(familyActivityIntent);
    }

    /**
     * This method opens up the Phrases Activity in the app
     * @param view
     */
    public void openPhrasesActivity(View view) {
        Intent phrasesActivityIntent = new Intent(this, PhrasesActivity.class);
        startActivity(phrasesActivityIntent);
    }

    /**
     * This method opens up the Colors Activity in the app
     * @param view
     */
    public void openColorsActivity(View view) {
        Intent colorsActivityIntent = new Intent(this, ColorsActivity.class);
        startActivity(colorsActivityIntent);
    }

}
