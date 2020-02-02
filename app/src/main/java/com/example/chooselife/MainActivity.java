package com.example.chooselife;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void startGame(View view)
    {
        Intent game_intent = new Intent(this, PlayGame.class);
        startActivityForResult(game_intent, 1);
    }
    public void startStatsPage(View view)
    {
        Intent stats_page = new Intent(this, StatsPage.class);
        startActivity(stats_page);
    }
}
