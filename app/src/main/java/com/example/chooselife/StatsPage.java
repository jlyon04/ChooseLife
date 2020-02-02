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
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_page);

        ListView page = (ListView)findViewById(R.id.list_view);

        // Get Shared Preferances
        SharedPreferences shref = getApplicationContext().getSharedPreferences("gameData", MODE_PRIVATE);
        Set<String> future_set = shref.getStringSet("futures", null);
        if (future_set == null){

        }
        int starts = shref.getInt("starts", 0);
        // Have never played - exit
        if (starts == 0) {
            str = "0";
        }
        else{
            str = Integer.toString(starts);
        }

        //Make Printable list
        //TODO: EXPAND TO INCLUDE OTHER STATS
        /*
        ArrayList<String> printable = new ArrayList<>();
        for (String str : future_set)
            printable.add(str);

         */
        ArrayList<String> printable = new ArrayList<>();
        printable.add(str);
        printable.add("test");




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
