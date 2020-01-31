package com.example.chooselife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayTrait extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_trait);

        // Get Intent
        ArrayList<String> values = getIntent().getStringArrayListExtra("trait_values");
        // Set Values
        TextView t1 = (TextView)findViewById(R.id.textViewInt);
        TextView t2 = (TextView)findViewById(R.id.textView9);
        TextView t3 = (TextView)findViewById(R.id.textView10);
        TextView t4 = (TextView)findViewById(R.id.textView6);
        TextView t5 = (TextView)findViewById(R.id.textView1);
        TextView t6 = (TextView)findViewById(R.id.textView11);
        TextView t7 = (TextView)findViewById(R.id.textView12);

        t1.setText(values.get(0));
        t2.setText(values.get(1));
        t3.setText(values.get(2));
        t4.setText(values.get(3));
        t5.setText(values.get(4));
        t6.setText(values.get(5));
        t7.setText(values.get(6));
    }

    public void continueButton(View view){
        finish();
    }
}
