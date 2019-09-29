package com.example.chooselife;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TraitQuestionPage extends AppCompatActivity {
    Button aButton, bButton, cButton, dButton;
    TextView questionText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trait_question_page);

        //Initialize Buttons and Question Prompt
        aButton = (Button)findViewById(R.id.buttonA);
        bButton = (Button)findViewById(R.id.buttonB);
        cButton = (Button)findViewById(R.id.buttonC);
        dButton = (Button)findViewById(R.id.buttonD);
        questionText = (TextView) findViewById(R.id.textView);

    }

    public void aButton(View view){
    }
    public void bButton(View view){
    }
    public void cButton(View view){
    }
    public void dButton(View view){
    }

}
