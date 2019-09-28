package com.example.chooselife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class PlayGame extends AppCompatActivity {
    int stage_count = 1;
    class_Helper Helper = new class_Helper();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        //Initial Readme
        Intent starting_readme = new Intent(this, ReadMe.class);
        starting_readme.putExtra("Readme", Helper.get_ReadMe("start"));
        startActivity(starting_readme);



    }
}
