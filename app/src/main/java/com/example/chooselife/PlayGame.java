package com.example.chooselife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class PlayGame extends AppCompatActivity {
    int stage_count = 1;
    class_Helper Helper = new class_Helper();
    class_GameStats Stats = new class_GameStats();
    class_TraitQuestion cur_trait_que = new class_TraitQuestion();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        //Initial Readme
        Intent starting_readme = new Intent(this, ReadMe.class);
        starting_readme.putExtra("Readme", Helper.get_ReadMe("start"));
        startActivity(starting_readme);

        play_game();

    }

    public void play_game(){
        // Get Stage 1 Question
        cur_trait_que = Helper.get_trait_question(1);
        Intent stage1 = new Intent(this, TraitQuestionPage.class);
        stage1.putExtra(cur_trait_que);
    }
}
