package com.example.chooselife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TraitQuestionPage extends AppCompatActivity {
    Button aButton, bButton, cButton, dButton;
    TextView questionText;
    Intent returnIntent = new Intent();
    class_TraitQuestion cur_trait_que = new class_TraitQuestion();
    class_Helper Helper = new class_Helper();
    int stage = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trait_question_page);

        stage = getIntent().getIntExtra("stage", 0);
        cur_trait_que = Helper.get_trait_question(stage);
        //Initialize Buttons and Question Prompt
        aButton = (Button)findViewById(R.id.buttonA);
        bButton = (Button)findViewById(R.id.buttonB);
        cButton = (Button)findViewById(R.id.buttonC);
        dButton = (Button)findViewById(R.id.buttonD);
        questionText = (TextView) findViewById(R.id.textView);

        //Set texts for Questions and Answers
        aButton.setText(cur_trait_que.getOptA().getText());
        bButton.setText(cur_trait_que.getOptB().getText());
        cButton.setText(cur_trait_que.getOptC().getText());
        dButton.setText(cur_trait_que.getOptD().getText());
        questionText.setText(cur_trait_que.getQuestion());

    }

    public void aButton(View view) {
        String[] temp = {
            cur_trait_que.getOptA().getTrait(0).getTitle(),
            Integer.toString(cur_trait_que.getOptA().getTrait(0).getValue()),
            cur_trait_que.getOptA().getTrait(1).getTitle(),
            Integer.toString(cur_trait_que.getOptA().getTrait(1).getValue()),
        };
        returnIntent.putExtra("result", temp);
        setResult(stage, returnIntent);
        finish();
    }
    public void bButton(View view){
        String[] temp = {
                cur_trait_que.getOptA().getTrait(0).getTitle(),
                Integer.toString(cur_trait_que.getOptA().getTrait(0).getValue()),
                cur_trait_que.getOptA().getTrait(1).getTitle(),
                Integer.toString(cur_trait_que.getOptA().getTrait(1).getValue()),
        };
        returnIntent.putExtra("result", temp);
        setResult(stage, returnIntent);
        finish();
    }
    public void cButton(View view){
        String[] temp = {
                cur_trait_que.getOptA().getTrait(0).getTitle(),
                Integer.toString(cur_trait_que.getOptA().getTrait(0).getValue()),
                cur_trait_que.getOptA().getTrait(1).getTitle(),
                Integer.toString(cur_trait_que.getOptA().getTrait(1).getValue()),
        };
        returnIntent.putExtra("result", temp);
        setResult(stage, returnIntent);
        finish();
    }
    public void dButton(View view){
        String[] temp = {
                cur_trait_que.getOptA().getTrait(0).getTitle(),
                Integer.toString(cur_trait_que.getOptA().getTrait(0).getValue()),
                cur_trait_que.getOptA().getTrait(1).getTitle(),
                Integer.toString(cur_trait_que.getOptA().getTrait(1).getValue()),
        };
        returnIntent.putExtra("result", temp);
        setResult(stage, returnIntent);
        finish();
    }

}
