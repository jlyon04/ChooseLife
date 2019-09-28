package com.example.chooselife;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ReadMe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_me);
        TextView readme_text = (TextView) findViewById(R.id.readMeTextView);
        // Get passed Text
        String text = getIntent().getStringExtra("Readme");
        readme_text.setText(text);
    }

    public void continueButton(View view){finish();
    }
}
