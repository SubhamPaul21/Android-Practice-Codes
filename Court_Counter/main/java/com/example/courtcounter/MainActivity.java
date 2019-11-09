package com.example.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreOfTeam_A = 0;
    int scoreOfTeam_B = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     *  This method displays the score of the team A
     */
    private void displayScoreA(int number) {
        TextView scoreTeamA = findViewById(R.id.team_a_score);
        scoreTeamA.setText("" + number);
    }

    /**
     *  This method displays the score of the team B
     */
    private void displayScoreB(int number) {
        TextView scoreTeamB = findViewById(R.id.team_b_score);
        scoreTeamB.setText("" + number);
    }

    /**
     *  This method increments Team A's score by 3
     */
    public void plusThreePointsA(View view) {
        scoreOfTeam_A = scoreOfTeam_A + 3;
        displayScoreA(scoreOfTeam_A);
    }

    /**
     *  This method increments Team A's score by 2
     */
    public void plusTwoPointsA(View view) {
        scoreOfTeam_A = scoreOfTeam_A + 2;
        displayScoreA(scoreOfTeam_A);
    }

    /**
     *  This method increments Team A's score by 1
     */
    public void plusOnePointsA(View view) {
        scoreOfTeam_A = scoreOfTeam_A + 1;
        displayScoreA(scoreOfTeam_A);
    }

    /**
     *  This method increments Team B's score by 3
     */
    public void plusThreePointsB(View view) {
        scoreOfTeam_B = scoreOfTeam_B + 3;
        displayScoreB(scoreOfTeam_B);
    }

    /**
     *  This method increments Team B's score by 2
     */
    public void plusTwoPointsB(View view) {
        scoreOfTeam_B = scoreOfTeam_B + 2;
        displayScoreB(scoreOfTeam_B);
    }

    /**
     *  This method increments Team B's score by 1
     */
    public void plusOnePointsB(View view) {
        scoreOfTeam_B = scoreOfTeam_B + 1;
        displayScoreB(scoreOfTeam_B);
    }

    /**
     *  This method resets both teams score to Zero
     */
    public void resetAll(View view) {
        scoreOfTeam_A = 0;
        scoreOfTeam_B = 0;
        TextView scoreTeamA = findViewById(R.id.team_a_score);
        scoreTeamA.setText("" + scoreOfTeam_A);
        TextView scoreTeamB = findViewById(R.id.team_b_score);
        scoreTeamB.setText("" + scoreOfTeam_B);
    }

}
