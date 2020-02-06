package com.example.chooselife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.Set;

public class StatsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_page);

        ListView page = (ListView)findViewById(R.id.list_view);

        // Get Futures
        SharedPreferences shref = getApplicationContext().getSharedPreferences("gameData", MODE_PRIVATE);
        Set<String> future_set = shref.getStringSet("futures", null);

        // Get Starts
        int starts = shref.getInt("starts", 0);
        String start_str = "Futures Achieved: " + starts;

        // Adapter List
        ArrayList<String> printable = new ArrayList<>();
        printable.add(start_str);
        if (future_set != null) {
            for (String str : future_set)
                printable.add(str);
        }


        // Create List for Scroll
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, printable);
        page.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }
}
